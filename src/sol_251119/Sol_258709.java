package sol_251119;/*
    https://school.programmers.co.kr/learn/courses/30/lessons/258709
    주사위 고르기
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sol_258709 {
    private static class DiceGroup {
        public List<Integer> diceIdx = new ArrayList<>();

        @Override
        public String toString() {
            return diceIdx.toString();
        }
    }

    public int[] solution(int[][] dice) {
        int n = dice.length;
        int half = n / 2;

        List<DiceGroup> aGroups = generateCombinations(n, half);

        int maxWin = -1;
        int[] answer = new int[half];

        for (DiceGroup aGroup : aGroups) {
            // 현재 A 주사위 조합을 참고해 나머지 주사위를 B 조합으로
            List<Integer> bGroup = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (!aGroup.diceIdx.contains(i)) bGroup.add(i);
            }

            // 주사위 조합으로 나올 수 있는 모든 합 계산
            List<Integer> aSums = getAllSums(aGroup.diceIdx, dice);
            List<Integer> bSums = getAllSums(bGroup, dice);

            Collections.sort(bSums);
            int winCount = 0;
            for (int aSum : aSums) {
                winCount += countLessThan(bSums, aSum);
            }

            if (winCount > maxWin) {
                maxWin = winCount;
                for (int i = 0; i < half; i++) {
                    answer[i] = aGroup.diceIdx.get(i) + 1;
                }
            }
        }

        Arrays.sort(answer);
        return answer;
    }

    // 주사위 인덱스로 만들 수 있는 모든 합 조합 구하기
    private List<Integer> getAllSums(List<Integer> diceGroup, int[][] dice) {
        List<Integer> result = new ArrayList<>();
        DFS(diceGroup, dice, 0, 0, result);
        return result;
    }

    private void DFS(List<Integer> diceGroup, int[][] dice, int depth, int sum, List<Integer> result) {
        if (depth == diceGroup.size()) {
            result.add(sum);
            return;
        }

        int[] currentDice = dice[diceGroup.get(depth)];
        for (int a : currentDice) {
            DFS(diceGroup, dice, depth + 1, sum + a, result);
        }
    }

    // 이분 탐색으로 bSums에서 target보다 작은 값 개수 구하기
    private int countLessThan(List<Integer> list, int target) {
        int left = 0;
        int right = list.size();

        while (left < right) {
            int mid = (right + left) / 2;
            if (list.get(mid) < target) left = mid + 1;
            else right = mid;
        }
        return left;
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
