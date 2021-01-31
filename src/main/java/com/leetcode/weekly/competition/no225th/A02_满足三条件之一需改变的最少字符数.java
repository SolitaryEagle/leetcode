package com.leetcode.weekly.competition.no225th;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 覃国强
 * @date 2021-01-24 10:40
 */
public class A02_满足三条件之一需改变的最少字符数 {

  public static void main(String[] args) {
    Solution solution = new Solution();

    String a1 = "aba";
    String b1 = "caa";

    String a2 = "dabadd";
    String b2 = "cda";

    System.out.println(solution.minCharacters(a1, b1));
//    System.out.println(solution.minCharacters(a2, b2));

  }


  static
  class Solution {

    class Char implements Comparable<Char> {
      char value;
      int num;

      Char(char value, int num) {
        this.value = value;
        this.num = num;
      }

      @Override
      public int compareTo(Char o) {
        return o.num - num;
      }

      @Override
      public String toString() {
        return "Char{" +
            "value=" + value +
            ", num=" + num +
            '}';
      }
    }

    private List<Char> getCharList(String str) {
      char[] chars = str.toCharArray();
      Map<Character, Integer> map = new HashMap<>();
      for (char ch : chars) {
        if (map.containsKey(ch)) {
          map.put(ch, map.get(ch) + 1);
        } else {
          map.put(ch, 1);
        }
      }
      List<Char> result = new ArrayList<>();
      for (Map.Entry<Character, Integer> entry : map.entrySet()) {
        result.add(new Char(entry.getKey(), entry.getValue()));
      }
      Collections.sort(result);
      return result;
    }

    private int condition1(String a, String b, List<Char> aCharList, List<Char> bCharList) {

      // 大于 a 的所有值
      Char firstChar = aCharList.get(0);
      int result = getLessAndEquals(firstChar.value, bCharList);

      int aEdit = firstChar.num;

      for (int i = 1; i < aCharList.size(); ++i) {
        Char aChar = aCharList.get(i);
        int bEdit = getLessAndEquals(aChar.value, bCharList);
        int edit = aEdit + bEdit;
        result = Math.min(result, edit);
        aEdit = aChar.num;
      }

      return 0;
    }

    private int getLessAndEquals(char ch, List<Char> charList) {
      int result = 0;
      for (int i = charList.size() - 1; i >= 0; --i) {
        Char aChar = charList.get(i);
        if (aChar.value > ch) {
          return result;
        }
        result += aChar.num;
      }
      return result;
    }

    public int minCharacters(String a, String b) {

      List<Char> aCharList = getCharList(a);
      List<Char> bCharList = getCharList(b);

      // 条件一


      char[] aChars = a.toCharArray();
      char[] bChars = b.toCharArray();

      char aMinChar = getMinChar(aChars);
      char bMinChar = getMinChar(bChars);

      // 条件一
      int edit1 = 0;
      for (char ch : aChars) {
        if (ch >= bMinChar) {
          edit1++;
        }
      }

      // 条件二
      int edit2 = 0;
      for (char ch : bChars) {
        if (ch >= aMinChar) {
          edit2++;
        }
      }

      // 条件三
      int edit3 = 0;
      Map<Character, Integer> map = new HashMap<>();
      for (char ch : aChars) {
        if (map.containsKey(ch)) {
          map.put(ch, map.get(ch) + 1);
        } else {
          map.put(ch, 1);
        }
      }
      for (char ch : bChars) {
        if (map.containsKey(ch)) {
          map.put(ch, map.get(ch) + 1);
        } else {
          map.put(ch, 1);
        }
      }
      int mostChar = getMostChar(map);
      for (char ch : aChars) {
        if (ch != mostChar) {
          edit3++;
        }
      }
      for (char ch : bChars) {
        if (ch != mostChar) {
          edit3++;
        }
      }

      return Math.min(edit1, Math.min(edit2, edit3));
    }

    private char getMostChar(Map<Character, Integer> map) {
      int count = -1;
      char result = 0;
      for (Map.Entry<Character, Integer> entry : map.entrySet()) {
        if (entry.getValue() > count) {
          result = entry.getKey();
        }
      }
      return result;
    }


    private char getMinChar(char[] chars) {
      char ch = chars[0];
      for (int i = 1; i < chars.length; ++i) {
        if (ch > chars[i]) {
          ch = chars[i];
        }
      }
      return ch;
    }
  }

}
