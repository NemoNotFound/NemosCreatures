package com.nemonotfound.nemos.creatures.block;

import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Function;

import static com.nemonotfound.nemos.creatures.NemosCreatures.MOD_ID;

public class ModBlocks {

    public static final Block SCORCHED_BONE_BLOCK = register(
            "scorched_bone_block",
            PillarBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.BROWN)
                    .instrument(NoteBlockInstrument.XYLOPHONE)
                    .requiresTool()
                    .strength(2.0F)
                    .sounds(BlockSoundGroup.BONE)
    );
    public static final Block CRIMSON_BONE_BLOCK = register(
            "crimson_bone_block",
            PillarBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.RED)
                    .instrument(NoteBlockInstrument.XYLOPHONE)
                    .requiresTool()
                    .strength(2.0F)
                    .sounds(BlockSoundGroup.BONE)
    );
    public static final Block WARPED_BONE_BLOCK = register(
            "warped_bone_block",
            PillarBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.BLUE)
                    .instrument(NoteBlockInstrument.XYLOPHONE)
                    .requiresTool()
                    .strength(2.0F)
                    .sounds(BlockSoundGroup.BONE)
    );
    //TODO: Add custom bone meal structures to biome

    private static Block register(String id, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        return Blocks.register(keyOf(id), factory, settings);
    }

    private static RegistryKey<Block> keyOf(String id) {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MOD_ID, id));
    }
}
