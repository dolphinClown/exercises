import java.util.ArrayList;
import java.util.Stack;
/**
 *���������������У���һ�����б�ʾջ��ѹ��˳�����жϵڶ��������Ƿ�Ϊ��ջ�ĵ���˳��
 *����ѹ��ջ���������־�����ȡ���������1,2,3,4,5��ĳջ��ѹ��˳������4��5,3,2,1�Ǹ�ѹջ���ж�Ӧ��һ���������У�
 *��4,3,5,1,2�Ͳ������Ǹ�ѹջ���еĵ������С���ע�⣺���������еĳ�������ȵģ�
 */
public class IsPopOrder {
    public boolean isPopOrder(int[] pushA,int[] popA) {
        if(pushA == null || pushA.length == 0 || popA == null || popA.length == 0 || pushA.length != popA.length){
        	return false;
        }
        
        //1.�ֱ���������������һ��ָ��ǰλ�õ�ָ�룺pushA--p; popA--q
        //2.���� pushA�����������н�Ԫ��ѹ��ջ�У�ֱ�������� popA ����ȵ�Ԫ�أ���Ԫ�ز�ѹջ������ p �� q �ֱ�����ƶ�һ��λ�á�
        //3.�� pushA �е�Ԫ�ر�����ʱ����ջ��Ԫ��ִ�г�ջ�������� popA �е�ʣ��Ԫ����ȣ�������ջ��Ԫ��Ϊ�գ����� q == popA.length
        //  ���ʾ popA �� pushA �ĵ������С�
        Stack<Integer> stack = new Stack<Integer>();
        int p = 0;
        int q = 0;
        while(p < pushA.length && q < popA.length){
            if(pushA[p] == popA[q]){
                p++;
                q++;
                //�жϵ�ǰջ����Ԫ�أ��� popA[q]�Ƿ���ȣ������ȣ���ջ��Ԫ�ص�����q ����ƶ�һ���±�
                if(!stack.empty()){
                    if(stack.peek() == popA[q]){
                        stack.pop();
                        q++;
                    }
                }
            }else{
                stack.push(pushA[p]);
                p++;
            }
        }
        
        while(!stack.empty() && q < popA.length){
            if(stack.pop() != popA[q]){
                break;
            }
            q++;
        }
        
        if(stack.empty() && q == popA.length){
            return true;
        }
        return false;
    }
}