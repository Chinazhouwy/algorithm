package com.Chinazhouwy.data_structures.trieTree;

import com.alibaba.fastjson.JSON;

import java.util.*;

public class Trie {

    private class Node{

        private TreeMap<Character, Node> nexts;

        private boolean isWordEnd;

        public Node(boolean isWordEnd){
            this.isWordEnd = false;
            nexts = new TreeMap<>();
        }

        public Node(){
            this(false);
        }
    }

    public Node root;

    private int size;

    public int getSize() {
        return size;
    }

    public Trie() {
        this.root = new Node();
        size = 0;
    }

    private boolean add(String word){

        Node cur = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(cur.nexts.get(c) == null)
                cur.nexts.put(c,new Node());
            cur = (Node)cur.nexts.get(c);
        }

        if(!cur.isWordEnd){
            cur.isWordEnd = true;
            size ++;
        }

        return true;
    }

    //以prefix为前缀的
    private boolean isPrefix(String prefix){
        Node cur = root;
        return loop(root,prefix) == null ? false : true;
    }

    // 查询单词word是否在Trie中
    private boolean search(String word){
        Node cur = loop(root,word);
        return cur == null ? false : cur.isWordEnd;
    }

    private Node loop(Node node,String word){
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(node.nexts.get(c) == null) {
                return null;
            }else{
                node =  (Node)node.nexts.get(c);
            }
        }
        return node;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this.root);
    }

    public static void main(String[] args) {
        String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        TreeSet<String> wordsSets = new TreeSet<>(Arrays.asList(words));
        Trie trie = new Trie();
        String longest = "";
        Arrays.sort(words);
        for(int i = 0;i < words.length;i++){
            if(words[i].length() == 1 || trie.search(
                                    words[i].substring(0,words[i].length()-1)) == true){
                trie.add(words[i]);
                longest = longest.length() >= words[i].length() ? longest : words[i];
            }
        }
        System.out.println(longest);
    }

}
