#include <bits/stdc++.h>
using namespace std;
int a[9][9];
bool vgroup[3][3][9], vrow[9][9], vcol[9][9];
bool found;
pair<int, int> nxt(int i, int j)
{
    int ni, nj;
    if (j == 8)
    {
        ni++;
        nj = 0;
    }
    else
        nj++;
}
void dfs(int i, int j)
{
    if (found)
        return;
    if (i == 9)
    {
        found = true;
        for (int m = 0; m < 9; m++)
        {
            for (int n = 0; n < 9; n++)
            {
                cout << a[m][n] + 1 << " ";
            }
            cout << "\n";
        }
        return;
    }
    if (a[i][j] != -1)
    {
        pair<int, int> n = nxt(i, j);
        dfs(n.first, n.second);
    }
    for (int m = 0; m < 9; m++)
    {
        if (vgroup[i / 3][j / 3][m] == 1 || vrow[i][m] == 1 || vcol[j][m])
            continue;
        a[i][j] = m;
        vgroup[i / 3][j / 3][m] = 1;
        vrow[i][m] = 1;
        vcol[j][m] = 1;
        int ni, nj;
        if (j == 8)
        {
            ni++;
            nj = 0;
        }
        else
            nj++;
        dfs(ni, nj);
        vgroup[i / 3][j / 3][m] = 0;
        vrow[i][m] = 0;
        vcol[j][m] = 0;
    }
}

int main()
{
    for (int i = 0; i < 9; i++)
    {
        for (int j = 0; j < 9; j++)
        {
            int val;
            cin >> val;
            a[i][j] = val - 1;
        }
    }
    dfs(0, 0);
}