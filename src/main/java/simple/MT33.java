package simple;

import java.util.Scanner;

/**
 * MT33 最小排列
 * @author d3y1
 */
public class MT33{
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
        int n = in.nextInt();
        int[] seq = new int[n];

        int index = 0;
        int left = 0;
        int right = 0;
        boolean found = false;
        for(int i=0; i<n; i++){
            seq[i] = in.nextInt();
            if(!found && seq[i]!=i+1){
                left = seq[i];
                right = i+1;
                seq[i] = i+1;
                index = i;
                found = true;
            }
            if(i>index && seq[i]==right){
                seq[i] = left;
            }
        }

        if(found){
            for(int i=0; i<n; i++){
                System.out.print(seq[i]+" ");
            }
        }
        // 已经有序 交换最后两个数
        else{
            for(int i=1; i<=n-2; i++){
                System.out.print(i+" ");
            }
            System.out.print(n+" "+(n-1));
        }
    }
}