#include <cstdio>

int main()
{
	int h, m, reqM;
	scanf("%d %d\n%d", &h, &m, &reqM);

	int plusH = reqM / 60;

	reqM = reqM % 60;

	m = reqM + m;
	if (m >= 60)
	{
		plusH += m / 60;
		m = m % 60;
	}
	
	h = h + plusH;
	
	while (h >= 24)
	{
		h = h - 24;
	}
	printf("%d %d",h,m);
}