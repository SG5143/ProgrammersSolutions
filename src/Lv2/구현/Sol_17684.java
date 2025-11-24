package Lv2.구현;

import java.util.*;

public class Sol_17684 {
    public int[] solution(String msg) {
        Map<String, Integer> dict = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            dict.put(String.valueOf((char) ('A' + i)), i + 1);
        }

        List<Integer> out = new ArrayList<>();
        int nextIndex = 27;
        int i = 0;
        while (i < msg.length()) {
            int j = i + 1;
            while (j < msg.length() && dict.containsKey(msg.substring(i, j + 1))) {
                j++;
            }
            String w = msg.substring(i, j);
            out.add(dict.get(w));
            if (j < msg.length()) {
                dict.put(msg.substring(i, j + 1), nextIndex++);
            }
            i += w.length();
        }

        int[] answer = new int[out.size()];
        for (int k = 0; k < out.size(); k++) answer[k] = out.get(k);
        return answer;
    }

    public static void main(String[] args) {
        Sol_17684 solver = new Sol_17684();
        System.out.println(Arrays.toString(solver.solution("KAKAO"))); // [11, 1, 27, 15]
        System.out.println(Arrays.toString(solver.solution("TOBEORNOTTOBEORTOBEORNOT")));
    }
}
