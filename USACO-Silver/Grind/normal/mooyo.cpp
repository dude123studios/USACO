#include <bits/stdc++.h>
using namespace std;
int N, K;
int a[102][12];
bool v[102][12];
int dr[4] = {0, 0, 1, -1}, dc[4] = {1, -1, 0, 0};
vector<pair<int, int>> toremove, curr;
int area = 0;
void ff(int r, int c)
{
    curr.push_back({r, c});
    v[r][c] = 1;
    area++;
    for (int i = 0; i < 4; i++)
    {
        int nr = r + dr[i];
        int nc = c + dc[i];
        if (a[nr][nc] == a[r][c] && v[nr][nc] != 1)
            ff(nr, nc);
    }
}

void reset()
{
    toremove.clear();
    for (int i = 0; i <= N + 1; i++)
        for (int j = 0; j <= 11; j++)
            v[i][j] = 0;
}

bool cluster()
{
    reset();
    bool change = 0;
    for (int i = 1; i <= N; i++)
    {
        for (int j = 1; j <= 10; j++)
        {
            if (a[i][j] == 0)
                continue;
            area = 0;
            ff(i, j);
            if (area >= K)
            {
                change = 1;
                for (auto p : curr)
                    toremove.push_back(p);
            }
            curr.clear();
        }
    }
    if (!change)
        return 0;
    for (auto p : toremove)
        a[p.first][p.second] = 0;
    // perform downwards shifting
    for (int k = 1; k <= 10; k++)
    {
        vector<int> v;
        for (int h = N; h >= 1; h--)
            if (a[h][k] > 0)
                v.push_back(a[h][k]);
        for (int i = 0; i < v.size(); i++)
            a[N - i][k] = v[i];
        for (int i = 1; i <= N - v.size(); i++)
            a[i][k] = 0;
    }
    return 1;
}

int main()
{
    freopen("mooyomooyo.in", "r", stdin);
    freopen("mooyomooyo.out", "w", stdout);
    cin >> N >> K;

    for (int i = 0; i <= N + 1; i++)
        for (int j = 0; j <= 11; j++)
            a[i][j] = 0;
    for (int i = 1; i <= N; i++)
    {
        string ln;
        cin >> ln;
        for (int j = 1; j <= 10; j++)
            a[i][j] = ln[j - 1] - '0';
    }

    while (cluster())
        continue;

    for (int i = 1; i <= N; i++)
    {
        for (int j = 1; j <= 10; j++)
        {
            cout << a[i][j];
        }
        cout << '\n';
    }
}