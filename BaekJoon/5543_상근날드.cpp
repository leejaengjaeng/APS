#include <cstdio>
#include<algorithm>
int main()
{
	int b[3],d[2],set = -50;
	scanf("%d\n%d\n%d\n%d\n%d", &b[0], &b[1], &b[2], &d[0], &d[1]);
	std::sort(b, b + 3); std::sort(d, d + 2);
	set += (b[0] + d[0]);
	printf("%d", set);
}

