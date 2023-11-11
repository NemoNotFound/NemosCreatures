package com.nemonotfound;

import com.nemonotfound.entity.mob.VenomEntity;
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
import net.minecraft.world.biome.SpawnSettings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Predicate;

public class NemosCreatures implements ModInitializer {

	public static final String MOD_ID = "nemos-creatures";
    public static final Logger log = LoggerFactory.getLogger(MOD_ID);

	public static final EntityType<VenomEntity> VENOM = Registry.register(Registries.ENTITY_TYPE,
			new Identifier(MOD_ID, "venom"),
			FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, VenomEntity::new)
					.dimensions(EntityDimensions.fixed(0.6f, 1.99f))
					.build());

	public static final Item VENOM_SPAWN_EGG = new SpawnEggItem(VENOM, 0xC1C1C1, 894731,
			new FabricItemSettings());


	@Override
	public void onInitialize() {
		log.info("Thanks for using Nemo's Creatures!!");

		SpawnRestriction.register(VENOM, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				HostileEntity::canSpawnInDark);
		replaceMobsForBiomes();
		registerItems();
		FabricDefaultAttributeRegistry.register(VENOM, VenomEntity.createAbstractSkeletonAttributes());
	}

	private void replaceMobsForBiomes() {
		Predicate<BiomeSelectionContext> biomeSelection = BiomeSelectors.tag(BiomeTags.IS_JUNGLE);

		BiomeModifications.addSpawn(biomeSelection, SpawnGroup.MONSTER, VENOM, 100, 4, 4);
		BiomeModification biomeModification = BiomeModifications.create(new Identifier("entity.minecraft.skeleton"));
		biomeModification.add(ModificationPhase.REMOVALS, biomeSelection, context ->
				context.getSpawnSettings().addSpawn(SpawnGroup.MONSTER,
						new SpawnSettings.SpawnEntry(VENOM, 100, 4, 4)));
	}

	private void registerItems() {
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "venom_spawn_egg"), VENOM_SPAWN_EGG);
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(content -> content.add(VENOM_SPAWN_EGG));
	}
}