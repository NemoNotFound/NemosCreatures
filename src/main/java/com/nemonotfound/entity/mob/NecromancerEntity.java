package com.nemonotfound.entity.mob;

import com.nemonotfound.entity.goal.NecromancersSummonGoal;
import com.nemonotfound.item.ModItems;
import com.nemonotfound.sounds.ModSounds;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.AbstractSkeletonEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class NecromancerEntity extends AbstractSkeletonEntity {

    private int summoningTicks;

    public NecromancerEntity(EntityType<? extends AbstractSkeletonEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.summoningTicks = nbt.getInt("SummoningTicks");
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putInt("SummoningTicks", this.summoningTicks);
    }

    public static DefaultAttributeContainer.Builder createNecromancerAttributes() {
        return AbstractSkeletonEntity.createAbstractSkeletonAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 100)
                .add(EntityAttributes.GENERIC_ARMOR, 10)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 4);
    }

    @Override
    public boolean canFreeze() {
        return false;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.ENTITY_NECROMANCER_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.ENTITY_NECROMANCER_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.ENTITY_NECROMANCER_DEATH;
    }

    @Override
    protected SoundEvent getStepSound() {
        return ModSounds.ENTITY_NECROMANCER_STEP;
    }

    public SoundEvent getSummonPrepareSound() {
        return SoundEvents.ENTITY_EVOKER_PREPARE_SUMMON;
    }

    public SoundEvent getSummonSound() {
        return SoundEvents.ENTITY_EVOKER_CAST_SPELL;
    }

    @Override
    public float getSoundVolume() {
        return 0.5F;
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(4, new NecromancersSummonGoal(this));
        super.initGoals();
    }

    @Override
    protected void initEquipment(Random random, LocalDifficulty localDifficulty) {
        this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(ModItems.NECROMANCERS_SCEPTER));
    }

    @Override
    protected void updateEnchantments(ServerWorldAccess world, Random random, LocalDifficulty localDifficulty) {
    }

    @Override
    @Nullable
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData) {
        EntityData initializedEntityData = super.initialize(world, difficulty, spawnReason, entityData);
        Objects.requireNonNull(this.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE)).setBaseValue(10.0);
        this.updateAttackType();

        return initializedEntityData;
    }

    //TODO: change attack type to necromancersScepter
    public void updateAttackType() {
        super.updateAttackType();
    }

    @Override
    protected void mobTick() {
        super.mobTick();
        if (this.summoningTicks > 0) {
            --this.summoningTicks;
        }
    }

    @Override
    protected PersistentProjectileEntity createArrowProjectile(ItemStack arrow, float damageModifier, @Nullable ItemStack shotFrom) {
        PersistentProjectileEntity persistentProjectileEntity = super.createArrowProjectile(arrow, damageModifier, shotFrom);
        if (persistentProjectileEntity instanceof ArrowEntity) {
            ((ArrowEntity)persistentProjectileEntity).addEffect(new StatusEffectInstance(StatusEffects.HUNGER, 100));
        }
        return persistentProjectileEntity;
    }

    public void setSummoningTicks(int summoningTicks) {
        this.summoningTicks = summoningTicks;
    }
}
