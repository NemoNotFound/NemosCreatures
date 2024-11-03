package com.nemonotfound.entity.mob;

import net.minecraft.entity.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.SpiderEntity;
import net.minecraft.nbt.NbtCompound;
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
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 10.0)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 4.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.28);
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

    @Override
    @Nullable
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
        return entityData;
    }

    @Override
    protected float getActiveEyeHeight(EntityPose pose, EntityDimensions dimensions) {
        return 0.5f;
    }
}
