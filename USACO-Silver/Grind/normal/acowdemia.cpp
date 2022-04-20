#include <bits/stdc++.h>
using namespace std;
int N, K, L;
int c[100001];
bool check(int h)
{
    int sum = 0;
    for (int i = 1; i <= h; i++)
    {
        if (h - c[i] > K)
            return 0;
        sum += max(0, h - c[i]);
    }
    return sum <= K * L;
}
int main()
{
    cin >> N >> K >> L;
    for (int i = 1; i <= N; i++)
        cin >> c[i];
    sort(c + 1, c + N + 1);
    reverse(c + 1, c + N + 1);
    int l = 1, h = N;
    while (l < h)
    {
        int mid = l + ((h - l) + 1) / 2;
        if (check(mid))
            l = mid;
        else
            h = mid - 1;
    }
    cout << h << endl;
}