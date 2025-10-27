package com.task.utils.tasks.taskitems;


/**
 * @author SmallasWater
 */
public class CommandClass {

    private String cmd;
    private String sendMessage;

    public CommandClass(String cmd){
        this(cmd,"Reward command");
    }

    public CommandClass(String cmd, String sendMessage){
        this.cmd = cmd;
        this.sendMessage = sendMessage;
    }

    /**
     * Get command
     * @return command*/
    public String getCmd() {
        return cmd;
    }

    /**
     * Get display information
     * @return command*/
    public String getSendMessage() {
        return sendMessage;
    }

    /**
     * Convert the command string to the command reward class
     *
    * @param defaultCmd The string passed in by the GUI
     * @return command reward{@link CommandClass}
    * */
    public static CommandClass toCommandClass(String defaultCmd){
        if(defaultCmd == null) {
            return null;
        }
        if(defaultCmd.split(":").length < 2) {
            return null;
        }
        return new CommandClass(defaultCmd.split(":")[0],defaultCmd.split(":")[1]);
    }

    @Override
    public String toString(){
        if(cmd.split(":").length > 1) {
            return cmd;
        }
        return cmd+":"+sendMessage;
    }
}
