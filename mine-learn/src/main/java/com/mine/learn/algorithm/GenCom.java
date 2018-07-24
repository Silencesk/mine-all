package com.mine.learn.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenCom {
    //组合算法+笛卡尔积

    //计算字符串笛卡尔积(一维数组乘积)
    //使用堆栈算法，不使用递归
    private static void Descartes(List<String> str_list, ArrayList<String> result) {
        ArrayList<char[]> result_char_list = new ArrayList<char[]>();

        int index = 0;

        while (index < str_list.size()) {
            String cur_str = str_list.get(index);

            if (index == 0) {
                for (int i = 0; i < cur_str.length(); ++i) {
                    char[] tmp = new char[str_list.size()];
                    tmp[index] = cur_str.charAt(i);
                    result_char_list.add(tmp);
                }
            } else {
                ArrayList<char[]> tmp_char_list = (ArrayList<char[]>) result_char_list.clone();
                result_char_list.clear();

                for (int i = 0; i < tmp_char_list.size(); ++i) {
                    for (int k = 0; k < cur_str.length(); ++k) {
                        char[] tmp = tmp_char_list.get(i);
                        tmp[index] = cur_str.charAt(k);

                        result_char_list.add(tmp.clone());
                    }
                }
            }
            index++;
        }

        for (int i = 0; i < result_char_list.size(); ++i) {
            result.add(String.valueOf(result_char_list.get(i)));
            System.err.println(String.valueOf(result_char_list.get(i)));
        }
    }

    //按标志位组合字符串
    private static void MakeCom(String[] str_list, boolean[] flags, ArrayList<String> result) {
        ArrayList<String> choice_str = new ArrayList<String>();

        for (int i = 0; i < str_list.length; ++i) {
            if (flags[i] == true) {
                choice_str.add(str_list[i]);
            }
        }

        //选择完，计算笛卡尔积
        Descartes(choice_str, result);
    }

    //组合算法,n为串数
    //核心算法:选号标记移位算法(选择该位为true,不选为false)，选号标记总最左(栈底)开始，循环移至最右(栈顶)。
    //移动选号位的选择：从最左边(栈底)起向右(栈顶)查询，最近一个上位有空位(false)的选号位(true)
    //将选定的选号位向右移一位(升栈)，左边标记位全部降至左边(栈底)
    //循环上面两个流程至全部选号位移至最右(栈顶)
    public static void GenCom(String[] str_list, int n, ArrayList<String> result) {
        if (n <= 0 || n > str_list.length) {
            return;
        }

        //标志数组
        boolean[] flags = new boolean[str_list.length];

        //初始化前n是选号位
        for (int i = 0; i < n; i++) {
            flags[i] = true;
        }
        //后面都是非选号位
        for (int i = n; i < str_list.length; i++) {
            flags[i] = false;
        }

        //计算初始化组合
        MakeCom(str_list, flags, result);

        while (true) {
            int num_count = 0;  //从最左边起，连续邻位true true的个数
            boolean move = false;   //是否进行了移位

            //找邻位true false组合
            for (int i = 0; i < str_list.length - 1; ++i)   //前置1位防越界
            {
                if (flags[i]) {
                    if (flags[i + 1]) //true true邻位组合，继续向右查找
                    {
                        num_count++;
                    } else        //第一个可升位位置
                    {
                        //相邻选号位true false变换为false true
                        //实现升栈
                        flags[i] = false;
                        flags[i + 1] = true;

                        //左边选号位将至栈底
                        for (int j = 0; j < num_count; j++) {
                            flags[j] = true;
                        }
                        for (int j = num_count; j < i; j++) {
                            flags[j] = false;
                        }

                        move = true;
                        break;
                    }
                }
            }

            if (move) {
                MakeCom(str_list, flags, result);
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
//        String src_str = "ab#c#def#gh#ijk#lmn#opq#rst#uvw#xyz";
        String src_str = "abc#def#gh#ijk";
        String[] str_list = src_str.split("#");

        ArrayList<String> result = new ArrayList<String>();

//        for (int i = 1; i <= str_list.length; ++i) {
//            GenCom.GenCom(str_list, i, result);
//        }

//        GenCom.GenCom(str_list, str_list.length, result);

        List<String> strList = Arrays.asList(str_list);
        Descartes(strList, result);

        for (int i = 0; i < result.size(); ++i) {
            System.out.print(i + ": " + result.get(i) + "\r\n");
        }
    }
}