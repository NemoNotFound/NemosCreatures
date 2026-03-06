package com.nemonotfound.nemos.creatures;

import com.nemonotfound.nemos.creatures.block.CreaturesBlocks;
import com.nemonotfound.nemos.creatures.block.ModDispenserBehavior;
import com.nemonotfound.nemos.creatures.entity.CreaturesEntityTypes;
import com.nemonotfound.nemos.creatures.item.CreaturesItemGroups;
import com.nemonotfound.nemos.creatures.item.CreaturesItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.entry.ItemEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NemosCreatures implements ModInitializer {

	public static final String MOD_ID = "nemos-creatures";
    public static final Logger log = LoggerFactory.getLogger(MOD_ID);


	@Override
	public void onInitialize() {
		log.info("Thanks for using Nemo's Creatures!!");

		CreaturesEntityTypes.registerSpawnRestrictions();
		CreaturesEntityTypes.registerAttributes();
		CreaturesEntityTypes.addMobsToBiome();
		CreaturesBlocks.bootstrap();
		CreaturesItems.bootstrap();
		CreaturesItemGroups.bootstrap();
		ModDispenserBehavior.registerDefaults();

		LootTableEvents.MODIFY.register((key, tableBuilder, source, wrapperLookup) -> {
			if (source.isBuiltin() && EntityType.PARCHED.getLootTableKey().isPresent() && EntityType.PARCHED.getLootTableKey().get() == key) {
				var pool = LootPool.builder()
						.with(ItemEntry.builder(CreaturesItems.PARCHED_BONE));

				tableBuilder.pool(pool);
			}
		});
	}


}