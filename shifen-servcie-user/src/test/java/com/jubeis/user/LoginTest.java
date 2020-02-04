package com.jubeis.user;

import com.jubeis.model.user.dos.UserDO;
import com.jubeis.user.service.LoginService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginTest {
    @Autowired
    LoginService loginService;

    @Test
    public void logintest(){
        UserDO userDO=new UserDO();
        userDO.setId(12L);
        userDO.setPassword("12");
        System.out.println(loginService.loginAuth(userDO).getData());



    }
}
