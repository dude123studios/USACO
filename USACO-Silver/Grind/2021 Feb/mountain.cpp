#include <bits/stdc++.h>
using namespace std;

void setIO(string name = "mountains")
{
    cin.tie(0)->sync_with_stdio(0); // see /general/fast-io
    if ((int)(name).size())
    {
        freopen((name + ".in").c_str(), "r", stdin); // see /general/input-output
        freopen((name + ".out").c_str(), "w", stdout);
    }
}

struct M
{
    int pos;
    int neg;
    bool operator<(const M &m)
    {
        if (neg == m.neg)
            return pos > m.pos;
        return neg < m.neg;
    }
};

int main()
{
    setIO();
    int N;
    cin >> N;
    vector<M> p;
    for (int i = 0; i < N; i++)
    {
        int x, y;
        cin >> x >> y;
        p.push_back({x + y, x - y});
    }
    sort(p.begin(), p.end());
    int maxend = -1, ans = 0;
    for (int i = 0; i < N; i++)
    {
        if (p[i].pos > maxend)
        {
            maxend = p[i].pos;
            ans++;
        }
    }
    cout << ans << endl;
}