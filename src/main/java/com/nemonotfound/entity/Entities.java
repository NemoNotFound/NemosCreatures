package com.nemonotfound.entity;

import com.nemonotfound.entity.mob.*;
import com.nemonotfound.entity.projectile.FireArrowEntity;
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
    public static final EntityType<ScorchedSkeletonEntity> SCORCHED_SKELETON = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(MOD_ID, "scorched_skeleton"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ScorchedSkeletonEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6f, 1.99f))
                    .build());
    public static final EntityType<SandSpiderEntity> SAND_SPIDER = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(MOD_ID, "sand_spider"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, SandSpiderEntity::new)
                    .dimensions(EntityDimensions.fixed(0.4f, 0.2f))
                    .build());
    public static final EntityType<MummyEntity> MUMMY = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(MOD_ID, "mummy"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, MummyEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6f, 1.95f))
                    .build());
    public static final EntityType<ScorchedCreeperEntity> SCORCHED_CREEPER = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(MOD_ID, "scorched_creeper"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ScorchedCreeperEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6f, 1.7f))
                    .build());
    public static final EntityType<CrimsonSkeletonEntity> CRIMSON_SKELETON = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(MOD_ID, "crimson_skeleton"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, CrimsonSkeletonEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6f, 1.99f))
                    .build());
    public static final EntityType<FireArrowEntity> FIRE_ARROW = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(MOD_ID, "fire_arrow"),
            FabricEntityTypeBuilder.<FireArrowEntity>create(SpawnGroup.MONSTER, FireArrowEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.5f))
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
        SpawnRestriction.register(SCORCHED_SKELETON, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                HostileEntity::canSpawnInDark);
        SpawnRestriction.register(SAND_SPIDER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING,
                HostileEntity::canSpawnInDark);
        SpawnRestriction.register(MUMMY, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                HostileEntity::canSpawnInDark);
        SpawnRestriction.register(SCORCHED_CREEPER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                HostileEntity::canSpawnInDark);
        SpawnRestriction.register(CRIMSON_SKELETON, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                HostileEntity::canSpawnInDark);
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
    }

    public static void replaceMobsForBiomes() {
        String skeletonKey = "entity.minecraft.skeleton";
        String spiderKey = "entity.minecraft.spider";
        String zombieKey = "entity.minecraft.zombie";
        String creeperKey = "entity.minecraft.creeper";

        Predicate<BiomeSelectionContext> jungle = BiomeSelectors.tag(BiomeTags.IS_JUNGLE);
        Predicate<BiomeSelectionContext> desert = BiomeSelectors.tag(BiomeTags.of("is_desert"));
        Predicate<BiomeSelectionContext> crimsonForest = BiomeSelectors.tag(BiomeTags.of("is_crimson_forest"));

        BiomeModifications.addSpawn(jungle, SpawnGroup.MONSTER, VENOMOUS_SKELETON, 100, 4, 4);
        BiomeModifications.addSpawn(jungle, SpawnGroup.MONSTER, VENOMOUS_SPIDER, 100, 4, 4);
        BiomeModifications.addSpawn(jungle, SpawnGroup.MONSTER, VENOMOUS_ZOMBIE, 95, 4, 4);
        BiomeModifications.addSpawn(jungle, SpawnGroup.MONSTER, VENOMOUS_CREEPER, 100, 4, 4);
        BiomeModifications.addSpawn(desert, SpawnGroup.MONSTER, SCORCHED_SKELETON, 100, 4, 4);
        BiomeModifications.addSpawn(desert, SpawnGroup.MONSTER, SAND_SPIDER, 100, 4, 4);
        BiomeModifications.addSpawn(desert, SpawnGroup.MONSTER, MUMMY, 100, 4, 4);
        BiomeModifications.addSpawn(desert, SpawnGroup.MONSTER, SCORCHED_CREEPER, 100, 4, 4);
        BiomeModifications.addSpawn(crimsonForest, SpawnGroup.MONSTER, CRIMSON_SKELETON, 40, 1, 1);

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
