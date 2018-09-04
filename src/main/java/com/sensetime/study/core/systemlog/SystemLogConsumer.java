package com.sensetime.study.core.systemlog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sensetime.study.model.SystemLog;
import com.sensetime.study.service.SystemLogService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class SystemLogConsumer implements Runnable {

	private static Logger logger = LoggerFactory.getLogger(SystemLogConsumer.class);

	public static final int DEFAULT_BATCH_SIZE = 64;

	private SystemLogQueue auditLogQueue;

	private SystemLogService systemLogService;

	private int batchSize = DEFAULT_BATCH_SIZE;

	private boolean active = true;

	private Thread thread;

	@PostConstruct
	public void init() {
		thread = new Thread(this);
		// 它的作用是启动一个新线程，新线程会执行相应的run()方法。start()不能被重复调用。
		thread.start();
	}

	@PreDestroy
	public void close() {
		active = false;
	}

	@Override
	public void run() {
		while (active) {
			execute();
		}
	}

	public void execute() {
		List<SystemLog> systemLogs = new ArrayList<>();
		try {
			int size = 0;
			while (size < batchSize) {
				SystemLog systemLog = auditLogQueue.poll();
				if (systemLog == null) {
					break;
				}
				systemLogs.add(systemLog);
				size++;
			}
		} catch (Exception ex) {
			logger.info(ex.getMessage(), ex);
		}
		if (!systemLogs.isEmpty()) {
			try {
				// TODO 需要删除下面的代码
				// 休眠10秒来模拟业务复杂，正在计算，测试之后大家别忘记删除这句话
				Thread.sleep(10000);
				systemLogService.insertByBatch(systemLogs);
			} catch (Exception e) {
				logger.error("异常信息:{}", e.getMessage());
			}

		}
	}

	@Resource
	public void setAuditLogQueue(SystemLogQueue auditLogQueue) {
		this.auditLogQueue = auditLogQueue;
	}
	@Resource
	public void setAuditLogService(SystemLogService systemLogService) {
		this.systemLogService = systemLogService;
	}

	public void setBatchSize(int batchSize) {
		this.batchSize = batchSize;
	}

}