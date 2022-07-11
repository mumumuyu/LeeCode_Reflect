package 递归;

/**
 * @Description: 使用递归找到树的最深深度
 * @author: LGD
 * @date:2022/4/29 14:00
 */
public class Tree_Test {
    public static void main(String[] args) {
        TreeNode root = init();
        int i = maxHeight(root);
        System.out.println(i);
    }

    public static TreeNode init(){
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode3 = new TreeNode(3, treeNode7, null);
        TreeNode treeNode4 = new TreeNode(4, null, null);
        TreeNode treeNode5 = new TreeNode(5, null, null);
        TreeNode treeNode6 = new TreeNode(6, null, null);
        TreeNode treeNode1 = new TreeNode(1, treeNode3, treeNode4);
        TreeNode treeNode2 = new TreeNode(2, treeNode5, treeNode6);
        TreeNode treeNode0 = new TreeNode(0, treeNode1, treeNode2);
        return  treeNode0;
    }
    public static int maxHeight(TreeNode root){
        return root==null? 0:Math.max(maxHeight(root.left),maxHeight(root.right))+1;
    }

/*    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return  true;
        }
        if(root)
    }*/
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
  }
