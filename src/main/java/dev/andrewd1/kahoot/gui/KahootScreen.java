package dev.andrewd1.kahoot.gui;

import dev.andrewd1.kahoot.sounds.SoundManager;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.TexturedButtonWidget;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;

@Environment(EnvType.CLIENT)
public class KahootScreen extends Screen {
    private final Screen parent;

    public KahootScreen(@Nullable Screen parent) {
        super(Text.literal("Kahoot"));
        this.parent = parent;
    }

    @Override
    protected void init() {
        super.init();

        int offset = 2;

        int row1 = this.height / 2 - 20 - offset;
        int row2 = this.height / 2 + offset;

        int col1 = this.width / 2 - 150 - offset;
        int col2 = this.width / 2 + offset;

        this.addDrawableChild(new ButtonWidget.Builder(Text.literal("Red Triangle"), btn -> {
            MinecraftClient.getInstance().player.playSound(SoundManager.GONG, 80, 1);
        }).dimensions(col1, row1, 150, 20).build());
        this.addDrawableChild(new ButtonWidget.Builder(Text.literal("Blue Diamond"), btn -> {

        }).dimensions(col2, row1, 150, 20).build());
        this.addDrawableChild(new ButtonWidget.Builder(Text.literal("Yellow Circle"), btn -> {

        }).dimensions(col1, row2, 150, 20).build());
        this.addDrawableChild(new ButtonWidget.Builder(Text.literal("Green Square"), btn -> {

        }).dimensions(col2, row2, 150, 20).build());

        MinecraftClient.getInstance().player.playSound(SoundManager.ANSWER_20S, 80, 1);
    }

    @Override
    public void close() {
        client.setScreen(parent);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
