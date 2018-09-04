package com.sensetime.study.dao;

import java.util.List;

import com.sensetime.study.core.universal.Mapper;
import com.sensetime.study.model.SystemLog;

public interface SystemLogMapper extends Mapper<SystemLog> {

	void insertValue(SystemLog systemLog);
	
	Integer insertByBatch(List<SystemLog> list);
}