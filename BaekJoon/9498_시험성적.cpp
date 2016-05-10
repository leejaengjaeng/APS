#include<stdio.h>

int main(void)
{
	int n = 0;
	scanf("%d", &n);
	char score = '\0';
	
	if (n >= 90) score = 'A';
	else if (n >= 80) score = 'B';
	else if (n >= 70) score = 'C';
	else if (n >= 60) score = 'D';
	else score = 'F';
	printf("%c", score);
}
