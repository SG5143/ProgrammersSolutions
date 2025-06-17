// 출력 테스트 용도
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Sol_258709 sol = new Sol_258709();

        int[][] dice = new int[][]{
                {1, 2, 3, 4, 5, 6},
                {3, 3, 3, 3, 4, 4},
                {1, 3, 3, 4, 4, 4},
                {1, 1, 4, 4, 5, 5}
        };

        int[] result = sol.solution(dice);
        System.out.println(Arrays.toString(result));
    }
}
