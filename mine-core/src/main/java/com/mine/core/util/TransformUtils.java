package com.mine.core.util;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mine.core.vo.SystemUser;

import java.util.List;
import java.util.Map;

/**
 * @author liutao
 * @create 2017-06-04 下午10:34
 */

public class TransformUtils {

    public void testDozer(){
        Map<String, List<SystemUser>> dataMap = Maps.newHashMap();
        List<SystemUser> users = Lists.newArrayList();
        SystemUser u1 = new SystemUser();
        u1.setUserCode("lt");
        u1.setUserName("liutao");
        SystemUser u2 = new SystemUser();
        u2.setUserCode("mk");
        u2.setUserName("moke");
        SystemUser u3 = new SystemUser();
        u3.setUserCode("gk");
        u3.setUserName("geke");
        SystemUser u4 = new SystemUser();
        u3.setUserCode("zs");
        u3.setUserName("zhishu");
        users.add(u1);
        users.add(u2);
        users.add(u3);

        // 如何正确的表述一个带范型的复杂类
//        Map<String, List<SystemUser>> dataMapCopy = BeanMapper.copy(dataMap, );
    }
}
