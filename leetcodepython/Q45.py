
def jump(nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        current = 0
        max = 0
        jump = 0
        count = 0
        length = len(nums)
        if(length==0):
             return jump
        for i in nums:
            if(count + i > max):
                max = count + i
            if(count == current):
                current = max
                if(max == length-1):
                    return jump
                jump += 1
            count+=1
        return jump
