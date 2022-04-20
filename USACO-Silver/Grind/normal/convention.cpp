#include <bits/stdc++.h>
using namespace std;
int N, M, C;
int t[100000];

bool check(int x)
{
    int cow = 0, start = 0;
    for (int bus = 0; bus < M; bus++)
    {
        while (t[cow] - t[start] <= x && cow - start + 1 <= C && cow < N)
            cow++;
        if (cow == N)
            return 1;
        start = cow;
    }
    return 0;
}

int main()
{

    freopen("convention.in", "r", stdin);
    freopen("convention.out", "w", stdout);

    cin >> N >> M >> C;
    for (int i = 0; i < N; i++)
        cin >> t[i];
    sort(t, t + N);

    int lo = 0, hi = t[N - 1] - t[0] + 1;
    while (lo < hi)
    {
        int mid = lo + (hi - lo) / 2;
        if (check(mid) == 1)
            hi = mid;
        else
            lo = mid + 1;
    }
    cout << lo << endl;
}