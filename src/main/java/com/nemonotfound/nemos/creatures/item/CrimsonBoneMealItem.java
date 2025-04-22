package com.nemonotfound.nemos.creatures.item;

import com.nemonotfound.nemos.creatures.world.ModWorldEvents;
import com.nemonotfound.nemos.creatures.world.gen.feature.ModNetherConfiguredFeatures;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.particle.ParticleUtil;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.event.GameEvent;

import java.util.Map;

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

    public CrimsonBoneMealItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        var world = context.getWorld();
        var blockPos = context.getBlockPos();
        var blockState = world.getBlockState(blockPos);
        var itemStack = context.getStack();

        if (!useOnReplaceable(world, blockState, blockPos, itemStack) && !useOnCrimsonNylium(context.getStack(), world, blockState, blockPos)) {
            return ActionResult.PASS;
        }

        if (!world.isClient) {
            context.getPlayer().emitGameEvent(GameEvent.ITEM_INTERACT_FINISH);
            world.syncWorldEvent(ModWorldEvents.CRIMSON_BONE_MEAL_USED, blockPos, 15);
        }

        return ActionResult.SUCCESS;
    }

    public static boolean useOnReplaceable(World world, BlockState blockState, BlockPos blockPos, ItemStack itemStack) {
        var oldBlock = blockState.getBlock();
        var blockReplacement = BLOCK_REPLACEMENT_MAP.get(oldBlock);

        if (blockReplacement == null) {
            return false;
        }

        if (world instanceof ServerWorld) {
            world.setBlockState(calculateNewBlockPos(blockState, blockPos), blockReplacement.getDefaultState());
            itemStack.decrement(1);
        }

        return true;
    }

    public static boolean useOnCrimsonNylium(ItemStack stack, World world, BlockState blockState, BlockPos pos) {
        if (blockState.getBlock() != Blocks.CRIMSON_NYLIUM) {
            return false;
        }

        if (world instanceof ServerWorld serverWorld) {
            world.getRegistryManager()
                    .getOptional(RegistryKeys.CONFIGURED_FEATURE)
                    .flatMap(registry -> registry.getOptional(ModNetherConfiguredFeatures.CRIMSON_FOREST_VEGETATION_PATCH_BONEMEAL))
                    .ifPresent(entry -> entry.value().generate(serverWorld, serverWorld.getChunkManager().getChunkGenerator(), serverWorld.random, pos.up()));

            stack.decrement(1);
        }

        return true;
    }

    private static BlockPos calculateNewBlockPos(BlockState blockState, BlockPos blockPos) {
        if (
                blockState.contains(Properties.DOUBLE_BLOCK_HALF) &&
                        blockState.get(Properties.DOUBLE_BLOCK_HALF).equals(DoubleBlockHalf.UPPER)
        ) {
            return blockPos.down();
        }

        return blockPos;
    }

    public static void createParticles(WorldAccess world, BlockPos blockPos, int count) {
        var blockState = world.getBlockState(blockPos);
        var oldBlock = blockState.getBlock();
        var blockReplacement = BLOCK_REPLACEMENT_MAP.get(oldBlock);

        if (oldBlock == Blocks.CRIMSON_NYLIUM) {
            ParticleUtil.spawnParticlesAround(world, blockPos, count * 3, 3.0, 1.0, false, ParticleTypes.CRIMSON_SPORE);
        } else if (blockReplacement != null) {
            ParticleUtil.spawnParticlesAround(world, calculateNewBlockPos(blockState, blockPos), count, ParticleTypes.CRIMSON_SPORE);
        }
    }
}
