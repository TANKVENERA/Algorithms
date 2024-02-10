package belski.algorithms.sort;

import java.util.ArrayList;
import java.util.List;

public class TreeSortAlgorithm {
    final List<Integer> result = new ArrayList<>();

    static class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    Node root;

    TreeSortAlgorithm() {
        root = null;
    }

    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {

        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        return root;
    }

    public void recordInAscendingOrder(Node root) {
        if (root != null) {
            recordInAscendingOrder(root.left);
            result.add(root.key);
            recordInAscendingOrder(root.right);
        }
    }

    void insertToPresortingOrder(int[] arrayTobeSorted) {
        for (final int j : arrayTobeSorted) {
            insert(j);
        }
    }
}
