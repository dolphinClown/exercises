/**
  * �ַ�����S=��abcXYZdef��,Ҫ�����ѭ������3λ��Ľ��������XYZdefabc����
  */
public class LeftRotateString {
    // abcXYZdef
    // fedZYXcba �Ƚ��ַ������巭ת��Ȼ�������ֱַ�ת
    public String leftRotateString(String str,int n) {
        if (str == null || str.length() == 0 || n < 0) {
            return "";
        }
        char[] array = str.toCharArray();
		// 1. ���巭ת
        reverse(array, 0, array.length - 1);
        int move = n % array.length;
		// 2. �ֱ�ת������
        reverse(array, 0, array.length - 1 - move);
        reverse(array, array.length - move, array.length - 1);
        return new String(array);
    }
    public void reverse(char[] array, int left, int right) {
        for (; left <= right; left++, right--) {
            swap(array, left, right);
        }
    }
    public void swap(char[] array, int left, int right) {
        char temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}