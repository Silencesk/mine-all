package com.mine.learn.regex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则
 *
 * @author liutao
 * @create 2017-03-21 上午10:48
 */

public class RegexStd {

    @Test
    public void appendWhere(){
        /**
         * 在正则表达式最前面加上 (?i) 就可以忽略后面所有的大小写
         * \b匹配单词 (.*?)懒惰匹配
         */
        String str = "select a.id,a.name,(select b.id from b where 1=1) from user a where 1=1";
        /**
         * from(.*)(?=from)-匹配以from与from之间的部分
         */
        String regex = "((?i)SELECT(.*)[^\\(](?=FROM))";
        StringBuilder sb = new StringBuilder(str.length());
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        boolean isMatched = false;
        while (matcher.find()){
            String s = matcher.group();
            System.out.println(s + "; start"+matcher.end());
//            if(s.indexOf(")") >0 && s.indexOf("where")<0){
//                sb.append(str.replace(")", " where 1=1)"));
//            }
            isMatched = true;
        }
        if(!isMatched){
            sb.append(str).append(" where 1=1 ");
        }
        System.out.println("sb="+sb.toString());

    }

    @Test
    public void splitFrom(){
//        String str = "select a.id,a.name,(select b.id FROm b) as bid,(select b.id from c where 1=1) as cid from user a";
        String str = "SELECT COUNT(1)  FROM  ( SELECT  test_id AS id,`name`,age,test_type AS testType,`role`,phone,dept_no AS deptNo FROM  user) TOTAL";
        String[] arr = str.split("(?i)FROM");
        int i = 0;
        StringBuilder sb = new StringBuilder(str.length());
        for (String s : arr){
            if(i++ == 0){
                sb.append(s);
                continue;
            }
            sb.append(" FROM ");
            if(s.matches("(.*)(?i)WHERE(.*)")){     // 直接使用WHERE则无法匹配
                sb.append(s);
            }else{
                if(s.indexOf(")") >0){
                    sb.append(s.replaceFirst("\\)", " WHERE 1=1)"));
                } else if (s.matches("(.*)(?i)\\((.*)SELECT(.*)")){
                    sb.append(s);
                }
                else{
                    sb.append(s).append(" WHERE 1=1 ");
                }
            }
        }
        System.out.println("sb="+sb.toString());
    }
}
