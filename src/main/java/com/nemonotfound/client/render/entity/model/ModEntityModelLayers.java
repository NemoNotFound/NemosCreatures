package com.nemonotfound.client.render.entity.model;

import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

import static com.nemonotfound.NemosCreatures.MOD_ID;
import static com.nemonotfound.NemosCreatures.log;

public class ModEntityModelLayers {

    private static final String MAIN = "main";
    private static final String INNER_ARMOR = "inner_armor";
    private static final String OUTER_ARMOR = "outer_armor";

    public static final EntityModelLayer VENOMOUS_SKELETON = createEntityModelLayer("venomous_skeleton", MAIN);
    public static final EntityModelLayer VENOMOUS_SKELETON_INNER_ARMOR = createEntityModelLayer("venomous_skeleton", INNER_ARMOR);
    public static final EntityModelLayer VENOMOUS_SKELETON_OUTER_ARMOR = createEntityModelLayer("venomous_skeleton", OUTER_ARMOR);
    public static final EntityModelLayer VENOMOUS_SKELETON_OUTER = createEntityModelLayer("venomous_skeleton", "outer");
    public static final EntityModelLayer VENOMOUS_SPIDER = createEntityModelLayer("venomous_spider", MAIN);
    public static final EntityModelLayer VENOMOUS_ZOMBIE = createEntityModelLayer("venomous_zombie", MAIN);
    public static final EntityModelLayer VENOMOUS_ZOMBIE_INNER_ARMOR = createEntityModelLayer("venomous_zombie", INNER_ARMOR);
    public static final EntityModelLayer VENOMOUS_ZOMBIE_OUTER_ARMOR = createEntityModelLayer("venomous_zombie", OUTER_ARMOR);
    public static final EntityModelLayer VENOMOUS_ZOMBIE_BABY = createEntityModelLayer("venomous_zombie_baby", MAIN);
    public static final EntityModelLayer VENOMOUS_ZOMBIE_BABY_INNER_ARMOR = createEntityModelLayer("venomous_zombie_baby", INNER_ARMOR);
    public static final EntityModelLayer VENOMOUS_ZOMBIE_BABY_OUTER_ARMOR = createEntityModelLayer("venomous_zombie_baby", OUTER_ARMOR);
    public static final EntityModelLayer SCORCHED_SKELETON = createEntityModelLayer("scorched_skeleton", MAIN);
    public static final EntityModelLayer SCORCHED_SKELETON_INNER_ARMOR = createEntityModelLayer("scorched_skeleton", INNER_ARMOR);
    public static final EntityModelLayer SCORCHED_SKELETON_OUTER_ARMOR = createEntityModelLayer("scorched_skeleton", OUTER_ARMOR);
    public static final EntityModelLayer SAND_SPIDER = createEntityModelLayer("sand_spider", MAIN);
    public static final EntityModelLayer MUMMY = createEntityModelLayer("mummy", MAIN);
    public static final EntityModelLayer MUMMY_INNER_ARMOR = createEntityModelLayer("mummy", INNER_ARMOR);
    public static final EntityModelLayer MUMMY_OUTER_ARMOR = createEntityModelLayer("mummy", OUTER_ARMOR);
    public static final EntityModelLayer MUMMY_BABY = createEntityModelLayer("mummy_baby", MAIN);
    public static final EntityModelLayer MUMMY_BABY_INNER_ARMOR = createEntityModelLayer("mummy_baby", INNER_ARMOR);
    public static final EntityModelLayer MUMMY_BABY_OUTER_ARMOR = createEntityModelLayer("mummy_baby", OUTER_ARMOR);
    public static final EntityModelLayer CRIMSON_SKELETON = createEntityModelLayer("crimson_skeleton", MAIN);
    public static final EntityModelLayer CRIMSON_SKELETON_INNER_ARMOR = createEntityModelLayer("crimson_skeleton", INNER_ARMOR);
    public static final EntityModelLayer CRIMSON_SKELETON_OUTER_ARMOR = createEntityModelLayer("crimson_skeleton", OUTER_ARMOR);
    public static final EntityModelLayer WARPED_SKELETON = createEntityModelLayer("warped_skeleton", MAIN);
    public static final EntityModelLayer WARPED_SKELETON_INNER_ARMOR = createEntityModelLayer("warped_skeleton", INNER_ARMOR);
    public static final EntityModelLayer WARPED_SKELETON_OUTER_ARMOR = createEntityModelLayer("warped_skeleton", OUTER_ARMOR);
    public static final EntityModelLayer WILD_BOAR = createEntityModelLayer("wild_boar", MAIN);
    public static final EntityModelLayer WILD_BOAR_BABY = createEntityModelLayer("wild_boar_baby", MAIN);
    public static final EntityModelLayer SNOWY_SKELETON = createEntityModelLayer("snowy_skeleton", MAIN);
    public static final EntityModelLayer SNOWY_SKELETON_INNER_ARMOR = createEntityModelLayer("snowy_skeleton", INNER_ARMOR);
    public static final EntityModelLayer SNOWY_SKELETON_OUTER_ARMOR = createEntityModelLayer("snowy_skeleton", OUTER_ARMOR);
    public static final EntityModelLayer SNOWY_PIG = createEntityModelLayer("snowy_pig", MAIN);
    public static final EntityModelLayer SNOWY_PIG_BABY = createEntityModelLayer("snowy_pig_baby", MAIN);
    public static final EntityModelLayer SNOWY_COW = createEntityModelLayer("snowy_cow", MAIN);
    public static final EntityModelLayer SNOWY_COW_BABY = createEntityModelLayer("snowy_cow_baby", MAIN);
    public static final EntityModelLayer SNOWY_SPIDER = createEntityModelLayer("snowy_spider", MAIN);
    public static final EntityModelLayer SNOW_SPIDER = createEntityModelLayer("snow_spider", MAIN);
    public static final EntityModelLayer SNOWY_ZOMBIE = createEntityModelLayer("snowy_zombie", MAIN);
    public static final EntityModelLayer SNOWY_ZOMBIE_INNER_ARMOR = createEntityModelLayer("snowy_zombie", INNER_ARMOR);
    public static final EntityModelLayer SNOWY_ZOMBIE_OUTER_ARMOR = createEntityModelLayer("snowy_zombie", OUTER_ARMOR);
    public static final EntityModelLayer SNOWY_ZOMBIE_BABY = createEntityModelLayer("snowy_zombie_baby", MAIN);
    public static final EntityModelLayer SNOWY_ZOMBIE_BABY_INNER_ARMOR = createEntityModelLayer("snowy_zombie_baby", INNER_ARMOR);
    public static final EntityModelLayer SNOWY_ZOMBIE_BABY_OUTER_ARMOR = createEntityModelLayer("snowy_zombie_baby", OUTER_ARMOR);
    public static final EntityModelLayer FROZEN_SKELETON = createEntityModelLayer("frozen_skeleton", MAIN);
    public static final EntityModelLayer FROZEN_SKELETON_INNER_ARMOR = createEntityModelLayer("frozen_skeleton", INNER_ARMOR);
    public static final EntityModelLayer FROZEN_SKELETON_OUTER_ARMOR = createEntityModelLayer("frozen_skeleton", OUTER_ARMOR);
    public static final EntityModelLayer FROZEN_SPIDER = createEntityModelLayer("frozen_spider", MAIN);
    public static final EntityModelLayer ICE_SPIDER = createEntityModelLayer("ice_spider", MAIN);
    public static final EntityModelLayer FROZEN_ZOMBIE = createEntityModelLayer("frozen_zombie", MAIN);
    public static final EntityModelLayer FROZEN_ZOMBIE_INNER_ARMOR = createEntityModelLayer("frozen_zombie", INNER_ARMOR);
    public static final EntityModelLayer FROZEN_ZOMBIE_OUTER_ARMOR = createEntityModelLayer("frozen_zombie", OUTER_ARMOR);
    public static final EntityModelLayer FROZEN_ZOMBIE_BABY = createEntityModelLayer("frozen_zombie_baby", MAIN);
    public static final EntityModelLayer FROZEN_ZOMBIE_BABY_INNER_ARMOR = createEntityModelLayer("frozen_zombie_baby", INNER_ARMOR);
    public static final EntityModelLayer FROZEN_ZOMBIE_BABY_OUTER_ARMOR = createEntityModelLayer("frozen_zombie_baby", OUTER_ARMOR);

    public static void registerEntityModelLayers() {
        log.info("Register entity model layers");
    }
    
    public static EntityModelLayer createEntityModelLayer(String path, String layer) {
        return new EntityModelLayer(Identifier.of(MOD_ID, path), layer);
    }
}
