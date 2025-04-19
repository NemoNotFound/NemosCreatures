package com.nemonotfound.nemos.creatures.entity.mob;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;

import java.util.Collection;
import java.util.List;

public class FrozenCreeperEntity extends CreeperEntity {

    public FrozenCreeperEntity(EntityType<? extends CreeperEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public Collection<StatusEffectInstance> getStatusEffects() {
        return List.of(new StatusEffectInstance(StatusEffects.SLOWNESS, 400, 0));
    }

    @Override
    public boolean canHaveStatusEffect(StatusEffectInstance effect) {
        if (effect.getEffectType() == StatusEffects.SLOWNESS) {
            return false;
        }
        return super.canHaveStatusEffect(effect);
    }

    public static DefaultAttributeContainer.Builder createCreeperAttributes() {
        return HostileEntity.createHostileAttributes().add(EntityAttributes.MOVEMENT_SPEED, 0.23);
    }
}
