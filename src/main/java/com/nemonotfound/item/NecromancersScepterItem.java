package com.nemonotfound.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Heightmap;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;

import java.util.Random;

public class NecromancersScepterItem extends Item {

    public NecromancersScepterItem(Settings settings) {
        super(settings);
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        super.onStoppedUsing(stack, world, user, remainingUseTicks);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);

        if (world.isClient) {
            return TypedActionResult.pass(itemStack);
        }

        world.playSound(null, user.getBlockPos(), SoundEvents.ENTITY_EVOKER_PREPARE_SUMMON, SoundCategory.HOSTILE, 0.5f, 1);
        summonZombies(world, user);

        return TypedActionResult.success(itemStack, world.isClient());
    }

    private void summonZombies(World world, PlayerEntity user) {
        Random random = new Random();
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

            ZombieEntity zombieEntity = new ZombieEntity(world);
            BlockPos spawnPos = world.getTopPosition(Heightmap.Type.MOTION_BLOCKING, user.getBlockPos());
            int x = spawnPos.getX() + randomXOffset;
            int y = spawnPos.getY();
            int z = spawnPos.getZ() + randomZOffset;
            zombieEntity.setPos(x, y, z);
            zombieEntity.initialize((ServerWorldAccess) world, world.getLocalDifficulty(zombieEntity.getBlockPos()), SpawnReason.EVENT, null);
            zombieEntity.wakeUp();

            world.spawnEntity(zombieEntity);
        }
    }
}
