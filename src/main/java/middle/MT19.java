package middle;

import java.util.Scanner;

/**
 * MT19 K 的倍数
 * @author d3y1
 */
public class MT19{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        while(in.hasNext()){
            solution1(in);
            solution2(in);
        }
    }

    /**
     * 模拟法: 滑动窗口
     * @param in
     */
    private static void solution1(Scanner in){
        int N = in.nextInt();

        int[] num = new int[N+1];
        long[] sum = new long[N+1];

        for(int i=1; i<=N; i++){
            num[i] = in.nextInt();
            sum[i] = sum[i-1] + num[i];
        }

        int K = in.nextInt();
        boolean found = false;
        int result = 0;
        for(int gap=N; gap>0; gap--){
            for(int j=0; j+gap<=N; j++){
                if((sum[j+gap]-sum[j])%K == 0){
                    result = gap;
                    found = true;
                    break;
                }
            }
            if(found){
                break;
            }
        }

        System.out.println(result);
    }


    /**
     * 模拟法: 滑动窗口
     * @param in
     */
    private static void solution2(Scanner in){
        int N = in.nextInt();

        int[] num = new int[N+1];
        long[] sum = new long[N+1];
        int[] mod = new int[N+1];

        for(int i=1; i<=N; i++){
            num[i] = in.nextInt();
            sum[i] = sum[i-1] + num[i];
        }

        int K = in.nextInt();
        for(int i=1; i<=N; i++){
            mod[i] = (int) (sum[i] % K);
        }

        boolean found = false;
        int result = 0;
        for(int gap=N; gap>0; gap--){
            for(int j=0; j+gap<=N; j++){
                if(mod[j+gap] == mod[j]){
                    result = gap;
                    found = true;
                    break;
                }
            }
            if(found){
                break;
            }
        }

        System.out.println(result);
    }
}