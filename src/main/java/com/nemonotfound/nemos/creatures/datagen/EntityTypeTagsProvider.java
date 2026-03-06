package com.nemonotfound.nemos.creatures.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.EntityTypeTags;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

import static com.nemonotfound.nemos.creatures.entity.CreaturesEntityTypes.*;

public class EntityTypeTagsProvider extends FabricTagProvider.EntityTypeTagProvider {

    public EntityTypeTagsProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.@NonNull WrapperLookup wrapperLookup) {
        valueLookupBuilder(EntityTypeTags.SKELETONS)
                .add(CRIMSON_SKELETON)
                .add(SNOWY_SKELETON)
                .add(FROZEN_SKELETON)
                .add(VENOMOUS_SKELETON)
                .add(WARPED_SKELETON);

        valueLookupBuilder(EntityTypeTags.ZOMBIES)
                .add(SNOWY_ZOMBIE)
                .add(FROZEN_ZOMBIE)
                .add(VENOMOUS_ZOMBIE);

        valueLookupBuilder(EntityTypeTags.BURN_IN_DAYLIGHT)
                .add(CRIMSON_SKELETON)
                .add(SNOWY_SKELETON)
                .add(FROZEN_SKELETON)
                .add(VENOMOUS_SKELETON)
                .add(WARPED_SKELETON)
                .add(SNOWY_ZOMBIE)
                .add(FROZEN_ZOMBIE)
                .add(VENOMOUS_ZOMBIE);
    }
}
