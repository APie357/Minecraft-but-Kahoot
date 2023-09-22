package dev.andrewd1.kahoot.sounds;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

import static dev.andrewd1.kahoot.KahootMod.MOD_ID;

public class SoundManager {
    public static final Identifier LOBBY_ID = new Identifier(MOD_ID, "lobby");
    public static final Identifier LOBBY_8BIT_ID = new Identifier(MOD_ID, "lobby_8bit");
    public static final Identifier GONG_ID = new Identifier(MOD_ID, "gong");
    public static final Identifier ANSWER_20S_ID = new Identifier(MOD_ID, "answer_20s");

    public static final SoundEvent LOBBY = SoundEvent.of(LOBBY_ID);
    public static final SoundEvent LOBBY_8BIT = SoundEvent.of(LOBBY_8BIT_ID);
    public static final SoundEvent GONG = SoundEvent.of(GONG_ID);
    public static final SoundEvent ANSWER_20S = SoundEvent.of(ANSWER_20S_ID);

    public static void register() {
        register(LOBBY_ID, LOBBY);
        register(LOBBY_8BIT_ID, LOBBY_8BIT);
        register(GONG_ID, GONG);
        register(ANSWER_20S_ID, ANSWER_20S);
    }

    private static void register(Identifier id, SoundEvent soundEvent) {
        Registry.register(Registries.SOUND_EVENT, id, soundEvent);
    }
}
