package middle;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * MT25 超链接
 * @author d3y1
 */
public class MT25{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        while(in.hasNext()){
            solution(in);
        }
    }

    /**
     * TreeSet
     * @param in
     */
    private static void solution(Scanner in){
        int n = Integer.parseInt(in.nextLine());

        TreeSet<String> linkSet = new TreeSet<>();
        for(int i=1; i<=n; i++){
            linkSet.add(in.nextLine());
        }

        int m = Integer.parseInt(in.nextLine());
        for(int i=1; i<=m; i++){
            linkSet.remove(in.nextLine());
        }

        for(String link: linkSet){
            System.out.println(link);
        }
    }
}