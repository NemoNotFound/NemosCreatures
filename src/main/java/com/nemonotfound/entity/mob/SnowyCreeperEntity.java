package com.nemonotfound.entity.mob;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.world.World;

import java.util.Collection;
import java.util.List;

public class SnowyCreeperEntity extends CreeperEntity {

    public SnowyCreeperEntity(EntityType<? extends CreeperEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public Collection<StatusEffectInstance> getStatusEffects() {
        return List.of(new StatusEffectInstance(StatusEffects.SLOWNESS, 200, 0));
    }

    @Override
    public boolean canHaveStatusEffect(StatusEffectInstance effect) {
        if (effect.getEffectType() == StatusEffects.SLOWNESS) {
            return false;
        }
        return super.canHaveStatusEffect(effect);
    }
}
