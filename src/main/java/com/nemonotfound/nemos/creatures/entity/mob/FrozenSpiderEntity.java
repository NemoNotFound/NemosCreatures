package com.nemonotfound.nemos.creatures.entity.mob;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.SpiderEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;

public class FrozenSpiderEntity extends SpiderEntity {

    public FrozenSpiderEntity(EntityType<? extends FrozenSpiderEntity> entityType, World world) {
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

                if (durationMultiplier > 0) {
                    ((LivingEntity)target).addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, durationMultiplier * 40, 0), this);
                }
            }
            return true;
        }
        return false;
    }

    public static DefaultAttributeContainer.Builder createSpiderAttributes() {
        return HostileEntity.createHostileAttributes().add(EntityAttributes.MAX_HEALTH, 18.0).
                add(EntityAttributes.MOVEMENT_SPEED, 0.28);
    }
}
