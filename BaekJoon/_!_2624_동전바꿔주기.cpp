#include<stdio.h>

int D[101][10001];

int main()
{
	int n,T;
	int coin[101];
	int cnt[101];

	scanf("%d\n%d",&T,&n);

	//모든 0가격은 1로 초기화 해둬야지 가능 
	D[0][0] = 1;
	for (int i = 1; i <= n; i++)
	{
		D[i][0] = 1;
		scanf("%d %d", &coin[i], &cnt[i]);
	}
	for (int i = 1; i <= n; i++)
	{
		for (int j = 1; j <= T; j++)
		{
			for (int k = 0; k <= cnt[i]; k++)
			{
				//최대 가격 전까지만 확인
				if (j - coin[i] * k < 0) break;
			
				/*
					i번째 j가격의 경우의 수는 i번째 j가격 더하기 
					(j가격 - i번째 동전의 가격)이 되는 경우의 수  
				*/

				D[i][j] += D[i - 1][j - coin[i] * k];
				
				/*
				ex) 동전 1개(5원)을 넣을때 가격 5원의 경우의 수는 
					동전 0개를 넣을때 가격(가격5 - 동전가치 5원)원
					-> 5원짜리를 넣을떄 10원이 되려면 이전에 5원이 되는 경우의 수 
					    + 새로넣는 5원 이니깐
				*/
			}
		}
	}
	printf("%d\n", D[n][T]);
}