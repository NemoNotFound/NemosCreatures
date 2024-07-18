package com.nemonotfound.entity.goal;

import com.nemonotfound.entity.mob.NecromancerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.event.GameEvent;

public class NecromancersSummonGoal extends Goal {


    private final NecromancerEntity entity;
    private final TargetPredicate closeZombiesPredicate;
    private int startTime;
    private int summonCooldown;
    private static final int MIN_SUMMON_COUNT = 2;
    private static final int MAX_SUMMON_COUNT = 5;

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

    private void summonZombies(ServerWorld serverWorld) {
        Random random = entity.getRandom();
        int summonCount = MathHelper.nextInt(random, MIN_SUMMON_COUNT, MAX_SUMMON_COUNT);
        int maxRetryCount = 0;

        for (int i = 0; i < summonCount; i++) {
            if (maxRetryCount >= 50) {
                break;
            }

            ZombieEntity zombieEntity = new ZombieEntity(serverWorld);
            //TODO: Make y variable
            BlockPos spawnPos = entity.getBlockPos().add(getOffset(random), 0, getOffset(random));

            if (!SpawnRestriction.isSpawnPosAllowed(zombieEntity.getType(), serverWorld, spawnPos)) {
                i--;
                maxRetryCount++;
                continue;
            }

            spawnZombie(spawnPos, zombieEntity, serverWorld);
        }
    }

    private int getOffset(Random random) {
        int randomOffset = MathHelper.nextInt(random, 1, 6);

        return random.nextBoolean() ? -randomOffset : randomOffset;
    }

    private void spawnZombie(BlockPos spawnPos, ZombieEntity zombieEntity, ServerWorld serverWorld) {
        int x = spawnPos.getX();
        int y = spawnPos.getY();
        int z = spawnPos.getZ();

        zombieEntity.setPos(x, y, z);
        zombieEntity.initialize(serverWorld, serverWorld.getLocalDifficulty(zombieEntity.getBlockPos()),
                SpawnReason.MOB_SUMMONED, null);
        zombieEntity.refreshPositionAndAngles(spawnPos, 0, 0);

        serverWorld.spawnEntityAndPassengers(zombieEntity);
        serverWorld.emitGameEvent(GameEvent.ENTITY_PLACE, spawnPos, GameEvent.Emitter.of(entity));
    }
}
