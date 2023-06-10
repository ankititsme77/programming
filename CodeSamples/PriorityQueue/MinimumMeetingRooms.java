class Solution {
    public int minMeetingRooms(int[][] intervals) {


        if(intervals.length == 0)
            return 0;

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));


        PriorityQueue<Integer> queue= new PriorityQueue<Integer>();


        queue.add(intervals[0][1]);


        for(int i=1; i < intervals.length ; i++){


            if(intervals[i][0] >= queue.peek()){

                queue.poll();

            }

            queue.add(intervals[i][1]);


        }

        return queue.size();

    }
}a