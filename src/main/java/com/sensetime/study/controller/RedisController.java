package com.sensetime.study.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sensetime.study.core.ret.RetResponse;
import com.sensetime.study.core.ret.RetResult;
import com.sensetime.study.service.RedisService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

@RestController
@RequestMapping("redis")
@Api(description = "操作redis的接口", tags = "操作redis的具体接口")
public class RedisController {

	@Resource
	private RedisService redisService;

	@ApiOperation(value = "存入redis数据", notes = "存入redis数据")
	@ApiImplicitParams({ @ApiImplicitParam(name = "key", value = "值对应的key", dataType = "String", paramType = "form"),
			@ApiImplicitParam(name = "value", value = "存入的值", dataType = "String", paramType = "form") })
	@PostMapping("/setRedis")
	public RetResult<Map<String, String>> setRedis(String key, String value) {
		redisService.set(key, value);
		Map<String, String> map = new HashMap<>();
		map.put(key, value);
		return RetResponse.makeOKRsp(map);
	}


	@ApiOperation(value = "根据key获取数据", notes = "根据key获取数据")
	@ApiImplicitParams({ @ApiImplicitParam(name = "key", value = "值对应的key", dataType = "String", paramType = "path")})
	@GetMapping("/getRedis/{key}")
	public RetResult<String> getRedis(@PathVariable("key") String key) {
		String result = redisService.get(key);
		return RetResponse.makeOKRsp(result);
	}
	
}