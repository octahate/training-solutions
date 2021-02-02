package collectionsqueue.collectionspriorityqueue;

import collectionsqueue.job.Job;
import collectionsqueue.job.NoJobException;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class JobDispatcher {

    private PriorityQueue<Job> currentJobs = new PriorityQueue<>();


    public Queue<Job> addJob(Job... jobs){
        currentJobs.addAll(Arrays.asList(jobs));
        return currentJobs;
    }

    public Job dispatchNextJob(Queue<Job> jobs) throws NoJobException{
        if (currentJobs.size() == 0){
            throw new NoJobException("No job available, get a rest!");
        }
        return currentJobs.remove();
    }

}
