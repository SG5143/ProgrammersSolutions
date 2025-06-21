// 출력 테스트 용도
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Sol_250125 sol = new Sol_250125();

        String[][] board = new String[][]{
                {"blue", "red", "orange", "red"},
                {"red", "red", "blue", "orange"},
                {"blue", "orange", "red", "red"},
                {"orange", "orange", "red", "blue"}};

        int h = 1;
        int w = 1;

        int result = sol.solution(board, h, w);

        System.out.println(result);
    }
}
