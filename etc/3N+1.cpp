#include <cstdio>
#include <iostream>
#include <queue>

using namespace std;

int main(int argc, char** argv) {
	setbuf(stdout, NULL);

	int T;
	int test_case;
	int cnt = 0;
	long long small, large;
	long long tmpValue;

	scanf("%d", &T);	// Codeground 시스템에서는 C++에서도 scanf 함수 사용을 권장하며, cin을 사용하셔도 됩니다.
	for (test_case = 1; test_case <= T; test_case++) {
		// 이 부분에서 알고리즘 프로그램을 작성하십시오. 기본 제공된 코드를 수정 또는 삭제하고 본인이 코드를 사용하셔도 됩니다.
		
		queue<long long> q;
		//cnt가 0 이면 1, 1
		small = 1; large = 1;
		scanf("%d", &cnt);
		q.push(1);
		q.push(-1);
		for (int i = 0; i < cnt; i++)
		{
			while (true)
			{
				tmpValue = q.front(); q.pop();
				if (tmpValue == -1) break;
		
				//짝수
				q.push(tmpValue * 2);
		//		printf("%lld, ", tmpValue * 2);

				//홀수
				if (((tmpValue - 1) % 3 == 0) && ((tmpValue - 1) / 3 > 1) && (((tmpValue - 1) / 3) % 2 != 0))
				{
					q.push((tmpValue - 1) / 3);
//					printf("%lld, ", (tmpValue-1)/3);
				}
			}
	//		printf("\n==========================================\n");
			q.push(-1);
			//small,large check
			if (i == cnt - 1)
			{
				//small 초기화
				small = (1 << 31) - 1;
				while (true)
				{
					tmpValue = q.front(); q.pop();
					if (tmpValue == -1) break;
					if (tmpValue > large) large = tmpValue;
					if (tmpValue < small) small = tmpValue;
				}
			}
		}
		// 이 부분에서 정답을 출력하십시오. Codeground 시스템에서는 C++에서도 printf 사용을 권장하며, cout을 사용하셔도 됩니다.
		printf("Case #%d\n%lld %lld\n", test_case,small,large);
	}

	return 0;	// 정상종료 시 반드시 0을 리턴해야 합니다.
}