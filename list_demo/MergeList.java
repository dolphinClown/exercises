/*���������������������������������ϳɺ��������Ȼ������Ҫ�ϳɺ���������㵥����������
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null && list2 == null){
            return null;
        }else if(list1 == null){
            return list2;
        }else if(list2 == null){
            return list1;
        }
        
        ListNode head = null;
        //1.ȷ��ͷ���
        if(list1.val <= list2.val){
            head = list1;
            list1 = list1.next;
        }else{
            head = list2;
            list2 = list2.next;
        }
        
        ListNode p = head; //ָ��ϲ�����ĵ�ǰ�ϲ����
        //2.�ϲ�����
		while(list1 != null && list2 != null){
            if(list1.val >= list2.val){
                p.next = list2;
                list2 = list2.next;
                p = p.next;
            }else{
                p.next = list1;
                list1 = list1.next;
                p = p.next;
            }
        }
        
        if(list1 != null){
            p.next = list1;
        }
        
        if(list2 != null){
			p.next = list2;
        }
        
        
      	return head;
    }
}