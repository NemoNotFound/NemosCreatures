package com.nemonotfound.nemos.creatures.block;

import com.nemonotfound.nemos.creatures.item.ModItems;
import com.nemonotfound.nemos.creatures.world.ModWorldEvents;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.FallibleItemDispenserBehavior;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPointer;

import static com.nemonotfound.nemos.creatures.item.ScorchedBoneMealItem.useOnDryableBlock;

public interface ModDispenserBehavior {

    static void registerDefaults() {
        DispenserBlock.registerBehavior(ModItems.SCORCHED_BONE_MEAL, new FallibleItemDispenserBehavior() {
            @Override
            protected ItemStack dispenseSilently(BlockPointer pointer, ItemStack stack) {
                this.setSuccess(true);
                var world = pointer.world();
                var blockPos = pointer.pos().offset(pointer.state().get(DispenserBlock.FACING));
                var blockState = world.getBlockState(blockPos);

                if (useOnDryableBlock(world, blockState, blockPos, stack)) {
                    this.setSuccess(false);
                } else if (!world.isClient) {
                    world.syncWorldEvent(ModWorldEvents.SCORCHED_BONE_MEAL_USED, blockPos, 15);
                }

                return stack;
            }
        });
    }
}
