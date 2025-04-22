package com.nemonotfound.nemos.creatures.block;

import com.nemonotfound.nemos.creatures.item.CrimsonBoneMealItem;
import com.nemonotfound.nemos.creatures.item.ModItems;
import com.nemonotfound.nemos.creatures.item.ScorchedBoneMealItem;
import com.nemonotfound.nemos.creatures.item.WarpedBoneMealItem;
import com.nemonotfound.nemos.creatures.world.ModWorldEvents;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.FallibleItemDispenserBehavior;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPointer;

public interface ModDispenserBehavior {

    static void registerDefaults() {
        DispenserBlock.registerBehavior(ModItems.SCORCHED_BONE_MEAL, new FallibleItemDispenserBehavior() {
            @Override
            protected ItemStack dispenseSilently(BlockPointer pointer, ItemStack stack) {
                this.setSuccess(true);
                var world = pointer.world();
                var blockPos = pointer.pos().offset(pointer.state().get(DispenserBlock.FACING));
                var blockState = world.getBlockState(blockPos);

                if (!ScorchedBoneMealItem.useOnDryableBlock(world, blockState, blockPos, stack)) {
                    this.setSuccess(false);
                } else if (!world.isClient) {
                    world.syncWorldEvent(ModWorldEvents.SCORCHED_BONE_MEAL_USED, blockPos, 15);
                }

                return stack;
            }
        });

        DispenserBlock.registerBehavior(ModItems.CRIMSON_BONE_MEAL, new FallibleItemDispenserBehavior() {
            @Override
            protected ItemStack dispenseSilently(BlockPointer pointer, ItemStack stack) {
                this.setSuccess(true);
                var world = pointer.world();
                var blockPos = pointer.pos().offset(pointer.state().get(DispenserBlock.FACING));
                var blockState = world.getBlockState(blockPos);

                if (!CrimsonBoneMealItem.useOnReplaceable(world, blockState, blockPos, stack) && !CrimsonBoneMealItem.useOnCrimsonNylium(stack, world, blockState, blockPos)) {
                    this.setSuccess(false);
                } else if (!world.isClient) {
                    world.syncWorldEvent(ModWorldEvents.CRIMSON_BONE_MEAL_USED, blockPos, 15);
                }

                return stack;
            }
        });

        DispenserBlock.registerBehavior(ModItems.WARPED_BONE_MEAL, new FallibleItemDispenserBehavior() {
            @Override
            protected ItemStack dispenseSilently(BlockPointer pointer, ItemStack stack) {
                this.setSuccess(true);
                var world = pointer.world();
                var blockPos = pointer.pos().offset(pointer.state().get(DispenserBlock.FACING));
                var blockState = world.getBlockState(blockPos);

                if (!WarpedBoneMealItem.useOnReplaceable(world, blockState, blockPos, stack) && !WarpedBoneMealItem.useOnWarpedNylium(stack, world, blockState, blockPos)) {
                    this.setSuccess(false);
                } else if (!world.isClient) {
                    world.syncWorldEvent(ModWorldEvents.WARPED_BONE_MEAL_USED, blockPos, 15);
                }

                return stack;
            }
        });
    }
}
