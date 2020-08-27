package com.leetcode.Solution601_700.Solution651_660;

/**
 * 机器人能否返回原点
 *
 * @author jianghanh
 * @date 2020-08-28 01:20
 */
public class RobotReturnToOrigin_657 {
    private static final char UP = 'U';
    private static final char DOWN = 'D';
    private static final char LEFT = 'L';
    private static final char RIGHT = 'R';

    public boolean judgeCircle(String moves) {
        int broadwise = 0;
        int direction = 0;
        for (int i = 0; i < moves.length(); i++) {
            char order = moves.charAt(i);
            if (UP == order) {
                direction++;
            }
            if (DOWN == order) {
                direction--;
            }
            if (RIGHT == order) {
                broadwise++;
            }
            if (LEFT == order) {
                broadwise--;
            }
        }
        return broadwise == 0 && direction == 0;
    }
}
