package com.sensetime.study.service.impl;

import com.sensetime.study.dao.SysPermMapper;
import com.sensetime.study.model.SysPerm;
import com.sensetime.study.service.SysPermService;
import com.sensetime.study.core.universal.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
* @Description: SysPermService接口实现类
* @author lfl4017
* @date 2018/08/02 14:44
*/
@Service
public class SysPermServiceImpl extends AbstractService<SysPerm> implements SysPermService {

    @Resource
    private SysPermMapper sysPermMapper;

}