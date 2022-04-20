#include <bits/stdc++.h>
using namespace std;

int N, q[15], ans = 0;
set<int> ddiag, udiag;
set<int> ys;
void solve(int x)
{
    if (x == N)
    {
        ans++;
        return;
    }
    for (int i = 0; i < N; i++)
    {
        if (ys.count(i) || ddiag.count(x - i) || udiag.count(x + i))
            continue;
        ys.insert(i);
        ddiag.insert(x - i);
        udiag.insert(x + i);
        q[x] = i;
        solve(x + 1);
        ys.erase(i);
        ddiag.erase(x - i);
        udiag.erase(x + i);
    }
}

int main()
{
    cin >> N;
    for (int i = 0; i < N; i++)
        cin >> q[i];
    solve(0);
    cout << ans << endl;
}