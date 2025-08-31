package liam0050.cwd;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ChatScreen;

public class OpenChatWhenDeadMod implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player != null && client.player.isDead()) {
                if (client.options.chatKey.isPressed() && client.currentScreen == null) {
                    client.setScreen(new ChatScreen(""));
                }
            }
        });
    }
}