package com.interview.easy;

/**
 * 配对交换。编写程序，交换某个整数的奇数位和偶数位，尽量使用较少的指令（也就是说，位0与位1交换，位2与位3交换，以此类推）。
 * <p>
 * 示例1:
 * 输入：num = 2（或者0b10）
 * 输出 1 (或者 0b01)
 * <p>
 * 示例2:
 * 输入：num = 3(0b11)
 * 输出：3
 * <p>
 * 提示:
 * num的范围在[0, 2^30 - 1]之间，不会发生整数溢出。
 */
public class Exchange {

    public int exchangeBits(int num) {
        for (int i = 0; i < 30; i = i + 2) {
            // 获取对应数位的值
            int num1 = num & (1 << i);
            int num2 = num & (1 << (i + 1));
            // 对应的数位置0
            num = num & (~(1 << i));
            num = num & (~(1 << (i + 1)));
            // 交换数位值
            num |= num1 << 1;
            num |= num2 >> 1;
        }
        return num;
    }
}
