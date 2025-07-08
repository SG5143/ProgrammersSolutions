/*
https://school.programmers.co.kr/learn/courses/30/lessons/161990
바탕화면 정리
 */

public class Sol_161990 {
    public int[] solution(String[] wallpaper) {
        int[] result = new int[]{50, 50, 0, 0};
        int height = wallpaper.length;
        int width = wallpaper[0].length();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    result[0] = Math.min(result[0], i);
                    result[1] = Math.min(result[1], j);

                    result[2] = Math.max(result[2], i+1);
                    result[3] = Math.max(result[3], j+1);
                }
            }
        }

        return result;
    }
}
