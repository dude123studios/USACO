#include <bits/stdc++.h>
using namespace std;
#include <cstdint> // for std::int_fast64_t
long long mod = 1e9 + 7;
// note: exp must be non-negative
long long binpow(long long a, long long b)
{
    a %= mod;
    long long res = 1;
    while (b > 0)
    {
        if (b & 1)
            res = res * a % mod;
        a = a * a % mod;
        b >>= 1;
    }
    return res;
}
void solve()
{
    int N, P;
    cin >> N >> P;
    long long int ans = 1;
    int maxexp = min(N, P), idx = 1;
    int mid = (N + P + 4) / 2;
    for (int i = 3; i <= mid; i++)
    {
        long long pw = binpow((long long)i, idx) % mod;
        ans = (ans * pw) % mod;
        idx = min(idx + 1, maxexp);
    }
    idx = 1;
    for (int i = N + P + 1; i > mid; i--)
    {
        long long pw = binpow((long long)i, idx) % mod;
        ans = (ans * pw) % mod;
        idx = min(idx + 1, maxexp);
    }
    cout << ans << endl;
}

int main()
{
    int T;
    cin >> T;
    while (T--)
        solve();
}