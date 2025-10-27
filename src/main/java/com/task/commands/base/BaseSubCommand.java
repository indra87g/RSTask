package com.task.commands.base;

import cn.nukkit.command.CommandSender;
import cn.nukkit.command.data.CommandParameter;


/**
 * Command utility class
 * @author SmallasWater
 *
 */
abstract public class BaseSubCommand {
    private String name;

    protected BaseSubCommand(String name) {
        this.name = name;
    }



    /**
     * @param sender CommandSender
     * @return boolean
     */
    protected boolean canUse(CommandSender sender){
        return sender.isPlayer();
    }


    /**
     * Get name
     * @return string
     */
    public String getName(){
        return name;
    }
    /**
     * Get alias
     * @return string[]
     */
    public abstract String[] getAliases();

    /**
     * Command response
     * @param sender the sender      - CommandSender
     * @param args   The arrugements      - String[]
     * @param label  label..
     * @return true if true
     */
    public abstract boolean execute(CommandSender sender, String label, String[] args);



    /**
     * Command parameters.
     * @return  Prompt parameters
     * */
    abstract public CommandParameter[] getParameters();

}
