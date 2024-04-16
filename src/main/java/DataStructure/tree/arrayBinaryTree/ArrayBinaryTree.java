package DataStructure.tree.arrayBinaryTree;

/**
 * 顺序存储二叉树
 *
 * @author jianghan
 * @date 2019-10-10 14:51
 */
public class ArrayBinaryTree {
    private int[] treeArray;

    public ArrayBinaryTree(int[] treeArray) {
        this.treeArray = treeArray;
    }

    /**
     * 前序遍历
     */
    public void preOrder(){
        System.out.println("前序遍历");
        this.preOrder(0);
    }

    /**
     * 中序遍历
     */
    public void infixOrder(){
        System.out.println("中序遍历");
        this.infixOrder(0);
    }

    /**
     * 后序遍历
     */
    public void postOrder(){
        System.out.println("后序遍历");
        this.postOrder(0);
    }

    private void preOrder(int index){
        if(treeArray==null||treeArray.length==0){
            System.out.println("空数组，无法进行二叉树遍历");
        }
        System.out.println(treeArray[index]);
        //遍历左子树
        if(2*index+1<treeArray.length){
            this.preOrder(2*index+1);
        }
        //遍历右子树
        if(2*index+2<treeArray.length){
            this.preOrder(2*index+2);
        }
    }

    private void infixOrder(int index){
        if(treeArray==null||treeArray.length==0){
            System.out.println("空数组，无法进行二叉树遍历");
        }
        //遍历左子树
        if(2*index+1<treeArray.length){
            this.infixOrder(2*index+1);
        }
        System.out.println(treeArray[index]);
        //遍历右子树
        if(2*index+2<treeArray.length){
            this.infixOrder(2*index+2);
        }
    }

    private void postOrder(int index){
        if(treeArray==null||treeArray.length==0){
            System.out.println("空数组，无法进行二叉树遍历");
        }
        //遍历左子树
        if(2*index+1<treeArray.length){
            this.postOrder(2*index+1);
        }
        //遍历右子树
        if(2*index+2<treeArray.length){
            this.postOrder(2*index+2);
        }
        System.out.println(treeArray[index]);
    }

    public void setTreeArray(int[] treeArray) {
        this.treeArray = treeArray;
    }
}
