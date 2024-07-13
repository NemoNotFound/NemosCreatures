package com.nemonotfound.entity.goal;

import com.nemonotfound.entity.mob.NecromancerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.Heightmap;
import net.minecraft.world.event.GameEvent;

public class NecromancersSummonGoal extends Goal {


    private final NecromancerEntity entity;
    private final TargetPredicate closeZombiesPredicate;
    private int startTime;
    private int summonCooldown;

    public NecromancersSummonGoal(NecromancerEntity entity) {
        this.entity = entity;
        this.closeZombiesPredicate = TargetPredicate.createNonAttackable().setBaseMaxDistance(16.0).ignoreVisibility().ignoreDistanceScalingFactor();
    }

    @Override
    public boolean shouldContinue() {
        LivingEntity livingEntity = entity.getTarget();
        return livingEntity != null && livingEntity.isAlive() && this.summonCooldown > 0;
    }

    @Override
    public boolean canStart() {
        LivingEntity livingEntity = entity.getTarget();
        if (livingEntity == null || !livingEntity.isAlive()) {
            return false;
        }

        if (entity.isAttacking()) {
            return false;
        }

        if (entity.age < this.startTime) {
            return false;
        }

        int i = entity.getWorld().getTargets(ZombieEntity.class, this.closeZombiesPredicate, entity, entity.getBoundingBox().expand(16.0)).size();
        return entity.getRandom().nextInt(8) + 1 > i;
    }

    @Override
    public void start() {
        this.summonCooldown = this.getTickCount(this.getInitialCooldown());
        entity.setSummoningTicks(this.getSummoningTicks());
        this.startTime = entity.age + this.startTimeDelay();
        entity.playSound(entity.getSummonPrepareSound(), 0.8f, 1.0f);
    }

    @Override
    public void tick() {
        --this.summonCooldown;
        if (this.summonCooldown == 0) {
            entity.playSound(entity.getSummonSound(), 0.8f, 1.0f);
            this.summonZombies();
        }
    }

    private int getInitialCooldown() {
        return 20;
    }

    protected int getSummoningTicks() {
        return 100;
    }

    protected int startTimeDelay() {
        return 340;
    }

    protected void summonZombies() {
        ServerWorld serverWorld = (ServerWorld) entity.getWorld();

        summonZombies(serverWorld);
    }

    //TODO: Fix zombies spawning on top when underground
    private void summonZombies(ServerWorld serverWorld) {
        Random random = entity.getRandom();
        int summonCount = random.nextInt(8 - 4 + 1) + 4;

        for (int i = 0; i < summonCount; i++) {
            int randomXOffset = random.nextInt(8 - 4 + 1) - 4;
            int randomZOffset = random.nextInt(8 - 4 + 1) - 4;

            if (random.nextBoolean()) {
                randomXOffset = -randomXOffset;
            }

            if (random.nextBoolean()) {
                randomZOffset = -randomZOffset;
            }

            ZombieEntity zombieEntity = new ZombieEntity(serverWorld);
            BlockPos spawnPos = serverWorld.getTopPosition(Heightmap.Type.MOTION_BLOCKING,
                    entity.getBlockPos().add(randomXOffset, 0, randomZOffset));
            int x = spawnPos.getX();
            int y = spawnPos.getY();
            int z = spawnPos.getZ();
            zombieEntity.setPos(x, y, z);
            zombieEntity.initialize(serverWorld, serverWorld.getLocalDifficulty(zombieEntity.getBlockPos()), SpawnReason.EVENT, null);
            zombieEntity.refreshPositionAndAngles(spawnPos, 0, 0);
            //zombieEntity.wakeUp();

            serverWorld.spawnEntityAndPassengers(zombieEntity);
            serverWorld.emitGameEvent(GameEvent.ENTITY_PLACE, spawnPos, GameEvent.Emitter.of(entity));
        }
    }
}
