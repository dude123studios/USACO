#include <bits/stdc++.h>
using namespace std;
#define pi pair<int, int>
#define f first
#define s second
#define pb push_back
#define mp make_pair
#define ll long long
const int MAX = 1e5;
int N, K;
map<vector<pi>, int> table;
int max_div[MAX + 1], a[MAX];

vector<pi> fast_divisors(int x)
{
    vector<pi> divisors;
    while (x != 1)
    {
        int p = max_div[x];
        int cnt = 0;
        while (!(x % p))
        {
            cnt++;
            x /= p;
        }
        int mod = cnt % K;
        if (mod)
            divisors.pb(mp(p, mod));
    }
    return divisors;
}
int main()
{
    cin >> N >> K;
    for (int i = 2; i <= MAX; i++)
        if (!max_div[i])
            for (int j = i; j <= MAX; j += i)
                max_div[j] = i;

    for (int i = 0; i < N; i++)
        cin >> a[i];
    ll ans = 0;
    for (int i = 0; i < N; i++)
    {
        vector<pi> divisors = fast_divisors(a[i]);
        vector<pi> other;
        for (pi i : divisors)
            other.pb(mp(i.f, K - i.s));
        ans += table[other];
        table[divisors]++;
    }
    cout << ans << endl;
}