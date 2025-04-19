package com.nemonotfound.nemos.creatures.entity.mob;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.world.World;

import java.util.Collection;
import java.util.List;

public class VenomousCreeperEntity extends CreeperEntity {

    public VenomousCreeperEntity(EntityType<? extends CreeperEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public Collection<StatusEffectInstance> getStatusEffects() {
        return List.of(new StatusEffectInstance(StatusEffects.POISON, 200, 0));
    }

    @Override
    public boolean canHaveStatusEffect(StatusEffectInstance effect) {
        if (effect.getEffectType() == StatusEffects.POISON) {
            return false;
        }
        return super.canHaveStatusEffect(effect);
    }
}
