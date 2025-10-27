package com.task;


import cn.nukkit.Player;
import cn.nukkit.Server;

import cn.nukkit.level.Level;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;
import cn.nukkit.utils.TextFormat;
import com.task.commands.*;
import com.task.items.ItemLib;
import com.task.utils.task.AutoSaveFileTask;
import com.task.utils.task.ChunkPlayerInventoryBookTask;
import com.task.utils.task.ChunkTaskTask;
import com.task.utils.tasks.TaskFile;
import com.task.utils.tasks.taskitems.TaskItem;
import com.task.utils.DataTool;
import com.task.utils.LoadMoney;
import com.task.utils.task.ListerEvents;
import com.task.utils.tasks.taskitems.ItemClass;
import com.task.utils.tasks.PlayerFile;
import com.task.form.ListenerMenu;
import org.jline.utils.Log;
import updata.AutoData;

import java.io.File;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * @author SmallasWater
 */
public class RsTask extends PluginBase{

    private static final String CONFIG_VERSION = "1.5.4";
    private static RsTask task;

    public static LinkedList<String> taskNames = new LinkedList<>();

    public static LinkedHashMap<Player,Integer> getClickStar = new LinkedHashMap<>();

    public LinkedHashMap<Player, TaskFile> getClickTask = new LinkedHashMap<>();

    public LinkedHashMap<String,TaskFile> tasks = new LinkedHashMap<>();



    public LinkedHashMap<String, PlayerFile> playerFiles = new LinkedHashMap<>();

    public static boolean loadEconomy = false;

    private LoadMoney loadMoney;

    public static boolean countChecking = true;

    private static boolean showCount = true;

    public static boolean showLoading = true;

    private static boolean showBack = true;

    private static boolean runC = true;

    public static boolean canGiveBook = true;

    public static boolean canSuccess = false;

    public int count = 10;

    private LinkedHashMap<String, Config> playerConfig = new LinkedHashMap<>();

    public LinkedHashMap<String, Config> taskConfig = new LinkedHashMap<>();

    private Config lag;

    private Config tagItem;

    public static ExecutorService executor = Executors.newCachedThreadPool();



    private String[] defaultFirstName = new String[]{
            "a","b","c","d","e","f","g","h",
            "i","j","k", "l","m","n","o","p","q",
            "r","s","t","u","v","w","x","y","z","0","1","2",
            "3","4","5","6","7","8","9","#"
    };



    @Override
    public void onEnable() {
        task = this;
        this.getLogger().info("[RSTask] Starting task system plugin");

        if(Server.getInstance().getPluginManager().getPlugin("AutoUpData") != null){
            if(AutoData.defaultUpData(this,getFile(),"SmallasWater","RSTask")){
                return;
            }
        }

        this.getServer().getPluginManager().registerEvents(new ListenerMenu(),this);
        this.getServer().getPluginManager().registerEvents(new ListerEvents(),this);

        loadItem();
        loadTask();
        registerCommand();
        if(countChecking) {
            this.getServer().getCommandMap().register("superTask", new RankCommand("c-rank"));
        }
        executor.execute(new ChunkTaskTask(this));
        executor.execute(new ChunkPlayerInventoryBookTask(this));
        if(getConfig().getBoolean("auto-save-task.open")){
            executor.execute(new AutoSaveFileTask(this));
        }
        Server.getInstance().getScheduler().scheduleDelayedTask(this, () -> {
            RsTask.getTask().getLogger().info("This plugin is a free and open source plugin");
            RsTask.getTask().getLogger().info("GitHub: https://github.com/SmallasWater/RSTask");
        },20);

    }



    private void init(){

        count = getConfig().getInt("Number of players displayed on the leaderboard",10);

        countChecking = getConfig().getBoolean("Enable score verification");

        showCount = getConfig().getBoolean("Display quantity on the main page",true);

        showLoading = getConfig().getBoolean("Display task progress at the bottom");

        showBack = getConfig().getBoolean("Add a return button to the task interface");

        runC = getConfig().getBoolean("Allow players to execute c commands",true);

        canGiveBook = getConfig().getBoolean("Give a task book when receiving a task",true);

        canSuccess = getConfig().getBoolean("Receive rewards directly after completing a task",true);

        playerFiles = new LinkedHashMap<>();
//        for(String playerName:getPlayerNames()){
//            playerFiles.put(playerName, PlayerFile.getPlayerFile(playerName));
//        }
    }

    public void loadItem(){
        this.saveResource("ItemLib.yml",false);
        ItemLib.ItemLibs = DataTool.loadItemLib(new Config(this.getDataFolder()+"/ItemLib.yml",Config.YAML));


    }

    private void registerCommand(){
        this.getServer().getCommandMap().register("cbook",new BookCommand("cbook"));
        if(canRunC()) {
            this.getServer().getCommandMap().register("c", new OpenTaskCommand("c"));
        }
        if(canRunCList()) {
            this.getServer().getCommandMap().register("c-list", new OpenTaskRunningCommand("c-list"));
        }
        if(countChecking) {
            this.getServer().getCommandMap().register("c-rank", new RankCommand("c-rank"));
        }
        this.getServer().getCommandMap().register("rtc", new RunTaskCommand("rtc"));
        this.getServer().getCommandMap().register("sh", new SaveItemCommand("sh"));
        this.getServer().getCommandMap().register("t-task", new TaskCommand("task"));
    }


    public static RsTask getTask() {
        return task;
    }

    private boolean canRunCList(){
        return getConfig().getBoolean("Allow players to execute the c-list command",true);
    }

    /**Check if the number exists*/
    public boolean canExistsNumber(String number){
        Config config = getTagItem();
        return (config.get(number) != null);
    }

    private Config getTagItem() {
        if(tagItem == null){
            tagItem = new Config(this.getDataFolder()+"/TagItem.json",Config.JSON);
        }
        return tagItem;
    }

    /** Get ItemClass by number*/
    public ItemClass getTagItemsConfig(String number){
        if(canExistsNumber(number)){
            Config config = getTagItem();
            return ItemClass.toItem(config.getString(number));
        }
        return null;

    }




    /**Check if it exists*/
    public boolean canExisteItemClass(ItemClass itemClass){
        Config config = getTagItem();
        LinkedHashMap<String,Object> map = (LinkedHashMap<String, Object>) config.getAll();
        for(String string:map.keySet()){
            String c = (String) map.get(string);
            ItemClass itemClass1 = ItemClass.toItem(c);
            if(itemClass1 != null){
                return itemClass1.equals(itemClass);
            }
        }
        return false;
    }

    public String saveTagItemsConfig(ItemClass itemClass){
        int id = new Random().nextInt(100000)+100;
        int s;
        Config config = getTagItem();
        LinkedHashMap<String,Object> map = (LinkedHashMap<String, Object>) config.getAll();
        for(String string:map.keySet()){
            String c = (String) map.get(string);
            if(c.equals(itemClass.toString())) {
                return string;
            }
        }
        if(config.get(id+"") == null){
            s = id;
            config.set(s+"",itemClass.toString());
        }else{
            for(;;){
                id = new Random().nextInt(100000)+100;
                if(config.get(id+"") == null){
                    s = id;
                    config.set(s+"",itemClass.toString());
                    break;
                }
            }
        }
        config.save();
        return s+"";
    }

    public int getCount() {
        return count;
    }

    /**Get all players*/
    public LinkedList<String> getPlayerNames(){
        LinkedList<String> linkedList = new LinkedList<>();
        LinkedList<String> playerNames = new LinkedList<>();
        File dir = new File(this.getDataFolder()+"/Players");
        if(dir.exists()){
            List<String> list = getAllFiles(dir,linkedList);
            for(String names:list){
                File file = new File(names);
                int dot = file.getName().lastIndexOf('.');
                if ((dot >-1) && (dot < (file.getName().length()))) {
                    playerNames.add(file.getName().substring(0, dot));
                }

            }
        }
        return playerNames;
    }


    private static List<String> getAllFiles(File dir, List<String> filelist){
        File[] fs = dir.listFiles();
        if(fs != null){
            for (File f : fs) {
                if (f.getAbsolutePath().matches(".*\\.yml$")) {
                    filelist.add(f.getAbsolutePath());
                }
                if (f.isDirectory()) {
                    try {
                        getAllFiles(f, filelist);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return filelist;
    }


    /**Get the number to save the NbtItem*/
    public void saveTagItemsConfig(ItemClass itemClass, String tag){
        Config config = getTagItem();
        config.set(tag,itemClass.toString());
        config.save();


    }

    public String getLag(String value){
        return lag.getString(value);
    }


    public String getLag(String value,String defaultString){
        return lag.getString(value,defaultString);
    }

    /**Get coin name*/
    public String getCoinName(){
        return getConfig().getString("Coin name","§eGold coin§r");
    }

    /**Get score name*/
    public String getFName(){
        return getConfig().getString("Score name","§bPoints§r");
    }

    /**Get score name*/
    public boolean canShowLodding(){
        return showCount;
    }



    /**Check if the world independent task is enabled
     * @deprecated None
     * */

    public boolean isWorldAloneTask(){
        return getConfig().getBoolean("Enable world independent tasks",false);
    }

    /**If it is enabled, initialize the folder
     * @deprecated */
    public void initWorlds(){
        for(Level level:Server.getInstance().getLevels().values()){
            if(!new File(this.getDataFolder()+"/Worlds").exists()){
                if(new File(this.getDataFolder()+"/Worlds").mkdir()){
                    this.getLogger().info("Worlds folder created successfully");
                }else{
                    this.getLogger().info("Failed to create Worlds folder");
                }
            }
            if(!new File(this.getDataFolder()+"/Worlds/"+level.getFolderName()).exists()){
                if(new File(this.getDataFolder()+"/Worlds/"+level.getFolderName()).mkdir()){
                    this.getLogger().info("Worlds/"+level.getFolderName()+" folder created successfully");
                }else{
                    this.getLogger().info("Worlds/"+level.getFolderName()+" folder creation failed");
                }
            }
            for(String i: defaultFirstName){
                File file = new File(this.getDataFolder()+"/Worlds/"+level.getFolderName()+"/Players/"+i);
                if(!file.exists()){
                    if(!file.mkdirs()) {
                        Log.error("Player file initialization failed");
                    }
                }
            }
            this.getLogger().info("Worlds/"+level.getFolderName()+"/Players/ folder created successfully");
        }
    }


    public Config getTaskConfig(String taskName){
        if(TaskFile.isFileTask(taskName)){
            if(taskConfig.containsKey(taskName)) {
                return taskConfig.get(taskName);
            }
            return new Config(this.getDataFolder()+"/Tasks/"+taskName+".yml",Config.YAML);
        }
        return null;
    }


    public Config getPlayerConfig(String playerName){
        if(!getPlayerFile(playerName).exists()){
            saveResource("player",getPlayerFileName(playerName),false);
        }
        if(!playerConfig.containsKey(playerName)){
            playerConfig.put(playerName,new Config(this.getDataFolder()+getPlayerFileName(playerName)));
        }
        return playerConfig.get(playerName);
    }

    public File getPlayerFile(String playerName){
        return new File(this.getDataFolder()+getPlayerFileName(playerName));
    }


    private String getPlayerFileName(String player){
        for(String i: defaultFirstName)
        {
            if(i.equals(player.substring(0,1).toLowerCase())){
                return "/Players/"+i+"/"+player+".yml";
            }
        }
        return "/Players/#/"+player+".yml";
    }




    /**
     *Get task progress percentage
     */
    public double getTaskLoading(String taskName,String player){
        PlayerFile playerFiles = PlayerFile.getPlayerFile(player);
        TaskFile file = TaskFile.getTask(taskName);
        if(file != null){
            if(playerFiles.issetTask(file.getTaskName())){
                double count = playerFiles.getTaskItems(file.getTaskName()).length;
                double math = 0.0D;
                for(TaskItem item:playerFiles.getTaskItems(file.getTaskName())){
                    if(item != null){
                        double fileCount = file.getCountByTaskItem(item);
                        double playerCount = item.getEndCount();
                        if(playerCount > 0){
                            if(playerCount > fileCount){
                                playerCount = fileCount;
                            }
                            double con =  playerCount / fileCount;
                            if(con != 0) {
                                math += ((con /  count) * 100);
                            }
                        }
                    }
                }
                return math;
            }
        }

        return 0.0D;
    }
    /**Enable score limit*/
    public static boolean canOpen(){
        return countChecking;
    }

    private static boolean canUseEconomyAPI(){
        return RsTask.getTask().getConfig().getBoolean("enable-Economy");
    }


    /**Show back button*/
    public static boolean canBack(){
        return showBack;
    }




    private boolean canRunC(){
        return runC;
    }



    public void loadTask() {
        taskConfig = new LinkedHashMap<>();
        File taskFiles = new File(this.getDataFolder() + "/Tasks");
        if (!taskFiles.exists()) {
            if (!taskFiles.mkdirs()) {
                Log.error("Failed to create Tasks folder");
            }
        }
        File fileE = new File(RsTask.getTask().getDataFolder() + "/Tasks");
        File[] files = fileE.listFiles();
        if (files != null) {
            Arrays.sort(files);
            for (File file1 : files) {
                if (file1.isFile()) {
                    String names = file1.getName().substring(0, file1.getName().lastIndexOf("."));
                    taskConfig.put(names, new Config(this.getDataFolder() + "/Tasks/" + names + ".yml", Config.YAML));
                }
            }
        }
        tasks = TaskFile.getTasks();
        for (String i : defaultFirstName) {
            File file = new File(this.getDataFolder() + "/Players/" + i);
            if (!file.exists()) {
                if (!file.mkdirs()) {
                    Log.error("Player file initialization failed");
                }
            }
        }
        playerConfig = new LinkedHashMap<>();
        for (String playerName : getPlayerNames()) {
            playerConfig.put(playerName, new Config(getDataFolder() + getPlayerFileName(playerName)));

        }
        saveDefaultConfig();
        reloadConfig();
        chunkConfigVersion();
        if(!new File(this.getDataFolder()+"/language.properties").exists()){
            this.saveResource("language.properties",false);
        }
        lag = new Config(this.getDataFolder()+"/language.properties",Config.PROPERTIES);
        chunkLanguageVersion();
        if(canUseEconomyAPI()){
            getLogger().info("Checking the economic system....");
            loadEconomy();
            if(loadMoney.getMoney() == -1){
                getLogger().info("No economic core detected");
            }else{
                loadEconomy = true;
            }
        }

        init();
    }
    private void chunkLanguageVersion(){
        String v1 = lag.get("version","1.0.0");
        int ver = DataTool.compareVersion(CONFIG_VERSION,v1);
        if(ver == 1 || ver == -1) {
            this.getLogger().info("A new version of the language file is detected and is being updated...");
            File file = new File(this.getDataFolder() + "/language.properties");
            if (file.delete()) {
                this.saveResource("language.properties",false);
                lag = new Config(this.getDataFolder()+"/language.properties",Config.PROPERTIES);
                this.getLogger().info("The configuration file has been updated. Current language file version: " + CONFIG_VERSION);
            } else {
                this.getLogger().warning("Failed to delete the configuration file. Please delete it manually");
            }
        }

    }

    private void chunkConfigVersion(){
        if(!new File(this.getDataFolder()+"/config.yml").exists()){
            this.saveDefaultConfig();
            this.reloadConfig();
        }else{
            String v1 = getConfig().get("version","1.0.0");
            int ver = DataTool.compareVersion(CONFIG_VERSION,v1);
            if(ver == 1 || ver == -1){
                this.getLogger().info("A new version of the configuration file is detected and is being updated...");
                File file = new File(this.getDataFolder()+"/config.yml");
                if(file.delete()){
                    this.saveDefaultConfig();
                    this.reloadConfig();
                    this.getLogger().info("The configuration file has been updated. Current configuration version: "+CONFIG_VERSION);
                }else{
                    this.getLogger().warning("Failed to delete the configuration file. Please delete it manually");
                }
            }

        }

    }

    public int getGroupSize(){
        Map map = (Map) RsTask.getTask().getConfig().get("Custom image path");
        return map.size();
    }

    public LinkedHashMap<String, TaskFile> getTasks() {
        return tasks;
    }

    public LoadMoney getLoadMoney() {
        return loadMoney;
    }

    private void loadEconomy(){
        loadMoney = new LoadMoney();
        String economy = getConfig().getString("Use economic core","default");
        if(loadMoney.getMoney() != -1) {
            if ("default".equalsIgnoreCase(economy)) {
                getLogger().info("Task system economic core has been enabled:" + TextFormat.GREEN + " Auto");
            }
            if ("money".equalsIgnoreCase(economy)) {
                loadMoney.setMoney(LoadMoney.MONEY);
                getLogger().info("Task system economic core has been enabled:" + TextFormat.GREEN + " Money");
            }
            if ("playerpoint".equalsIgnoreCase(economy)) {
                loadMoney.setMoney(LoadMoney.PLAYER_POINT);
                getLogger().info("Task system economic core has been enabled:" + TextFormat.GREEN + " PlayerPoints");
            } else {
                loadMoney.setMoney(LoadMoney.ECONOMY_API);
                getLogger().info("Task system economic core has been enabled:" + TextFormat.GREEN + " EconomyAPI");
            }
        }

    }

    @Override
    public void onDisable() {
        for(TaskFile file:tasks.values()){
            file.toSaveConfig();
        }
        for(PlayerFile player:playerFiles.values()){
            player.toSave();
        }

    }
}
