#include <bits/stdc++.h>
using namespace std;

int N;
char g[18][18];
set<vector<char>> palindromes;
set<vector<char>> paths[18];
vector<char> str;
void dfsr(int r, int c, int i)
{
    if (r == N - 1 && c == N - 1)
    {
        if (paths[i].count(str))
            palindromes.insert(str);
        return;
    }
    if (r < N - 1)
    {
        str.push_back(g[r + 1][c]);
        dfsr(r + 1, c, i);
        str.pop_back();
    }
    if (c < N - 1)
    {
        str.push_back(g[r][c + 1]);
        dfsr(r, c + 1, i);
        str.pop_back();
    }
}
void dfsl(int r, int c, int i)
{
    if (r == 0 && c == 0)
    {
        paths[i].insert(str);
    }
    if (r > 0)
    {
        str.push_back(g[r - 1][c]);
        dfsl(r - 1, c, i);
        str.pop_back();
    }
    if (c > 0)
    {
        str.push_back(g[r][c - 1]);
        dfsl(r, c - 1, i);
        str.pop_back();
    }
}

int main()
{
    cin >> N;
    for (int i = 0; i < N; i++)
    {
        string line;
        cin >> line;
        for (int j = 0; j < N; j++)
        {
            g[i][j] = line[j];
        }
    }
    for (int c = 0; c < N; c++)
    {
        str.push_back(g[N - 1 - c][c]);
        dfsl(N - 1 - c, c, c);
        dfsr(N - 1 - c, c, c);
        str.pop_back();
    }
    cout << palindromes.size() << endl;
}