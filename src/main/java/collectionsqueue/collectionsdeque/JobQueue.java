package collectionsqueue.collectionsdeque;

import collectionsqueue.job.Job;
import collectionsqueue.job.NoJobException;

import java.util.*;

public class JobQueue {

    private Deque<Job> currentJobs = new ArrayDeque<>();


    public Deque<Job> addJobByUrgency(Job... jobs) {
        for (Job actualJob : jobs) {
            if (actualJob.isUrgent()) {
                currentJobs.addFirst(actualJob);
            } else {
                currentJobs.addLast(actualJob);
            }
        }
        return currentJobs;
    }

    public Job dispatchUrgentJob(Deque<Job> jobs) throws NoJobException {
        if (currentJobs.isEmpty()) {
            throw new NoJobException("No job available, get a rest!");
        }
        return currentJobs.getFirst();
    }

    public Job dispatchNotUrgentJob(Deque<Job> jobs) throws NoJobException {
        if (currentJobs.isEmpty()) {
            throw new NoJobException("No job available, get a rest!");
        }
        return currentJobs.getLast();
    }

}
