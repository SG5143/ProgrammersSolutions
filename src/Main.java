// 출력 테스트 용도
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Sol_160586 sol = new Sol_160586();

        String[] keymap = new String[]{"ABACD", "BCEFD"};
        String[] target = new String[]{"ABCD","AABB"};

        System.out.println(Arrays.toString(sol.solution(keymap, target)));
    }
}
