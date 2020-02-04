package com.jubeis.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jubeis.model.mappers.user.UserMapper;
import com.jubeis.model.user.dos.UserDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MariadbTest {
//    @Autowired
//    private DataSource dataSource;
//
//    @Test
//    public void test() throws SQLException {
//
//        System.out.println(dataSource.getClass());
//    }
    @Resource
    private UserMapper userMapper;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void select() throws JsonProcessingException {

        //userMapper.selectList(null).forEach(System.out::println);
        List<UserDO> userDOs=userMapper.selectList(null);
        for (UserDO user:userDOs) {
            String json = objectMapper.writeValueAsString(user);

            System.out.println(json);
        }
    }

}
