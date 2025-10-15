package com.nemonotfound.nemos.creatures.entity.mob;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;

public class VenomousZombieEntity extends ZombieEntity {

    public VenomousZombieEntity(EntityType<? extends VenomousZombieEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public boolean tryAttack(ServerWorld world, Entity target) {
        if (super.tryAttack(world, target)) {
            if (target instanceof LivingEntity) {
                var durationMultiplier = 0;

                if (world.getDifficulty() == Difficulty.EASY) {
                    durationMultiplier = 3;
                } else if (world.getDifficulty() == Difficulty.NORMAL) {
                    durationMultiplier = 7;
                } else if (world.getDifficulty() == Difficulty.HARD) {
                    durationMultiplier = 15;
                }

                ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, durationMultiplier * 20, 0), this);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean canHaveStatusEffect(StatusEffectInstance effect) {
        if (effect.getEffectType() == StatusEffects.POISON) {
            return false;
        }
        return super.canHaveStatusEffect(effect);
    }
}
