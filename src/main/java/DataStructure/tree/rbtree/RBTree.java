package DataStructure.tree.rbtree;

/**
 * 1、创建红黑树，定义颜色
 * 2、创建节点 RBNode
 * 3、定义辅助方法
 *
 * @param <K>
 * @param <V>
 */
public class RBTree<K extends Comparable<K>, V> {

    public static final boolean RED = true;

    public static final boolean BLACK = false;

    private RBNode<K, V> root;

    /**
     * 获取当前节点的父节点
     */
    public RBNode<K, V> parentOf(RBNode<K, V> rbNode) {
        if (rbNode != null) {
            return rbNode.getParent();
        } else {
            return null;
        }
    }

    private boolean isRed(RBNode<K, V> rbNode) {
        if (rbNode != null) {
            return rbNode.isColor();
        }
        return false;
    }

    private boolean isBlack(RBNode<K, V> rbNode) {
        if (rbNode != null) {
            return !rbNode.isColor();
        }
        return false;
    }

    private void setRed(RBNode<K, V> rbNode) {
        if (rbNode != null) {
            rbNode.setColor(RED);
        }
    }

    private void setBlack(RBNode<K, V> rbNode) {
        if (rbNode != null) {
            rbNode.setColor(BLACK);
        }
    }

    private void inOrderPrint() {
        inOrderPrint(root);
    }

    private void inOrderPrint(RBNode<K, V> node) {
        if (node != null) {
            inOrderPrint(node.getLeft());
            System.out.println(node.getKey() + " | " + node.getValue());
            inOrderPrint(node.getRight());
        }
    }
}
