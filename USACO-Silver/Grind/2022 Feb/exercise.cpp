#include <bits/stdc++.h>
using namespace std;
int main()
{
    int N, K, P;
    cin >> N >> K >> P;
    int a[K * P];
    
    int l = 0, r = K;
    for (int i = 0; i < N; i++)
        a[i] = i;
    vector<int> ans;
    int mod = 0;
    while (l < r)
    {
        if (mod == N - 1)
        {
            ans.push_back(a[l]);
            mod = -1;
        }
        l++;
        for (int i = 0; i < P; i++)
        {
            a[r] = a[l];
            l++;
            r++;
        }
        mod++;
    }
    sort(begin(ans), end(ans));
    for (int a : ans)
        cout << a+1 << endl;
}