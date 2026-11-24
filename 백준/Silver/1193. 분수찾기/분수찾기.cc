#include <stdio.h>

int main(void)
{
	int num, add = 2, scan, a = 1;
	scanf("%d", &scan);
	for (num = 1; num < scan; num += add, add++) {
		a++;
	}
	if (a % 2 == 1)
		printf("%d/%d", 1 + (num - scan), a - (num - scan));
	else
		printf("%d/%d", a - (num - scan), 1 + (num - scan));
}