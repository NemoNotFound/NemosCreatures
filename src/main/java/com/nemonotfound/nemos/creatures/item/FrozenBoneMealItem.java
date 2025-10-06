package com.nemonotfound.nemos.creatures.item;

import com.nemonotfound.nemos.creatures.world.CreatureWorldEvents;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.particle.ParticleUtil;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.event.GameEvent;

import java.util.Map;

public class FrozenBoneMealItem extends Item {

    private static final Map<Fluid, Block> FLUID_REPLACEMENT_MAP = Map.of(
            Fluids.WATER, Blocks.ICE,
            Fluids.LAVA, Blocks.OBSIDIAN
    );
    private static final Map<Fluid, ParticleEffect> FLUID_PARTICLE_MAP = Map.of(
            Fluids.WATER, ParticleTypes.SPLASH,
            Fluids.LAVA, ParticleTypes.FLAME
    );
    private static final Map<Fluid, SoundEvent> FLUID_SOUND_MAP = Map.of(
            Fluids.WATER, SoundEvents.ITEM_BUCKET_EMPTY_POWDER_SNOW,
            Fluids.LAVA, SoundEvents.BLOCK_LAVA_EXTINGUISH
    );

    public FrozenBoneMealItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        var blockHitResult = raycast(world, user, RaycastContext.FluidHandling.SOURCE_ONLY);
        var hitResultType = blockHitResult.getType();

        if (hitResultType != HitResult.Type.BLOCK) {
            return ActionResult.PASS;
        }

        var blockPos = blockHitResult.getBlockPos();
        var fluidState = world.getFluidState(blockPos);

        if (useOnFluidBlock(world, fluidState, blockPos, user.getActiveItem())) {
            if (!world.isClient) {
                user.emitGameEvent(GameEvent.ITEM_INTERACT_FINISH);
                world.syncWorldEvent(CreatureWorldEvents.FROZEN_BONE_MEAL_USED, blockPos, 15);

            }
        }

        return ActionResult.PASS;
    }

    public static boolean useOnFluidBlock(World world, FluidState fluidState, BlockPos blockPos, ItemStack itemStack) {
        var blockReplacement = FLUID_REPLACEMENT_MAP.get(fluidState.getFluid());

        if (blockReplacement == null) {
            return false;
        }

        if (world instanceof ServerWorld) {
            world.setBlockState(blockPos, blockReplacement.getDefaultState());
            itemStack.decrement(1);
        }

        return true;
    }

    public static void createParticles(WorldAccess world, BlockPos pos, int count) {
        var fluidState = world.getFluidState(pos);
        var blockReplacement = FLUID_REPLACEMENT_MAP.get(fluidState.getFluid());

        if (blockReplacement != null) {
            ParticleUtil.spawnParticlesAround(world, pos.up(), count, FLUID_PARTICLE_MAP.get(fluidState.getFluid()));
        }
    }

    public static void playSound(World world, BlockPos pos) {
        var fluidState = world.getFluidState(pos);
        var blockReplacement = FLUID_REPLACEMENT_MAP.get(fluidState.getFluid());

        if (blockReplacement != null) {
            world.playSoundAtBlockCenterClient(pos, FLUID_SOUND_MAP.get(fluidState.getFluid()), SoundCategory.BLOCKS, 1.0F, 1.0F, false);
        }
    }
}
