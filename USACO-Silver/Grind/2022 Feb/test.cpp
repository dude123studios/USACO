#include <bits/stdc++.h>
using namespace std;
using ll = long long;
#define x pair<ll, ll>::first
#define y pair<ll, ll>::second

int main()
{
    int N;
    ll xs[40], ys[40], gx, gy;
    unordered_map<pair<ll, ll>, vector<ll>> lookup;
    cin >> N;
    cin >> gx >> gy;
    for (int i = 0; i < N; i++)
        cin >> xs[i] >> ys[i];

    int half = (N + 1) / 2;
    for (int i = 0; i < (1 << half); i++)
    {
        pair<ll, ll> p;
        int num = 0;
        for (int j = 0; j < half; j++)
        {
            if (i & (1 << j))
            {
                p.x += xs[j];
                p.y += ys[j];
                num++;
            }
        }
        if (!lookup.count(p))
        {
            vector<ll> tmp(N);
            tmp[num - 1]++;
            lookup[p] = tmp;
        }
        else
        {
            lookup[p][num - 1]++;
        }
    }
    int ans[N];
    fill(ans, ans + N, 0);
    for (int i = 0; i < (1 << (N - half)); i++)
    {
        pair<ll, ll> p;
        int num = 0;
        for (int j = half; j < N; j++)
        {
            if (i & (1 << j - half))
            {
                p.x += xs[j];
                p.y += ys[j];
                num++;
            }
        }
        p.x = gx-p.x;
        p.y = gy-p.y;
        if(lookup.count(p)) {
            auto &v = lookup[p];
            
        }
    }

    for (int i = 0; i < N; i++)
        cout << ans[i] << endl;
}