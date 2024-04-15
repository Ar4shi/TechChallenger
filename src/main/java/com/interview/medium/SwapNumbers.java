package com.interview.medium;

/**
 * 编写一个函数，不用临时变量，直接交换numbers = [a, b]中a与b的值。
 * <p>
 * 示例：
 * <p>
 * 输入: numbers = [1,2]
 * <p>
 * 输出: [2,1]
 * <p>
 * 提示：
 * <p>
 * numbers.length == 2
 * <p>
 * -2147483647 <= numbers[i] <= 2147483647
 */
public class SwapNumbers {

    public int[] swapNumbers(int[] numbers) {
        // a = a ^ b
        numbers[0] = numbers[0] ^ numbers[1];
        // b = a ^ b = (a ^ b) ^ b = a ^ (b ^ b) = a ^ 0 = a
        numbers[1] = numbers[0] ^ numbers[1];
        // a = a ^ b = (a ^ b) ^ a = b ^ (a ^ a) = b ^ 0 = b
        numbers[0] = numbers[0] ^ numbers[1];
        return numbers;
    }
}
