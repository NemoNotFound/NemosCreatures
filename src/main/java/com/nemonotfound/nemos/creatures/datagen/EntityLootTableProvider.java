package com.nemonotfound.nemos.creatures.datagen;

import com.nemonotfound.nemos.creatures.item.CreaturesItems;
import com.nemonotfound.nemos.creatures.world.entity.CreaturesEntityTypes;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricEntityLootSubProvider;
import net.minecraft.advancements.predicates.entity.EntityPredicate;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.entries.TagEntry;
import net.minecraft.world.level.storage.loot.functions.EnchantedCountIncreaseFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.functions.SetPotionFunction;
import net.minecraft.world.level.storage.loot.functions.SmeltItemFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemKilledByPlayerCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceWithEnchantedBonusCondition;
import net.minecraft.world.level.storage.loot.providers.number.ints.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.ints.UniformGenerator;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class EntityLootTableProvider extends FabricEntityLootSubProvider {

    private static Holder<net.minecraft.world.level.storage.loot.providers.number.floats.ContextFloatProvider> floatUniform(float min, float max) {
        return Holder.direct(new net.minecraft.world.level.storage.loot.providers.number.floats.UniformGenerator(
                Holder.direct(new net.minecraft.world.level.storage.loot.providers.number.floats.ConstantValue(min)),
                Holder.direct(new net.minecraft.world.level.storage.loot.providers.number.floats.ConstantValue(max))
        ));
    }

    public EntityLootTableProvider(FabricPackOutput output, @NotNull CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generate() {
        HolderGetter<EntityType<?>> entityTypeRegistryEntryLookup = this.entityTypes;

        this.add(
                CreaturesEntityTypes.CRIMSON_SKELETON,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(Holder.direct(new ConstantValue(1)))
                                        .add(itemEntryBuilder(Items.ARROW))
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(Holder.direct(new ConstantValue(1)))
                                        .add(itemEntryBuilder(CreaturesItems.CRIMSON_BONE))
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(Holder.direct(new ConstantValue(1)))
                                        .add(itemEntryBuilder(Items.BONE))
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(Holder.direct(new ConstantValue(1)))
                                        .add(
                                                LootItem.lootTableItem(Items.CRIMSON_FUNGUS)
                                                        .apply(SetItemCountFunction.setCount(Holder.direct(new UniformGenerator(Holder.direct(new ConstantValue(0)), Holder.direct(new ConstantValue(1))))))
                                                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.enchantments, floatUniform(0.0F, 1.0F)))
                                        )
                        )
        );

        this.add(
                CreaturesEntityTypes.WARPED_SKELETON,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(Holder.direct(new ConstantValue(1)))
                                        .add(itemEntryBuilder(Items.ARROW))
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(Holder.direct(new ConstantValue(1)))
                                        .add(itemEntryBuilder(CreaturesItems.WARPED_BONE))
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(Holder.direct(new ConstantValue(1)))
                                        .add(itemEntryBuilder(Items.BONE))
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(Holder.direct(new ConstantValue(1)))
                                        .add(
                                                LootItem.lootTableItem(Items.WARPED_FUNGUS)
                                                        .apply(SetItemCountFunction.setCount(Holder.direct(new UniformGenerator(Holder.direct(new ConstantValue(0)), Holder.direct(new ConstantValue(1))))))
                                                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.enchantments, floatUniform(0.0F, 1.0F)))
                                        )
                        )
        );

        this.add(
                CreaturesEntityTypes.VENOMOUS_SKELETON,
                defaultSkeletonLootTableBuilder()
                        .withPool(tippedArrowLootPoolBuilder(Potions.POISON))
        );

        this.add(
                CreaturesEntityTypes.SNOWY_SKELETON,
                defaultSkeletonLootTableBuilder()
                        .withPool(lootPoolBuilder(Items.SNOWBALL))
                        .withPool(tippedArrowLootPoolBuilder(Potions.SLOWNESS))
        );

        this.add(
                CreaturesEntityTypes.FROZEN_SKELETON,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(Holder.direct(new ConstantValue(1)))
                                        .add(itemEntryBuilder(Items.ARROW))
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(Holder.direct(new ConstantValue(1)))
                                        .add(itemEntryBuilder(CreaturesItems.FROZEN_BONE))
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(Holder.direct(new ConstantValue(1)))
                                        .add(itemEntryBuilder(Items.BONE))
                        )
                        .withPool(tippedArrowLootPoolBuilder(Potions.SLOWNESS))
        );

        this.add(
                CreaturesEntityTypes.FROZEN_ZOMBIE,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(Holder.direct(new ConstantValue(1)))
                                        .add(itemEntryBuilder(Items.ROTTEN_FLESH))
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(Holder.direct(new ConstantValue(1)))
                                        .add(LootItem.lootTableItem(Items.IRON_INGOT))
                                        .add(LootItem.lootTableItem(Items.CARROT))
                                        .add(LootItem.lootTableItem(Items.POTATO).apply(SmeltItemFunction.smelted().when(this.shouldSmeltLoot())))
                                        .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                        .when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(this.enchantments, 0.025F, 0.01F))
                        )
        );

        this.add(
                CreaturesEntityTypes.VENOMOUS_ZOMBIE,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(Holder.direct(new ConstantValue(1)))
                                        .add(itemEntryBuilder(Items.ROTTEN_FLESH))
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(Holder.direct(new ConstantValue(1)))
                                        .add(LootItem.lootTableItem(Items.IRON_INGOT))
                                        .add(LootItem.lootTableItem(Items.POISONOUS_POTATO))
                                        .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                        .when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(this.enchantments, 0.025F, 0.01F))
                        )
        );

        this.add(
                CreaturesEntityTypes.SNOWY_ZOMBIE,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(Holder.direct(new ConstantValue(1)))
                                        .add(itemEntryBuilder(Items.ROTTEN_FLESH))
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(Holder.direct(new ConstantValue(1)))
                                        .add(LootItem.lootTableItem(Items.IRON_INGOT))
                                        .add(LootItem.lootTableItem(Items.CARROT))
                                        .add(LootItem.lootTableItem(Items.POTATO).apply(SmeltItemFunction.smelted().when(this.shouldSmeltLoot())))
                                        .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                        .when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(this.enchantments, 0.025F, 0.01F))
                        )
                        .withPool(lootPoolBuilder(Items.SNOWBALL))
        );

        this.add(CreaturesEntityTypes.FROZEN_CREEPER, defaultCreeperLootTableBuilder(entityTypeRegistryEntryLookup));

        this.add(
                CreaturesEntityTypes.SCORCHED_CREEPER,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(Holder.direct(new ConstantValue(1)))
                                        .add(itemEntryBuilder(Items.GUNPOWDER))
                                        .add(itemEntryBuilder(CreaturesItems.SAND_DUST))
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .add(TagEntry.expandTag(this.items.getOrThrow(ItemTags.CREEPER_DROP_MUSIC_DISCS)))
                                        .when(
                                                LootItemEntityPropertyCondition.hasProperties(
                                                        LootContext.EntityTarget.ATTACKER,
                                                        EntityPredicate.Builder.entity()
                                                                .of(entityTypeRegistryEntryLookup, EntityTypeTags.SKELETONS)
                                                )
                                        )
                        )
        );

        this.add(
                CreaturesEntityTypes.SNOWY_CREEPER,
                defaultCreeperLootTableBuilder(entityTypeRegistryEntryLookup)
                        .withPool(lootPoolBuilder(Items.SNOWBALL))
        );

        this.add(CreaturesEntityTypes.VENOMOUS_CREEPER, defaultCreeperLootTableBuilder(entityTypeRegistryEntryLookup));

        this.add(CreaturesEntityTypes.FROZEN_SPIDER, defaultSpiderLootTableBuilder());
        this.add(CreaturesEntityTypes.ICE_SPIDER, defaultSpiderLootTableBuilder());
        this.add(
                CreaturesEntityTypes.SAND_SPIDER,
                defaultSpiderLootTableBuilder()
                        .withPool(lootPoolBuilder(CreaturesItems.SAND_DUST))
        );
        this.add(
                CreaturesEntityTypes.SNOW_SPIDER,
                defaultSpiderLootTableBuilder()
                        .withPool(lootPoolBuilder(Items.SNOWBALL))
        );
        this.add(CreaturesEntityTypes.VENOMOUS_SPIDER, defaultSpiderLootTableBuilder());
        this.add(
                CreaturesEntityTypes.SNOWY_SPIDER,
                defaultSpiderLootTableBuilder()
                        .withPool(lootPoolBuilder(Items.SNOWBALL))
        );

        this.add(
                CreaturesEntityTypes.SNOWY_COW,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(Holder.direct(new ConstantValue(1)))
                                        .add(itemEntryBuilder(Items.LEATHER))
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(Holder.direct(new ConstantValue(1)))
                                        .add(
                                                LootItem.lootTableItem(Items.BEEF)
                                                        .apply(SetItemCountFunction.setCount(Holder.direct(new UniformGenerator(Holder.direct(new ConstantValue(1)), Holder.direct(new ConstantValue(3))))))
                                                        .apply(SmeltItemFunction.smelted().when(this.shouldSmeltLoot()))
                                                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.enchantments, floatUniform(0.0F, 1.0F)))
                                        )
                        )
                        .withPool(lootPoolBuilder(Items.SNOWBALL))
        );

        this.add(
                CreaturesEntityTypes.SNOWY_PIG,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(Holder.direct(new ConstantValue(1)))
                                        .add(
                                                LootItem.lootTableItem(Items.PORKCHOP)
                                                        .apply(SetItemCountFunction.setCount(Holder.direct(new UniformGenerator(Holder.direct(new ConstantValue(1)), Holder.direct(new ConstantValue(3))))))
                                                        .apply(SmeltItemFunction.smelted().when(this.shouldSmeltLoot()))
                                                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.enchantments, floatUniform(0.0F, 1.0F)))
                                        )
                        )
                        .withPool(lootPoolBuilder(Items.SNOWBALL))
        );

        this.add(
                CreaturesEntityTypes.WILD_BOAR,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(Holder.direct(new ConstantValue(1)))
                                        .add(
                                                LootItem.lootTableItem(Items.PORKCHOP)
                                                        .apply(SetItemCountFunction.setCount(Holder.direct(new UniformGenerator(Holder.direct(new ConstantValue(1)), Holder.direct(new ConstantValue(3))))))
                                                        .apply(SmeltItemFunction.smelted().when(this.shouldSmeltLoot()))
                                                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.enchantments, floatUniform(0.0F, 1.0F)))
                                        )
                        )
        );
    }

    private LootPool.Builder lootPoolBuilder(Item item) {
        return LootPool.lootPool()
                .setRolls(Holder.direct(new ConstantValue(1)))
                .add(
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(Holder.direct(new UniformGenerator(Holder.direct(new ConstantValue(0)), Holder.direct(new ConstantValue(2))))))
                                .apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.enchantments, floatUniform(0.0F, 1.0F)))
                );
    }

    private LootPoolEntryContainer.Builder<?> itemEntryBuilder(Item item) {
        return LootItem.lootTableItem(item)
                .apply(SetItemCountFunction.setCount(Holder.direct(new UniformGenerator(Holder.direct(new ConstantValue(0)), Holder.direct(new ConstantValue(2))))))
                .apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.enchantments, floatUniform(0.0F, 1.0F)));
    }

    private LootTable.Builder defaultSkeletonLootTableBuilder() {
        return LootTable.lootTable()
                .withPool(
                        LootPool.lootPool()
                                .setRolls(Holder.direct(new ConstantValue(1)))
                                .add(itemEntryBuilder(Items.ARROW))
                )
                .withPool(
                        LootPool.lootPool()
                                .setRolls(Holder.direct(new ConstantValue(1)))
                                .add(itemEntryBuilder(Items.BONE))
                );
    }

    private LootPool.Builder tippedArrowLootPoolBuilder(Holder<Potion> potion) {
        return LootPool.lootPool()
                .setRolls(Holder.direct(new ConstantValue(1)))
                .add(
                        LootItem.lootTableItem(Items.TIPPED_ARROW)
                                .apply(SetItemCountFunction.setCount(Holder.direct(new UniformGenerator(Holder.direct(new ConstantValue(0)), Holder.direct(new ConstantValue(1))))))
                                .apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.enchantments, floatUniform(0.0F, 1.0F)).setLimit(1))
                                .apply(SetPotionFunction.setPotion(potion))
                )
                .when(LootItemKilledByPlayerCondition.killedByPlayer());
    }

    private LootTable.Builder defaultCreeperLootTableBuilder(HolderGetter<EntityType<?>> registryEntryLookup) {
        return LootTable.lootTable()
                .withPool(
                        LootPool.lootPool()
                                .setRolls(Holder.direct(new ConstantValue(1)))
                                .add(itemEntryBuilder(Items.GUNPOWDER))
                )
                .withPool(
                        LootPool.lootPool()
                                .add(TagEntry.expandTag(this.items.getOrThrow(ItemTags.CREEPER_DROP_MUSIC_DISCS)))
                                .when(
                                        LootItemEntityPropertyCondition.hasProperties(
                                                LootContext.EntityTarget.ATTACKER, EntityPredicate.Builder.entity().of(registryEntryLookup, EntityTypeTags.SKELETONS)
                                        )
                                )
                );
    }

    private LootTable.Builder defaultSpiderLootTableBuilder() {
        return LootTable.lootTable()
                .withPool(
                        LootPool.lootPool()
                                .setRolls(Holder.direct(new ConstantValue(1)))
                                .add(itemEntryBuilder(Items.STRING))
                )
                .withPool(
                        LootPool.lootPool()
                                .setRolls(Holder.direct(new ConstantValue(1)))
                                .add(
                                        LootItem.lootTableItem(Items.SPIDER_EYE)
                                                .apply(SetItemCountFunction.setCount(Holder.direct(new UniformGenerator(Holder.direct(new ConstantValue(-1)), Holder.direct(new ConstantValue(1))))))
                                                .apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.enchantments, floatUniform(0.0F, 1.0F)))
                                )
                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
                );
    }
}
