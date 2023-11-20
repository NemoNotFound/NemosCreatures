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

    public static void registerItems() {
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "venomous_skeleton_spawn_egg"), VENOMOUS_SKELETON_SPAWN_EGG);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "venomous_spider_spawn_egg"), VENOMOUS_SPIDER_SPAWN_EGG);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "venomous_zombie_spawn_egg"), VENOMOUS_ZOMBIE_SPAWN_EGG);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "venomous_creeper_spawn_egg"), VENOMOUS_CREEPER_SPAWN_EGG);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(content -> content.add(VENOMOUS_SKELETON_SPAWN_EGG));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(content -> content.add(VENOMOUS_SPIDER_SPAWN_EGG));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(content -> content.add(VENOMOUS_ZOMBIE_SPAWN_EGG));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(content -> content.add(VENOMOUS_CREEPER_SPAWN_EGG));
    }
}
