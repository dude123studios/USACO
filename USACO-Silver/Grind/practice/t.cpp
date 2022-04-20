#include <bits/stdc++.h>
using namespace std;

bool v[10];
vector<int> curr;
int val()
{
    int sum = 0;
    for (int x : curr)
    {
        sum = sum * 10 + x;
    }
    return sum;
}

void dfs(int i)
{
    if (i != 0 && val() % i != 0)
        return;
    if (i == 10)
    {
        for (int x : curr)
        {
            cout << x << ' ';
        }
        cout << '\n';
    }
    for (int j = 0; j < 10; j++)
    {
        if (v[j] == 1)
            continue;
        v[j] = true;
        curr.push_back(j);
        dfs(i + 1);
        curr.pop_back();
        v[j] = false;
    }
}

int main()
{
    fill(v, v + 10, false);
    dfs(0);
}