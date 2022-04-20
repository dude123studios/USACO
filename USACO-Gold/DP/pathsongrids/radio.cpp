#include <bits/stdc++.h>
using namespace std;

#define x first
#define y second
#define P pair<int, int>
#define ll long long

int N, M;
ll dp[1001][1001]; // i fj steps, j bessie steps
P fj[1001], b[1001];
ll dist(int i, int j)
{
    return pow(fj[i].x - b[j].x, 2) + pow(fj[i].y - b[j].y, 2);
}
int main()
{
    freopen("radio.in", "r", stdin);
    freopen("radio.out", "w", stdout);
    cin >> N >> M >> fj[0].x >> fj[0].y >> b[0].x >> b[0].y;
    // store position at every step along the path
    string fjpath, bpath;
    cin >> fjpath >> bpath;

    map<char, P> l2dir;
    l2dir['N'] = {0, 1};
    l2dir['S'] = {0, -1};
    l2dir['E'] = {1, 0};
    l2dir['W'] = {-1, 0};

    for (int i = 1; i <= N; i++)
    {
        P dir = l2dir[fjpath[i - 1]];
        fj[i].x = fj[i - 1].x + dir.x;
        fj[i].y = fj[i - 1].y + dir.y;
    }
    for (int i = 1; i <= M; i++)
    {
        P dir = l2dir[bpath[i - 1]];
        b[i].x = b[i - 1].x + dir.x;
        b[i].y = b[i - 1].y + dir.y;
    }
    // base case
    dp[0][0] = 0;
    for (int i = 0; i <= N; i++)
        for (int j = 0; j <= M; j++)
        {
            if (!i && !j)
                continue;
            dp[i][j] = 1e18;
            int d = dist(i, j);
            if (i)
                dp[i][j] = min(dp[i][j], dp[i - 1][j] + d);
            if (j)
                dp[i][j] = min(dp[i][j], dp[i][j - 1] + d);
            if (i && j)
                dp[i][j] = min(dp[i][j], dp[i - 1][j - 1] + d);
        }

    cout << dp[N][M] << endl;
}