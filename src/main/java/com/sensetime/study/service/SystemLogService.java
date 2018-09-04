package com.sensetime.study.service;

import com.sensetime.study.model.SystemLog;

import java.util.List;

import com.sensetime.study.core.universal.Service;

/**
* @Description: SystemLogService接口
* @author lfl4017
* @date 2018/08/03 11:27
*/
public interface SystemLogService extends Service<SystemLog> {

	/**
	 *【insertValue】{插入一条日志记录}
	 * @author     liufulu_vendor
	 * @since      2018年8月3日 下午2:21:56
	 * @param systemLog
	 * @exception  {说明在某情况下,将发生什么异常}
	*/
	    
	void insertValue(SystemLog systemLog);

	/**
	 *【insertByBatch】{批量插入日志记录}
	 * @author     liufulu_vendor
	 * @since      2018年8月3日 下午2:26:22
	 * @param list
	 * @return
	 * @exception  {说明在某情况下,将发生什么异常}
	*/
	    
	public Integer insertByBatch(List<SystemLog> list);

}