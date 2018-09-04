package com.sensetime.study;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sensetime.study.SpringbootBackendsystemApplicationTests.Type;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootBackendsystemApplicationTests {

	@Test
	public void contextLoads() {
		
	}


	

	//定义枚举类型
	enum Day {
	    MONDAY, TUESDAY, WEDNESDAY,
	    THURSDAY, FRIDAY, SATURDAY, SUNDAY
	}
	
	enum Type {
		STRANGER,NORMARL
	}
}
