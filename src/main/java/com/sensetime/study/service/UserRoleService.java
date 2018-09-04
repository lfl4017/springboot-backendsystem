package com.sensetime.study.service;

import com.sensetime.study.model.UserRole;

import java.util.List;

import com.sensetime.study.core.universal.Service;

/**
* @Description: UserRoleService接口
* @author lfl4017
* @date 2018/08/02 14:44
*/
public interface UserRoleService extends Service<UserRole> {

	List<String> getRolesByUserId(String id);

}