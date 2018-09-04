package com.sensetime.study.service;

import com.sensetime.study.model.RolePerm;

import java.util.List;

import com.sensetime.study.core.universal.Service;

/**
* @Description: RolePermService接口
* @author lfl4017
* @date 2018/08/02 14:44
*/
public interface RolePermService extends Service<RolePerm> {

	List<String> getPermsByUserId(String id);

}