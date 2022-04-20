#include <bits/stdc++.h>
using namespace std;

void solve()
{
    int N;
    cin >> N;
    long long h[N];
    for (int i = 0; i < N; i++)
    {
        cin >> h[i];
    }
    long long d[N - 1];
    for (int i = 0; i < N - 1; i++)
    {
        d[i] = h[i + 1] - h[i];
    }
    int cnt = 0;
    if (N % 2 == 0)
    {
        // go through evens
        for (int i = 0; i < N - 3; i += 2)
        {
            if (d[i] < 0)
            {
                cout << -1 << '\n';
                return;
            }
            d[i + 2] += d[i];
            h[i + 1] -= d[i];
            h[i + 2] -= d[i];
            cnt += 2 * d[i];
            d[i] = 0;
        }
        if (d[N - 2] != 0)
        {
            cout << -1 << '\n';
            return;
        }
        // go through odds
        int minval = 0;
        int sums = 0;
        for (int i = 1; i < N - 2; i += 2)
        {
            sums += d[i];
            minval = min(minval, sums);
        }
        if (minval < 0)
        {
            d[1] += minval;
            h[0] += minval;
            h[1] += minval;
            cnt += 2 * abs(minval);
        }
        for (int i = 1; i < N - 4; i += 2)
        {
            d[i + 2] += d[i];
            h[i + 1] -= d[i];
            h[i + 2] -= d[i];
            cnt += 2 * d[i];
            d[i] = 0;
        }
        cnt += 2 * abs(d[N - 3]);
    }
    else
    {
    }
}

int main()
{
    int T;
    cin >> T;
    for (int k = 0; k < T; k++)
    {
        solve();
    }
}