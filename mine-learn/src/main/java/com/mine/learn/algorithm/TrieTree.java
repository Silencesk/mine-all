package com.mine.learn.algorithm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Lists;

/**
 * 字典树
 *
 * @author liutao
 * @create 2017-06-29 下午9:44
 */

public class TrieTree {

    TrieNode root = new TrieNode(null, null);

    /**
     * 根据查找串查找出以该串开头的所有单词
     * @param findStr
     * @return
     */
    public List<String> findWordsByPrefix(String findStr) {
        List<String> result = Lists.newArrayList();
        // 如果空树，直接返回
        if (isEmpty()) {
            return result;
        }

        // 定位到输入串的最后一个单词所在节点
        TrieNode node = root;
        Map<Character, TrieNode> childrenMap;
        for (int i = 0; i < findStr.length(); i++) {
            if (!node.hasChildren()) {
                return result;
            }
            childrenMap = node.getChildrenMap();
            node = childrenMap.get(findStr.charAt(i));
            if (node == null) {
                return result;
            }
        }

        // 如果节点为单词结尾，则需将查找串添加为返回结果集中
        if (node.isWord()) {
            result.add(findStr);
        }

        // 获取该节点下面的所有单词，树的深度遍历
        getAllWordsBelowNode(node, result, findStr);

        return result;
    }

    /**
     * 获取该节点下面的所有单词
     * @param node 树节点
     * @param result 结果集
     */
    private void getAllWordsBelowNode(TrieNode node, List<String> result, String parentStr) {
        if (!node.hasChildren()) {
            return;
        }
        Map<Character, TrieNode> childrenMap = node.getChildrenMap();
        for(Map.Entry<Character, TrieNode> entry : childrenMap.entrySet()) {
            String curStr = parentStr + entry.getKey();
            node = entry.getValue();
            if (node.isWord()) {
                result.add(curStr);
            }
            getAllWordsBelowNode(node, result, curStr);
        }
    }

    /**
     * 添加一个字典
     *
     * @param word
     */
    public void addWord(String word) {
        if (StringUtils.isEmpty(word)) {
            return;
        }
        // 定义递进的node，从root节点开始，会被不断增加的字符替换
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            node = node.addCharacter(word.charAt(i));
        }
        // 在最后的字符节点，标识为单词
        node.setWord(true);
    }

    /**
     * 判断当前树是否为空树
     * @return
     */
    public boolean isEmpty (){
        Map<Character, TrieNode> childrenMap = root.getChildrenMap();
        return childrenMap == null || childrenMap.size() == 0;
    }

    class TrieNode {
        /**
         * 节点字符
         */
        private Character ch;
        /**
         * 子节点
         */
        private Map<Character, TrieNode> childrenMap;
        /**
         * 是否单词结尾标识
         */
        private boolean isWord = false;

        TrieNode(Character ch, Map<Character, TrieNode> childrenMap) {
            this.ch = ch;
            this.childrenMap = childrenMap;
        }

        /**
         * 为当前的节点添加一个字符，也是子节点
         *
         * @param ch 字符
         * @return 新添加的子节点
         */
        public TrieNode addCharacter(Character ch) {
            if (childrenMap == null) {
                childrenMap = new HashMap<>();
            }
            // 先判断添加的字符是否已在子节点中
            TrieNode newNode = childrenMap.get(ch);
            if (newNode == null) {
                newNode = new TrieNode(ch, null);
                childrenMap.put(ch, newNode);
            }

            return newNode;
        }

        public boolean hasChildren(){
            return childrenMap != null && childrenMap.size() > 0;
        }

        public Character getCh() {
            return ch;
        }

        public void setCh(Character ch) {
            this.ch = ch;
        }

        public Map<Character, TrieNode> getChildrenMap() {
            return childrenMap;
        }

        public void setChildrenMap(Map<Character, TrieNode> childrenMap) {
            this.childrenMap = childrenMap;
        }

        public boolean isWord() {
            return isWord;
        }

        public void setWord(boolean word) {
            isWord = word;
        }

        @Override
        public String toString() {
            return "TrieNode{" +
                    "ch=" + ch +
                    ", childrenMap=" + childrenMap +
                    ", isWord=" + isWord +
                    '}';
        }
    }
}
