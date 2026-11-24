#include <iostream>
#include <string>
#include <climits>

using namespace std;

class Solution {
public:
    string minWindow(string s1, string s2) {
        int n = s1.size();
        int m = s2.size();
        
        int minLen = INT_MAX;
        int startIndex = -1;
        
        int j = 0; // Pointer for s2
        
        for (int i = 0; i < n; i++) {
            // 1. Forward pass: match characters of s2 in order
            if (s1[i] == s2[j]) {
                j++;
                
                // Entire s2 is matched
                if (j == m) {
                    int end = i;
                    j--; // Set j to the last character of s2
                    
                    // 2. Backward pass: shrink window to find the tightest start
                    while (j >= 0) {
                        if (s1[i] == s2[j]) {
                            j--;
                        }
                        i--;
                    }
                    
                    i++; // Move i back to the exact start of the valid window
                    int currLen = end - i + 1;
                    
                    // 3. Update minimum window (strict '<' keeps the leftmost one)
                    if (currLen < minLen) {
                        minLen = currLen;
                        startIndex = i;
                    }
                    
                    // 4. Reset j; the for-loop's i++ will start next search at i + 1
                    j = 0;
                }
            }
        }
        
        return (startIndex == -1) ? "" : s1.substr(startIndex, minLen);
    }
};