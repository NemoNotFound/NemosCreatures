package com.nemonotfound.nemos.creatures.item;

import com.nemonotfound.nemos.creatures.block.ModBlocks;
import com.nemonotfound.nemos.creatures.entity.ModEntityTypes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.BoneMealItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

import static com.nemonotfound.nemos.creatures.NemosCreatures.MOD_ID;
import static com.nemonotfound.nemos.creatures.NemosCreatures.log;

public class ModItems {

    public static final Item VENOMOUS_SKELETON_SPAWN_EGG = registerItem("venomous_skeleton_spawn_egg", createSpawnEggItem(ModEntityTypes.VENOMOUS_SKELETON));
    public static final Item VENOMOUS_SPIDER_SPAWN_EGG = registerItem("venomous_spider_spawn_egg", createSpawnEggItem(ModEntityTypes.VENOMOUS_SPIDER));
    public static final Item VENOMOUS_ZOMBIE_SPAWN_EGG = registerItem("venomous_zombie_spawn_egg", createSpawnEggItem(ModEntityTypes.VENOMOUS_ZOMBIE));
    public static final Item VENOMOUS_CREEPER_SPAWN_EGG = registerItem("venomous_creeper_spawn_egg", createSpawnEggItem(ModEntityTypes.VENOMOUS_CREEPER));
    public static final Item SCORCHED_SKELETON_SPAWN_EGG = registerItem("scorched_skeleton_spawn_egg", createSpawnEggItem(ModEntityTypes.SCORCHED_SKELETON));
    public static final Item SAND_SPIDER_SPAWN_EGG = registerItem("sand_spider_spawn_egg", createSpawnEggItem(ModEntityTypes.SAND_SPIDER));
    public static final Item MUMMY_SPAWN_EGG = registerItem("mummy_spawn_egg", createSpawnEggItem(ModEntityTypes.MUMMY));
    public static final Item SCORCHED_CREEPER_SPAWN_EGG = registerItem("scorched_creeper_spawn_egg", createSpawnEggItem(ModEntityTypes.SCORCHED_CREEPER));
    public static final Item CRIMSON_SKELETON_SPAWN_EGG = registerItem("crimson_skeleton_spawn_egg", createSpawnEggItem(ModEntityTypes.CRIMSON_SKELETON));
    public static final Item WARPED_SKELETON_SPAWN_EGG = registerItem("warped_skeleton_spawn_egg", createSpawnEggItem(ModEntityTypes.WARPED_SKELETON));
    public static final Item WILD_BOAR_SPAWN_EGG = registerItem("wild_boar_spawn_egg", createSpawnEggItem(ModEntityTypes.WILD_BOAR));
    public static final Item SNOWY_SKELETON_SPAWN_EGG = registerItem("snowy_skeleton_spawn_egg", createSpawnEggItem(ModEntityTypes.SNOWY_SKELETON));
    public static final Item SNOWY_PIG_SPAWN_EGG = registerItem("snowy_pig_spawn_egg", createSpawnEggItem(ModEntityTypes.SNOWY_PIG));
    public static final Item SNOWY_COW_SPAWN_EGG = registerItem("snowy_cow_spawn_egg", createSpawnEggItem(ModEntityTypes.SNOWY_COW));
    public static final Item SNOWY_SPIDER_SPAWN_EGG = registerItem("snowy_spider_spawn_egg", createSpawnEggItem(ModEntityTypes.SNOWY_SPIDER));
    public static final Item SNOW_SPIDER_SPAWN_EGG = registerItem("snow_spider_spawn_egg", createSpawnEggItem(ModEntityTypes.SNOW_SPIDER));
    public static final Item SNOWY_CREEPER_SPAWN_EGG = registerItem("snowy_creeper_spawn_egg", createSpawnEggItem(ModEntityTypes.SNOWY_CREEPER));
    public static final Item SNOWY_ZOMBIE_SPAWN_EGG = registerItem("snowy_zombie_spawn_egg", createSpawnEggItem(ModEntityTypes.SNOWY_ZOMBIE));
    public static final Item FROZEN_SKELETON_SPAWN_EGG = registerItem("frozen_skeleton_spawn_egg", createSpawnEggItem(ModEntityTypes.FROZEN_SKELETON));
    public static final Item FROZEN_CREEPER_SPAWN_EGG = registerItem("frozen_creeper_spawn_egg", createSpawnEggItem(ModEntityTypes.FROZEN_CREEPER));
    public static final Item FROZEN_SPIDER_SPAWN_EGG = registerItem("frozen_spider_spawn_egg", createSpawnEggItem(ModEntityTypes.FROZEN_SPIDER));
    public static final Item ICE_SPIDER_SPAWN_EGG = registerItem("ice_spider_spawn_egg", createSpawnEggItem(ModEntityTypes.ICE_SPIDER));
    public static final Item FROZEN_ZOMBIE_SPAWN_EGG = registerItem("frozen_zombie_spawn_egg", createSpawnEggItem(ModEntityTypes.FROZEN_ZOMBIE));
    public static final Item SAND_DUST = registerItem("sand_dust", Item::new);
    public static final Item SCORCHED_BONE = registerItem("scorched_bone", Item::new);
    public static final Item SCORCHED_BONE_MEAL = registerItem("scorched_bone_meal", BoneMealItem::new);
    public static final Item SCORCHED_BONE_BLOCK = Items.register(ModBlocks.SCORCHED_BONE_BLOCK);
    public static final Item CRIMSON_BONE = registerItem("crimson_bone", Item::new);
    public static final Item CRIMSON_BONE_MEAL = registerItem("crimson_bone_meal", BoneMealItem::new);
    public static final Item CRIMSON_BONE_BLOCK = Items.register(ModBlocks.CRIMSON_BONE_BLOCK);
    public static final Item WARPED_BONE = registerItem("warped_bone", Item::new);
    public static final Item WARPED_BONE_MEAL = registerItem("warped_bone_meal", BoneMealItem::new);
    public static final Item WARPED_BONE_BLOCK = Items.register(ModBlocks.WARPED_BONE_BLOCK);
    //TODO: Custom bone meal item

    public static void registerItems() {
        log.info("Register items");
    }

    private static Item registerItem(String path, Function<Item.Settings, Item> factory) {
        Identifier id = Identifier.of(MOD_ID, path);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);
        Item item = factory.apply(new Item.Settings().registryKey(key));

        return Registry.register(Registries.ITEM, key, item);
    }

    private static Function<Item.Settings, Item> createSpawnEggItem(EntityType<? extends MobEntity> entityType) {
        return settings -> new SpawnEggItem(entityType, settings);
    }
}
