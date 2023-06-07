class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int[] first = coordinates[0];
        int[] second = coordinates[1];
        double slope;
        if((first[1]-second[1]) == 0)
        {
            slope=Integer.MAX_VALUE;
        }
        else{
            slope = ((double)(first[0]-second[0])/(first[1]-second[1]));
        }
        
        for(int i=1 ;i<coordinates.length;i++)
        {
            if((first[1]-coordinates[i][1]) == 0)
            {
                if(slope != Integer.MAX_VALUE) return false;
            }
            else
            if((double)(first[0]-coordinates[i][0])/(first[1]-coordinates[i][1]) != slope)
            {
                return false;
            }
        }
        return true;
    }
}