package com.sensetime.study.service.impl;

import com.sensetime.study.dao.SystemLogMapper;
import com.sensetime.study.model.SystemLog;
import com.sensetime.study.service.SystemLogService;
import com.sensetime.study.core.universal.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.annotation.Resource;

/**
 * @Description: SystemLogService接口实现类
 * @author lfl4017
 * @date 2018/08/03 11:27
 */
@Service
public class SystemLogServiceImpl extends AbstractService<SystemLog> implements SystemLogService {

	@Resource
	private SystemLogMapper systemLogMapper;

	/* （非 Javadoc）
	 * @see com.sensetime.study.service.SystemLogService#insertValue(com.sensetime.study.model.SystemLog)
	 */
	@Override
	public void insertValue(SystemLog systemLog) {
		systemLogMapper.insertValue(systemLog);
	}

	/* （非 Javadoc）
	 * @see com.sensetime.study.service.SystemLogService#insertByBatch(java.util.List)
	 */
	@Override
	public Integer insertByBatch(List<SystemLog> list) {
		return systemLogMapper.insertByBatch(list);
	}

}