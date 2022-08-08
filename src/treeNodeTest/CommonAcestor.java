package treeNodeTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:

 * @author: LGD
 * @date:2022/8/8 14:43
 */
public class CommonAcestor {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.buildTree(new int[]{6, 2, 0, 4, 3, 5, 8, 7, 9}, new int[]{0, 2, 3, 4, 5, 6, 7, 8, 9});
        System.out.println(lowestCommonAncestor(treeNode, new TreeNode(2), new TreeNode(4)).val); //2

        TreeNode treeNode2 = TreeNode.buildTree(new int[]{3,5,6,2,7,4,1,0,8}, new int[]{6,5,7,2,4,3,0,1,8});
        System.out.println(new CommonAcestor().lowestCommonAncestor2(treeNode2, new TreeNode(5), new TreeNode(8)).val); //2
    }

    /**
     *  输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
     *  输出: 6
     *  解释: 节点 2 和节点 8 的最近公共祖先是 6。
     *
     *  划重点，二叉搜索树
     *
     *  执行用时：5 ms, 在所有 Java 提交中击败了100.00%的用户
     *  内存消耗：42.3 MB, 在所有 Java 提交中击败了75.92%的用户
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathP = getPath(root, p);
        List<TreeNode> pathQ = getPath(root, q);
        TreeNode lowestCommonTree = null;
        for (int i = 0; i < pathP.size() && i < pathQ.size(); i++) {
            if(pathP.get(i).val == pathQ.get(i).val)
                lowestCommonTree = pathP.get(i);
        }
        return lowestCommonTree;
    }

    //获取路径
    public static List<TreeNode> getPath(TreeNode root,TreeNode flag){
        ArrayList<TreeNode> lists = new ArrayList<>();

        while(root.val != flag.val){
            if(root.val > flag.val){
                lists.add(root);
                root = root.left;
            }else{
                lists.add(root);
                root = root.right;
            }
        }
        lists.add(flag);
        return lists;
    }

    /**
     * 任意二叉树版
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs2(root,p,q);
        return this.ans;
    }

    public boolean dfs2(TreeNode root,TreeNode l ,TreeNode r){
        if( root == null ) return false;
        boolean lson = dfs2(root.left,l,r);
        boolean rson = dfs2(root.right,l,r);
        if((lson && rson) || (((root.val == l.val) || (root.val == r.val))) && (lson || rson))
            ans = root;
        return lson || rson || root.val == l.val || root.val == r.val;
    }

    private TreeNode ans;

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            ans = root;
        }
        return lson || rson || (root.val == p.val || root.val == q.val);
    }

}
