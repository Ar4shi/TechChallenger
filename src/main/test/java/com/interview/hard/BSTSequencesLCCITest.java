package java.com.interview.hard;

import com.interview.hard.BSTSequencesLCCI;
import com.leetcode.TreeNode;
import org.junit.Test;

public class BSTSequencesLCCITest {

    @Test
    public void test() {
        BSTSequencesLCCI bstSequencesLCCI = new BSTSequencesLCCI();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        bstSequencesLCCI.BSTSequences(root);
    }
}
