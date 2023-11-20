package com.nemonotfound.entity;

import com.nemonotfound.entity.mob.VenomousCreeperEntity;
import com.nemonotfound.entity.mob.VenomousSkeletonEntity;
import com.nemonotfound.entity.mob.VenomousSpiderEntity;
import com.nemonotfound.entity.mob.VenomousZombieEntity;
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
    public static final EntityType<VenomousZombieEntity> VENOMOUS_ZOMBIE = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(MOD_ID, "venomous_zombie"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, VenomousZombieEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6f, 1.95f))
                    .build());
    public static final EntityType<VenomousCreeperEntity> VENOMOUS_CREEPER = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(MOD_ID, "venomous_creeper"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, VenomousCreeperEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6f, 1.7f))
                    .build());

    public static void registerSpawnRestrictions() {
        SpawnRestriction.register(VENOMOUS_SKELETON, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                HostileEntity::canSpawnInDark);
        SpawnRestriction.register(VENOMOUS_SPIDER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING,
                HostileEntity::canSpawnInDark);
        SpawnRestriction.register(VENOMOUS_ZOMBIE, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                HostileEntity::canSpawnInDark);
        SpawnRestriction.register(VENOMOUS_CREEPER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                HostileEntity::canSpawnInDark);
    }

    public static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(VENOMOUS_SKELETON, VenomousSkeletonEntity.createAbstractSkeletonAttributes());
        FabricDefaultAttributeRegistry.register(VENOMOUS_SPIDER, VenomousSpiderEntity.createJungleSpiderAttributes());
        FabricDefaultAttributeRegistry.register(VENOMOUS_ZOMBIE, VenomousZombieEntity.createZombieAttributes());
        FabricDefaultAttributeRegistry.register(VENOMOUS_CREEPER, VenomousZombieEntity.createZombieAttributes());
    }

    public static void replaceMobsForBiomes() {
        Predicate<BiomeSelectionContext> biomeSelection = BiomeSelectors.tag(BiomeTags.IS_JUNGLE);
        String skeletonKey = "entity.minecraft.skeleton";
        String spiderKey = "entity.minecraft.spider";
        String zombieKey = "entity.minecraft.zombie";
        String creeperKey = "entity.minecraft.creeper";

        BiomeModifications.addSpawn(biomeSelection, SpawnGroup.MONSTER, VENOMOUS_SKELETON, 100, 4, 4);
        BiomeModifications.addSpawn(biomeSelection, SpawnGroup.MONSTER, VENOMOUS_SPIDER, 100, 4, 4);
        BiomeModifications.addSpawn(biomeSelection, SpawnGroup.MONSTER, VENOMOUS_ZOMBIE, 95, 4, 4);
        BiomeModifications.addSpawn(biomeSelection, SpawnGroup.MONSTER, VENOMOUS_CREEPER, 100, 4, 4);

        removeMobFromBiome(biomeSelection, skeletonKey);
        removeMobFromBiome(biomeSelection, spiderKey);
        removeMobFromBiome(biomeSelection, zombieKey);
        removeMobFromBiome(biomeSelection, creeperKey);
    }

    private static void removeMobFromBiome(Predicate<BiomeSelectionContext> biomeSelection, String entityKey) {
        BiomeModification biomeModification = BiomeModifications.create(new Identifier(entityKey));

        biomeModification.add(ModificationPhase.REMOVALS, biomeSelection, context ->
                context.getSpawnSettings()
                        .removeSpawns(((spawnGroup, spawnEntry) -> spawnEntry.type.getTranslationKey().contains(entityKey))));

    }
}
