package com.sensetime.study.service;

import com.sensetime.study.model.SysPermissionInit;

import java.util.List;

import com.sensetime.study.core.universal.Service;

/**
* @Description: SysPermissionInitService接口
* @author lfl4017
* @date 2018/08/02 16:07
*/
public interface SysPermissionInitService extends Service<SysPermissionInit> {

	List<SysPermissionInit> selectAllOrderBySort();

}