#include <cstdio>
#include <queue>
int **base;

using namespace std;

int main()
{
	int n;
	scanf("%d", &n);
	base = new int*[n];
	for (int i = 0; i < n; i++)
	{
		base[i] = new int[n];
		for (int j = 0; j < n; j++)
		{
			scanf("%d", &base[i][j]);
		}
	}
	queue<int> q;
	int t;
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			if (base[i][j] == 1) q.push(j);
		}
		while (!q.empty())
		{
			t = q.front(); q.pop();
			for (int j = 0; j < n; j++)
			{
				if (base[t][j] == 1 && base[i][j] != 1)
				{
					base[i][j] = 1;
					q.push(j);
				}
			}
		}
	}

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			printf("%d ", base[i][j]);
		}
		printf("\n");
	}
}

