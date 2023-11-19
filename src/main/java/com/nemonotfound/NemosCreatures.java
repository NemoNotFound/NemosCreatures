package com.nemonotfound;

import com.nemonotfound.entity.mob.VenomousSpiderEntity;
import com.nemonotfound.entity.mob.VenomousSkeletonEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.util.Identifier;
import net.minecraft.world.Heightmap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Predicate;

public class NemosCreatures implements ModInitializer {

	public static final String MOD_ID = "nemos-creatures";
    public static final Logger log = LoggerFactory.getLogger(MOD_ID);
	public static final EntityType<VenomousSkeletonEntity> VENOMOUS_SKELETON = Registry.register(Registries.ENTITY_TYPE,
			new Identifier(MOD_ID, "venomous_skeleton"),
			FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, VenomousSkeletonEntity::new)
					.dimensions(EntityDimensions.fixed(0.6f, 1.99f))
					.build());
	public static final EntityType<VenomousSpiderEntity> VENOMOUS_SPIDER = Registry.register(Registries.ENTITY_TYPE,
			new Identifier(MOD_ID, "venomous_spider"),
			FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, VenomousSpiderEntity::new)
					.dimensions(EntityDimensions.fixed(0.8f, 0.6f))
					.build());

	public static final Item VENOMOUS_SKELETON_SPAWN_EGG = new SpawnEggItem(VENOMOUS_SKELETON, 0xC1C1C1, 5884716,
			new FabricItemSettings());
	public static final Item JUNGLE_SPIDER_SPAWN_EGG = new SpawnEggItem(VENOMOUS_SPIDER, 1657614, 11013646,
			new FabricItemSettings());


	@Override
	public void onInitialize() {
		log.info("Thanks for using Nemo's Creatures!!");

		SpawnRestriction.register(VENOMOUS_SKELETON, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				HostileEntity::canSpawnInDark);
		SpawnRestriction.register(VENOMOUS_SPIDER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING,
				HostileEntity::canSpawnInDark);
		replaceMobsForBiomes();
		registerItems();
		FabricDefaultAttributeRegistry.register(VENOMOUS_SKELETON, VenomousSkeletonEntity.createAbstractSkeletonAttributes());
		FabricDefaultAttributeRegistry.register(VENOMOUS_SPIDER, VenomousSpiderEntity.createJungleSpiderAttributes());
	}

	private void replaceMobsForBiomes() {
		Predicate<BiomeSelectionContext> biomeSelection = BiomeSelectors.tag(BiomeTags.IS_JUNGLE);
		String skeletonKey = "entity.minecraft.skeleton";
		String spiderKey = "entity.minecraft.spider";

		BiomeModifications.addSpawn(biomeSelection, SpawnGroup.MONSTER, VENOMOUS_SKELETON, 100, 4, 4);
		BiomeModifications.addSpawn(biomeSelection, SpawnGroup.MONSTER, VENOMOUS_SPIDER, 100, 4, 4);

		removeMobFromBiome(biomeSelection, skeletonKey);
		removeMobFromBiome(biomeSelection, spiderKey);
	}

    private void removeMobFromBiome(Predicate<BiomeSelectionContext> biomeSelection, String entityKey) {
		BiomeModification biomeModification = BiomeModifications.create(new Identifier(entityKey));

		biomeModification.add(ModificationPhase.REMOVALS, biomeSelection, context ->
				context.getSpawnSettings()
						.removeSpawns(((spawnGroup, spawnEntry) -> spawnEntry.type.getTranslationKey().contains(entityKey))));

	}

	private void registerItems() {
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "venomous_skeleton_spawn_egg"), VENOMOUS_SKELETON_SPAWN_EGG);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "venomous_spider_spawn_egg"), JUNGLE_SPIDER_SPAWN_EGG);

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(content -> content.add(VENOMOUS_SKELETON_SPAWN_EGG));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(content -> content.add(JUNGLE_SPIDER_SPAWN_EGG));
	}
}