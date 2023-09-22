package dev.andrewd1.kahoot;

import dev.andrewd1.kahoot.question.KahootQuestions;
import dev.andrewd1.kahoot.sounds.SoundManager;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KahootMod implements ModInitializer {
	public static final String MOD_ID = "kahoot";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		KahootQuestions.init();
		SoundManager.register();
		LOGGER.info("minecraft but kahoot, wait thats so cursed why did i think of that");
	}
}