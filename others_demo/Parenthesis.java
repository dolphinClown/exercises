import java.util.*;
/**
  * ����һ���ַ����������һ���㷨���ж����Ƿ�Ϊһ���Ϸ������Ŵ���
  * ����һ���ַ���A�����ĳ���n���뷵��һ��boolֵ�������Ƿ�Ϊһ���Ϸ������Ŵ���
  */
public class Parenthesis {
    public boolean chkParenthesis(String A, int n) {
        if (A == null || n == 0) {
            return false;
        }
        // ����һ������ num��������������� num++������������ num--���� num < 0 
        // ʱ����ʾ�˴�����������
        int num = 0;
        for (int i = 0; i < n; i++) {
            char c = A.charAt(i);
            if (c != '(' && c != '(') {
                return false;
            } else if (c == '(') {
                num++;
            } else if (c == ')') {
                num--;
            }
            if (num < 0) {
                return false;
            }
        }
        if (num != 0) {
            return false;
        }
        return true;
    }
}