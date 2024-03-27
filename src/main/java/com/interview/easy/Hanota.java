package com.interview.easy;

import java.util.List;

/**
 * 在经典汉诺塔问题中，有 3 根柱子及 N 个不同大小的穿孔圆盘，盘子可以滑入任意一根柱子。一开始，所有盘子自上而下按升序依次套在第一根柱子上(即每一个盘子只能放在更大的盘子上面)。移动圆盘时受到以下限制:
 * (1) 每次只能移动一个盘子;
 * (2) 盘子只能从柱子顶端滑出移到下一根柱子;
 * (3) 盘子只能叠在比它大的盘子上。
 * <p>
 * 请编写程序，用栈将所有盘子从第一根柱子移到最后一根柱子。
 * 你需要原地修改栈。
 * <p>
 * 示例1:
 * 输入：A = [2, 1, 0], B = [], C = []
 * 输出：C = [2, 1, 0]
 * <p>
 * 示例2:
 * 输入：A = [1, 0], B = [], C = []
 * 输出：C = [1, 0]
 * <p>
 * 提示:
 * A中盘子的数目不大于14个
 */
public class Hanota {

    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        move(A, B, C, A.size());
    }

    /**
     * @param A     源柱子
     * @param B     辅助柱子
     * @param C     目标柱子
     * @param count 要移动的剩余盘子的数量
     */
    private void move(List<Integer> A, List<Integer> B, List<Integer> C, int count) {
        // 最后一个盘子,递归的出口,直接从A移动到C
        if (count == 1) {
            C.add(A.remove(A.size() - 1));
            return;
        }
        // 此时C变成了辅助柱子,我们需要把N-1个盘子从A移动到B,但是由于盘子需要从小到大移动,所以这是个子递归的过程
        move(A, C, B, count - 1);
        // 将最大的盘子(最后一个)从A移动到C
        C.add(A.remove(A.size() - 1));
        // 此时A和B的角色互换了,需要把盘子从B移动到C
        move(B, A, C, count - 1);
    }
}
