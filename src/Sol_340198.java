/*
    https://school.programmers.co.kr/learn/courses/30/lessons/340198
    공원
    지민이는 다양한 크기의 정사각형 모양 돗자리를 가지고 공원에 소풍을 나왔습니다.
    공원에는 이미 돗자리를 깔고 여가를 즐기는 사람들이 많아 지민이가 깔 수 있는 가장 큰 돗자리가 어떤 건지 확인하려 합니다.
    예를 들어 지민이가 가지고 있는 돗자리의 한 변 길이가 5, 3, 2 세 종류이고,
    사람들이 다음과 같이 앉아 있다면 지민이가 깔 수 있는 가장 큰 돗자리는 3x3 크기입니다.

    지민이가 가진 돗자리들의 한 변의 길이들이 담긴 정수 리스트 mats,
    현재 공원의 자리 배치도를 의미하는 2차원 문자열 리스트 park가 주어질 때
    지민이가 깔 수 있는 가장 큰 돗자리의 한 변 길이를 return 하도록 solution 함수를 완성해 주세요.

    아무런 돗자리도 깔 수 없는 경우 -1을 return합니다.
 */
import java.util.Arrays;

public class Sol_340198 {
    public int solution(int[] mats, String[][] park) {

        int rows = park.length;
        int cols = park[0].length;

        Arrays.sort(mats); // 정렬 후 큰 거부터 가능한지 루프
        for (int i = mats.length - 1; i >= 0; i--) {
            int size = mats[i];
            if (canPlaceMat(size, park, rows, cols)) return size;
        }
        return -1;
    }

    private boolean canPlaceMat(int size, String[][] park, int rows, int cols) {
        for (int r = 0; r <= rows - size; r++) {
            for (int c = 0; c <= cols - size; c++) {
                if (isAreaClear(r, c, size, park)) return true;
            }
        }
        return false;
    }

    // size x size 만큼 영역 확인
    private boolean isAreaClear(int startRow, int startCol, int size, String[][] park) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!park[startRow + i][startCol + j].equals("-1")) return false; // 돗자리 펴져 있음 false
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] mats = new int[]{5, 3, 2};
        String[][] park = new String[][]{
                {"A", "A", "-1", "B", "B", "B", "B", "-1"},
                {"A", "A", "-1", "B", "B", "B", "B", "-1"},
                {"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"},
                {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"},
                {"D", "D", "-1", "-1", "-1", "-1", "-1", "F"},
                {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"}
        };

        Sol_340198 sol = new Sol_340198();
        int result = sol.solution(mats, park);
        System.out.println(result);
    }
}
