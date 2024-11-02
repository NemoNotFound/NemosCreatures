package com.nemonotfound.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;

import static com.nemonotfound.NemosCreatures.log;
import static com.nemonotfound.item.ModItems.*;
import static net.minecraft.item.Items.*;

public class ModItemGroups {

    public static void registerItemGroups() {
        log.info("Registering/modifying item groups");
        
        modifySpawnEggsItemGroup();
    }

    private static void modifySpawnEggsItemGroup() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(entries -> {
            entries.addAfter(CREEPER_SPAWN_EGG, CRIMSON_SKELETON_SPAWN_EGG);
            entries.addAfter(FROG_SPAWN_EGG, FROZEN_CREEPER_SPAWN_EGG);
            entries.addAfter(FROZEN_CREEPER_SPAWN_EGG, FROZEN_SKELETON_SPAWN_EGG);
            entries.addAfter(MULE_SPAWN_EGG, MUMMY_SPAWN_EGG);
            entries.addAfter(SALMON_SPAWN_EGG, SAND_SPIDER_SPAWN_EGG);
            entries.addAfter(SAND_SPIDER_SPAWN_EGG, SCORCHED_CREEPER_SPAWN_EGG);
            entries.addAfter(SCORCHED_CREEPER_SPAWN_EGG, SCORCHED_SKELETON_SPAWN_EGG);
            entries.addAfter(SNOW_GOLEM_SPAWN_EGG, SNOW_SPIDER_SPAWN_EGG);
            entries.addAfter(SNOW_SPIDER_SPAWN_EGG, SNOWY_COW_SPAWN_EGG);
            entries.addAfter(SNOWY_COW_SPAWN_EGG, SNOWY_CREEPER_SPAWN_EGG);
            entries.addAfter(SNOWY_CREEPER_SPAWN_EGG, SNOWY_PIG_SPAWN_EGG);
            entries.addAfter(SNOWY_PIG_SPAWN_EGG, SNOWY_SKELETON_SPAWN_EGG);
            entries.addAfter(SNOWY_SKELETON_SPAWN_EGG, SNOWY_SPIDER_SPAWN_EGG);
            entries.addAfter(SNOWY_SPIDER_SPAWN_EGG, SNOWY_ZOMBIE_SPAWN_EGG);
            entries.addAfter(TURTLE_SPAWN_EGG, VENOMOUS_CREEPER_SPAWN_EGG);
            entries.addAfter(VENOMOUS_CREEPER_SPAWN_EGG, VENOMOUS_SKELETON_SPAWN_EGG);
            entries.addAfter(VENOMOUS_SKELETON_SPAWN_EGG, VENOMOUS_SPIDER_SPAWN_EGG);
            entries.addAfter(VENOMOUS_SPIDER_SPAWN_EGG, VENOMOUS_ZOMBIE_SPAWN_EGG);
            entries.addAfter(WARDEN_SPAWN_EGG, WARPED_SKELETON_SPAWN_EGG);
            entries.addAfter(WARPED_SKELETON_SPAWN_EGG, WILD_BOAR_SPAWN_EGG);
        });
    }
}
