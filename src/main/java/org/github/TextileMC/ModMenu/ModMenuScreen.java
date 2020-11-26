package org.github.TextileMC.ModMenu;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.gui.Button;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;

import java.util.concurrent.atomic.AtomicInteger;

public class ModMenuScreen extends Screen {
	public Screen parent;

	public ModMenuScreen(Screen arg) {
		this.parent = arg;
	}

	@Override
	public void init() {
		this.screenItems.add(new Button(1, this.screenWidth / 10, this.screenHeight / 10, "Go back"));
	}

	@Override
	public final void onButtonClicked(Button arg) {
		if (arg.id == 1) {
			this.mc.showScreen(new TitleScreen());
		}
	}

	@Override
	public void render(int mouseX, int mouseY, float delta) {
		this.method_584();
		renderText(this.field_917, "Mods", this.screenWidth / 2, 20, 16777215);

		AtomicInteger counter = new AtomicInteger(40);
		FabricLoader.getInstance().getAllMods().stream().forEachOrdered(modContainer -> {
			renderText(this.field_917, modContainer.getMetadata().getName(), this.screenWidth / 4, counter.get(), 16777215);
			renderText(this.field_917, modContainer.getMetadata().getDescription(), this.screenWidth / 3, counter.get() + 10, 16777215);
			counter.addAndGet(20);
		});
			//LOGGER.info(modContainer.getMetadata().getAuthors());
			//LOGGER.info(modContainer.getMetadata().getDescription());
			//this.screenItems.add(new Button(counter, this.screenWidth / 2 - 100, this.screenHeight / 4 + 115, modContainer.getMetadata().getName()));
		super.render(mouseX, mouseY, delta);
	}
}
