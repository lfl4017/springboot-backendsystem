package com.sensetime.study.controller;

import com.sensetime.study.core.ret.RetResult;
import com.sensetime.study.core.ret.ServiceException;
import com.sensetime.study.core.aop.AnnotationLog;
import com.sensetime.study.core.ret.RetResponse;
import com.sensetime.study.core.utils.ApplicationUtils;
import com.sensetime.study.model.UserInfo;
import com.sensetime.study.service.UserInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: UserInfoController类
 * @author lfl4017
 * @date 2018/07/30 19:33
 */
@RestController
@RequestMapping("/userInfo")
public class UserInfoController {

	@Resource
	private UserInfoService userInfoService;

	@PostMapping("/login")
	public RetResult<UserInfo> login(String userName, String password) {
		Subject currentUser = SecurityUtils.getSubject();
		// 登录
		try {
			currentUser.login(new UsernamePasswordToken(userName, password));
		} catch (IncorrectCredentialsException i) {
			throw new ServiceException("密码输入错误");
		}
		// 从session取出用户信息
		UserInfo user = (UserInfo) currentUser.getPrincipal();
		return RetResponse.makeOKRsp(user);
	}

	@PostMapping("/insert")
	public RetResult<Integer> insert(UserInfo userInfo) throws Exception {
		userInfo.setId(ApplicationUtils.getUUID());
		Integer state = userInfoService.insert(userInfo);
		return RetResponse.makeOKRsp(state);
	}

	@PostMapping("/deleteById")
	public RetResult<Integer> deleteById(@RequestParam String id) throws Exception {
		Integer state = userInfoService.deleteById(id);
		return RetResponse.makeOKRsp(state);
	}

	@PostMapping("/update")
	public RetResult<Integer> update(UserInfo userInfo) throws Exception {
		Integer state = userInfoService.update(userInfo);
		return RetResponse.makeOKRsp(state);
	}

	@PostMapping("/selectById")
	@AnnotationLog(remark = "查询")
	public RetResult<UserInfo> selectById(@RequestParam String id) throws Exception {
		UserInfo userInfo = userInfoService.selectById(id);
		return RetResponse.makeOKRsp(userInfo);
	}

	/**
	 * @Description: 分页查询
	 * @param page
	 *            页码
	 * @param size
	 *            每页条数
	 * @Reutrn RetResult<PageInfo<UserInfo>>
	 */
	@PostMapping("/list")
	public RetResult<PageInfo<UserInfo>> list(@RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "0") Integer size) throws Exception {
		PageHelper.startPage(page, size);
		List<UserInfo> list = userInfoService.selectAll();
		PageInfo<UserInfo> pageInfo = new PageInfo<UserInfo>(list);
		return RetResponse.makeOKRsp(pageInfo);
	}
}