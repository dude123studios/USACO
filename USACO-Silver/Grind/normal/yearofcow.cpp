#include <bits/stdc++.h>
using namespace std;

int main()
{
    int N, K;
    cin >> N >> K;
    set<int> intervals;
    for (int i = 0; i < N; i++)
    {
        int year;
        cin >> year;
        intervals.insert(year / 12);
    }
    vector<int> gaps;
    int prev = 0;
    for (auto it : intervals)
    {
        gaps.push_back(max(0, it - prev - 1));
        prev = it;
    }
    sort(gaps.begin(), gaps.end());
    int full = intervals.size();
    int ans = 0;
    for (int i = 0; i < max(0, full - (K - 1)); i++)
        ans += gaps[i];
    cout << (ans + full) * 12 << endl;
}