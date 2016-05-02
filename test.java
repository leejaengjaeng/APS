/*
import java.util.Scanner;

public class test {
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		String str="";
		int size=0;
		while(true)
		{
			char[] stArr;
			char[] out;

			str = sc.nextLine();
			if(str.equals("END")) break;
			size = str.length();
			stArr = new char[size];
			out = new char[size];
			stArr = str.toCharArray();
			for(int i=size-1;i>=0;i--)
			{
				out[size-i-1] = stArr[i];
			//	out+=str.charAt(i);
			}
			System.out.println(out);

		}
	}
}
*/

import java.util.Scanner;
 
public class test{
    public static void main(String args[])
    {
        double a = 2;
        System.out.println(a);
    }
}