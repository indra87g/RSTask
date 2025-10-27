package com.task.form;


import cn.nukkit.Player;
import cn.nukkit.form.element.*;
import cn.nukkit.form.window.FormWindow;
import cn.nukkit.form.window.FormWindowCustom;
import cn.nukkit.form.window.FormWindowModal;
import cn.nukkit.form.window.FormWindowSimple;
import com.task.RsTask;
import com.task.items.ItemLib;
import com.task.utils.ItemIDSunName;
import com.task.utils.task.CollectItemTask;
import com.task.utils.DayTime;
import com.task.utils.tasks.TaskFile;
import com.task.utils.tasks.taskitems.PlayerTask;
import com.task.utils.tasks.taskitems.PlayerTaskClass;
import com.task.utils.tasks.taskitems.SuccessItem;
import com.task.utils.tasks.taskitems.TaskItem;
import com.task.utils.DataTool;
import com.task.utils.tasks.PlayerFile;

import java.util.*;

/**
 * @author SmallasWater
 */
public class CreateMenu {

    static final int MENU = 0xcc1001;
    static final int TASKS = 0xcc1002;
    static final int TASKS_MENU = 0xcc1003;
    static final int CREATE = 0xcc1004;
    static final int AGAIN = 0xcc1005;
    static final int INVITE = 0xcc1006;

    public static RsTask task = RsTask.getTask();

    public static LinkedHashMap<Player,LinkedHashMap<Integer,Integer>> clickGroup = new LinkedHashMap<>();

    public static LinkedHashMap<Player,LinkedList<TaskFile>> runTaskFiles = new LinkedHashMap<>();


    /**
     * Send the main task interface GUI to the player
     * @param player player
     * */
    public static void sendMenu(Player player){
        LinkedHashMap<Integer,Integer> c = new LinkedHashMap<>();
        PlayerFile playerFiles = PlayerFile.getPlayerFile(player.getName());
        FormWindowSimple simple =
                new FormWindowSimple
                        (task.getLag("title"),(RsTask.canOpen())?
                                (task.getLag("player-task-integral").replace("%c",playerFiles.getCount()+"").replace("%f", RsTask.getTask().getFName()))
                                : "");
        int i = 0;
        int b = 0;
        Map map = ((Map)task.getConfig().get("Custom image path"));
        for (Object o:map.keySet()){

            Map map1 = (Map) map.get(o);
            String s = " ";
            if(RsTask.canOpen()){
                if(playerFiles.canLock(i)){
                    if(RsTask.getTask().canShowLodding()){
                        if(playerFiles.getCanInviteTasks(i).size() == 0 && playerFiles.getInviteTasks(i).size() == 0 && playerFiles.getSuccessTasks(i).size() == 0){
                            s = (RsTask.getTask().getLag("success-all"));
                        }else if(playerFiles.getSuccessTasks(i).size() > 0){
                            s = (RsTask.getTask().getLag("task-message-success").replace("%c",playerFiles.getSuccessTasks(i).size()+""));
                        }else if(playerFiles.getInviteTasks(i).size() > 0){
                            s = (RsTask.getTask().getLag("task-message-lodding").replace("%c",playerFiles.getInviteTasks(i).size()+""));
                        }else if(playerFiles.getCanInviteTasks(i).size() > 0){
                            s = (RsTask.getTask().getLag("task-message-can-receive").replace("%c",playerFiles.getCanInviteTasks(i).size()+""));
                        }
                    }
                }else{
                    s = (RsTask.getTask().getLag("Lock").replace("%c", DataTool.starNeed(i)+"").replace("%f", RsTask.getTask().getFName()));
                }
            }
            boolean isShow = true;
            if(map1.containsKey("show or hide")){
                isShow = Boolean.valueOf(map1.get("show or hide").toString());
            }
            if(isShow){
                ElementButton button = new ElementButton(map1.get("name")+s);
                ElementButtonImageData imageData = new ElementButtonImageData("internet".equals(map1.get("image type").toString())?"url":"path",(String) map1.get("image path"));
                button.addImage(imageData);
                simple.addButton(button);
                c.put(b,i);
                b++;
            }else{
                c.put(b,i);
            }
            i++ ;

        }
        clickGroup.put(player,c);
        send(player,simple, MENU);
    }

    /**
     * Send the task GUI in progress
     * */
    public static void sendMenuRunningTaskList(Player player){
        PlayerFile file = PlayerFile.getPlayerFile(player.getName());
        LinkedList<TaskFile> taskFiles = file.getRunningTasks();
        runTaskFiles.put(player,taskFiles);
        FormWindowSimple simple = makeSimpleByTasks(player,taskFiles,RsTask.getTask().getLag("running-task-menu-title"),"");
        player.showFormWindow(simple,INVITE);

    }

    private static FormWindowSimple makeSimpleByTasks(Player player,LinkedList<TaskFile> taskFiles,String title,String context){
        PlayerFile playerFiles = PlayerFile.getPlayerFile(player.getName());
        FormWindowSimple simple = new FormWindowSimple(title,context);
        for(TaskFile file:taskFiles) {
            if(file != null){
                String s = "";
                switch (playerFiles.getTaskType(file)) {
                    case Running:
                        s = (RsTask.getTask().getLag("using"));
                        break;
                    case No_Invite:
                        if(!"null".equals(file.getLastTask())) {
                            if (!playerFiles.isSuccessed(file.getLastTask())) {
                                String last = file.getLastTask();
                                TaskFile file1 = file.getLastTaskFile();
                                if(file1 != null){
                                    last = file1.getName();
                                }
                                s = (RsTask.getTask().getLag("not-receive").replace("%s", last));
                                break;
                            }
                        }
                        s = RsTask.getTask().getLag("not-invite","§c[Not available]");
                        break;
                    case Success:
                        s = (RsTask.getTask().getLag("success"));
                        break;
                    case can_Invite:
                        s = (RsTask.getTask().getLag("can-receive"));
                        break;
                    case isSuccess_canInvite:
                        s = (RsTask.getTask().getLag("enable-receive"));
                        break;
                    case isSuccess_noInvite:
                        s = (RsTask.getTask().getLag("cannot-receive"));
                        break;
                    default:
                        break;
                }
                ElementButton button = file.getButton().toButton();
                button.setText(file.getName()+ s);
                simple.addButton(button);
                if(simple.getButtons().size() == 0){
                    simple.setContent((taskFiles.size() == 0)?"\n\n\n\n\n\n    "+ RsTask.getTask().getLag("no-task"):"");
                }
            }
        }
        return simple;
    }

    /**
     * Send the task list GUI to the player
     * @param player player
     * @param group group
     * */
    public static void sendTaskList(Player player, int group){
        LinkedList<TaskFile> taskFiles = TaskFile.getDifficultyTasks(group);
        runTaskFiles.remove(player);
        FormWindowSimple simple = makeSimpleByTasks(player,taskFiles,DataTool.getGroupName(group),RsTask.getTask().getLag("sendMenu-content"));
        send(player,simple, TASKS);
    }

    static void sendAgain(Player player){
        if(RsTask.getTask().getClickTask.containsKey(player)){
            TaskFile file = RsTask.getTask().getClickTask.get(player);
            if(file != null){
                FormWindowModal simple = new FormWindowModal(task.getLag("title"),
                        RsTask.getTask().getLag("giveUpChose","§d§lAre you sure you want to give up the %s task?{line break}§cYou will lose the current progress after giving up")
                                .replace("%s",file.getName()).replace("{line break}","\n"),"OK","Cancel");

                send(player,simple, AGAIN);
            }
        }else{
            player.sendMessage("§cPlease try again");
        }
    }

    /**
     * Convert the task progress into the content displayed on the GUI
     * @param player player
     * @param items task progress
     *
     * @return display content
     * */
    public static LinkedList<String> toTaskItemString(TaskItem[] items, Player player){
        LinkedList<String> builder = new LinkedList<>();
        for(TaskItem item:items){
            PlayerFile file2 = PlayerFile.getPlayerFile(player.getName());
            PlayerTask task = file2.getTaskByName(item.getTaskName());
            if(task != null){
                PlayerTaskClass taskClass = task.getTaskClass();
                int playerItem = taskClass.getLoad(item);
                int taskCount = item.getEndCount();
                if(item.getTaskTag() != TaskItem.TaskItemTag.diyName){
                    if(item.getTaskTag() != TaskItem.TaskItemTag.lib) {
                        builder.add(ItemIDSunName.getIDByName(item.getItemClass().getItem()) + "> " + playerItem + " / " + taskCount + "\n");
                    }else{
                        ItemLib lib = ItemLib.getItem(item.getTask().split("@")[0]);
                        if(lib != null){
                            builder.add(lib.getLibName() + "> " + playerItem + " / " + taskCount + "\n");
                        }
                    }
                }else{
                    builder.add(item.getTask()+"> "+playerItem+" / "+taskCount+"\n");
                }
            }
        }
        return builder;
    }

    /**
     * Convert the task progress into the content displayed on the GUI
     * @param player player
     * @param file task file {@link TaskFile}
     *
     * @return display content
     * */
    public static StringBuilder getTitles(Player player,TaskFile file){
        StringBuilder builder = new StringBuilder();
        builder.append(RsTask.getTask().getLag("tast-title")).append("§r ").append(file.getName()).append("\n");
        builder.append(RsTask.getTask().getLag("task-difficulty")).append("§r ").append(DataTool.getStar(file.getStar())).append("\n\n");
        builder.append(RsTask.getTask().getLag("task-introduce")).append("§r \n").append(file.getTaskMessage()).append("\n\n");
        PlayerFile file1 = PlayerFile.getPlayerFile(player.getName());
        int timeOut = file1.getTimeOutDay(file.getTaskName());
        int time = file.getLoadDay();
        DayTime dayTime1 = DataTool.getTimeByDay(timeOut);
        builder.append(RsTask.getTask().getLag("time-out","§e§lExpiration time:")).append("§r ").append(time <= 0?"§2Unlimited":dayTime1.getTime() > 0? "§a"+dayTime1.getTime()+DayTime.STRINGS[dayTime1.getType()]+" §cInvalid later":"§cExpired").append("\n\n");
        return builder;
    }

    /**
     * Send the leaderboard GUI to the player
     * @param player player
     * */
    public static void sendRankMenu(Player player){
        FormWindowSimple simple = new FormWindowSimple("Task System--Leaderboard","");
        StringBuilder builder = new StringBuilder();
        LinkedHashMap<String,Integer> map = new LinkedHashMap<>();
        PlayerFile file;
        for(String name: RsTask.getTask().getPlayerNames()){
            file = PlayerFile.getPlayerFile(name);
            map.put(name,file.getCount());
        }
        HashMap<String,Integer> list = DataTool.getPlayerRankingList(map);
        int in = 1;
        int i = 1;
        for(String uuid: list.keySet()){
            if (player.getName().equals(uuid)) {
                in = i;
            }
            if(i <= RsTask.getTask().getCount()){
                builder.append("§7No.§a").append(i).append(" §e>>§6").append(uuid).append("§e: ").append( list.get(uuid)).append("\n");
            }
            i++;
        }
        simple.setContent("Task points leaderboard: \n§bYour current ranking: §7No.§a"+in+"\n\n-------------------\n"+builder.toString());
        int lead = 0xcc1006;
        player.showFormWindow(simple, lead);

    }



    /**
     * Send the task interface GUI to the player
     * @param player player
     * @param file task file
     * */
    public static void sendTaskMenu(Player player, TaskFile file){

        FormWindowSimple simple = new FormWindowSimple(task.getLag("title"),"");
        StringBuilder builder = new StringBuilder();
        builder.append(getTitles(player,file));
        TaskFile file1 = TaskFile.getTask(file.getTaskName());
        builder.append(RsTask.getTask().getLag("task-speed")).append("§r\n");
        TaskItem[] items = new TaskItem[]{};
        if(file1 != null){
            items = file1.getTaskItem();
        }
        LinkedList<String> linkedList = new LinkedList<>();
        if(items.length > 0){
            CollectItemTask.onRun(player);
            linkedList = toTaskItemString(items,player);
            for(String s:linkedList){
                builder.append(s);
            }
        }else{
            builder.append(RsTask.getTask().getLag("notTasks")).append("§r\n");
        }

        builder.append("\n\n");


        builder.append(RsTask.getTask().getLag("success-item")).append("§r\n");
        SuccessItem successItem = file.getFirstSuccessItem();
        if(!PlayerFile.getPlayerFile(player.getName()).isFirst(file)){
            successItem = file.getSuccessItem();
        }
        LinkedList<StringBuilder> builders = new LinkedList<>();
        if(successItem != null){
            builders = successItem.toList();
        }
        if(builders.size() > 0){
            for(StringBuilder builder1:builders){
                builder.append(builder1).append("\n");
            }
        }else{
            builder.append(RsTask.getTask().getLag("nothave-SuccessItem"));
        }
        builder.append("\n");
        simple.setContent(builder.toString());

        if(PlayerFile.getPlayerFile(player.getName()).isSuccess(file) && linkedList.size() == items.length){
            simple.addButton(getSuccessButton());
        }else{
            simple.addButton(getCancelButton());
        }

        ElementButton giveUp = new ElementButton(RsTask.getTask().getLag("giveUpTask","§cGive up the task"));
        giveUp.addImage(new ElementButtonImageData("path","textures/ui/book_trash_default"));
        simple.addButton(giveUp);
        if(RsTask.canBack()){
            ElementButton button2 = new ElementButton(RsTask.getTask().getLag("back","Back"));
            ElementButtonImageData imageData2 = new ElementButtonImageData("path","textures/ui/refresh_light");
            button2.addImage(imageData2);
            simple.addButton(button2);
        }

        send(player,simple, TASKS_MENU);
    }

    /**
     * Send the create task GUI to the player
     * @param player player
     * */
    public static void sendCreateTaskMenu(Player player){
        FormWindowCustom custom = new FormWindowCustom("Create task");
        custom.addElement(new ElementLabel("Task creation UI Please fill in according to the prompts (this UI only provides a simple task creation, if you want to make further changes, please modify the configuration)"));
        custom.addElement(new ElementInput("Please enter the task name","e.g. Task ①--Destroy and collect oak wood","Task ①--Destroy and collect oak wood"));
        LinkedList<String> list = new LinkedList<>();
        for(TaskFile.TaskType type: TaskFile.TaskType.values()){
            list.add(type.getTaskType());
        }
        custom.addElement(new ElementDropdown("Please select the task type",list,3));
        LinkedList<String> list1 = new LinkedList<>();
        Map map = ((Map)task.getConfig().get("Custom image path"));
        Map map1;
        for(int i = 0;i<map.size();i++){
             map1 = (Map) map.get(i+"");
             list1.add(map1.get("name").toString());
        }
        custom.addElement(new ElementDropdown("Please select a task group",list1));
        custom.addElement(new ElementInput("Please enter the task difficulty (integer)","e.g. 1","1"));
        custom.addElement(new ElementInput("Please enter the task introduction","e.g. Collect 10 oak wood","Collect 10 oak wood"));
        custom.addElement(new ElementInput("Please enter the task completion conditions (& distinguish multiple elements) @item is the item (17:0:10@item) @lib is the item dictionary (wood:10@lib) @tag is the nbt item (id:10@tag) (for custom tasks, please enter content:quantity)","e.g. 17:0:10@item or id:10@tag (collection task)","17:0:10@item"));
        custom.addElement(new ElementInput("Please enter the task rewards (& distinguish multiple elements) @item is the reward item @tag rewards the item in TagItem.json @lib rewards the item in the item dictionary (only the first one) @money rewards money @Cmd rewards the command (%p represents the player)","e.g. 366:0:1@item or id:1@tag","366:0:1@item&100@money"));
        send(player,custom, CREATE);
    }


    private static void send(Player player,FormWindow window,int id){
        player.showFormWindow(window,id);
    }

    private static ElementButton getCancelButton(){
        ElementButton button = new ElementButton(RsTask.getTask().getLag("unsubmission-task"));
        ElementButtonImageData imageData = new ElementButtonImageData("path","textures/ui/cancel");
        button.addImage(imageData);
        return button;
    }

    private static ElementButton getSuccessButton(){
        ElementButton button = new ElementButton(RsTask.getTask().getLag("submission-task"));
        ElementButtonImageData imageData = new ElementButtonImageData("path","textures/ui/confirm");
        button.addImage(imageData);
        return button;
    }





}
