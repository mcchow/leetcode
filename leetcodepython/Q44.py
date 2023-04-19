
def isMatch(s, p):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """

        #Range for proved correct matching
        s_start = 0
        p_start = 0
        if(s == ""):
            while(p_start < len(p)):
                if(p[p_start] != '*'):
                    return False
                p_start+=1
            return True
        
        while(p_start < len(p) and s_start < len(s)):
            if(p[p_start] == '*'):
                while(p[p_start] == '*'):
                    p_start += 1
                    if(p_start == len(p)):
                        return True
                if(p_start == len(p)):
                    return True
                if(p_start < len(p)):
                    while(s_start < len(s)):
                        if(p[p_start] == s[s_start] or p[p_start]=='?'):
                            result = isMatch(s[s_start:],p[p_start:])
                            if(result == True):
                                return True
                        s_start += 1
                    return False
            else:
                if(p[p_start] == '?' or p[p_start] == s[s_start]):
                    s_start += 1
                    p_start += 1
                else:
                    return False
        if(p_start == len(p) and s_start == len(s)):
            return True
        if(s[s_start:] == ""):
            while(p_start < len(p)):
                if(p[p_start] != '*'):
                    return False
                p_start+=1
            return True
        return False

s ="babbbbaabababaabbababaababaabbaabababbaaababbababaaaaaabbabaaaabababbabbababbbaaaababbbabbbbbbbbbbaabbb"
p = "b**bb**a**bba*b**a*bbb**aba***babbb*aa****aabb*bbb***a"
print(isMatch(s,p))