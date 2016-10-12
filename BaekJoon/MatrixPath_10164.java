import java.util.Scanner;
/*
 * 		0,1 0,2 0,3 ...
 *		1,1 1,2 1,3 ...
 *		2,1 2,2 2,3 ... 
 *		�̷�����
 *		n*m ���ڿ��� ��ü ��μ��� (n+m)Cn;   -> (n+m)Cm �̶� ����
 *		�ٵ� �̰� �� ������ �߽��� ���� ���ٰ� �����ϸ� ���� ���� 1ĭ�� ���̸� ��
 */
public class MatrixPath_10164 {

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		sc.nextLine();
		
		long path=0;
		if(K==0)
			path = comb(M+N-2,M-1);
		else
		{
			int ki = K%M == 0 ? K/M-1 : K/M;
			int kj = K%M == 0 ? M : K%M;
			
			path = comb((1+ki)+kj-2,kj-1) * comb(N-ki+M-kj-1,M-kj);  
		}	
		System.out.println(path);	
	}
	public static int comb(int n,int r)
	{
		if(n==r || r==0) return 1;
		else return comb(n-1,r-1)+comb(n-1,r);
	}
}
