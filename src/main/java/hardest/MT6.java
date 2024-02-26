package hardest;

import java.util.Scanner;

/**
 * MT6 平均年龄
 * @author d3y1
 */
public class MT6{
    private static final int newStaffAvgAge = 21;
    private static int totalStaffNum;
    private static int totalStaffAvgAge;
    private static float departRate;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        while(in.hasNext()){
            solution(in);
        }
    }

    /**
     * 模拟法
     * @param in
     */
    private static void solution(Scanner in){
        totalStaffNum = in.nextInt();
        totalStaffAvgAge = in.nextInt();
        departRate = in.nextFloat();
        int n = in.nextInt();

        float avgAge = getNthYearAvgAge(n);

        System.out.println((int)Math.ceil(avgAge));
    }

    /**
     * 获取第N年后公司员工平均年龄
     * @param n
     * @return
     */
    private static float getNthYearAvgAge(int n){
        float avgAge = totalStaffAvgAge;
        while(n-- > 0){
            avgAge = getNextYearAvgAge(avgAge);
        }

        return avgAge;
    }

    /**
     * 获取下一年公司员工平均年龄
     *
     * 平均年龄算式可简化:
     * ((totalStaffNum-newStaffNum)*(avgAge+1)+newStaffNum*newStaffAvgAge)/totalStaffNum
     * = ((totalStaffNum-totalStaffNum*departRate)*(avgAge+1)+totalStaffNum*departRate*newStaffAvgAge)/totalStaffNum
     * = (1-departRate)*(avgAge+1)+departRate*newStaffAvgAge
     *
     * @param avgAge
     * @return
     */
    private static float getNextYearAvgAge(float avgAge){
//        float newStaffNum = totalStaffNum*departRate;
//        return ((totalStaffNum-newStaffNum)*(avgAge+1)+newStaffNum*newStaffAvgAge)/totalStaffNum;

        // (avgAge+1) -> 每过一年 公司员工平均年龄要+1
        return (1-departRate)*(avgAge+1)+departRate*newStaffAvgAge;
    }
}