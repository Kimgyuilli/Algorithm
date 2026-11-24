#include <stdio.h>

int main(void)
{
	int n, a = 1, b = 1;
	scanf("%d", &n);
	while (a < n) {
		a += b * 6;
		b++;
	}
	printf("%d", b);
	return 0;
}