import java.util.Scanner;

public class plusCycle_1110 {

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int a = n/10;
		int b = n-a*10;
		int result = -1;
		int count=0;
	
		while(result != n)
		{
			count++;
			result = b*10 + ((a+b)%10); 
			a = result/10;
			b = result -a*10;
		}
		System.out.println(count);

	}
}
