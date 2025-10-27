package com.task.commands;

import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import cn.nukkit.item.Item;
import com.task.RsTask;
import com.task.utils.tasks.taskitems.ItemClass;
import com.task.commands.base.BaseCommand;

/**
 * Handheld item command
 * @author SmallasWater
 */
public class SaveItemCommand extends BaseCommand {

    public SaveItemCommand(String name) {
        super(name, "§dSave the item in hand to ItemTag");
        this.setPermission("RSTask.command.sh");
    }

    @Override
    public boolean hasPermission(CommandSender sender) {
        return sender.isPlayer() && sender.hasPermission(getPermission());
    }

    @Override
    public void sendHelp(CommandSender sender) {
        sender.sendMessage("§c=======================");
        sender.sendMessage("§e/sh <number (optional)> <quantity (optional)>");
        sender.sendMessage("§c=======================");
    }

    @Override
    public boolean execute(CommandSender sender, String s, String[] args) {
        if(sender instanceof Player){
            Item item = ((Player) sender).getInventory().getItemInHand();
            if(item.getId() == 0){
                sender.sendMessage("§cUnable to add air");
                return true;
            }
            ItemClass itemClass = new ItemClass(item);
            if(args.length < 1){
                String n = RsTask.getTask().saveTagItemsConfig(itemClass);
                sender.sendMessage("§eSuccessfully added "+n+" to TagItem.json");
            }else if(args.length < 2){
                RsTask.getTask().saveTagItemsConfig(itemClass,args[0]);
                sender.sendMessage("§eSuccessfully added "+args[0]+" to TagItem.json");
            }else{
                int count = Integer.parseInt(args[1]);
                itemClass.getItem().setCount(count);
                RsTask.getTask().saveTagItemsConfig(itemClass,args[0]);
                sender.sendMessage("§eSuccessfully added "+args[0]+" to quantity set to "+count+" TagItem.json");
            }
        }
        return true;
    }
}
