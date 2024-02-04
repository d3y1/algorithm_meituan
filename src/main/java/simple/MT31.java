package simple;

import java.util.Scanner;

/**
 * MT31 硬币兑换
 * @author d3y1
 */
public class MT31{
    private static int[] coins = new int[]{1, 2, 5, 10, 20, 50, 100};

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        while(in.hasNext()){
            solution(in);
        }
    }

    /**
     * 贪心
     * @param in
     */
    private static void solution(Scanner in){
        int money = in.nextInt();

        int remain = money;
        int kind = 0;
        int amount;
        // 种类贪心 硬币面额由小到大
        for(int i=0; i<coins.length; i++){
            if(coins[i] <= remain){
                remain -= coins[i];
                kind++;
            }
        }

        // 数量贪心 剩下全选1元硬币
        amount = kind + remain;

        System.out.println(kind+" "+amount);
    }
}