/*
https://school.programmers.co.kr/learn/courses/30/lessons/258709
주사위 고르기

 */

import java.util.ArrayList;
import java.util.List;

public class Sol_258709 {

    private class DiceGroup {
        public List<Integer> diceIdx = new ArrayList<>();

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("Group [");

            for(int i = 0; i < diceIdx.size(); i++) {
                builder.append(diceIdx.get(i));
                if (i != diceIdx.size() - 1) {
                    builder.append(", ");
                }
            }
            builder.append("]");
            return builder.toString();
        }
    }

    public int[] solution(int[][] dice) {
        int n = dice.length;
        int half = n / 2;

        List<DiceGroup> diceGroups = generateCombinations(n, half);
        for(DiceGroup dg : diceGroups) System.out.println(dg);

        return new int[half];
    }

    // 조합 생성 메서드
    private List<DiceGroup> generateCombinations(int n, int r) {
        List<DiceGroup> result = new ArrayList<>();
        backtrack(0, n, r, new DiceGroup(), result);
        return result;
    }

    private void backtrack(int start, int n, int r, DiceGroup current, List<DiceGroup> result) {

        // 절반 만큼 만들어졌으면 전체 리스트에 추가
        if (current.diceIdx.size() == r) {
            DiceGroup copy = new DiceGroup();
            copy.diceIdx.addAll(current.diceIdx);
            result.add(copy);
            return;
        }

        for (int i = start; i < n; i++) {
            current.diceIdx.add(i); // 현재 인덱스를 조합에 추가
            backtrack(i + 1, n, r, current, result); // 다음 숫자부터 재귀적으로 조합 생성
            current.diceIdx.remove(current.diceIdx.size() - 1); // 백트래킹 (방문 취소)
        }
    }
}
