// 출력 테스트 용도
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Sol_250121 sol = new Sol_250121();

        int[][] data = new int[][]{{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}};
        String ext = "date";
        int val_ext = 20300501;
        String sort_by = "remain";

        sol.solution(data, ext, val_ext, sort_by);
    }
}
