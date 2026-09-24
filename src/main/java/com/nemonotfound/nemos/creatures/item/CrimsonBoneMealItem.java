package com.nemonotfound.nemos.creatures.item;

import com.nemonotfound.nemos.creatures.world.CreatureWorldEvents;
import com.nemonotfound.nemos.creatures.world.gen.feature.ModNetherConfiguredFeatures;
import java.util.Map;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.ParticleUtils;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jspecify.annotations.NonNull;

public class CrimsonBoneMealItem extends Item {

    private static final Map<Block, Block> BLOCK_REPLACEMENT_MAP = Map.ofEntries(
            Map.entry(Blocks.GRASS_BLOCK, Blocks.CRIMSON_NYLIUM),
            Map.entry(Blocks.DIRT, Blocks.CRIMSON_NYLIUM),
            Map.entry(Blocks.STONE, Blocks.CRIMSON_NYLIUM),
            Map.entry(Blocks.COBBLESTONE, Blocks.CRIMSON_NYLIUM),
            Map.entry(Blocks.NETHERRACK, Blocks.CRIMSON_NYLIUM),
            Map.entry(Blocks.WARPED_NYLIUM, Blocks.CRIMSON_NYLIUM),
            Map.entry(Blocks.SHORT_GRASS, Blocks.CRIMSON_ROOTS),
            Map.entry(Blocks.TALL_GRASS, Blocks.CRIMSON_ROOTS),
            Map.entry(Blocks.BROWN_MUSHROOM, Blocks.CRIMSON_FUNGUS),
            Map.entry(Blocks.RED_MUSHROOM, Blocks.CRIMSON_FUNGUS),
            Map.entry(Blocks.WARPED_FUNGUS, Blocks.CRIMSON_FUNGUS),
            Map.entry(Blocks.WARPED_ROOTS, Blocks.CRIMSON_ROOTS)
    );

    public CrimsonBoneMealItem(Properties settings) {
        super(settings);
    }

    @Override
    public @NonNull InteractionResult useOn(UseOnContext context) {
        var world = context.getLevel();
        var blockPos = context.getClickedPos();
        var blockState = world.getBlockState(blockPos);
        var itemStack = context.getItemInHand();

        if (!useOnReplaceable(world, blockState, blockPos, itemStack) && !useOnCrimsonNylium(context.getItemInHand(), world, blockState, blockPos)) {
            return InteractionResult.PASS;
        }

        if (!world.isClientSide()) {
            context.getPlayer().gameEvent(GameEvent.ITEM_INTERACT_FINISH);
            world.levelEvent(CreatureWorldEvents.CRIMSON_BONE_MEAL_USED, blockPos, 15);
        }

        return InteractionResult.SUCCESS;
    }

    public static boolean useOnReplaceable(Level world, BlockState blockState, BlockPos blockPos, ItemStack itemStack) {
        var oldBlock = blockState.getBlock();
        var blockReplacement = BLOCK_REPLACEMENT_MAP.get(oldBlock);

        if (blockReplacement == null) {
            return false;
        }

        if (world instanceof ServerLevel) {
            world.setBlockAndUpdate(calculateNewBlockPos(blockState, blockPos), blockReplacement.defaultBlockState());
            itemStack.shrink(1);
        }

        return true;
    }

    public static boolean useOnCrimsonNylium(ItemStack stack, Level world, BlockState blockState, BlockPos pos) {
        if (blockState.getBlock() != Blocks.CRIMSON_NYLIUM) {
            return false;
        }

        if (world instanceof ServerLevel serverWorld) {
            world.registryAccess()
                    .lookup(Registries.FEATURE)
                    .flatMap(registry -> registry.get(ModNetherConfiguredFeatures.CRIMSON_FOREST_VEGETATION_PATCH_BONEMEAL))
                    .ifPresent(entry -> entry.value().place(serverWorld, serverWorld.getChunkSource().getGenerator(), serverWorld.getRandom(), pos.above()));

            stack.shrink(1);
        }

        return true;
    }

    private static BlockPos calculateNewBlockPos(BlockState blockState, BlockPos blockPos) {
        if (
                blockState.hasProperty(BlockStateProperties.DOUBLE_BLOCK_HALF) &&
                        blockState.getValue(BlockStateProperties.DOUBLE_BLOCK_HALF).equals(DoubleBlockHalf.UPPER)
        ) {
            return blockPos.below();
        }

        return blockPos;
    }

    public static void createParticles(LevelAccessor world, BlockPos blockPos, int count) {
        var blockState = world.getBlockState(blockPos);
        var oldBlock = blockState.getBlock();
        var blockReplacement = BLOCK_REPLACEMENT_MAP.get(oldBlock);

        if (oldBlock == Blocks.CRIMSON_NYLIUM) {
            ParticleUtils.spawnParticles(world, blockPos, count * 3, 3.0, 1.0, false, ParticleTypes.CRIMSON_SPORE);
        } else if (blockReplacement != null) {
            ParticleUtils.spawnParticleInBlock(world, calculateNewBlockPos(blockState, blockPos), count, ParticleTypes.CRIMSON_SPORE);
        }
    }
}
