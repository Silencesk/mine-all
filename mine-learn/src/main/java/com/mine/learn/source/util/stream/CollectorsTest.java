package com.mine.learn.source.util.stream;

import static java.util.stream.Collectors.toList;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.mine.core.util.BeanMapper;
import com.mine.learn.source.Moke;
import com.mine.learn.source.MokeDTO;

/**
 * CollectorsTest
 *
 * @author liutao
 * @version 2018-07-29 下午10:03
 */

public class CollectorsTest {

    @Test
    public void testToMap() {
        List<String> list = Lists.newArrayList("zhishu", "geke", "moke", "zhishu");
        Map<String, String> map = list.stream().collect(Collectors.toMap(
                Function.identity(),
                key -> key + key,
                // 合并函数
                (first, second) -> first + second,
                // Map类型
                LinkedHashMap::new));
        System.err.println(JSON.toJSONString(map));
        List<Moke> mokes = getMokeList();

        // 转为单个对象
        // 如果只要分组后保存一个对象，则使用toMap，若需要保存的是一个list对象，则使用groupBy
        Map<String, MokeDTO> singleMap = mokes.stream().collect(
                Collectors.toMap(Moke::getSex, x -> BeanMapper.map(x, MokeDTO.class),
                        (first, second) -> {
                            MokeDTO x = new MokeDTO();
                            x.setSex(first.getSex());
                            x.setId(first.getId().concat(",").concat(second.getId()));
                            x.setName(first.getName().concat(",").concat(second.getName()));
                            return x;
                        }
                )
        );
        System.err.println(JSON.toJSONString(singleMap));
        // 转为list对象
        Map<String, List<Moke>> listMap = mokes.stream().collect(
                Collectors.toMap(x -> x.getSex() + ":" + x.getName(), x -> Lists.newArrayList(x),
                        (first, second) -> {
                            List<Moke> mokeList = Lists.newArrayList();
                            mokeList.addAll(first);
                            mokeList.addAll(second);
                            return mokeList;
                        }
                )
        );
        System.err.println(JSON.toJSONString(listMap));
        Assert.assertEquals(4, listMap.size());
    }

    @Test
    public void testGroupBy() {
        List<Moke> mokes = getMokeList();
        Map<String, List<Moke>> groups = mokes.stream().collect(
                Collectors.groupingBy(x -> x.getSex() + ":" + x.getName(), LinkedHashMap::new, toList())
        );
        System.err.println(JSON.toJSONString(groups));
        Assert.assertEquals(4, groups.size());
    }

    private List<Moke> getMokeList() {
        List<Moke> mokes = Lists.newArrayList(new Moke(1L, "lt", "M"),
                new Moke(2L, "xk", "F"), new Moke(3L, "lx", "F"),
                new Moke(4L, "gk", "M"), new Moke(5L, "xk", "F"));

        return mokes;
    }
}
