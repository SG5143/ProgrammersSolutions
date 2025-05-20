/**
 * 출력 테스트 용도
 */

public class Main {
    public static void main(String[] args) {
        Sol_340213 sol = new Sol_340213();

        String video_len = "10:55";
        String pos = "00:05";
        String op_start = "00:15";
        String op_end = "06:55";
        String[] commands = new String[]{"prev", "next", "next"};

        String result = sol.solution(video_len, pos, op_start, op_end, commands);

        System.out.println(result);
    }
}
