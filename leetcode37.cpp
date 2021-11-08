#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    char[][] input= {{"5","3",".",".","7",".",".",".","."}
    ,{"6",".",".","1","9","5",".",".","."}
    ,{".","9","8",".",".",".",".","6","."}
    ,{"8",".",".",".","6",".",".",".","3"}
    ,{"4",".",".","8",".","3",".",".","1"}
    ,{"7",".",".",".","2",".",".",".","6"}
    ,{".","6",".",".",".",".","2","8","."}
    ,{".",".",".","4","1","9",".",".","5"}
    ,{".",".",".",".","8",".",".","7","9"}}
    vector<vector<vector<int>>> curboard;

    //initalize and solve the puzzle using the helper function
    void solveSudoku(vector<vector<char>>& board) {
        for(vector<char>row : board){
            for(char number: row){
                cout << number <<",";
            }
            cout << "\n";
        }    
    }

    void addSudoku(){

    }
     
};

//test code


int main()
{
    std::cout << "Hello World" << std::endl;
}