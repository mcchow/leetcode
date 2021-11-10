// Leetcode38_count_and_say.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <stack>
#include <vector>
#include <string> 
using namespace std;

class Solution {
public:
    string countAndSay(int n) {
        string current = "1";
        
        for (int i = 1; i < n; i++) {
            int count=1;
            string temp = "";
            int previous = current[0];
            int ptr = 1;

            while (ptr < current.length()) {
                if (previous == current[ptr]) {
                    count++;
                }
                else {
                    temp += to_string(count) + current[ptr - 1];
                    count = 1;
                }
                previous = current[ptr];
                ptr++;
            }
            temp += to_string(count) + current[ptr-1];
            current = temp;
            cout << current<<endl;
        }
        return current;
    }
};

int main()
{
    Solution sol;
    cout << sol.countAndSay(5);
}

// Run program: Ctrl + F5 or Debug > Start Without Debugging menu
// Debug program: F5 or Debug > Start Debugging menu

// Tips for Getting Started: 
//   1. Use the Solution Explorer window to add/manage files
//   2. Use the Team Explorer window to connect to source control
//   3. Use the Output window to see build output and other messages
//   4. Use the Error List window to view errors
//   5. Go to Project > Add New Item to create new code files, or Project > Add Existing Item to add existing code files to the project
//   6. In the future, to open this project again, go to File > Open > Project and select the .sln file
