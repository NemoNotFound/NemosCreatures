package com.nemonotfound.item;

import com.nemonotfound.entity.ModEntityTypes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

import static com.nemonotfound.NemosCreatures.MOD_ID;
import static com.nemonotfound.NemosCreatures.log;

public class ModItems {

    public static final Item VENOMOUS_SKELETON_SPAWN_EGG = registerItem("venomous_skeleton_spawn_egg", createSpawnEggItem(ModEntityTypes.VENOMOUS_SKELETON, 0xC1C1C1, 5884716));
    public static final Item VENOMOUS_SPIDER_SPAWN_EGG = registerItem("venomous_spider_spawn_egg", createSpawnEggItem(ModEntityTypes.VENOMOUS_SPIDER, 1657614, 11013646));
    public static final Item VENOMOUS_ZOMBIE_SPAWN_EGG = registerItem("venomous_zombie_spawn_egg", createSpawnEggItem(ModEntityTypes.VENOMOUS_ZOMBIE, 44975, 5884716));
    public static final Item VENOMOUS_CREEPER_SPAWN_EGG = registerItem("venomous_creeper_spawn_egg", createSpawnEggItem(ModEntityTypes.VENOMOUS_CREEPER, 894731, 87040));
    public static final Item SCORCHED_SKELETON_SPAWN_EGG = registerItem("scorched_skeleton_spawn_egg", createSpawnEggItem(ModEntityTypes.SCORCHED_SKELETON, 7497817, 5262145));
    public static final Item SAND_SPIDER_SPAWN_EGG = registerItem("sand_spider_spawn_egg", createSpawnEggItem(ModEntityTypes.SAND_SPIDER, 14009494, 15394254));
    public static final Item MUMMY_SPAWN_EGG = registerItem("mummy_spawn_egg", createSpawnEggItem(ModEntityTypes.MUMMY, 11572567, 5326381));
    public static final Item SCORCHED_CREEPER_SPAWN_EGG = registerItem("scorched_creeper_spawn_egg", createSpawnEggItem(ModEntityTypes.SCORCHED_CREEPER, 7497817, 15000247));
    public static final Item CRIMSON_SKELETON_SPAWN_EGG = registerItem("crimson_skeleton_spawn_egg", createSpawnEggItem(ModEntityTypes.CRIMSON_SKELETON, 11439758, 11280416));
    public static final Item WARPED_SKELETON_SPAWN_EGG = registerItem("warped_skeleton_spawn_egg", createSpawnEggItem(ModEntityTypes.WARPED_SKELETON, 12909551, 1474182));
    public static final Item WILD_BOAR_SPAWN_EGG = registerItem("wild_boar_spawn_egg", createSpawnEggItem(ModEntityTypes.WILD_BOAR, 1971725, 4798503));
    public static final Item SNOWY_SKELETON_SPAWN_EGG = registerItem("snowy_skeleton_spawn_egg", createSpawnEggItem(ModEntityTypes.SNOWY_SKELETON, 11388628, 16777215));
    public static final Item SNOWY_PIG_SPAWN_EGG = registerItem("snowy_pig_spawn_egg", createSpawnEggItem(ModEntityTypes.SNOWY_PIG, 15771042, 16777215));
    public static final Item SNOWY_COW_SPAWN_EGG = registerItem("snowy_cow_spawn_egg", createSpawnEggItem(ModEntityTypes.SNOWY_COW, 4470310, 16777215));
    public static final Item SNOWY_SPIDER_SPAWN_EGG = registerItem("snowy_spider_spawn_egg", createSpawnEggItem(ModEntityTypes.SNOWY_SPIDER, 3419431, 16777215));
    public static final Item SNOW_SPIDER_SPAWN_EGG = registerItem("snow_spider_spawn_egg", createSpawnEggItem(ModEntityTypes.SNOW_SPIDER, 16777215, 955560));
    public static final Item SNOWY_CREEPER_SPAWN_EGG = registerItem("snowy_creeper_spawn_egg", createSpawnEggItem(ModEntityTypes.SNOWY_CREEPER, 5856370, 16777215));
    public static final Item SNOWY_ZOMBIE_SPAWN_EGG = registerItem("snowy_zombie_spawn_egg", createSpawnEggItem(ModEntityTypes.SNOWY_ZOMBIE, 3565947, 16777215));
    public static final Item FROZEN_SKELETON_SPAWN_EGG = registerItem("frozen_skeleton_spawn_egg", createSpawnEggItem(ModEntityTypes.FROZEN_SKELETON, 6652326, 6658544));

    public static void registerItems() {
        log.info("Register items");
    }

    private static Item registerItem(String path, Function<Item.Settings, Item> factory) {
        Identifier id = Identifier.of(MOD_ID, path);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);
        Item item = factory.apply(new Item.Settings().registryKey(key));

        return Registry.register(Registries.ITEM, key, item);
    }

    private static Function<Item.Settings, Item> createSpawnEggItem(EntityType<? extends MobEntity> entityType, int primaryColor, int secondaryColor) {
        return settings -> new SpawnEggItem(entityType, primaryColor, secondaryColor, settings);
    }
}
