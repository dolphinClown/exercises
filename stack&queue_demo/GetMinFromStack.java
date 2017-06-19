import java.util.Stack;
/**
 *����ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ��СԪ�ص�min������
 */
public class GetMinFromStack {

	/*ʹ������ջ��һ��ջ��������������Ԫ�أ�a������һ��ջ���ڵõ���СԪ�أ���СԪ��λ��ջ��(b)
     *1.��ʼ����ջΪ�գ��� a ��ѹ��һ��Ԫ�أ������Ԫ��ͬʱѹ�� b
     *2.֮��ѹ��Ԫ��ʱ��Ӧ�������жϣ���ǰԪ���� b ��ջ��Ԫ�رȽϣ���С�� b ջ��Ԫ�أ���ͬʱ����Ԫ��ѹ�� b ջ��
     *  ��ǰԪ�������� b ջ����Ԫ�أ��� b ջ��Ԫ���ظ�ѹ�� b һ��
     *3.���Ҫʹһ��Ԫ�س�ջ���� a �е���������ôͬʱ���� b ջ����Ԫ��
     */ 
    private static Stack<Integer> a = new Stack<Integer>();
    
    private static Stack<Integer> b = new Stack<Integer>();
    
    public void push(int node) {
        if(a.empty() && b.empty()){
            a.push(node);
            b.push(node);
        }else if(node <= b.peek()){
            a.push(node);
            b.push(node);
        }else{
            a.push(node);
            b.push(b.peek());
        }
        
    }
    
    public void pop() {
        if(a.empty() && b.empty()){
    		return;
        }
        a.pop();
       	b.pop();
    }
    
    public int top() {
        if(a.empty() && b.empty()){
    		return -1;
        }
        return a.peek();
    }
    
    public int min() {
        if(a.empty() && b.empty()){
    		return -1;
        }
    	return b.peek();
    }
}