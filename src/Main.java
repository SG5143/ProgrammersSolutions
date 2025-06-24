// 출력 테스트 용도
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Sol_161989 sol = new Sol_161989();

        int n = 8;
        int m = 4;
        int[] section = new int[]{2,3,6};

        System.out.println(sol.solution(n, m, section));
    }
}
