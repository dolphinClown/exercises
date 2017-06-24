package sword;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by CLAY on 2017/6/24.
 * ��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡�
 * ��������һ������Ϊ9������{1,2,3,2,2,2,5,4,2}��
 * ��������2�������г�����5�Σ��������鳤�ȵ�һ�룬������2����������������0��
 */
public class MoreThanHalfNum {
    //����һ������ HashMap<Integer, Integer> K-��ǰ���֣�V-������ִ���������ҳ��������鳤��һ�������--[�ռ临�Ӷ�O(n),ʱ�临�Ӷ�O(n)]
    //��������ʹ�ù�����ط�����ʼ��ʼ��һ������ times Ϊ1����ʼ���������Ϊ�����һ��Ԫ�أ��������飬��������������ͬ�����ֽ�
    //		 ֵ��һ������һ������ͬ�����֣���ֵ��һ������ʱ times < 0,�� times ��ֵΪ 1�����������������Ϊ��ǰԪ�أ�
    //    	 ������Ӧ��������Ƿ񳬹����鳤��һ�룬�����Ӧ���--[ʱ�临�Ӷ�O(n)]
    //������������������ص㣬���ò��ֿ��� partition() �ҳ��м�Ԫ�ؼ�ΪҪѡ��--[ʱ�临�Ӷ�O(nlogn)]
    //        ע�⣺��ı�����Ԫ�����λ��

    //����һ��
    public static int moreThanHalfNum1(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(array[i])) {
                map.put(array[i], 1);
            } else {
                map.put(array[i], map.get(array[i]) + 1);
            }
        }
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > result) {
                result = entry.getKey();
            }
        }
        if (!checkMoreThanHalf(array, result)) {
            return 0;
        }
        return result;
    }

    //��������
    public static int moreThanHalfNum2(int[] array) {
        //ʹ�ù������
        if (array == null || array.length == 0) {
            return 0;
        }
        int result = array[0];
        int times = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == result) {
                times += 1;
            } else {
                times -= 1;
                if (times <= 0) {
                    times = 1;
                    result = array[i];
                }
            }
        }
        if (!checkMoreThanHalf(array, result)) {
            return 0;
        }
        return result;
    }

    //��������
    public static int moreThanHalfNum3(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int mid = array.length / 2;
        int position = partition(array, 0, array.length - 1);
        int result;
        int start = 0;
        int end = array.length - 1;
        while (position != mid) {
            if (position < mid) {
                start = position + 1;
                position = partition(array, start, end);
            } else {
                end = position - 1;
                position = partition(array, start, end);
            }
        }
        result = array[position];
        if (!checkMoreThanHalf(array, result)) {
            return 0;
        }
        return result;
    }

    private static int partition(int[] array, int left, int right) {
        int pos = array[left];
        int i = left;
        int j = right + 1;
        for (; ; ) {
            while (array[++i] < pos && i < right);
            while (array[--j] > pos);
            if (i >= j) {
                break;
            } else {
                swap(array, i, j);
            }
        }
        swap(array, left, j);
        return j;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public static boolean checkMoreThanHalf(int[] array, int result) {
        int count = 0;
        int halfOfLength = array.length / 2;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == result) {
                count++;
            }
        }
        if (count > halfOfLength) {
            return true;
        }
        return false;
    }
}
