package com.task.commands;


import cn.nukkit.command.CommandSender;
import com.task.commands.base.BaseCommand;
import com.task.commands.sub.AddAllTaskValueSubCommand;
import com.task.commands.sub.AddTaskValueSubCommand;
import com.task.commands.sub.SetAllTaskValueSubCommand;
import com.task.commands.sub.SetTaskValueSubCommand;


/**
 * Increase the main instruction of player task progress
 * @author 若水
 */
public class RunTaskCommand extends BaseCommand {
    public RunTaskCommand(String name) {
        super(name,"Increase task progress");
        this.setPermission("RSTask.command.sh");
        this.usageMessage = "/rtc help";
        this.addSubCommand(new AddTaskValueSubCommand("add"));
        this.addSubCommand(new SetTaskValueSubCommand("set"));
        this.addSubCommand(new AddAllTaskValueSubCommand("addall"));
        this.addSubCommand(new SetAllTaskValueSubCommand("setall"));
        loadCommandBase();
    }

    @Override
    public boolean hasPermission(CommandSender sender) {
        return sender.hasPermission(getPermission());
    }




    @Override
    public void sendHelp(CommandSender sender) {
        sender.sendMessage("/rtc add <player> <task name> <progress> <quantity> <prompt (false) optional>");
        sender.sendMessage("/rtc addall <player> <progress> <quantity> <prompt (false) optional>");
        sender.sendMessage("/rtc set <player> <progress> <quantity> <prompt (false) optional>");
        sender.sendMessage("/rtc setall <player> <progress> <quantity> <prompt (false) optional>");
        sender.sendMessage("ps: The collection type items cannot increase the progress");
    }
}
