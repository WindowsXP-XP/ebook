package com.xp.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * jackson 工具类
 * <p>
 * create by 2020-07-17 08:58
 *
 * @author xp
 */
public class JackSonUtil {

    /**
     * 将对象转换成json格式字符串
     * 若无法转换，则为空的json格式字符串 []
     *
     * @param object 待转换的对象
     * @return json格式字符串
     */
    public static String toJson(Object object) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "[]";
        }
    }

}
