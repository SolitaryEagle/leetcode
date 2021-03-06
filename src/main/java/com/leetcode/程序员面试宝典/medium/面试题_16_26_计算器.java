package com.leetcode.程序员面试宝典.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author 覃国强
 * @date 2021-03-06 19:06
 */
public class 面试题_16_26_计算器 {

  public static void main(String[] args) {
    Solution solution = new Solution();
    String s = "1*2-3/4+5*6-7*8+9/10";
    System.out.println(solution.calculate(s));
  }

  static
  class Solution {

    public int calculate(String s) {
      return 0;
    }


    private List<String> reversePolishNotation(String exp) {

      List<String> result = new ArrayList<>();
      Deque<Character> opStack = new ArrayDeque<>();

      int num = 0;

      for (char ch : exp.toCharArray()) {
        if (ch == ' ') {
          continue;
        }
        if (Character.isDigit(ch)) {
          num += num * 10 + (ch - '0');
        } else {
          result.add(String.valueOf(num));
          num = 0;

          if (opStack.isEmpty() || ch == '(') {
            opStack.push(ch);
          } else {
            if (ch == ')') {
              while (!opStack.isEmpty() && opStack.peek() != '(') {
                result.add(String.valueOf(opStack.pop()));
              }
              opStack.pop();
            } else {
              while (!opStack.isEmpty() && opStack.peek() != '('
                  && opCompare(ch, opStack.peek()) <= 0) {
                result.add(String.valueOf(opStack.pop()));
              }
              opStack.push(ch);
            }
          }
        }
      }
      while (!opStack.isEmpty()) {
        result.add(String.valueOf(opStack.pop()));
      }
      return result;
    }

    private int opCompare(char op1, char op2) {
      return Integer.compare(op2int(op1), op2int(op2));
    }

    private int op2int(char op) {
      if (op == '+' || op == '-') {
        return 0;
      } else {
        return 1;
      }
    }

  }

  static
  class Solution_1 {

    public int calculate(String s) {
      if (s == null || s.trim().length() == 0) {
        return 0;
      }

      Deque<Integer> numStack = new ArrayDeque<>();
      Deque<Character> opStack = new ArrayDeque<>();

      StringBuilder sb = new StringBuilder();
      for (char ch : s.toCharArray()) {
        if (ch == ' ') {
          continue;
        }
        if (ch >= '0' && ch <= '9') {
          sb.append(ch);
        } else {
          if (sb.length() != 0) {
            numStack.push(Integer.parseInt(sb.toString()));
            sb = new StringBuilder();
          }

          if (!opStack.isEmpty()) {
            if (isLowerOp(ch)) {
              // 当前是 + -
              while (!opStack.isEmpty()) {
                calculate(numStack, opStack);
              }
            } else {
              // 当前是 * / && 栈顶是  * /
              while (!opStack.isEmpty() && isHighOp(opStack.peek())) {
                calculate(numStack, opStack);
              }
            }
          }
          opStack.push(ch);
        }
      }

      numStack.push(Integer.parseInt(sb.toString()));

      while (!opStack.isEmpty()) {
        calculate(numStack, opStack);
      }

      return numStack.pop();
    }

    private void calculate(Deque<Integer> numStack, Deque<Character> opStack) {
      int secondNum = numStack.pop();
      int firstNum = numStack.pop();
      char op = opStack.pop();
      int result;
      switch (op) {
        case '+':
          result = firstNum + secondNum;
          break;
        case '-':
          result = firstNum - secondNum;
          break;
        case '*':
          result = firstNum * secondNum;
          break;
        default:
          result = firstNum / secondNum;
          break;
      }
      numStack.push(result);
    }

    private boolean isLowerOp(char ch) {
      return ch == '+' || ch == '-';
    }

    private boolean isHighOp(char ch) {
      return ch == '*' || ch == '/';
    }
  }

}
