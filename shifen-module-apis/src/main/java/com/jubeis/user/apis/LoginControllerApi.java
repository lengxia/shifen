package com.jubeis.user.apis;

import com.jubeis.model.common.dtos.ResponseResult;
import com.jubeis.model.user.dos.UserDO;

public interface LoginControllerApi {
    public ResponseResult login(UserDO userDO);
}
