#include <bits/stdc++.h>
using namespace std;

int v[1002][1002]; // 0 ice, 1 blob, 2 visited
int dy[4] = {0, 0, -1, 1}, dx[4] = {1, -1, 0, 0};
int a, p;
void ff(int x, int y)
{
    v[x][y] = 2;
    a++;
    for (int i = 0; i < 4; i++)
    {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if (v[nx][ny] == 1)
            ff(nx, ny);
        else if (v[nx][ny] == 0)
            p++;
    }
}

int main()
{
    freopen("perimeter.in", "r", stdin);
    freopen("perimeter.out", "w", stdout);
    int N;
    cin >> N;
    for (int i = 0; i < N; i++)
    {
        string ln;
        cin >> ln;
        for (int j = 0; j < N; j++)
        {
            v[i + 1][j + 1] = ln[j] == '#';
        }
    }
    int ma = 0, mp = 0;
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {

            if (v[i + 1][j + 1] == 1)
            {
                a = 0;
                p = 0;
                ff(i + 1, j + 1);
                if (a > ma)
                {
                    ma = a;
                    mp = p;
                }
                else if (a == ma)
                    mp = max(p, mp);
            }
        }
    }
    cout << ma << " " << mp << endl;
}