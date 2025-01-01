package java.com.interview.medium;

import com.interview.medium.RobotInAGrid;
import org.junit.Test;

public class RobotInAGridTest {

    @Test
    public void testPathWithObstacles() {
        RobotInAGrid robotInAGrid = new RobotInAGrid();
        int[][] obstacleGrid = new int[][] {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(robotInAGrid.pathWithObstacles(obstacleGrid));
    }
}
