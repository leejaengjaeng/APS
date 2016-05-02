/*
import java.util.Scanner;

public class Jennifer_B {

	public static char theater[][];
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		theater = new char[N][N];
		
		//둘이상 빈자리를 저장하기 위한 리스트 
		myList start = new myList();
		
		//theater 초기화
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
		
		//빈자리 탐색
		searchEmptySheets(N,start);
		
		//커플이 앉을 수 있는 자리 세기
		myList tmpList = start.next;
		int totalCnt=0;
		while(tmpList!=null)
		{
			//n자리가 연속되어있으면 n-1가지 수 만큼 앉을 수 있는 방법이 존재 
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
					//한자리만 비었다면 변수 초기화 후 continue
					//두자리 이상 붙어있다면 리스트에 넣기 
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
			//다음 줄로 넘어가기 전에 검사 
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
// theater[i][j]위치가 비었다면  j와 j옆으로 몇칸이 비었는지를 저장 
class myList
{
	//연속된 빈자리의 시작 위치 
	public int pos;
	//자신을 포함한 연속된 빈자리의 수
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