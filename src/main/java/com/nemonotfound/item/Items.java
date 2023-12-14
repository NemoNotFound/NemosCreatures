package com.nemonotfound.item;

import com.nemonotfound.entity.Entities;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static com.nemonotfound.NemosCreatures.MOD_ID;

public class Items {

    public static final Item VENOMOUS_SKELETON_SPAWN_EGG = new SpawnEggItem(Entities.VENOMOUS_SKELETON, 0xC1C1C1, 5884716,
            new FabricItemSettings());
    public static final Item VENOMOUS_SPIDER_SPAWN_EGG = new SpawnEggItem(Entities.VENOMOUS_SPIDER, 1657614, 11013646,
            new FabricItemSettings());
    public static final Item VENOMOUS_ZOMBIE_SPAWN_EGG = new SpawnEggItem(Entities.VENOMOUS_ZOMBIE, 44975, 5884716,
            new FabricItemSettings());
    public static final Item VENOMOUS_CREEPER_SPAWN_EGG = new SpawnEggItem(Entities.VENOMOUS_CREEPER, 894731, 87040,
            new FabricItemSettings());
    public static final Item SCORCHED_SKELETON_SPAWN_EGG = new SpawnEggItem(Entities.SCORCHED_SKELETON, 7497817, 5262145,
            new FabricItemSettings());
    public static final Item SAND_SPIDER_SPAWN_EGG = new SpawnEggItem(Entities.SAND_SPIDER, 14009494, 15394254,
            new FabricItemSettings());
    public static final Item MUMMY_SPAWN_EGG = new SpawnEggItem(Entities.MUMMY, 11572567, 5326381,
            new FabricItemSettings());
    public static final Item SCORCHED_CREEPER_SPAWN_EGG = new SpawnEggItem(Entities.SCORCHED_CREEPER, 7497817, 15000247,
            new FabricItemSettings());
    public static final Item CRIMSON_SKELETON_SPAWN_EGG = new SpawnEggItem(Entities.CRIMSON_SKELETON, 7497817, 15000247,
            new FabricItemSettings());
    public static final Item FIRE_ARROW = new FireArrowItem(new FabricItemSettings());

    public static void registerItems() {
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "venomous_skeleton_spawn_egg"), VENOMOUS_SKELETON_SPAWN_EGG);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "venomous_spider_spawn_egg"), VENOMOUS_SPIDER_SPAWN_EGG);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "venomous_zombie_spawn_egg"), VENOMOUS_ZOMBIE_SPAWN_EGG);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "venomous_creeper_spawn_egg"), VENOMOUS_CREEPER_SPAWN_EGG);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "scorched_skeleton_spawn_egg"), SCORCHED_SKELETON_SPAWN_EGG);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "sand_spider_spawn_egg"), SAND_SPIDER_SPAWN_EGG);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "mummy_spawn_egg"), MUMMY_SPAWN_EGG);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "scorched_creeper_spawn_egg"), SCORCHED_CREEPER_SPAWN_EGG);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "crimson_skeleton_spawn_egg"), CRIMSON_SKELETON_SPAWN_EGG);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "fire_arrow"), FIRE_ARROW);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(content -> content.add(VENOMOUS_SKELETON_SPAWN_EGG));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(content -> content.add(VENOMOUS_SPIDER_SPAWN_EGG));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(content -> content.add(VENOMOUS_ZOMBIE_SPAWN_EGG));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(content -> content.add(VENOMOUS_CREEPER_SPAWN_EGG));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(content -> content.add(SCORCHED_SKELETON_SPAWN_EGG));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(content -> content.add(SAND_SPIDER_SPAWN_EGG));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(content -> content.add(MUMMY_SPAWN_EGG));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(content -> content.add(SCORCHED_CREEPER_SPAWN_EGG));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(content -> content.add(CRIMSON_SKELETON_SPAWN_EGG));
    }
}
