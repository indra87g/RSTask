package com.task.utils.tasks;



import cn.nukkit.Player;
import cn.nukkit.Server;

import cn.nukkit.utils.Config;
import cn.nukkit.utils.TextFormat;
import com.task.events.PlayerAddTaskEvent;
import com.task.utils.tasks.taskitems.SuccessItem;
import com.task.utils.tasks.taskitems.TaskButton;
import com.task.utils.tasks.taskitems.TaskItem;
import com.task.RsTask;
import com.task.utils.DataTool;


import java.io.File;
import java.util.*;

/**
 *   ____  ____ _____         _
 |  _ \/ ___|_   _|_ _ ___| | __
 | |_) \___ \ | |/ _` / __| |/ /
 |  _ < ___) || | (_| \__ \   <
 |_| \_\____/ |_|\__,_|___/_|\_\

 @author 若水
 */
public class TaskFile {


    private String showName;

    /** Task name */
    private String taskName;

    /** Task difficulty */
    private int star;

    /** Task group */
    private int group;

    /** Task introduction */
    private String taskMessage;

    /** Completion times limit*/
    private int successCount = 1;

    /** Reward items */
    private SuccessItem successItem;

    /** First completion reward*/
    private SuccessItem firstSuccessItem;

    /** Task content */
    private TaskItem[] taskItem;

    /** Task type */
    private TaskType type;

    /** Previous task */
    private String task;

    private LinkedList<String> notInviteTasks = new LinkedList<>();

    private LinkedList<String> notToInviteTasks = new LinkedList<>();
    /** Refresh time */
    private int day;

    /**Duration*/
    private int loadDay = -1;

    /** Completion announcement type (0/1) */
    private int messageType;

    /** Announcement content */
    private String broadcastMessage;

    /** Button image*/
    private TaskButton button;


    public enum TaskType{
        /**
         * Destruction task
         * */
        BlockBreak("Destroy"),
        /**
         * Placement task
         * */
        BlockPlayer("Place"),
        /**
         * Discard task
         * */
        DropItem("Discard"),
        /**
         * Collection task
         * */
        CollectItem("Collect"),
        /**
         * Synthesis task
         * */
        CraftItem("Synthesize"),
        /**
         * Get task
         * */
        GetItem("Get"),

        EatItem("Eat"),

        GetWater("Fetch water"),

        Click("Click"),



        DIY("Custom");
        protected String taskType;
        TaskType(String taskType){

            this.taskType = taskType;
        }

        public String getTaskType() {
            return taskType;
        }
    }

    public TaskFile(String taskName, TaskType type, TaskItem[] taskItem){
        this(taskName,type,taskItem,"None");
    }

    public TaskFile(String taskName, TaskType type, TaskItem[] taskItem, String taskMessage){
        this(taskName,type,taskItem,taskMessage,1);
    }

    public TaskFile(String taskName, TaskType type, TaskItem[] taskItem, String taskMessage, int star){
        this(taskName,type,taskItem,taskMessage,star,star - 1,null);
    }

    public TaskFile(String taskName, TaskType type, TaskItem[] taskItem, String taskMessage, int star,int group, SuccessItem item){
        this(taskName,type,taskItem,taskMessage,star,group,item,null);
    }

    public TaskFile(String taskName, TaskType type, TaskItem[] taskItem, String taskMessage, int star,int group, SuccessItem item, String task){
        this(taskName,type,taskItem,taskMessage,star,group,item,task,0);
    }

    public TaskFile(String taskName, TaskType type, TaskItem[] taskItem, String taskMessage, int star,int group, SuccessItem item, String task, int day){
        this(taskName,type,taskItem,taskMessage,star,group,item,null,task,day,0);
    }

    public TaskFile(String taskName, TaskType type, TaskItem[] taskItem, String taskMessage, int star,int group, SuccessItem item, SuccessItem firstItem, String task, int day, int messageType){
        this(taskName,type,taskItem,taskMessage,star,group,item,firstItem,task,day,messageType,"§l§c[§bTask System§c]§eCongratulations §a%p §ecompleted the §d[ %s ]§etask");
    }
    public TaskFile(String taskName, TaskType type, TaskItem[] taskItem, String taskMessage, int star,int group, SuccessItem item, SuccessItem firstItem, String task, int day, int messageType, String broadcastMessage){
        this(taskName,type,taskItem,taskMessage,star,group,item,firstItem,task,day,messageType,broadcastMessage,new TaskButton(""));
    }

    public TaskFile(String taskName, TaskType type, TaskItem[] taskItem, String taskMessage, int star,int group, SuccessItem item, SuccessItem firstItem, String task, int day, int messageType, String broadcastMessage, TaskButton button){
        this.type = type;
        this.taskItem = taskItem;
        this.taskName = taskName;
        this.taskMessage = taskMessage;
        this.star = star;
        this.group = group;
        this.successItem = item;
        this.task = task;
        this.day = day;
        this.firstSuccessItem = firstItem;
        this.messageType = messageType;
        this.button = button;
        this.showName = "This is a task";
        this.broadcastMessage = broadcastMessage;
    }

    public TaskType getType() {
        return type;
    }

    public int getStar() {
        return star;
    }

    public String getTaskMessage() {
        return taskMessage;
    }

    public String getTaskName() {
        return taskName;
    }

    public SuccessItem getSuccessItem() {
        return successItem;
    }

    public SuccessItem getFirstSuccessItem() {
        return firstSuccessItem;
    }

    public TaskItem[] getTaskItem() {
        return taskItem;
    }

    public String getLastTask() {
        return task;
    }

    public TaskFile getLastTaskFile(){
        return TaskFile.getTask(task);
    }

    public void toSaveConfig(){
        if(taskName == null) {
            return;
        }
        if(!isFileTask(taskName)){
            RsTask.getTask().saveResource("Task.yml","/Tasks/"+ taskName +".yml",false);
        }
        LinkedHashMap<String,Object> taskitems = new LinkedHashMap<>();
        if(taskItem != null){
            for(TaskItem taskItem:taskItem){
                taskitems.putAll(taskItem.toSaveConfig());
            }
        }
        Config config = RsTask.getTask().getTaskConfig(taskName);
        if(showName == null){
            showName = config.getString("Task display name","This is a task");
        }
        config.set("Task display name",showName);
        config.set("Task difficulty",star);
        config.set("Task group",group);
        config.set("Task introduction",taskMessage == null ? "None":taskMessage);
        config.set("Refresh time (minutes)",day);
        config.set("Duration (minutes)",loadDay);
        config.set("Task type",type.getTaskType());
        config.set("Completion times limit",successCount);
        if(task != null && !"null".equals(task)) {
            config.set("Complete this task before you need to complete",task);
        }
        config.set("Cannot receive this task after completing the following tasks",notInviteTasks);
        config.set("Cannot receive this task after receiving the following tasks",notToInviteTasks);
        config.set("Task content",taskitems);
        if(firstSuccessItem != null){
            config.set("First completion reward",firstSuccessItem.toSaveConfig());
        } else {
            config.set("First completion reward",successItem.toSaveConfig());
        }
        config.set("Reward",successItem.toSaveConfig());
        config.set("Completion announcement type (0/1)",messageType);
        config.set("Announcement content",broadcastMessage);
        config.set("Custom button image",button.toSaveConfig());
        config.save();
        RsTask.getTask().taskConfig.put(taskName,config);
    }

    private void setShowName(String showName) {
        this.showName = showName;
    }

    public String getShowName() {
        return showName;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public int getGroup() {
        return group;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public void setButton(TaskButton button) {
        this.button = button;
    }

    public TaskButton getButton() {
        return button;
    }

    public void setBroadcastMessage(String broadcastMessage) {
        this.broadcastMessage = broadcastMessage;
    }

    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }

    public void setFristSuccessItem(SuccessItem fristSuccessItem) {
        this.firstSuccessItem = fristSuccessItem;
    }

    public void setSuccessItem(SuccessItem successItem) {
        this.successItem = successItem;
    }

    public void setTaskItem(TaskItem[] taskItem) {
        this.taskItem = taskItem;
    }

    public void setLastTask(String task) {
        this.task = task;
    }

    public void setTaskMessage(String taskMessage) {
        taskMessage = taskMessage;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setType(TaskType type) {
        this.type = type;
    }

    public int getDay() {
        return day;
    }


    public void addTaskItem(TaskItem item){
        TaskItem[] items = getTaskItem();
        TaskItem[] newItem = new TaskItem[items.length+1];
        System.arraycopy(items,0,newItem,0,newItem.length);
        newItem[items.length] = item;
        this.setTaskItem(newItem);
    }


    public void removeTaskItem(TaskItem item){
        if(canInArrayTaskItem(item)){
            TaskItem[] taskItems = taskItem;
            TaskItem[] newItem = new TaskItem[taskItems.length-1];
            int i = 1;
            for(TaskItem item1:taskItems){
                if(!item1.equals(item)){
                    newItem[i] = item1;
                }
                i++;
            }
            taskItem = newItem;
        }
    }

    public boolean canInArrayTaskItem(TaskItem item){
        for(TaskItem item1:taskItem){
            if(item1.equals(item)) {
                return true;
            }
        }
        return false;
    }


    public int getMessageType() {
        return messageType;
    }

    public String getBroadcastMessage() {
        return broadcastMessage;
    }

    public static boolean isFileTask(String taskName){
        File file = new File(RsTask.getTask().getDataFolder()+"/Tasks/"+taskName+".yml");
        return file.exists();
    }

    public static TaskFile getTask(String taskName){
        return RsTask.getTask().tasks.get(taskName);
    }

    public String getName(){
        if("null".equalsIgnoreCase(showName) || showName == null || "".equalsIgnoreCase(showName)){
            return getTaskName();
        }
        return getShowName();
    }

    private static TaskFile toTask(String taskName){
        try{
            if(isFileTask(taskName)){
                Config config = RsTask.getTask().getTaskConfig(taskName);
                String sType = config.getString("Task type");
                int succount = config.getInt("Completion times limit",1);
                TaskType type = null;
                for(TaskType taskType:TaskType.values()){
                    if(taskType.getTaskType().equals(sType)){
                        type = taskType;
                        break;
                    }
                }
                Map map = (Map) config.get("Task content");
                TaskItem[] taskItems;
                if(map != null){
                    taskItems = new TaskItem[map.size()];
                    int i = 0;
                    for(Object os :map.keySet()){
                        if(os  instanceof String){
                            taskItems[i] = TaskItem.toTaskItem(taskName,new LinkedHashMap<String,Integer>() {{
                                put((String) os ,Integer.parseInt(String.valueOf( map.get(os ))));}});
                            i++;
                        }
                    }
                }else{
                    return null;
                }
                Map firstSuccess = (Map) config.get("First completion reward");
                SuccessItem first =
                        SuccessItem.toSuccessItem(firstSuccess);
                Map success = (Map) config.get("Reward");
                SuccessItem second =
                        SuccessItem.toSuccessItem(success);
                if(type == null) {
                    return null;
                }
                TaskFile file = new TaskFile(taskName,type,taskItems,config.getString("Task introduction")
                        ,config.getInt("Task difficulty"),config.getInt("Task group",config.getInt("Task difficulty") - 1),second,first,config.getString("Complete this task before you need to complete"),
                        +config.getInt("Refresh time (minutes)",0),config.getInt("Completion announcement type (0/1)"),config.getString("Announcement content"),TaskButton.toTaskButton((Map) config.get("Custom button image")));
                file.setShowName(config.getString("Task display name"));
                file.setSuccessCount(succount);
                file.setNotInviteTasks(new LinkedList<>(config.getStringList("Cannot receive this task after completing the following tasks")));
                file.setNotToInviteTasks(new LinkedList<>(config.getStringList("Cannot receive this task after receiving the following tasks")));
                file.setLoadDay(config.getInt("Duration (minutes)",1440));
                return file;
            }

        }catch (Exception e){
            e.printStackTrace();
            Server.getInstance().getLogger().error("An error occurred when reading the "+taskName+" task file, it may be because it no longer exists or the configuration is wrong");
            File file = new File(RsTask.getTask().getDataFolder()+"/Tasks/"+taskName+".yml");
            if(file.exists()){
                Server.getInstance().getLogger().error("Update error: detected "+taskName+" exists, deleted "+taskName+".yml file");
                if(!file.delete()){
                    Server.getInstance().getLogger().error("Failed to delete "+taskName+".yml");
                }
            }
            return null;
        }
        return null;
    }

    public void setLoadDay(int loadDay) {
        this.loadDay = loadDay;
    }

    public int getLoadDay() {
        return loadDay;
    }

    public void setNotToInviteTasks(LinkedList<String> notToInviteTasks) {
        this.notToInviteTasks = notToInviteTasks;
    }

    public LinkedList<String> getNotToInviteTasks() {
        return notToInviteTasks;
    }

    public LinkedList<String> getNotInviteTasks() {
        return notInviteTasks;
    }

    public void setNotInviteTasks(LinkedList<String> notInviteTasks) {
        this.notInviteTasks = notInviteTasks;
    }

    public void setSuccessCount(int successCount) {
        this.successCount = successCount;
    }

    public int getSuccessCount() {
        return successCount;
    }

    public boolean close(){
        if(isFileTask(this.taskName)){
            File file = new File(RsTask.getTask().getDataFolder()+"/Tasks/"+ taskName +".yml");
            return file.delete();
        }
        return true;
    }


    /** Get count by TaskItem
     *
     * @param item task progress class
     *
     * @return get progress*/
    public int getCountByTaskItem(TaskItem item){
        for(TaskItem item1:taskItem){
            if(item1.equals(item)) {
                return item1.getEndCount();
            }
        }
        return 0;
    }

    /** Get all task files
     * @return task class*/
    public static LinkedHashMap<String,TaskFile> getTasks(){
        int sCount = 0;
        int errorCount = 0;
        File file = new File(RsTask.getTask().getDataFolder()+"/Tasks");
        LinkedHashMap<String,TaskFile> names = new LinkedHashMap<>();
        File[] files = file.listFiles();
        if(files != null){
            Arrays.sort(files);
            for(File file1:files){
                if(file1.isFile()){
                    String name = file1.getName().substring(0,file1.getName().lastIndexOf("."));
                    TaskFile file2 = TaskFile.toTask(name);
                    if(file2 != null) {
                        names.put(name,file2);
                        sCount++;
                    }else{
                        errorCount++;
                    }
                }else{
                    errorCount++;
                }
            }
            RsTask.getTask().getLogger().info(TextFormat.colorize('&',"Task loading completed &a"+sCount+"&r tasks loaded successfully &c"+errorCount+"&r tasks failed to load"));

        }
        return names;
    }

    /** Get all tasks in the task group
     * @param group group
     *
     * @return list of task files
     * */
    public static LinkedList<TaskFile> getDifficultyTasks(int group){
        LinkedList<TaskFile> files = new LinkedList<>();
        for (TaskFile file: RsTask.getTask().tasks.values()){
            if(file.getGroup() == group) {
                files.add(file);
            }
        }
        DataTool.sortTaskFiles(files);
        return files;
    }

    /**
     * A series of judgments made after the player clicks on the task
     * @param player player
     * @param file task file
     *
     * @return whether it was successful*/
    public static boolean runTaskFile(Player player,TaskFile file){
        PlayerFile file1 = PlayerFile.getPlayerFile(player.getName());
        PlayerFile.PlayerTaskType type = file1.getTaskType(file);

        if(type == PlayerFile.PlayerTaskType.can_Invite || type == PlayerFile.PlayerTaskType.isSuccess_canInvite){
            int starCount = DataTool.starNeed(file.getGroup());
            if(RsTask.canOpen() && file1.getCount() < starCount){
                player.sendMessage(RsTask.getTask().getLag("not-add-task","§c[Task System] Sorry, this task cannot be received"));
                return false;
            }else{
                PlayerAddTaskEvent event1= new PlayerAddTaskEvent(player,file);
                Server.getInstance().getPluginManager().callEvent(event1);
                return true;
            }
        }
        if(type == PlayerFile.PlayerTaskType.Running || type == PlayerFile.PlayerTaskType.Success){
            return true;
        }
        if((file.getLastTask() != null && !"null".equals(file.getLastTask()) && !"".equals(file.getLastTask()))){
            if(!file1.isSuccessed(file.getLastTask())){
                player.sendMessage(RsTask.getTask().getLag("useLastTask").replace("%s",file.getLastTask()));
                return false;
            }
        }
        if(file1.isSuccessed(file.getTaskName())){
            if(file.getSuccessCount() != -1) {
                if(file.getSuccessCount() <= file1.getSuccessedCount(file.getTaskName())) {
                    player.sendMessage(RsTask.getTask().getLag("repeat-collection"));
                    return false;
                }
            }
        }

        if(!file1.inDay(file.getTaskName()) ){
            //Task refresh duration (minutes)
            int day = file.getDay();
            int hours = 60;
            int dayTime = 1440;
            //Elapsed time (minutes)
            int out = DataTool.getTime(file1.getTaskByName(file.getTaskName()).getTaskClass().getTime());
            int dayM = ((day > out)?(day - out):0);
            String dayMs = dayM+" minutes";
            if(dayM / hours >= 1){
                if(dayM / dayTime  >= 1){
                    dayMs = (dayM / dayTime)+" days";
                }else{
                    dayMs = (dayM / hours)+" hours";
                }
            }
            player.sendMessage(RsTask.getTask().getLag("repeat-inDay").
                    replace("%c", dayMs +""));
            return false;
        }
        if(type == PlayerFile.PlayerTaskType.No_Invite){
            player.sendMessage(RsTask.getTask().getLag("not-add-task","§c[Task System] Sorry, this task cannot be received"));
            return false;
        }

        return true;
    }




}
