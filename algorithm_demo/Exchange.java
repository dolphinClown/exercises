import java.util.*;
/**
 * ����Ǯ��ϰ
 * ������penny��penny�����е�ֵ��Ϊ�����Ҳ��ظ���ÿ��ֵ����һ����ֵ�Ļ��ң�ÿ����ֵ�Ļ��ҿ���ʹ�������ţ��ٸ���һ������aim(С�ڵ���1000)����Ҫ�ҵ�Ǯ������Ǯ�ж����ַ�����
 * ��������penny�����Ĵ�С(С�ڵ���50)��ͬʱ����һ������aim���뷵���ж����ַ������Դճ�aim��
 */
public class Exchange {
    public int countWays(int[] penny, int n, int aim) {
		//dp[i][j] ��ʾʹ���±� 0~i �Ľ����ֵ��ȥ�� aim ���ж����ַ���
        int[][] dp = new int[n][aim+1];
		//��ʼ���߽�ֵ
        for(int i=0; i<n; i++){
            dp[i][0] = 1;
        }
        for(int j=0; j<aim+1; j++){
            if(j%penny[0] == 0){
                dp[0][j] = 1;
            }else{
                dp[0][j] = 0;
            }
        }
		//���� dp[n - 1][aim] ��Ϊ���󷽷���
        for(int i=1; i<n; i++){
            for(int j=1; j<=aim; j++){
                if(penny[i] > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-penny[i]];
                }
            }
        }
        return dp[n-1][aim];
    }
}