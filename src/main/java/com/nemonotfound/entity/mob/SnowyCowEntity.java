package com.nemonotfound.entity.mob;

import com.nemonotfound.entity.ModEntityTypes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class SnowyCowEntity extends CowEntity {

    public SnowyCowEntity(EntityType<? extends CowEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    @Nullable
    public CowEntity createChild(ServerWorld world, PassiveEntity entity) {
        return ModEntityTypes.SNOWY_COW.create(world);
    }
}
