package com.leetcode.程序员面试宝典;

import com.leetcode.程序员面试宝典.面试题_16_20_T9键盘.Solution.TrieNode;
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

    String[] words = {"tree", "used"};
    TrieNode trieNode = solution.generateTrieNode(words);
    System.out.println(trieNode);
  }


  static
  class Solution {

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

      List<Map<String, TrieNode>> cur = new ArrayList<>();
      Map<String, TrieNode> rootMap = new HashMap<>();
      rootMap.put("", root);
      cur.add(rootMap);
      List<TrieNode> next = new ArrayList<>();

      char[] numChars = num.toCharArray();
      for (int i = 0; i < numChars.length; ++i) {
        char[] chars = num2Char.get(numChars[i]);
        for (Map<String, TrieNode> map : cur) {

        }

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

    class TrieNode {

      /**
       * 当前节点字符
       */
      char value;

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
