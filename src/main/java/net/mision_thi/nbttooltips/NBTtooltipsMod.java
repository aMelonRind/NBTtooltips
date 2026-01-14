package net.mision_thi.nbttooltips;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.InputUtil;
import net.mision_thi.nbttooltips.config.ModConfigs;
import net.minecraft.client.option.KeyBinding;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NBTtooltipsMod implements ModInitializer {
	public static final MinecraftClient client = MinecraftClient.getInstance();
	public static final String MOD_ID = "NBTtooltips";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final KeyBinding KEYBIND = KeyBindingHelper.registerKeyBinding(new KeyBinding("nbttooltips.keybind", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_LEFT_ALT, KeyBinding.Category.INVENTORY));
	public static final KeyBinding KEYBIND_VERBOSE = KeyBindingHelper.registerKeyBinding(new KeyBinding("nbttooltips.keybind.verbose", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN, KeyBinding.Category.INVENTORY));
	public static final KeyBinding KEYBIND_PARSE_BASE64 = KeyBindingHelper.registerKeyBinding(new KeyBinding("nbttooltips.keybind.parse_base64", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN, KeyBinding.Category.INVENTORY));

	@Override
	public void onInitialize() {
		ModConfigs.registerConfigs();
	}

	public static boolean isKeyPressed(KeyBinding binding) {
		int code = InputUtil.fromTranslationKey(binding.getBoundKeyTranslationKey()).getCode();
		if (code == -1) return false; // unbound
		return InputUtil.isKeyPressed(client.getWindow(), code);
	}

}