package com.task.events;


import com.task.events.base.TaskEvent;
import com.task.utils.tasks.TaskFile;

/** Delete task event
 * @author SmallasWater*/
public class DelTaskEvent extends TaskEvent {

    public DelTaskEvent(TaskFile file) {
        super(file);
    }
}
