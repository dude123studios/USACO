#include <bits/stdc++.h>
using namespace std;

#define x first
#define y second
typedef pair<int, int> pii;
typedef long long ll;

int H, G;
ll dp[1001][1001][2];
pii p[1001][2];
int dist(pii p1, pii p2)
{
    return pow(p1.x - p2.x, 2) + pow(p1.y - p2.y, 2);
}
int main()
{
    freopen("checklist.in", "r", stdin);
    freopen("checklist.out", "w", stdout);
    cin >> H >> G;
    for (int i = 1; i <= H; i++)
    {
        int x, y;
        cin >> x >> y;
        p[i][0] = {x, y};
    }
    for (int i = 1; i <= G; i++)
    {
        int x, y;
        cin >> x >> y;
        p[i][1] = {x, y};
    }
    for (int i = 0; i <= H; i++)
        for (int j = 0; j <= G; j++)
            for (int k = 0; k < 2; k++)
                dp[i][j][k] = 1e18;
    dp[1][0][0] = 0;
    for (int i = 0; i <= H; i++)
        for (int j = 0; j <= G; j++)
        {
            if (i)
            {
                dp[i][j][0] = min(dp[i][j][0], dist(p[i][0], p[i - 1][0]) + dp[i - 1][j][0]);
                dp[i][j][0] = min(dp[i][j][0], dist(p[i][0], p[j][1]) + dp[i - 1][j][1]);
            }
            if (j)
            {
                dp[i][j][1] = min(dp[i][j][1], dist(p[j][1], p[j - 1][1]) + dp[i][j - 1][1]);
                dp[i][j][1] = min(dp[i][j][1], dist(p[j][1], p[i][0]) + dp[i][j - 1][0]);
            }
        }
    cout << dp[H][G][0] << endl;
}