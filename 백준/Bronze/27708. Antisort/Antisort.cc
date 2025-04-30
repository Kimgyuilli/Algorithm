#include <iostream>
#include <algorithm>
#include <utility>
using namespace std;

int T, N;
int arr[1000];

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	cin >> T;
	cout << T << '\n' << '\n';
	while (T--) {
		cin >> N;
		for (int i = 0; i < N; i++) cin >> arr[i];
		sort(arr, arr + N);
		swap(arr[0], arr[1]);
		cout << N << '\n';
		for (int i = 0; i < N; i++) cout << arr[i] << ' ';
		cout << '\n' << '\n';
	}
}