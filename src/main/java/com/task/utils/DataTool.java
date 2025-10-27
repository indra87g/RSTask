package com.task.utils;


import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.entity.item.EntityFirework;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemFirework;
import cn.nukkit.level.Level;
import cn.nukkit.nbt.NBTIO;
import cn.nukkit.nbt.tag.CompoundTag;
import cn.nukkit.nbt.tag.DoubleTag;
import cn.nukkit.nbt.tag.FloatTag;
import cn.nukkit.nbt.tag.ListTag;
import cn.nukkit.utils.Config;
import cn.nukkit.utils.DyeColor;
import com.google.gson.reflect.TypeToken;
import com.task.RsTask;
import com.task.events.CreateTaskEvent;
import com.task.items.ItemLib;
import com.task.utils.tasks.TaskFile;
import com.task.utils.tasks.taskitems.ItemClass;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author SmallasWater
 */
public class DataTool {

    /** Convert a string in the format of 2019/6/9/24/11 to a Date
     * @param format time format
     *
     * @return time class*/
    public static Date getDate(String format){
        SimpleDateFormat lsdStrFormat = new SimpleDateFormat("yyyy/MM/dd/HH/ss");
        // Compatible with old versions...
        try {
            return lsdStrFormat.parse(format);
        }catch (ParseException e){
            lsdStrFormat = new SimpleDateFormat("yyyy/MM/dd");
            try{
                return lsdStrFormat.parse(format);
            } catch (ParseException ex) {
                return null;
            }
        }
    }

    /** Get all group strings
     *
     * @return group string*/
    public static String[] getGropAllName(){
        LinkedList<String> taskNames = new LinkedList<>();
        for(int i = 0; i < RsTask.getTask().getGroupSize(); i++){
            taskNames.add(i+"");
        }
        return taskNames.toArray(new String[0]);
    }

    /** Get all task names
     *
     * @return array of task names
     * */
    public static String[] getTaskAllNames(){
        LinkedList<String> taskNames = new LinkedList<>(RsTask.getTask().getTasks().keySet());
        return taskNames.toArray(new String[0]);
    }


    /** Get the difference in minutes
     * @param oldData time 1
     *
     * @return number of minutes*/

    public static int getTime(Date oldData) {
        long temp = System.currentTimeMillis() - oldData.getTime();
        return (int) temp / 1000 / 60;
    }

    public static DayTime getTimeByDay(int min){
        if(min > 0){
            int hour = min / 60;
            int day;
            if(hour >= 24){
                day = hour / 24;
                return new DayTime(DayTime.DAY,day);
            }else if(hour > 0){
                return new DayTime(DayTime.HOUR,hour);
            }else{
                return new DayTime(DayTime.MIN,min);
            }
        }
        return new DayTime(DayTime.MIN,min);
    }




    /** Convert Date to String*/
    public static String toDateString(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/HH/ss");
        return sdf.format(date);
    }


    /** Convert Data to Object*/
    public static Object[] toArrayByData(String data){
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        return gson.fromJson(data,(new TypeToken<Object[]>() {
        }).getType());
    }

    /** Set off fireworks*/
    public static void spawnFirework(Player player) {

        Level level = player.getLevel();
        ItemFirework item = new ItemFirework();
        CompoundTag tag = new CompoundTag();
        Random random = new Random();
        CompoundTag ex = new CompoundTag();
        ex.putByteArray("FireworkColor",new byte[]{
                (byte) DyeColor.values()[random.nextInt(ItemFirework.FireworkExplosion.ExplosionType.values().length)].getDyeData()
        });
        ex.putByteArray("FireworkFade",new byte[0]);
        ex.putBoolean("FireworkFlicker",random.nextBoolean());
        ex.putBoolean("FireworkTrail",random.nextBoolean());
        ex.putByte("FireworkType",ItemFirework.FireworkExplosion.ExplosionType.values()
                [random.nextInt(ItemFirework.FireworkExplosion.ExplosionType.values().length)].ordinal());
        tag.putCompound("Fireworks",(new CompoundTag("Fireworks")).putList(new ListTag<CompoundTag>("Explosions").add(ex)).putByte("Flight",1));
        item.setNamedTag(tag);
        CompoundTag nbt = new CompoundTag();
        nbt.putList(new ListTag<DoubleTag>("Pos")
                .add(new DoubleTag("",player.x+0.5D))
                .add(new DoubleTag("",player.y+0.5D))
                .add(new DoubleTag("",player.z+0.5D))
        );
        nbt.putList(new ListTag<DoubleTag>("Motion")
                .add(new DoubleTag("",0.0D))
                .add(new DoubleTag("",0.0D))
                .add(new DoubleTag("",0.0D))
        );
        nbt.putList(new ListTag<FloatTag>("Rotation")
                .add(new FloatTag("",0.0F))
                .add(new FloatTag("",0.0F))

        );
        nbt.putCompound("FireworkItem", NBTIO.putItemHelper(item));
        EntityFirework entity = new EntityFirework(level.getChunk((int)player.x >> 4, (int)player.z >> 4), nbt);
        entity.spawnToAll();
    }


    public static int compareVersion(String v1, String v2) {
        if (v1.equals(v2)) {
            return 0;
        }
        String[] version1Array = v1.split("[._]");
        String[] version2Array = v2.split("[._]");
        int index = 0;
        int minLen = Math.min(version1Array.length, version2Array.length);
        long diff = 0;

        while (index < minLen
                && (diff = Long.parseLong(version1Array[index])
                - Long.parseLong(version2Array[index])) == 0) {
            index++;
        }
        if (diff == 0) {
            for (int i = index; i < version1Array.length; i++) {
                if (Long.parseLong(version1Array[i]) > 0) {
                    return 1;
                }
            }

            for (int i = index; i < version2Array.length; i++) {
                if (Long.parseLong(version2Array[i]) > 0) {
                    return -1;
                }
            }
            return 0;
        } else {
            return diff > 0 ? 1 : -1;
        }
    }

    /**
     * String is UUID
     * Leaderboard
     * */
    public static HashMap<String,Integer> getPlayerRankingList(Map<String,Integer> map){
        HashMap<String,Integer> map1 = new LinkedHashMap<>();
        Comparator<Map.Entry<String, Integer>> valCmp = (o1, o2) -> {
            // TODO Auto-generated method stub
            return o2.getValue()-o1.getValue();
        };
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(valCmp);
        for(Map.Entry<String,Integer> ma:list){
            map1.put(ma.getKey(),ma.getValue());
        }
        return map1;
    }

    /** Get item quantity
     * @param player player
     * @param item item
     *
     * @return item quantity*/
    public static int getCount(Player player, ItemClass item){
        if(item instanceof ItemLib){
            return ((ItemLib) item).getPlayerAllItemCount(player);
        }
        int i = 0;
        for(Item playerItem:player.getInventory().getContents().values()){
            ItemClass itemClass = new ItemClass(playerItem);
            if(item != null){
                if(itemClass.equals(item)){
                    i += playerItem.getCount();
                }
            }
        }
        return i;
    }
    /**Get the points required for the difficulty */
    public static int starNeed(int star){
        Map map = (Map) RsTask.getTask().getConfig().get("Custom image path");
        if(map.containsKey(star+"")){
            Map map1 = (Map) map.get(star+"");
            return Integer.parseInt(map1.get("Unlock points").toString());
        }else{
            return 0;
        }
    }

    public static void sendMessage(Player player,String message){
        switch (RsTask.getTask().getConfig().getString("Bottom display type")){
            case "tip":
                player.sendTip(message);
                break;
            case "popup":
                player.sendPopup(message);
                break;
            default:
                player.sendActionBar(message);
                break;
        }
    }


    /** Convert difficulty to stars*/
    public static String getStar(int star){
        StringBuilder builder = new StringBuilder("");
        for(int i = 0;i < star;i++){
            builder.append(" ★ ");
        }
        return builder.toString();
    }

    /** Get group name*/
    public static String getGroupName(int group){
        Map map = (Map) RsTask.getTask().getConfig().get("Custom image path");
        if(map.containsKey(group+"")){
            return RsTask.getTask().getConfig().get("Custom image path."+group+"."+"name").toString();
        }
        return RsTask.getTask().getLag("title");
    }

    /** Get the scoreboard title*/
    public static String getScoreTitle(){
        Map map = (Map) RsTask.getTask().getConfig().get("scoreboard");
        return (String) map.get("title");
    }

    /** Create task */
    public static void createTask(TaskFile file){
        if(!TaskFile.isFileTask(file.getTaskName())){
            file.toSaveConfig();
            CreateTaskEvent event1 = new CreateTaskEvent(file);
            Server.getInstance().getPluginManager().callEvent(event1);
        }
    }

    public static boolean existsGroup(int group){
        Map map = (Map) RsTask.getTask().getConfig().get("Custom image path");
        return map.containsKey(group + "");
    }

    public static ArrayList<ItemLib> loadItemLib(Config config){
        ArrayList<ItemLib> itemLibs = new ArrayList<>();
        ItemLib lib;
        ArrayList<ItemClass> items;
        for(Map.Entry<String, Object> objectEntry : config.getAll().entrySet()){
            if(objectEntry.getValue() instanceof List){
                items = new ArrayList<>();
                for(Object msg: (List)objectEntry.getValue()){
                    ItemClass customItem = ItemClass.toItem(msg.toString());
                    if(customItem != null){
                        items.add(customItem);
                    }
                }
                lib = new ItemLib(objectEntry.getKey(),items);
                itemLibs.add(lib);
            }
        }
        return itemLibs;
    }


    public static void sortTaskFiles(LinkedList<TaskFile> files){
        files.sort((p1, p2) -> {
            //Sort in ascending order by Person's age
            if (p1.getName().compareTo(p2.getName()) == 0) {
                return 1;
            }
            return p1.getName().compareTo(p2.getName());
        });

    }



}
