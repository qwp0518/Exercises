package com.example.springmqtopicproducer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringmqDirectProviderApplicationTests {
    @Autowired
    private UserSender userSender;
    @Autowired
    private ProductSender productSender;
    @Autowired
    private OrderSender orderSender;

    @Test
    public void testSend() {
        this.userSender.send("Send user log");
        this.productSender.send("Send product log");
        this.orderSender.send("send order log");


    }


}
