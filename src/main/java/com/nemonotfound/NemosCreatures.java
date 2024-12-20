package com.nemonotfound;

import com.nemonotfound.entity.ModEntityTypes;
import com.nemonotfound.item.ModItemGroups;
import com.nemonotfound.item.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NemosCreatures implements ModInitializer {

	public static final String MOD_ID = "nemos-creatures";
    public static final Logger log = LoggerFactory.getLogger(MOD_ID);


	@Override
	public void onInitialize() {
		log.info("Thanks for using Nemo's Creatures!!");

		ModEntityTypes.registerSpawnRestrictions();
		ModEntityTypes.registerAttributes();
		ModEntityTypes.addMobsToBiome();
		ModItems.registerItems();
		ModItemGroups.registerItemGroups();
	}


}