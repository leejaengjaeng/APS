/*
import java.util.HashMap;
import java.util.Scanner;
//public class Main {
public class Triangle_Yoon_1 {

	public static void mainT(String[] args) {
       
        double pi = Math.acos(-1.0);
        int a = 3;	//m
        int b = 4;	//s
        int d = 6;	//c

        double result;
           
        //double로 형변환
        a *= 1.0;
        b *= 1.0;
        d *= 1.0;
        double part1 = 2*Math.acos((d*d-(a*a-b*b))/(2*a*d));
        double part2 = 2*Math.acos((d*d+(a*a-b*b))/(2*b*d));
        
        double toMinus = (a*a/2)*(part1 -Math.sin(part1))
        				+(b*b)*(part2-Math.sin(part2));
        
        result = part2;//pi*a*a - toMinus;
        		
        System.out.printf("%.3f\n", result);
	}
}
	
*/
