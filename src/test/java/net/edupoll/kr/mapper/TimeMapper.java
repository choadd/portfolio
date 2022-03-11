package net.edupoll.kr.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml")
public class TimeMapper {

	@Autowired
	TestMapper testMapper;
	
	@Test
	public void test() {
		System.out.println(testMapper.getTime());
		
		
	}
	
}
