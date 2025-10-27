package com.task.commands;

import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import com.task.form.CreateMenu;
import com.task.commands.base.BaseCommand;

/**
 * Task leaderboard main command
 * @author SmallasWater
 */
public class RankCommand extends BaseCommand {
    public RankCommand(String name) {
        super(name,"Task points leaderboard");
        this.setPermission("RSTask.command.rank");
        this.usageMessage = "/c-rank";
    }

    @Override
    public boolean hasPermission(CommandSender sender) {
        return sender.isPlayer() && sender.hasPermission(getPermission());
    }

    @Override
    public boolean execute(CommandSender commandSender, String s, String[] strings) {
        if (commandSender.isPlayer()) {
            CreateMenu.sendRankMenu((Player) commandSender);
        }else{
            commandSender.sendMessage("Please do not execute in the console");
        }
        return true;
    }

    @Override
    public void sendHelp(CommandSender sender) {}
}
