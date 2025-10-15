package com.nemonotfound.nemos.creatures.mixin;

import com.nemonotfound.nemos.creatures.item.CrimsonBoneMealItem;
import com.nemonotfound.nemos.creatures.item.FrozenBoneMealItem;
import com.nemonotfound.nemos.creatures.item.ScorchedBoneMealItem;
import com.nemonotfound.nemos.creatures.item.WarpedBoneMealItem;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.client.world.WorldEventHandler;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static com.nemonotfound.nemos.creatures.world.CreatureWorldEvents.*;

@Mixin(WorldEventHandler.class)
public class WorldEventHandlerMixin {

    @Shadow @Final private ClientWorld world;

    @Inject(method = "processWorldEvent", at = @At(value = "TAIL"))
    private void processWorldEvent(int eventId, BlockPos pos, int count, CallbackInfo ci) {
        switch (eventId) {
            case FROZEN_BONE_MEAL_USED:
                FrozenBoneMealItem.createParticles(this.world, pos, count);
                FrozenBoneMealItem.playSound(this.world, pos);
                playBoneMealUseSound(pos);
            case SCORCHED_BONE_MEAL_USED:
                ScorchedBoneMealItem.createParticles(this.world, pos, count);
                playBoneMealUseSound(pos);
            case CRIMSON_BONE_MEAL_USED:
                CrimsonBoneMealItem.createParticles(this.world, pos, count);
                playBoneMealUseSound(pos);
            case WARPED_BONE_MEAL_USED:
                WarpedBoneMealItem.createParticles(this.world, pos, count);
                playBoneMealUseSound(pos);
        }
    }

    @Unique
    private void playBoneMealUseSound(BlockPos pos) {
        this.world.playSoundAtBlockCenterClient(pos, SoundEvents.ITEM_BONE_MEAL_USE, SoundCategory.BLOCKS, 1.0F, 1.0F, false);
    }
}
