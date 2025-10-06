package com.nemonotfound.nemos.creatures.datagen;

import com.nemonotfound.nemos.creatures.entity.CreaturesEntityTypes;
import com.nemonotfound.nemos.creatures.item.CreaturesItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricEntityLootTableProvider;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.EntityPropertiesLootCondition;
import net.minecraft.loot.condition.KilledByPlayerLootCondition;
import net.minecraft.loot.condition.RandomChanceWithEnchantedBonusLootCondition;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.entry.TagEntry;
import net.minecraft.loot.function.EnchantedCountIncreaseLootFunction;
import net.minecraft.loot.function.FurnaceSmeltLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.function.SetPotionLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.EntityTypeTags;
import net.minecraft.registry.tag.ItemTags;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class EntityLootTableProvider extends FabricEntityLootTableProvider {

    public EntityLootTableProvider(FabricDataOutput output, @NotNull CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generate() {
        RegistryEntryLookup<EntityType<?>> entityTypeRegistryEntryLookup = this.registries.getOrThrow(RegistryKeys.ENTITY_TYPE);

        this.register(
                CreaturesEntityTypes.SCORCHED_SKELETON,
                LootTable.builder()
                        .pool(
                                LootPool.builder()
                                        .rolls(ConstantLootNumberProvider.create(1.0F))
                                        .with(itemEntryBuilder(Items.ARROW))
                        )
                        .pool(
                                LootPool.builder()
                                        .rolls(ConstantLootNumberProvider.create(1.0F))
                                        .with(itemEntryBuilder(CreaturesItems.SCORCHED_BONE))
                        )
        );

        this.register(
                CreaturesEntityTypes.CRIMSON_SKELETON,
                LootTable.builder()
                        .pool(
                                LootPool.builder()
                                        .rolls(ConstantLootNumberProvider.create(1.0F))
                                        .with(itemEntryBuilder(Items.ARROW))
                        )
                        .pool(
                                LootPool.builder()
                                        .rolls(ConstantLootNumberProvider.create(1.0F))
                                        .with(itemEntryBuilder(CreaturesItems.CRIMSON_BONE))
                        )
                        .pool(
                                LootPool.builder()
                                        .rolls(ConstantLootNumberProvider.create(1.0F))
                                        .with(
                                                ItemEntry.builder(Items.CRIMSON_FUNGUS)
                                                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0F, 1.0F)))
                                                        .apply(EnchantedCountIncreaseLootFunction.builder(this.registries, UniformLootNumberProvider.create(0.0F, 1.0F)))
                                        )
                        )
        );

        this.register(
                CreaturesEntityTypes.WARPED_SKELETON,
                LootTable.builder()
                        .pool(
                                LootPool.builder()
                                        .rolls(ConstantLootNumberProvider.create(1.0F))
                                        .with(itemEntryBuilder(Items.ARROW))
                        )
                        .pool(
                                LootPool.builder()
                                        .rolls(ConstantLootNumberProvider.create(1.0F))
                                        .with(itemEntryBuilder(CreaturesItems.WARPED_BONE))
                        )
                        .pool(
                                LootPool.builder()
                                        .rolls(ConstantLootNumberProvider.create(1.0F))
                                        .with(
                                                ItemEntry.builder(Items.WARPED_FUNGUS)
                                                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0F, 1.0F)))
                                                        .apply(EnchantedCountIncreaseLootFunction.builder(this.registries, UniformLootNumberProvider.create(0.0F, 1.0F)))
                                        )
                        )
        );

        this.register(
                CreaturesEntityTypes.VENOMOUS_SKELETON,
                defaultSkeletonLootTableBuilder()
                        .pool(tippedArrowLootPoolBuilder(Potions.POISON))
        );

        this.register(
                CreaturesEntityTypes.SNOWY_SKELETON,
                defaultSkeletonLootTableBuilder()
                        .pool(lootPoolBuilder(Items.SNOWBALL))
                        .pool(tippedArrowLootPoolBuilder(Potions.SLOWNESS))
        );

        this.register(
                CreaturesEntityTypes.FROZEN_SKELETON,
                LootTable.builder()
                        .pool(
                                LootPool.builder()
                                        .rolls(ConstantLootNumberProvider.create(1.0F))
                                        .with(itemEntryBuilder(Items.ARROW))
                        )
                        .pool(
                                LootPool.builder()
                                        .rolls(ConstantLootNumberProvider.create(1.0F))
                                        .with(itemEntryBuilder(CreaturesItems.FROZEN_BONE))
                        )
                        .pool(tippedArrowLootPoolBuilder(Potions.SLOWNESS))
        );

        this.register(
                CreaturesEntityTypes.FROZEN_ZOMBIE,
                LootTable.builder()
                        .pool(
                                LootPool.builder()
                                        .rolls(ConstantLootNumberProvider.create(1.0F))
                                        .with(itemEntryBuilder(Items.ROTTEN_FLESH))
                        )
                        .pool(
                                LootPool.builder()
                                        .rolls(ConstantLootNumberProvider.create(1.0F))
                                        .with(ItemEntry.builder(Items.IRON_INGOT))
                                        .with(ItemEntry.builder(Items.CARROT))
                                        .with(ItemEntry.builder(Items.POTATO).apply(FurnaceSmeltLootFunction.builder().conditionally(this.createSmeltLootCondition())))
                                        .conditionally(KilledByPlayerLootCondition.builder())
                                        .conditionally(RandomChanceWithEnchantedBonusLootCondition.builder(this.registries, 0.025F, 0.01F))
                        )
        );

        this.register(
                CreaturesEntityTypes.MUMMY,
                LootTable.builder()
                        .pool(
                                LootPool.builder()
                                        .rolls(ConstantLootNumberProvider.create(1.0F))
                                        .with(itemEntryBuilder(Items.ROTTEN_FLESH))
                        )
                        .pool(
                                LootPool.builder()
                                        .rolls(ConstantLootNumberProvider.create(1.0F))
                                        .with(ItemEntry.builder(Items.IRON_INGOT))
                                        .with(ItemEntry.builder(Items.CARROT))
                                        .with(ItemEntry.builder(Items.POTATO).apply(FurnaceSmeltLootFunction.builder().conditionally(this.createSmeltLootCondition())))
                                        .conditionally(KilledByPlayerLootCondition.builder())
                                        .conditionally(RandomChanceWithEnchantedBonusLootCondition.builder(this.registries, 0.025F, 0.01F))
                        )
                        .pool(
                                LootPool.builder()
                                        .rolls(ConstantLootNumberProvider.create(1.0F))
                                        .with(itemEntryBuilder(Items.STRING))
                        )
        );

        this.register(
                CreaturesEntityTypes.VENOMOUS_ZOMBIE,
                LootTable.builder()
                        .pool(
                                LootPool.builder()
                                        .rolls(ConstantLootNumberProvider.create(1.0F))
                                        .with(itemEntryBuilder(Items.ROTTEN_FLESH))
                        )
                        .pool(
                                LootPool.builder()
                                        .rolls(ConstantLootNumberProvider.create(1.0F))
                                        .with(ItemEntry.builder(Items.IRON_INGOT))
                                        .with(ItemEntry.builder(Items.POISONOUS_POTATO))
                                        .conditionally(KilledByPlayerLootCondition.builder())
                                        .conditionally(RandomChanceWithEnchantedBonusLootCondition.builder(this.registries, 0.025F, 0.01F))
                        )
        );

        this.register(
                CreaturesEntityTypes.SNOWY_ZOMBIE,
                LootTable.builder()
                        .pool(
                                LootPool.builder()
                                        .rolls(ConstantLootNumberProvider.create(1.0F))
                                        .with(itemEntryBuilder(Items.ROTTEN_FLESH))
                        )
                        .pool(
                                LootPool.builder()
                                        .rolls(ConstantLootNumberProvider.create(1.0F))
                                        .with(ItemEntry.builder(Items.IRON_INGOT))
                                        .with(ItemEntry.builder(Items.CARROT))
                                        .with(ItemEntry.builder(Items.POTATO).apply(FurnaceSmeltLootFunction.builder().conditionally(this.createSmeltLootCondition())))
                                        .conditionally(KilledByPlayerLootCondition.builder())
                                        .conditionally(RandomChanceWithEnchantedBonusLootCondition.builder(this.registries, 0.025F, 0.01F))
                        )
                        .pool(lootPoolBuilder(Items.SNOWBALL))
        );

        this.register(CreaturesEntityTypes.FROZEN_CREEPER, defaultCreeperLootTableBuilder(entityTypeRegistryEntryLookup));

        this.register(
                CreaturesEntityTypes.SCORCHED_CREEPER,
                LootTable.builder()
                        .pool(
                                LootPool.builder()
                                        .rolls(ConstantLootNumberProvider.create(1.0F))
                                        .with(itemEntryBuilder(Items.GUNPOWDER))
                                        .with(itemEntryBuilder(CreaturesItems.SAND_DUST))
                        )
                        .pool(
                                LootPool.builder()
                                        .with(TagEntry.expandBuilder(ItemTags.CREEPER_DROP_MUSIC_DISCS))
                                        .conditionally(
                                                EntityPropertiesLootCondition.builder(
                                                        LootContext.EntityTarget.ATTACKER,
                                                        EntityPredicate.Builder.create()
                                                                .type(entityTypeRegistryEntryLookup, EntityTypeTags.SKELETONS)
                                                )
                                        )
                        )
        );

        this.register(
                CreaturesEntityTypes.SNOWY_CREEPER,
                defaultCreeperLootTableBuilder(entityTypeRegistryEntryLookup)
                        .pool(lootPoolBuilder(Items.SNOWBALL))
        );

        this.register(CreaturesEntityTypes.VENOMOUS_CREEPER, defaultCreeperLootTableBuilder(entityTypeRegistryEntryLookup));

        this.register(CreaturesEntityTypes.FROZEN_SPIDER, defaultSpiderLootTableBuilder());
        this.register(CreaturesEntityTypes.ICE_SPIDER, defaultSpiderLootTableBuilder());
        this.register(
                CreaturesEntityTypes.SAND_SPIDER,
                defaultSpiderLootTableBuilder()
                        .pool(lootPoolBuilder(CreaturesItems.SAND_DUST))
        );
        this.register(
                CreaturesEntityTypes.SNOW_SPIDER,
                defaultSpiderLootTableBuilder()
                        .pool(lootPoolBuilder(Items.SNOWBALL))
        );
        this.register(CreaturesEntityTypes.VENOMOUS_SPIDER, defaultSpiderLootTableBuilder());
        this.register(
                CreaturesEntityTypes.SNOWY_SPIDER,
                defaultSpiderLootTableBuilder()
                        .pool(lootPoolBuilder(Items.SNOWBALL))
        );

        this.register(
                CreaturesEntityTypes.SNOWY_COW,
                LootTable.builder()
                        .pool(
                                LootPool.builder()
                                        .rolls(ConstantLootNumberProvider.create(1.0F))
                                        .with(itemEntryBuilder(Items.LEATHER))
                        )
                        .pool(
                                LootPool.builder()
                                        .rolls(ConstantLootNumberProvider.create(1.0F))
                                        .with(
                                                ItemEntry.builder(Items.BEEF)
                                                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 3.0F)))
                                                        .apply(FurnaceSmeltLootFunction.builder().conditionally(this.createSmeltLootCondition()))
                                                        .apply(EnchantedCountIncreaseLootFunction.builder(this.registries, UniformLootNumberProvider.create(0.0F, 1.0F)))
                                        )
                        )
                        .pool(lootPoolBuilder(Items.SNOWBALL))
        );

        this.register(
                CreaturesEntityTypes.SNOWY_PIG,
                LootTable.builder()
                        .pool(
                                LootPool.builder()
                                        .rolls(ConstantLootNumberProvider.create(1.0F))
                                        .with(
                                                ItemEntry.builder(Items.PORKCHOP)
                                                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 3.0F)))
                                                        .apply(FurnaceSmeltLootFunction.builder().conditionally(this.createSmeltLootCondition()))
                                                        .apply(EnchantedCountIncreaseLootFunction.builder(this.registries, UniformLootNumberProvider.create(0.0F, 1.0F)))
                                        )
                        )
                        .pool(lootPoolBuilder(Items.SNOWBALL))
        );

        this.register(
                CreaturesEntityTypes.WILD_BOAR,
                LootTable.builder()
                        .pool(
                                LootPool.builder()
                                        .rolls(ConstantLootNumberProvider.create(1.0F))
                                        .with(
                                                ItemEntry.builder(Items.PORKCHOP)
                                                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 3.0F)))
                                                        .apply(FurnaceSmeltLootFunction.builder().conditionally(this.createSmeltLootCondition()))
                                                        .apply(EnchantedCountIncreaseLootFunction.builder(this.registries, UniformLootNumberProvider.create(0.0F, 1.0F)))
                                        )
                        )
        );
    }

    private LootPool.Builder lootPoolBuilder(Item item) {
        return LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1.0F))
                .with(
                        ItemEntry.builder(item)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0F, 2.0F)))
                                .apply(EnchantedCountIncreaseLootFunction.builder(this.registries, UniformLootNumberProvider.create(0.0F, 1.0F)))
                );
    }

    private LootPoolEntry.Builder<?> itemEntryBuilder(Item item) {
        return ItemEntry.builder(item)
                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0F, 2.0F)))
                .apply(EnchantedCountIncreaseLootFunction.builder(this.registries, UniformLootNumberProvider.create(0.0F, 1.0F)));
    }

    private LootTable.Builder defaultSkeletonLootTableBuilder() {
        return LootTable.builder()
                .pool(
                        LootPool.builder()
                                .rolls(ConstantLootNumberProvider.create(1.0F))
                                .with(itemEntryBuilder(Items.ARROW))
                )
                .pool(
                        LootPool.builder()
                                .rolls(ConstantLootNumberProvider.create(1.0F))
                                .with(itemEntryBuilder(Items.BONE))
                );
    }

    private LootPool.Builder tippedArrowLootPoolBuilder(RegistryEntry<Potion> potion) {
        return LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1.0F))
                .with(
                        ItemEntry.builder(Items.TIPPED_ARROW)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0F, 1.0F)))
                                .apply(EnchantedCountIncreaseLootFunction.builder(this.registries, UniformLootNumberProvider.create(0.0F, 1.0F)).withLimit(1))
                                .apply(SetPotionLootFunction.builder(potion))
                )
                .conditionally(KilledByPlayerLootCondition.builder());
    }

    private LootTable.Builder defaultCreeperLootTableBuilder(RegistryEntryLookup<EntityType<?>> registryEntryLookup) {
        return LootTable.builder()
                .pool(
                        LootPool.builder()
                                .rolls(ConstantLootNumberProvider.create(1.0F))
                                .with(itemEntryBuilder(Items.GUNPOWDER))
                )
                .pool(
                        LootPool.builder()
                                .with(TagEntry.expandBuilder(ItemTags.CREEPER_DROP_MUSIC_DISCS))
                                .conditionally(
                                        EntityPropertiesLootCondition.builder(
                                                LootContext.EntityTarget.ATTACKER, EntityPredicate.Builder.create().type(registryEntryLookup, EntityTypeTags.SKELETONS)
                                        )
                                )
                );
    }

    private LootTable.Builder defaultSpiderLootTableBuilder() {
        return LootTable.builder()
                .pool(
                        LootPool.builder()
                                .rolls(ConstantLootNumberProvider.create(1.0F))
                                .with(itemEntryBuilder(Items.STRING))
                )
                .pool(
                        LootPool.builder()
                                .rolls(ConstantLootNumberProvider.create(1.0F))
                                .with(
                                        ItemEntry.builder(Items.SPIDER_EYE)
                                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(-1.0F, 1.0F)))
                                                .apply(EnchantedCountIncreaseLootFunction.builder(this.registries, UniformLootNumberProvider.create(0.0F, 1.0F)))
                                )
                                .conditionally(KilledByPlayerLootCondition.builder())
                );
    }
}
