package simple;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * MT29 题目列表
 * @author d3y1
 */
public class MT29{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        while(in.hasNext()){
            solution(in);
        }
    }

    /**
     * TreeMap
     * @param in
     */
    private static void solution(Scanner in){
        int n = Integer.parseInt(in.nextLine());

        TreeMap<String, Integer> map = new TreeMap<>();

        String[] parts;
        String name;
        float submit;
        float pass;
        float rate;
        int difficulty;
        for(int i=1; i<=n; i++){
            parts = in.nextLine().split(" ");
            name = parts[0];
            submit = Integer.parseInt(parts[1]);
            pass = Integer.parseInt(parts[2]);
            rate = pass/submit;
            if(0<=rate && rate<=0.3){
                difficulty = 5;
            }else if(0.3<rate && rate<=0.6){
                difficulty = 4;
            }else{
                difficulty = 3;
            }

            map.put(name, difficulty);
        }

        for(Map.Entry<String, Integer> entry: map.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }
}