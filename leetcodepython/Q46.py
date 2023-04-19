
def permute(nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        result = []
        if(len(nums) == 1):
                return [nums]
        
        for i in range(len(nums)):
            n = nums.pop(0)
            subset = permute(nums)
            for set in subset:
                set.append(n)
            result.extend(subset)
            nums.append(n)
        return result

nums=[1,2,3]
permute(nums)