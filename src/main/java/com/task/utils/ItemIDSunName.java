package com.task.utils;


import cn.nukkit.item.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Winfxk
 * @author Anders233
 *
 */
public enum ItemIDSunName {
    /**
     * Stone
     */
    STONE("Stone", 1, 0, "textures/blocks/stone.png"),
    /**
     * Granite
     */
    STONE_GRANITE("Granite", 1, 1, "textures/blocks/stone_granite.png"),
    /**
     * Polished Granite
     */
    STONE_GRANITE_SMOOTH("Polished Granite", 1, 2, "textures/blocks/stone_granite_smooth.png"),
    /**
     * Diorite
     */
    STONE_DIORITE("Diorite", 1, 3, "textures/blocks/stone_diorite.png"),
    /**
     * Polished Diorite
     */
    STONE_DIORITE_SMOOTH("Polished Diorite", 1, 4, "textures/blocks/stone_diorite_smooth.png"),
    /**
     * Andesite
     */
    STONE_ANDESITE("Andesite", 1, 5, "textures/blocks/stone_andesite.png"),
    /**
     * Polished Andesite
     */
    STONE_ANDESITE_SMOOTH("Polished Andesite", 1, 6, "textures/blocks/stone_andesite_smooth.png"),
    /**
     * Grass Block
     */
    GRASS("Grass Block", 2, 0, "textures/blocks/grass_side_carried.png"),
    /**
     * Dirt
     */
    DIRT("Dirt", 3, 0, "textures/blocks/dirt.png"),
    /**
     * Cobblestone
     */
    COBBLESTONE("Cobblestone", 4, 0, "textures/blocks/cobblestone.png"),
    /**
     * Oak Wood Planks
     */
    PLANKS("Oak Wood Planks", 5, 0, "textures/blocks/planks_oak.png"),
    /**
     * Spruce Wood Planks
     */
    PLANKS_SPRUCE("Spruce Wood Planks", 5, 1, "textures/blocks/planks_spruce.png"),
    /**
     * Birch Wood Planks
     */
    PLANKS_BIRCH("Birch Wood Planks", 5, 2, "textures/blocks/planks_birch.png"),
    /**
     * Jungle Wood Planks
     */
    PLANKS_JUNGLE("Jungle Wood Planks", 5, 3, "textures/blocks/planks_jungle.png"),
    /**
     * Acacia Wood Planks
     */
    PLANKS_ACACIA("Acacia Wood Planks", 5, 4, "textures/blocks/planks_acacia.png"),
    /**
     * Dark Oak Wood Planks
     */
    PLANKS_BIG_OAK("Dark Oak Wood Planks", 5, 5, "textures/blocks/planks_big_oak.png"),
    /**
     * Oak Sapling
     */
    SAPLING("Oak Sapling", 6, 0, "textures/blocks/sapling_oak.png"),
    /**
     * Spruce Sapling
     */
    SAPLING_SPRUCE("Spruce Sapling", 6, 1, "textures/blocks/sapling_spruce.png"),
    /**
     * Birch Sapling
     */
    SAPLING_BIRCH("Birch Sapling", 6, 2, "textures/blocks/sapling_birch.png"),
    /**
     * Jungle Sapling
     */
    SAPLING_JUNGLE("Jungle Sapling", 6, 3, "textures/blocks/sapling_jungle.png"),
    /**
     * Acacia Sapling
     */
    SAPLING_ACACIA("Acacia Sapling", 6, 4, "textures/blocks/sapling_acacia.png"),
    /**
     * Dark Oak Sapling
     */
    SAPLING_ROOFED_OAK("Dark Oak Sapling", 6, 5, "textures/blocks/sapling_roofed_oak.png"),
    /**
     * Bedrock
     */
    BEDROCK("Bedrock", 7, 0, "textures/blocks/bedrock.png"),
    /**
     * Flowing Water
     */
    FLOWING_WATER("Flowing Water", 8, 0, "textures/blocks/water_placeholder.png"),
    /**
     * Water
     */
    WATER("Water", 9, 0, "textures/blocks/water_placeholder.png"),
    /**
     * Flowing Lava
     */
    FLOWING_LAVA("Flowing Lava", 10, 0, "textures/blocks/lava_placeholder.png"),
    /**
     * Lava
     */
    LAVA("Lava", 11, 0, "textures/blocks/lava_placeholder.png"),
    /**
     * Sand
     */
    SAND("Sand", 12, 0, "textures/blocks/sand.png"),
    /**
     * Red Sand
     */
    RED_SAND("Red Sand", 12, 1, "textures/blocks/red_sand.png"),
    /**
     * Gravel
     */
    GRAVEL("Gravel", 13, 0, "textures/blocks/gravel.png"),
    /**
     * Gold Ore
     */
    GOLD_ORE("Gold Ore", 14, 0, "textures/blocks/gold_ore.png"),
    /**
     * Iron Ore
     */
    IRON_ORE("Iron Ore", 15, 0, "textures/blocks/iron_ore.png"),
    /**
     * Coal Ore
     */
    COAL_ORE("Coal Ore", 16, 0, "textures/blocks/coal_ore.png"),
    /**
     * Oak Wood
     */
    LOG("Oak Wood", 17, 0, "textures/blocks/log_oak.png"),
    /**
     * Spruce Wood
     */
    LOG_SPRUCE("Spruce Wood", 17, 1, "textures/blocks/log_spruce.png"),
    /**
     * Birch Wood
     */
    LOG_BIRCH("Birch Wood", 17, 2, "textures/blocks/log_birch.png"),
    /**
     * Jungle Wood
     */
    LOG_JUNGLE("Jungle Wood", 17, 3, "textures/blocks/log_jungle.png"),
    /**
     * Oak Leaves
     */
    LEAVES("Oak Leaves", 18, 0, "textures/blocks/leaves_oak_carried.tga"),
    /**
     * Spruce Leaves
     */
    LEAVES_SPRUCE_CARRIED("Spruce Leaves", 18, 1, "textures/blocks/leaves_spruce_carried.tga"),
    /**
     * Birch Leaves
     */
    LEAVES_BIRCH_CARRIED("Birch Leaves", 18, 2, "textures/blocks/leaves_birch_carried.tga"),
    /**
     * Jungle Leaves
     */
    LEAVES_JUNGLE_CARRIED("Jungle Leaves", 18, 3, "textures/blocks/leaves_jungle_carried.tga"),
    /**
     * Dry Sponge
     */
    SPONGE("Dry Sponge", 19, 0, "textures/blocks/sponge.png"),
    /**
     * Wet Sponge
     */
    SPONGE_WET("Wet Sponge", 19, 1, "textures/blocks/sponge_wet.png"),
    /**
     * Glass
     */
    GLASS("Glass", 20, 0, "textures/blocks/glass.png"),
    /**
     * Lapis Lazuli Ore
     */
    LAPIS_ORE("Lapis Lazuli Ore", 21, 0, "textures/blocks/lapis_ore.png"),
    /**
     * Lapis Lazuli Block
     */
    LAPIS_BLOCK("Lapis Lazuli Block", 22, 0, "textures/blocks/lapis_block.png"),
    /**
     * Dispenser
     */
    DISPENSER("Dispenser", 23, 0, "textures/blocks/dispenser_front_horizontal.png"),
    /**
     * Sandstone
     */
    SANDSTONE("Sandstone", 24, 0, "textures/blocks/sandstone_normal.png"),
    /**
     * Chiseled Sandstone
     */
    SANDSTONE_CARVED("Chiseled Sandstone", 24, 1, "textures/blocks/sandstone_carved.png"),
    /**
     * Smooth Sandstone
     */
    SANDSTONE_SMOOTH("Smooth Sandstone", 24, 2, "textures/blocks/sandstone_smooth.png"),
    /**
     * Note Block
     */
    NOTEBLOCK("Note Block", 25, 0, "textures/blocks/noteblock.png"),
    /**
     * Bed Block
     */
    BED_BLOCK("Bed Block", 26, 0, "textures/blocks/bed_head_top.png"),
    /**
     * Powered Rail
     */
    GOLDEN_RAIL("Powered Rail", 27, 0, "textures/blocks/rail_golden.png"),
    /**
     * Detector Rail
     */
    DETECTOR_RAIL("Detector Rail", 28, 0, "textures/blocks/rail_detector.png"),
    /**
     * Sticky Piston
     */
    STICKY_PISTON("Sticky Piston", 29, 0, "textures/blocks/piston_top_sticky.png"),
    /**
     * Cobweb
     */
    WEB("Cobweb", 30, 0, "textures/blocks/web.png"),
    /**
     * Tall Grass
     */
    TALLGRASS("Tall Grass", 31, 0, "textures/blocks/deadbush.png"),
    /**
     * Grass
     */
    TALLGRASS_CARRIED("Grass", 31, 1, "textures/blocks/tallgrass_carried.tga"),
    /**
     * Fern
     */
    FERN_CARRIED("Fern", 31, 2, "textures/blocks/fern_carried.tga"),
    /**
     * Dead Bush
     */
    DEADBUSH("Dead Bush", 32, 0, "textures/blocks/deadbush.png"),
    /**
     * Piston
     */
    PISTON("Piston", 33, 0, "textures/blocks/piston_top_normal.png"),
    /**
     * Piston Head
     */
    PISTON_HEAD("Piston Head", 34, 0, "textures/blocks/piston_top_normal.png"),
    /**
     * White Wool
     */
    WOOL("White Wool", 35, 0, "textures/blocks/wool_colored_white.png"),
    /**
     * Orange Wool
     */
    WOOL_COLORED_ORANGE("Orange Wool", 35, 1, "textures/blocks/wool_colored_orange.png"),
    /**
     * Magenta Wool
     */
    WOOL_COLORED_MAGENTA("Magenta Wool", 35, 2, "textures/blocks/wool_colored_magenta.png"),
    /**
     * Light Blue Wool
     */
    WOOL_COLORED_LIGHT_BLUE("Light Blue Wool", 35, 3, "textures/blocks/wool_colored_light_blue.png"),
    /**
     * Yellow Wool
     */
    WOOL_COLORED_YELLOW("Yellow Wool", 35, 4, "textures/blocks/wool_colored_yellow.png"),
    /**
     * Lime Wool
     */
    WOOL_COLORED_LIME("Lime Wool", 35, 5, "textures/blocks/wool_colored_lime.png"),
    /**
     * Pink Wool
     */
    WOOL_COLORED_PINK("Pink Wool", 35, 6, "textures/blocks/wool_colored_pink.png"),
    /**
     * Gray Wool
     */
    WOOL_COLORED_GRAY("Gray Wool", 35, 7, "textures/blocks/wool_colored_gray.png"),
    /**
     * Light Gray Wool
     */
    WOOL_COLORED_SILVER("Light Gray Wool", 35, 8, "textures/blocks/wool_colored_silver.png"),
    /**
     * Cyan Wool
     */
    WOOL_COLORED_CYAN("Cyan Wool", 35, 9, "textures/blocks/wool_colored_cyan.png"),
    /**
     * Purple Wool
     */
    WOOL_COLORED_PURPLE("Purple Wool", 35, 10, "textures/blocks/wool_colored_purple.png"),
    /**
     * Blue Wool
     */
    WOOL_COLORED_BLUE("Blue Wool", 35, 11, "textures/blocks/wool_colored_blue.png"),
    /**
     * Brown Wool
     */
    WOOL_COLORED_BROWN("Brown Wool", 35, 12, "textures/blocks/wool_colored_brown.png"),
    /**
     * Green Wool
     */
    WOOL_COLORED_GREEN("Green Wool", 35, 13, "textures/blocks/wool_colored_green.png"),
    /**
     * Red Wool
     */
    WOOL_COLORED_RED("Red Wool", 35, 14, "textures/blocks/wool_colored_red.png"),
    /**
     * Black Wool
     */
    WOOL_COLORED_BLACK("Black Wool", 35, 15, "textures/blocks/wool_colored_black.png"),
    /**
     * Dandelion
     */
    YELLOW_FLOWER("Dandelion", 37, 0, "textures/blocks/glazed_terracotta_yellow.png"),
    /**
     * Poppy
     */
    RED_FLOWER("Poppy", 38, 0, "textures/blocks/flower_rose.png"),
    /**
     * Blue Orchid
     */
    FLOWER_BLUE_ORCHID("Blue Orchid", 38, 1, "textures/blocks/flower_blue_orchid.png"),
    /**
     * Allium
     */
    FLOWER_ALLIUM("Allium", 38, 2, "textures/blocks/flower_allium.png"),
    /**
     * Azure Bluet
     */
    FLOWER_HOUSTONIA("Azure Bluet", 38, 3, "textures/blocks/flower_houstonia.png"),
    /**
     * Red Tulip
     */
    FLOWER_TULIP_RED("Red Tulip", 38, 4, "textures/blocks/flower_tulip_red.png"),
    /**
     * Orange Tulip
     */
    FLOWER_TULIP_ORANGE("Orange Tulip", 38, 5, "textures/blocks/flower_tulip_orange.png"),
    /**
     * White Tulip
     */
    FLOWER_TULIP_WHITE("White Tulip", 38, 6, "textures/blocks/flower_tulip_white.png"),
    /**
     * Pink Tulip
     */
    FLOWER_TULIP_PINK("Pink Tulip", 38, 7, "textures/blocks/flower_tulip_pink.png"),
    /**
     * Oxeye Daisy
     */
    FLOWER_OXEYE_DAISY("Oxeye Daisy", 38, 8, "textures/blocks/flower_oxeye_daisy.png"),
    /**
     * Brown Mushroom
     */
    BROWN_MUSHROOM("Brown Mushroom", 39, 0, "textures/blocks/mushroom_brown.png"),
    /**
     * Red Mushroom
     */
    RED_MUSHROOM("Red Mushroom", 40, 0, "textures/blocks/mushroom_red.png"),
    /**
     * Gold Block
     */
    GOLD_BLOCK("Gold Block", 41, 0, "textures/blocks/gold_block.png"),
    /**
     * Iron Block
     */
    IRON_BLOCK("Iron Block", 42, 0, "textures/blocks/iron_block.png"),
    /**
     * Double Stone Slab
     */
    DOUBLE_STONE_SLAB("Double Stone Slab", 43, 0, "textures/blocks/stone_slab_side.png"),
    /**
     * Double Sandstone Slab
     */
    SANDSTONE_BOTTOM("Double Sandstone Slab", 43, 1, "textures/blocks/sandstone_bottom.png"),
    /**
     * Double Oak Wood Slab
     */
    PLANKS_OAK("Double Oak Wood Slab", 43, 2, "textures/blocks/planks_oak.png"),
    /**
     * Double Cobblestone Slab
     */
    DOUBLE_PEBBLE_STEPS("Double Cobblestone Slab", 43, 3, "textures/blocks/cobblestone.png"),
    /**
     * Double Brick Slab
     */
    DOUBLE_BRICK_STEPS("Double Brick Slab", 43, 4, "textures/blocks/brick.png"),
    /**
     * Double Stone Brick Slab
     */
    DOUBLE_STONE_BRICK_STEPS("Double Stone Brick Slab", 43, 5, "textures/blocks/stonebrick.png"),
    /**
     * Double Quartz Slab
     */
    DOUBLE_QUARTZ_STEPS("Double Quartz Slab", 43, 6, "textures/blocks/nether_brick.png"),
    /**
     * Double Nether Brick Slab
     */
    DOUBLE_HELL_BRICK_STEPS("Double Nether Brick Slab", 43, 7, "textures/blocks/quartz_block_top.png"),
    /**
     * Stone Slab
     */
    STONE_SLAB("Stone Slab", 44, 0, "textures/blocks/stone_slab_top.png"),
    /**
     * Sandstone Slab
     */
    SANDSTONE_TOP("Sandstone Slab", 44, 1, "textures/blocks/sandstone_top.png"),
    /**
     * Cobblestone Slab
     */
    COBBLESTONE_STEPS("Cobblestone Slab", 44, 3, "textures/blocks/cobblestone.png"),
    /**
     * Brick Slab
     */
    BRICK_STEPS("Brick Slab", 44, 4, "textures/blocks/brick.png"),
    /**
     * Stone Brick Slab
     */
    STONEBRICK_STEPS("Stone Brick Slab", 44, 5, "textures/blocks/stonebrick.png"),
    /**
     * Quartz Slab
     */
    NETHER_BRICK_STEPS("Quartz Slab", 44, 6, "textures/blocks/nether_brick.png"),
    /**
     * Nether Brick Slab
     */
    QUARTZ_BLOCK_TOP_STEPS("Nether Brick Slab", 44, 7, "textures/blocks/quartz_block_top.png"),
    /**
     * Brick
     */
    BRICK("Brick", 336, 0, "textures/blocks/brick.png"),
    /**
     * TNT
     */
    TNT("TNT", 46, 0, "textures/blocks/tnt_side.png"),
    /**
     * Bookshelf
     */
    BOOKSHELF("Bookshelf", 47, 0, "textures/blocks/bookshelf.png"),
    /**
     * Mossy Cobblestone
     */
    MOSSY_COBBLESTONE("Mossy Cobblestone", 48, 0, "textures/blocks/cobblestone_mossy.png"),
    /**
     * Obsidian
     */
    OBSIDIAN("Obsidian", 49, 0, "textures/blocks/obsidian.png"),
    /**
     * Torch
     */
    TORCH("Torch", 50, 0, "textures/blocks/torch_on.png"),
    /**
     * Fire
     */
    FIRE("Fire", 51, 0, "textures/blocks/fire_0_placeholder.png"),
    /**
     * Monster Spawner
     */
    MOB_SPAWNER("Monster Spawner", 52, 0, "textures/blocks/mob_spawner.png"),
    /**
     * Oak Stairs
     */
    OAK_STAIRS("Oak Stairs", 53, 0, "textures/blocks/planks_oak.png"),
    /**
     * Chest
     */
    CHEST("Chest", 54, 0, "textures/blocks/chest_front.png"),
    /**
     * Redstone Wire
     */
    REDSTONE_WIRE("Redstone Wire", 55, 0, "textures/blocks/redstone_dust_line.png"),
    /**
     * Diamond Ore
     */
    DIAMOND_ORE("Diamond Ore", 56, 0, "textures/blocks/diamond_ore.png"),
    /**
     * Diamond Block
     */
    DIAMOND_BLOCK("Diamond Block", 57, 0, "textures/blocks/diamond_block.png"),
    /**
     * Crafting Table
     */
    CRAFTING_TABLE("Crafting Table", 58, 0, "textures/blocks/crafting_table_top.png"),
    /**
     * Farmland
     */
    FARMLAND("Farmland", 60, 0, "textures/blocks/farmland_dry.png"),
    /**
     * Furnace
     */
    FURNACE("Furnace", 61, 0, "textures/blocks/furnace_front_off.png"),
    /**
     * Ladder
     */
    LADDER("Ladder", 65, 0, "textures/blocks/ladder.png"),
    /**
     * Rail
     */
    RAIL("Rail", 66, 0, "textures/blocks/rail_normal.png"),
    /**
     * Cobblestone Stairs
     */
    STONE_STAIRS("Cobblestone Stairs", 67, 0, "textures/blocks/cobblestone.png"),
    /**
     * Lever
     */
    LEVER("Lever", 69, 0, "textures/blocks/lever.png"),
    /**
     * Stone Pressure Plate
     */
    STONE_PRESSURE_PLATE("Stone Pressure Plate", 70, 0, "textures/blocks/stone.png"),
    /**
     * Wooden Pressure Plate
     */
    WOODEN_PRESSURE_PLATE("Wooden Pressure Plate", 72, 0, "textures/blocks/planks_oak.png"),
    /**
     * Redstone Ore
     */
    REDSTONE_ORE("Redstone Ore", 73, 0, "textures/blocks/redstone_ore.png"),
    /**
     * Lit Redstone Ore
     */
    LIT_REDSTONE_ORE("Lit Redstone Ore", 74, 0, "textures/blocks/redstone_ore.png"),
    /**
     * Redstone Torch
     */
    UNLIT_REDSTONE_TORCH("Redstone Torch", 75, 0, "textures/blocks/redstone_torch_off.png"),
    /**
     * Stone Button
     */
    STONE_BUTTON("Stone Button", 77, 0, "textures/blocks/stone.png"),
    /**
     * Snow Layer
     */
    SNOW_LAYER("Snow Layer", 78, 0, "textures/blocks/snow.png"),
    /**
     * Ice
     */
    ICE("Ice", 79, 0, "textures/blocks/ice.png"),
    /**
     * Snow
     */
    SNOW("Snow", 80, 0, "textures/blocks/snow.png"),
    /**
     * Cactus
     */
    CACTUS("Cactus", 81, 0, "textures/blocks/cactus_side.tga"),
    /**
     * Clay
     */
    CLAY("Clay", 82, 0, "textures/blocks/clay.png"),
    /**
     * Jukebox
     */
    JUKEBOX("Jukebox", 84, 0, "textures/blocks/jukebox_top.png"),
    /**
     * Oak Fence
     */
    FENCE("Oak Fence", 85, 0, "textures/blocks/planks_oak.png"),
    /**
     * Pumpkin
     */
    PUMPKIN("Pumpkin", 86, 0, "textures/blocks/pumpkin_face_off.png"),
    /**
     * Netherrack
     */
    NETHERRACK("Netherrack", 87, 0, "textures/blocks/netherrack.png"),
    /**
     * Soul Sand
     */
    SOUL_SAND("Soul Sand", 88, 0, "textures/blocks/soul_sand.png"),
    /**
     * Glowstone
     */
    GLOWSTONE("Glowstone", 89, 0, "textures/blocks/glowstone.png"),
    /**
     * Portal
     */
    PORTAL("Portal", 90, 0, "textures/blocks/portal_placeholder.png"),
    /**
     * Jack o'Lantern
     */
    LIT_PUMPKIN("Jack o'Lantern", 91, 0, "textures/blocks/pumpkin_face_on.png"),
    /**
     * Invisible Bedrock
     */
    STAINED_GLASS("Invisible Bedrock", 95, 0, "textures/blocks/glass_white.png"),
    /**
     * Wooden Trapdoor
     */
    TRAPDOOR("Wooden Trapdoor", 96, 0, "textures/blocks/trapdoor.png"),
    /**
     * Stone Monster Egg
     */
    MONSTER_EGG("Stone Monster Egg", 97, 0, "textures/blocks/stone.png"),
    /**
     * Cobblestone Monster Egg
     */
    COBBLESTONE_EGG("Cobblestone Monster Egg", 97, 1, "textures/blocks/Cobblestone.png"),
    /**
     * Stone Brick Monster Egg
     */
    STONEBRICK("Stone Brick Monster Egg", 97, 2, "textures/blocks/stonebrick.png"),
    /**
     * Mossy Stone Bricks
     */
    STONEBRICK_MOSSY("Mossy Stone Bricks", 98, 1, "textures/blocks/stonebrick_mossy.png"),
    /**
     * Cracked Stone Bricks
     */
    STONEBRICK_CRACKED("Cracked Stone Bricks", 98, 2, "textures/blocks/stonebrick_cracked.png"),
    /**
     * Chiseled Stone Bricks
     */
    STONEBRICK_CARVED("Chiseled Stone Bricks", 98, 3, "textures/blocks/stonebrick_carved.png"),
    /**
     * Brown Mushroom Block
     */
    BROWN_MUSHROOM_BLOCK("Brown Mushroom Block", 99, 0, "textures/blocks/mushroom_block_skin_brown.png"),
    /**
     * Red Mushroom Block
     */
    RED_MUSHROOM_BLOCK("Red Mushroom Block", 100, 0, "textures/blocks/mushroom_block_skin_red.png"),
    /**
     * Iron Bars
     */
    IRON_BARS("Iron Bars", 101, 0, "textures/blocks/iron_bars.png"),
    /**
     * Glass Pane
     */
    GLASS_PANE("Glass Pane", 102, 0, "textures/blocks/glass_pane_top.png"),
    /**
     * Pumpkin Stem
     */
    PUMPKIN_STEM("Pumpkin Stem", 104, 0, "textures/blocks/pumpkin_stem_disconnected.png"),
    /**
     * Vines
     */
    VINE("Vines", 106, 0, "textures/blocks/vine_carried.png"),
    /**
     * Oak Fence Gate
     */
    FENCE_GATE("Oak Fence Gate", 107, 0, "textures/blocks/planks_oak.png"),
    /**
     * Brick Stairs
     */
    BRICK_STAIRS("Brick Stairs", 108, 0, "textures/blocks/brick.png"),
    /**
     * Stone Brick Stairs
     */
    STONE_BRICK_STAIRS("Stone Brick Stairs", 109, 0, "textures/blocks/stonebrick.png"),
    /**
     * Mycelium
     */
    MYCELIUM("Mycelium", 110, 0, "textures/blocks/mycelium_side.png"),
    /**
     * Lily Pad
     */
    WATERLILY("Lily Pad", 111, 0, "textures/blocks/carried_waterlily.png"),
    /**
     * Nether Brick
     */
    NETHERBRICK("Nether Brick", 405, 0, "textures/blocks/nether_brick.png"),
    /**
     * Nether Brick Fence
     */
    NETHER_BRICK_FENCE("Nether Brick Fence", 113, 0, "textures/blocks/nether_brick.png"),
    /**
     * Nether Brick Stairs
     */
    NETHER_BRICK_STAIRS("Nether Brick Stairs", 114, 0, "textures/blocks/nether_brick.png"),
    /**
     * Enchanting Table
     */
    ENCHANTING_TABLE("Enchanting Table", 116, 0, "textures/blocks/enchanting_table_side.png"),
    /**
     * Brewing Stand
     */
    BREWING_STAND("Brewing Stand", 379, 0, "textures/blocks/brewing_stand.png"),
    /**
     * Cauldron
     */
    CAULDRON("Cauldron", 380, 0, "textures/blocks/cauldron_side.png"),
    /**
     * End Portal
     */
    END_PORTAL("End Portal", 119, 0, "textures/blocks/end_portal.png"),
    /**
     * End Portal Frame
     */
    END_PORTAL_FRAME("End Portal Frame", 120, 0, "textures/blocks/end_portal.png"),
    /**
     * End Stone
     */
    END_STONE("End Stone", 121, 0, "textures/blocks/end_stone.png"),
    /**
     * Dragon Egg
     */
    DRAGON_EGG("Dragon Egg", 122, 0, "textures/blocks/dragon_egg.png"),
    /**
     * Redstone Lamp
     */
    REDSTONE_LAMP("Redstone Lamp", 123, 0, "textures/blocks/redstone_lamp_off.png"),
    /**
     * Sandstone Stairs
     */
    SANDSTONE_STAIRS("Sandstone Stairs", 128, 0, "textures/blocks/sandstone_bottom.png"),
    /**
     * Emerald Ore
     */
    EMERALD_ORE("Emerald Ore", 129, 0, "textures/blocks/emerald_ore.png"),
    /**
     * Ender Chest
     */
    ENDER_CHEST("Ender Chest", 130, 0, "textures/blocks/ender_chest_front.png"),
    /**
     * Tripwire Hook
     */
    TRIPWIRE_HOOK("Tripwire Hook", 131, 0, "textures/blocks/trip_wire_source.png"),
    /**
     * Tripwire
     */
    TRIPWIRE("Tripwire", 132, 0, "textures/blocks/trip_wire.png"),
    /**
     * Emerald Block
     */
    EMERALD_BLOCK("Emerald Block", 133, 0, "textures/blocks/emerald_block.png"),
    /**
     * Spruce Wood Stairs
     */
    SPRUCE_STAIRS("Spruce Wood Stairs", 134, 0, "textures/blocks/planks_spruce.png"),
    /**
     * Birch Wood Stairs
     */
    BIRCH_STAIRS("Birch Wood Stairs", 135, 0, "textures/blocks/planks_birch.png"),
    /**
     * Jungle Wood Stairs
     */
    JUNGLE_STAIRS("Jungle Wood Stairs", 136, 0, "textures/blocks/planks_jungle.png"),
    /**
     * Command Block
     */
    COMMAND_BLOCK("Command Block", 137, 0, "textures/blocks/command_block.png"),
    /**
     * Beacon
     */
    BEACON("Beacon", 138, 0, "textures/blocks/beacon.png"),
    /**
     * Cobblestone Wall
     */
    COBBLESTONE_WALL("Cobblestone Wall", 139, 0, "textures/blocks/cobblestone.png"),
    /**
     * Mossy Cobblestone Wall
     */
    MOSS_COBBLESTONE_WALL("Mossy Cobblestone Wall", 139, 1, "textures/blocks/cobblestone_mossy.png"),
    /**
     * Potatoes
     */
    POTATOES("Potatoes", 142, 0, "textures/blocks/potatoes_stage_3.png"),
    /**
     * Wooden Button
     */
    WOODEN_BUTTON("Wooden Button", 143, 0, "textures/blocks/planks_oak.png"),
    /**
     * Anvil
     */
    ANVIL("Anvil", 145, 0, "textures/blocks/anvil_top_damaged_0.png"),
    /**
     * Trapped Chest
     */
    TRAPPED_CHEST("Trapped Chest", 146, 0, "textures/blocks/trapped_chest_front.png"),
    /**
     * Light Weighted Pressure Plate
     */
    LIGHT_WEIGHTED_PRESSURE_PLATE("Light Weighted Pressure Plate", 147, 0, "textures/blocks/gold_block.png"),
    /**
     * Heavy Weighted Pressure Plate
     */
    HEAVY_WEIGHTED_PRESSURE_PLATE("Heavy Weighted Pressure Plate", 148, 0, "textures/blocks/iron_block.png"),
    /**
     * Daylight Detector
     */
    DAYLIGHT_DETECTOR_INVERTED("Daylight Detector", 178, 0, "textures/blocks/daylight_detector_inverted_top.png"),
    /**
     * Redstone Block
     */
    REDSTONE_BLOCK("Redstone Block", 152, 0, "textures/blocks/redstone_block.png"),
    /**
     * Nether Quartz Ore
     */
    QUARTZ_ORE("Nether Quartz Ore", 153, 0, "textures/blocks/quartz_ore.png"),
    /**
     * Hopper
     */
    HOPPER("Hopper", 154, 0, "textures/blocks/hopper_top.png"),
    /**
     * Quartz Block
     */
    QUARTZ_BLOCK("Quartz Block", 155, 0, "textures/blocks/quartz_block_top.png"),
    /**
     * Pillar Quartz Block
     */
    VERTICAL_GRAIN_QUARTZ_BLOCK("Pillar Quartz Block", 155, 1, "textures/blocks/quartz_block_lines.png"),
    /**
     * Chiseled Quartz Block
     */
    QUARTZ_BLOCK_CHISELED("Chiseled Quartz Block", 155, 2, "textures/blocks/quartz_block_chiseled_top.png"),
    /**
     * Quartz Stairs
     */
    QUARTZ_STAIRS("Quartz Stairs", 156, 0, "textures/blocks/quartz_block_top.png"),
    /**
     * Oak Wood Slab
     */
    OAK_WOOD_STAIRS("Oak Wood Slab", 158, 0, "textures/blocks/planks_oak.png"),
    /**
     * White Terracotta
     */
    WHITE_STAINED_HARDENED_CLAY("White Terracotta", 159, 0, "textures/blocks/hardened_clay_stained_white.png"),
    /**
     * Orange Terracotta
     */
    ORANGE_STAINED_HARDENED_CLAY("Orange Terracotta", 159, 1, "textures/blocks/hardened_clay_stained_orange.png"),
    /**
     * Magenta Terracotta
     */
    SOLFERINO_STAINED_HARDENED_CLAY("Magenta Terracotta", 159, 2, "textures/blocks/hardened_clay_stained_magenta.png"),
    /**
     * Light Blue Terracotta
     */
    LIGHT_BLUE_STAINED_HARDENED_CLAY("Light Blue Terracotta", 159, 3, "textures/blocks/hardened_clay_stained_light_blue.png"),
    /**
     * Yellow Terracotta
     */
    YELLOW_STAINED_HARDENED_CLAY("Yellow Terracotta", 159, 4, "textures/blocks/hardened_clay_stained_yellow.png"),
    /**
     * Lime Terracotta
     */
    OLIVINE_STAINED_HARDENED_CLAY("Lime Terracotta", 159, 5, "textures/blocks/hardened_clay_stained_lime.png"),
    /**
     * Pink Terracotta
     */
    PINK_STAINED_HARDENED_CLAY("Pink Terracotta", 159, 6, "textures/blocks/hardened_clay_stained_pink.png"),
    /**
     * Gray Terracotta
     */
    GRAY_STAINED_HARDENED_CLAY("Gray Terracotta", 159, 7, "textures/blocks/hardened_clay_stained_gray.png"),
    /**
     * Light Gray Terracotta
     */
    LIGHT_GRAY_STAINED_HARDENED_CLAY("Light Gray Terracotta", 159, 8, "textures/blocks/concrete_gray.png"),
    /**
     * Cyan Terracotta
     */
    CYAN_STAINED_HARDENED_CLAY("Cyan Terracotta", 159, 9, "textures/blocks/hardened_clay_stained_lime.png"),
    /**
     * Purple Terracotta
     */
    VIOLET_STAINED_HARDENED_CLAY("Purple Terracotta", 159, 10, "textures/blocks/hardened_clay_stained_purple.png"),
    /**
     * Blue Terracotta
     */
    BLUE_STAINED_HARDENED_CLAY("Blue Terracotta", 159, 11, "textures/blocks/hardened_clay_stained_blue.png"),
    /**
     * Brown Terracotta
     */
    BROWN_STAINED_HARDENED_CLAY("Brown Terracotta", 159, 12, "textures/blocks/hardened_clay_stained_brown.png"),
    /**
     * Green Terracotta
     */
    GREEN_STAINED_HARDENED_CLAY("Green Terracotta", 159, 13, "textures/blocks/hardened_clay_stained_green.png"),
    /**
     * Red Terracotta
     */
    RED_STAINED_HARDENED_CLAY("Red Terracotta", 159, 14, "textures/blocks/hardened_clay_stained_red.png"),
    /**
     * Black Terracotta
     */
    BLACK_STAINED_HARDENED_CLAY("Black Terracotta", 159, 15, "textures/blocks/hardened_clay_stained_black.png"),
    /**
     * White Stained Glass Pane
     */
    WHITE_STAINED_GLASS_PANE("White Stained Glass Pane", 160, 0, "textures/blocks/glass_pane_top_white.png"),
    /**
     * Orange Stained Glass Pane
     */
    ORANGE_STAINED_GLASS_PANE("Orange Stained Glass Pane", 160, 1, "textures/blocks/glass_pane_top_orange.png"),
    /**
     * Magenta Stained Glass Pane
     */
    SOLFERINO_STAINED_GLASS_PANE("Magenta Stained Glass Pane", 160, 2, "textures/blocks/glass_pane_top_magenta.png"),
    /**
     * Light Blue Stained Glass Pane
     */
    LIGHT_BLUE_STAINED_GLASS_PANE("Light Blue Stained Glass Pane", 160, 3, "textures/blocks/glass_light_blue.png"),
    /**
     * Yellow Stained Glass Pane
     */
    YELLOW_STAINED_GLASS_PANE("Yellow Stained Glass Pane", 160, 4, "textures/blocks/glass_yellow.png"),
    /**
     * Lime Stained Glass Pane
     */
    OLIVINE_STAINED_GLASS_PANE("Lime Stained Glass Pane", 160, 5, "textures/blocks/glass_pane_top_lime.png"),
    /**
     * Pink Stained Glass Pane
     */
    PINK_STAINED_GLASS_PANE("Pink Stained Glass Pane", 160, 6, "textures/blocks/glass_pane_top_pink.png"),
    /**
     * Gray Stained Glass Pane
     */
    GRAY_STAINED_GLASS_PANE("Gray Stained Glass Pane", 160, 7, "textures/blocks/glass_gray.png"),
    /**
     * Light Gray Stained Glass Pane
     */
    LIGHT_GRAY_STAINED_GLASS_PANE("Light Gray Stained Glass Pane", 160, 8, "textures/blocks/glass_brown.png"),
    /**
     * Cyan Stained Glass Pane
     */
    CYAN_STAINED_GLASS_PANE("Cyan Stained Glass Pane", 160, 9, "textures/blocks/glass_pane_top_cyan.png"),
    /**
     * Purple Stained Glass Pane
     */
    VIOLET_STAINED_GLASS_PANE("Purple Stained Glass Pane", 160, 10, "textures/blocks/glass_pane_top_purple.png"),
    /**
     * Blue Stained Glass Pane
     */
    BLUE_STAINED_GLASS_PANE("Blue Stained Glass Pane", 160, 11, "textures/blocks/glass_blue.png"),
    /**
     * Brown Stained Glass Pane
     */
    BROWN_STAINED_GLASS_PANE("Brown Stained Glass Pane", 160, 12, "textures/blocks/glass_brown.png"),
    /**
     * Green Stained Glass Pane
     */
    GREEN_STAINED_GLASS_PANE("Green Stained Glass Pane", 160, 13, "textures/blocks/glass_pane_top_green.png"),
    /**
     * Red Stained Glass Pane
     */
    RED_STAINED_GLASS_PANE("Red Stained Glass Pane", 160, 14, "textures/blocks/glass_red.png"),
    /**
     * Black Stained Glass Pane
     */
    BLACK_STAINED_GLASS_PANE("Black Stained Glass Pane", 160, 15, "textures/blocks/glass_black.png"),
    /**
     * Acacia Leaves
     */
    ACACIA_LEAVES("Acacia Leaves", 161, 0, "textures/blocks/leaves_acacia_opaque.png"),
    /**
     * Dark Oak Leaves
     */
    DARK_OAK_LEAF("Dark Oak Leaves", 161, 1, "textures/blocks/leaves_big_oak_opaque.png"),
    /**
     * Acacia Wood
     */
    ACACIA_WOOD("Acacia Wood", 162, 0, "textures/blocks/log_acacia.png"),
    /**
     * Dark Oak Wood
     */
    DARK_OAK("Dark Oak Wood", 162, 1, "textures/blocks/log_acacia.png"),
    /**
     * Acacia Wood Stairs
     */
    ACACIA_STAIRS("Acacia Wood Stairs", 163, 0, "textures/blocks/planks_acacia.png"),
    /**
     * Dark Oak Wood Stairs
     */
    DARK_OAK_STAIRS("Dark Oak Wood Stairs", 164, 0, "textures/blocks/planks_big_oak.png"),
    /**
     * Slime Block
     */
    SLIME("Slime Block", 165, 0, "textures/blocks/slime.png"),
    /**
     * Iron Door
     */
    IRON_DOOR("Iron Door", 330, 0, "textures/blocks/door_iron_upper.png"),
    /**
     * Prismarine
     */
    PRISMARINE("Prismarine", 168, 0, "textures/blocks/prismarine_dark.png"),
    /**
     * Dark Prismarine
     */
    DARK_PRISMARINE("Dark Prismarine", 168, 1, "textures/blocks/prismarine_dark.png"),
    /**
     * Prismarine Bricks
     */
    PRISMARINE_STONE_BRICK("Prismarine Bricks", 168, 2, "textures/blocks/prismarine_bricks.png"),
    /**
     * Sea Lantern
     */
    SEA_LANTERN("Sea Lantern", 169, 0, "textures/blocks/sea_lantern.png"),
    /**
     * Hay Bale
     */
    HAY_BLOCK("Hay Bale", 170, 0, "textures/blocks/hay_block_side.png"),
    /**
     * White Carpet
     */
    WHITE_CARPET("White Carpet", 171, 0, "textures/blocks/wool_colored_white.png"),
    /**
     * Orange Carpet
     */
    ORANGE_CARPET("Orange Carpet", 171, 1, "textures/blocks/wool_colored_orange.png"),
    /**
     * Magenta Carpet
     */
    SOLFERINO_CARPET("Magenta Carpet", 171, 2, "textures/blocks/wool_colored_magenta.png"),
    /**
     * Light Blue Carpet
     */
    LIGHT_BLUE_CARPET("Light Blue Carpet", 171, 3, "textures/blocks/wool_colored_light_blue.png"),
    /**
     * Yellow Carpet
     */
    YELLOW_CARPET("Yellow Carpet", 171, 4, "textures/blocks/wool_colored_yellow.png"),
    /**
     * Lime Carpet
     */
    OLIVINE_CARPET("Lime Carpet", 171, 5, "textures/blocks/wool_colored_lime.png"),
    /**
     * Pink Carpet
     */
    PINK_CARPET("Pink Carpet", 171, 6, "textures/blocks/wool_colored_pink.png"),
    /**
     * Gray Carpet
     */
    GRAY_CARPET("Gray Carpet", 171, 7, "textures/blocks/wool_colored_gray.png"),
    /**
     * Light Gray Carpet
     */
    LIGHT_GRAY_CARPET("Light Gray Carpet", 171, 8, "textures/blocks/wool_colored_silver.png"),
    /**
     * Cyan Carpet
     */
    CYAN_CARPET("Cyan Carpet", 171, 9, "textures/blocks/wool_colored_cyan.png"),
    /**
     * Purple Carpet
     */
    VIOLET_CARPET("Purple Carpet", 171, 10, "textures/blocks/wool_colored_purple.png"),
    /**
     * Blue Carpet
     */
    BLUE_CARPET("Blue Carpet", 171, 11, "textures/blocks/wool_colored_blue.png"),
    /**
     * Brown Carpet
     */
    BROWN_CARPET("Brown Carpet", 171, 12, "textures/blocks/wool_colored_brown.png"),
    /**
     * Green Carpet
     */
    GREEN_CARPET("Green Carpet", 171, 13, "textures/blocks/wool_colored_green.png"),
    /**
     * Red Carpet
     */
    RED_CARPET("Red Carpet", 171, 14, "textures/blocks/wool_colored_red.png"),
    /**
     * Black Carpet
     */
    BLACK_CARPET("Black Carpet", 171, 15, "textures/blocks/wool_colored_black.png"),
    /**
     * Terracotta
     */
    HARDENED_CLAY("Terracotta", 172, 0, "textures/blocks/hardened_clay.png"),
    /**
     * Coal Block
     */
    COAL_BLOCK("Coal Block", 173, 0, "textures/blocks/coal_block.png"),
    /**
     * Packed Ice
     */
    PACKED_ICE("Packed Ice", 174, 0, "textures/blocks/ice_packed.png"),
    /**
     * Sunflower
     */
    SUNFLOWER("Sunflower", 175, 0, "textures/blocks/double_plant_sunflower_front.png"),
    /**
     * Lilac
     */
    LILAC("Lilac", 175, 1, "textures/blocks/flower_cornflower.png"),
    /**
     * Double Tallgrass
     */
    TALL_GRASS("Double Tallgrass", 175, 2, "textures/blocks/double_plant_grass_carried.png"),
    /**
     * Large Fern
     */
    LARGE_FERN("Large Fern", 175, 3, "textures/blocks/tallgrass.png"),
    /**
     * Rose Bush
     */
    ROSE_BUSH("Rose Bush", 175, 4, "textures/blocks/sweet_berry_bush_stage3.png"),
    /**
     * Peony
     */
    PEONY("Peony", 175, 5, "textures/blocks/flower_allium.png"),
    /**
     * Banner
     */
    STANDING_BANNER("Banner", 176, 0, "textures/blocks/bone_block_side.png"),
    /**
     * Wall Banner
     */
    WALL_BANNER("Wall Banner", 177, 0, "textures/blocks/bone_block_side.png"),
    /**
     * Red Sandstone
     */
    RED_SANDSTONE("Red Sandstone", 179, 0, "textures/blocks/red_sandstone_bottom.png"),
    /**
     * Chiseled Red Sandstone
     */
    CHISELED_RED_SANDSTONE("Chiseled Red Sandstone", 179, 1, "textures/blocks/red_sandstone_carved.png"),
    /**
     * Smooth Red Sandstone
     */
    SMOOTH_RED_SANDSTONE("Smooth Red Sandstone", 179, 2, "textures/blocks/red_sandstone_smooth.png"),
    /**
     * Red Sandstone Stairs
     */
    RED_SANDSTONE_STAIRS("Red Sandstone Stairs", 180, 0, "textures/blocks/red_sandstone_carved.png"),
    /**
     * Red Sandstone Slab
     */
    STONE_SLAB2("Red Sandstone Slab", 182, 0, "textures/blocks/red_sandstone_smooth.png"),
    /**
     * Spruce Fence Gate
     */
    SPRUCE_FENCE_GATE("Spruce Fence Gate", 183, 0, "textures/blocks/door_spruce_lower.png"),
    /**
     * Birch Fence Gate
     */
    BIRCH_FENCE_GATE("Birch Fence Gate", 184, 0, "textures/blocks/door_birch_upper.png"),
    /**
     * Jungle Fence Gate
     */
    JUNGLE_FENCE_GATE("Jungle Fence Gate", 185, 0, "textures/blocks/door_acacia_upper.png"),
    /**
     * Dark Oak Fence Gate
     */
    DARK_OAK_FENCE_GATE("Dark Oak Fence Gate", 186, 0, "textures/blocks/door_dark_oak_lower.png"),
    /**
     * Acacia Fence Gate
     */
    ACACIA_FENCE_GATE("Acacia Fence Gate", 187, 0, "textures/blocks/door_spruce_lower.png"),
    /**
     * Repeating Command Block
     */
    SPRUCE_FENCE("Repeating Command Block", 188, 0, "textures/blocks/chain_command_block_conditional_mipmap.png"),
    /**
     * Chain Command Block
     */
    BIRCH_FENCE("Chain Command Block", 189, 0, "textures/blocks/repeating_command_block_back_mipmap.png"),
    /**
     * Birch Door
     */
    BIRCH_DOOR("Birch Door", 194, 0, "textures/blocks/door_birch_upper.png"),
    /**
     * Grass Path
     */
    END_ROD("Grass Path", 198, 0, "textures/blocks/end_rod.png"),
    /**
     * Chorus Flower
     */
    CHORUS_FLOWER("Chorus Flower", 200, 0, "textures/blocks/chorus_flower.png"),
    /**
     * Purpur Block
     */
    PURPUR_BLOCK("Purpur Block", 201, 0, "textures/blocks/purpur_block.png"),
    /**
     * Purpur Stairs
     */
    PURPUR_STAIRS("Purpur Stairs", 203, 0, "textures/blocks/purpur_block.png"),
    /**
     * Shulker Box
     */
    PURPUR_SLAB("Shulker Box", 205, 0, "textures/items/shulker_shell.png"),
    /**
     * End Stone Bricks
     */
    END_BRICKS("End Stone Bricks", 206, 0, "textures/blocks/end_bricks.png"),
    /**
     * End Rod
     */
    GRASS_PATH("End Rod", 208, 0, "textures/blocks/grass_path_side.png"),
    /**
     * End Gateway
     */
    END_GATEWAY("End Gateway", 209, 0, "textures/blocks/end_gateway.png"),
    /**
     * Iron Shovel
     */
    IRON_SHOVEL("Iron Shovel", 256, 0, "textures/items/iron_shovel.png"),
    /**
     * Iron Pickaxe
     */
    IRON_PICKAXE("Iron Pickaxe", 257, 0, "textures/items/iron_pickaxe.png"),
    /**
     * Iron Axe
     */
    IRON_AXE("Iron Axe", 258, 0, "textures/items/iron_axe.png"),
    /**
     * Flint and Steel
     */
    FLINT_AND_STEEL("Flint and Steel", 259, 0, "textures/items/flint_and_steel.png"),
    /**
     * Apple
     */
    APPLE("Apple", 260, 0, "textures/items/apple.png"),
    /**
     * Bow
     */
    BOW("Bow", 261, 0, "textures/items/bow_standby.png"),
    /**
     * Arrow
     */
    ARROW("Arrow", 262, 0, "textures/items/arrow.png"),
    /**
     * Coal
     */
    COAL("Coal", 263, 0, "textures/items/coal.png"),
    /**
     * Charcoal
     */
    CHARCOAL("Charcoal", 263, 1, "textures/items/charcoal.png"),
    /**
     * Diamond
     */
    DIAMOND("Diamond", 264, 0, "textures/items/diamond.png"),
    /**
     * Iron Ingot
     */
    IRON_INGOT("Iron Ingot", 265, 0, "textures/items/iron_ingot.png"),
    /**
     * Gold Ingot
     */
    GOLD_INGOT("Gold Ingot", 266, 0, "textures/items/gold_ingot.png"),
    /**
     * Iron Sword
     */
    IRON_SWORD("Iron Sword", 267, 0, "textures/items/iron_sword.png"),
    /**
     * Wooden Sword
     */
    WOODEN_SWORD("Wooden Sword", 268, 0, "textures/items/wood_sword.png"),
    /**
     * Wooden Shovel
     */
    WOODEN_SHOVEL("Wooden Shovel", 269, 0, "textures/items/wood_shovel.png"),
    /**
     * Wooden Pickaxe
     */
    WOODEN_PICKAXE("Wooden Pickaxe", 270, 0, "textures/items/wood_pickaxe.png"),
    /**
     * Wooden Axe
     */
    WOODEN_AXE("Wooden Axe", 271, 0, "textures/items/wood_axe.png"),
    /**
     * Stone Sword
     */
    STONE_SWORD("Stone Sword", 272, 0, "textures/items/stone_sword.png"),
    /**
     * Stone Shovel
     */
    STONE_SHOVEL("Stone Shovel", 273, 0, "textures/items/stone_shovel.png"),
    /**
     * Stone Pickaxe
     */
    STONE_PICKAXE("Stone Pickaxe", 274, 0, "textures/items/stone_pickaxe.png"),
    /**
     * Stone Axe
     */
    STONE_AXE("Stone Axe", 275, 0, "textures/items/stone_axe.png"),
    /**
     * Diamond Sword
     */
    DIAMOND_SWORD("Diamond Sword", 276, 0, "textures/items/diamond_sword.png"),
    /**
     * Diamond Shovel
     */
    DIAMOND_SHOVEL("Diamond Shovel", 277, 0, "textures/items/diamond_shovel.png"),
    /**
     * Diamond Pickaxe
     */
    DIAMOND_PICKAXE("Diamond Pickaxe", 278, 0, "textures/items/diamond_pickaxe.png"),
    /**
     * Diamond Axe
     */
    DIAMOND_AXE("Diamond Axe", 279, 0, "textures/items/diamond_axe.png"),
    /**
     * Stick
     */
    STICK("Stick", 280, 0, "textures/items/stick.png"),
    /**
     * Bowl
     */
    BOWL("Bowl", 281, 0, "textures/items/bowl.png"),
    /**
     * Mushroom Stew
     */
    MUSHROOM_STEW("Mushroom Stew", 282, 0, "textures/items/mushroom_stew.png"),
    /**
     * Golden Sword
     */
    GOLDEN_SWORD("Golden Sword", 283, 0, "textures/items/gold_sword.png"),
    /**
     * Golden Shovel
     */
    GOLDEN_SHOVEL("Golden Shovel", 284, 0, "textures/items/gold_shovel.png"),
    /**
     * Golden Pickaxe
     */
    GOLDEN_PICKAXE("Golden Pickaxe", 285, 0, "textures/items/gold_pickaxe.png"),
    /**
     * Golden Axe
     */
    GOLDEN_AXE("Golden Axe", 286, 0, "textures/items/gold_axe.png"),
    /**
     * String
     */
    STRING("String", 287, 0, "textures/items/string.png"),
    /**
     * Feather
     */
    FEATHER("Feather", 288, 0, "textures/items/feather.png"),
    /**
     * Gunpowder
     */
    GUNPOWDER("Gunpowder", 289, 0, "textures/items/gunpowder.png"),
    /**
     * Wooden Hoe
     */
    WOODEN_HOE("Wooden Hoe", 290, 0, "textures/items/wood_hoe.png"),
    /**
     * Stone Hoe
     */
    STONE_HOE("Stone Hoe", 291, 0, "textures/items/stone_hoe.png"),
    /**
     * Iron Hoe
     */
    IRON_HOE("Iron Hoe", 292, 0, "textures/items/iron_hoe.png"),
    /**
     * Diamond Hoe
     */
    DIAMOND_HOE("Diamond Hoe", 293, 0, "textures/items/diamond_hoe.png"),
    /**
     * Golden Hoe
     */
    GOLDEN_HOE("Golden Hoe", 294, 0, "textures/items/gold_hoe.png"),
    /**
     * Wheat Seeds
     */
    WHEAT_SEEDS("Wheat Seeds", 295, 0, "textures/items/seeds_wheat.png"),
    /**
     * Wheat
     */
    WHEAT("Wheat", 296, 0, "textures/items/wheat.png"),
    /**
     * Bread
     */
    BREAD("Bread", 297, 0, "textures/items/bread.png"),
    /**
     * Leather Helmet
     */
    LEATHER_HELMET("Leather Helmet", 298, 0, "textures/items/leather_helmet.tga"),
    /**
     * Leather Chestplate
     */
    LEATHER_CHESTPLATE("Leather Chestplate", 299, 0, "textures/items/leather_chestplate.png"),
    /**
     * Leather Leggings
     */
    LEATHER_LEGGINGS("Leather Leggings", 300, 0, "textures/items/leather_leggings.tga"),
    /**
     * Leather Boots
     */
    LEATHER_BOOTS("Leather Boots", 301, 0, "textures/items/leather_boots.tga"),
    /**
     * Chainmail Helmet
     */
    CHAINMAIL_HELMET("Chainmail Helmet", 302, 0, "textures/items/chainmail_helmet.png"),
    /**
     * Chainmail Chestplate
     */
    CHAINMAIL_CHESTPLATE("Chainmail Chestplate", 303, 0, "textures/items/chainmail_chestplate.png"),
    /**
     * Chainmail Leggings
     */
    CHAINMAIL_LEGGINGS("Chainmail Leggings", 304, 0, "textures/items/chainmail_leggings.png"),
    /**
     * Chainmail Boots
     */
    CHAINMAIL_BOOTS("Chainmail Boots", 305, 0, "textures/items/chainmail_boots.png"),
    /**
     * Iron Helmet
     */
    IRON_HELMET("Iron Helmet", 306, 0, "textures/items/iron_helmet.png"),
    /**
     * Iron Chestplate
     */
    IRON_CHESTPLATE("Iron Chestplate", 307, 0, "textures/items/iron_chestplate.png"),
    /**
     * Iron Leggings
     */
    IRON_LEGGINGS("Iron Leggings", 308, 0, "textures/items/iron_leggings.png"),
    /**
     * Iron Boots
     */
    IRON_BOOTS("Iron Boots", 309, 0, "textures/items/iron_boots.png"),
    /**
     * Diamond Helmet
     */
    DIAMOND_HELMET("Diamond Helmet", 310, 0, "textures/items/diamond_helmet.png"),
    /**
     * Diamond Chestplate
     */
    DIAMOND_CHESTPLATE("Diamond Chestplate", 311, 0, "textures/items/diamond_chestplate.png"),
    /**
     * Diamond Leggings
     */
    DIAMOND_LEGGINGS("Diamond Leggings", 312, 0, "textures/items/diamond_leggings.png"),
    /**
     * Diamond Boots
     */
    DIAMOND_BOOTS("Diamond Boots", 313, 0, "textures/items/diamond_boots.png"),
    /**
     * Golden Helmet
     */
    GOLDEN_HELMET("Golden Helmet", 314, 0, "textures/items/gold_helmet.png"),
    /**
     * Golden Chestplate
     */
    GOLDEN_CHESTPLATE("Golden Chestplate", 315, 0, "textures/items/gold_chestplate.png"),
    /**
     * Golden Leggings
     */
    GOLDEN_LEGGINGS("Golden Leggings", 316, 0, "textures/items/gold_leggings.png"),
    /**
     * Golden Boots
     */
    GOLDEN_BOOTS("Golden Boots", 317, 0, "textures/items/gold_boots.png"),
    /**
     * Flint
     */
    FLINT("Flint", 318, 0, "textures/items/flint.png"),
    /**
     * Raw Porkchop
     */
    PORKCHOP("Raw Porkchop", 319, 0, "textures/items/porkchop_raw.png"),
    /**
     * Cooked Porkchop
     */
    COOKED_PORKCHOP("Cooked Porkchop", 320, 0, "textures/items/porkchop_cooked.png"),
    /**
     * Painting
     */
    PAINTING("Painting", 321, 0, "textures/items/painting.png"),
    /**
     * Golden Apple
     */
    GOLDEN_APPLE("Golden Apple", 322, 0, "textures/items/apple_golden.png"),
    /**
     * Sign
     */
    SIGN("Sign", 323, 0, "textures/items/sign.png"),
    /**
     * Oak Door
     */
    WOODEN_DOOR("Oak Door", 324, 0, "textures/items/door_wood.png"),
    /**
     * Bucket
     */
    BUCKET("Bucket", 325, 0, "textures/items/bucket_empty.png"),
    /**
     * Minecart
     */
    MINECART("Minecart", 328, 0, "textures/items/minecart_normal.png"),
    /**
     * Saddle
     */
    SADDLE("Saddle", 329, 0, "textures/items/saddle.png"),
    /**
     * Redstone
     */
    REDSTONE("Redstone", 331, 0, "textures/items/redstone_dust.png"),
    /**
     * Snowball
     */
    SNOWBALL("Snowball", 332, 0, "textures/items/snowball.png"),
    /**
     * Oak Boat
     */
    BOAT("Oak Boat", 333, 0, "textures/items/boat.png"),
    /**
     * Leather
     */
    LEATHER("Leather", 334, 0, "textures/items/leather.png"),
    /**
     * Clay Ball
     */
    CLAY_BALL("Clay Ball", 337, 0, "textures/items/clay_ball.png"),
    /**
     * Sugar Canes
     */
    REEDS("Sugar Canes", 338, 0, "textures/items/reeds.png"),
    /**
     * Paper
     */
    PAPER("Paper", 339, 0, "textures/items/paper.png"),
    /**
     * Book
     */
    BOOK("Book", 340, 0, "textures/items/book_normal.png"),
    /**
     * Slimeball
     */
    SLIME_BALL("Slimeball", 341, 0, "textures/items/slimeball.png"),
    /**
     * Minecart with Chest
     */
    CHEST_MINECART("Minecart with Chest", 342, 0, "textures/items/minecart_chest.png"),
    /**
     * Egg
     */
    EGG("Egg", 344, 0, "textures/items/egg.png"),
    /**
     * Compass
     */
    COMPASS("Compass", 345, 0, "textures/items/compass_item.png"),
    /**
     * Fishing Rod
     */
    FISHING_ROD("Fishing Rod", 346, 0, "textures/items/fishing_rod_cast.png"),
    /**
     * Clock
     */
    CLOCK("Clock", 347, 0, "textures/items/clock_item.png"),
    /**
     * Glowstone Dust
     */
    GLOWSTONE_DUST("Glowstone Dust", 348, 0, "textures/items/glowstone_dust.png"),
    /**
     * Raw Fish
     */
    FISH("Raw Fish", 349, 0, "textures/items/fish_raw.png"),
    /**
     * Cooked Fish
     */
    COOKED_FISH("Cooked Fish", 350, 0, "textures/items/fish_cooked.png"),
    /**
     * Ink Sac
     */
    DYE("Ink Sac", 351, 0, "textures/items/dye_powder_black.png"),
    /**
     * Magenta Dye
     */
    SOLFERINO_DYE("Magenta Dye", 351, 1, "textures/items/dye_powder_purple.png"),
    /**
     * Green Dye
     */
    GREEN_DYE("Green Dye", 351, 2, "textures/items/dye_powder_green.png"),
    /**
     * Cocoa Beans
     */
    BROWN_DYE("Cocoa Beans", 351, 3, "textures/items/dye_powder_brown.png"),
    /**
     * Blue Dye
     */
    BLUE_DYE("Blue Dye", 351, 4, "textures/items/dye_powder_blue.png"),
    /**
     * Purple Dye
     */
    VIOLET_DYE("Purple Dye", 351, 5, "textures/items/dye_powder_purple.png"),
    /**
     * Cyan Dye
     */
    CYAN_DYE("Cyan Dye", 351, 6, "textures/items/dye_powder_cyan.png"),
    /**
     * Light Gray Dye
     */
    LIGHT_GRAY_DYE("Light Gray Dye", 351, 7, "textures/items/dye_powder_silver.png"),
    /**
     * Gray Dye
     */
    GRAY_DYE("Gray Dye", 351, 8, "textures/items/dye_powder_pink.png"),
    /**
     * Pink Dye
     */
    PINK_DYE("Pink Dye", 351, 9, "textures/items/dye_powder_pink.png"),
    /**
     * Lime Dye
     */
    OLIVINE_DYE("Lime Dye", 351, 10, "textures/items/dye_powder_lime.png"),
    /**
     * Yellow Dye
     */
    YELLOW_DYE("Yellow Dye", 351, 11, "textures/items/dye_powder_yellow.png"),
    /**
     * Light Blue Dye
     */
    LIGHT_BLUE_DYE("Light Blue Dye", 351, 12, "textures/items/dye_powder_light_blue.png"),
    /**
     * Red Dye
     */
    RED_DYE("Red Dye", 351, 13, "textures/items/dye_powder_red.png"),
    /**
     * Orange Dye
     */
    ORANGE_DYE("Orange Dye", 351, 14, "textures/items/dye_powder_orange.png"),
    /**
     * Bone Meal
     */
    WHITE_DYE("Bone Meal", 351, 15, "textures/items/dye_powder_white.png"),
    /**
     * Bone
     */
    BONE("Bone", 352, 0, "textures/items/bone.png"),
    /**
     * Sugar
     */
    SUGAR("Sugar", 353, 0, "textures/items/sugar.png"),
    /**
     * Cake
     */
    CAKE("Cake", 354, 0, "textures/items/cake.png"),
    /**
     * Bed
     */
    BED("Bed", 355, 0, "textures/items/bed_red.png"),
    /**
     * Repeater
     */
    REPEATER("Repeater", 356, 0, "textures/items/repeater.png"),
    /**
     * Cookie
     */
    COOKIE("Cookie", 357, 0, "textures/items/cookie.png"),
    /**
     * Filled Map
     */
    FILLED_MAP("Filled Map", 358, 0, "textures/items/map_nautilus.png"),
    /**
     * Shears
     */
    SHEARS("Shears", 359, 0, "textures/items/shears.png"),
    /**
     * Melon Slice
     */
    MELON("Melon Slice", 360, 0, "textures/items/melon.png"),
    /**
     * Melon Seeds
     */
    MELON_SEEDS("Melon Seeds", 362, 0, "textures/items/seeds_melon.png"),
    /**
     * Raw Beef
     */
    BEEF("Raw Beef", 363, 0, "textures/items/beef_raw.png"),
    /**
     * Cooked Beef
     */
    COOKED_BEEF("Cooked Beef", 364, 0, "textures/items/beef_cooked.png"),
    /**
     * Raw Chicken
     */
    CHICKEN("Raw Chicken", 365, 0, "textures/items/chicken_raw.png"),
    /**
     * Cooked Chicken
     */
    COOKED_CHICKEN("Cooked Chicken", 366, 0, "textures/items/chicken_cooked.png"),
    /**
     * Rotten Flesh
     */
    ROTTEN_FLESH("Rotten Flesh", 367, 0, "textures/items/rotten_flesh.png"),
    /**
     * Ender Pearl
     */
    ENDER_PEARL("Ender Pearl", 368, 0, "textures/items/ender_pearl.png"),
    /**
     * Blaze Rod
     */
    BLAZE_ROD("Blaze Rod", 369, 0, "textures/items/blaze_rod.png"),
    /**
     * Ghast Tear
     */
    GHAST_TEAR("Ghast Tear", 370, 0, "textures/items/ghast_tear.png"),
    /**
     * Gold Nugget
     */
    GOLD_NUGGET("Gold Nugget", 371, 0, "textures/items/gold_nugget.png"),
    /**
     * Nether Wart
     */
    NETHER_WART("Nether Wart", 372, 0, "textures/items/nether_wart.png"),
    /**
     * Potion
     */
    POTION("Potion", 373, 0, "textures/items/potion_bottle_drinkable.png"),
    /**
     * Glass Bottle
     */
    GLASS_BOTTLE("Glass Bottle", 374, 0, "textures/items/potion_bottle_empty.png"),
    /**
     * Spider Eye
     */
    SPIDER_EYE("Spider Eye", 375, 0, "textures/items/spider_eye.png"),
    /**
     * Fermented Spider Eye
     */
    SPIDER_EYE_FERMENTED("Fermented Spider Eye", 376, 0, "textures/items/spider_eye_fermented.png"),
    /**
     * Blaze Powder
     */
    BLAZE_POWDER("Blaze Powder", 377, 0, "textures/items/blaze_powder.png"),
    /**
     * Magma Cream
     */
    MAGMA_CREAM("Magma Cream", 378, 0, "textures/items/magma_cream.png"),
    /**
     * Eye of Ender
     */
    ENDER_EYE("Eye of Ender", 381, 0, "textures/items/ender_eye.png"),
    /**
     * Glistering Melon Slice
     */
    SPECKLED_MELON("Glistering Melon Slice", 382, 0, "textures/items/melon_speckled.png"),
    /**
     * Bottle o' Enchanting
     */
    EXPERIENCE_BOTTLE("Bottle o' Enchanting", 384, 0, "textures/items/experience_bottle.png"),
    /**
     * Fire Charge
     */
    FIRE_CHARGE("Fire Charge", 385, 0, "textures/items/fireball.png"),
    /**
     * Emerald
     */
    EMERALD("Emerald", 388, 0, "textures/items/emerald.png"),
    /**
     * Item Frame
     */
    ITEM_FRAME("Item Frame", 389, 0, "textures/items/item_frame.png"),
    /**
     * Flower Pot
     */
    FLOWER_POT("Flower Pot", 390, 0, "textures/items/flower_pot.png"),
    /**
     * Carrot
     */
    CARROT("Carrot", 391, 0, "textures/items/carrot.png"),
    /**
     * Potato
     */
    POTATO("Potato", 392, 0, "textures/items/potato.png"),
    /**
     * Baked Potato
     */
    BAKED_POTATO("Baked Potato", 393, 0, "textures/items/potato_baked.png"),
    /**
     * Poisonous Potato
     */
    POISONOUS_POTATO("Poisonous Potato", 394, 0, "textures/items/potato_poisonous.png"),
    /**
     * Empty Map
     */
    MAP("Empty Map", 395, 0, "textures/items/map_empty.png"),
    /**
     * Golden Carrot
     */
    GOLDEN_CARROT("Golden Carrot", 396, 0, "textures/items/carrot_golden.png"),
    /**
     * Skeleton Skull
     */
    SKELETON_SKULL("Skeleton Skull", 397, 0, "textures/items/bone.png"),
    /**
     * Wither Skeleton Skull
     */
    LEIERDA_SKULL("Wither Skeleton Skull", 397, 1, "textures/blocks/observer_front.png"),
    /**
     * Zombie Head
     */
    ZOMBIE_SKULL("Zombie Head", 397, 2, "textures/blocks/observer_front.png"),
    /**
     * Player Head
     */
    STEVE_SKULL("Player Head", 397, 3, "textures/blocks/observer_front.png"),
    /**
     * Creeper Head
     */
    CREEPER_SKULL("Creeper Head", 397, 4, "textures/blocks/observer_front.png"),
    /**
     * Dragon Head
     */
    DRAGON_SKULL("Dragon Head", 397, 5, "textures/blocks/observer_front.png"),
    /**
     * Carrot on a Stick
     */
    CARROT_ON_A_STICK("Carrot on a Stick", 398, 0, "textures/items/carrot_on_a_stick.png"),
    /**
     * Nether Star
     */
    NETHER_STAR("Nether Star", 399, 0, "textures/items/nether_star.png"),
    /**
     * Pumpkin Pie
     */
    PUMPKIN_PIE("Pumpkin Pie", 400, 0, "textures/items/pumpkin_pie.png"),
    /**
     * Enchanted Book
     */
    ENCHANTED_BOOK("Enchanted Book", 403, 0, "textures/items/book_writable.png"),
    /**
     * Comparator
     */
    COMPARATOR("Comparator", 404, 0, "textures/items/comparator.png"),
    /**
     * Nether Quartz
     */
    QUARTZ("Nether Quartz", 406, 0, "textures/items/quartz.png"),
    /**
     * Minecart with TNT
     */
    TNT_MINECART("Minecart with TNT", 407, 0, "textures/items/minecart_tnt.png"),
    /**
     * Minecart with Hopper
     */
    HOPPER_MINECART("Minecart with Hopper", 408, 0, "textures/items/minecart_hopper.png"),
    /**
     * Prismarine Shard
     */
    PRISMARINE_SHARD("Prismarine Shard", 409, 0, "textures/items/prismarine_shard.png"),
    /**
     * Prismarine Crystals
     */
    PRISMARINE_CRYSTALS("Prismarine Crystals", 410, 0, "textures/items/prismarine_crystals.png"),
    /**
     * Raw Rabbit
     */
    RABBIT("Raw Rabbit", 411, 0, "textures/items/rabbit_raw.png"),
    /**
     * Cooked Rabbit
     */
    COOKED_RABBIT("Cooked Rabbit", 412, 0, "textures/items/rabbit_cooked.png"),
    /**
     * Rabbit Stew
     */
    RABBIT_STEW("Rabbit Stew", 413, 0, "textures/items/rabbit_stew.png"),
    /**
     * Rabbit's Foot
     */
    RABBIT_FOOT("Rabbit's Foot", 414, 0, "textures/items/rabbit_foot.png"),
    /**
     * Rabbit Hide
     */
    RABBIT_HIDE("Rabbit Hide", 415, 0, "textures/items/rabbit_hide.png"),
    /**
     * Armor Stand
     */
    ARMOR_STAND("Armor Stand", 416, 0, "textures/items/saddle.png"),
    /**
     * Iron Horse Armor
     */
    IRON_HORSE_ARMOR("Iron Horse Armor", 417, 0, "textures/items/iron_horse_armor.png"),
    /**
     * Golden Horse Armor
     */
    GOLD_HORSE_ARMOR("Golden Horse Armor", 418, 0, "textures/items/gold_horse_armor.png"),
    /**
     * Diamond Horse Armor
     */
    DIAMOND_HORSE_ARMOR("Diamond Horse Armor", 419, 0, "textures/items/diamond_horse_armor.png"),
    /**
     * Lead
     */
    LEAD("Lead", 420, 0, "textures/items/lead.png"),
    /**
     * Name Tag
     */
    NAME_TAG("Name Tag", 421, 0, "textures/items/name_tag.png"),
    /**
     * Minecart with Command Block
     */
    COMMAND_BLOCK_MINECART("Minecart with Command Block", 422, 0, "textures/items/minecart_command_block.png"),
    /**
     * Raw Mutton
     */
    MUTTON("Raw Mutton", 423, 0, "textures/items/mutton_raw.png"),
    /**
     * Cooked Mutton
     */
    COOKED_MUTTON("Cooked Mutton", 424, 0, "textures/items/mutton_cooked.png"),
    /**
     * Spruce Door
     */
    SPRUCE_DOOR("Spruce Door", 427, 0, "textures/items/door_jungle.png"),
    /**
     * Birch Door
     */
    BIRCH_WOOD_DOOR("Birch Door", 428, 0, "textures/items/door_birch.png"),
    /**
     * Jungle Door
     */
    JUNGLE_DOOR("Jungle Door", 429, 0, "textures/items/door_spruce.png"),
    /**
     * Acacia Door
     */
    ACACIA_DOOR("Acacia Door", 430, 0, "textures/items/door_acacia.png"),
    /**
     * Dark Oak Door
     */
    DARK_OAK_DOOR("Dark Oak Door", 431, 0, "textures/items/door_dark_oak.png"),
    /**
     * Chorus Fruit
     */
    CHORUS_FRUIT("Chorus Fruit", 432, 0, "textures/items/chorus_fruit.png"),
    /**
     * Popped Chorus Fruit
     */
    POPPED_CHORUS_FRUIT("Popped Chorus Fruit", 433, 0, "textures/items/chorus_fruit_popped.png"),
    /**
     * Dragon's Breath
     */
    DRAGON_BREATH("Dragon's Breath", 437, 0, "textures/items/dragons_breath.png"),
    /**
     * Splash Potion
     */
    SPLASH_POTION("Splash Potion", 438, 0, "textures/items/potion_bottle_splash.png"),
    /**
     * Lingering Potion
     */
    LINGERING_POTION("Lingering Potion", 441, 0, "textures/items/potion_bottle_lingering_waterBreathing.png"),
    /**
     * Elytra
     */
    ELYTRA("Elytra", 444, 0, "textures/items/elytra.png"),
    /**
     * Shulker Shell
     */
    BIRCH_BOAT("Shulker Shell", 445, 0, "textures/items/shulker_shell.png");
    private int ID, Damage;
    private String Name, Path;
    private static final HashMap<String, Map<String, Object>> NAME_MAP = new HashMap<>();
    private static final HashMap<String, Map<String, Object>> ID_MAP = new HashMap<>();
    private static final HashMap<String, ItemIDSunName> ItemIDSunName_MAP = new HashMap<>();
    private static final ArrayList<HashMap<String, Object>> All = new ArrayList<>();
    static {
        for (ItemIDSunName item : ItemIDSunName.values()) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("ID", item.ID);
            map.put("Damage", item.Damage);
            map.put("Path", item.Path);
            map.put("Name", item.Name);
            map.put("item", item);
            All.add(map);
            NAME_MAP.put(item.Name, map);
            ID_MAP.put(item.ID + ":" + item.Damage, map);
            ItemIDSunName_MAP.put(item.ID + ":" + item.Damage, item);
        }
    }

    /**
     * @param Name   Item name
     * @param id     Item ID
     * @param Damage Item special value
     * @param Path   Item texture path
     */
    private ItemIDSunName(String Name, int id, int Damage, String Path) {
        this.ID = id;
        this.Name = Name;
        this.Damage = Damage;
        this.Path = Path;
    }

    /**
     * @return Item texture path
     */
    public String getPath() {
        return this.Path;
    }

    /**
     * @return Item name
     */
    public String getName() {
        return this.Name;
    }

    /**
     * @return Item special value
     */
    public int getDamage() {
        return this.Damage;
    }

    /**
     * @return Item ID
     */
    public int getID() {
        return this.ID;
    }

    /**
     * @param ID Item ID
     * @return Get the item texture path according to the item ID
     */
    public static String getIDByPath(int ID) {
        return getIDByPath(ID + ":0");
    }

    /**
     * @param ID     Item ID
     * @param Damage Item special value
     * @return Get the item texture path according to the item ID
     */
    public static String getIDByPath(int ID, int Damage) {
        return getIDByPath(ID + ":" + Damage);
    }

    /**
     * @param ID Item ID (ID: special value)
     * @return Get the item texture path according to the item ID (ID: special value)
     */
    public static String getIDByPath(String ID) {
        Map<String, Object> map = ID_MAP.getOrDefault(ID, null);
        if (map == null || map.getOrDefault("Path", null) == null)
            return null;
        return String.valueOf(map.get("Path"));
    }

    /**
     * @param ID Item ID
     * @return Get the item name according to the item ID
     */
    public static String getIDByName(int ID) {
        return getIDByName(ID + ":0");
    }

    /**
     * @param ID     Item ID
     * @param Damage Item special value
     * @return Get the item name according to the item ID
     */
    public static String getIDByName(int ID, int Damage) {
        return getIDByName(ID + ":" + Damage);
    }


    public static String getIDByName(Item item) {
        String name = getIDByName(item.getId() + ":" + item.getDamage());
        if(name == null){
            if(item.hasCustomName()){
                return item.getCustomName();
            }else{
                return item.getName();
            }
        }else{
            if(item.hasCustomName())
                return item.getCustomName();
            return name;
        }
    }

    /**
     * @param ID Item ID (ID: special value)
     * @return Get the item name according to the item ID
     */
    public static String getIDByName(String ID) {
        Map<String, Object> map = ID_MAP.getOrDefault(ID, null);
        if (map == null || map.getOrDefault("Name", null) == null)
            return null;
        return String.valueOf(map.get("Name"));
    }

    /**
     * @param Name Item name
     * @return Get the item ID according to the item name
     */
    public static int getNameByID(String Name) {
        Map<String, Object> map = NAME_MAP.getOrDefault(Name, null);
        if (map == null || map.getOrDefault("ID", null) == null)
            return 0;
        return Integer.valueOf(String.valueOf(map.get("ID")));
    }

    /**
     * @param Name Item name
     * @return Get the item special value according to the item name
     */
    public static int getNameByDamage(String Name) {
        Map<String, Object> map = NAME_MAP.getOrDefault(Name, null);
        if (map == null || map.getOrDefault("Damage", null) == null)
            return 0;
        return Integer.valueOf(String.valueOf(map.get("Damage")));
    }

    /**
     * @param Name Item name
     * @return Get the item texture path according to the item name
     */
    public static String getNameByPath(String Name) {
        Map<String, Object> map = NAME_MAP.getOrDefault(Name, null);
        if (map == null || map.getOrDefault("Path", null) == null)
            return null;
        return String.valueOf(map.get("Path"));
    }

    /**
     * @param ID Item ID
     * @return Get the item enumeration object according to the item ID
     */
    public static ItemIDSunName getItem(int ID) {
        return getItem(ID, 0);
    }

    /**
     * @param ID     Item ID
     * @param Damage Item special value
     * @return Get the item enumeration object according to the item ID
     */
    public static ItemIDSunName getItem(int ID, int Damage) {
        return ItemIDSunName_MAP.getOrDefault(ID + ":" + Damage, null);
    }

    /**
     * @param Name Item name
     * @return Get the item enumeration object according to the item ID
     */
    public static ItemIDSunName getItem(String Name) {
        return getItem(getNameByID(Name), getNameByDamage(Name));
    }

    /**
     * @param ID (ID: special value)/item name
     * @return Try to parse and get the item ID (ID: special value)
     */
    public static String UnknownToID(String ID) {
        if (!ID.contains(":")) {
            if (getNameByPath(ID) != null)
                return getNameByID(ID) + ":" + getNameByDamage(ID);
            else if (getIDByPath(ID + ":0") != null)
                return ID + ":0";
            else
                return ID;
        } else {
            if (getIDByPath(ID) != null)
                return ID;
            else if (getNameByPath(ID) != null)
                return getNameByID(ID) + ":" + getNameByDamage(ID);
            else
                return ID;
        }
    }

    /**
     * @param string item ID/item name/item texture path
     * @return Try to parse and get the item texture path
     */
    public static String UnknownToPath(String string) {
        if (UnknownToID(string) != null)
            return getIDByPath(UnknownToID(string));
        else
            return string;
    }


    /**
     * Get all items
     *
     * @return
     */
    public static ArrayList<HashMap<String, Object>> getAll() {
        return All;
    }
}