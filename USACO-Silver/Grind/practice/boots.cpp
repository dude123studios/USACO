#include <bits/stdc++.h>
using namespace std;

int N, B;
int f[10000], s[250], d[250];
bool v[10000][250]; //[pos][boot]
int ans = 250;

// min boots used given that your on pos, boot
void dfs(int pos, int boot)
{

    if (pos == N - 1)
    {
        ans = min(ans, boot);
        return;
    }
    for (int b = boot; b < ans; b++)
    {
        if (d[b] < f[pos])
            continue;
        for (int i = pos + 1; i <= min(pos + d[b], N); i++)
        {
            if (s[b] >= f[i] && v[i][b] != 1)
            {
                v[i][b] = true;
                dfs(i, b);
            }
        }
    }
}

int main()
{
    cin >> N >> B;
    for (int i = 0; i < N; i++)
        cin >> f[i];
    for (int i = 0; i < B; i++)
        cin >> s[i] >> d[i];
    dfs(0, 0);
    cout << ans << endl;
}