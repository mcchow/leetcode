def isMatch(s, p):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """

        #Range for proved correct matching
        processArray=[[False for i in range(len(p))] for j in range(len(s))]
        processArray[0][0]=True
        print(processArray)
s ="babbb"
p = "b*b"
print(isMatch(s,p))