package com.jubeis.user.controller.v1;

import com.jubeis.model.common.dtos.ResponseResult;
import com.jubeis.model.user.dos.UserDO;
import com.jubeis.user.apis.UserControllerApi;
import com.jubeis.user.service.UserDaoService;
import com.jubeis.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/register")
public class UserController implements UserControllerApi {
    @Autowired
    private UserService userService;

    @Override
    @RequestMapping("/in")
    public ResponseResult register(@RequestBody UserDO userDO) {
        return userService.register(userDO);
    }


}
