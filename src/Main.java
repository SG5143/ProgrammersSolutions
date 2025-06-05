import java.util.Arrays;

/**
 * 출력 테스트 용도
 */

public class Main {
    public static void main(String[] args) {
        Sol_42579 sol = new Sol_42579();

        String[] genres = new String[]{"classic", "pop", "classic", "classic", "pop"};
        int[] plays = new int[]{500, 600, 150, 800, 2500};

        System.out.println(Arrays.toString(sol.solution(genres, plays)));
    }
}
