#include <bits/stdc++.h>
using namespace std;
int Q;
vector<set<char>> p;

string s, t;
set<set<char>> ans;
char l[18] = {
    'a',
    'b',
    'c',
    'd',
    'e',
    'f',
    'g',
    'h',
    'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r'};
bool works(set<char> allowed)
{
    vector<char> ns, nt;

    for (int i = 0; i < s.size(); i++)
        if (allowed.find(s[i]) != allowed.end())
            ns.push_back(s[i]);
    for (int i = 0; i < t.size(); i++)
        if (allowed.find(t[i]) != allowed.end())
            nt.push_back(t[i]);
    return nt == ns;
}
void gen()
{
    set<char> curr;
    for (int i = 0; i < 1 << 18; i++)
    {
        curr.clear();
        for (int j = 0; j < 18; j++)
        {
            if (i & (1 << j))
                curr.insert(l[i]);
        }
        if (works(curr))
            p.push_back(curr);
    }
}

int main()
{
    string s, t;
    cin >> s >> t >> Q;
    gen();
    cout << p.size() << endl;
}