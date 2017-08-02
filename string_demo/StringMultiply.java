package exam;

import java.util.Scanner;

/**
 * Created by CLAY on 2017/8/1.
 * ���������ַ������������ַ����������ֵĳ˻���������ַ������
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            String str1 = scanner.nextLine();
            String str2 = scanner.nextLine();
            System.out.println(multiply(str1, str2));
        }
    }

    public static String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) {
            throw new IllegalArgumentException("��������");
        }
        int len1 = num1.length();
        int len2 = num2.length();
        int product, carry, i, j;
        int[] num = new int[len1 + len2]; //������ˣ��������Ϊ len1 + len2 ���� len1 + len2 - 1
        for (i = len1 - 1; i >= 0; i--) {
            carry = 0;
            for (j = len2 - 1; j >= 0; j--) {
                product = carry + (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + num[i + j + 1];
                num[i + j + 1] = product % 10;
                carry = product / 10;
            }
            num[i + j + 1] = carry;
        }
        //ȥ���ع�ǰ����� 0
        i = 0;
        while (i < (len1 + len2) && num[i] == 0) {
            i++;
        }
        StringBuilder sb = new StringBuilder();
        while (i < (len1 + len2)) {
            sb.append(num[i]);
            i++;
        }

        return sb.toString();
    }
}

