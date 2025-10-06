package com.nemonotfound.nemos.creatures.mixin;

import com.nemonotfound.nemos.creatures.entity.CreaturesEntityTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Blocks.class)
public class BlocksMixin {

    @Inject(at = @At("HEAD"), method = "canSpawnOnLeaves", cancellable = true)
    private static void canSpawnOnLeaves(BlockState state, BlockView world, BlockPos pos, EntityType<?> type, CallbackInfoReturnable<Boolean> cir) {
        if (type == CreaturesEntityTypes.VENOMOUS_SPIDER) {
            cir.setReturnValue(true);
        }
    }
}
