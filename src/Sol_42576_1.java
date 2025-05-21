import java.util.HashMap;

public class Sol_42576_1 {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();

        // participant 배열의 이름 카운트
        for (String name : participant) {
            if (map.containsKey(name)) {
                // 키가 존재하면 기존 값에 1을 더하기
                map.put(name, map.get(name) + 1);
            } else {
                // 키가 없으면 1로 초기화
                map.put(name, 1);
            }
        }

        // completion에 담긴 이름 제거
        for (String name : completion) {
            map.put(name, map.get(name) - 1);
        }

        for (String name : map.keySet()) {
            if (map.get(name) == 1) return name;
        }

        return null;
    }
}
