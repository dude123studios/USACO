#include <bits/stdc++.h>
using namespace std;

int N;
vector<string> dnas(7);
int ans = 10000;

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

bool v[7];
vector<string> curr;
void generate(int i)
{
    if (i == N)
    {
        string c = curr[0];
        for (int j = 1; j < N; j++)
        {
            c = merge(c, curr[j]);
        }
        ans = min(ans, (int)c.length());
    }
    for (int j = 0; j < N; j++)
    {
        if (v[j] == 1)
            continue;
        v[j] = true;
        curr.push_back(dnas[j]);
        generate(i + 1);
        curr.pop_back();
        v[j] = false;
    }
}

int main()
{
    cin >> N;
    for (int i = 0; i < N; i++)
        cin >> dnas[i];
    generate(0);
    cout << ans << endl;
}