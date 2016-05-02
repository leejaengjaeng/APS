import java.util.Scanner;

//public class Main {
public class Bread_Bom_Yoon_2 {

	public static int map[][];
	public static int DirInCol[];
	public static int Row;
	public static int Col;
	public static int MaxCount=0;
	public static void main(String args[]) throws Exception	{
	    
		Scanner sc = new Scanner(System.in);

		Row = sc.nextInt();
		
		Col = sc.nextInt();
		
		// 0:갈 수 있음, 1:건물, 2:지나간 경로 , 3: 막힌 경로 
		map = new int[Row][Col];
		DirInCol = new int[Col];
		
		// 위치 정보 입력
		//건물이 있는 위치는 사용한 위치로 취급
		String tmp = null;
		char ttmp;
		for(int i=0;i<Row;i++)
		{
			tmp = sc.next();
			for(int j =0;j<Col;j++)
			{
				ttmp = tmp.charAt(j);
				if(ttmp=='x') map[i][j] = 1;
				else map[i][j] = 0;
			}
		}
		
		//DirInCol 초기화
		resetDIC();
		routeInit(0);
		
		System.out.println(MaxCount);
	}//end of main
	public static void resetDIC()
	{
		for(int i=0;i<Col;i++)
			DirInCol[i]=-1;
	}
	public static void routeInit(int startR)
	{
		//(r.c)
		int curR=startR;
		int curC=0;
		int dir=0;
		int stage=0;
		int sw;
		int mCount=0;
		
		//마지막 행을 검사 할때 까지 반복
		while(stage<Row)
		{
			dir =0;
			map[curR][curC]=2;
			//마지막 열까지 이동
		innerLoop: while(curC<Col && stage<Row)
			{	
				DirInCol[curC]=dir;
	
				sw=canForward(curR,curC,dir);
			//경로 탐색 
			//0: 탐색 실패, 1: 경로 탐색 성공, 2: 마지막 지점 도착, 3: 경로 퇴각 
				while(sw==0)
				{
					DirInCol[curC] = ++dir;
					sw = canForward(curR,curC,dir);
				}
			//다음 경로 진행  
				if(sw==1)
				{
					// 0 : ↗ 
					if(dir==0)
					{
						curC = curC+1;
						curR = curR-1;
						map[curR][curC]=2;
					}
					// 1 : →
					else if(dir==1)
					{
						curC = curC+1;
						//curR = curR;
						map[curR][curC]=2;
					}
					//  2 : ↘
					else if(dir==2)
					{
						curC = curC+1;
						curR = curR+1;
						map[curR][curC]=2;
					}
					//방향 초기화
					dir=0;
				}
			//경로 완성
				else if(sw==2)
				{
					stage++;
					mCount++;
					if(mCount>MaxCount) MaxCount=mCount;
					curC = 0;
					curR = stage;
					dir=0;
					
					//마지막 스테이지에서 완성되면 
					if(stage>=Row) break innerLoop;
				}
			//되돌아가야함 
				else if(sw==3)
				{
					//막힌 경로로 표시
					map[curR][curC]=3;
				
					//이전에 방문했던 curR의 좌표를 가지고옴 
					curR = getBackPointR(curR,curC);
							
					//시작위치, 바깥 루프로 이동
					if(curR==-1)
						break innerLoop;
					//에러
					else if(curR==-999)
						System.out.println("err curR=-999");
					//하나 이전의 점으로 이동
					else
					{
						curC = curC-1;
						dir = DirInCol[curC]+1;
					}
				}
			}// end of inner Loop
			stage++;
			curR=stage;
			curC=0;
			resetDIC();
		}
	}
	
		
	//direction ) 0:↗ , 1:→ , 2:↘
	//retVal ) 0:불가 ,1:가능, 2:마지막 C도달, 3:갈수있는 길이 없음(정해진 방향이 아닌 다른 값이 입력된 경우) 
	public static int canForward(int r,int c,int dir)
	{
		int retVal = 0;
		
		switch(dir)
		{
		case 0:
			if(r-1<0) retVal = 0;
			else if(c+1>=Col) retVal = 2;
			else
			{
				if(map[r-1][c+1]==0)
					retVal=1;
				else
					retVal=0;
			}
			break;
		case 1:
			if(c+1>=Col) retVal = 2;
			else
			{
				if(map[r][c+1]==0)
					retVal=1;
				else
					retVal=0;
			}
			break;
		case 2:
			if(r+1>=Row) retVal = 0;
			else if(c+1>=Col) retVal = 2;
			else
			{
				if(map[r+1][c+1]==0)
					retVal=1;
				else
					retVal=0;
			}
			break;
		default:
			retVal = 3;
			break;
		}
		return retVal;
	}
	
	//시작 위치면 -1을 리턴
	public static int getBackPointR(int row,int col)
	{
		int retValue=-1;
		//현재위치가 시작 점인 경우
		if(col==0) retValue=-1;
		//이전 위치 탐색
		else
		{
			int dir = DirInCol[col-1];
			switch(dir)
			{
				case 0:
					retValue = row+1;
					break;
				case 1:
					retValue = row;
					break;
				case 2:
					retValue = row-1;
					break;
				default:
				{
					retValue = -999;
				}
			}
		}
		return retValue;
	}
	
}
	
	
	
