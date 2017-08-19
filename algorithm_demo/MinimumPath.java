import java.util.*;
/**
  * ��һ������ map����ÿ��������һ��Ȩֵ�������Ͻǵĸ��ӿ�ʼÿ��ֻ�����һ��������ߣ���󵽴����½ǵ�λ�ã�·�������е������ۼ���������·���ͣ��������е�·������С��·���͡�
  * ����һ������ map ���������� n ������ m���뷵����С·���͡���֤��������С�ڵ���100.
  */
public class MinimumPath {
    public int getMin(int[][] map, int n, int m) {
        if (map == null || map.length == 0) {
            return -1;
        }
        int[][] dp = new int[n][m];
        dp[0][0] = map[0][0];
        for (int i = 1; i < m; i++) {
            dp[0][i] = map[0][i] + dp[0][i - 1]; 
        }
        for (int i = 1; i < n; i++) {
            dp[i][0] = map[i][0] + dp[i - 1][0];
        }
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + map[i][j];
            }
        }
        return dp[n - 1][m - 1];
    }
}