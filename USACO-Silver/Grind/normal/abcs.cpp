#include <bits/stdc++.h>
using namespace std;
int N;
vector<int> xs;
set<int> all;

void solve()
{
    cin >> N;
    all.clear();
    xs.clear();
    xs.resize(N);
    for (int i = 0; i < N; i++)
        cin >> xs[i];
    sort(xs.begin(), xs.end());
    if (N == 7)
    {
        int a = xs[0];
        int b = xs[1];
        int c = xs[6] - a - b;
        for (int x : xs)
        {
        }
    }
}

int main()
{
    int T;
    cin >> T;
    while (T--)
        solve();
}