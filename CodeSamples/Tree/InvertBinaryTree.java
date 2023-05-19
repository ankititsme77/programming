class Solution {


    public TreeNode invertBinaryTree(TreeNode root){


        return invertTree(root);

    }

    private TreeNode invertTree(TreeNode root){

        if(root == null)
            return null;

        TreeNode tmp = root.left
        root.left = root.right
        root.right = tmp

        invertTree(root.left);

        invertTree(root.right);


        return root;




    }


}