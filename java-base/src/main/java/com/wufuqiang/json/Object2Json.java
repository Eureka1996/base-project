package com.wufuqiang.json;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author Wu Fuqiang
 * @date 2021/12/7 2:02 下午
 */
public class Object2Json {
    
    @Test
    public void test1(){
        // map array转成json  {"name":["wu","fu","qiang"]}
        Map<String, List<String>> map = new HashMap<>();
        List<String> list1 = Arrays.asList("wu","fu","qiang");
        map.put("name",list1);
        final String mapJson = JSON.toJSONString(map);
        System.out.println(mapJson);
    }


    @Test
    public void test2(){
        // 解析json中的map和list
        String jsonStr = "{\"MapObjectKey\":{\"map1\":{\"left\":\"00\",\"right\":\"40\",\"indexLeft\":4,\"indexRight\":2},\"map2\":{\"left\":\"00\",\"right\":\"10\",\"indexLeft\":4,\"indexRight\":2}},\"ListKey\":[\"list1\",\"list2\",\"list3\"]}";
        Obj obj = JSON.parseObject(jsonStr, Obj.class);
        System.out.println(obj);
        for (String s : obj.ListKey) {
            System.out.println(s);
        }
        System.out.println(obj.ListKey);
        System.out.println("1".equals(null));
        System.out.println(null instanceof String);

        obj.MapObjectKey.forEach( (k,v) -> System.out.println("key:"+k+",value:"+v));
    }
}

@Data
class Obj{
    public Map<String, MapObj> MapObjectKey;
    public Set<String> ListKey;
}

@Data
class MapObj{
    public String left;
    public String right;
    public Integer indexLeft;
    public Integer indexRight;
}