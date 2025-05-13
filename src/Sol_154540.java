import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Math.abs;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/154540
 * 메리는 여름을 맞아 무인도로 여행을 가기 위해 지도를 보고 있습니다.
 * 지도에는 바다와 무인도들에 대한 정보가 표시돼 있습니다.
 * 지도는 1 x 1크기의 사각형들로 이루어진 직사각형 격자 형태이며,
 * 격자의 각 칸에는 'X' 또는 1에서 9 사이의 자연수가 적혀있습니다.
 * 지도의 'X'는 바다를 나타내며, 숫자는 무인도를 나타냅니다.
 * 이때, 상, 하, 좌, 우로 연결되는 땅들은 하나의 무인도를 이룹니다.
 * 지도의 각 칸에 적힌 숫자는 식량을 나타내는데,
 * 상, 하, 좌, 우로 연결되는 칸에 적힌 숫자를 모두 합한 값은
 * 해당 무인도에서 최대 며칠동안 머물 수 있는지를 나타냅니다.
 * 어떤 섬으로 놀러 갈지 못 정한 메리는 우선 각 섬에서
 * 최대 며칠씩 머물 수 있는지 알아본 후 놀러갈 섬을 결정하려 합니다.
 * <p>
 * 지도를 나타내는 문자열 배열 maps가 매개변수로 주어질 때,
 * 각 섬에서 최대 며칠씩 머무를 수 있는지 배열에 오름차순으로 담아 return 하는 solution 함수를 완성해주세요.
 * 만약 지낼 수 있는 무인도가 없다면 -1을 배열에 담아 return 해주세요.
 */

public class Sol_154540 {
    public int[] solution(String[] maps) {

        int y = maps.length;
        int x = maps[0].length();

        int[][] integerMap = new int[y][x];
        ArrayList<int[]> list = new ArrayList<>();

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (maps[i].charAt(j) == 'X') {
                    integerMap[i][j] = -1;
                } else {
                    integerMap[i][j] = maps[i].charAt(j) - '0';
                    list.add(new int[]{i, j});
                }
            }
        }

        if (list.isEmpty()) return new int[]{-1};

        ArrayList<ArrayList<int[]>> grouped = new ArrayList<>();

        while (!list.isEmpty()) {
            ArrayList<int[]> group = new ArrayList<>();
            group.add(list.get(0));
            list.remove(0);

            int index = 0;
            while (index < group.size()) {
                int[] item = group.get(index);

                for (int i = 0; i < list.size(); i++) {
                    int calY = abs(item[0] - list.get(i)[0]);
                    int calX = abs(item[1] - list.get(i)[1]);

                    if (calY + calX == 1) {
                        group.add(list.get(i));
                        list.remove(i);
                        i--;
                    }
                }
                index++;
            }

            grouped.add(group);
        }

        /* 결과 확인용 그룹된 배열 출력 */
        for (ArrayList<int[]> group : grouped) {
            for (int[] item : group)
                System.out.print("[" + item[0] + "," + item[1] + "]");
            System.out.println();
        }

        int[] answer = new int[grouped.size()];
        for (int i = 0; i < grouped.size(); i++) {
            for (int[] item : grouped.get(i))
                answer[i] += integerMap[item[0]][item[1]];
        }

        answer = Arrays.stream(answer).sorted().toArray();

        return answer;
    }

}
