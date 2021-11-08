#include <iostream>
#include <array>
using namespace std;

class Solution {
public:
    //initalize and solve the puzzle using the helper function
    void solveSudoku(vector<vector<char> >& board) const noexcept
    {
        std::array<std::bitset<9>, 9> row_contains = {0,0,0,0,0,0,0,0,0};
        std::array<std::bitset<9>, 9> col_contains = {0,0,0,0,0,0,0,0,0};
        std::array<std::bitset<9>, 9> cell_contains = {0,0,0,0,0,0,0,0,0};
    }

    void addSudoku(){

    }
     
};

//test code


int main()
{
    std::array< char, 81> const flat_board = 
    {"5","3",".",".","7",".",".",".","."
    ,"6",".",".","1","9","5",".",".","."
    ,".","9","8",".",".",".",".","6","."
    ,"8",".",".",".","6",".",".",".","3"
    ,"4",".",".","8",".","3",".",".","1"
    ,"7",".",".",".","2",".",".",".","6"
    ,".","6",".",".",".",".","2","8","."
    ,".",".",".","4","1","9",".",".","5"
    ,".",".",".",".","8",".",".","7","9"};
    return 0;
}