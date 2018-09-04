package com.sensetime.study.dao;

import java.util.List;

import com.sensetime.study.core.universal.Mapper;
import com.sensetime.study.model.RolePerm;

public interface RolePermMapper extends Mapper<RolePerm> {
	List<String> getPermsByUserId(String userId);
}