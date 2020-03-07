package com.mine.learn.javaguide;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

public class UserDTOTest {

    @Test
    public void test() {
        UserDTO dto = UserDTO.of().setAge(21).setUsername("oo");

        System.err.println(JSON.toJSONString(dto));
    }
}
