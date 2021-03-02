package com.leetcode.程序员面试宝典;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 覃国强
 * @date 2021-03-02 13:03
 */
public class 面试题_16_20_T9键盘 {

  public static void main(String[] args) {
    Solution solution = new Solution();
    String num = "8733";
    String[] words = {"tree", "used"};
    List<String> result = solution.getValidT9Words(num, words);
    System.out.println(result);
  }

  // 将 num 变成字典树，用 words 去查
  static
  class Solution {
    public List<String> getValidT9Words(String num, String[] words) {
      return null;
    }
  }

  // 超出内存限制
  // 将 words 变成字典树，用 num 去查
  static
  class Solution_1 {

    private static final Map<Character, char[]> num2Char = new HashMap<>();

    static {
      num2Char.put('2', new char[]{'a', 'b', 'c'});
      num2Char.put('3', new char[]{'d', 'e', 'f'});
      num2Char.put('4', new char[]{'g', 'h', 'i'});
      num2Char.put('5', new char[]{'j', 'k', 'l'});
      num2Char.put('6', new char[]{'m', 'n', 'o'});
      num2Char.put('7', new char[]{'p', 'q', 'r', 's'});
      num2Char.put('8', new char[]{'t', 'u', 'v'});
      num2Char.put('9', new char[]{'w', 'x', 'y', 'z'});
    }

    public List<String> getValidT9Words(String num, String[] words) {
      List<String> result = new ArrayList<>();
      if (num == null || num.length() == 0 || words == null || words.length == 0) {
        return result;
      }

      TrieNode root = generateTrieNode(words);

      List<TrieNode> cur = new ArrayList<>();
      cur.add(root);
      List<TrieNode> next = new ArrayList<>();

      char[] numChars = num.toCharArray();
      for (char numChar : numChars) {
        char[] chars = num2Char.get(numChar);
        for (TrieNode node : cur) {
          for (char ch : chars) {
            if (node.children.containsKey(ch)) {
              next.add(node.children.get(ch));
            }
          }
        }
        cur = next;
        next = new ArrayList<>();
      }

      for (TrieNode node : cur) {
        result.add(node.prefix);
      }

      return result;
    }

    private TrieNode generateTrieNode(String[] words) {
      TrieNode root = new TrieNode();
      for (String word : words) {
        char[] chars = word.toCharArray();
        TrieNode parent = root;
        for (int i = 0; i < chars.length; ++i) {
          if (parent.children.containsKey(chars[i])) {
            parent = parent.children.get(chars[i]);
          } else {
            TrieNode tmp = new TrieNode(chars[i]);
            tmp.prefix = parent.prefix + chars[i];
            parent.children.put(chars[i], tmp);
            parent = tmp;
          }
          if (i == chars.length - 1) {
            parent.endFlag = true;
          }
        }
      }
      return root;
    }

    static class TrieNode {

      /**
       * 当前节点字符
       */
      char value;

      /**
       * 截止到当前节点组成的单词
       */
      String prefix = "";

      /**
       * 当前节点是否为单词末尾
       */
      boolean endFlag;

      /**
       * 子节点
       */
      Map<Character, TrieNode> children = new HashMap<>();

      TrieNode() {

      }

      TrieNode(char value) {
        this.value = value;
      }

    }
  }

}
