package com.interview.medium;

/**
 * 已知一个由像素点组成的单色屏幕，每行均有 w 个像素点，所有像素点初始为 0，左上角位置为 (0,0)。
 * 现将每行的像素点按照「每 32 个像素点」为一组存放在一个 int 中，再依次存入长度为 length 的一维数组中。
 * 我们将在屏幕上绘制一条从点 (x1,y) 到点 (x2,y) 的直线（即像素点修改为 1），请返回绘制过后的数组。
 * <p>
 * 注意：
 * 用例保证屏幕宽度 w 可被 32 整除（即一个 int 不会分布在两行上）
 * <p>
 * 示例1:
 * 输入：length = 1, w = 32, x1 = 30, x2 = 31, y = 0
 * 输出：[3]
 * 解释：在第 0 行的第 30 位到第 31 位画一条直线，屏幕二进制形式表示为 [00000000000000000000000000000011]，因此返回 [3]
 * <p>
 * 示例2:
 * 输入：length = 3, w = 96, x1 = 0, x2 = 95, y = 0
 * 输出：[-1, -1, -1]
 * 解释：由于二进制 11111111111111111111111111111111 的 int 类型代表 -1，因此返回 [-1,-1,-1]
 */
public class DrawLine {


    public int[] drawLine(int length, int w, int x1, int x2, int y) {
        int[] ans = new int[length];
        int size = length * 32;
        int left = y * w + x1;
        int right = y * w + x2;
        int num = 0;
        for (int i = 0; i < size; i++) {
            int power = 31 - i % 32;
            // 画线的区域，bit为1
            if (i >= left && i <= right) {
                num += 1 << power;
            }
            // 非画线区域，bit为0
            else {
                num += 0 << power;
            }
            // 每32位一个数字，0 ~ 31
            if (i % 32 == 31) {
                ans[i / 32] = num;
                num = 0;
            }
        }
        return ans;
    }

    /**
     * 这个写的有点问题，没时间debug了，先放着
     */
    public int[] drawLine2(int length, int w, int x1, int x2, int y) {
        int[] result = new int[length];
        // 数组的起始点
        int start = w / 32 * y;
        // 相对于启示点的偏移量
        int offset1 = x1 / 32;
        int offset2 = x2 / 32;
        for (int i = start + offset1; i <= start + offset2; i++) {
            // 中间的都是-1
            if (i > start + offset1 && i < start + offset2) {
                result[i] = -1;
                continue;
            }
            // 左侧端点之后每一位都置1
            int left = 0;
            if (i == start + offset1) {
                int offset = (32 - (x1 % 32)) - 1;
                for (int j = 0; j <= offset; j++) {
                    left = left | (1 << j);
                }
            }
            // 右侧端点之后每一位都置0
            int right = -1;
            if (i == start + offset2) {
                int offset = (32 - (x2 % 32)) - 1;
                for (int j = 0; j < offset; j++) {
                    right = ~(1 << j);
                }
            }
            if (start + offset2 == start + offset1) {
                result[i] = left & right;
            } else {
                if (i == start + offset1) {
                    result[i] = left;
                } else {
                    result[i] = right;
                }
            }
        }
        return result;
    }
}
