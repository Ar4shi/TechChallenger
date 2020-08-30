package DataStructure.Tree.ThreadedBinaryTree;

/**
 * 线索化二叉树结点
 *
 * @author jianghan
 * @date 2019-10-09 15:39
 */
public class ThreadedBinaryTreeNode {
    private int number;
    private String name;
    private ThreadedBinaryTreeNode leftNode;
    private ThreadedBinaryTreeNode rightNode;
    //规定type=1则指向线索化节点 type=0则指向二叉树的逻辑节点，默认为0
    private int leftType;
    private int rightType;

    public ThreadedBinaryTreeNode(int number, String name) {
        this.number = number;
        this.name = name;
    }

    /**
     * 前序遍历
     */
    public void preOrder(){
        System.out.println(this);
        if(this.leftNode!=null){
            this.leftNode.preOrder();
        }
        if(this.rightNode!=null){
            this.rightNode.preOrder();
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder(){
        if(this.leftNode!=null){
            this.leftNode.infixOrder();
        }
        System.out.println(this);
        if(this.rightNode!=null){
            this.rightNode.infixOrder();
        }
    }

    /**
     * 后序遍历
     */
    public void postOrder(){
        if(this.leftNode!=null){
            this.leftNode.postOrder();
        }
        if(this.rightNode!=null){
            this.rightNode.postOrder();
        }
        System.out.println(this);
    }


    /**
     * 前序查找
     */
    public ThreadedBinaryTreeNode preOrderSearch(int no){
        if(this.number==no){
            return this;
        }
        ThreadedBinaryTreeNode resultNode = null;
        if(this.leftNode!=null){
            resultNode = this.leftNode.preOrderSearch(no);
        }
        //找到对应的节点
        if(resultNode!=null){
            return resultNode;
        }
        if(this.rightNode!=null){
            resultNode = this.rightNode.preOrderSearch(no);
        }
        return resultNode;
    }

    /**
     * 中序查找
     */
    public ThreadedBinaryTreeNode infixOrderSearch(int no){
        ThreadedBinaryTreeNode resultNode = null;
        if(this.leftNode!=null){
            resultNode = this.leftNode.infixOrderSearch(no);
        }
        //找到对应的节点
        if(resultNode!=null){
            return resultNode;
        }

        if(this.number==no){
            return this;
        }

        if(this.rightNode!=null){
            resultNode = this.rightNode.infixOrderSearch(no);
        }
        return resultNode;
    }

    /**
     * 后序查找
     */
    public ThreadedBinaryTreeNode postOrderSearch(int no){
        ThreadedBinaryTreeNode resultNode = null;
        if(this.leftNode!=null){
            resultNode = this.leftNode.postOrderSearch(no);
        }
        //找到对应的节点
        if(resultNode!=null){
            return resultNode;
        }
        if(this.rightNode!=null){
            resultNode = this.rightNode.postOrderSearch(no);
        }
        //找到对应的节点
        if(resultNode!=null){
            return resultNode;
        }
        if(this.number==no){
            return this;
        }else {
            return null;
        }
    }

    /**
     * 删除节点
     */
    public void delNode(int no){
        if(this.leftNode!=null&&this.leftNode.getNumber()==no){
            this.leftNode = null;
            return;
        }
        if(this.rightNode!=null&&this.rightNode.getNumber()==no){
            this.rightNode = null;
            return;
        }
        if(this.leftNode!=null){
            this.leftNode.delNode(no);
        }
        if(this.rightNode!=null){
            this.rightNode.delNode(no);
        }
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ThreadedBinaryTreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(ThreadedBinaryTreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public ThreadedBinaryTreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(ThreadedBinaryTreeNode rightNode) {
        this.rightNode = rightNode;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    @Override
    public String toString() {
        return "BinaryTreeNode{" +
                "number=" + number +
                ", name='" + name + '\'' +
                '}';
    }
}
