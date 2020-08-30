package DataStructure.Tree.ThreadedBinaryTree;

/**
 * 线索化二叉树Demo
 *
 * @author jianghan
 * @date 2019-10-10 16:30
 */
public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        ThreadedBinaryTreeNode root = new ThreadedBinaryTreeNode(1,"1");
        ThreadedBinaryTreeNode node2 = new ThreadedBinaryTreeNode(3,"3");
        ThreadedBinaryTreeNode node3 = new ThreadedBinaryTreeNode(6,"6");
        ThreadedBinaryTreeNode node4 = new ThreadedBinaryTreeNode(8,"8");
        ThreadedBinaryTreeNode node5 = new ThreadedBinaryTreeNode(10,"10");
        ThreadedBinaryTreeNode node6 = new ThreadedBinaryTreeNode(14,"14");

        //手动创建二叉树
        root.setLeftNode(node2);
        root.setRightNode(node3);
        node2.setLeftNode(node4);
        node2.setRightNode(node5);
        node3.setLeftNode(node6);

        //测试线索化
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
        threadedBinaryTree.threadedNode();

        //测试
        ThreadedBinaryTreeNode leftNode = node5.getLeftNode();
        ThreadedBinaryTreeNode rightNode = node5.getRightNode();
        System.out.println("10号节点的前驱节点是： "+leftNode.toString());
        System.out.println("10号节点的后继节点是： "+rightNode.toString());
    }
}
