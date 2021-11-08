// leetcode37_Sudoku_Solver.cpp : This file contains the 'main' function. Program execution begins and ends there.
// following https://github.com/mCodingLLC/VideosSampleCode/blob/master/videos/045_c_plus__plus__sudoku_solver_in_7_minutes_using_recursive_backtracking/sudoku_solver.cpp
//

#include <iostream>
#include <vector>
#include <array>
#include <bitset>

constexpr std::size_t
get_cell(std::size_t row, std::size_t col) noexcept
{
    return (row / 3) * 3 + col / 3;
}

constexpr std::size_t
get_next_row(std::size_t row, std::size_t col) noexcept
{
    return row + (col + 1) / 9;
}

constexpr std::size_t
get_next_col(std::size_t col) noexcept
{
    return (col + 1) % 9;
}

class Solution
{
public:
    void solveSudoku(std::vector<std::vector<char>>& board) const noexcept
    {
        /* Note: input is guaranteed to be a valid board using only '1'-'9' and '.' with a unique solution.
           Solution should modify board, not return a new one. */

        std::array<std::bitset<9>, 9> row_contains = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        std::array<std::bitset<9>, 9> col_contains = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        std::array<std::bitset<9>, 9> cell_contains = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };

        for (std::size_t row = 0; row < 9; ++row)
        {
            for (std::size_t col = 0; col < 9; ++col)
            {
                char digit;
                if ((digit = board[row][col]) != '.')
                {
                    std::size_t digit_idx = digit - '1';
                    row_contains[row].set(digit_idx);
                    col_contains[col].set(digit_idx);
                    std::size_t cell = get_cell(row, col);
                    cell_contains[cell].set(digit_idx);
                }
            }
        }
        

        solve(board, 0, 0, row_contains, col_contains, cell_contains);
        
    }

    bool solve(std::vector<std::vector<char>>& board, int row, int col, 
        std::array<std::bitset<9>, 9> row_contains,
        std::array<std::bitset<9>, 9> col_contains,
        std::array<std::bitset<9>, 9> cell_contains) const noexcept {
        auto test = find_next_empty(board, 0, 0);
        int new_row = test.first;
        int new_col = test.second;
        std::cout << test.first << test.second;
        if (test.first == 9) {
            return true;
        }
        //find already eliminate box
        int cell = get_cell(new_row, new_col);
        std::bitset<9> contain = row_contains[new_row] | col_contains[new_col] | cell_contains[cell];
        if (contain.all()) {
            return false;
        }
        for (int index = 0; index < 9; index++) {
            if (!contain[index]) {
                board[new_row][new_col] = static_cast<char>(index+'1');
                row_contains[new_row].set(index);
                col_contains[new_col].set(index);
                cell_contains[cell].set(index);
                if (solve(board, 0, 0, row_contains, col_contains, cell_contains)) {
                    return true;
                }
                row_contains[new_row].reset(index);
                col_contains[new_col].reset(index);
                cell_contains[cell].reset(index);
            }
        }
        board[new_row][new_col] = '.';
        return false;
    }

    std::pair<int, int> find_next_empty(std::vector<std::vector<char>>& board, int row, int col) const noexcept 
    {
        while (row != 9) {
            if (board[row][col] == '.') {
                return { row,col };
            }
            col++;
            if (col == 9) {
                col = 0;
                row++;
            }
        }
        return { 9,0 };
    }
};


std::vector<std::vector<char>> flat_board_to_vec_vec(std::array<char, 81> const flat_board)
{
    std::vector<std::vector<char>> board;
    board.reserve(9);
    for (std::size_t row = 0; row < 9; ++row)
    {
        std::vector<char> this_row;
        this_row.reserve(9);
        for (std::size_t col = 0; col < 9; ++col)
        {
            this_row.push_back(flat_board[row * 9 + col]);
        }
        board.push_back(this_row);
    }
    return board;
}

void print_board(std::vector<std::vector<char>> board)
{
    for (std::size_t row = 0; row < 9; ++row)
    {
        for (std::size_t col = 0; col < 9; ++col)
        {
            std::cout << board[row][col] << ", ";
        }
        std::cout << "\n";
    }
}

int main()
{
    std::array<char, 81> const flat_board = { '5', '3', '.', '.', '7', '.', '.', '.', '.', '6', '.', '.', '1', '9', '5', '.', '.', '.', '.', '9', '8', '.', '.', '.', '.', '6', '.', '8', '.', '.', '.', '6', '.', '.', '.', '3', '4', '.', '.', '8', '.', '3', '.', '.', '1', '7', '.', '.', '.', '2', '.', '.', '.', '6', '.', '6', '.', '.', '.', '.', '2', '8', '.', '.', '.', '.', '4', '1', '9', '.', '.', '5', '.', '.', '.', '.', '8', '.', '.', '7', '9' };
    std::array<char, 81> const flat_expected = { '5', '3', '4', '6', '7', '8', '9', '1', '2', '6', '7', '2', '1', '9', '5', '3', '4', '8', '1', '9', '8', '3', '4', '2', '5', '6', '7', '8', '5', '9', '7', '6', '1', '4', '2', '3', '4', '2', '6', '8', '5', '3', '7', '9', '1', '7', '1', '3', '9', '2', '4', '8', '5', '6', '9', '6', '1', '5', '3', '7', '2', '8', '4', '2', '8', '7', '4', '1', '9', '6', '3', '5', '3', '4', '5', '2', '8', '6', '1', '7', '9' };
    std::vector<std::vector<char>> board = flat_board_to_vec_vec(flat_board);
    std::vector<std::vector<char>> const expected = flat_board_to_vec_vec(flat_expected);

    std::cout << "initial\n";
    print_board(board);

    std::cout << "expected\n";
    print_board(expected);

    Solution soln;

    soln.solveSudoku(board);
    std::cout << (board == expected ? "success!" : "UH OH :(") << std::endl;
    std::cout << "actual\n";
    print_board(board);
    
    return 0;
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
