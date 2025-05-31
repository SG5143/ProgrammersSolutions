/*
    https://school.programmers.co.kr/learn/courses/30/lessons/42842#qna
    Leo는 카펫을 사러 갔다가 아래 그림과 같이 중앙에는 노란색으로 칠해져 있고
    테두리 1줄은 갈색으로 칠해져 있는 격자 모양 카펫을 봤습니다.

    Leo는 집으로 돌아와서 아까 본 카펫의 노란색과 갈색으로 색칠된 격자의 개수는 기억했지만,
    전체 카펫의 크기는 기억하지 못했습니다.

    Leo가 본 카펫에서 갈색 격자의 수 brown,
    노란색 격자의 수 yellow가 매개변수로 주어질 때 카펫의 가로,
    세로 크기를 순서대로 배열에 담아 return 하도록 solution 함수를 작성해주세요.

    제한사항
    갈색 격자의 수 brown은 8 이상 5,000 이하인 자연수입니다.
    노란색 격자의 수 yellow는 1 이상 2,000,000 이하인 자연수입니다.
    카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 깁니다.
 */

public class Sol_42842 {
    public int[] solution(int brown, int yellow) {

        // 총 격자의 개수
        int total = brown + yellow;

        // 최소 높이는 3, 최대 높이는 총 격자수를 제곱근한 값
        for (int h = 3; h < Math.sqrt(total) + 1; h++) {
            // 총 격자가 높이 값으로 나누어 떨어지면
            if (total % h == 0) {
                int width = total / h;
                // 가로가 세로보다 같거나 길면
                if (width >= h) {
                    // 내부 격자 수가 일치하면
                    if ((width - 2) * (h - 2) == yellow) {
                        return new int[]{width, h};
                    }
                }
            }
        }

        return new int[]{};
    }
}
