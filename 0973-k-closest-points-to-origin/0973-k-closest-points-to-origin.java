class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> ans = new PriorityQueue<>(
            (a,b)->{
                return Double.compare(Math.sqrt(a[0]*a[0]+a[1]*a[1]),
                Math.sqrt(b[0]*b[0]+b[1]*b[1]));
            }
        );
        
        for(int i=0; i<points.length; i++){
            ans.add(points[i]);
        }

        int[][] finalAns = new int[k][2];
        for(int i=0; i<k; i++){
            int temp[] = ans.poll();
            finalAns[i][0] = temp[0];
            finalAns[i][1] = temp[1];
        }

        return finalAns;
    }
}