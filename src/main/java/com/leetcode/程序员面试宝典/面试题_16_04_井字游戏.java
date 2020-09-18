package com.leetcode.程序员面试宝典;

/**
 * @author 覃国强
 * @date 2020-09-18 08:12
 */
public class 面试题_16_04_井字游戏 {


    class Solution {

        public String tictactoe(String[] board) {
            if (board == null || board.length == 0) {
                return "Draw";
            }

            if (board.length == 1) {
                return board[0];
            }

            String result = "Draw";

            // 行
            for (String str : board) {
                if (str.charAt(0) == ' ') {
                    result = "Pending";
                }
                for (int i = 1; i < str.length(); ++i) {
                    if (str.charAt(i) == ' ') {
                        result = "Pending";
                    }
                    if (str.charAt(i) != str.charAt(i - 1)) {
                        break;
                    }
                    if (i == str.length() - 1 && str.charAt(i) != ' ') {
                        return String.valueOf(str.charAt(i));
                    }
                }
            }

            // 列
            for (int i = 0; i < board.length; ++i) {
                if (board[0].charAt(i) == ' ') {
                    result = "Pending";
                }
                for (int j = 1; j < board.length; ++j) {
                    if (board[j].charAt(i) == ' ') {
                        result = "Pending";
                    }
                    if (board[j].charAt(i) != board[j - 1].charAt(i)) {
                        break;
                    }
                    if (j == board.length - 1 && board[j].charAt(i) != ' ') {
                        return String.valueOf(board[j].charAt(i));
                    }
                }
            }

            // 正对角线
            if (board[0].charAt(0) == ' ') {
                result = "Pending";
            }
            for (int i = 1; i < board.length; ++i) {
                if (board[i].charAt(i) == ' ') {
                    result = "Pending";
                }
                if (board[i].charAt(i) != board[i - 1].charAt(i - 1)) {
                    break;
                }
                if (i == board.length - 1 && board[i].charAt(i) != ' ') {
                    return String.valueOf(board[i].charAt(i));
                }
            }

            // 反对角线
            if (board[0].charAt(board.length - 1) == ' ') {
                result = "Pending";
            }
            for (int i = 1, j = board.length - 2; i < board.length && j >= 0; ++i, --j) {
                if (board[i].charAt(j) == ' ') {
                    result = "Pending";
                }
                if (board[i].charAt(j) != board[i - 1].charAt(j + 1)) {
                    break;
                }
                if (i == board.length - 1 && board[i].charAt(j) != ' ') {
                    return String.valueOf(board[i].charAt(j));
                }
            }

            return result;
        }
    }

}
