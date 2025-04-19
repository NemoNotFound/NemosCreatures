package com.nemonotfound.nemos.creatures.entity.mob;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.SpiderEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;

public class SnowySpiderEntity extends SpiderEntity {

    public SnowySpiderEntity(EntityType<? extends SnowySpiderEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public boolean tryAttack(ServerWorld world, Entity target) {
        if (super.tryAttack(world, target)) {
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
                    ((LivingEntity)target).addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, durationMultiplier * 20, 0), this);
                }
            }
            return true;
        }
        return false;
    }
}
