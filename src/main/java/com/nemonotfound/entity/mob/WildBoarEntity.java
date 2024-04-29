package com.nemonotfound.entity.mob;

import com.nemonotfound.entity.Entities;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.Angerable;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TimeHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.*;
import net.minecraft.world.biome.Biome;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public class WildBoarEntity extends AnimalEntity implements Angerable {

    private static final TrackedData<Boolean> ATTACK = DataTracker.registerData(WildBoarEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;
    private static final Ingredient BREEDING_INGREDIENT = Ingredient.ofItems(Items.CARROT, Items.POTATO, Items.BEETROOT);
    private static final UniformIntProvider ANGER_TIME_RANGE = TimeHelper.betweenSeconds(20, 39);
    private int angerTime;
    @Nullable
    private UUID angryAt;

    public WildBoarEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new AttackGoal());
        this.goalSelector.add(1, new BoarEscapeDangerGoal());
        this.goalSelector.add(3, new AnimalMateGoal(this, 1.0));
        this.goalSelector.add(4, new TemptGoal(this, 1.2, BREEDING_INGREDIENT, false));
        this.goalSelector.add(4, new FollowParentGoal(this, 1.1));
        this.goalSelector.add(5, new WanderAroundFarGoal(this, 1.0));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 6.0f));
        this.goalSelector.add(7, new LookAroundGoal(this));
        this.targetSelector.add(1, new BoarRevengeGoal());
        this.targetSelector.add(2, new ProtectBabiesGoal());
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, PlayerEntity.class, 10, true, false, this::isPlayerTooClose));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, PlayerEntity.class, 10, true, false, this::shouldAngerAt));
        this.targetSelector.add(4, new UniversalAngerGoal<>(this, false));
    }

    @Override
    protected void updateLimbs(float posDelta) {
        float f = this.getPose() == EntityPose.STANDING ? Math.min(posDelta * 6.0f, 1.0f) : 0.0f;
        this.limbAnimator.updateLimbs(f, 0.2f);
    }

    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData) {
        if (entityData == null) {
            entityData = new PassiveEntity.PassiveData(1.0f);
        }
        return super.initialize(world, difficulty, spawnReason, entityData);
    }

    public static DefaultAttributeContainer.Builder createBoarAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 15.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 10)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3.0)
                .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 1);
    }

    public static boolean canSpawn(EntityType<WildBoarEntity> type, WorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random) {
        RegistryEntry<Biome> registryEntry = world.getBiome(pos);
        if (registryEntry.isIn(BiomeTags.IS_FOREST)) {
            return isLightLevelValidForNaturalSpawn(world, pos) && world.getBlockState(pos.down()).isIn(BlockTags.ANIMALS_SPAWNABLE_ON);
        }
        return WildBoarEntity.isValidNaturalSpawn(type, world, spawnReason, pos, random);
    }

    protected static boolean isLightLevelValidForNaturalSpawn(BlockRenderView world, BlockPos pos) {
        return world.getBaseLightLevel(pos, 0) > 8;
    }

    public boolean isPlayerTooClose(LivingEntity entity) {
        List<PlayerEntity> closePlayers = WildBoarEntity.this.getWorld()
                .getNonSpectatingEntities(PlayerEntity.class, WildBoarEntity.this.getBoundingBox().expand(5.0, 4.0, 5.0));

        if (!closePlayers.isEmpty() && entity instanceof PlayerEntity) {
            return closePlayers.contains(entity);
        }

        return false;
    }

    @Override
    @Nullable
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return Entities.WILD_BOAR.create(world);
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(ATTACK, false);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_PIG_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_PIG_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_PIG_DEATH;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.ENTITY_PIG_STEP, 0.15f, 1.0f);
    }

    @Override
    public float getSoundPitch() {
        if (this.isBaby()) {
            return 1.3F;
        }
        return 0.7F;
    }

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ActionResult actionResult = super.interactMob(player, hand);

        if (!actionResult.isAccepted()) {
            return ActionResult.PASS;
        }

        return actionResult;
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return BREEDING_INGREDIENT.test(stack);
    }

    @Override
    public void onTrackedDataSet(TrackedData<?> data) {
        super.onTrackedDataSet(data);
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.readAngerFromNbt(this.getWorld(), nbt);
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        this.writeAngerToNbt(nbt);
    }

    @Override
    public Vec3d getLeashOffset() {
        return new Vec3d(0.0, 0.6f * this.getStandingEyeHeight(), this.getWidth() * 0.4f);
    }

    @Override
    public void chooseRandomAngerTime() {
        this.setAngerTime(ANGER_TIME_RANGE.get(this.random));
    }

    @Override
    public void setAngerTime(int angerTime) {
        this.angerTime = angerTime;
    }

    @Override
    public int getAngerTime() {
        return this.angerTime;
    }

    @Override
    public void setAngryAt(@Nullable UUID angryAt) {
        this.angryAt = angryAt;
    }

    @Override
    @Nullable
    public UUID getAngryAt() {
        return this.angryAt;
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.getWorld().isClient) {
            this.tickAngerLogic((ServerWorld)this.getWorld(), true);
        }

        if(this.getWorld().isClient()) {
            setupAnimationStates();
        }
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationTimeout;
        }

        if(this.isAttacking() && this.isAttack() && attackAnimationTimeout <= 0) {
            attackAnimationTimeout = 19;
            attackAnimationState.start(this.age);
        } else {
            --this.attackAnimationTimeout;
        }

        if(!this.isAttacking()) {
            attackAnimationState.stop();
        }
    }

    public boolean isAttack() {
        return this.dataTracker.get(ATTACK);
    }

    public void setAttack(boolean attacking) {
        this.dataTracker.set(ATTACK, attacking);
    }

    @Override
    public boolean tryAttack(Entity target) {
        boolean bl = target.damage(this.getDamageSources().mobAttack(this), (int)this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE));
        if (bl) {
            this.applyDamageEffects(this, target);
        }
        return bl;
    }

    class AttackGoal
            extends MeleeAttackGoal {

        public AttackGoal() {
            super(WildBoarEntity.this, 1.25, true);
        }

        @Override
        protected void attack(LivingEntity target) {
            if (this.canAttack(target)) {
                this.resetCooldown();
                this.mob.tryAttack(target);
                WildBoarEntity.this.setAttack(true);
            } else if (this.mob.squaredDistanceTo(target) < (double)((target.getWidth() + 3.0f) * (target.getWidth() + 3.0f))) {
                if (this.isCooledDown()) {
                    this.resetCooldown();
                }
            } else {
                this.resetCooldown();
                WildBoarEntity.this.setAttack(false);
            }
        }

        @Override
        public void stop() {
            WildBoarEntity.this.setAttack(false);
            super.stop();
        }
    }

    class BoarEscapeDangerGoal
            extends EscapeDangerGoal {
        public BoarEscapeDangerGoal() {
            super(WildBoarEntity.this, 2.0);
        }

        @Override
        protected boolean isInDanger() {
            return this.mob.getAttacker() != null && this.mob.isBaby() || this.mob.isOnFire();
        }
    }

    class BoarRevengeGoal
            extends RevengeGoal {
        public BoarRevengeGoal() {
            super(WildBoarEntity.this);
        }

        @Override
        public void start() {
            super.start();
            if (WildBoarEntity.this.isBaby()) {
                this.callSameTypeForRevenge();
                this.stop();
            }
        }

        @Override
        protected void setMobEntityTarget(MobEntity mob, LivingEntity target) {
            if (mob instanceof WildBoarEntity && !mob.isBaby()) {
                super.setMobEntityTarget(mob, target);
            }
        }
    }

    class ProtectBabiesGoal
            extends ActiveTargetGoal<PlayerEntity> {
        public ProtectBabiesGoal() {
            super(WildBoarEntity.this, PlayerEntity.class, 20, true, true, null);
        }

        @Override
        public boolean canStart() {
            if (WildBoarEntity.this.isBaby()) {
                return false;
            }
            if (super.canStart()) {
                List<WildBoarEntity> list = WildBoarEntity.this.getWorld()
                        .getNonSpectatingEntities(WildBoarEntity.class, WildBoarEntity.this.getBoundingBox().expand(8.0, 4.0, 8.0));
                for (WildBoarEntity wildBoarEntity : list) {
                    if (!wildBoarEntity.isBaby()) continue;
                    return true;
                }
            }
            return false;
        }

        @Override
        protected double getFollowRange() {
            return super.getFollowRange() * 0.5;
        }
    }
}
