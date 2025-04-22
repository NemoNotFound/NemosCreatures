package com.nemonotfound.nemos.creatures.item;

import com.nemonotfound.nemos.creatures.world.ModWorldEvents;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.GrassBlock;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.particle.ParticleUtil;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.event.GameEvent;

public class ScorchedBoneMealItem extends Item {

    public ScorchedBoneMealItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        var world = context.getWorld();
        var blockPos = context.getBlockPos();
        var blockState = world.getBlockState(blockPos);
        var itemStack = context.getStack();

        if (useOnDirtOrGrassBlock(world, blockState, blockPos, itemStack)) {
            if (!world.isClient) {
                //TODO: Should not cause Nullpointer
                context.getPlayer().emitGameEvent(GameEvent.ITEM_INTERACT_FINISH);
                world.syncWorldEvent(ModWorldEvents.SCORCHED_BONE_MEAL_USED, blockPos, 15);

            }

            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }

    private boolean useOnDirtOrGrassBlock(World world, BlockState blockState, BlockPos blockPos, ItemStack itemStack) {
        var isDirtOrGrassBlock = blockState.getBlock() instanceof GrassBlock || blockState.isOf(Blocks.DIRT);

        if (!isDirtOrGrassBlock) {
            return false;
        }

        if (world instanceof ServerWorld) {
            world.setBlockState(blockPos, Blocks.SAND.getDefaultState());
            itemStack.decrement(1);
        }

        return true;
    }

    public static void createParticles(WorldAccess world, BlockPos pos, int count) {
        BlockState blockState = world.getBlockState(pos);
        if (blockState.getBlock() instanceof GrassBlock || blockState.isOf(Blocks.DIRT)) {
            ParticleUtil.spawnParticlesAround(world, pos.up(), count, ParticleTypes.DUST_PLUME);
        } else if (blockState.isOf(Blocks.WATER)) {
            ParticleUtil.spawnParticlesAround(world, pos.up(), count * 3, 3.0, 1.0, false, ParticleTypes.DUST_PLUME);
        }
    }
}
