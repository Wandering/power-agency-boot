package com.power.controller;

import java.util.List;
import java.util.Map;

import com.power.entity.PermissionEnum;
import com.power.service.ex.IAgenciesExService;
import com.power.service.ex.IDataPermissionService;
import io.renren.entity.SysUserEntity;
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
import io.renren.entity.SysUserEntity;
import io.renren.service.SysUserService;
import io.renren.utils.PageUtils;
import io.renren.utils.Query;
import io.renren.utils.R;


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
	private IAgenciesExService agenciesExService;
	@Autowired
	private IDataPermissionService dataPermissionService;

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
		agencies.setAbbrCode(user.getUserId().toString());
		agencies.setStatus("1");
		agenciesService.save(agencies);
		user.setAgencyId(agencies.getId());
		user.setParentId(agencies.getParent());
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
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("agencies:delete")
	public R delete(@RequestBody Long[] ids){
		agenciesService.deleteBatch(ids);
		
		return R.ok();
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
