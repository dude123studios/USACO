#include <bits/stdc++.h>
using namespace std;
#define MAX 100000
#define a first
#define s second
int N, P, K;
pair<int, array<int, 7>> people[MAX + 1];
int dp[MAX + 1][1 << 7];
int main()
{
    cin >> N >> P >> K;
    for (int i = 1; i <= N; i++)
        cin >> people[i].a;
    for (int i = 1; i <= N; i++)
        for (int j = 0; j < P; j++)
            cin >> people[i].s[j];
    sort(people + 1, people + N + 1);
    reverse(people + 1, people + N + 1);
    for (int i = 1; i <= N; i++)
        for (int m = 0; m < (1 << P); m++)
        {
            dp[i][m] = dp[i - 1][m];
            // add to audience
            int team = __popcount(m);
            if (i - 1 - team < K)
                dp[i][m] = max(dp[i][m], dp[i - 1][m] + people[i].a);
            // add to team
            for (int j = 0; j < P; j++)
                if (m & (1 << j))
                    dp[i][m] = max(dp[i][m], dp[i - 1][m ^ (1 << j)] + people[i].s[j]);
        }
    cout << dp[N][(1 << P) - 1] << endl;
}