package com.luna.synthesis.features.miscellaneous;

import com.luna.synthesis.Synthesis;
import com.luna.synthesis.core.Config;
import com.luna.synthesis.utils.ChatLib;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreenBook;

import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class IgnoreHypixelBooks {

    private final Config config = Synthesis.getInstance().getConfig();
    
    @SubscribeEvent
    private void onBook(GuiScreenEvent.KeyboardInputEvent e) {
        if (!config.miscIgnoreHypixelBooks) {return;}
        if ((Minecraft.getMinecraft().currentScreen instanceof GuiScreenBook)) {
            //e.setCanceled(true);
            //Minecraft.getMinecraft().thePlayer.closeScreen();
            ChatLib.chat("Ascynx won't be able to see this message in-game because BRUH");
        }
    }
}
