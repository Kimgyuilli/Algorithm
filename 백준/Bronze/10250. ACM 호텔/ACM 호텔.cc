#include <stdio.h>

int main(void)
{
	int T, H, W, N;
	int num;
	scanf("%d", &T);

	for (; T > 0; T--) {
		scanf("%d %d %d", &H, &W, &N);
		if (N % H == 0)
			num = H * 100 + ((N - 1) / H + 1);
		else
			num = N % H * 100 + ((N - 1) / H + 1);
		printf("%d\n", num);
	}
	return 0;
}