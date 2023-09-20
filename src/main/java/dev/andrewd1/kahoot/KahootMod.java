package dev.andrewd1.kahoot;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KahootMod implements ModInitializer {
	public static final String MOD_ID = "kahoot";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("minecraft but kahoot, wait thats so cursed why did i think of that");
	}
}