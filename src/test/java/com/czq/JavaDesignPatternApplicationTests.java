package com.czq;

import com.czq.strategyreflect.PaymentHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JavaDesignPatternApplication.class)
public class JavaDesignPatternApplicationTests {

//	@Test
//	void contextLoads() {
//		System.out.println("测试用例");
////		使用myFirstTest方法上方使用@Test方法，表明该方法是一个测试方法。
////		在myFirstTest方法中，使用断言assertEquals,用以验证2和1+1的值是否相等
//		assertEquals(2, 1 + 1);
//	}

    /**
     * 测试支付处理器执行生成以及执行传智支付宝PC端支付
     */
    @Test
    public void testPaymentHandler4ItcastAlipayPcPay() {
        String clientType = "PC";
        String strategyCode = "ITCAST_ALIPAY_PC";
        PaymentHandler paymentHandler = PaymentHandler.getInstance(clientType, strategyCode);
        Assert.notNull(paymentHandler, "获取不到支付处理器！");
        String paymentParams = "测试支付策略";
        String str = paymentHandler.unifiedOrder(paymentParams);
        System.out.println("获取：" + str);
    }
}
