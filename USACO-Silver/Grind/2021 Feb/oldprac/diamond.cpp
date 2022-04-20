#include <bits/stdc++.h>
using namespace std;

void setIO(string name = "diamond")
{
    cin.tie(0)->sync_with_stdio(0); // see /general/fast-io
    if ((int)(name).size())
    {
        freopen((name + ".in").c_str(), "r", stdin); // see /general/input-output
        freopen((name + ".out").c_str(), "w", stdout);
    }
}

int main()
{
    setIO();
    int N;
    long long K;
    cin >> N >> K;
    long long d[N];
    for (int i = 0; i < N; i++)
    {
        cin >> d[i];
    }
    sort(d, d + N);
    int l = 0, maxL[N];
    maxL[0] = 1;
    for (int r = 1; r < N; r++)
    {
        if (d[r] - d[l] > K)
        {
            while (d[r] - d[l] > K && l < r)
                l++;
        }
        maxL[r] = max(maxL[r - 1], r - l + 1);
    }

    int r = N - 1, maxR[N];
    maxR[N - 1] = 1;
    for (int l = N - 2; l >= 0; l--)
    {
        if (d[r] - d[l] > K)
        {
            while (d[r] - d[l] > K && l < r)
                r--;
        }
        maxR[l] = max(maxR[l + 1], r - l + 1);
    }
    int ans = max(maxR[0], maxL[N - 1]);
    for (int i = 0; i < N - 1; i++)
    {
        ans = max(ans, maxL[i] + maxR[i + 1]);
    }
    cout << ans << '\n';
}