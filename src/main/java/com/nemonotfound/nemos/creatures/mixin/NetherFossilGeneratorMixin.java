package com.nemonotfound.nemos.creatures.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.Identifier;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Util;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.levelgen.structure.structures.NetherFossilPieces;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.Arrays;
import java.util.stream.Stream;

import static com.nemonotfound.nemos.creatures.NemosCreatures.MOD_ID;

@Mixin(NetherFossilPieces.class)
public class NetherFossilGeneratorMixin {

    @Shadow @Final private static Identifier[] FOSSILS;
    @Unique
    private static final Identifier[] CUSTOM_FOSSILS = new Identifier[]{
            Identifier.fromNamespaceAndPath(MOD_ID, "crimson_nether_fossils/fossil_1"),
            Identifier.fromNamespaceAndPath(MOD_ID, "crimson_nether_fossils/fossil_2"),
            Identifier.fromNamespaceAndPath(MOD_ID, "crimson_nether_fossils/fossil_3"),
            Identifier.fromNamespaceAndPath(MOD_ID, "crimson_nether_fossils/fossil_4"),
            Identifier.fromNamespaceAndPath(MOD_ID, "crimson_nether_fossils/fossil_5"),
            Identifier.fromNamespaceAndPath(MOD_ID, "crimson_nether_fossils/fossil_6"),
            Identifier.fromNamespaceAndPath(MOD_ID, "crimson_nether_fossils/fossil_7"),
            Identifier.fromNamespaceAndPath(MOD_ID, "crimson_nether_fossils/fossil_8"),
            Identifier.fromNamespaceAndPath(MOD_ID, "crimson_nether_fossils/fossil_9"),
            Identifier.fromNamespaceAndPath(MOD_ID, "crimson_nether_fossils/fossil_10"),
            Identifier.fromNamespaceAndPath(MOD_ID, "crimson_nether_fossils/fossil_11"),
            Identifier.fromNamespaceAndPath(MOD_ID, "crimson_nether_fossils/fossil_12"),
            Identifier.fromNamespaceAndPath(MOD_ID, "crimson_nether_fossils/fossil_13"),
            Identifier.fromNamespaceAndPath(MOD_ID, "crimson_nether_fossils/fossil_14"),
            Identifier.fromNamespaceAndPath(MOD_ID, "warped_nether_fossils/fossil_1"),
            Identifier.fromNamespaceAndPath(MOD_ID, "warped_nether_fossils/fossil_2"),
            Identifier.fromNamespaceAndPath(MOD_ID, "warped_nether_fossils/fossil_3"),
            Identifier.fromNamespaceAndPath(MOD_ID, "warped_nether_fossils/fossil_4"),
            Identifier.fromNamespaceAndPath(MOD_ID, "warped_nether_fossils/fossil_5"),
            Identifier.fromNamespaceAndPath(MOD_ID, "warped_nether_fossils/fossil_6"),
            Identifier.fromNamespaceAndPath(MOD_ID, "warped_nether_fossils/fossil_7"),
            Identifier.fromNamespaceAndPath(MOD_ID, "warped_nether_fossils/fossil_8"),
            Identifier.fromNamespaceAndPath(MOD_ID, "warped_nether_fossils/fossil_9"),
            Identifier.fromNamespaceAndPath(MOD_ID, "warped_nether_fossils/fossil_10"),
            Identifier.fromNamespaceAndPath(MOD_ID, "warped_nether_fossils/fossil_11"),
            Identifier.fromNamespaceAndPath(MOD_ID, "warped_nether_fossils/fossil_12"),
            Identifier.fromNamespaceAndPath(MOD_ID, "warped_nether_fossils/fossil_13"),
            Identifier.fromNamespaceAndPath(MOD_ID, "warped_nether_fossils/fossil_14")
    };

    @ModifyArg(method = "addPieces", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/levelgen/structure/pieces/StructurePiecesBuilder;addPiece(Lnet/minecraft/world/level/levelgen/structure/StructurePiece;)V"), index = 0)
    private static StructurePiece addPieces(StructurePiece piece, @Local(argsOnly = true) StructureTemplateManager manager, @Local(argsOnly = true) BlockPos pos, @Local Rotation rotation, @Local(argsOnly = true) RandomSource random) {
        var combinedFossils = Stream.concat(Arrays.stream(FOSSILS), Arrays.stream(CUSTOM_FOSSILS))
                .toArray(Identifier[]::new);

        return new NetherFossilPieces.NetherFossilPiece(manager, Util.getRandom(combinedFossils, random), pos, rotation);
    }

}
