package DataStructure.tree.rbtree;

public class RBNode<K extends Comparable<K>, V> {

    private boolean color;
    private K key;
    private V value;
    private RBNode<K, V> left;
    private RBNode<K, V> right;
    private RBNode<K, V> parent;

    public RBNode() {
    }

    public RBNode(boolean color, K key, V value, RBNode<K, V> left, RBNode<K, V> right, RBNode<K, V> parent) {
        this.color = color;
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }

    public boolean isColor() {
        return color;
    }
    public void setColor(boolean color) {
        this.color = color;
    }
    public K getKey() {
        return key;
    }
    public void setKey(K key) {
        this.key = key;
    }
    public V getValue() {
        return value;
    }
    public void setValue(V value) {
        this.value = value;
    }
    public RBNode<K, V> getLeft() {
        return left;
    }
    public void setLeft(RBNode<K, V> left) {
        this.left = left;
    }
    public RBNode<K, V> getRight() {
        return right;
    }
    public void setRight(RBNode<K, V> right) {
        this.right = right;
    }
    public RBNode<K, V> getParent() {
        return parent;
    }
    public void setParent(RBNode<K, V> parent) {
        this.parent = parent;
    }
}
