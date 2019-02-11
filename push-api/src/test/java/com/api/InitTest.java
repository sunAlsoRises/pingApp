package com.api;

import com.util.JiGuangPush;
import org.junit.Test;
public class InitTest extends BaseTest{
//    @Autowired
//    private EntFileService entFileService;
    //@Ignore("not ready yet")
    @Test
    public void testPush(){
//        推送
        JiGuangPush.push("707eb_0d8ba0642f19d14_5527fc92a10d","推送你大爷");
    }
    @Test
    public void testJgPush(){
        JiGuangPush jp = new JiGuangPush();
        jp.jiguangPush();
        System.out.println("推送成功了吗");
    }

}
