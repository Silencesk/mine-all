package com.mine.learn.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

/**
 * 阿里面试
 *
 * @author liutao
 * @create 2017-06-24 下午11:26
 */

public class AliInterview {
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
        int input = 938;
        List<String> candidates = getCandidates(input, rawDict);
        candidates.forEach(System.out::println);
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
     * 获取输入匹配的候选词
     *
     * @param input
     * @param rawDict
     * @return
     */
    public static List<String> getCandidates(int input, List<String> rawDict) {
        List<String> candidates = new ArrayList<String>();
        String inputStr = getInputString(input);
        for (String word : rawDict) {
            // 非空判断
            if (StringUtils.isNotBlank(word)) {
                // 先转为小写，然后再与输入串进行匹配
                String newWord = word.toLowerCase().trim();
                if (matchInput(newWord, inputStr)) {
                    candidates.add(newWord);
                }
            }

        }
        return candidates;
    }

    /**
     * 匹配输入，具体逻辑
     *
     * @param word
     * @param inputStr
     * @return
     */
    public static boolean matchInput(String word, String inputStr) {
        /**
         * 1.获取输入串可能的组合单词，再通过输入组合单词与词典单词一个个匹配，这种效率应该会高些
         * 2.直接取单词的位数一位位匹配
         */
//        return matchInput1(word, inputStr);
        return matchInput2(word, inputStr);
    }

    /**
     * 匹配规则1：获取输入串可能的组合单词，再通过输入组合单词与词典单词一个个匹配
     *
     * @param word
     * @param inputStr
     * @return
     */
    public static boolean matchInput1(String word, String inputStr) {
        boolean isMatched = false;
        // TODO 待实现
        return isMatched;
    }

    /**
     * 匹配规则2：直接取单词的位数一位位匹配
     *
     * @param word
     * @param inputStr
     * @return
     */
    public static boolean matchInput2(String word, String inputStr) {
        boolean isMatched = true;
        // 只有当单词的长度 >= 输入串的长度才有可能匹配上
        int inputLength = inputStr.length();
        if (word.length() < inputLength) {
            return false;
        }
        for (int i = 0; i < inputLength; i++) {
            // map中char与string并不是同一类型
            String value = keyMap.get(String.valueOf(inputStr.charAt(i)));
            if (value.indexOf(word.charAt(i)) == -1) {
                isMatched = false;
                break;
            }
        }
        return isMatched;
    }

    /**
     * 获取有效的输入串
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
}
