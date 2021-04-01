package highlevelkit.dp;

/*
https://programmers.co.kr/learn/courses/30/lessons/43105
 */

public class 정수삼각형 {

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
    }


    public static int solution(int[][] triangle) {
        int answer = 0;

        int triangleHeight = triangle.length;
        int[][] longestPath = new int[triangleHeight][triangleHeight];

        longestPath[0][0] = triangle[0][0];

        for (int currentHeight = 1; currentHeight < triangleHeight; currentHeight++) {
            for (int currentNode = 0; currentNode <= currentHeight; currentNode++) {

                int longestRightParent = longestPath[currentHeight - 1][currentNode];
                int currentValue = triangle[currentHeight][currentNode];

                if (currentNode == 0) {
                    longestPath[currentHeight][currentNode] = longestRightParent + currentValue;
                    continue;
                }

                int longestLeftParent = longestPath[currentHeight - 1][currentNode - 1];
                longestPath[currentHeight][currentNode] = Math.max(longestLeftParent, longestRightParent) + currentValue;
            }
        }

        //Arrays.stream(triangle[triangle.length-1]).max().getAsInt();
        for (int i = 0; i < triangleHeight; i++) {
            answer = Math.max(answer, longestPath[triangleHeight - 1][i]);
        }

        return answer;
    }
}

