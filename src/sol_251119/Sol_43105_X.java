package sol_251119;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/43105
 */
public class Sol_43105_X {
    List<Integer> list = new ArrayList<>();

    public int solution(int[][] triangle) {
        ss(0, 0, triangle, 0);
        return Collections.max(list);
    }

    private void ss(int x, int y, int[][] triangle, int sum) {
        sum += triangle[x][y];

        if (x == triangle.length - 1){
            list.add(sum);
            return;
        }

        ss(x + 1, y, triangle, sum);
        ss(x + 1, y + 1, triangle, sum);
    }
}
