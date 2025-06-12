// 출력 테스트 용도

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Sol_181188 sol = new Sol_181188();

        int[][] targets = { {4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12} };
        int result = sol.solution(targets);
        System.out.println(result);
    }
}
