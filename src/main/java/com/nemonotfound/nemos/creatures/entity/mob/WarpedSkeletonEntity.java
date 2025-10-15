package com.nemonotfound.nemos.creatures.entity.mob;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.AbstractSkeletonEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.TurtleEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.World;

public class WarpedSkeletonEntity extends AbstractSkeletonEntity {

    public WarpedSkeletonEntity(EntityType<? extends AbstractSkeletonEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public boolean canFreeze() {
        return false;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_SKELETON_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_SKELETON_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_SKELETON_DEATH;
    }

    @Override
    protected SoundEvent getStepSound() {
        return SoundEvents.ENTITY_SKELETON_STEP;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(this.getStepSound(), 0.15F, 0.5F);
    }

    @Override
    public float getSoundPitch() {
        return 1.1F;
    }

    @Override
    public float getSoundVolume() {
        return 0.8F;
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(3, new FleeEntityGoal<>(this, WolfEntity.class, 6.0f, 1.0, 1.2));
        this.goalSelector.add(5, new WanderAroundFarGoal(this, 1.0));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 8.0f));
        this.goalSelector.add(6, new LookAroundGoal(this));
        this.targetSelector.add(1, new RevengeGoal(this));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, IronGolemEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, TurtleEntity.class, 10, true, false, TurtleEntity.BABY_TURTLE_ON_LAND_FILTER));
    }

    @Override
    protected void initEquipment(Random random, LocalDifficulty localDifficulty) {
        super.initEquipment(random, localDifficulty);
        ItemStack bow = new ItemStack(Items.BOW);
        this.equipStack(EquipmentSlot.MAINHAND, bow);
    }

    @Override
    public void equipStack(EquipmentSlot slot, ItemStack stack) {
        super.equipStack(slot, stack);
        if (!this.getEntityWorld().isClient()) {
            this.updateAttackType();
        }
    }

    @Override
    public void shootAt(LivingEntity target, float pullProgress) {
        var bow = this.getStackInHand(ProjectileUtil.getHandPossiblyHolding(this, Items.BOW));
        var projectile = this.getProjectileType(bow);
        var persistentProjectileEntity = this.createArrowProjectile(projectile, pullProgress, bow);
        persistentProjectileEntity.setInvisible(true);
        var d = target.getX() - this.getX();
        var e = target.getBodyY(0.3333333333333333) - persistentProjectileEntity.getY();
        var f = target.getZ() - this.getZ();
        var g = Math.sqrt(d * d + f * f);
        var world = getEntityWorld();

        if (world instanceof ServerWorld serverWorld) {
            ProjectileEntity.spawnWithVelocity(persistentProjectileEntity, serverWorld, projectile, d, e + g * (double)0.1f, f, 2.5f, 7 - world.getDifficulty().getId() * 4);
        }

        this.playSound(SoundEvents.ENTITY_SKELETON_SHOOT, 1.0f, 1.0f / (this.getRandom().nextFloat() * 0.2f + 0.6f));
    }
}
