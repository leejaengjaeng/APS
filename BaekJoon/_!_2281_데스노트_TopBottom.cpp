#include<stdio.h>
inline int min(int a, int b){ return ((a < b) ? a : b); }
int go(int nameC, int used);

//D[�̸���ȣ][������� ��ġ] �϶� ���ķ� �ּҰ��� �����
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

	//���� �̸��� ���� ���ο� �� �� ���� ���
	if ((nameList[nameC] + 1 ) > (m - used))
	{
		D[nameC][used] = go(nameC ,0) + (m - used)*(m - used);
	}
	//���� �ٿ� ���� ���� �ٿ� ���� ����
	else
	{
		//���� �ٿ� ���� ���
		int t1 = go(nameC + 1, nameList[nameC] + used + (used ? 1:0));
		//���� �ٿ� �ִ� ���
		int t2 = go(nameC + 1, nameList[nameC]) + (m - used)*(m - used);
		D[nameC][used] = min(t1, t2);
	}
	return D[nameC][used];
}