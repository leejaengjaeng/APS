#include <cstdio>
void makeBase(int** base, int row, int col);
void deleteBase(int** base, int row);

int main()
{
	int n, row, col;
	scanf("%d", &n);
	int** base;
	int tmpCount, sumCount;
	for (int i = 0; i < n; i++)
	{
		scanf("%d %d", &row, &col);
		base = new int*[row];
		makeBase(base, row, col);

		tmpCount = 0;
		sumCount = 0;
		for (int j = 0; j < col; j++)
		{
			for (int k = row - 1; k >= 0; k--)
			{
				if (base[k][j] == 1) sumCount += tmpCount;
				else tmpCount++;
			}
			tmpCount = 0;
		}
		printf("%d\n", sumCount);
		deleteBase(base, row);
	}
}
void makeBase(int** base, int row, int col)
{
	for (int j = 0; j < row; j++)
	{
		base[j] = new int[col];
		for (int k = 0; k < col; k++)
			scanf("%d", &base[j][k]);
	}
}
void deleteBase(int** base, int row)
{
	for (int j = 0; j < row; j++)
	{
		delete(base[j]);
	}
	delete(base);
}