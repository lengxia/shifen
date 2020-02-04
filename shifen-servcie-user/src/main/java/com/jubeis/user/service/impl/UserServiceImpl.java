package com.jubeis.user.service.impl;

import com.jubeis.model.common.dtos.ResponseResult;
import com.jubeis.model.enums.AppHttpCodeEnum;
import com.jubeis.model.user.dos.UserDO;
import com.jubeis.user.service.UserDaoService;
import com.jubeis.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    private UserDaoService userDaoService;
    @Override
    public ResponseResult register(UserDO user) {
        Boolean registerok=userDaoService.save(user);
        if(registerok==true){
            return ResponseResult.okResult(null);
        }else {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
    }
}
