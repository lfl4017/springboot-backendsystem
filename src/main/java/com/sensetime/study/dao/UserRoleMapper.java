package com.sensetime.study.dao;

import java.util.List;

import com.sensetime.study.core.universal.Mapper;
import com.sensetime.study.model.UserRole;

public interface UserRoleMapper extends Mapper<UserRole> {
	
	List<String> getRolesByUserId(String userId);
}