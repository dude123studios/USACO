#include <bits/stdc++.h>
using namespace std;

main()
{
    cin.tie(0)->sync_with_stdio(0);
    freopen("measurement.in", "r", stdin);
    freopen("measurement.out", "w", stdout);
    int N;
    cin >> N;
    vector<tuple<int, int, int>> e(N);
    for (int i = 0; i < N; i++)
    {
        int day, cow, change;
        cin >> day >> cow >> change;
        e[i] = {day, cow, change};
    }
    sort(e.begin(), e.end());
    int maxMilk = 0, cnt = N;
    multiset<int> prod; // to find top prod and detect changes in log(n)
    map<int, int> c2p;  // log(n) changes to production
    for (int i = 0; i < N; i++)
    {
        c2p[get<1>(e[i])] = 0;
        prod.insert(0);
    }
    int ans = 0;
    for (int i = 0; i < N; i++)
    {
        int c = get<1>(e[i]), v = get<2>(e[i]), oldV = c2p[c];
        c2p[c] += v;
        int newV = c2p[c];
        prod.erase(prod.find(oldV));
        prod.insert(newV);
        if (newV > maxMilk)
        {
            if (cnt !=)
        }
        int newMax = *prod.rbegin();
        int newCnt = prod.count(newV);
    }
    cout << ans << endl;
}