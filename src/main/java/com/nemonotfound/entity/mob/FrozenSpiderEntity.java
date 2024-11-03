package com.nemonotfound.entity.mob;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.SpiderEntity;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;

public class FrozenSpiderEntity extends SpiderEntity {

    public FrozenSpiderEntity(EntityType<? extends FrozenSpiderEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public boolean tryAttack(Entity target) {
        if (super.tryAttack(target)) {
            if (target instanceof LivingEntity) {
                int durationMultiplier = 0;

                if (this.getWorld().getDifficulty() == Difficulty.EASY) {
                    durationMultiplier = 3;
                } else if (this.getWorld().getDifficulty() == Difficulty.NORMAL) {
                    durationMultiplier = 7;
                } else if (this.getWorld().getDifficulty() == Difficulty.HARD) {
                    durationMultiplier = 15;
                }

                if (durationMultiplier > 0) {
                    ((LivingEntity)target).addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, durationMultiplier * 40, 0), this);
                }
            }
            return true;
        }
        return false;
    }

    public static DefaultAttributeContainer.Builder createSpiderAttributes() {
        return HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 18.0).
                add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.28);
    }
}
