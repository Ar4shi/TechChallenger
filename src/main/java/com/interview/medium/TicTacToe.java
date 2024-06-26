package com.interview.medium;

/**
 * 设计一个算法，判断玩家是否赢了井字游戏。输入是一个 N x N 的数组棋盘，由字符" "，"X"和"O"组成，其中字符" "代表一个空位。
 * <p>
 * 以下是井字游戏的规则：
 * <p>
 * 玩家轮流将字符放入空位（" "）中。
 * <p>
 * 第一个玩家总是放字符"O"，且第二个玩家总是放字符"X"。
 * <p>
 * "X"和"O"只允许放置在空位中，不允许对已放有字符的位置进行填充。
 * <p>
 * 当有N个相同（且非空）的字符填充任何行、列或对角线时，游戏结束，对应该字符的玩家获胜。
 * <p>
 * 当所有位置非空时，也算为游戏结束。
 * <p>
 * 如果游戏结束，玩家不允许再放置字符。
 * <p>
 * 如果游戏存在获胜者，就返回该游戏的获胜者使用的字符（"X"或"O"）；如果游戏以平局结束，则返回 "Draw"；如果仍会有行动（游戏未结束），则返回 "Pending"。
 * <p>
 * 示例 1：
 * <p>
 * 输入： board = ["O X"," XO","X O"]
 * <p>
 * 输出： "X"
 * <p>
 * 示例 2：
 * <p>
 * 输入： board = ["OOX","XXO","OXO"]
 * <p>
 * 输出： "Draw"
 * <p>
 * 解释： 没有玩家获胜且不存在空位
 * <p>
 * 示例 3：
 * <p>
 * 输入： board = ["OOX","XXO","OX "]
 * <p>
 * 输出： "Pending"
 * <p>
 * 解释： 没有玩家获胜且仍存在空位
 * <p>
 * 提示：
 * <p>
 * 1 <= board.length == board[i].length <= 100
 * <p>
 * 输入一定遵循井字棋规则
 */
public class TicTacToe {

    public String tictactoe(String[] board) {
        return "";
    }
}
