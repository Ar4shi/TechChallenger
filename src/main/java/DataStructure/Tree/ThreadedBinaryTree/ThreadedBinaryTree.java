package DataStructure.Tree.ThreadedBinaryTree;

/**
 * 线索化二叉树
 *
 * @author jianghan
 * @date 2019-10-09 15:56
 */
public class ThreadedBinaryTree {
    private ThreadedBinaryTreeNode root;
    //前驱节点
    private ThreadedBinaryTreeNode pre;
    public void setRoot(ThreadedBinaryTreeNode binaryTreeNode){
        this.root = binaryTreeNode;
    }

    public void threadedNode(){
        this.threadedNode(root);
    }

    /**
     * 中序遍历方式-线索化二叉树
     */
    private void threadedNode(ThreadedBinaryTreeNode binaryTreeNode){
        if(binaryTreeNode==null){
            return;
        }
        /* 1）线索化左子树 */
        threadedNode(binaryTreeNode.getLeftNode());
        /* 2）线索化当前节点 */
             /* 2.1)线索化左指针 */
        if(binaryTreeNode.getLeftNode()==null){
            binaryTreeNode.setLeftNode(pre);
            binaryTreeNode.setLeftType(1);
        }
            /* 2.2)线索化右指针  此处由递归的下一阶段获取到pre节点来线索化*/
        if(pre!=null&&pre.getRightNode()==null){
            pre.setRightNode(binaryTreeNode);
            pre.setRightType(1);
        }
            /* 2.3)修改上个节点的指针 */
        pre = binaryTreeNode;
        /* 3）线索化右子树 */
        threadedNode(binaryTreeNode.getRightNode());
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
        ThreadedBinaryTreeNode resultNode = null;
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
        ThreadedBinaryTreeNode resultNode = null;
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
        ThreadedBinaryTreeNode resultNode = null;
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
