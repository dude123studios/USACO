#include <bits/stdc++.h>
using namespace std;
int N, M, mod = 1e9 + 7;
vector<int> adj[20];

int dp[1 << 20][20];

int main()
{
    cin >> N >> M;
    for (int i = 0; i < M; i++)
    {
        int a, b;
        cin >> a >> b;
        adj[b - 1].push_back(a - 1); // reverse edges
    }
    dp[1][0] = 1;
    for (int m = 3; m < 1 << N; m++)
    {
        // optimize
        if ((m & 1) == 0)
            continue;
        if ((m & (1 << (N - 1))) && m != (1 << N) - 1)
            continue;
        for (int i = 1; i < N; i++)
        {

            int prevm = m ^ (1 << i);
            for (int u : adj[i])
                if (m & (1 << u))
                    (dp[m][i] += dp[prevm][u]) %= mod;
        }
    }
    cout << dp[(1 << N) - 1][N - 1] << endl;
}