//#include<cstdio>
//#define min(a,b)    ((a)>(b)?(b):(a))
//
//int a[1001];
//int d[1001];
//
//int main()
//{
//	int n, m;
//	scanf("%d %d", &n, &m);
//
//	for (int i = 1; i <= n; i++){
//		scanf("%d", &a[i]);
//		d[i] = (1 << 31) - 1;
//	}
//
//	for (int i = 1; i <= n; i++){
//		int len = a[i];
//		for (int j = 1; j <= i && len <= m; j++){
//			if (i == n)
//				d[i] = min(d[i], d[i - j]);
//			else
//				d[i] = min(d[i], d[i - j] + (m - len)*(m - len));
//			len += 1 + a[i - j];
//		}
//		printf("%d : %d\n", i, d[i]);
//	}
//	printf("%d", d[n]);
//	for (int i = 0; i < n;i++)
//		printf("%d : %d\n", i, d[i]);
//
//	return 0;
//}