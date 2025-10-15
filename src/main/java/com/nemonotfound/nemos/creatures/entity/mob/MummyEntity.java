package com.nemonotfound.nemos.creatures.entity.mob;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;

public class MummyEntity extends ZombieEntity {

    public MummyEntity(EntityType<? extends MummyEntity> entityType, World world) {
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
                    ((LivingEntity)target).addStatusEffect(new StatusEffectInstance(StatusEffects.HUNGER, durationMultiplier * 20, 0), this);
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public float getSoundPitch() {
        if (this.isBaby()) {
            return 1.3F;
        }
        return 0.7F;
    }

    @Override
    protected boolean isAffectedByDaylight() {
        return false;
    }

    public static DefaultAttributeContainer.Builder createMummyAttributes() {
        return ZombieEntity.createZombieAttributes()
                .add(EntityAttributes.MAX_HEALTH, 30.0)
                .add(EntityAttributes.ATTACK_DAMAGE, 6.0)
                .add(EntityAttributes.MOVEMENT_SPEED, 0.21F);
    }
}
