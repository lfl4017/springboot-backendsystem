package com.sensetime.study.service.impl;

import com.sensetime.study.dao.SysPermissionInitMapper;
import com.sensetime.study.model.SysPermissionInit;
import com.sensetime.study.service.SysPermissionInitService;
import com.sensetime.study.core.universal.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.annotation.Resource;

/**
* @Description: SysPermissionInitService接口实现类
* @author lfl4017
* @date 2018/08/02 16:07
*/
@Service
public class SysPermissionInitServiceImpl extends AbstractService<SysPermissionInit> implements SysPermissionInitService {

    @Resource
    private SysPermissionInitMapper sysPermissionInitMapper;

	@Override
	public List<SysPermissionInit> selectAllOrderBySort() {
		return sysPermissionInitMapper.selectAllOrderBySort();
	}

}