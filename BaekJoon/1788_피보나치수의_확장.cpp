#include<stdio.h>

int main()
{
	int find;
	scanf("%d", &find);
	int n = find < 0 ? -find : find;
	long long t1,t2,t3;
	t1 = 0;
	t2 = 1;
	for (int i = 2; i <= n; i++)
	{
		t3 = t1 + t2;
		if (t3 >= 1000000000) t3 = t3 % 1000000000;
		t1 = t2;
		t2 = t3;
	}
	
	if (find == 0) printf("0\n");
	else if (find < 0 && find % 2 == 0) printf("-1\n");
	else printf("1\n");
	
	if (find == 0) t3 = 0;
	else if (find == 1 || find==-1) t3 = 1;

	printf("%lld\n", t3);
}