public class Solution {
    public IList<IList<int>> Permute(int[] nums) {
        IList<int> numbersList = nums.ToList();
        IList<IList<int>> result = new List<IList<int>>();
        return PermuteHelper(numbersList, result);
    }
    public IList<IList<int>> PermuteHelper(IList<int> nums, IList<IList<int>> result) {
        int size = nums.Count;
        if (size <= 1) {
        result.Add(new List<int>(nums)); // Make a copy of nums and add it to the result
        return result;
        }

        for (int i = 0; i < size; i++) {
            int firstElement = nums[0];

            // Remove the first element
            nums.RemoveAt(0);
            PermuteHelper(nums, result);
            foreach(IList<int> resultnums in current)
            {
                resultnums.Add(firstElement);
                result.Add(resultnums);
            }
            nums.Add(firstElement);
        }
        return result;
    }
}