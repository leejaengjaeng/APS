package test;

/*
 */

import java.io.*;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class SampleTest1 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = IntStream.range(0, arrCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
        .map(String::trim)
        .map(Integer::parseInt)
        .collect(toList());

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.findNumber(arr, k);
        System.out.println(result);

//        bufferedWriter.write(result);
//        bufferedWriter.newLine();

        bufferedReader.close();
//        bufferedWriter.close();
    }
}

class Result {
    private static final String YES = "YES";
    private static final String NO = "NO";
    /*
     * Complete the 'findNumber' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER k
     */
    public static String findNumber(List<Integer> arr, int k) {
        Collections.sort(arr);
        return Collections.binarySearch(arr, k) >= 0 ?  YES : NO;
    }

}
