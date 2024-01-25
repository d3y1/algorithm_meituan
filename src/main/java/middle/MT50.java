package middle;

import java.util.Scanner;

/**
 * MT50 D塔2
 * @author d3y1
 */
public class MT50{
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
        int test = in.nextInt();
        while(test-- > 0){
            int blood = in.nextInt();

            int soldiers = in.nextInt();
            int soldierDamage = in.nextInt();
            int heroSkillDamage = in.nextInt();
            int heroNormalDamage = in.nextInt();

            int soldierCoolDown = in.nextInt();
            int heroNormalCoolDown = in.nextInt();
            int heroSkillCoolDown = in.nextInt();

            int currTime = 0;
            while(true){
                // 小兵的伤害算在前
                // 小兵群体攻击
                if(currTime%soldierCoolDown == 0){
                    blood -= soldiers * soldierDamage;
                    if(blood <= 0){
                        System.out.println("NO");
                        break;
                    }
                }

                // 英雄技能攻击
                if(currTime%heroSkillCoolDown == 0){
                    blood -= heroSkillDamage;
                    if(blood <= 0){
                        System.out.println("YES");
                        break;
                    }
                }

                // 英雄普通攻击
                if(currTime%heroNormalCoolDown == 0){
                    blood -= heroNormalDamage;
                    if(blood <= 0){
                        System.out.println("YES");
                        break;
                    }
                }

                currTime++;
            }
        }
    }
}