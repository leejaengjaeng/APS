#include<cstdio>
#include<iostream>
using namespace std;

const int MAX = 3001;
char base[MAX][MAX];

int main()
{
	int n; scanf("%d", &n);
	for (int i = 0; i<n; i++) scanf("%s", base[i]);

	int sol = 0;

	for (int i = 0; i<n; i++)
	for (int j = 0; j<n; j++)
	if (base[i][j] == '1')
	for (int k = 1;; k++)
	{
		// provjeravam jel 2k+1 okej
		if (i - k < 0 || i + k >= n || j - k < 0 || j + k >= n) break;
		if (base[i][j - k] == '0' || base[i][j + k] == '0' || base[i - k][j] == '0' || base[i + k][j] == '0') break;
		int ok = 1;
		for (int x = 0; ok && x < 2 * k + 1; x++)
		if (x != k) if (base[i - k][j - k + x] == '1' || base[i + k][j - k + x] == '1') ok = 0;
		for (int y = 0; ok && y < 2 * k + 1; y++)
		if (y != k) if (base[i - k + y][j - k] == '1' || base[i - k + y][j + k] == '1') ok = 0;
		if (ok == 0) break;
		sol++; //cout << i << " " << j << endl;
	}

	printf("%d\n", sol);
	return 0;
}
