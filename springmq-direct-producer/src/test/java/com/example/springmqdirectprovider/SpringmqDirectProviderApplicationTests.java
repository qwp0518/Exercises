package com.example.springmqdirectprovider;

import com.sun.source.tree.TryTree;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringmqDirectProviderApplicationTests {
    @Autowired
    private Sender sender;
    @Autowired
    private SendError sendError;

    @Test
    public void testSendInfo() throws InterruptedException {
        while (true){
            Thread.sleep(1000);
            this.sender.send("Send Info");
        }
    }

    @Test
    public void testSendError() throws InterruptedException{
        while (true){
            this.sendError.sendError("Send Error");
            Thread.sleep(1000);

        }
    }

}
