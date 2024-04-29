package com.nemonotfound.item;

import com.nemonotfound.entity.Entities;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static com.nemonotfound.NemosCreatures.MOD_ID;
import static com.nemonotfound.NemosCreatures.log;

public class ModItems {

    public static final Item VENOMOUS_SKELETON_SPAWN_EGG = registerSpawnEggItem(Entities.VENOMOUS_SKELETON, 0xC1C1C1, 5884716);
    public static final Item VENOMOUS_SPIDER_SPAWN_EGG = registerSpawnEggItem(Entities.VENOMOUS_SPIDER, 1657614, 11013646);
    public static final Item VENOMOUS_ZOMBIE_SPAWN_EGG = registerSpawnEggItem(Entities.VENOMOUS_ZOMBIE, 44975, 5884716);
    public static final Item VENOMOUS_CREEPER_SPAWN_EGG = registerSpawnEggItem(Entities.VENOMOUS_CREEPER, 894731, 87040);
    public static final Item SCORCHED_SKELETON_SPAWN_EGG = registerSpawnEggItem(Entities.SCORCHED_SKELETON, 7497817, 5262145);
    public static final Item SAND_SPIDER_SPAWN_EGG = registerSpawnEggItem(Entities.SAND_SPIDER, 14009494, 15394254);
    public static final Item MUMMY_SPAWN_EGG = registerSpawnEggItem(Entities.MUMMY, 11572567, 5326381);
    public static final Item SCORCHED_CREEPER_SPAWN_EGG = registerSpawnEggItem(Entities.SCORCHED_CREEPER, 7497817, 15000247);
    public static final Item CRIMSON_SKELETON_SPAWN_EGG = registerSpawnEggItem(Entities.CRIMSON_SKELETON, 11439758, 11280416);
    public static final Item WARPED_SKELETON_SPAWN_EGG = registerSpawnEggItem(Entities.WARPED_SKELETON, 12909551, 1474182);
    public static final Item WILD_BOAR_SPAWN_EGG = registerSpawnEggItem(Entities.WILD_BOAR, 1971725, 4798503);

    private static SpawnEggItem registerSpawnEggItem(EntityType<? extends MobEntity> entityType, int primaryColor, int secondaryColor) {
        String entityName = retrieveEntityName(entityType);
        SpawnEggItem spawnEggItem = new SpawnEggItem(entityType, primaryColor, secondaryColor, new Item.Settings());
        log.debug("Registering spawn egg: " + entityName + "_spawn_egg");
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, entityName + "_spawn_egg"), spawnEggItem);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(content -> content.add(spawnEggItem));

        return spawnEggItem;
    }

    private static String retrieveEntityName(EntityType<? extends MobEntity> entityType) {
        String[] translationKeyList = entityType.getTranslationKey().split("\\.");

        return translationKeyList[translationKeyList.length - 1];
    }

    public static void registerItems() {
        log.info("Register items");
    }


}
