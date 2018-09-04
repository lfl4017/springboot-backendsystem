package com.sensetime.study.dao;

import java.util.List;

import com.sensetime.study.core.universal.Mapper;
import com.sensetime.study.model.SysPermissionInit;

public interface SysPermissionInitMapper extends Mapper<SysPermissionInit> {
	List<SysPermissionInit> selectAllOrderBySort();
}