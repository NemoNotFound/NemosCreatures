package com.nemonotfound;

import com.nemonotfound.entity.Entities;
import com.nemonotfound.item.Items;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NemosCreatures implements ModInitializer {

	public static final String MOD_ID = "nemos-creatures";
    public static final Logger log = LoggerFactory.getLogger(MOD_ID);


	@Override
	public void onInitialize() {
		log.info("Thanks for using Nemo's Creatures!!");

		Entities.registerSpawnRestrictions();
		Entities.registerAttributes();
		Entities.replaceMobsForBiomes();
		Items.registerItems();
	}


}