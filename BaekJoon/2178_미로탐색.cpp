#include <cstdio>
#include <queue>
int **base;

using namespace std;

int main()
{
	int r, c;
	scanf("%d %d", &r, &c);
	base = new int*[r];
	for (int i = 0; i < r; i++)
		base[i] = new int[c];

	getchar();
	for (int i = 0; i < r; i++)
	{
		for (int j = 0; j < c; j++)
		{
			base[i][j] = getchar() - '0';
		}
		getchar();
	}

	//출구 설정
	r--; c--;

	queue<int> iq;
	queue<int> jq;
	queue<int> wq;

	iq.push(0);
	jq.push(0);
	wq.push(1);

	int ci, cj, cw;

	while (!iq.empty())
	{
		
		ci = iq.front(); iq.pop();
		cj = jq.front(); jq.pop();
		cw = wq.front(); wq.pop();

		if (ci == r && cj == c)	break;

		//오른쪽 검사
		if (cj == c);
		else if (base[ci][cj + 1] == 1)
		{
			base[ci][cj + 1] = 2;
			iq.push(ci);
			jq.push(cj + 1);
			wq.push(cw + 1);
		}
		else;
		//아래쪽 검사
		if (ci == r);
		else if (base[ci + 1][cj] == 1)
		{
			base[ci+1][cj] = 2;
			iq.push(ci + 1);
			jq.push(cj);
			wq.push(cw + 1);
		}
		else;
		//위쪽 검사
		if (ci == 0);
		else if (base[ci - 1][cj] == 1)
		{
			base[ci - 1][cj] = 2;
			iq.push(ci - 1);
			jq.push(cj);
			wq.push(cw + 1);
		}
		else;
	
		//왼쪽 검사
		if (cj == 0);
		else if (base[ci][cj - 1] == 1)
		{

			base[ci][cj-1] = 2;
			iq.push(ci);
			jq.push(cj - 1);
			wq.push(cw + 1);
		}
		else;
		
	}
	printf("%d", cw);

}

