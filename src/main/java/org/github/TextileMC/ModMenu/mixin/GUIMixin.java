package org.github.TextileMC.ModMenu.mixin;

import org.github.TextileMC.ModMenu.ModMenuScreen;
import net.minecraft.client.gui.Button;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class GUIMixin extends Screen {

	@Inject(at = @At("TAIL"), method = "init")
	private void injectButton (CallbackInfo ci) {
		this.screenItems.add(new Button(3, this.screenWidth / 2 - 100, this.screenHeight / 4 + 115, "Mods"));
	}

	@Inject(at = @At("TAIL"), method = "onButtonClicked")
	private void buttonClicked(Button arg, CallbackInfo ci) {
		if (arg.id == 3) {
			// Mods button was clicked
			this.mc.showScreen(new ModMenuScreen(this));
		}
	}
}
