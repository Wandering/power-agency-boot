package com.power.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.power.entity.PermissionEnum;
import com.power.service.ex.IAgenciesExService;
import com.power.service.ex.IDataPermissionService;
import com.power.yuneng.user.IQrCodeService;
import io.renren.entity.SysUserEntity;
import io.renren.entity.UserEntity;
import io.renren.utils.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.power.entity.AgenciesEntity;
import com.power.service.AgenciesService;

import io.renren.admin.AbstractController;
import io.renren.service.SysUserRoleService;
import io.renren.service.SysUserService;


/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-21 23:02:38
 */
@RestController
@RequestMapping("agencies")
public class AgenciesController extends AbstractController{
	@Autowired
	private AgenciesService agenciesService;
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private SysUserRoleService sysUserRoleService;
	@Autowired
	private IAgenciesExService agenciesExService;
	@Autowired
	private IDataPermissionService dataPermissionService;
	@Autowired
	private IQrCodeService qrCodeService;

	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("agencies:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		Subject subject = SecurityUtils.getSubject();
		SysUserEntity userEntity = (SysUserEntity)subject.getPrincipal();
		query.put("whereSql",userEntity.getAgencytype()!=null && userEntity.getAgencytype() == 1 ?dataPermissionService.genWhereSql(PermissionEnum.AGENCY_SIGN) : dataPermissionService.genWhereSql(PermissionEnum.AGENCY_INDEPENDENT));
		List<AgenciesEntity> agenciesList = agenciesService.queryList(query);
		int total = agenciesService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(agenciesList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("agencies:info")
	public R info(@PathVariable("id") Long id){
		AgenciesEntity agencies = agenciesService.queryObject(id);
		
		return R.ok().put("agencies", agencies);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody AgenciesEntity agencies){
		SysUserEntity user = getUser();
		agencies.setAbbrCode(user.getUserId());
		agencies.setStatus("1");
		agencies.setAgencyPool("1");
		agenciesService.save(agencies);
		user.setAgencyId(agencies.getId());
		user.setParentId(agencies.getParent());
		//设置空角色列表
		List<Long> roleIdList = new ArrayList<Long>();
		user.setRoleIdList(roleIdList);
		sysUserService.update(user);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("agencies:update")
	public R update(@RequestBody AgenciesEntity agencies){
		agenciesService.update(agencies);
		return R.ok();
	}
	
	/**
     * 审核
	 */
	@RequestMapping("/examine")
	@RequiresPermissions("agencies:examine")
	public R examine(@RequestBody AgenciesEntity agencies){
		String status = agencies.getStatus();
		int agencyType = agencies.getAgencytype();
//				0：独家代理(宇能默认为独家代理)
//				1：签约代理

		//通过审核或店主
		if(status.equals("2")){
			System.out.println("通过审核");
			AgenciesEntity parentEntity = agenciesService.queryObject(agencies.getParent());
			agencies.setAgencyPool(agencyType == 1 ? dataPermissionService.genPermissionByIndependent(agencies.getId(),parentEntity.getAgencyPool()): dataPermissionService.genPermissionBySign(agencies.getId(),agencies.getParent()));
			qrCodeService.qrCodeCreateByAgency(agencies.getId(),"ppower");
		//未通过审核或店主
		}else if(status.equals("3")){
			System.out.println("未通过审核");
		//转移给代理商
		}else if(status.equals("4")){
			System.out.println("转移");
			AgenciesEntity parentEntity = agenciesService.queryObject(agencies.getParent());
			agencies.setAgencyPool(dataPermissionService.genPermissionByIndependent(agencies.getId(),parentEntity.getAgencyPool()));
		}
		agenciesService.update(agencies);
		return R.ok();
	}
	
	/**
	 * 激活
	 */
	@RequestMapping("/activate")
	@RequiresPermissions("agencies:activate")
	public R activate(@RequestBody AgenciesEntity agencies){
		String status = agencies.getStatus();
		//禁用的代理商或店主
		if(status.equals("0")){
			agencies.setStatus("2");
		//未通过审核的代理商或店主
		}else if(status.equals("3")){
			agencies.setStatus("1");
		}else{
			return R.error("请求错误！");
		}
		agenciesService.update(agencies);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("agencies:delete")
	public R delete(@RequestBody Long[] ids){
		agenciesService.deleteBatch(ids);
		
		return R.ok();
	}
	
	/**
     * 检索代理商状态
	 */
	@RequestMapping("/checkStatus")
	public R queryAgencyStatus(){
		Long userId = getUserId();
		if(userId == Constant.SUPER_ADMIN){
			return R.error("当前为超级管理员！");
		}
		AgenciesEntity agency = agenciesService.queryAgencybyUserId(userId);
		if(agency!=null){
			String status = agency.getStatus();
			if(status.equals("1")){
				//待审核
				return R.ok().put("status", status);
			}else if(status.equals("3")){
				//未通过
				return R.ok().put("status", status);
			}else{
				return R.error("该用户已经注册成为代理商或店主");
			}
		}else{
			AgenciesEntity parent = agenciesService.queryAgencybyUserId(getUser().getParentId());
			if(parent!=null){
				return R.error("该用户为运营商创建的帐号！");
			}
			return R.ok().put("status", "0");
		}
	}
	

	/**
     * 查询代理商
	 */
	@RequestMapping("/search")
	public R search(String key){
		Subject subject = SecurityUtils.getSubject();
		SysUserEntity userEntity = (SysUserEntity)subject.getPrincipal();
		return R.ok().put("data",userEntity.getAgencytype()!=null && userEntity.getAgencytype() == 1 ?dataPermissionService.genWhereSql(PermissionEnum.AGENCY_SIGN) : dataPermissionService.genWhereSql(PermissionEnum.AGENCY_INDEPENDENT));
	}

	/**
     * 查询所有账号
	 * @param key
	 * @return
	 */
	@RequestMapping("/searchAccount")
	public R searchAccount(String key){
		Subject subject = SecurityUtils.getSubject();
		SysUserEntity userEntity = (SysUserEntity)subject.getPrincipal();
		return R.ok().put("data",userEntity.getAgencytype()!=null && userEntity.getAgencytype() == 1 ?dataPermissionService.genWhereSql(PermissionEnum.AGENCY_SIGN) : dataPermissionService.genWhereSql(PermissionEnum.AGENCY_INDEPENDENT));
	}

    /**
     * 查询所有的代理商账号
     * @param key
     * @return
     */
    @RequestMapping("/all/searchAccount")
    public R searchAllAccount(String key){
        return R.ok().put("data",agenciesExService.searchAccount(key,null));
    }

}
