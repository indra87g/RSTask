package com.task.commands;

import cn.nukkit.command.CommandSender;
import com.task.commands.base.BaseCommand;
import com.task.commands.sub.BookGiveSubCommand;
import com.task.commands.sub.BookUpSubCommand;


/**
 * Book main command
 * @author SmallasWater
 */
public class BookCommand extends BaseCommand {
    public BookCommand(String name) {
        super(name, "§aGet the task book by command");
        this.addSubCommand(new BookUpSubCommand("up"));
        this.addSubCommand(new BookGiveSubCommand("give"));
        this.loadCommandBase();
    }

    @Override
    public boolean execute(CommandSender sender, String s, String[] args) {
        if(args.length > 0) {
           super.execute(sender, s, args);
        }else{
            sendHelp(sender);
        }

        return true;
    }

    @Override
    public boolean hasPermission(CommandSender sender) {
        return sender.isPlayer();
    }

    @Override
    public void sendHelp(CommandSender sender) {
        sender.sendMessage("§c=======================");
        sender.sendMessage("§e/cbook give <task name> Get the task book for this task");
        sender.sendMessage("§e/cbook up Update the task book in your hand");
        sender.sendMessage("§c=======================");
    }
}
