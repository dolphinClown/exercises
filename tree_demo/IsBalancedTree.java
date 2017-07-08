/**
 * ����һ�ö��������жϸö������Ƿ���ƽ���������
 */
public class Solution {
    // ˼·һ���Զ��������к�����������������ж�ÿ���������жϣ������ӽڵ����Ȳ�ľ���ֵ <= 1������������㣬��ƽ�⡣
    //       ȱ�㣺���ڴ�������ظ�����
    // ˼·������������ȵķ������иĽ������ú�����������������н�������Ľ����ȱ��������������ظ�����
	public int getDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftDepth = 0;
        int rightDepth = 0;
        if(root.left != null){
            leftDepth = getDepth(root.left);
        }
        if(root.right != null){
            rightDepth = getDepth(root.right);
        }
        return 1 + Math.max(leftDepth, rightDepth);
    }

	// ����һ��
	public boolean isBalanced(TreeNode root){
		if(root == null){
			return true;		
		}
		int leftDepth = getDepth(root.left);
		int rightDepth = getDepth(root.right);
		if(Math.abs(leftDepth - rightDepth) > 1){
			return false;
		}
		return isBalanced(root.left) && isBalanced(root.right);
	}

	// ��������
    public boolean IsBalanced2(TreeNode root) {
        if(checkDepth(root) == -1) {  
            return false;
        }else{
            return true;
        }
    }

    public int checkDepth(TreeNode root){
        if (null == root) return 0;
        int leftDepth = checkDepth(root.left);
        if ( leftDepth == -1) {
            return -1; //unbalanced
        }  
          
        int rightDepth = checkDepth(root.right);
        if ( rightDepth == -1) {
            return -1; //unbalanced
        }  
          
        int depthDiff = leftDepth - rightDepth;
        if (Math.abs(depthDiff) > 1) {
            return -1; // unbalanced
        }  
        else {  
            return Math.max(leftDepth, rightDepth) + 1;
        }  
    }
}