package dev.andrewd1.kahoot.mixin;

import dev.andrewd1.kahoot.gui.KahootScreen;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.GameMenuScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(GameMenuScreen.class)
public class DebugMenu extends Screen {
	protected DebugMenu(Text title) { super(title); }

	@Inject(at = @At("HEAD"), method = "initWidgets")
	private void init(CallbackInfo info) {
		this.addDrawableChild(
				new ButtonWidget.Builder(Text.literal("DEBUG: Kahoot GUI"), (click) -> {
					client.setScreen(new KahootScreen(client.currentScreen));
				})
						.dimensions(10, 10, 100, 20)
						.build()
		);
	}
}