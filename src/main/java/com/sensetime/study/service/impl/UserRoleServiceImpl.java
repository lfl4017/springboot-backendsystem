package com.sensetime.study.service.impl;

import com.sensetime.study.dao.UserRoleMapper;
import com.sensetime.study.model.UserRole;
import com.sensetime.study.service.UserRoleService;
import com.sensetime.study.core.universal.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.annotation.Resource;

/**
* @Description: UserRoleService接口实现类
* @author lfl4017
* @date 2018/08/02 14:44
*/
@Service
public class UserRoleServiceImpl extends AbstractService<UserRole> implements UserRoleService {

    @Resource
    private UserRoleMapper userRoleMapper;

	@Override
	public List<String> getRolesByUserId(String id) {
		return userRoleMapper.getRolesByUserId(id);
	}

}