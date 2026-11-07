class Solution {
    class Server implements Comparable<Server> {
        int wt;
        int index;

        Server(int wt, int index) {
            this.wt = wt;
            this.index = index;
        }

        @Override
        public int compareTo(Server s1) {
            if (this.wt != s1.wt) {
                return Integer.compare(this.wt, s1.wt);
            }

            return Integer.compare(this.index, s1.index);
        }
    }

    class occupied implements Comparable<occupied> {
        int avlTime;
        int wt;
        int index;

        occupied(int avlTime, int wt, int index) {
            this.avlTime = avlTime;
            this.wt = wt;
            this.index = index;
        }

        @Override
        public int compareTo(occupied oc1) {

            if (this.avlTime != oc1.avlTime) {
                return Integer.compare(this.avlTime, oc1.avlTime);
            }

            if (this.wt != oc1.wt) {
                return Integer.compare(this.wt, oc1.wt);
            }

            return Integer.compare(this.index, oc1.index);
        }
    }

    public int[] assignTasks(int[] servers, int[] tasks) {

        PriorityQueue<Server> pq = new PriorityQueue<>();
        PriorityQueue<occupied> oc = new PriorityQueue<>();
        for (int i = 0; i < servers.length; i++) {
            pq.add(new Server(servers[i], i));
        }
        int ans[] = new int[tasks.length];
            int time = 0;
        for (int i = 0; i < tasks.length; i++) {
            time = Math.max(time, i);
            // Release all available servers
            while (!oc.isEmpty() && oc.peek().avlTime <= i) {
                occupied x = oc.remove();
                pq.add(new Server(x.wt, x.index));
            }

            if (pq.isEmpty()) {
                time = oc.peek().avlTime;

                while (!oc.isEmpty() && oc.peek().avlTime <= time) {
                    occupied x = oc.remove();
                    pq.add(new Server(x.wt, x.index));
                }
            }

            // Assign one server
            Server num = pq.remove();

            ans[i] = num.index;

            oc.add(new occupied(time + tasks[i], num.wt, num.index));
        }

        return ans;
    }
}