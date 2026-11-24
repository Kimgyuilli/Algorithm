#include <stdio.h>

int main()
{
	int a, b, c, d;
	scanf("%d %d %d", &a, &b, &c);
	if (b >= c) {
		printf("-1");
		return 0;
	}
	else
		d = a / (c - b);
	printf("%d", d + 1);
	return 0;
}