package com.mine.learn.huawei;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        String input = "100,11111,1111";
//        Scanner in = new Scanner(System.in);
//        while (in.hasNextInt()) {
//            input = in.nextLine();
//        }
        String[] arr = input.split(",");
        int[] ret = {0, 0, 0, 0, 0};
        for (String s : arr) {
            int n = s.length()>5?5:s.length();
            for (int i = 0; i < n; i++) {
                char ch = s.charAt(i);
                int current = Integer.valueOf("" + ch);
                ret[i] += current > 1?1:current;
            }
        }
        int min = ret[0];
        for (int i : ret) {
            if (min > i) {
                min = i;
            }
        }
        System.out.println(min);
    }
}
