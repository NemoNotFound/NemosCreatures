package com.nemonotfound.nemos.creatures.entity.mob;

import net.minecraft.entity.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.SpiderEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Difficulty;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class IceSpiderEntity extends SpiderEntity {

    public IceSpiderEntity(EntityType<? extends IceSpiderEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder createIceSpiderAttributes() {
        return SpiderEntity.createSpiderAttributes()
                .add(EntityAttributes.MAX_HEALTH, 10.0)
                .add(EntityAttributes.ATTACK_DAMAGE, 4.0)
                .add(EntityAttributes.MOVEMENT_SPEED, 0.28);
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
                    ((LivingEntity)target).addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, durationMultiplier * 40, 0), this);
                }
            }
            return true;
        }
        return false;
    }

    @Override
    @Nullable
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData) {
        return entityData;
    }

    @Override
    protected Vec3d getPassengerAttachmentPos(Entity passenger, EntityDimensions dimensions, float scaleFactor) {
        return new Vec3d(0.0f, 0.21875 * (double)this.getScale(), 0.0f);
    }
}
