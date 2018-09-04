package com.sensetime.study.service.impl;

import com.sensetime.study.dao.UserInfoMapper;
import com.sensetime.study.model.UserInfo;
import com.sensetime.study.service.UserInfoService;
import com.sensetime.study.core.universal.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
* @Description: UserInfoService接口实现类
* @author lfl4017
* @date 2018/07/30 19:33
*/
@Service
public class UserInfoServiceImpl extends AbstractService<UserInfo> implements UserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;

}