#include<stdio.h>
inline int min(int a, int b){ return ((a < b) ? a : b); }
int go(int nameC, int used);

//D[이름번호][사용중인 위치] 일때 이후로 최소값이 저장됨
int D[1001][1001];
int nameList[1001];
int n, m;
int squareSum;
int used;

int main()
{
	scanf("%d %d", &n, &m);
	for (int i = 0; i < n; i++)
		scanf("%d", &nameList[i]);
	
	for (int i = 0; i < 1001; i++)
	for (int j = 0; j < 1001; j++)
			D[i][j] = -1;

	printf("%d\n", go(0,0));

}

int go(int nameC, int used)
{
	if (nameC == n) return 0;
	if (D[nameC][used] != -1) return D[nameC][used];

	//현재 이름이 현재 라인에 들어갈 수 없는 경우
	if ((nameList[nameC] + 1 ) > (m - used))
	{
		D[nameC][used] = go(nameC ,0) + (m - used)*(m - used);
	}
	//현재 줄에 들어갈지 다음 줄에 들어갈지 결정
	else
	{
		//같은 줄에 들어가는 경우
		int t1 = go(nameC + 1, nameList[nameC] + used + (used ? 1:0));
		//다음 줄에 넣는 경우
		int t2 = go(nameC + 1, nameList[nameC]) + (m - used)*(m - used);
		D[nameC][used] = min(t1, t2);
	}
	return D[nameC][used];
}