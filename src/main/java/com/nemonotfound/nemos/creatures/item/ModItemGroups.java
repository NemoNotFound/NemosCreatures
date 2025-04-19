package com.nemonotfound.nemos.creatures.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static com.nemonotfound.nemos.creatures.NemosCreatures.MOD_ID;
import static com.nemonotfound.nemos.creatures.NemosCreatures.log;
import static com.nemonotfound.nemos.creatures.item.ModItems.*;

public class ModItemGroups {

    public static final RegistryKey<ItemGroup> NEMOS_CREATURES_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(MOD_ID, "nemos_creatures"));
    public static final ItemGroup NEMOS_CREATURES = FabricItemGroup.builder()
            .icon(() -> new ItemStack(SCORCHED_CREEPER_SPAWN_EGG))
            .displayName(Text.translatable("itemGroup.nemos_creatures"))
            .build();

    public static void registerItemGroups() {
        log.info("Registering item groups");

        Registry.register(Registries.ITEM_GROUP, NEMOS_CREATURES_KEY, NEMOS_CREATURES);

        modifySpawnEggsItemGroup();
    }

    private static void modifySpawnEggsItemGroup() {
        ItemGroupEvents.modifyEntriesEvent(NEMOS_CREATURES_KEY)
                .register(entries -> {
                    entries.add(CRIMSON_SKELETON_SPAWN_EGG);
                    entries.add(FROZEN_CREEPER_SPAWN_EGG);
                    entries.add(FROZEN_SKELETON_SPAWN_EGG);
                    entries.add(FROZEN_SPIDER_SPAWN_EGG);
                    entries.add(FROZEN_ZOMBIE_SPAWN_EGG);
                    entries.add(ICE_SPIDER_SPAWN_EGG);
                    entries.add(MUMMY_SPAWN_EGG);
                    entries.add(SAND_SPIDER_SPAWN_EGG);
                    entries.add(SCORCHED_CREEPER_SPAWN_EGG);
                    entries.add(SCORCHED_SKELETON_SPAWN_EGG);
                    entries.add(SNOW_SPIDER_SPAWN_EGG);
                    entries.add(SNOWY_COW_SPAWN_EGG);
                    entries.add(SNOWY_CREEPER_SPAWN_EGG);
                    entries.add(SNOWY_PIG_SPAWN_EGG);
                    entries.add(SNOWY_SKELETON_SPAWN_EGG);
                    entries.add(SNOWY_SPIDER_SPAWN_EGG);
                    entries.add(SNOWY_ZOMBIE_SPAWN_EGG);
                    entries.add(VENOMOUS_CREEPER_SPAWN_EGG);
                    entries.add(VENOMOUS_SKELETON_SPAWN_EGG);
                    entries.add(VENOMOUS_SPIDER_SPAWN_EGG);
                    entries.add(VENOMOUS_ZOMBIE_SPAWN_EGG);
                    entries.add(WARPED_SKELETON_SPAWN_EGG);
                    entries.add(WILD_BOAR_SPAWN_EGG);
                    entries.add(SAND_DUST);
                    entries.add(SCORCHED_BONE);
                    entries.add(SCORCHED_BONE_MEAL);
                    entries.add(SCORCHED_BONE_BLOCK);
                    entries.add(CRIMSON_BONE);
                    entries.add(CRIMSON_BONE_MEAL);
                    entries.add(CRIMSON_BONE_BLOCK);
                    entries.add(WARPED_BONE);
                    entries.add(WARPED_BONE_MEAL);
                    entries.add(WARPED_BONE_BLOCK);
                });
    }
}
