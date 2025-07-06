// 출력 테스트 용도

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Sol_250137 sol = new Sol_250137();

        int[] bandage = {5, 1, 5};
        int health = 30;
        int[][] attack = new int[][]{{2, 10}, {9, 15}, {10, 5}, {11, 5}};

        int result = sol.solution(bandage, health, attack);

        System.out.println(result);
    }
}
