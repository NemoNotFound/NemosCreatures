package com.nemonotfound.nemos.creatures.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.structure.NetherFossilGenerator;
import net.minecraft.structure.StructurePiece;
import net.minecraft.structure.StructureTemplateManager;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.Arrays;
import java.util.stream.Stream;

import static com.nemonotfound.nemos.creatures.NemosCreatures.MOD_ID;

@Mixin(NetherFossilGenerator.class)
public class NetherFossilGeneratorMixin {

    @Shadow @Final private static Identifier[] FOSSILS;
    @Unique
    private static final Identifier[] CUSTOM_FOSSILS = new Identifier[]{
            Identifier.of(MOD_ID, "crimson_nether_fossils/fossil_1"),
            Identifier.of(MOD_ID, "crimson_nether_fossils/fossil_2"),
            Identifier.of(MOD_ID, "crimson_nether_fossils/fossil_3"),
            Identifier.of(MOD_ID, "crimson_nether_fossils/fossil_4"),
            Identifier.of(MOD_ID, "crimson_nether_fossils/fossil_5"),
            Identifier.of(MOD_ID, "crimson_nether_fossils/fossil_6"),
            Identifier.of(MOD_ID, "crimson_nether_fossils/fossil_7"),
            Identifier.of(MOD_ID, "crimson_nether_fossils/fossil_8"),
            Identifier.of(MOD_ID, "crimson_nether_fossils/fossil_9"),
            Identifier.of(MOD_ID, "crimson_nether_fossils/fossil_10"),
            Identifier.of(MOD_ID, "crimson_nether_fossils/fossil_11"),
            Identifier.of(MOD_ID, "crimson_nether_fossils/fossil_12"),
            Identifier.of(MOD_ID, "crimson_nether_fossils/fossil_13"),
            Identifier.of(MOD_ID, "crimson_nether_fossils/fossil_14"),
            Identifier.of(MOD_ID, "warped_nether_fossils/fossil_1"),
            Identifier.of(MOD_ID, "warped_nether_fossils/fossil_2"),
            Identifier.of(MOD_ID, "warped_nether_fossils/fossil_3"),
            Identifier.of(MOD_ID, "warped_nether_fossils/fossil_4"),
            Identifier.of(MOD_ID, "warped_nether_fossils/fossil_5"),
            Identifier.of(MOD_ID, "warped_nether_fossils/fossil_6"),
            Identifier.of(MOD_ID, "warped_nether_fossils/fossil_7"),
            Identifier.of(MOD_ID, "warped_nether_fossils/fossil_8"),
            Identifier.of(MOD_ID, "warped_nether_fossils/fossil_9"),
            Identifier.of(MOD_ID, "warped_nether_fossils/fossil_10"),
            Identifier.of(MOD_ID, "warped_nether_fossils/fossil_11"),
            Identifier.of(MOD_ID, "warped_nether_fossils/fossil_12"),
            Identifier.of(MOD_ID, "warped_nether_fossils/fossil_13"),
            Identifier.of(MOD_ID, "warped_nether_fossils/fossil_14")
    };

    @ModifyArg(method = "addPieces", at = @At(value = "INVOKE", target = "Lnet/minecraft/structure/StructurePiecesHolder;addPiece(Lnet/minecraft/structure/StructurePiece;)V"), index = 0)
    private static StructurePiece addPieces(StructurePiece piece, @Local(argsOnly = true) StructureTemplateManager manager, @Local(argsOnly = true) BlockPos pos, @Local BlockRotation rotation, @Local(argsOnly = true) Random random) {
        var combinedFossils = Stream.concat(Arrays.stream(FOSSILS), Arrays.stream(CUSTOM_FOSSILS))
                .toArray(Identifier[]::new);

        return new NetherFossilGenerator.Piece(manager, Util.getRandom(combinedFossils, random), pos, rotation);
    }

}
