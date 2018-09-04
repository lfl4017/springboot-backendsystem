package com.sensetime.study.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sensetime.study.core.ret.RetResponse;
import com.sensetime.study.core.ret.RetResult;
import com.sensetime.study.core.utils.UploadActionUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/uploadFile")
public class UploadFileController {

	@PostMapping("/upload")
	public RetResult<List<String>> upload(HttpServletRequest httpServletRequest) throws Exception {
		List<String> list = UploadActionUtil.uploadFile(httpServletRequest);
		return RetResponse.makeOKRsp(list);
	}
}