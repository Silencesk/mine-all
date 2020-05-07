package com.mine.learn.lang;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeConfig;
import org.junit.Test;

public class EnumSTD {
    enum OperateTypeEnum {
        ADD("A", "新增"),
        MODIFY("M", "修改"),
        DELETE("D", "删除");

        private String value;
        private String info;

        OperateTypeEnum(String value, String info) {
            this.value = value;
            this.info = info;
        }
    }

    @Test
    public void testEnumToJSONString() {
        SerializeConfig serializeConfig = new SerializeConfig();
        serializeConfig.configEnumAsJavaBean(OperateTypeEnum.class);
        String jsonStr = JSON.toJSONString(OperateTypeEnum.class);
        System.err.println(jsonStr);
    }
}