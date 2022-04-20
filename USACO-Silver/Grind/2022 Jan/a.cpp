#include <bits/stdc++.h>
using namespace std;

int main()
{
    char a[3][3];
    char g[3][3];
    multiset<char> remain;
    for (int i = 0; i < 3; i++)
    {
        string ln;
        cin >> ln;
        for (int j = 0; j < 3; j++)
        {
            a[i][j] = ln[j];
            remain.insert(ln[j]);
        }
    }
    for (int i = 0; i < 3; i++)
    {
        string ln;
        cin >> ln;
        for (int j = 0; j < 3; j++)
        {
            g[i][j] = ln[j];
        }
    }
    int green = 0, yellow = 0;
    for (int i = 0; i < 3; i++)
    {
        for (int j = 0; j < 3; j++)
        {
            if (a[i][j] == g[i][j])
            {
                green++;
                remain.erase(remain.find(a[i][j]));
            }
            else
            {
                if (remain.count(g[i][j]))
                {
                    remain.erase(remain.find(g[i][j]));
                    yellow++;
                }
            }
        }
    }
    cout << green << '\n'
         << yellow << endl;
}