package com.power.service.ex.impl;

import com.power.conf.PermissionSqlConstant;
import com.power.dao.ex.IPermissionDAO;
import com.power.entity.PermissionEnum;
import com.power.service.ex.IDataPermissionService;
import io.renren.entity.SysUserEntity;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * Created by Administrator on 2017/9/6.
 */
@Service
public class DataPermissionServiceImpl implements IDataPermissionService {

    @Autowired
    IPermissionDAO permissionDAO;
    /**
     * ◆查询代理商的可视范围构建代理商树
     * ◆其中代理商分为：
     * ◆ 1.平台代理商，拥有全部权限
     * ◆ 2.独立代理商，拥有自己和下级(包括下级的下级)所有权限
     * ◆ 3.签约代理商，拥有自己和下级(不包括下级的下级)的所有查询权限
     *
     * @param agencyId 默认当前用户(无此参数时候为当前用户)
     * @return 反馈结果为用户的权限池
     */
    @Override
    public String selectAgencyTree(Long agencyId) {
        return null;
    }

    @Override
    public String selectAgencyTree() {
        return getSysUserEntity().getAgencyPool();
    }

    /**
     * <pre>
     * ◆检测当前用户是不是有添加的权限
     * ◆主要场景用于添加修改删除功能 防止有用户通过id直接删除非当前用户的数据
     * ◆检测用户：按照表格组成不同的权限检测方案
     * ◆ 大致分为：
     * ◆     1.平台代理商所有权限
     * ◆     2.签约代理商所有权限
     * ◆     3.独立代理商所有权限
     * ◆  按照表格会划分不同的权限
     * ◆     1.设备表(桩表/充电宝表) 当前用户只能看到自己的设备（租赁/拥有）
     * ◆     2.代理商表/网点表 主要划分为：
     * ◆                 独立代理商可以看到自己和自己的下级，包括下级的所有桩和下级的下级
     * ◆                 签约代理商可以看到自己和自己的下级，但是看不到下级的所有桩和下级的下级（区分于独立代理商）
     * ◆                 平台代理商可以查看到所有的代理商，拥有最大权限
     * ◆     3.订单表：  主要划分为：
     * ◆                 宇能平台，可以看到所有的订单
     * ◆                 代理商，可以看到自己参与分成的订单(参与分成的订单指，自己的直属下级，自己充电桩/充电宝产生的订单，自己的二维码分享用户的充值的会员)
     * ◆                     由于订单较多，会导致查询变慢，最好的做法为，在订单生成时生成利益分成关系，查询的时候直接查询即可
     * ◆
     * </pre>
     *
     * @return
     */
    @Override
    public boolean hasPermission() {
        Long agencyId = getSysUserEntity().getAgencyId();
        String agencyPool = getSysUserEntity().getAgencyPool();
        String[] strings = StringUtils.split(agencyPool,",");
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].equals(agencyId)) return true;
        }
        return false;
    }

    /**
     * <pre>
     *     ◆生成数据权限WhereSql，在数据权限表格中获取对应表的权限sql，根据当前用户组装出最终sql，sql的查询结果一定是一个当前需求表格的id-List
     *     ◆按照表格划分可以划分为：
     *     ◆ 1.设备表：需要查询当前用户的租赁桩/宝和拥有桩/宝
     *     ◆ 2.网点表：
     *     ◆     1) 独立代理商 可以看到自己和所有自己下属的桩
     *     ◆         示例: 预定义数据格式为：A一级代理商-B二级代理商-C三级代理商 代理商权限字段为: A-A,B-A,B,C
     *     ◆             查询sql为 select id as ids from table where FIND_IN_SET(currAgencyId,column)
     *     ◆     2) 签约代理商 可以看到自己的桩
     *     ◆         示例: 预定义数据格式为：A一级代理商-B二级代理商-C三级代理商 代理商权限字段为: A-A,B-B,C
     *     ◆             查询sql为 select id as ids from table where FIND_IN_SET(currAgencyId,column)
     *     ◆ 3.代理商表：
     *     ◆     1) 独立代理商 可以看到自己和所有自己下属的代理商
     *     ◆         示例: 预定义数据格式为：A一级代理商-B二级代理商-C三级代理商 代理商权限字段为: A-A,B-A,B,C
     *     ◆             查询sql为 select id as ids from table where FIND_IN_SET(currAgencyId,column)
     *     ◆
     *     ◆     2) 签约代理商 可以看到自己的下属的代理商
     *     ◆         示例: 预定义数据格式 为：A一级代理商-B二级代理商-C三级代理商 代理商权限字段为: A-A,B-B,C
     *     ◆             查询sql为 select id as ids from table where FIND_IN_SET(currAgencyId,column)
     *     ◆ 4.订单表：
     *     ◆     订单在生成时候会产生一列数据，决定了当前订单的分成去向，根据这一列来划分数据权限
     *     ◆         示例： 预定义数据格式为: 1,2,3,4 格式形式为:代理商ID1,代理商ID2,代理商ID3,代理商ID4
     *     ◆         则 查询条件为 select id as ids from table where FIND_IN_SET(currAgencyId,column)
     * </pre>
     *
     * @param permissionEnum
     * @return
     */
    @Override
    public String genWhereSql(PermissionEnum permissionEnum) {
        /**
         *  1.获取当前用户的权限池
         *  2.获取系统预定义sql模板
         *  3.生成实际sql并反馈
         */
        StringBuilder builder =null;
        String agencyPool = selectAgencyTree();
        switch (permissionEnum){
            case ORDER:
//                订单在生成时候会产生一列数据，决定了当前订单的分成去向，根据这一列来划分数据权限
//                    示例： 预定义数据格式为: 1,2,3,4 格式形式为:代理商ID1,代理商ID2,代理商ID3,代理商ID4
//                    则 查询条件为 select id as ids from table where FIND_IN_SET(currAgencyId,column)
                return String.format(PermissionSqlConstant.SPILE_SQL,getCurrAgencyId());
            case SPILE:
                return String.format(PermissionSqlConstant.SPILE_SQL,agencyPool);
            case BANK:
                return String.format(PermissionSqlConstant.BANK_SQL,agencyPool);
            case AGENCY_INDEPENDENT:
                builder = new StringBuilder(PermissionSqlConstant.AGENCY_SQL).append(" ").append("where");
                int count = 0;
                for (String agency:agencyPool.split(",")){
                    builder.append(String.format(" FIND_IN_SET(%s,ag.agency_pool) ",agency)).append("and");
                    count++;
                }
                if (count>0) {
                    builder.delete(builder.length() - "and".length(), builder.length());
                }
                return builder.toString();
            case AGENCY_SIGN:
                builder = new StringBuilder(PermissionSqlConstant.AGENCY_SQL).append(" ").append("where");
                builder.append(String.format(" FIND_IN_SET(%s,ag.agency_pool) ",getSysUserEntity().getAgencyId()));
                return builder.toString();
            case BRANCH:
                return String.format(PermissionSqlConstant.BRANCH_SQL,agencyPool);
        }
        return null;
    }

    /**
     * <pre>
     * ◆生成某个用户的权限树
     * ◆主要分为多种情况：
     * ◆ 1.父类是独立代理商
     * ◆     在这种情况下，查询父类的权限池，在父类的权限池基础上加上自己的权限池即可，长度无上限
     * ◆     示例：A的权限池是 ： 1,2   B是A的子代理商，B的agencyId为3 则B的权限池为: 1,2,3
     * ◆     其中1为宇能平台的代理商ID
     * ◆ 2.父类是签约代理商
     * ◆     在这种情况下，查询父类代理商ID，在父类的代理商ID基础上加上自己的AgencyId再加上宇能平台ID  最多出现数据量为3
     * ◆     示例：A的权限池是 ： 1,2   B是A的子代理商，B的agencyId为3 则B的权限池为: 1,2,3
     * ◆           C是B的子代,C的agencyId为4 则C的权限池为:1,3,4
     * ◆     其中1为宇能平台的代理商ID
     * ◆ 3.父类是平台用户(子运营账号)
     * ◆     对于平台用户 直接继承父类权限池即可
     * ◆ 4.对于审核代理商转义到独家代理商来说
     * ◆        第一次生成的权限属于宇能1，当转移到独家代理(id-2)的时候，数据权限被变更为1,2,则 在独家代理平台可以看到
     * ◆        当审核通过时通过重新赋予该用户数据权限
     * </pre>
     *
     * @param agencyId      代理商ID
     * @param superAgencyId 父类的带螺丝阿红ID
     * @return
     */
    @Override
    public String genPermissionBySign(Long agencyId, Long superAgencyId) {
        return new StringBuilder("1").append(",").append(superAgencyId).append(",").append(agencyId).toString();
    }

    /**
     * 独家代理商权限生成
     *
     * @param agencyId            代理商ID
     * @param superPermissionPool 父类权限池
     * @return
     */
    @Override
    public String genPermissionByIndependent(Long agencyId, String superPermissionPool) {
        return new StringBuilder().append(superPermissionPool).append(",").append(agencyId).toString();
    }

    private Long getCurrAgencyId() {
        return getSysUserEntity().getAgencyId();
    }
    protected SysUserEntity getSysUserEntity() {
        Subject subject = SecurityUtils.getSubject();
        SysUserEntity userEntity = (SysUserEntity)subject.getPrincipal();
        return userEntity;
    }
}
