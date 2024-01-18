package middle;

import java.util.*;

/**
 * MT43 数字字符
 * @author d3y1
 */
public class MT43{
    private static HashMap<Integer, Integer> digitMap = new HashMap<Integer, Integer>(){{
        put(0, 0);
        put(1, 0);
        put(2, 0);
        put(3, 0);
        put(4, 0);
        put(5, 0);
        put(6, 0);
        put(7, 0);
        put(8, 0);
        put(9, 0);
    }};

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        while(in.hasNext()){
            solution(in);
        }
    }

    /**
     * 模拟法: 贪心
     *
     * 举例找规律
     *
     * @param in
     */
    private static void solution(Scanner in){
        String digits = in.nextLine();

        int digit;
        for(char ch: digits.toCharArray()){
            digit = Integer.parseInt(String.valueOf(ch));
            digitMap.put(digit, digitMap.get(digit)+1);
        }

        List<Map.Entry<Integer, Integer>> digitCountList = new ArrayList<>(digitMap.entrySet());

        Collections.sort(digitCountList, (o1, o2) -> {
            if(o1.getValue().equals(o2.getValue())){
                return o1.getKey()-o2.getKey();
            }else{
                return o1.getValue()-o2.getValue();
            }
        });

        Map.Entry<Integer, Integer> firstEntry = digitCountList.get(0);
        Map.Entry<Integer, Integer> secondEntry = digitCountList.get(1);
        StringBuilder sb = new StringBuilder();
        if(firstEntry.getValue() == 0){
            if(firstEntry.getKey() == 0){
                if(secondEntry.getValue() == 0){
                    sb.append(secondEntry.getKey());
                }else{
                    sb.append(10);
                }
            }else{
                sb.append(firstEntry.getKey());
            }
        }else{
            if(firstEntry.getKey() == 0){
                for(int i=0; i<=secondEntry.getValue(); i++){
                    sb.append(secondEntry.getKey());
                }
            }else{
                for(int i=0; i<=firstEntry.getValue(); i++){
                    sb.append(firstEntry.getKey());
                }
            }
        }

        System.out.println(sb);
    }
}