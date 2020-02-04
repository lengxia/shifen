package com.jubeis.user.service;

import com.jubeis.model.common.dtos.ResponseResult;
import com.jubeis.model.user.dos.UserDO;

public interface UserService {
    ResponseResult register(UserDO user);
}
