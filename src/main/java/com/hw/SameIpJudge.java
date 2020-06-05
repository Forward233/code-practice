package com.hw;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author: yhl
 * @DateTime: 2020/5/30 17:20
 * @Description:
 */
public class SameIpJudge {

    public static void main(String[] args) {
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("q", "a");
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(jsonObject1);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("1", jsonArray);
        jsonObject.put("2", jsonArray);
        System.out.println(jsonObject);
    }
}
