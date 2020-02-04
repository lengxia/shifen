package com.jubeis.user.apis;

import com.jubeis.model.common.dtos.ResponseResult;
import com.jubeis.model.user.dos.UserDO;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserControllerApi {
    public ResponseResult register(UserDO userDO);
}
