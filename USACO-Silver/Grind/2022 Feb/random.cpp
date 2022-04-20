#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

int main()
{
    int N, SUM;
    cin >> N >> SUM;
    vector<int> a(N);
    for (int i = 0; i < N; i++)
        cin >> a[i];
    int half = N / 2;
    multiset<int> vals;
    for (int i = 0; i < (1 << half); i++)
    {
        int sum = 0;
        for (int j = 0; j < half; j++)
        {
            if (i & (1 << j))
                sum += a[j];
        }
        vals.insert(sum);
    }
    int ans = 0;
    int ohalf = N - half;
    for (int i = 0; i < (1 << ohalf); i++)
    {
        int sum = 0;
        for (int j = 0; j < ohalf; j++)
        {
            if (i & (1 << j))
                sum += a[half + j];
        }
        if (vals.count(SUM - sum))
            ans += vals.count(SUM - sum);
    }
    cout << ans << endl;
}