package com.nemonotfound.entity;

import com.nemonotfound.entity.mob.*;
import com.nemonotfound.registry.tag.ModBiomeTags;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.*;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.util.Identifier;
import net.minecraft.world.Heightmap;

import java.util.function.Predicate;

import static com.nemonotfound.NemosCreatures.MOD_ID;

public class ModEntityTypes {

    public static final EntityType<VenomousSkeletonEntity> VENOMOUS_SKELETON = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MOD_ID, "venomous_skeleton"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, VenomousSkeletonEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6f, 1.99f))
                    .build());
    public static final EntityType<VenomousSpiderEntity> VENOMOUS_SPIDER = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MOD_ID, "venomous_spider"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, VenomousSpiderEntity::new)
                    .dimensions(EntityDimensions.fixed(0.8f, 0.6f))
                    .build());
    public static final EntityType<VenomousZombieEntity> VENOMOUS_ZOMBIE = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MOD_ID, "venomous_zombie"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, VenomousZombieEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6f, 1.95f))
                    .build());
    public static final EntityType<VenomousCreeperEntity> VENOMOUS_CREEPER = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MOD_ID, "venomous_creeper"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, VenomousCreeperEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6f, 1.7f))
                    .build());
    public static final EntityType<ScorchedSkeletonEntity> SCORCHED_SKELETON = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MOD_ID, "scorched_skeleton"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ScorchedSkeletonEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6f, 1.99f))
                    .build());
    public static final EntityType<SandSpiderEntity> SAND_SPIDER = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MOD_ID, "sand_spider"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, SandSpiderEntity::new)
                    .dimensions(EntityDimensions.fixed(0.4f, 0.2f))
                    .build());
    public static final EntityType<MummyEntity> MUMMY = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MOD_ID, "mummy"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, MummyEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6f, 1.95f))
                    .build());
    public static final EntityType<ScorchedCreeperEntity> SCORCHED_CREEPER = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MOD_ID, "scorched_creeper"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ScorchedCreeperEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6f, 1.7f))
                    .build());
    public static final EntityType<CrimsonSkeletonEntity> CRIMSON_SKELETON = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MOD_ID, "crimson_skeleton"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, CrimsonSkeletonEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6f, 1.99f))
                    .build());
    public static final EntityType<WarpedSkeletonEntity> WARPED_SKELETON = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MOD_ID, "warped_skeleton"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, WarpedSkeletonEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6f, 1.99f))
                    .build());
    public static final EntityType<WildBoarEntity> WILD_BOAR = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MOD_ID, "wild_boar"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, WildBoarEntity::new)
                    .dimensions(EntityDimensions.fixed(0.9f, 0.9f))
                    .build());
    public static final EntityType<SnowySkeletonEntity> SNOWY_SKELETON = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MOD_ID, "snowy_skeleton"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, SnowySkeletonEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6f, 1.99f))
                    .build());
    public static final EntityType<SnowySpiderEntity> SNOWY_SPIDER = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MOD_ID, "snowy_spider"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, SnowySpiderEntity::new)
                    .dimensions(EntityDimensions.fixed(1.4F, 0.9F))
                    .build());
    public static final EntityType<SnowSpiderEntity> SNOW_SPIDER = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MOD_ID, "snow_spider"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, SnowSpiderEntity::new)
                    .dimensions(EntityDimensions.fixed(0.4f, 0.2f))
                    .build());
    public static final EntityType<SnowyCreeperEntity> SNOWY_CREEPER = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MOD_ID, "snowy_creeper"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, SnowyCreeperEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6f, 1.7f))
                    .build());
    public static final EntityType<SnowyZombieEntity> SNOWY_ZOMBIE = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MOD_ID, "snowy_zombie"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, SnowyZombieEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6f, 1.95f))
                    .build());
    public static final EntityType<SnowyPigEntity> SNOWY_PIG = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MOD_ID, "snowy_pig"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, SnowyPigEntity::new)
                    .dimensions(EntityDimensions.fixed(0.9f, 0.9f))
                    .build());
    public static final EntityType<SnowyCowEntity> SNOWY_COW = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MOD_ID, "snowy_cow"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, SnowyCowEntity::new)
                    .dimensions(EntityDimensions.fixed(0.9f, 1.4f))
                    .build());
    public static final EntityType<FrozenSkeletonEntity> FROZEN_SKELETON = registerEntityType("frozen_skeleton",
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, FrozenSkeletonEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6f, 1.99f)));
    public static final EntityType<FrozenCreeperEntity> FROZEN_CREEPER = registerEntityType("frozen_creeper",
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, FrozenCreeperEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6f, 1.7f)));
    public static final EntityType<FrozenSpiderEntity> FROZEN_SPIDER = registerEntityType("frozen_spider",
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, FrozenSpiderEntity::new)
                    .dimensions(EntityDimensions.fixed(1.4F, 0.9F)));
    public static final EntityType<IceSpiderEntity> ICE_SPIDER = registerEntityType("ice_spider",
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, IceSpiderEntity::new)
                    .dimensions(EntityDimensions.fixed(0.4f, 0.2f)));
    public static final EntityType<FrozenZombieEntity> FROZEN_ZOMBIE = registerEntityType("frozen_zombie",
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, FrozenZombieEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6f, 1.95f)));

    public static <T extends Entity> EntityType<T> registerEntityType(String path, FabricEntityTypeBuilder<T> entityTypeBuilder) {
        return Registry.register(Registries.ENTITY_TYPE, Identifier.of(MOD_ID, path), entityTypeBuilder.build());
    }

    public static void registerSpawnRestrictions() {
        SpawnRestriction.register(VENOMOUS_SKELETON, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
        SpawnRestriction.register(VENOMOUS_SPIDER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING, HostileEntity::canSpawnInDark);
        SpawnRestriction.register(VENOMOUS_ZOMBIE, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
        SpawnRestriction.register(VENOMOUS_CREEPER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
        SpawnRestriction.register(SCORCHED_SKELETON, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
        SpawnRestriction.register(SAND_SPIDER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING, HostileEntity::canSpawnInDark);
        SpawnRestriction.register(MUMMY, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
        SpawnRestriction.register(SCORCHED_CREEPER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
        SpawnRestriction.register(CRIMSON_SKELETON, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
        SpawnRestriction.register(WARPED_SKELETON, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
        SpawnRestriction.register(WILD_BOAR, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, WildBoarEntity::canSpawn);
        SpawnRestriction.register(SNOWY_SKELETON, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
        SpawnRestriction.register(SNOWY_PIG, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);
        SpawnRestriction.register(SNOWY_COW, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);
        SpawnRestriction.register(SNOWY_SPIDER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING, HostileEntity::canSpawnInDark);
        SpawnRestriction.register(SNOW_SPIDER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING, HostileEntity::canSpawnInDark);
        SpawnRestriction.register(SNOWY_CREEPER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING, HostileEntity::canSpawnInDark);
        SpawnRestriction.register(SNOWY_ZOMBIE, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
        SpawnRestriction.register(FROZEN_SKELETON, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
        SpawnRestriction.register(FROZEN_CREEPER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING, HostileEntity::canSpawnInDark);
        SpawnRestriction.register(FROZEN_SPIDER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING, HostileEntity::canSpawnInDark);
        SpawnRestriction.register(ICE_SPIDER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING, HostileEntity::canSpawnInDark);
        SpawnRestriction.register(FROZEN_ZOMBIE, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
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
        FabricDefaultAttributeRegistry.register(SNOWY_SKELETON, SnowySkeletonEntity.createAbstractSkeletonAttributes());
        FabricDefaultAttributeRegistry.register(SNOWY_PIG, SnowyPigEntity.createPigAttributes());
        FabricDefaultAttributeRegistry.register(SNOWY_COW, SnowyCowEntity.createCowAttributes());
        FabricDefaultAttributeRegistry.register(SNOWY_SPIDER, SnowySpiderEntity.createSpiderAttributes());
        FabricDefaultAttributeRegistry.register(SNOW_SPIDER, SnowSpiderEntity.createSnowSpiderAttributes());
        FabricDefaultAttributeRegistry.register(SNOWY_CREEPER, SnowyCreeperEntity.createCreeperAttributes());
        FabricDefaultAttributeRegistry.register(SNOWY_ZOMBIE, SnowyZombieEntity.createZombieAttributes());
        FabricDefaultAttributeRegistry.register(FROZEN_SKELETON, FrozenSkeletonEntity.createFrozenSkeletonAttributes());
        FabricDefaultAttributeRegistry.register(FROZEN_CREEPER, FrozenCreeperEntity.createCreeperAttributes());
        FabricDefaultAttributeRegistry.register(FROZEN_SPIDER, FrozenSpiderEntity.createSpiderAttributes());
        FabricDefaultAttributeRegistry.register(ICE_SPIDER, IceSpiderEntity.createIceSpiderAttributes());
        FabricDefaultAttributeRegistry.register(FROZEN_ZOMBIE, FrozenZombieEntity.createZombieAttributes());
    }

    public static void addMobsToBiome() {
        Predicate<BiomeSelectionContext> jungle = BiomeSelectors.tag(BiomeTags.IS_JUNGLE);
        Predicate<BiomeSelectionContext> desert = BiomeSelectors.tag(BiomeTags.of("is_desert"));
        Predicate<BiomeSelectionContext> crimsonForest = BiomeSelectors.tag(ModBiomeTags.IS_CRIMSON_FOREST);
        Predicate<BiomeSelectionContext> warpedForest = BiomeSelectors.tag(ModBiomeTags.IS_WARPED_FOREST);
        Predicate<BiomeSelectionContext> forest = BiomeSelectors.tag(BiomeTags.IS_FOREST);
        Predicate<BiomeSelectionContext> snowy = BiomeSelectors.tag(ModBiomeTags.IS_SNOWY);
        Predicate<BiomeSelectionContext> snowyTaiga = BiomeSelectors.tag(ModBiomeTags.IS_SNOWY_TAIGA);
        Predicate<BiomeSelectionContext> icy = BiomeSelectors.tag(ModBiomeTags.IS_ICY);

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
        BiomeModifications.addSpawn(snowy, SpawnGroup.MONSTER, SNOWY_SKELETON, 100, 4, 4);
        BiomeModifications.addSpawn(snowy, SpawnGroup.MONSTER, SNOWY_SPIDER, 100, 4, 4);
        BiomeModifications.addSpawn(snowy, SpawnGroup.MONSTER, SNOW_SPIDER, 100, 4, 4);
        BiomeModifications.addSpawn(snowy, SpawnGroup.MONSTER, SNOWY_CREEPER, 100, 4, 4);
        BiomeModifications.addSpawn(snowy, SpawnGroup.MONSTER, SNOWY_ZOMBIE, 95, 4, 4);
        BiomeModifications.addSpawn(snowyTaiga, SpawnGroup.CREATURE, SNOWY_PIG, 10, 4, 4);
        BiomeModifications.addSpawn(snowyTaiga, SpawnGroup.CREATURE, SNOWY_COW, 8, 4, 4);
        BiomeModifications.addSpawn(icy, SpawnGroup.MONSTER, FROZEN_SKELETON, 80, 4, 4);
        BiomeModifications.addSpawn(icy, SpawnGroup.MONSTER, FROZEN_CREEPER, 100, 4, 4);
        BiomeModifications.addSpawn(icy, SpawnGroup.MONSTER, FROZEN_SPIDER, 100, 4, 4);
        BiomeModifications.addSpawn(icy, SpawnGroup.MONSTER, ICE_SPIDER, 80, 4, 4);
        BiomeModifications.addSpawn(icy, SpawnGroup.MONSTER, FROZEN_ZOMBIE, 95, 4, 4);
    }
}
