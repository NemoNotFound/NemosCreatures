package com.nemonotfound.nemos.creatures.client.render.entity.model;

import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EquipmentModelData;
import net.minecraft.util.Identifier;

import static com.nemonotfound.nemos.creatures.NemosCreatures.MOD_ID;
import static com.nemonotfound.nemos.creatures.NemosCreatures.log;

public class CreaturesEntityModelLayers {

    private static final String MAIN = "main";
    public static final String OUTER = "outer";

    public static final EntityModelLayer VENOMOUS_SKELETON = createEntityModelLayer("venomous_skeleton", MAIN);
    public static final EquipmentModelData<EntityModelLayer> VENOMOUS_SKELETON_EQUIPMENT = registerEquipment("venomous_skeleton");
    public static final EntityModelLayer VENOMOUS_SKELETON_OUTER_PANTS = createEntityModelLayer("venomous_skeleton_outer_pants", "outer");
    public static final EntityModelLayer VENOMOUS_SKELETON_OUTER = createEntityModelLayer("venomous_skeleton", "outer");
    public static final EntityModelLayer VENOMOUS_SPIDER = createEntityModelLayer("venomous_spider", MAIN);
    public static final EntityModelLayer VENOMOUS_CREEPER_OUTER = createEntityModelLayer("venomous_creeper", OUTER);
    public static final EntityModelLayer VENOMOUS_ZOMBIE = createEntityModelLayer("venomous_zombie", MAIN);
    public static final EquipmentModelData<EntityModelLayer> VENOMOUS_ZOMBIE_EQUIPMENT = registerEquipment("venomous_zombie");
    public static final EntityModelLayer VENOMOUS_ZOMBIE_OUTER = createEntityModelLayer("venomous_zombie", OUTER);
    public static final EntityModelLayer VENOMOUS_ZOMBIE_BABY = createEntityModelLayer("venomous_zombie_baby", MAIN);
    public static final EquipmentModelData<EntityModelLayer> VENOMOUS_ZOMBIE_BABY_EQUIPMENT = registerEquipment("venomous_zombie_baby");
    public static final EntityModelLayer VENOMOUS_ZOMBIE_BABY_OUTER = createEntityModelLayer("venomous_zombie_baby", OUTER);
    public static final EntityModelLayer SCORCHED_SKELETON = createEntityModelLayer("scorched_skeleton", MAIN);
    public static final EquipmentModelData<EntityModelLayer> SCORCHED_SKELETON_EQUIPMENT = registerEquipment("scorched_skeleton");
    public static final EntityModelLayer SAND_SPIDER = createEntityModelLayer("sand_spider", MAIN);
    public static final EntityModelLayer SCORCHED_CREEPER_OUTER = createEntityModelLayer("scorched_creeper", OUTER);
    public static final EntityModelLayer MUMMY = createEntityModelLayer("mummy", MAIN);
    public static final EquipmentModelData<EntityModelLayer> MUMMY_EQUIPMENT = registerEquipment("mummy");
    public static final EntityModelLayer MUMMY_OUTER = createEntityModelLayer("mummy", OUTER);
    public static final EntityModelLayer MUMMY_BABY = createEntityModelLayer("mummy_baby", MAIN);
    public static final EquipmentModelData<EntityModelLayer> MUMMY_BABY_EQUIPMENT = registerEquipment("mummy_baby");
    public static final EntityModelLayer MUMMY_BABY_OUTER = createEntityModelLayer("mummy_baby", OUTER);
    public static final EntityModelLayer CRIMSON_SKELETON = createEntityModelLayer("crimson_skeleton", MAIN);
    public static final EquipmentModelData<EntityModelLayer> CRIMSON_SKELETON_EQUIPMENT = registerEquipment("crimson_skeleton");
    public static final EntityModelLayer WARPED_SKELETON = createEntityModelLayer("warped_skeleton", MAIN);
    public static final EquipmentModelData<EntityModelLayer> WARPED_SKELETON_EQUIPMENT = registerEquipment("warped_skeleton");
    public static final EntityModelLayer WILD_BOAR = createEntityModelLayer("wild_boar", MAIN);
    public static final EntityModelLayer WILD_BOAR_BABY = createEntityModelLayer("wild_boar_baby", MAIN);
    public static final EntityModelLayer SNOWY_SKELETON = createEntityModelLayer("snowy_skeleton", MAIN);
    public static final EquipmentModelData<EntityModelLayer> SNOWY_SKELETON_EQUIPMENT = registerEquipment("snowy_skeleton");
    public static final EntityModelLayer SNOWY_SKELETON_OUTER = createEntityModelLayer("snowy_skeleton", OUTER);
    public static final EntityModelLayer SNOWY_PIG = createEntityModelLayer("snowy_pig", MAIN);
    public static final EntityModelLayer SNOWY_PIG_BABY = createEntityModelLayer("snowy_pig_baby", MAIN);
    public static final EntityModelLayer SNOWY_COW = createEntityModelLayer("snowy_cow", MAIN);
    public static final EntityModelLayer SNOWY_COW_BABY = createEntityModelLayer("snowy_cow_baby", MAIN);
    public static final EntityModelLayer SNOWY_SPIDER = createEntityModelLayer("snowy_spider", MAIN);
    public static final EntityModelLayer SNOW_SPIDER = createEntityModelLayer("snow_spider", MAIN);
    public static final EntityModelLayer SNOWY_CREEPER_OUTER = createEntityModelLayer("snowy_creeper", OUTER);
    public static final EntityModelLayer SNOWY_ZOMBIE = createEntityModelLayer("snowy_zombie", MAIN);
    public static final EquipmentModelData<EntityModelLayer> SNOWY_ZOMBIE_EQUIPMENT = registerEquipment("snowy_zombie");
    public static final EntityModelLayer SNOWY_ZOMBIE_OUTER = createEntityModelLayer("snowy_zombie", OUTER);
    public static final EntityModelLayer SNOWY_ZOMBIE_BABY = createEntityModelLayer("snowy_zombie_baby", MAIN);
    public static final EquipmentModelData<EntityModelLayer> SNOWY_ZOMBIE_BABY_EQUIPMENT = registerEquipment("snowy_zombie_baby");
    public static final EntityModelLayer SNOWY_ZOMBIE_BABY_OUTER = createEntityModelLayer("snowy_zombie_baby", OUTER);
    public static final EntityModelLayer FROZEN_SKELETON = createEntityModelLayer("frozen_skeleton", MAIN);
    public static final EquipmentModelData<EntityModelLayer> FROZEN_SKELETON_EQUIPMENT = registerEquipment("frozen_skeleton");
    public static final EntityModelLayer FROZEN_SPIDER = createEntityModelLayer("frozen_spider", MAIN);
    public static final EntityModelLayer ICE_SPIDER = createEntityModelLayer("ice_spider", MAIN);
    public static final EntityModelLayer FROZEN_ZOMBIE = createEntityModelLayer("frozen_zombie", MAIN);
    public static final EquipmentModelData<EntityModelLayer> FROZEN_ZOMBIE_EQUIPMENT = registerEquipment("frozen_zombie");
    public static final EntityModelLayer FROZEN_ZOMBIE_BABY = createEntityModelLayer("frozen_zombie_baby", MAIN);
    public static final EquipmentModelData<EntityModelLayer> FROZEN_ZOMBIE_BABY_EQUIPMENT = registerEquipment("frozen_zombie_baby");

    public static void registerEntityModelLayers() {
        log.info("Register entity model layers");
    }
    
    private static EntityModelLayer createEntityModelLayer(String path, String layer) {
        return new EntityModelLayer(Identifier.of(MOD_ID, path), layer);
    }

    private static EquipmentModelData<EntityModelLayer> registerEquipment(String path) {
        return new EquipmentModelData<>(createEntityModelLayer(path, "helmet"), createEntityModelLayer(path, "chestplate"), createEntityModelLayer(path, "leggings"), createEntityModelLayer(path, "boots"));
    }
}
