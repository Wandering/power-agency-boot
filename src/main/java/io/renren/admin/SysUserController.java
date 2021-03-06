package io.renren.admin;

import io.renren.utils.annotation.SysLog;
import io.renren.entity.SysLogEntity;
import io.renren.entity.SysUserEntity;
import io.renren.service.SysLogService;
import io.renren.service.SysUserRoleService;
import io.renren.service.SysUserService;
import io.renren.utils.*;
import io.renren.utils.validator.group.AddGroup;
import io.renren.utils.validator.group.UpdateGroup;
import io.renren.utils.validator.Assert;
import io.renren.utils.validator.ValidatorUtils;

import org.apache.commons.lang.ArrayUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.power.entity.AgenciesEntity;
import com.power.service.AgenciesService;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 系统用户
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年10月31日 上午10:40:10
 */
@RestController
@RequestMapping("/sys/user")
public class SysUserController extends AbstractController {
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private SysUserRoleService sysUserRoleService;
	@Autowired
	private AgenciesService agenciesService;
	@Autowired
	private SysLogService sysLogService;
	
	/**
	 * 所有用户列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sys:user:list")
	public R list(@RequestParam Map<String, Object> params){
		//只有超级管理员，才能查看所有管理员列表
		if(getUserId() != Constant.SUPER_ADMIN){
			params.put("createUserId", getUserId());
		}
		
		//查询列表数据
		Query query = new Query(params);
		List<SysUserEntity> userList = sysUserService.queryList(query);
		int total = sysUserService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(userList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	/**
	 * 获取登录的用户信息
	 */
	@RequestMapping("/info")
	public R info(){
		
		return R.ok().put("user", getUser());
	}
	
	/**
	 * 修改登录用户密码
	 */
	@SysLog("修改密码")
	@RequestMapping("/password")
	public R password(String password, String newPassword){
		Assert.isBlank(newPassword, "新密码不为能空");
		
		//sha256加密
		password = new Sha256Hash(password).toHex();
		//sha256加密
		newPassword = new Sha256Hash(newPassword).toHex();
				
		//更新密码
		int count = sysUserService.updatePassword(getUserId(), password, newPassword);
		if(count == 0){
			return R.error("原密码不正确");
		}
		
		//退出
		ShiroUtils.logout();
		
		return R.ok();
	}
	
	/**
	 * 修改登录用户密码
	 */
	@RequestMapping("/resetPassword")
	public R resetPassword(String userName,String password){
		
		//sha256加密
		password = new Sha256Hash(password).toHex();
				
		//更新密码
		int count = sysUserService.resetPassword(userName, password);
		if(count == 0){
			return R.error("用户名不正确");
		}else{
		
		//退出
		
		return R.ok();
		}
	}
	
	/**
	 * 用户信息
	 */
	@RequestMapping("/info/{userId}")
	@RequiresPermissions("sys:user:info")
	public R info(@PathVariable("userId") Long userId){
		SysUserEntity user = sysUserService.queryObject(userId);
		
		//获取用户对应的代理商信息
		AgenciesEntity agency =  agenciesService.queryObject(user.getAgencyId());
		user.setAgency(agency);
		//获取用户所属的角色列表
		List<Long> roleIdList = sysUserRoleService.queryRoleIdList(userId);
		user.setRoleIdList(roleIdList);
		
		return R.ok().put("user", user);
	}
	
	/**
	 * 保存用户
	 */
	@SysLog("保存用户")
	@RequestMapping("/save")
	@RequiresPermissions("sys:user:save")
	public R save(@RequestBody SysUserEntity user){
		ValidatorUtils.validateEntity(user, AddGroup.class);
		//获取登录用户的信息
		SysUserEntity userEntity = getUser();
		//判断是否代理商
//		AgenciesEntity agency = user.getAgency();
//		if(user.getType().equals(1)){
//			agenciesService.save(agency);
//			user.setAgencyId(agency.getId());
//		}else{
//			user.setAgencyId(userEntity.getAgencyId());
//		}
		String password = userEntity.getPassword();
		if(password.equals(new Sha256Hash(user.getLoginPassword()).toHex())){
		user.setCreateUserId(userEntity.getUserId());
		user.setParentId(userEntity.getAgencyId());
		sysUserService.save(user);
		
		return R.ok();
		}else{
		return R.error("你输入的登录密码不正确");	
		}
	}
	
	/**
	 * 注册用户
	 */
	@SysLog("注册用户")
	@RequestMapping("/register")
	public R register(@RequestBody SysUserEntity user){
		user.setPassword(new Sha256Hash(user.getPassword()).toHex());
		user.setCreateTime(new Date());
		user.setStatus(1);
		sysUserService.register(user);
		//注册成功后 直接登录
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
		ShiroUtils.getSubject().login(token);
		return R.ok();
	}
	
	/**
	 * 修改用户
	 */
	@SysLog("修改用户")
	@RequestMapping("/update")
	@RequiresPermissions("sys:user:update")
	public R update(@RequestBody SysUserEntity user){
		ValidatorUtils.validateEntity(user, UpdateGroup.class);
		//获取登录用户的信息
		SysUserEntity userEntity = getUser();
		String password = userEntity.getPassword();
		if(password.equals(new Sha256Hash(user.getLoginPassword()).toHex())){
			
		
		//判断是否代理商
		//AgenciesEntity agency = user.getAgency();
//		if(user.getType().equals(1)){
//			agenciesService.update(agency);
//		}else{}
		user.setCreateUserId(userEntity.getUserId());
		sysUserService.update(user);
		
		return R.ok();
		}else{
			return R.error("你输入的登录密码不正确");
		}
	}
	/**
	 * 修改用户
	 */
	@RequestMapping("/updateUserInfo")
	public R updateUserInfo(@RequestBody SysUserEntity user){
		ValidatorUtils.validateEntity(user, UpdateGroup.class);
		sysUserService.updateUserInfo(user);
		return R.ok();
	}
	
	/**
	 * 删除用户
	 */
	@SysLog("删除用户")
	@RequestMapping("/delete")
	@RequiresPermissions("sys:user:delete")
	public R delete(@RequestBody Long[] userIds){
		if(ArrayUtils.contains(userIds, 1L)){
			return R.error("系统管理员不能删除");
		}
		
		if(ArrayUtils.contains(userIds, getUserId())){
			return R.error("当前用户不能删除");
		}
		
		sysUserService.deleteBatch(userIds);
		
		return R.ok();
	}
	
	
	/**
	 * 验证用户名
	 */
	@RequestMapping("/checkUsername")
	public R checkUsername(String userName){
		int count = sysUserService.checkUsername(userName);
		logger.debug("用户是否存在",count);
		if(count>0){
			return R.error("当前用户已存在");
		}else{
		return R.ok();
		}
	}
	
	/**
	 * 校验用户密码
	 */
	@RequestMapping("/checkPwd")
	public R checkPassword(String password){
		
		//sha256加密
		password = new Sha256Hash(password).toHex();
		//sha256加密
				
		//更新密码
		int count = sysUserService.updatePassword(getUserId(), password, password);
		if(count == 0){
			return R.error("密码不正确,请重新输入！");
		}
		
		return R.ok();
	}
}

