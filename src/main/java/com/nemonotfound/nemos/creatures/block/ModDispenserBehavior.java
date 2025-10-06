package com.nemonotfound.nemos.creatures.block;

import com.nemonotfound.nemos.creatures.item.*;
import com.nemonotfound.nemos.creatures.world.CreatureWorldEvents;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.FallibleItemDispenserBehavior;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPointer;

public interface ModDispenserBehavior {

    static void registerDefaults() {
        DispenserBlock.registerBehavior(CreaturesItems.FROZEN_BONE_MEAL, new FallibleItemDispenserBehavior() {
            @Override
            protected ItemStack dispenseSilently(BlockPointer pointer, ItemStack stack) {
                this.setSuccess(true);
                var world = pointer.world();
                var blockPos = pointer.pos().offset(pointer.state().get(DispenserBlock.FACING));
                var fluidState = world.getFluidState(blockPos);

                if (!FrozenBoneMealItem.useOnFluidBlock(world, fluidState, blockPos, stack)) {
                    this.setSuccess(false);
                } else if (!world.isClient) {
                    world.syncWorldEvent(CreatureWorldEvents.FROZEN_BONE_MEAL_USED, blockPos, 15);
                }

                return stack;
            }
        });

        DispenserBlock.registerBehavior(CreaturesItems.SCORCHED_BONE_MEAL, new FallibleItemDispenserBehavior() {
            @Override
            protected ItemStack dispenseSilently(BlockPointer pointer, ItemStack stack) {
                this.setSuccess(true);
                var world = pointer.world();
                var blockPos = pointer.pos().offset(pointer.state().get(DispenserBlock.FACING));
                var blockState = world.getBlockState(blockPos);

                if (!ScorchedBoneMealItem.useOnDryableBlock(world, blockState, blockPos, stack)) {
                    this.setSuccess(false);
                } else if (!world.isClient) {
                    world.syncWorldEvent(CreatureWorldEvents.SCORCHED_BONE_MEAL_USED, blockPos, 15);
                }

                return stack;
            }
        });

        DispenserBlock.registerBehavior(CreaturesItems.CRIMSON_BONE_MEAL, new FallibleItemDispenserBehavior() {
            @Override
            protected ItemStack dispenseSilently(BlockPointer pointer, ItemStack stack) {
                this.setSuccess(true);
                var world = pointer.world();
                var blockPos = pointer.pos().offset(pointer.state().get(DispenserBlock.FACING));
                var blockState = world.getBlockState(blockPos);

                if (!CrimsonBoneMealItem.useOnReplaceable(world, blockState, blockPos, stack) && !CrimsonBoneMealItem.useOnCrimsonNylium(stack, world, blockState, blockPos)) {
                    this.setSuccess(false);
                } else if (!world.isClient) {
                    world.syncWorldEvent(CreatureWorldEvents.CRIMSON_BONE_MEAL_USED, blockPos, 15);
                }

                return stack;
            }
        });

        DispenserBlock.registerBehavior(CreaturesItems.WARPED_BONE_MEAL, new FallibleItemDispenserBehavior() {
            @Override
            protected ItemStack dispenseSilently(BlockPointer pointer, ItemStack stack) {
                this.setSuccess(true);
                var world = pointer.world();
                var blockPos = pointer.pos().offset(pointer.state().get(DispenserBlock.FACING));
                var blockState = world.getBlockState(blockPos);

                if (!WarpedBoneMealItem.useOnReplaceable(world, blockState, blockPos, stack) && !WarpedBoneMealItem.useOnWarpedNylium(stack, world, blockState, blockPos)) {
                    this.setSuccess(false);
                } else if (!world.isClient) {
                    world.syncWorldEvent(CreatureWorldEvents.WARPED_BONE_MEAL_USED, blockPos, 15);
                }

                return stack;
            }
        });
    }
}
