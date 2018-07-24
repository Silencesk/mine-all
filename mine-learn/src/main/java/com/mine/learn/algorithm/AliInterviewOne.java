package com.mine.learn.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 阿里面试one
 *
 * @author liutao
 * @create 2017-06-24 下午11:26
 */

public class AliInterviewOne {
    /**
     * 输入数字键值Map
     */
    private static Map<String, String> keyMap = new HashMap<String, String>();
    private static Map<String, String> dictMap = new HashMap<>();

    static {
        initKeyMap();
        buildDict();
    }

    /**
     * 初始化数字键值Map
     */
    static void initKeyMap(){
        keyMap.put("2", "abc");
        keyMap.put("3", "def");
        keyMap.put("4", "ghi");
        keyMap.put("5", "jkl");
        keyMap.put("6", "mno");
        keyMap.put("7", "pqrs");
        keyMap.put("8", "tuv");
        keyMap.put("9", "wxyz");
    }

    /**
     * 构建单词字典
     */
    static void buildDict(){
        List<String> rawDict = loadDict("dict.txt");
        for(String word : rawDict){
            StringBuilder numberStr = new StringBuilder(word.length());
            char[] chars = word.toCharArray();
            for (char ch : chars){
                numberStr.append(getReflectiveNumber(ch));
            }
            dictMap.put(word, numberStr.toString());
        }

        System.err.println("=====dictMap====");
        System.err.println(dictMap.toString());
    }

    /**
     * 获取字符对应的数字
     * @param ch
     * @return
     */
    public static String getReflectiveNumber(char ch){
        for (Map.Entry<String, String> entry : keyMap.entrySet()){
            if(entry.getValue().indexOf(ch) > -1){
                return entry.getKey();
            }
        }

        return null;
    }

    public static void main(String[] args) {
        List<String> rawDict = loadDict("dict.txt");
        printCandidates(937);
        printCandidates(938);
        printCandidates(244);
        printCandidates(246);
        printCandidates(93);
    }

    /**
     * 打印出候选词
     * @param input
     */
    public static void printCandidates(int input) {
        System.err.println("=====" + input + "======");
        List<String> candidates = getCandidates(input);
//        candidates.forEach(System.out::println);
        for (String candidate : candidates) {
            System.out.println(candidate);
        }
    }
    /**
     * 模拟从文件加载单词
     * @param file
     * @return
     */
    public static List<String> loadDict(String file){
        List<String> rawDict = new ArrayList<String>();
        rawDict.add("china");
        rawDict.add("yes");
        rawDict.add("you");
        rawDict.add("yesterday");
        rawDict.add("wet");
        rawDict.add("welcome");

        return rawDict;
    }

    /**
     * 获取输入匹配的候选词
     * @param input
     * @return
     */
    public static List<String> getCandidates(int input){
        List<String> candidates = new ArrayList<String>();
        String inputStr = getInputString(input);
        for(Map.Entry<String, String> entry : dictMap.entrySet()){
            if (entry.getValue().startsWith(inputStr)){
                candidates.add(entry.getKey());
            }
        }
        return candidates;
    }

    /**
     * 获取有效的输入串
     * @param input
     * @return
     */
    public static String getInputString(int input){
        // 校验参数有效性
        if(input < 0) {
            throw new RuntimeException("只能输入正整数");
        }
        // 对于输入的0，1直接替换为""，不影响输入的结果
        // StringBuilder不支持直接将int转换为字符串，其整型的构造函数代表长度
        StringBuilder sb = new StringBuilder(String.valueOf(input));
        return sb.toString().replace("0", "").replace("1", "");
    }
}
