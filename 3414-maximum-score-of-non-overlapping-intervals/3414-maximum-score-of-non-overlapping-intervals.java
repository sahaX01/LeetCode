class Solution {
    class Pair{
        long weight;
        List<Integer> indices;

        Pair(long weight, List<Integer> indices){
            this.weight = weight;
            this.indices = indices;
        }
    }
    int n;
    int arr[][];
    Pair dp[][];
    
    int compare(List<Integer> a, List<Integer> b){
        int n = Math.min(a.size(), b.size());

        for(int i=0; i<n; i++){
            if(!a.get(i).equals(b.get(i))){
                return Integer.compare(a.get(i), b.get(i));
            }
        }

        return Integer.compare(a.size(), b.size());
    }
    int findNext(int end, int start){
        int lo = start;
        int hi = n;

        while(lo<hi){
            int mid = lo + (hi-lo)/2;

            if(arr[mid][0]>end){
                hi = mid;
            }else{
                lo = mid + 1;
            }
        }

        return lo;
    }
    Pair solve(int i, int k){
        if(i == n || k == 0){
            return new Pair(0, new ArrayList<>());
        }

        if(dp[i][k] != null){
            return dp[i][k];
        }

        // Don't take current interval
        Pair skip = solve(i+1, k);

        // Take current interval
        int r = arr[i][1];
        int weight = arr[i][2];
        int originalIndex = arr[i][3];

        // Find first interval with start > r
        int next = findNext(r, i+1);

        Pair nextAns = solve(next, k-1);

        List<Integer> takeList = new ArrayList<>();
        takeList.add(originalIndex);
        takeList.addAll(nextAns.indices);

        Collections.sort(takeList);

        Pair take = new Pair(
            weight + nextAns.weight,
            takeList
        );

        // choose better answer
        if(take.weight > skip.weight){
            dp[i][k] = take;
        }else if(take.weight < skip.weight){
            dp[i][k] = skip;
        }else{
            // Same weight -> Lexicographially smaller indices
            if(compare(take.indices, skip.indices) < 0){
                dp[i][k] = take;
            }else{
                dp[i][k] = skip;
            }
        }

        return dp[i][k];
    }
    public int[] maximumWeight(List<List<Integer>> intervals) {
        n = intervals.size();
        arr = new int[n][4];

        // store original index first
        for(int i=0; i<n; i++){
            arr[i][0] = intervals.get(i).get(0); // l
            arr[i][1] = intervals.get(i).get(1); // r
            arr[i][2] = intervals.get(i).get(2); // weight
            arr[i][3] = i; // original index
        }

        // sort intervals by start point , end point
        Arrays.sort(arr, (a, b)->{
            if(a[0] != b[0]) return Integer.compare(a[0], b[0]);

            return Integer.compare(a[1], b[1]);
        });

        dp = new Pair[n+1][5];

        Pair ans = solve(0, 4);

        int result[] = new int[ans.indices.size()];

        for(int i=0; i<result.length; i++){
            result[i] = ans.indices.get(i);
        }
        return result;
    }
}