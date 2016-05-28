//A¹ø
#include <cstdio>
int main()
{
	int n;
	int st[8];
	int ad[4];
	int total = 0;
	scanf("%d", &n);
	for (int i = 0; i < n; i++)
	{
		st[0] = 0; st[1] = 0; st[2] = 0; st[3] = 0;
		st[4] = 0; st[5] = 0; st[6] = 0; st[7] = 0;
		ad[0] = 0; ad[1] = 0; ad[2] = 0; ad[3] = 0;
		total = 0;
		for (int j = 0; j < 8; j++)
		{
			scanf("%d", &st[j]);
		}
		ad[0] = st[0] + st[4];
		ad[1] = st[1] + st[5];
		ad[2] = st[2] + st[6];
		ad[3] = st[3] + st[7];
		if (ad[0] <= 1) ad[0] = 1;
		if (ad[1] <= 1) ad[1] = 1;
		if (ad[2] <= 0) ad[2] = 0;
		total = ad[0] + 5 * ad[1] + 2 * ad[2] + 2 * ad[3];
		printf("%d\n", total);
	}
}

