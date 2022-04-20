#include <bits/stdc++.h>
using namespace std;
int N;
int v[2000][2000];

int ans = 0;
pair<int, int> d[4] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

void add(int i, int j)
{
    v[i][j] = 0;
    int ri, rj;
    for (pair<int, int> dir : d)
    {
        int ni = dir.first + i;
        int nj = dir.second + j;
        if (v[ni][nj] >= 0)
        {
            v[i][j]++;
            // increment neighbors of adjecent
            v[ni][nj]++;
        }
        else
        {
            ri = ni;
            rj = nj;
        }
    }
    if (v[i][j] == 3)
    {
        ans++;
        add(ri, rj);
    }
    for (pair<int, int> dir : d)
    {
        int ni = dir.first + i;
        int nj = dir.second + j;
        if (v[ni][nj] == 3)
        {
            for (pair<int, int> dir : d)
            {
                int nexti = dir.first + ni;
                int nextj = dir.second + nj;
                if (v[nexti][nextj] == -1)
                {
                    ans++;
                    add(nexti, nextj);
                    break;
                }
            }
        }
    }
}

int main()
{
    cin >> N;
    for (int i = 0; i < 2000; i++)
    {
        for (int j = 0; j < 2000; j++)
            v[i][j] = -1;
    }
    for (int i = 0; i < N; i++)
    {
        int x, y;
        cin >> x >> y;
        x += 1000;
        y += 1000;
        // already should be added
        if (v[x][y] >= 0)
            ans--;
        else
        {
            add(x, y);
        }
        cout << ans << endl;
    }
}