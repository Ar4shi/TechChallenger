package DataStructure.Tree.BinaryTree;

/**
 * 二叉树
 *
 * @author jianghanh
 * @date 2019-10-09 15:56
 */
public class BinaryTree {
    private BinaryTreeNode root;
    public void setRoot(BinaryTreeNode binaryTreeNode){
        this.root = binaryTreeNode;
    }

    /**
     * 前序遍历
     */
    public void preOrder(){
        if(this.root!=null){
            this.root.preOrder();
        }else {
            System.out.println("根节点为空，无法进行前序遍历");
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder(){
        if(this.root!=null){
            this.root.infixOrder();
        }else {
            System.out.println("根节点为空，无法进行中序遍历");
        }
    }

    /**
     * 后序遍历
     */
    public void postOrder(){
        if(this.root!=null){
            this.root.postOrder();
        }else {
            System.out.println("根节点为空，无法进行后序遍历");
        }
    }

    /**
     * 前序查找
     */
    public void preOrderSearch(int no){
        BinaryTreeNode resultNode = null;
        if(this.root!=null){
            resultNode = this.root.preOrderSearch(no);
        }else {
            System.out.println("根节点为空，无法进行前序遍历");
        }
        if(resultNode != null){
            System.out.println("找到该节点： "+resultNode.toString());
        }else{
            System.out.println("未找到该节点");
        }
    }

    /**
     * 中序查找
     */
    public void infixOrderSearch(int no){
        BinaryTreeNode resultNode = null;
        if(this.root!=null){
            resultNode = this.root.infixOrderSearch(no);
        }else {
            System.out.println("根节点为空，无法进行中序遍历");
        }
        if(resultNode != null){
            System.out.println("找到该节点： "+resultNode.toString());
        }else{
            System.out.println("未找到该节点");
        }
    }

    /**
     * 后序查找
     */
    public void postOrderSearch(int no){
        BinaryTreeNode resultNode = null;
        if(this.root!=null){
            resultNode = this.root.postOrderSearch(no);
        }else {
            System.out.println("根节点为空，无法进行后序遍历");
        }
        if(resultNode != null){
            System.out.println("找到该节点： "+resultNode.toString());
        }else{
            System.out.println("未找到该节点");
        }
    }

    /**
     * 删除节点
     */
    public void delNode(int no){
        if(this.root!=null){
            this.root.delNode(no);
        }else{
            System.out.println("根节点为空，删除对应节点");
        }
    }
}
