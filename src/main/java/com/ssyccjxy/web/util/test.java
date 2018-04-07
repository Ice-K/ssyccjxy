package com.ssyccjxy.web.util;

import java.util.*;

/**
 * Description：
 * Cteated by wangpeng
 * 2018/3/27 11:40
 */
public class test {
    public static void main(String[] args){
//        System.out.println(new Date().getTime());
//
//        System.out.println(HttpIpUtil.getIpInfo("本地"));

        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("A");
        list.add("B");
        Set<String> set = new HashSet<>(list);
        String a = Arrays.toString(set.toArray());

        System.out.println(a);
    }
}
