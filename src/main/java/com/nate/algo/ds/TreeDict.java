package com.nate.algo.ds;

/**
 * A binary search tree.
 */
public class TreeDict<K, V> implements IDictionary<K, V> {

    private TreeNode<K, V> root = null;
    private int size = 0;

    public TreeDict() {

    }

    public void clear() {
        root = null;
        size = 0;
    }

    public V get(K key) {
        TreeNode<K, V> node = getNode(key);
        return (node == null ? null : node.value);
    }

    public void put(K key, V value) {
        root = put(key, value, root, null);
    }

    private TreeNode<K, V> put(K key, V value, TreeNode<K, V> tree, TreeNode<K, V> parent) {
        if (tree == null) {
            tree = new TreeNode<K, V>(key, value, parent);
            size++;
            return tree;
        }

        Comparable<? super K> k = (Comparable<? super K>) key;
        int cmp = k.compareTo(tree.key);
        if (cmp < 0) {
            tree.left = put(key, value, tree.left, tree);
        } else if (cmp > 0) {
            tree.right = put(key, value, tree.right, tree);
        } else {
            tree.value = value;
        }

        return tree;
    }

    public void remove(K key) {
        TreeNode<K, V> node = getNode(key);

        if (node == null)
            return;

        if (node.left == null && node.right == null) {
            remove(node);
        } else if (node.left == null || node.right == null) {
            TreeNode<K, V> t = (node.left == null) ? node.right : node.left;
            node.parent = t.parent;
            node.left = t.left;
            node.right = t.right;
            node.value = t.value;
        } else {
            // has both children
            TreeNode<K, V> suc = successor(node);
            node.key = suc.key;
            node.value = suc.value;
            remove(suc);
        }
    }

    private void remove(TreeNode<K, V> node) {
        if (node == null) {
            return;
        }

        if (node.parent == null) {
            root = null;
            return;
        }

        if (node == node.parent.left) {
            node.parent.left = null;
        } else if (node == node.parent.right) {
            node.parent.right = null;
        }
    }

    private TreeNode<K, V> successor(TreeNode<K, V> node) {
        if (node == null || node.right == null)
            return null;
        TreeNode<K, V> suc = node.right;
        while (suc.left != null) {
            suc = suc.left;
        }
        return suc;
    }

    private TreeNode<K, V> getNode(K key) {
        Comparable<? super K> k = (Comparable<? super K>) key;
        TreeNode<K, V> p = root;
        while (p != null) {
            int cmp = k.compareTo(p.key);
            if (cmp < 0) {
                p = p.left;
            } else if (cmp > 0) {
                p = p.right;
            } else {
                return p;
            }
        }
        return null;
    }

    public int size() {
        return size;
    }

    public boolean empty() {
        return size == 0;
    }

    private class TreeNode<K, V> {
        K key;
        V value;
        TreeNode<K, V> left = null;
        TreeNode<K, V> right = null;
        TreeNode<K, V> parent;

        TreeNode(K key, V value, TreeNode<K, V> parent) {
            this.key = key;
            this.value = value;
            this.parent = parent;
        }
    }
}
