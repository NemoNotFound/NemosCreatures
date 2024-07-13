package com.nemonotfound.sounds;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

import static com.nemonotfound.NemosCreatures.MOD_ID;
import static com.nemonotfound.NemosCreatures.log;

public class ModSounds {

    //TODO: Check if sounds are mono
    public static final SoundEvent ENTITY_NECROMANCER_AMBIENT = registerSound("necromancer_ambient");
    public static final SoundEvent ENTITY_NECROMANCER_HURT = registerSound("necromancer_hurt");
    public static final SoundEvent ENTITY_NECROMANCER_STEP = registerSound("necromancer_step");
    public static final SoundEvent ENTITY_NECROMANCER_DEATH = registerSound("necromancer_death");
    public static final SoundEvent ENTITY_NECROMANCER_PREPARE_SUMMON = registerSound("necromancer_prepare_summon");
    public static final SoundEvent ENTITY_NECROMANCER_SUMMON = registerSound("necromancer_summon");
    public static final SoundEvent ENTITY_NECROMANCER_SPELL = registerSound("necromancer_spell");
    public static final SoundEvent ENTITY_NECROMANCERS_ORB_IMPACT = registerSound("necromancers_orb_impact");

    private static SoundEvent registerSound(String path) {
        Identifier identifier = Identifier.of(MOD_ID, path);
        return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
    }

    public static void initialize() {
        log.info(MOD_ID + ": Registering sounds");
    }
}
