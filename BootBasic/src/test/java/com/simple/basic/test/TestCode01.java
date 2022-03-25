package com.simple.basic.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import com.simple.basic.command.BuilderVO;
import com.simple.basic.command.BuilderVO.Builder;
import com.simple.basic.command.BuilderVO2;
import com.simple.basic.controller.TestController;

//기준 패키지 하위에 작성
@SpringBootTest
public class TestCode01 {
	
	@Autowired
	private ApplicationContext context;
	
//	@Test
//	public void test01() {
//		
//		//우클릭 - run as -  junit으로 실행
//		TestController t = context.getBean(TestController.class);
//		System.out.println(t);
//	}
	
	@Test
	public void test02() {
		
//		Builder b = BuilderVO.builder();
//		Builder b2 = b.age(10);
//		Builder b3 = b.name("홍길동");
		
		BuilderVO vo = BuilderVO.builder().age(10).name("홍길동").build();
		System.out.println(vo.toString());
		
		BuilderVO2 vo2 = BuilderVO2.builder().age(30).name("이순신").build();
		System.out.println(vo2.toString());
		
		BuilderVO2 vo3 = new BuilderVO2("강감찬",30);
		System.out.println(vo3.toString());
		
	}
	
	
}
