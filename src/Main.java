// 출력 테스트 용도
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Sol_161990 sol = new Sol_161990();

        String[] wallpaper = new String[]{".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."};

        System.out.println(Arrays.toString(sol.solution(wallpaper)));
    }
}
