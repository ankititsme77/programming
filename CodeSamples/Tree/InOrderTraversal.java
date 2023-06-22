/* Definition for a binary tree node.
        * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        inOrderTreeTraversal(res,root);

        return res;

    }

    private void inOrderTreeTraversal(List<Integer> res, TreeNode root){

        if (root == null){
            //res.add(null);
            return;
        }


        inOrderTreeTraversal(res,root.left);

        res.add(root.val);

        inOrderTreeTraversal(res,root.right);

    }

}