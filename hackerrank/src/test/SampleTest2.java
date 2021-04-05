package test;

/*
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SampleTest2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        int r = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> result = Result2.oddNumbers(l, r);
        System.out.println(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
        );
//        bufferedWriter.write(
//                result.stream()
//                        .map(Object::toString)
//                        .collect(joining("\n"))
//                        + "\n"
//        );

        bufferedReader.close();
//        bufferedWriter.close();
    }
}

class Result2 {
    /*
     * Complete the 'findNumber' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER k
     */

    /*
    public class Main {
    public static boolean isPrime(int num){
        for(int i=2; i*i<=num; i++){
            if(num % i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
       System.out.println(isPrime(80));
       System.out.println(isPrime(79));
    }
    }
     */
    public static List<Integer> oddNumbers(int l, int r) {
        // Write your code here
        List<Integer> result = new ArrayList<>((r-l)/2+1);
        int startLeft = l % 2 == 0 ? l + 1 : l;
        for (int start = startLeft; start <= r; start+=2) {
            result.add(start);
        }
        return result;
    }

}
