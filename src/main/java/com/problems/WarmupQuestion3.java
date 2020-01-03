public class WarmupQuestion3 {

    /* how much is "overloading"? factor of 1,2,3..n mins?
        Should be assumed the difference between time taken by two threads in not more than 1 min?
        Should be assumed the task time cannot be divided between threads?
     */
    public static int minTimeRequired(int[] tasks, int threads) {
        int sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a); // max heap to sort the tasks by longest time
        for(int task : tasks) {
            sum += task;
            pq.offer(task);
        }
        int avg = sum / threads; // taking int for rounding the average
        int maxTime = 0;
        int timeRequired = 0;
        if (!pq.isEmpty() && threads >0) {
            while (pq.size() > 0) {
                timeRequired += pq.poll();
                maxTime = Math.max(maxTime, timeRequired);
                if (timeRequired == avg) {
                    threads--;
                    timeRequired = 0;
                }
            }
        }
        return maxTime;
    }

    public static void main(String[] args) {
        int[] tasks = {5,1,1,3};
        minTimeRequired(tasks, 2);
    }
}
