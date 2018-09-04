//package com.sensetime.study.controller;
//
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.sensetime.study.core.ret.RetResponse;
//import com.sensetime.study.core.ret.RetResult;
//import com.sensetime.study.model.UserInfo;
//
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiImplicitParam;
//import io.swagger.annotations.ApiImplicitParams;
//import io.swagger.annotations.ApiModelProperty;
//import io.swagger.annotations.ApiOperation;
//
//@RestController // 该注解是@Controller和@ResponseBody两个注解的组合,使用了该注解之后所有的结果都是以json的格式返回
//@Api(tags = { "用户操作接口" }, value = "userInfoController控制类")
//public class UserInfoControllerBak {
//
//	private static final Logger log = LoggerFactory.getLogger(UserInfoControllerBak.class);
//
//	@Autowired
//	UserInfoService userInfoService;
//
////	@ApiIgnore // 表示该接口不对外展示，在swagger-ui的页面查看不到
//	@GetMapping("/hello")
//	public String hello() {
//		return "hello world!";
//	}
//
//	@ApiOperation(value = "分页查询用户", notes = "分页查询用户")
//	@ApiImplicitParams({ @ApiImplicitParam(name = "page", value = "当前页码", dataType = "Integer", paramType = "query"),
//			@ApiImplicitParam(name = "size", value = "每页显示条数", dataType = "Integer", paramType = "query") })
//	@GetMapping("/selectAll")
//	public RetResult<List<UserInfo>> selectAll(@RequestParam(defaultValue = "1") Integer page,
//			@RequestParam(defaultValue = "5") Integer size) {
//		List<UserInfo> list = userInfoService.selectAll(page, size);
//		return RetResponse.makeOKRsp(list);
//	}
//
//	@ApiOperation(value = "查询单个用户", notes = "根据用户id查询用户详细信息")
//	@ApiImplicitParams({
//			@ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "String", paramType = "query") })
//	@RequestMapping(value = "/userInfo", method = RequestMethod.GET)
//	public RetResult<UserInfo> selectById(@RequestParam("id") String id) {
//		UserInfo userInfo = userInfoService.selectById(id);
//		return RetResponse.makeOKRsp(userInfo);
//	}
//
//	@ApiOperation(value = "保存用户", notes = "将用户信息保存到数据库中")
//	@ApiModelProperty(name="id",hidden=true)
//	@PostMapping("/userInfo")
//	public RetResult<UserInfo> insertUserInfo(@RequestBody UserInfo userInfo) {
//		log.info("[info] >>>>>> 接收到参数{}", userInfo);
//		try {
//			userInfoService.insert(userInfo);
//		} catch (Exception e) {
//			log.error(e.getMessage());
//		}
//		return RetResponse.makeOKRsp(null);
//	}
//
//	@ApiOperation(value = "更新用户", notes = "根据用户对象信息更新用户")
//	@PutMapping("/userInfo")
//	public RetResult<UserInfo> updateUserInfoById(@RequestBody UserInfo userInfo) {
//		try {
//			userInfoService.update(userInfo);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return RetResponse.makeErrRsp("更新失败");
//		}
//		return RetResponse.makeOKRsp();
//	}
//
//}
