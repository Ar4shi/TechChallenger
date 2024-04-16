package DataStructure.tree.binaryTree;

/**
 * 二叉树结点
 *
 * @author jianghan
 * @date 2019-10-09 15:39
 */
public class BinaryTreeNode {
    private int number;
    private String name;
    private BinaryTreeNode leftNode;
    private BinaryTreeNode rightNode;

    public BinaryTreeNode(int number, String name) {
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
    public BinaryTreeNode preOrderSearch(int no){
        if(this.number==no){
            return this;
        }
        BinaryTreeNode resultNode = null;
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
    public BinaryTreeNode infixOrderSearch(int no){
        BinaryTreeNode resultNode = null;
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
    public BinaryTreeNode postOrderSearch(int no){
        BinaryTreeNode resultNode = null;
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

    public BinaryTreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(BinaryTreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public BinaryTreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(BinaryTreeNode rightNode) {
        this.rightNode = rightNode;
    }

    @Override
    public String toString() {
        return "BinaryTreeNode{" +
                "number=" + number +
                ", name='" + name + '\'' +
                '}';
    }
}
