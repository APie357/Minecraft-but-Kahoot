package dev.andrewd1.kahoot.gui;

import dev.andrewd1.kahoot.KahootMod;
import dev.andrewd1.kahoot.question.Question;
import dev.andrewd1.kahoot.sounds.SoundManager;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.TextWidget;
import net.minecraft.client.gui.widget.TexturedButtonWidget;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Environment(EnvType.CLIENT)
public class KahootScreen extends Screen {
    private final Identifier BUTTONS = new Identifier(KahootMod.MOD_ID, "textures/gui/buttons.png");
    private final Screen parent;
    private final Question question;
    private boolean musicStarted = false;

    public KahootScreen(@Nullable Screen parent, @NotNull Question question) {
        super(Text.literal("Kahoot"));
        this.parent = parent;
        this.question = question;
    }

    @Override
    protected void init() {
        super.init();

        int yOffset = 23;
        int btnOffset = 2;
        int textOffset = 8;

        int row1 = this.height / 2 - 20 - btnOffset + yOffset;
        int row2 = this.height / 2 + (btnOffset - 1) + yOffset;

        int col1 = this.width / 2 - 150 - btnOffset;
        int col2 = this.width / 2 + (btnOffset - 1);

        this.addDrawableChild(new TextWidget(this.width / 2 - 150, this.height / 2 - 20, 300 + btnOffset, 10, Text.literal(question.question), client.textRenderer));

        // Red Triangle
        if (!question.answers.isEmpty()) {
            this.addDrawableChild(new TexturedButtonWidget(col1, row1, 150, 20, 0, 20, 20, BUTTONS, 256, 256, btn -> {
                MinecraftClient.getInstance().player.playSound(SoundManager.GONG, 80, 1);
            }));
            this.addDrawableChild(new TextWidget(col1 + textOffset, row1, 150 - textOffset, 20, Text.literal(question.answers.get(0)), client.textRenderer));
        }

        // Blue Diamond
        if (question.answers.size() > 1) {
            this.addDrawableChild(new TexturedButtonWidget(col2, row1, 150, 20, 0, 80, 20, BUTTONS, 256, 256, btn -> {

            }));
            this.addDrawableChild(new TextWidget(col2 + textOffset, row1, 150 - textOffset, 20, Text.literal(question.answers.get(1)), client.textRenderer));
        }

        // Yellow Circle
        if (question.answers.size() > 2) {
            this.addDrawableChild(new TexturedButtonWidget(col1, row2, 150, 20, 0, 140, 20, BUTTONS, 256, 256, btn -> {

            }));
            this.addDrawableChild(new TextWidget(col1 + textOffset, row2, 150 - textOffset, 20, Text.literal(question.answers.get(2)), client.textRenderer));
        }

        // Green Square
        if (question.answers.size() > 3) {
            this.addDrawableChild(new TexturedButtonWidget(col2, row2, 150, 20, 0, 200, 20, BUTTONS, 256, 256, btn -> {

            }));
            this.addDrawableChild(new TextWidget(col2 + textOffset, row2, 150 - textOffset, 20, Text.literal(question.answers.get(3)), client.textRenderer));
        }

        if (!musicStarted) {
            MinecraftClient.getInstance().player.playSound(SoundManager.ANSWER_20S, 80, 1);
            musicStarted = true;
        }
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
