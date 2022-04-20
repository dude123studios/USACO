#include <bits/stdc++.h>
using namespace std;

void setIO(string name = "sort")
{
    cin.tie(0)->sync_with_stdio(0); // see /general/fast-io
    if ((int)(name).size())
    {
        freopen((name + ".in").c_str(), "r", stdin); // see /general/input-output
        freopen((name + ".out").c_str(), "w", stdout);
    }
}

int main()
{
    setIO();
    int N;
    cin >> N;
    vector<pair<int, int>> entries;
    int val;
    for (int i = 0; i < N; i++)
    {
        cin >> val;
        entries.push_back({val, i});
    }
    sort(entries.begin(), entries.end());
    int ans = 0;
    for (int i = 0; i < N; i++)
    {
        ans = max(ans, entries[i].second - i);
    }
    cout << ans + 1 << endl;
}