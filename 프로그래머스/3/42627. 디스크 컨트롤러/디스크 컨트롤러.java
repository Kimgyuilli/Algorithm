import java.util.*;

class Solution {
    private class Job implements Comparable<Job> {
        int id;
        int start;
        int cost;
        
        Job(int id, int start, int cost) {
            this.id = id;
            this.start = start;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Job job) {
            if(this.cost != job.cost) return this.cost - job.cost;
            if(this.start != job.start) return this.start - job.start;
            return this.id - job.id;
        }
    }
    
    public int solution(int[][] jobs) {
        int len = jobs.length;
        
        PriorityQueue<Job> pq = new PriorityQueue<>();
        
        Arrays.sort(jobs, (a, b) -> {
           return a[0] - b[0]; 
        });
            
        int time = 0;
        int idx = 0;
        int completedJobs = 0;
        int answer = 0;
        
        while(completedJobs < len) {
            
            while(idx < len && jobs[idx][0] <= time) {
                pq.offer(new Job(idx, jobs[idx][0], jobs[idx][1]));
                idx++;
            }
            
            if(pq.isEmpty()) {
                time = jobs[idx][0];
                continue;
            }
            
            Job cur = pq.poll();
            time += cur.cost; 
            answer += time - cur.start;
            completedJobs++;
            
        }
        
        return answer/len;
    }
}