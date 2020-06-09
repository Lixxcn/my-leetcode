package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Li-Xiaoxu
 * @version 1.0
 * @date 2020/5/26 9:32
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 *  
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *  
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *方法二的迭代没看懂
 */
public class Problem07 {
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode treeNode = buildTree(preorder, inorder);
        System.out.println("前序遍历：");
        preorderOut(treeNode);
        System.out.println("中序遍历：");
        inorderOut(treeNode);
        System.out.println("后序遍历：");
        postorderOut(treeNode);
    }

    //前序遍历
    public static void preorderOut(TreeNode root){
        if(root != null){
            System.out.println(root.val);
            preorderOut(root.left);
            preorderOut(root.right);
        }
    }
    //中序遍历
    public static void inorderOut(TreeNode root){
        if(root != null){
            inorderOut(root.left);
            System.out.println(root.val);
            inorderOut(root.right);
        }
    }
    //后序遍历
    public static void postorderOut(TreeNode root){
        if(root != null){
            postorderOut(root.left);
            postorderOut(root.right);
            System.out.println(root.val);
        }
    }

    /**
     * 自己想的方法
     * @param preorder
     * @param inorder
     * @return
     */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode rootNode = new TreeNode(preorder[0]);
        int rootIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if(inorder[i] == preorder[0]){
                rootIndex = i;//1
            }
        }
        int leftSize = rootIndex;
        int rightSize = inorder.length -1 -rootIndex;
        int[] preorderLeft = new int[leftSize];
        int[] preorderRight = new int[rightSize];
        int[] inorderLeft = new int[leftSize];
        int[] inorderRight = new int[rightSize];
        int count = 0;
        for (int i = 0; i < inorder.length; i++) {
            if(i < rootIndex){
                inorderLeft[i] = inorder[i];
            }else if(i > rootIndex){
                inorderRight[count] = inorder[i];
                count++;
            }
        }
        count = 0;
        int count1 = 0;
        for (int i = 1; i < preorder.length; i++) {
            if(i < 1+leftSize){
                preorderLeft[count] = preorder[i];
                count++;
            }else {
                preorderRight[count1] = preorder[i];
                count1++;
            }
        }
        TreeNode leftSubtree =  buildTree(preorderLeft,inorderLeft);
        TreeNode rightSubtree = buildTree(preorderRight,inorderRight);

        rootNode.left = leftSubtree;
        rootNode.right = rightSubtree;

        return rootNode;
    }

    public static TreeNode buildTree1(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
        int length = preorder.length;
        for (int i = 0; i < length; i++) {
            indexMap.put(inorder[i], i);
        }
        TreeNode root = buildTree(preorder, 0, length - 1, inorder, 0, length - 1, indexMap);
        return root;
    }

    public static TreeNode buildTree(int[] preorder, int preorderStart, int preorderEnd, int[] inorder, int inorderStart, int inorderEnd, Map<Integer, Integer> indexMap) {
        if (preorderStart > preorderEnd) {
            return null;
        }
        int rootVal = preorder[preorderStart];
        TreeNode root = new TreeNode(rootVal);
        if (preorderStart == preorderEnd) {
            return root;
        } else {
            int rootIndex = indexMap.get(rootVal);//1
            int leftNodes = rootIndex - inorderStart, rightNodes = inorderEnd - rootIndex;//1-0=1 4-1=3
            TreeNode leftSubtree = buildTree(preorder, preorderStart + 1, preorderStart + leftNodes, inorder, inorderStart, rootIndex - 1, indexMap);
            TreeNode rightSubtree = buildTree(preorder, preorderEnd - rightNodes + 1, preorderEnd, inorder, rootIndex + 1, inorderEnd, indexMap);
            root.left = leftSubtree;
            root.right = rightSubtree;
            return root;
        }
    }
}
