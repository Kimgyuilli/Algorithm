#include <stdio.h>

int main(void)
{
	int N;
	int i[100], j, k, count1 = 0, count2;
	scanf("%d", &N);
	for (k = 0; k < N; k++) 
		scanf("%d", &i[k]);
	for(k = 0; N > 0; N--, k++) {
		for (j = 1, count2 = 0; j <= i[k]; j++) {
			if (i[k] % j == 0)
				count2++;
		}
		if (count2 == 2)
			count1++;
	}
	printf("%d", count1);
}