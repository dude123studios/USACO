#include <bits/stdc++.h>
using namespace std;

int main()
{
    int N;
    cin >> N;
    int c[N];
    set<int> cards;
    for(int i = 1; i<=2*N;i++) cards.insert(i);
    for(int i=0; i<N; i++) {
        int j;
        cin >> j;
        cards.erase(j);
    }
    for(int i=0; i<N/2;i++) {
        auto it = cards.lower_bound(c[i]);
        ++it;
        if(it != end(cards)) {
            cards.erase(it);
        }
    }
}