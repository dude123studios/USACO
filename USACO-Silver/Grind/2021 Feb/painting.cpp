#include <bits/stdc++.h>
using namespace std;

void setIO(string name = "rental")
{
    cin.tie(0)->sync_with_stdio(0); // see /general/fast-io
    if ((int)(name).size())
    {
        freopen((name + ".in").c_str(), "r", stdin); // see /general/input-output
        freopen((name + ".out").c_str(), "w", stdout);
    }
}

int N, M, R;
struct S {
    int p;
    int q;
};
bool comp(const S& s1, const S& s2) {
    return s1.q > s2.q;
}

int main()
{
    setIO();
    cin >> N >> M >> R;
    int c[N];
    for (int i = 0; i < N; i++)
    {
        cin >> c[i];
    }
    sort(c, c + N);
    vector<S> s;
    for (int i = 0; i < M; i++)
    {
        int p, q;
        cin >> p >> q;
        s.push_back({p, q});
    }
    sort(s.begin(), s.end(), comp);
    int cow = N-1, done = 0;
    for(int i=0; i<M; i++) {
        int spent = 0;
        while(cow >=0 && spent < s[i].p) {
            spent += c[cow];
        }
        if(spent > s[i].p) {}
    }

}