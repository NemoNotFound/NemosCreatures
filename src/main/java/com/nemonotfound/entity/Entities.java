package com.nemonotfound.entity;

import com.nemonotfound.entity.mob.VenomousSkeletonEntity;
import com.nemonotfound.entity.mob.VenomousSpiderEntity;
import net.fabricmc.fabric.api.biome.v1.*;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.util.Identifier;
import net.minecraft.world.Heightmap;

import java.util.function.Predicate;

import static com.nemonotfound.NemosCreatures.MOD_ID;

public class Entities {

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

    public static void registerSpawnRestrictions() {
        SpawnRestriction.register(VENOMOUS_SKELETON, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                HostileEntity::canSpawnInDark);
        SpawnRestriction.register(VENOMOUS_SPIDER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING,
                HostileEntity::canSpawnInDark);
    }

    public static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(VENOMOUS_SKELETON, VenomousSkeletonEntity.createAbstractSkeletonAttributes());
        FabricDefaultAttributeRegistry.register(VENOMOUS_SPIDER, VenomousSpiderEntity.createJungleSpiderAttributes());
    }

    public static void replaceMobsForBiomes() {
        Predicate<BiomeSelectionContext> biomeSelection = BiomeSelectors.tag(BiomeTags.IS_JUNGLE);
        String skeletonKey = "entity.minecraft.skeleton";
        String spiderKey = "entity.minecraft.spider";

        BiomeModifications.addSpawn(biomeSelection, SpawnGroup.MONSTER, VENOMOUS_SKELETON, 100, 4, 4);
        BiomeModifications.addSpawn(biomeSelection, SpawnGroup.MONSTER, VENOMOUS_SPIDER, 100, 4, 4);

        removeMobFromBiome(biomeSelection, skeletonKey);
        removeMobFromBiome(biomeSelection, spiderKey);
    }

    private static void removeMobFromBiome(Predicate<BiomeSelectionContext> biomeSelection, String entityKey) {
        BiomeModification biomeModification = BiomeModifications.create(new Identifier(entityKey));

        biomeModification.add(ModificationPhase.REMOVALS, biomeSelection, context ->
                context.getSpawnSettings()
                        .removeSpawns(((spawnGroup, spawnEntry) -> spawnEntry.type.getTranslationKey().contains(entityKey))));

    }
}
