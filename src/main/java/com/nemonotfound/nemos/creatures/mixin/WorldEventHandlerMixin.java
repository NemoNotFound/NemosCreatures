package com.nemonotfound.nemos.creatures.mixin;

import com.nemonotfound.nemos.creatures.item.ScorchedBoneMealItem;
import com.nemonotfound.nemos.creatures.world.ModWorldEvents;
import net.minecraft.client.world.WorldEventHandler;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldEventHandler.class)
public class WorldEventHandlerMixin {

    @Shadow @Final private World world;

    @Inject(method = "processWorldEvent", at = @At(value = "TAIL"))
    private void processWorldEvent(int eventId, BlockPos pos, int data, CallbackInfo ci) {
        if (eventId == ModWorldEvents.SCORCHED_BONE_MEAL_USED) {
            ScorchedBoneMealItem.createParticles(this.world, pos, data);
            this.world.playSoundAtBlockCenterClient(pos, SoundEvents.ITEM_BONE_MEAL_USE, SoundCategory.BLOCKS, 1.0F, 1.0F, false);
        }
    }
}
