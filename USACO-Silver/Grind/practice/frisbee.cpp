#include <bits/stdc++.h>
using namespace std;
int N, ans = 0;
vector<int> h;
int rev[300000];

void contrib()
{
    set<int> curr;
    for (int c : h)
    {
        curr.insert(c);
        auto hi = curr.find(c);
        // h_i is greatest lower bound for h_j, where i < j, unless at end
        if (next(hi) != end(curr))
        {
            ans += abs(rev[*next(hi) - 1] - rev[*hi - 1]) + 1;
        }
    }
}

int main()
{
    int N;
    cin >> N;
    for (int i = 0; i < N; i++)
    {
        int j;
        cin >> j;
        h.push_back(j);
        rev[j - 1] = i;
    }
    contrib();
    reverse(h.begin(), h.end());
    contrib();
    cout << ans << endl;
}