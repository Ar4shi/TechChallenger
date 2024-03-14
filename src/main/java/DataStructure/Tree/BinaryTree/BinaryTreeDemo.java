package DataStructure.Tree.BinaryTree;

/**
 * 二叉树demo
 *
 * @author jianghan
 * @date 2019-10-09 16:02
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        BinaryTreeNode root = new BinaryTreeNode(1,"师傅");
        BinaryTreeNode node2 = new BinaryTreeNode(2,"悟空");
        BinaryTreeNode node3 = new BinaryTreeNode(3,"八戒");
        BinaryTreeNode node4 = new BinaryTreeNode(4,"沙僧");
        BinaryTreeNode node5 = new BinaryTreeNode(5,"小白龙");

        //先手动创建二叉树，后续会用递归创建
        root.setLeftNode(node2);
        root.setRightNode(node3);
        node3.setLeftNode(node5);
        node3.setRightNode(node4);
        binaryTree.setRoot(root);

        //测试
        ergodic(binaryTree);
        search(binaryTree,3);
        delete(binaryTree,3);
        ergodic(binaryTree);
    }

    /**
     * 遍历
     */
    private static void ergodic (BinaryTree binaryTree){
        System.out.println("前序遍历");
        binaryTree.preOrder();
        System.out.println("中序遍历");
        binaryTree.infixOrder();
        System.out.println("后序遍历");
        binaryTree.postOrder();
    }

    /**
     * 查找
     */
    private static void search (BinaryTree binaryTree,int i){
        System.out.println("前序查找");
        binaryTree.preOrderSearch(i);
        System.out.println("中序查找");
        binaryTree.infixOrderSearch(i);
        System.out.println("后序查找");
        binaryTree.postOrderSearch(i);
    }

    /**
     * 删除
     */
    private static void delete(BinaryTree binaryTree,int i){
        System.out.println("正在删除 "+i+" 节点");
        binaryTree.delNode(i);
    }
}
