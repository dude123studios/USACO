#include <bits/stdc++.h>
using namespace std;
int N, B;
int f[50000], s[250], d[250];
bool v[5000][250];
int ans = INT_MAX;

void dfs(int i, int b)
{
    if (i == N - 1)
    {
        ans = min(ans, b);
        return;
    }
    v[i][b] = 1;
    for (int nextb = b; nextb < B; nextb++)
        for (int pos = i; pos <= min(N - 1, i + d[nextb]); pos++)
        {
            if (v[pos][nextb] != 1 && f[pos] <= s[nextb])
                dfs(pos, nextb);
        }
}

int main()
{
    freopen("snowboots.in", "r", stdin);
    freopen("snowboots.out", "w", stdout);
    cin >> N >> B;
    for (int i = 0; i < N; i++)
        cin >> f[i];
    for (int i = 0; i < B; i++)
        cin >> s[i] >> d[i];
    dfs(0, 0);
    cout << ans << endl;
}