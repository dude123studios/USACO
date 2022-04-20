#include <bits/stdc++.h>
using namespace std;

int g[5][5];
set<int> paths;

void dfs(int row, int col, int m, int curr)
{
    if (m == 0)
    {
        paths.insert(curr);
        return;
    }
    int dr[4] = {1, -1, 0, 0}, dc[4] = {0, 0, 1, -1};
    for (int i = 0; i < 4; i++)
    {
        int nr = row + dr[i];
        int nc = col + dc[i];
        if (nr >= 0 && nr < 5 && nc >= 0 && nc < 5)
        {
            dfs(nr, nc, m - 1, curr * 10 + g[nr][nc]);
        }
    }
}

int main()
{
    for (int i = 0; i < 5; i++)
    {
        for (int j = 0; j < 5; j++)
        {
            cin >> g[i][j];
        }
    }
    for (int i = 0; i < 5; i++)
    {
        for (int j = 0; j < 5; j++)
        {
            dfs(i, j, 5, g[i][j]);
        }
    }
    cout << paths.size() << endl;
}