/*����һ����������ÿ���ڵ����нڵ�ֵ���Լ�����ָ�룬һ��ָ����һ���ڵ㣬
  ��һ������ָ��ָ������һ���ڵ㣩�����ؽ��Ϊ���ƺ��������head��
  public class RandomListNode {
      int label;
      RandomListNode next = null;
      RandomListNode random = null;

      RandomListNode(int label) {
          this.label = label;
      }
  }
*/
public class CloneComplexList {
    public RandomListNode clone(RandomListNode pHead)
    {
        if(pHead == null){
            return null;
        }
        RandomListNode position = pHead;
        //1.���ȣ���������ÿһ����㶼���и��ƣ����õ����½�����ԭ������
        while(position != null){
            RandomListNode newNode = new RandomListNode(position.label);
            newNode.next = position.next;
            position.next = newNode;
            position = newNode.next;
        }
        position = pHead;
        //2.�����Ƶõ���������ָ��ָ����ȷ�Ľ�㴦
        while(position != null){
            RandomListNode tempPosition = position.next;
            if(position.random != null){
                tempPosition.random = position.random.next;
            }
            position = tempPosition.next;
        }
        position = pHead;
        //3.�����ƵĽ���ֳ���
        RandomListNode newHead = null;
        RandomListNode clonedPosition = null;
        if(position != null){
            newHead = clonedPosition = position.next;
            position.next = clonedPosition.next;
            position = position.next;
        }
        while(position != null){
			clonedPosition.next = position.next;
            clonedPosition = clonedPosition.next;
            position.next = clonedPosition.next;
            position = position.next;
        }
        return newHead;
    }
}