#include <bits/stdc++.h>
using namespace std;

int N, S[20], s[3];
int ans = 20001;

void solve(int pos)
{
    if (pos == N)
    {
        ans = min(ans, max({s[0], s[1], s[2]}));
        return;
    }
    for (int i = 0; i < 3; i++)
    {
        if (s[i] > ans)
            return;
        s[i] += S[pos];
        solve(pos + 1);
        s[i] -= S[pos];
    }
}

int main()
{
    cin >> N;
    for (int i = 0; i < N; i++)
        cin >> S[i];
    s[0] = S[0];
    solve(1);
    cout << ans << endl;
}