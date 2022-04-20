#include <bits/stdc++.h>
using namespace std;

void setIO(string name = "split")
{
    cin.tie(0)->sync_with_stdio(0); // see /general/fast-io
    if ((int)(name).size())
    {
        freopen((name + ".in").c_str(), "r", stdin); // see /general/input-output
        freopen((name + ".out").c_str(), "w", stdout);
    }
}
const int maxn = 5e4;
int N;
pair<int, int> cows[maxn];
int minX, maxX;

int solve()
{
    multiset<int> leftX, leftY, rightX, rightY;
    for (int i = 0; i < N; i++)
    {
        rightX.insert(cows[i].first);
        rightY.insert(cows[i].second);
    }
    int maxTotal = 0;
    for (int i = 0; i < N - 1; i++)
    {
        leftX.insert(cows[i].first);
        leftY.insert(cows[i].second);
        rightX.erase(rightX.find(cows[i].first));
        rightY.erase(rightY.find(cows[i].second));
        if (!rightX.empty())
        {
            // int lArea = (cows[i].first - minX) * 1LL * (*l.rbegin() - *l.begin());
        }
    }
}

int main()
{
    setIO();
    cin >> N;
    sort(cows, cows + N);
    minX = cows[0].first;
    maxX = cows[N - 1].first;
    int ans = solve();
}