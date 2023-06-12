class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class SubtreeFinder {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;  // Both trees are empty, considered a subtree
        }
        if (s == null || t == null) {
            return false; // One of the trees is empty, not considered a subtree
        }

        if (isSameTree(s, t)) {
            return true; // Found a match for the subtree
        }

        // Recursively search for the subtree in the left and right subtrees of the main tree
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true; // Both nodes are empty, considered the same
        }
        if (p == null || q == null) {
            return false; // One of the nodes is empty, not considered the same
        }

        // Check if the current nodes have the same value and recursively compare their left and right subtrees
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        // Create the main tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);

        // Create the subtree
        TreeNode subtree = new TreeNode(4);
        subtree.left = new TreeNode(1);
        subtree.right = new TreeNode(2);

        SubtreeFinder finder = new SubtreeFinder();
        boolean isSubtree = finder.isSubtree(root, subtree);
        System.out.println("Is subtree: " + isSubtree);
    }
}
