package com.nemonotfound.nemos.creatures.datagen;

import com.nemonotfound.nemos.creatures.entity.CreaturesEntityTypes;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.EntityTypeTags;

import java.util.concurrent.CompletableFuture;

public class EntityTypeTagsProvider extends FabricTagProvider.EntityTypeTagProvider {

    public EntityTypeTagsProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(EntityTypeTags.SKELETONS)
                .add(CreaturesEntityTypes.CRIMSON_SKELETON)
                .add(CreaturesEntityTypes.SCORCHED_SKELETON)
                .add(CreaturesEntityTypes.SNOWY_SKELETON)
                .add(CreaturesEntityTypes.FROZEN_SKELETON)
                .add(CreaturesEntityTypes.VENOMOUS_SKELETON)
                .add(CreaturesEntityTypes.WARPED_SKELETON);
    }
}
