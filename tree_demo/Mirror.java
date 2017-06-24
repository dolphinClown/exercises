/**���������Ķ�����������任ΪԴ�������ľ���
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    public void Mirror(TreeNode root) {
        if(root == null){
			return;            
        }
        if(root.left == null && root.right == null){
 			return;           
        }
        
        //ʹ��ǰ�����������������Ľ�����ӽڵ�ͽ��������ӽڵ�,
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        if(root.left != null){
            Mirror(root.left);
        }
        
        if(root.right != null){
            Mirror(root.right);
        }
    }
}