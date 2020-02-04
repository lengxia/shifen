package com.jubeis.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jubeis.model.mappers.user.UserMapper;
import com.jubeis.model.user.dos.UserDO;
import com.jubeis.user.service.UserDaoService;
import org.springframework.stereotype.Service;

@Service
public class UserDaoServiceImpl  extends ServiceImpl<UserMapper,UserDO> implements UserDaoService {

}
