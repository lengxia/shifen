package com.jubeis.user.service.impl;

import com.jubeis.model.common.dtos.ResponseResult;
import com.jubeis.model.enums.AppHttpCodeEnum;
import com.jubeis.model.user.dos.UserDO;
import com.jubeis.user.service.LoginService;
import com.jubeis.user.service.UserDaoService;
import com.jubeis.utils.common.AppJwtUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserDaoService userDaoService;


    @Override
    public ResponseResult loginAuth(UserDO userDto) {
        if(userDto.getId().equals(null)||StringUtils.isEmpty(userDto.getPassword())){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        UserDO user= userDaoService.getBaseMapper().selectById(userDto.getId());
        if(user==null){
            return ResponseResult.errorResult(AppHttpCodeEnum.AP_USER_DATA_NOT_EXIST,"查无此人");
        }
        if (!userDto.getPassword().equals(user.getPassword())) {
            return ResponseResult.errorResult(AppHttpCodeEnum.LOGIN_PASSWORD_ERROR);
        }
        user.setPassword("");
        Map<String, Object> map = new HashMap<>();
        map.put("token", AppJwtUtil.getToken(user));
        map.put("user", user);

        return ResponseResult.okResult(map);
    }
}
