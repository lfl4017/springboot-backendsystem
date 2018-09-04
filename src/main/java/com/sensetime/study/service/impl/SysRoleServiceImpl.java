package com.sensetime.study.service.impl;

import com.sensetime.study.dao.SysRoleMapper;
import com.sensetime.study.model.SysRole;
import com.sensetime.study.service.SysRoleService;
import com.sensetime.study.core.universal.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
* @Description: SysRoleService接口实现类
* @author lfl4017
* @date 2018/08/02 14:44
*/
@Service
public class SysRoleServiceImpl extends AbstractService<SysRole> implements SysRoleService {

    @Resource
    private SysRoleMapper sysRoleMapper;

}