// 출력 테스트 용도
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Sol_67256 sol = new Sol_67256();

        int[] number = new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";

        System.out.println(sol.solution(number, hand));
    }
}
