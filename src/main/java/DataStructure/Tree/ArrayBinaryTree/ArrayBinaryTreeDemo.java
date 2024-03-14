package DataStructure.Tree.ArrayBinaryTree;

/**
 * 顺序存储二叉树Demo
 *
 * @author jianghan
 * @date 2019-10-10 15:25
 */
public class ArrayBinaryTreeDemo {
    public static void main(String[] args) {
        int[] treeArray = {1,2,3,4,5,6,7};
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(treeArray);
        ergodic(arrayBinaryTree);
    }

    /**
     * 遍历
     */
    private static void ergodic(ArrayBinaryTree arrayBinaryTree){
        arrayBinaryTree.preOrder();
        arrayBinaryTree.infixOrder();
        arrayBinaryTree.postOrder();
    }
}
