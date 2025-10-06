package com.nemonotfound.nemos.creatures.registry.tag;

import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import static com.nemonotfound.nemos.creatures.NemosCreatures.MOD_ID;

public class CreatureBlockTags {

    public static final TagKey<Block> CRIMSON_BONE_MEAL_REPLACEABLE = of("crimson_bone_meal_replaceable");
    public static final TagKey<Block> WARPED_BONE_MEAL_REPLACEABLE = of("warped_bone_meal_replaceable");

    private static TagKey<Block> of(String id) {
        return TagKey.of(RegistryKeys.BLOCK, Identifier.of(MOD_ID, id));
    }
}
