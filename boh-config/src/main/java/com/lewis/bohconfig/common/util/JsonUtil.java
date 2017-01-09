package com.lewis.bohconfig.common.util;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhangminghua on 2017/1/9.
 */
public class JsonUtil {
    private JsonUtil(){}

    public static String toString(Object obj){
        if (obj != null) {
            return JSON.toJSONString(obj);
        }
        return "";
    }

    public static <T> T toBean(String str,Class<T> clazzType){
        if (StringUtils.isNotEmpty(str) && clazzType != null) {
            return JSON.parseObject(str,clazzType);
        }
        return null;
    }

    public static <T> List<T> toList(String str, Class<T> clazzType){
        List<T> retList = new LinkedList<T>();
        if (StringUtils.isNotEmpty(str) && clazzType != null) {
            List<String> list = JSON.parseObject(str, List.class);
            if (ListUtil.isNotEmpty(list)) {
                for (String string : list) {
                    T t = JsonUtil.toBean(string, clazzType);
                    if (t != null) {
                        retList.add(t);
                    }
                }
            }
        }
        return retList;
    }
}
