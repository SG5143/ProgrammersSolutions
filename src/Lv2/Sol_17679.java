package Lv2;

import java.util.*;

public class Sol_17679 {
    public int solution(int m, int n, String[] board) {
        // 문자판을 2차원 배열로 변환
        char[][] map = new char[m][n];
        for (int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
        }

        int answer = 0;

        // 더 이상 터질 블록이 없을 때까지 반복
        for (;;) {
            boolean[][] remove = new boolean[m][n]; // 지울 블록 표시
            int count = 0;

            // 2x2 같은 블록 찾기
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    char c = map[i][j];
                    if (c == '.') continue; // 빈칸은 스킵

                    if (c == map[i][j + 1] &&
                            c == map[i + 1][j] &&
                            c == map[i + 1][j + 1]) {

                        remove[i][j] = true;
                        remove[i][j + 1] = true;
                        remove[i + 1][j] = true;
                        remove[i + 1][j + 1] = true;
                    }
                }
            }

            // 표시된 블록 실제로 지우면서 개수 세기
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (remove[i][j]) {
                        count++;
                        map[i][j] = '.'; // 빈칸 표시 (입력에는 '.' 안 나오니까 안전)
                    }
                }
            }

            // 이번 턴에서 아무것도 안 지워졌으면 종료
            if (count == 0) {
                break;
            }

            answer += count;

            // 중력 처리: 위에서 아래로 떨어뜨리기
            for (int j = 0; j < n; j++) {
                int writeRow = m - 1; // 아래에서부터 채워 넣을 위치

                // 아래에서 위로 올라가며 블록만 내려 꽂기
                for (int i = m - 1; i >= 0; i--) {
                    if (map[i][j] != '.') {
                        map[writeRow][j] = map[i][j];
                        if (writeRow != i) {
                            map[i][j] = '.';
                        }
                        writeRow--;
                    }
                }

                // 나머지 위쪽은 빈칸으로 채우기
                for (int i = writeRow; i >= 0; i--) {
                    map[i][j] = '.';
                }
            }
        }

        return answer;
    }
}
