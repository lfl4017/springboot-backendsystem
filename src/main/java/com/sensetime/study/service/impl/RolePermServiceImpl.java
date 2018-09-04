package com.sensetime.study.service.impl;

import com.sensetime.study.dao.RolePermMapper;
import com.sensetime.study.model.RolePerm;
import com.sensetime.study.service.RolePermService;
import com.sensetime.study.core.universal.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.annotation.Resource;

/**
* @Description: RolePermService接口实现类
* @author lfl4017
* @date 2018/08/02 14:44
*/
@Service
public class RolePermServiceImpl extends AbstractService<RolePerm> implements RolePermService {

    @Resource
    private RolePermMapper rolePermMapper;

	@Override
	public List<String> getPermsByUserId(String id) {
		return rolePermMapper.getPermsByUserId(id);
	}

}