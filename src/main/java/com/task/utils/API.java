package com.task.utils;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.item.Item;
import com.task.RsTask;
import com.task.events.DelTaskEvent;
import com.task.utils.tasks.TaskFile;
import com.task.utils.tasks.taskitems.ItemClass;
import com.task.utils.tasks.taskitems.PlayerTask;
import com.task.utils.tasks.PlayerFile;
import com.task.events.PlayerClickTaskEvent;
import com.task.utils.task.ListerEvents;

import java.util.LinkedList;


/**
 * @author SmallasWater
 */
public class API {


    /**
     * Create a task
     * @param task task {@link TaskFile}
     * @return whether the creation was successful
     * */
    public static boolean createTask(TaskFile task) {
        if(task != null){
            DataTool.createTask(task);
        }
        return false;
    }

    /**
     * Delete a task
     * @param taskName task name
     * @return whether the deletion was successful
     * */
    public static boolean deleteTask(String taskName) {
       TaskFile task = TaskFile.getTask(taskName);
       if(task != null){
           DelTaskEvent event = new DelTaskEvent(task);
           Server.getInstance().getPluginManager().callEvent(event);
           return task.close();
       }
        return false;
    }


    /**
     * Player receives a task
     * @param player player
     * @param task task name
     * @return whether the task was successfully received
     * */
    public static boolean playerSeeTask(Player player, TaskFile task){
        PlayerFile pf = PlayerFile.getPlayerFile(player.getName());
        if(pf.canInvite(task.getTaskName())){
            PlayerClickTaskEvent event = new PlayerClickTaskEvent(task,player);
            Server.getInstance().getPluginManager().callEvent(event);
            return true;
        }
        return false;
    }
    /**
     * Increase player task progress
     * @param player player
     * @param task task name
     * @param load task branch
     * @param value quantity
     * @return whether the task was successfully received
     * */
    public static boolean addPlayerTaskValue(String player,String task,String load,int value){
        PlayerFile f = PlayerFile.getPlayerFile(player);
        if(f != null){
            return f.addTaskValue(task,load,value);
        }
        return false;
    }

    /**
     * Set player task progress
     * @param player player
     * @param task task name
     * @param load task branch
     * @param value quantity
     * @return whether the task was successfully received
     * */
    public static boolean setPlayerTaskValue(String player,String task,String load,int value){
        PlayerFile f = PlayerFile.getPlayerFile(player);
        if(f != null){
            return f.setTaskValue(task,load,value);
        }
        return false;
    }

    /**
     * Task adds item progress
     * */
    public static void addItem(Player player, Item item, TaskFile.TaskType type){
        if(item != null){
            ItemClass itemClass = new ItemClass(item);
            if(!RsTask.getTask().canExisteItemClass(itemClass)){
                ListerEvents.defaultUseTask(player.getName(),itemClass.toTaskItem(false), type,false);
            }else{
                ListerEvents.defaultUseTask(player.getName(),itemClass.toTaskItem(true),type,false);

            }
        }
    }

    /**
     * Increase the progress of the player's ongoing task
     * @param player player
     * @param task task name
     * @param load task branch
     * @param value quantity
     * @return whether the increase was successful
     * */
    public static boolean addPlayerRunTask(String player,String task,String load,int value){
        PlayerFile f = PlayerFile.getPlayerFile(player);
        if(f != null){
            if(f.isRunning(task)) {
                return f.addTaskValue(task, load, value);
            }
        }
        return false;
    }

    /**
     * Set player progress
     * @param player player
     * @param task task name
     * @param load task branch
     * @param value quantity
     * @return whether the setting was successful
     * */
    public static boolean setPlayerRunTask(String player,String task,String load,int value){
        PlayerFile f = PlayerFile.getPlayerFile(player);
        if(f != null){
            if(f.isRunning(task)) {
                return f.setTaskValue(task, load, value);
            }
        }
        return false;
    }



    /**
     * Get all ongoing tasks of the player
     * @param player player
     * @return ongoing tasks
     * */
    public static LinkedList<PlayerTask> getAllRunTasks(Player player){
        //Get all ongoing tasks of the player
        LinkedList<PlayerTask> tasks = new LinkedList<>();
        PlayerFile file = PlayerFile.getPlayerFile(player.getName());
        if(file != null){
            for(PlayerTask task:file.getPlayerTasks()){
                if(file.isRunning(task.getTaskName())){
                    tasks.add(task);
                }
            }
        }
        return tasks;
    }


}
