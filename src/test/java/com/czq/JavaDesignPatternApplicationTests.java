package com.czq;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JavaDesignPatternApplicationTests {

	@Test
	void contextLoads() {
		System.out.println("测试用例");
//		使用myFirstTest方法上方使用@Test方法，表明该方法是一个测试方法。
//		在myFirstTest方法中，使用断言assertEquals,用以验证2和1+1的值是否相等
		assertEquals(2, 1 + 1);
	}

}
