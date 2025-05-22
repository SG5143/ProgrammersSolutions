/**
 * 출력 테스트 용도
 */

public class Main {
    public static void main(String[] args) {
        Sol_42892 sol = new Sol_42892();

        int[][] nodeinfo = new int[][]{{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};

        int[][] result = sol.solution(nodeinfo);

        System.out.println(result);
    }
}
