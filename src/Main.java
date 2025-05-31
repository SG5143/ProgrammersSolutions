import java.util.Arrays;

/**
 * 출력 테스트 용도
 */

public class Main {
    public static void main(String[] args) {
        Sol_42842 sol = new Sol_42842();

        int brown = 10;
        int yellow = 2;

        int[] result = sol.solution(brown, yellow);

        System.out.println(Arrays.toString(result));
    }
}
