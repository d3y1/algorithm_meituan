package simple;

import java.util.Scanner;

/**
 * MT38 贪心的小博
 * @author d3y1
 */
public class MT38{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        while(in.hasNext()){
            solution(in);
        }
    }

    /**
     * 模拟法: 数学
     *
     * "最坏情况下" 等价于 每类卡片都只差一张,最后再买一包面即可
     */
    private static void solution(Scanner in){
        int n = in.nextInt();

        long total = 0;
        for(int i=1; i<=n; i++){
            total += in.nextInt();
        }

        System.out.println(total-n+1);
    }
}