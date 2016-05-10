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
		
		// 0:�� �� ����, 1:�ǹ�, 2:������ ��� , 3: ���� ��� 
		map = new int[Row][Col];
		DirInCol = new int[Col];
		
		// ��ġ ���� �Է�
		//�ǹ��� �ִ� ��ġ�� ����� ��ġ�� ���
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
		
		//DirInCol �ʱ�ȭ
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
		
		//������ ���� �˻� �Ҷ� ���� �ݺ�
		while(stage<Row)
		{
			dir =0;
			map[curR][curC]=2;
			//������ ������ �̵�
		innerLoop: while(curC<Col && stage<Row)
			{	
				DirInCol[curC]=dir;
	
				sw=canForward(curR,curC,dir);
			//��� Ž�� 
			//0: Ž�� ����, 1: ��� Ž�� ����, 2: ������ ���� ����, 3: ��� �� 
				while(sw==0)
				{
					DirInCol[curC] = ++dir;
					sw = canForward(curR,curC,dir);
				}
			//���� ��� ����  
				if(sw==1)
				{
					// 0 : �� 
					if(dir==0)
					{
						curC = curC+1;
						curR = curR-1;
						map[curR][curC]=2;
					}
					// 1 : ��
					else if(dir==1)
					{
						curC = curC+1;
						//curR = curR;
						map[curR][curC]=2;
					}
					//  2 : ��
					else if(dir==2)
					{
						curC = curC+1;
						curR = curR+1;
						map[curR][curC]=2;
					}
					//���� �ʱ�ȭ
					dir=0;
				}
			//��� �ϼ�
				else if(sw==2)
				{
					stage++;
					mCount++;
					if(mCount>MaxCount) MaxCount=mCount;
					curC = 0;
					curR = stage;
					dir=0;
					
					//������ ������������ �ϼ��Ǹ� 
					if(stage>=Row) break innerLoop;
				}
			//�ǵ��ư����� 
				else if(sw==3)
				{
					//���� ��η� ǥ��
					map[curR][curC]=3;
				
					//������ �湮�ߴ� curR�� ��ǥ�� ������� 
					curR = getBackPointR(curR,curC);
							
					//������ġ, �ٱ� ������ �̵�
					if(curR==-1)
						break innerLoop;
					//����
					else if(curR==-999)
						System.out.println("err curR=-999");
					//�ϳ� ������ ������ �̵�
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
	
		
	//direction ) 0:�� , 1:�� , 2:��
	//retVal ) 0:�Ұ� ,1:����, 2:������ C����, 3:�����ִ� ���� ����(������ ������ �ƴ� �ٸ� ���� �Էµ� ���) 
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
	
	//���� ��ġ�� -1�� ����
	public static int getBackPointR(int row,int col)
	{
		int retValue=-1;
		//������ġ�� ���� ���� ���
		if(col==0) retValue=-1;
		//���� ��ġ Ž��
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
	
	
	
