#include <bits/stdc++.h>
using namespace std;
#define ll long long
int main()
{
    int N;
    cin >> N;
    multiset<int> ans;
    for (int i = 1; i < N; i++)
        if (gcd(i, N) == 1)
            ans.insert(i);
    ll prod = 1;
    for (int i : ans)
        prod = ((i * prod) % N);
    if (prod != 1)
        ans.erase(ans.find(prod));
    cout << ans.size() << endl;
    for (int i : ans)
        cout << i << " ";
    cout << endl;
}