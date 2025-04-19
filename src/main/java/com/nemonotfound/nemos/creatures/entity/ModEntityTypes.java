package com.nemonotfound.nemos.creatures.entity;

import com.nemonotfound.nemos.creatures.entity.mob.*;
import com.nemonotfound.nemos.creatures.registry.tag.ModBiomeTags;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBiomeTags;
import net.minecraft.entity.*;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.Heightmap;

import java.util.function.Predicate;

import static com.nemonotfound.nemos.creatures.NemosCreatures.MOD_ID;

public class ModEntityTypes {

    public static final EntityType<VenomousSkeletonEntity> VENOMOUS_SKELETON = registerEntityType("venomous_skeleton",
            EntityType.Builder.create(VenomousSkeletonEntity::new, SpawnGroup.MONSTER)
                    .dimensions(0.6f, 1.99f));
    public static final EntityType<VenomousSpiderEntity> VENOMOUS_SPIDER = registerEntityType("venomous_spider",
            EntityType.Builder.create(VenomousSpiderEntity::new, SpawnGroup.MONSTER)
                    .dimensions(0.8f, 0.6f));
    public static final EntityType<VenomousZombieEntity> VENOMOUS_ZOMBIE = registerEntityType("venomous_zombie",
            EntityType.Builder.create(VenomousZombieEntity::new, SpawnGroup.MONSTER)
                    .dimensions(0.6f, 1.95f));
    public static final EntityType<VenomousCreeperEntity> VENOMOUS_CREEPER = registerEntityType("venomous_creeper",
            EntityType.Builder.create(VenomousCreeperEntity::new, SpawnGroup.MONSTER)
                    .dimensions(0.6f, 1.7f));
    public static final EntityType<ScorchedSkeletonEntity> SCORCHED_SKELETON = registerEntityType("scorched_skeleton",
            EntityType.Builder.create(ScorchedSkeletonEntity::new, SpawnGroup.MONSTER)
                    .dimensions(0.6f, 1.99f));
    public static final EntityType<SandSpiderEntity> SAND_SPIDER = registerEntityType("sand_spider",
            EntityType.Builder.create(SandSpiderEntity::new, SpawnGroup.MONSTER)
                    .dimensions(0.4f, 0.2f));
    public static final EntityType<MummyEntity> MUMMY = registerEntityType("mummy",
            EntityType.Builder.create(MummyEntity::new, SpawnGroup.MONSTER)
                    .dimensions(0.6f, 1.95f));
    public static final EntityType<ScorchedCreeperEntity> SCORCHED_CREEPER = registerEntityType("scorched_creeper",
            EntityType.Builder.create(ScorchedCreeperEntity::new, SpawnGroup.MONSTER)
                    .dimensions(0.6f, 1.7f));
    public static final EntityType<CrimsonSkeletonEntity> CRIMSON_SKELETON = registerEntityType("crimson_skeleton",
            EntityType.Builder.create(CrimsonSkeletonEntity::new, SpawnGroup.MONSTER)
                    .dimensions(0.6f, 1.99f));
    public static final EntityType<WarpedSkeletonEntity> WARPED_SKELETON = registerEntityType("warped_skeleton",
            EntityType.Builder.create(WarpedSkeletonEntity::new, SpawnGroup.MONSTER)
                    .dimensions(0.6f, 1.99f));
    public static final EntityType<WildBoarEntity> WILD_BOAR = registerEntityType("wild_boar",
            EntityType.Builder.create(WildBoarEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.9f, 0.9f));
    public static final EntityType<SnowySkeletonEntity> SNOWY_SKELETON = registerEntityType("snowy_skeleton",
            EntityType.Builder.create(SnowySkeletonEntity::new, SpawnGroup.MONSTER)
                    .dimensions(0.6f, 1.99f));
    public static final EntityType<SnowySpiderEntity> SNOWY_SPIDER = registerEntityType("snowy_spider",
            EntityType.Builder.create(SnowySpiderEntity::new, SpawnGroup.MONSTER)
                    .dimensions(1.4F, 0.9F)
                    .eyeHeight(0.65F)
                    .passengerAttachments(0.765F)
                    .maxTrackingRange(8));
    public static final EntityType<SnowSpiderEntity> SNOW_SPIDER = registerEntityType("snow_spider",
            EntityType.Builder.create(SnowSpiderEntity::new, SpawnGroup.MONSTER)
                    .dimensions(0.4f, 0.2f));
    public static final EntityType<SnowyCreeperEntity> SNOWY_CREEPER = registerEntityType("snowy_creeper",
            EntityType.Builder.create(SnowyCreeperEntity::new, SpawnGroup.MONSTER)
                    .dimensions(0.6f, 1.7f));
    public static final EntityType<SnowyZombieEntity> SNOWY_ZOMBIE = registerEntityType("snowy_zombie",
            EntityType.Builder.create(SnowyZombieEntity::new, SpawnGroup.MONSTER)
                    .dimensions(0.6f, 1.95f));
    public static final EntityType<SnowyPigEntity> SNOWY_PIG = registerEntityType("snowy_pig",
            EntityType.Builder.create(SnowyPigEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.9f, 0.9f)
                    .passengerAttachments(0.86875f)
                    .maxTrackingRange(10));
    public static final EntityType<SnowyCowEntity> SNOWY_COW =  registerEntityType("snowy_cow",
            EntityType.Builder.create(SnowyCowEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.9f, 1.4f)
                    .eyeHeight(1.3f)
                    .passengerAttachments(1.36875f)
                    .maxTrackingRange(10));
    public static final EntityType<FrozenSkeletonEntity> FROZEN_SKELETON = registerEntityType("frozen_skeleton",
            EntityType.Builder.create(FrozenSkeletonEntity::new, SpawnGroup.MONSTER)
                    .dimensions(0.6f, 1.99f));
    public static final EntityType<FrozenCreeperEntity> FROZEN_CREEPER = registerEntityType("frozen_creeper",
            EntityType.Builder.create(FrozenCreeperEntity::new, SpawnGroup.MONSTER)
                    .dimensions(0.6f, 1.7f));
    public static final EntityType<FrozenSpiderEntity> FROZEN_SPIDER = registerEntityType("frozen_spider",
            EntityType.Builder.create(FrozenSpiderEntity::new, SpawnGroup.MONSTER)
                    .dimensions(1.4F, 0.9F)
                    .eyeHeight(0.65F)
                    .passengerAttachments(0.765F)
                    .maxTrackingRange(8));
    public static final EntityType<IceSpiderEntity> ICE_SPIDER = registerEntityType("ice_spider",
            EntityType.Builder.create(IceSpiderEntity::new, SpawnGroup.MONSTER)
                    .dimensions(0.4f, 0.2f));
    public static final EntityType<FrozenZombieEntity> FROZEN_ZOMBIE = registerEntityType("frozen_zombie",
            EntityType.Builder.create(FrozenZombieEntity::new, SpawnGroup.MONSTER)
                    .dimensions(0.6f, 1.95f));

    public static <T extends Entity> EntityType<T> registerEntityType(String path, EntityType.Builder<T> entityTypeBuilder) {
        Identifier id = Identifier.of(MOD_ID, path);
        RegistryKey<EntityType<?>> key = RegistryKey.of(RegistryKeys.ENTITY_TYPE, id);

        return Registry.register(Registries.ENTITY_TYPE, key, entityTypeBuilder.build(key));
    }

    public static void registerSpawnRestrictions() {
        SpawnRestriction.register(VENOMOUS_SKELETON, SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
        SpawnRestriction.register(VENOMOUS_SPIDER, SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING, HostileEntity::canSpawnInDark);
        SpawnRestriction.register(VENOMOUS_ZOMBIE, SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
        SpawnRestriction.register(VENOMOUS_CREEPER, SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
        SpawnRestriction.register(SCORCHED_SKELETON, SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
        SpawnRestriction.register(SAND_SPIDER, SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING, HostileEntity::canSpawnInDark);
        SpawnRestriction.register(MUMMY, SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
        SpawnRestriction.register(SCORCHED_CREEPER, SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
        SpawnRestriction.register(CRIMSON_SKELETON, SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
        SpawnRestriction.register(WARPED_SKELETON, SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
        SpawnRestriction.register(WILD_BOAR, SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, WildBoarEntity::canSpawn);
        SpawnRestriction.register(SNOWY_SKELETON, SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
        SpawnRestriction.register(SNOWY_PIG, SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);
        SpawnRestriction.register(SNOWY_COW, SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);
        SpawnRestriction.register(SNOWY_SPIDER, SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING, HostileEntity::canSpawnInDark);
        SpawnRestriction.register(SNOW_SPIDER, SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING, HostileEntity::canSpawnInDark);
        SpawnRestriction.register(SNOWY_CREEPER, SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING, HostileEntity::canSpawnInDark);
        SpawnRestriction.register(SNOWY_ZOMBIE, SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
        SpawnRestriction.register(FROZEN_SKELETON, SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
        SpawnRestriction.register(FROZEN_CREEPER, SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING, HostileEntity::canSpawnInDark);
        SpawnRestriction.register(FROZEN_SPIDER, SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING, HostileEntity::canSpawnInDark);
        SpawnRestriction.register(ICE_SPIDER, SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING, HostileEntity::canSpawnInDark);
        SpawnRestriction.register(FROZEN_ZOMBIE, SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
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
        Predicate<BiomeSelectionContext> jungle = BiomeSelectors.tag(ConventionalBiomeTags.IS_JUNGLE);
        Predicate<BiomeSelectionContext> desert = BiomeSelectors.tag(ConventionalBiomeTags.IS_DESERT);
        Predicate<BiomeSelectionContext> crimsonForest = BiomeSelectors.tag(ModBiomeTags.IS_CRIMSON_FOREST);
        Predicate<BiomeSelectionContext> warpedForest = BiomeSelectors.tag(ModBiomeTags.IS_WARPED_FOREST);
        Predicate<BiomeSelectionContext> forest = BiomeSelectors.tag(ConventionalBiomeTags.IS_FOREST);
        Predicate<BiomeSelectionContext> snowy = BiomeSelectors.tag(ConventionalBiomeTags.IS_SNOWY);
        Predicate<BiomeSelectionContext> snowyTaiga = BiomeSelectors.tag(ModBiomeTags.IS_SNOWY_TAIGA);
        Predicate<BiomeSelectionContext> icy = BiomeSelectors.tag(ConventionalBiomeTags.IS_ICY);

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
