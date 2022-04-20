#include <bits/stdc++.h>
using namespace std;

string merge(string s1, string s2)
{
    int l1 = s1.length();
    int l2 = s2.length();
    int m = 0;
    for (int i = 1; i <= min(l1, l2); i++)
    {
        bool works = true;
        for (int j = 0; j < i; j++)
        {
            if (s2[j] != s1[l1 - i + j])
            {
                works = false;
                break;
            }
        }
        if (works)
            m = i;
    }
    if (m == l1)
        return s2;
    if (m == l2)
        return s1;
    return s1 + s2.substr(m);
}

int main()
{
    vector<int> curr{1, 2, 3};
    vector<vector<int>> v;
    v.push_back(curr);
    curr.clear();
    cout << v[0].size() << endl;
}