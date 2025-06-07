import java.util.Arrays;

/**
 * 출력 테스트 용도
 */

public class Main {
    public static void main(String[] args) {
        Sol_42583 sol = new Sol_42583();

        int bridge_length = 2;
        int weight = 10;
        int[] truck_weight = new int[]{7,4,5,6};

        System.out.println(sol.solution(bridge_length, weight, truck_weight));
    }
}
