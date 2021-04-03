package kakao_blind_2021;

/*
https://programmers.co.kr/learn/courses/30/lessons/72412
 */

import java.util.*;

public class 순위검색 {

    public static void main(String[] args) {

        int[] a = solution(
                new String[]{"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"},
                new String[]{"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"}
        );

        System.out.println(a);
    }

    /*
    ["java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"]
    ["java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"]
    [1,1,1,1,2,4]

    언어	직군	경력	소울 푸드	점수
    java	backend	junior	pizza	150
    python	frontend	senior	chicken	210
    python	frontend	senior	chicken	150
    cpp	    backend	senior	pizza	260
    java	backend	junior	chicken	80
    python	backend	senior	chicken	50
     */
    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        Map<String, Set<Applicant>> group = new HashMap<>();
        group.put("all", new HashSet<>());

        for (String currentInfo : info) {
            String[] chunk = currentInfo.split(" ");
            String language = chunk[0];
            String major = chunk[1];
            String position = chunk[2];
            String food = chunk[3];

            int score = Integer.parseInt(chunk[4]);
            Applicant applicant = new Applicant(language, major, position, food, score);

            for (int i = 0; i <= 3; i++) {
                if (!group.containsKey(chunk[i])) {
                    group.put(chunk[i], new HashSet<>());
                }
                group.get(chunk[i]).add(applicant);
            }

            group.get("all").add(applicant);
        }

        final String NOT_REQUIRED = "-";

        for (int i = 0; i < query.length; i++) {
            String[] chunks = query[i].split(" and ");

            Set<Applicant> resultSet = null;
            for (int chunkPart = 0; chunkPart <= 2; chunkPart++) {
                String chunk = chunks[chunkPart];
                if (NOT_REQUIRED.equals(chunk)) {
                    continue;
                }

                if (resultSet == null) {
                    resultSet = group.get(chunk);
                } else {
                    resultSet.retainAll(group.get(chunk));
                }
            }

            String[] foodAndScore = chunks[3].split(" ");
            String food = foodAndScore[0];
            if (!NOT_REQUIRED.equals(food)) {
                if (resultSet == null) {
                    resultSet = group.get(food);
                } else {
                    resultSet.retainAll(group.get(food));
                }
            }

            int score = Integer.parseInt(foodAndScore[1]);
            if (resultSet == null || resultSet.isEmpty()) {
                resultSet = group.get("all");
            }

            Applicant[] filteredApplicants = resultSet.toArray(new Applicant[]{});
            Arrays.sort(filteredApplicants);
            answer[i] = getScoreSuitableCount(filteredApplicants, score, 0, filteredApplicants.length);
        }
        return answer;
    }

    /*
        50
            0   1   2   3   4   5   6   7   8
            1   2   5   10  15  50  60  150 200
                            15  50  60  150 200
                            15  50  60
                            15  50
                            15
        100
            0 1
            0
            150
     */

    public static int getScoreSuitableCount(Applicant[] applicants, int targetScore, int searchStart, int searchEnd) {
        int mid = (searchStart + searchEnd) / 2;
        Applicant midApplicant = applicants[mid];

        if (searchStart == mid) {
            return applicants.length - searchStart + (midApplicant.score > targetScore ? 0 : -1);
        }

        if (midApplicant.score < targetScore) {
            return getScoreSuitableCount(applicants, targetScore, mid, searchEnd);
        } else {
            return getScoreSuitableCount(applicants, targetScore, searchStart, mid);
        }

    }
}

class Applicant implements Comparable<Applicant> {
    String language;
    String major;
    String position;
    String food;
    int score;

    public Applicant(String language, String major, String position, String food, int score) {
        this.language = language;
        this.major = major;
        this.position = position;
        this.food = food;
        this.score = score;
    }

    @Override
    public int compareTo(Applicant o) {
        return score - o.score;
    }
}

