package com.task.events;


import com.task.events.base.TaskEvent;
import com.task.utils.tasks.TaskFile;

/** Task created
 * @author SmallasWater*/

public class CreateTaskEvent extends TaskEvent {

    public CreateTaskEvent(TaskFile file) {
        super(file);
    }

}
