#include <bits/stdc++.h>
using namespace std;

int main()
{
    freopen("moobuzz.in", "r", stdin);
    freopen("moobuzz.out", "w", stdout);
    int N;
    cin >> N;
    int r[8] = {14, 1, 2, 4, 7, 8, 11, 13};
    cout << 15 * (N / 8) + r[N % 8] << endl;
}