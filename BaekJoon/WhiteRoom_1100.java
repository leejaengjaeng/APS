import java.util.Scanner;

public class WhiteRoom_1100 {
	public static void main(String[] agrs)
	{
		String str[] = new String[8];
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<8;i++)
		{
			str[i] = sc.nextLine();
		}
		int min=0;
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				if(i%2==0 && j%2==0 && str[i].charAt(j)=='F') min++;
				else if(i%2==1 && j%2==1 && str[i].charAt(j)=='F') min++;
			}
		}
		System.out.println(min);
	}
}
