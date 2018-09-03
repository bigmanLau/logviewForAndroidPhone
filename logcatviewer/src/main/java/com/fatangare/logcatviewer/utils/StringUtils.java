package com.fatangare.logcatviewer.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * create by bigman
 * create date == 2018/9/3
 * create time == 11:31
 */

public class StringUtils {
    //分离一个或多个空格的字符串
    public static List<String> splitStrings(String str){
        String [] arr = str.split("\\s+");
        List<String> list=new ArrayList<>();
        for(String ss : arr){
            list.add(ss);
        }
        return list;
    }
}
