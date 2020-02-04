package com.jubeis.user.controller.v1;

import com.jubeis.model.common.dtos.ResponseResult;
import com.jubeis.model.user.dos.UserDO;
import com.jubeis.user.apis.LoginControllerApi;
import com.jubeis.user.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class LoginController implements LoginControllerApi {
    @Autowired
    private LoginService loginService;

    @Override
    @RequestMapping("/login")
    public ResponseResult login(@RequestBody UserDO userDO) {
        return loginService.loginAuth(userDO);
    }
}
