package Lv2.해시맵;

import java.util.*;

public class Sol_42888 {
    public static String[] solution(String[] record) {
        Map<String, String> nick = new HashMap<>();
        List<String> actions = new ArrayList<>();
        List<String> uids = new ArrayList<>();

        for (String r : record) {
            String[] parts = r.split(" ");
            String cmd = parts[0];
            String id = parts[1];

            if (cmd.equals("Enter")) {
                String name = parts[2];
                nick.put(id, name);
                actions.add("Enter");
                uids.add(id);
            } else if (cmd.equals("Leave")) {
                actions.add("Leave");
                uids.add(id);
            } else if (cmd.equals("Change")) {
                String name = parts[2];
                nick.put(id, name);
            }
        }

        String[] answer = new String[actions.size()];
        for (int i = 0; i < actions.size(); i++) {
            String name = nick.get(uids.get(i));
            if (actions.get(i).equals("Enter")) {
                answer[i] = name + "님이 들어왔습니다.";
            } else {
                answer[i] = name + "님이 나갔습니다.";
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] record = {
                "Enter uid1234 Muzi",
                "Enter uid4567 Prodo",
                "Leave uid1234",
                "Enter uid1234 Prodo",
                "Change uid4567 Ryan"
        };
        String[] result = solution(record);
        System.out.println(Arrays.toString(result));
    }
}
