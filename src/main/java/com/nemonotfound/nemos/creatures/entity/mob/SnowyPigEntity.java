package com.nemonotfound.nemos.creatures.entity.mob;

import com.nemonotfound.nemos.creatures.entity.CreaturesEntityTypes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class SnowyPigEntity extends PigEntity {

    public SnowyPigEntity(EntityType<? extends PigEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    @Nullable
    public PigEntity createChild(ServerWorld world, PassiveEntity entity) {
        return CreaturesEntityTypes.SNOWY_PIG.create(world, SpawnReason.BREEDING);
    }
}
