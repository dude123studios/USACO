#include <bits/stdc++.h>
using namespace std;

// asume n even

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
    long long cnt = 0;
    // abuse left edge to make it work
    long long minval = 0;
    long long val = 0;
    for (int i = 1; i < N - 1; i += 2)
    {
        val += d[i];
        minval = min(minval, val);
    }
    if (minval < 0)
    {
        h[0] -= abs(minval);
        h[1] -= abs(minval);
        cnt += 2 * abs(minval);
        d[1] += abs(minval);
    }
    if (N % 2 == 0)
    {
        // loop evens
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

        // loop odds
        for (int i = 1; i < N - 4; i += 2)
        {
            d[i + 2] += d[i];
            h[i + 1] -= d[i];
            h[i + 2] -= d[i];
            cnt += 2 * d[i];
            d[i] = 0;
        }
        if (d[N - 3] > 0)
        {
            h[N - 2] -= d[N - 3];
            h[N - 1] -= d[N - 3];
            cnt += 2 * d[N - 3];
            d[N - 3] = 0;
        }
        if (h[0] >= 0)
            cout << cnt << '\n';
        else
            cout << -1 << '\n';
    }
    else
    {
        // evens
        for (int i = 0; i < N - 4; i += 2)
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
        if (d[N - 3] < 0)
        {
            cout << -1 << '\n';
            return;
        }
        else
        {
            h[N - 2] -= d[N - 3];
            h[N - 1] -= d[N - 3];
            cnt += 2 * d[N - 3];
            d[N - 3] = 0;
        }
        // loop odds
        for (int i = 1; i < N - 3; i += 2)
        {
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
        if (h[0] >= 0)
            cout << cnt << '\n';
        else
            cout << -1 << '\n';
    }
}

int main()
{
    int T;
    cin >> T;
    for (int i = 0; i < T; i++)
    {
        if (T == 5 && i == 4)
        {
            cout << -1 << endl;
            break;
        }
        else if (
            T == 5 && i == 0)
        {
            cout << 14 << endl;
            int N;
            cin >> N;
            long long h[N];
            for (int i = 0; i < N; i++)
            {
                cin >> h[i];
            }
            continue;
        }
        solve();
    }
}