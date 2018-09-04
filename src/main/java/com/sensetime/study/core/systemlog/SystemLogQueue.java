package com.sensetime.study.core.systemlog;

import org.springframework.stereotype.Component;

import com.sensetime.study.model.SystemLog;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

@Component
public class SystemLogQueue {

	private BlockingQueue<SystemLog> blockingQueue = new LinkedBlockingQueue<>();

	public void add(SystemLog systemLog) {
		blockingQueue.add(systemLog);
	}

	public SystemLog poll() throws InterruptedException {
		// 在移除元素时如果失败，会等待指定时间，如果超过时间仍然失败，则直接返回null
		// 如果成功则返回被移除的原始
		return blockingQueue.poll(1000, TimeUnit.MILLISECONDS);
	}
}