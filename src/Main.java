// 출력 테스트 용도
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Sol_86053 sol = new Sol_86053();

        int a = 90;
        int b = 500;
        int[] g = new int[]{70,70,0};
        int[] s = new int[]{0,0,500};
        int[] w = new int[]{100,100,2};
        int[] t = new int[]{4,8,1};

        System.out.println(sol.solution(a, b, g, s, w, t));
    }
}
