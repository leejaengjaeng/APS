package kakao_blind_2021;

/*
https://programmers.co.kr/learn/courses/30/lessons/72411


order 정렬해서 반쪽짜리 course 만큼 조합 만들고 (AC가 있으면 CA는 없도록)
count 제일 높은거 뽑아서 리턴

제출하면 런타임 에러... 왜죠..
*/

import java.util.*;
import java.util.stream.Collectors;

public class 메뉴리뉴얼 {

    public static void main(String[] args) {

        String[] aaaaa = solution(new String[]{
                "ASDFGHJKLQ",
                "ASDFGHJKLQ",
                "ASDFGHJKLQ",
                "ASDFGHJKLQ",
                "ASDFGHJKLQ",
                "ASDFGHJKLQ",
                "ASDFGHJKLQ",
                "ASDFGHJKLQ",
                "ASDFGHJKLQ",
                "ASDFGHJKLQ",
                "ASDFGHJKLQ",
                "ASDFGHJKLQ",
                "ASDFGHJKLQ",
                "ASDFGHJKLQ",
                "ASDFGHJKLQ",
                "ASDFGHJKLQ",
                "ASDFGHJKLQ",
                "ASDFGHJKLQ",
                "ASDFGHJKLQ",
                "ASDFGHJKLQ"
        }, new int[]{2,3,4,5,6,7,8,9,10});
        String c = "";
    }

    public static String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();

        for (int courseSize : course) {
            Map<String, Course> createdCourse = new HashMap<>();
            for (String order : orders) {
                char[] orderChars = order.toCharArray();
                Arrays.sort(orderChars);
                generateCourse(0, "", orderChars, courseSize, createdCourse);
            }

            List<Course> sortedCourse = createdCourse.values()
                                                    .stream()
                                                    .filter(entry -> entry.count > 1)
                                                    .sorted()
                                                    .collect(Collectors.toList());
            if(!sortedCourse.isEmpty()) {
                int bestCourseCount = sortedCourse.get(0).count;
                for(Course currentCreatedCourse : sortedCourse) {
                    if(currentCreatedCourse.count == bestCourseCount) {
                        answer.add(currentCreatedCourse.menu);
                    } else {
                        break;
                    }
                }
            }
        }

        Collections.sort(answer);
        return answer.toArray(new String[]{});
    }

    public static void generateCourse(int currentIndex, String currentMenu, char[] sortedOrder, int courseSize, Map<String, Course> createdCourse) {
        if (currentMenu.length() == courseSize) {
            if (createdCourse.containsKey(currentMenu)) {
                createdCourse.get(currentMenu).count++;
            } else {
                createdCourse.put(currentMenu, new Course(currentMenu));
            }
            return;
        }

        for (int i = currentIndex; i < sortedOrder.length; i++) {
            generateCourse(i + 1, currentMenu + sortedOrder[i], sortedOrder, courseSize, createdCourse);
        }
    }
}

class Course implements Comparable<Course> {
    String menu;
    int count;

    public Course(String menu) {
        this.menu = menu;
        this.count = 1;
    }

    @Override
    public int compareTo(Course o) {
        return count < o.count ? 1 : -1;
    }
}

