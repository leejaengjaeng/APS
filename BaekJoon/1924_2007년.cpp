#include<stdio.h>

int main(void)
{
	int m,d;
	scanf("%d %d",&m,&d);
	int after = 0;
	for (int i = 1; i < m; i++)
	{
		if (i == 2) after += 28;
		else if (i == 4 || i == 6 || i == 9 || i == 11) after += 30;
		else after += 31;
	}
	after += d;

	//1월 1일 다음날 부터 세기 위함 
	after = (after-1) % 7;

	if (after == 0) printf("MON\n");
	else if (after == 1) printf("TUE\n");
	else if (after == 2) printf("WED\n");
	else if (after == 3) printf("THU\n");
	else if (after == 4) printf("FRI\n");
	else if (after == 5) printf("SAT\n");
	else printf("SUN\n");
}
