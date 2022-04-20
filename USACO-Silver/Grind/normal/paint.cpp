#include <bits/stdc++.h>
using namespace std;
int N, Q;
string S;
int l[100001], r[100001];

void comp(int *a)
{
    set<char> curr;
    priority_queue<char> coats;
    for (int i = 0; i < N; i++)
    {
        a[i + 1] = a[i];
        if (curr.find(S[i]) == curr.end())
        {
            curr.insert(S[i]);
            coats.push(S[i]);
            a[i + 1]++;
        }
        while (coats.top() > S[i])
        {
            curr.erase(coats.top());
            coats.pop();
        }
    }
}

int main()
{
    cin >> N >> Q >> S;
    comp(l);
    reverse(S.begin(), S.end());
    comp(r);
    for (int i = 0; i < Q; i++)
    {
        int a, b;
        cin >> a >> b;
        cout << l[a - 1] + r[N - b] << endl;
    }
}