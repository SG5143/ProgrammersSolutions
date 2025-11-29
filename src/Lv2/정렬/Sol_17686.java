package Lv2.정렬;

import java.util.*;

public class Sol_17686 {
    private static class FileInfo {
        String original;
        String headLower;
        int numberValue;
        int index;

        FileInfo(String original, String headLower, int numberValue, int index) {
            this.original = original;
            this.headLower = headLower;
            this.numberValue = numberValue;
            this.index = index;
        }
    }

    public String[] solution(String[] files) {
        List<FileInfo> list = new ArrayList<>();
        for (int idx = 0; idx < files.length; idx++) {
            String f = files[idx];
            int i = 0, n = f.length();
            while (i < n && !Character.isDigit(f.charAt(i))) i++;
            int j = i;
            while (j < n && Character.isDigit(f.charAt(j)) && j - i < 5) j++;
            String head = f.substring(0, i);
            String number = f.substring(i, j);
            int numberVal = 0;
            try {
                numberVal = Integer.parseInt(number);
            } catch (NumberFormatException e) {}
            list.add(new FileInfo(f, head.toLowerCase(), numberVal, idx));
        }

        list.sort((a, b) -> {
            int cmp = a.headLower.compareTo(b.headLower);
            if (cmp != 0) return cmp;
            if (a.numberValue != b.numberValue) return Integer.compare(a.numberValue, b.numberValue);
            return Integer.compare(a.index, b.index);
        });

        String[] ans = new String[files.length];
        for (int k = 0; k < list.size(); k++) ans[k] = list.get(k).original;
        return ans;
    }

    public static void main(String[] args) {
        Sol_17686 s = new Sol_17686();
        String[] input = {"img12.png", "img10.png", "img2.png", "img1.png"};
        String[] output = s.solution(input);
        for (String o : output) System.out.println(o);
    }

}
