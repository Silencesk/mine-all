package com.mine.learn.algorithm;

import java.util.LinkedList;

/**
 * <p>
 * 字典树<br>
 * @see http://www.jianshu.com/p/1cf0e9907216?nomobile=yes
 * </p>
 * @author liutao
 * @create 2017-06-28 下午11:34
 */

public class Trie {
    private Node root;

    public Trie(){
        root = new Node(' ');
    }

    /**
     * 插入字典
     * @param word
     */
    public void insert(String word){
        if(search(word) == true) return;

        Node current = root;
        for(int i = 0; i < word.length(); i++){
            Node child = current.subNode(word.charAt(i));
            if(child != null){
                current = child;
            } else {
                current.childList.add(new Node(word.charAt(i)));
                current = current.subNode(word.charAt(i));
            }
            current.count++;
        }
        // Set isEnd to indicate end of the word
        current.isEnd = true;
    }

    /**
     * 搜索单词
     * @param word
     */
    public boolean search(String word){
        Node current = root;

        for(int i = 0; i < word.length(); i++){
            if(current.subNode(word.charAt(i)) == null)
                return false;
            else
                current = current.subNode(word.charAt(i));
        }
        /*
        * This means that a string exists, but make sure its
        * a word by checking its 'isEnd' flag
        */
        if (current.isEnd == true) return true;
        else return false;
    }

    class Node {
        Character ch; // the character in the node
        boolean isEnd; // whether the end of the words
        int count;  // the number of words sharing this character
        LinkedList<Node> childList; // the child list

        public Node(Character ch){
            childList = new LinkedList<Node>();
            isEnd = false;
            ch = ch;
            count = 0;
        }

        public Node subNode(char ch){
            if(childList != null){
                for(Node eachChild : childList){
                    if(eachChild.ch == ch){
                        return eachChild;
                    }
                }
            }
            return null;
        }


        public boolean isEnd() {
            return isEnd;
        }

        public void setEnd(boolean end) {
            isEnd = end;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public LinkedList<Node> getChildList() {
            return childList;
        }

        public void setChildList(LinkedList<Node> childList) {
            this.childList = childList;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("ball");
        trie.insert("balls");
        trie.insert("sense");

        // testing deletion
        System.out.println(trie.search("balls"));
        System.out.println(trie.search("ba"));
        System.out.println(trie.search("balls"));
        System.out.println(trie.search("ball"));
    }
}
