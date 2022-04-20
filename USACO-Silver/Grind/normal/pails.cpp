#include <bits/stdc++.h>
using namespace std;
int M, X, Y, K;
bool v[100][100];
deque<pair<int, int>> qs;
deque<int> ts;

void add(int x, int y, int t)
{
    if (v[x][y] == 1)
        return;
    qs.push_back({x, y});
    ts.push_back(t + 1);
}

int main()
{
    freopen("pails.in", "r", stdin);
    freopen("pails.out", "w", stdout);
    cin >> X >> Y >> K >> M;
    qs.push_back({0, 0});
    ts.push_back(0);
    int ans = INT_MAX;
    while (!qs.empty())
    {
        // update queue
        pair<int, int> q = qs.front();
        int x = q.first, y = q.second;
        qs.pop_front();
        int t = ts.front();
        ts.pop_front();

        // process state
        v[q.first][q.second] = 1;
        ans = min(ans, abs(M - x - y));
        if (t == K)
            continue;

        // fill
        add(X, y, t);
        add(x, Y, t);
        // empty
        add(x, 0, t);
        add(0, y, t);
        // pour
        int amt = min(x, Y - y);
        add(x - amt, y + amt, t);
        amt = min(X - x, y);
        add(x + amt, y - amt, t);
    }
    cout << ans << endl;
}