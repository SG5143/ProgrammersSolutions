/*
    https://school.programmers.co.kr/learn/courses/30/lessons/172928
    지나다니는 길을 'O', 장애물을 'X'로 나타낸 직사각형 격자 모양의 공원에서 로봇 강아지가 산책을 하려합니다.
    산책은 로봇 강아지에 미리 입력된 명령에 따라 진행하며, 명령은 다음과 같은 형식으로 주어집니다.

    ["방향 거리", "방향 거리" … ]
    예를 들어 "E 5"는 로봇 강아지가 현재 위치에서 동쪽으로 5칸 이동했다는 의미입니다.
    로봇 강아지는 명령을 수행하기 전에 다음 두 가지를 먼저 확인합니다.

    주어진 방향으로 이동할 때 공원을 벗어나는지 확인합니다.
    주어진 방향으로 이동 중 장애물을 만나는지 확인합니다.
    위 두 가지중 어느 하나라도 해당된다면, 로봇 강아지는 해당 명령을 무시하고 다음 명령을 수행합니다.
    공원의 가로 길이가 W, 세로 길이가 H라고 할 때, 공원의 좌측 상단의 좌표는 (0, 0), 우측 하단의 좌표는 (H - 1, W - 1) 입니다.

    공원을 나타내는 문자열 배열 park, 로봇 강아지가 수행할 명령이 담긴 문자열 배열 routes가 매개변수로 주어질 때,
    로봇 강아지가 모든 명령을 수행 후 놓인 위치를 [세로 방향 좌표, 가로 방향 좌표] 순으로 배열에 담아 return 하도록 solution 함수를 완성해주세요.
 */
public class Sol_172928 {
    public int[] solution(String[] park, String[] routes) {
        int h = park.length;
        int w = park[0].length();
        int x = 0, y = 0;

        for (int i = 0; i < h; i++) {
            if (park[i].contains("S")) {
                x = i;
                y = park[i].indexOf("S");
                break;
            }
        }

        for (String route : routes) {
            String[] parts = route.split(" ");
            String dir = parts[0];
            int dist = Integer.parseInt(parts[1]);

            int nx = x, ny = y;
            boolean isRun = true;

            for (int i = 0; i < dist; i++) {
                if (dir.equals("N")) nx--;
                else if (dir.equals("S")) nx++;
                else if (dir.equals("W")) ny--;
                else if (dir.equals("E")) ny++;

                if (nx < 0 || ny < 0 || nx >= h || ny >= w || park[nx].charAt(ny) == 'X') {
                    isRun = false;
                    break;
                }
            }

            if (isRun) {
                x = nx;
                y = ny;
            }
        }

        return new int[]{x, y};
    }
}
