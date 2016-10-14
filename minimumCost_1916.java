package baekjoon;

/*
 * ���ͽ�Ʈ�� �⺻����
 */

import java.util.Scanner;
 
public class minimumCost_1916 {
     
	public final static int INF = 987654321;
    public static int paths[][];
    public static int dist[];
    public static boolean visited[];
     
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int cityNum = Integer.parseInt(sc.nextLine());
        int busNum = Integer.parseInt(sc.nextLine());
         
        paths = new int[cityNum+1][cityNum+1];
        dist = new int[cityNum+1];
        visited = new boolean[cityNum+1];
         
        //path �ʱ�ȭ
        for(int i=0;i<=cityNum;i++)
        	for(int j=0;j<=cityNum;j++)
        		paths[i][j]=INF;
        //dist �ʱ�ȭ
        for(int i=0;i<=cityNum;i++)
            dist[i] = INF;
        //��� �Է�
        for(int i=1;i<=busNum;i++)
        {
        	String inputStr[] = sc.nextLine().split(" ");
            int start = Integer.parseInt(inputStr[0]);
            int end = Integer.parseInt(inputStr[1]);
            int dist = Integer.parseInt(inputStr[2]);
            
            if(paths[start][end]!=INF)
				paths[start][end] =	paths[start][end] < dist ? paths[start][end] : dist;
			else				
				paths[start][end] = dist;
	
        }
        
        String inputStr[] = sc.nextLine().split(" ");
        int startP = Integer.parseInt(inputStr[0]);
        int endP = Integer.parseInt(inputStr[1]);
        
        
        //���ͽ�Ʈ��
        dist[startP]=0; //�ʱ����� startP�� �⵵�� dist�� 0���� �ʱ�ȭ 
        //�ݺ�Ƚ���� ĥ�ؾߵǴ� ������ �̻��̸� selectedPoint�� ����Ʈ �����ε� -> ����Ʈ�� -1�̸� ��Ÿ�� ���� 
        for(int i=0;i<cityNum;i++) 
        {
        	int minPath = INF+1;
        	int selectedPoint= 0;
        	//���� ª�� �Ÿ� ã�� 
        	// -> �켱 ����ť���� �ڵ����� �ּ� ��� �̾��ִ°� �������� ���� 
        	for(int j=1;j<=cityNum;j++)
        	{
        		if(!visited[j] && minPath > dist[j])
        		{
        			minPath=dist[j];
        			selectedPoint=j;
        		}
        	}
        	visited[selectedPoint]=true;

        	//ã���� �ϴ� ������ �湮�Ǹ� ����
        	if(selectedPoint==endP || selectedPoint==0) break;
        	
        	// ��� ����
        	for(int j=1;j<=cityNum;j++)
        	{
        		//�湮���� ����, ���� ������ ������ �������� ���̸� ����
        		if(!visited[j] && paths[selectedPoint][j]!=INF)
        		{
        			int dist1 = dist[j];
        			int dist2 = dist[selectedPoint]+paths[selectedPoint][j];
        			dist[j] = dist1 < dist2 ? dist1:dist2;   			
        		}
        	}	
        }
        System.out.println(dist[endP]);
        
         
    }     
}
