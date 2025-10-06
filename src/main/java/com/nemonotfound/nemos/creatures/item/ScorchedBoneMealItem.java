package com.nemonotfound.nemos.creatures.item;

import com.nemonotfound.nemos.creatures.world.CreatureWorldEvents;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.particle.ParticleUtil;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.event.GameEvent;

import java.util.Map;

public class ScorchedBoneMealItem extends Item {

    private static final Map<Block, Block> BLOCK_REPLACEMENT_MAP = Map.of(
            Blocks.GRASS_BLOCK, Blocks.SAND,
            Blocks.DIRT, Blocks.SAND,
            Blocks.SHORT_GRASS, Blocks.SHORT_DRY_GRASS,
            Blocks.TALL_GRASS, Blocks.TALL_DRY_GRASS,
            Blocks.BUSH, Blocks.DEAD_BUSH
    );

    public ScorchedBoneMealItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        var world = context.getWorld();
        var blockPos = context.getBlockPos();
        var blockState = world.getBlockState(blockPos);
        var itemStack = context.getStack();

        if (useOnDryableBlock(world, blockState, blockPos, itemStack)) {
            if (!world.isClient) {
                context.getPlayer().emitGameEvent(GameEvent.ITEM_INTERACT_FINISH);
                world.syncWorldEvent(CreatureWorldEvents.SCORCHED_BONE_MEAL_USED, blockPos, 15);

            }

            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }

    public static boolean useOnDryableBlock(World world, BlockState blockState, BlockPos blockPos, ItemStack itemStack) {
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

    private static BlockPos calculateNewBlockPos(BlockState blockState, BlockPos blockPos) {
        if (
                blockState.contains(Properties.DOUBLE_BLOCK_HALF) &&
                        blockState.get(Properties.DOUBLE_BLOCK_HALF).equals(DoubleBlockHalf.UPPER)
        ) {
            return blockPos.down();
        }

        return blockPos;
    }

    public static void createParticles(WorldAccess world, BlockPos pos, int count) {
        var blockState = world.getBlockState(pos);
        var oldBlock = blockState.getBlock();
        var blockReplacement = BLOCK_REPLACEMENT_MAP.get(oldBlock);

        if (blockReplacement != null) {
            ParticleUtil.spawnParticlesAround(world, calculateNewBlockPos(blockState, pos), count, ParticleTypes.DUST_PLUME);
        }
    }
}
