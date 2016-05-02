/*
import java.util.Scanner;

public class Jennifer_B {

	public static char theater[][];
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		theater = new char[N][N];
		
		//���̻� ���ڸ��� �����ϱ� ���� ����Ʈ 
		myList start = new myList();
		
		//theater �ʱ�ȭ
		String tmp = null;
		for(int i=0;i<N;i++)
		{
			tmp = sc.next();
			for(int j=0;j<N;j++)
			{
				if(tmp.charAt(j)=='*') theater[i][j]='*';
				else theater[i][j]='.';
			}
		}
		
		//���ڸ� Ž��
		searchEmptySheets(N,start);
		
		//Ŀ���� ���� �� �ִ� �ڸ� ����
		myList tmpList = start.next;
		int totalCnt=0;
		while(tmpList!=null)
		{
			//n�ڸ��� ���ӵǾ������� n-1���� �� ��ŭ ���� �� �ִ� ����� ���� 
			totalCnt += tmpList.value-1;
			tmpList = tmpList.next;
		}
		System.out.println(totalCnt);
	}
	public static void searchEmptySheets(int N,myList start)
	{
		int connectedSheetCnt=0;
		int pos=-1;
		boolean isBeforeEmpty=false;
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				if(theater[i][j]=='.')
				{
					if(isBeforeEmpty==false)
					{
						pos=j;
						connectedSheetCnt++;
						isBeforeEmpty=true;
						continue;
					}
					else //isBeforeEmpty==true
					{
						connectedSheetCnt++;
						continue;
					}
				}
				else //theater[i][j]=='*'
				{
					//���ڸ��� ����ٸ� ���� �ʱ�ȭ �� continue
					//���ڸ� �̻� �پ��ִٸ� ����Ʈ�� �ֱ� 
					if(connectedSheetCnt>0)
					{
						if(connectedSheetCnt>1)
						{
							myList newSheet = new myList(pos,connectedSheetCnt);
							start.addToLast(newSheet);
						}
						connectedSheetCnt=0;
						isBeforeEmpty=false;
					}
					continue;
				}
			}//end of InnerLoop
			//���� �ٷ� �Ѿ�� ���� �˻� 
			if(connectedSheetCnt>1)
			{
				myList newSheet = new myList(pos,connectedSheetCnt);
				start.addToLast(newSheet);
			}
			connectedSheetCnt=0;
			isBeforeEmpty=false;
			pos=-1;
		}
	}
	
}
// theater[i][j]��ġ�� ����ٸ�  j�� j������ ��ĭ�� ��������� ���� 
class myList
{
	//���ӵ� ���ڸ��� ���� ��ġ 
	public int pos;
	//�ڽ��� ������ ���ӵ� ���ڸ��� ��
	public int value;
	
	public myList next;
	public myList last;
	
	public myList()
	{
		pos=-1;
		value=0;
		next=null;
		last=this;
	}
	public myList(int p,int v)
	{
		pos=p;
		value=v;
		next = null;
		last = null;
	}
	public void addToLast(myList m)
	{
		last.next = m;
		last=m;
	}
}
*/