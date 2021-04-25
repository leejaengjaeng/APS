package problems;

import java.math.BigInteger;

public class MultiplyStrings {

    public static void main(String[] args) {
        System.out.println(multiply("2","4"));
    }

    public static String multiply(String num1, String num2) {
        return new BigInteger(num1).multiply(new BigInteger(num2)).toString();
    }
}
