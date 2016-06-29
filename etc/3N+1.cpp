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

	scanf("%d", &T);	// Codeground �ý��ۿ����� C++������ scanf �Լ� ����� �����ϸ�, cin�� ����ϼŵ� �˴ϴ�.
	for (test_case = 1; test_case <= T; test_case++) {
		// �� �κп��� �˰��� ���α׷��� �ۼ��Ͻʽÿ�. �⺻ ������ �ڵ带 ���� �Ǵ� �����ϰ� ������ �ڵ带 ����ϼŵ� �˴ϴ�.
		
		queue<long long> q;
		//cnt�� 0 �̸� 1, 1
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
		
				//¦��
				q.push(tmpValue * 2);
		//		printf("%lld, ", tmpValue * 2);

				//Ȧ��
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
				//small �ʱ�ȭ
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
		// �� �κп��� ������ ����Ͻʽÿ�. Codeground �ý��ۿ����� C++������ printf ����� �����ϸ�, cout�� ����ϼŵ� �˴ϴ�.
		printf("Case #%d\n%lld %lld\n", test_case,small,large);
	}

	return 0;	// �������� �� �ݵ�� 0�� �����ؾ� �մϴ�.
}