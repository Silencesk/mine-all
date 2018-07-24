package com.mine.learn.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;

/**
 * 阿里面试
 *
 * @author liutao
 * @create 2017-06-24 下午11:26
 */

public class AliInterviewTwo {

    /**
     * 输入数字键值Map
     */
    private static Map<String, String> keyMap = new HashMap<String, String>();

    static {
        keyMap.put("2", "abc");
        keyMap.put("3", "def");
        keyMap.put("4", "ghi");
        keyMap.put("5", "jkl");
        keyMap.put("6", "mno");
        keyMap.put("7", "pqrs");
        keyMap.put("8", "tuv");
        keyMap.put("9", "wxyz");
    }

    public static void main(String[] args) {
        List<String> rawDict = loadDict("dict.txt");
//        int input = 937;    // yes yesterday
//        int input = 938;    // wet
        int input = 9;    // wet
        List<String> candidates = getCandidates(input, rawDict);
        System.err.println("===result===");
        candidates.forEach(System.err::println);
    }

    /**
     * 模拟从文件加载单词
     *
     * @param file
     * @return
     */
    public static List<String> loadDict(String file) {
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
     * 构建字典树
     * @param rawDict
     * @return
     */
    public static TrieTree buildTrieTree(List<String> rawDict){
        TrieTree trieTree = new TrieTree();
        rawDict.forEach(word -> {
            trieTree.addWord(word);
        });

        return trieTree;
    }

    /**
     * 获取输入匹配的候选词
     *
     * @param input
     * @param rawDict
     * @return
     */
    public static List<String> getCandidates(int input, List<String> rawDict) {
        List<String> candidates = Lists.newArrayList();

        // 获取有效的输入数字串
        String inputStr = getInputString(input);
        // 获取输入数字串对应的字母串字符list
        List<String> strList = getStrList(inputStr);
        // 计算字母串字符list的笛卡尔积
        List<String> descartes = calcDescartes(strList);
        int i = 0;
        // 构建字典树
        TrieTree dict = buildTrieTree(rawDict);
        // 遍历笛卡尔积，将字符组合作为Trie Tree的匹配词，并将匹配到的单词添加到候选词中
        for(String findStr : descartes) {
            System.out.println((i++) + ": " + findStr);
            if(findStr.equals("yes")) {
                System.out.println(findStr);
            }
            List<String> curList = dict.findWordsByPrefix(findStr);
            curList.forEach(System.out::println);
            candidates.addAll(curList);
        }

        return candidates;
    }


    /**
     * 获取有效的输入数字串
     *
     * @param input
     * @return
     */
    public static String getInputString(int input) {
        // 校验参数有效性
        if (input < 0) {
            throw new RuntimeException("只能输入正整数");
        }
        // 对于输入的0，1直接替换为""，不影响输入的结果
        // StringBuilder不支持直接将int转换为字符串，其整型的构造函数代表长度
        StringBuilder sb = new StringBuilder(String.valueOf(input));
        return sb.toString().replace("0", "").replace("1", "");
    }

    /**
     * 获取输入数字串对应的字母串字符list
     * @param intput
     * @return
     */
    public static List<String> getStrList(String intput) {
        int length = intput.length();
        List<String> strList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            // map中char与string并不是同一类型
            String str = keyMap.get(String.valueOf(intput.charAt(i)));
            strList.add(str);
        }
        return strList;
    }

    /**
     * 计算输入字符串数组的笛卡尔积
     *
     * @param strList 输入字符串数组 abc def hijk
     * @return
     */
    public static List<String> calcDescartes(List<String> strList) {
        List<String> result = new ArrayList();
        // 笛卡尔积的字符数组表示
        List<char[]> resultChars = new ArrayList();
        int index = 0;
        int size = strList.size();
        while (index < strList.size()) {
            String curStr = strList.get(index);
            // 对于第一个字符串，直接生成结果字符数组内容
            if (index == 0) {
                for (int i = 0; i < curStr.length(); i++) {
                    char[] tmp = new char[size];    // 字符数组，长度为进行笛卡尔积的字符串数组长度
                    tmp[index] = curStr.charAt(i);
                    resultChars.add(tmp);
                }
            } else {
                // 对于非第一个字符串，需要在原有字符数组的笛卡尔积的基础上，与当前字符串进行组合
                // 上一次循环计算字符数组
                List<char[]> resultCharsLast = new ArrayList(resultChars);
                resultChars.clear();

                // 此次的结果等于上次结果 并 当前字符 双重循环
                for (int i = 0; i < curStr.length(); i++) {     // 当前字符串遍历
                    for (int j = 0; j < resultCharsLast.size(); j++) {  // 上一次循环
                        char[] tmp = resultCharsLast.get(j).clone();
                        tmp[index] = curStr.charAt(i);
                        resultChars.add(tmp);
                    }
                }
            }
            index++;
        }

        resultChars.forEach(chars -> {
            result.add(String.valueOf(chars));
        });
        return result;
    }

}
