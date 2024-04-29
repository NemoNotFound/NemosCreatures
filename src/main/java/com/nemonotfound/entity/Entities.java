package com.nemonotfound.entity;

import com.nemonotfound.entity.mob.*;
import net.fabricmc.fabric.api.biome.v1.*;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnLocationTypes;
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
            EntityType.Builder.create(VenomousSkeletonEntity::new, SpawnGroup.MONSTER)
                    .dimensions(0.6f, 1.99f)
                    .build());
    public static final EntityType<VenomousSpiderEntity> VENOMOUS_SPIDER = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(MOD_ID, "venomous_spider"),
            EntityType.Builder.create(VenomousSpiderEntity::new, SpawnGroup.MONSTER)
                    .dimensions(0.8f, 0.6f)
                    .build());
    public static final EntityType<VenomousZombieEntity> VENOMOUS_ZOMBIE = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(MOD_ID, "venomous_zombie"),
            EntityType.Builder.create(VenomousZombieEntity::new, SpawnGroup.MONSTER)
                    .dimensions(0.6f, 1.95f)
                    .build());
    public static final EntityType<VenomousCreeperEntity> VENOMOUS_CREEPER = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(MOD_ID, "venomous_creeper"),
            EntityType.Builder.create(VenomousCreeperEntity::new, SpawnGroup.MONSTER)
                    .dimensions(0.6f, 1.7f)
                    .build());
    public static final EntityType<ScorchedSkeletonEntity> SCORCHED_SKELETON = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(MOD_ID, "scorched_skeleton"),
            EntityType.Builder.create(ScorchedSkeletonEntity::new, SpawnGroup.MONSTER)
                    .dimensions(0.6f, 1.99f)
                    .build());
    public static final EntityType<SandSpiderEntity> SAND_SPIDER = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(MOD_ID, "sand_spider"),
            EntityType.Builder.create(SandSpiderEntity::new, SpawnGroup.MONSTER)
                    .dimensions(0.4f, 0.2f)
                    .build());
    public static final EntityType<MummyEntity> MUMMY = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(MOD_ID, "mummy"),
            EntityType.Builder.create(MummyEntity::new, SpawnGroup.MONSTER)
                    .dimensions(0.6f, 1.95f)
                    .build());
    public static final EntityType<ScorchedCreeperEntity> SCORCHED_CREEPER = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(MOD_ID, "scorched_creeper"),
            EntityType.Builder.create(ScorchedCreeperEntity::new, SpawnGroup.MONSTER)
                    .dimensions(0.6f, 1.7f)
                    .build());
    public static final EntityType<CrimsonSkeletonEntity> CRIMSON_SKELETON = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(MOD_ID, "crimson_skeleton"),
            EntityType.Builder.create(CrimsonSkeletonEntity::new, SpawnGroup.MONSTER)
                    .dimensions(0.6f, 1.99f)
                    .build());
    public static final EntityType<WarpedSkeletonEntity> WARPED_SKELETON = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(MOD_ID, "warped_skeleton"),
            EntityType.Builder.create(WarpedSkeletonEntity::new, SpawnGroup.MONSTER)
                    .dimensions(0.6f, 1.99f)
                    .build());
    public static final EntityType<WildBoarEntity> WILD_BOAR = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(MOD_ID, "wild_boar"),
            EntityType.Builder.create(WildBoarEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.9f, 0.9f)
                    .build());

    public static void registerSpawnRestrictions() {
        SpawnRestriction.register(VENOMOUS_SKELETON, SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                HostileEntity::canSpawnInDark);
        SpawnRestriction.register(VENOMOUS_SPIDER, SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING,
                HostileEntity::canSpawnInDark);
        SpawnRestriction.register(VENOMOUS_ZOMBIE, SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                HostileEntity::canSpawnInDark);
        SpawnRestriction.register(VENOMOUS_CREEPER, SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                HostileEntity::canSpawnInDark);
        SpawnRestriction.register(SCORCHED_SKELETON, SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                HostileEntity::canSpawnInDark);
        SpawnRestriction.register(SAND_SPIDER, SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING,
                HostileEntity::canSpawnInDark);
        SpawnRestriction.register(MUMMY, SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                HostileEntity::canSpawnInDark);
        SpawnRestriction.register(SCORCHED_CREEPER, SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                HostileEntity::canSpawnInDark);
        SpawnRestriction.register(CRIMSON_SKELETON, SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                HostileEntity::canSpawnInDark);
        SpawnRestriction.register(WARPED_SKELETON, SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                HostileEntity::canSpawnInDark);
        SpawnRestriction.register(WILD_BOAR, SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                WildBoarEntity::canSpawn);
    }

    public static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(VENOMOUS_SKELETON, VenomousSkeletonEntity.createAbstractSkeletonAttributes());
        FabricDefaultAttributeRegistry.register(VENOMOUS_SPIDER, VenomousSpiderEntity.createJungleSpiderAttributes());
        FabricDefaultAttributeRegistry.register(VENOMOUS_ZOMBIE, VenomousZombieEntity.createZombieAttributes());
        FabricDefaultAttributeRegistry.register(VENOMOUS_CREEPER, VenomousCreeperEntity.createCreeperAttributes());
        FabricDefaultAttributeRegistry.register(SCORCHED_SKELETON, ScorchedSkeletonEntity.createAbstractSkeletonAttributes());
        FabricDefaultAttributeRegistry.register(SAND_SPIDER, SandSpiderEntity.createSandSpiderAttributes());
        FabricDefaultAttributeRegistry.register(MUMMY, MummyEntity.createMummyAttributes());
        FabricDefaultAttributeRegistry.register(SCORCHED_CREEPER, ScorchedCreeperEntity.createCreeperAttributes());
        FabricDefaultAttributeRegistry.register(CRIMSON_SKELETON, CrimsonSkeletonEntity.createAbstractSkeletonAttributes());
        FabricDefaultAttributeRegistry.register(WARPED_SKELETON, WarpedSkeletonEntity.createAbstractSkeletonAttributes());
        FabricDefaultAttributeRegistry.register(WILD_BOAR, WildBoarEntity.createBoarAttributes());
    }

    public static void replaceMobsForBiomes() {
        String skeletonKey = "entity.minecraft.skeleton";
        String spiderKey = "entity.minecraft.spider";
        String zombieKey = "entity.minecraft.zombie";
        String creeperKey = "entity.minecraft.creeper";

        Predicate<BiomeSelectionContext> jungle = BiomeSelectors.tag(BiomeTags.IS_JUNGLE);
        Predicate<BiomeSelectionContext> desert = BiomeSelectors.tag(BiomeTags.of("is_desert"));
        Predicate<BiomeSelectionContext> crimsonForest = BiomeSelectors.tag(BiomeTags.of("is_crimson_forest"));
        Predicate<BiomeSelectionContext> warpedForest = BiomeSelectors.tag(BiomeTags.of("is_warped_forest"));
        Predicate<BiomeSelectionContext> forest = BiomeSelectors.tag(BiomeTags.IS_FOREST);

        BiomeModifications.addSpawn(jungle, SpawnGroup.MONSTER, VENOMOUS_SKELETON, 100, 4, 4);
        BiomeModifications.addSpawn(jungle, SpawnGroup.MONSTER, VENOMOUS_SPIDER, 100, 4, 4);
        BiomeModifications.addSpawn(jungle, SpawnGroup.MONSTER, VENOMOUS_ZOMBIE, 95, 4, 4);
        BiomeModifications.addSpawn(jungle, SpawnGroup.MONSTER, VENOMOUS_CREEPER, 100, 4, 4);
        BiomeModifications.addSpawn(desert, SpawnGroup.MONSTER, SCORCHED_SKELETON, 100, 4, 4);
        BiomeModifications.addSpawn(desert, SpawnGroup.MONSTER, SAND_SPIDER, 100, 4, 4);
        BiomeModifications.addSpawn(desert, SpawnGroup.MONSTER, MUMMY, 100, 4, 4);
        BiomeModifications.addSpawn(desert, SpawnGroup.MONSTER, SCORCHED_CREEPER, 100, 4, 4);
        BiomeModifications.addSpawn(crimsonForest, SpawnGroup.MONSTER, CRIMSON_SKELETON, 40, 1, 1);
        BiomeModifications.addSpawn(warpedForest, SpawnGroup.MONSTER, WARPED_SKELETON, 60, 1, 1);
        BiomeModifications.addSpawn(forest, SpawnGroup.CREATURE, WILD_BOAR, 12, 2, 4);

        removeMobFromBiome(jungle, skeletonKey);
        removeMobFromBiome(jungle, spiderKey);
        removeMobFromBiome(jungle, zombieKey);
        removeMobFromBiome(jungle, creeperKey);
        removeMobFromBiome(desert, skeletonKey);
        removeMobFromBiome(desert, spiderKey);
        removeMobFromBiome(desert, zombieKey);
        removeMobFromBiome(desert, creeperKey);
    }

    private static void removeMobFromBiome(Predicate<BiomeSelectionContext> biomeSelection, String entityKey) {
        BiomeModification biomeModification = BiomeModifications.create(new Identifier(entityKey));

        biomeModification.add(ModificationPhase.REMOVALS, biomeSelection, context ->
                context.getSpawnSettings()
                        .removeSpawns(((spawnGroup, spawnEntry) -> spawnEntry.type.getTranslationKey().contains(entityKey))));

    }
}
