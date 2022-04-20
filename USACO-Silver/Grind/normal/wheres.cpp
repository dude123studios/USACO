#include <bits/stdc++.h>
using namespace std;
int N;
bool v[22][22];
char a[22][22];

int dr[4] = {0, 0, 1, -1}, dc[4] = {1, -1, 0, 0};
void ff(int r, int c, int r1, int r2, int c1, int c2)
{
    v[r][c] = 1;
    for (int i = 0; i < 4; i++)
    {
        int nr = dr[i] + r;
        int nc = dc[i] + c;
        if (nr >= r1 && nr <= r2 && nc >= c1 && nc <= c2 && v[nr][nc] != 1 && a[nr][nc] == a[r][c])
            ff(nr, nc, r1, r2, c1, c2);
    }
}
bool works(int r1, int r2, int c1, int c2)
{
    bool two = 1;
    char c1 = 0, c2 = 0;
    int g1 = 0, g2 = 0;
    for (int i = r1; i <= r2; i++)
        for (int j = c1; j <= c2; j++)
        {
            if (v[i][j] == 1)
                continue;
            ff(i, j, r1, r2, c1, c2);
            if (c1 == 0)
                c1 = a[i][j];
            else if (c2 == 0)
                c2 = a[i][j];
            else if (a[i][j] == c1)
                g1++;
            else if (a[i][j] == c2)
                g2++;
            else
                two = 0;
        }
    return c1 != 0 && c2 != 0 && (g1 == 0 && g2 >= 1) || (g2 == 0 && g1 >= 1) && two;
}

int main()
{
    int N;
    for (int i = 1; i <= N; i++)
        for (int j = 1; j <= N; j++)
            cin >> a[i][j];
}