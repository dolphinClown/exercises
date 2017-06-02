/*����һ��������ת�����������������Ԫ�ء�
public class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}*/
public class Solution {
    public ListNode ReverseList(ListNode head) {
 		if(head == null){
           return null; 
        }
        
        //ʹ������ָ�룬head ָ�뱣�ֲ��䣬pre ָ���µ�ͷ��㣬behind ָ����һ��Ҫ�ƶ��Ľ��
        ListNode pre = head;
        ListNode behind = head.next;
        
        while(behind != null){
            head.next = behind.next;
            behind.next = pre;
            pre = behind;
            behind = head.next;
        }
        
        return pre;
    }
}