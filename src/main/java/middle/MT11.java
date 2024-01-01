package middle;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * MT11 丢失的三个数
 * @author d3y1
 */
public class MT11{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        while(in.hasNext()){
            solution1(in);
            solution2(in);
        }
    }

    /**
     * 模拟法: Set
     * @param in
     */
    private static void solution1(Scanner in){
        String[] nums = in.nextLine().split(" ");

        Set<String> set = new HashSet<>(Arrays.asList(nums));

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=10000; i++){
            if(!set.contains(String.valueOf(i))){
                sb.append(i);
            }
        }

        System.out.println(Long.parseLong(sb.toString())%7);
    }

    /**
     * 模拟法: boolean[]
     * @param in
     */
    private static void solution2(Scanner in){
        boolean[] isExisted = new boolean[10001];
        for(int i=1; i<=9997; i++){
            isExisted[in.nextInt()] = true;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=10000; i++){
            if(!isExisted[i]){
                sb.append(i);
            }
        }

        System.out.println(Long.parseLong(sb.toString())%7);
    }
}