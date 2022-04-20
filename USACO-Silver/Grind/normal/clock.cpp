#include <bits/stdc++.h>
using namespace std;

int clocks[9];
int u[9];
bool v[4][4][4][4][4][4][4][4][4];

vector<int> moves[9];
int f[4] = {1, 2, 3, 0}, b[4] = {3, 0, 1, 2};
bool found = false;
void dfs()
{
    if (found == 1)
        return;
    bool pos = true;
    for (int i = 0; i < 9; i++)
        if (clocks[i] != 0)
            pos = false;
    if (pos)
    {
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < u[i]; j++)
            {
                cout << i << " ";
            }
        }
        cout << "\n";
        found = 1;
        return;
    }
    v[u[0]][u[1]][u[2]][u[3]][u[4]][u[5]][u[6]][u[7]][u[8]] = 1;
    for (int i = 0; i < 9; i++)
    {
        u[i] = f[u[i]];
        if (v[u[0]][u[1]][u[2]][u[3]][u[4]][u[5]][u[6]][u[7]][u[8]] == 1)
        {
            u[i] = b[u[i]];
            continue;
        }
        for (int x : moves[i])
            clocks[x] = f[x];

        dfs();
        for (int x : moves[i])
            clocks[x] = b[x];
        u[i] = b[u[i]];
    }
}

int main()
{
    fill(u, u + 9, 0);
    for (int i = 0; i < 9; i++)
    {
        cin >> clocks[i];
        if (clocks[i] == 12)
            clocks[i] = 0;
        else
            clocks[i] /= 3;
    }
    vector<int> v1{0, 1, 3, 4};
    vector<int> v2{0, 1, 2};
    vector<int> v3{1, 2, 4, 5};
    vector<int> v4{0, 3, 6};
    vector<int> v5{1, 3, 4, 5, 7};
    vector<int> v6{2, 5, 8};
    vector<int> v7{3, 4, 6, 7};
    vector<int> v8{6, 7, 8};
    vector<int> v9{4, 5, 7, 8};
    moves[0] = v1;
    moves[1] = v2;
    moves[2] = v3;
    moves[3] = v4;
    moves[4] = v5;
    moves[5] = v6;
    moves[6] = v7;
    moves[7] = v8;
    moves[8] = v8;
    moves[8] = v9;
    for (int i = 0; i < 9; i++)
        cout << clocks[i] << " ";
    dfs();
}