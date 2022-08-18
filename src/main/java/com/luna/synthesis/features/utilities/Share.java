package com.luna.synthesis.features.utilities;

import com.google.gson.*;
import com.luna.synthesis.Synthesis;
import com.luna.synthesis.core.Config;
import com.luna.synthesis.events.MessageSentEvent;
import com.luna.synthesis.utils.ChatLib;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.event.ClickEvent;
import net.minecraft.event.HoverEvent;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.StringUtils;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.commons.io.IOUtils;
import org.lwjgl.input.Mouse;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


//event.setCanceled(true) abused because NO ONE should get muted over using this and going to appeals = going to limbo

public class Share {

    private final Pattern shareRegexPattern = Pattern.compile("\\{SynthesisShare:([a-f0-9]{8}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{12})}", Pattern.CASE_INSENSITIVE);
    private final Config config = Synthesis.getInstance().getConfig();

    @SubscribeEvent
    public void onMessageSent(MessageSentEvent event) {
        String message = event.message;
        if (message.endsWith(config.utilitiesShareText)) {
            event.setCanceled(true);
            doTheMagic(Minecraft.getMinecraft().thePlayer.getHeldItem(), message, config.utilitiesShareText);
        }
        /**
         * 
         * Suggestion #29 by AstroFuture#0932
         * suggested this before but it disappeared randomly, 
         * in addition to [item], have [helmet], [chestplate],
         * [leggings] and [boots] to make it easier to show armour
         * pieces without having to take them off and hold them
         * which is a pain especially when you have armour pieces
         * slot bound via neu
         * 
        */
        else if (message.endsWith(config.utilitiesShareHelmetText)) {
            event.setCanceled(true);
            doTheMagic(Minecraft.getMinecraft().thePlayer.getEquipmentInSlot(4), message, config.utilitiesShareHelmetText);
        } else if (message.endsWith(config.utilitiesShareChestplateText)) {
            event.setCanceled(true);
            doTheMagic(Minecraft.getMinecraft().thePlayer.getEquipmentInSlot(3), message, config.utilitiesShareChestplateText);
        } else if (message.endsWith(config.utilitiesShareLeggingsText)) {
            event.setCanceled(true);
            doTheMagic(Minecraft.getMinecraft().thePlayer.getEquipmentInSlot(2), message, config.utilitiesShareLeggingsText);
        } else if (message.endsWith(config.utilitiesShareBootsText)) {
            event.setCanceled(true);
            doTheMagic(Minecraft.getMinecraft().thePlayer.getEquipmentInSlot(1), message, config.utilitiesShareBootsText);
        }
    }

    @SubscribeEvent
    public void onChatReceived(ClientChatReceivedEvent event) {
        if (event.type == 0 || event.type == 1) {
            String msg = StringUtils.stripControlCodes(event.message.getUnformattedText());
            if (!msg.contains("{SynthesisShare:") || !msg.contains("}")) return;

            Matcher matcher = shareRegexPattern.matcher(msg);
            event.setCanceled(true);

            (new Thread(() -> {
                ArrayList<IChatComponent> shares = new ArrayList<>();
                while (matcher.find()) {
                    String shareId = matcher.group(1);

                    try {
                        URL url = new URL("https://synthesis-share.antonio32a.com/share/" + shareId);
                        HttpURLConnection http = (HttpURLConnection) url.openConnection();
                        http.setDoOutput(true);
                        http.setDoInput(true);
                        http.setRequestProperty("User-Agent", "SynthesisMod");
                        http.setRequestProperty("Accept", "application/json");
                        http.setRequestProperty("Method", "GET");
                        http.connect();
                        try (InputStream instream = http.getInputStream()) {
                            if (http.getResponseCode() != 200) {
                                Minecraft.getMinecraft().thePlayer.addChatMessage(event.message);
                                return;
                            }
                            JsonParser parser = new JsonParser();
                            JsonObject shareJson = parser.parse(new String(IOUtils.toByteArray(instream), StandardCharsets.UTF_8)).getAsJsonObject();
                            if (!shareJson.get("success").getAsBoolean()) {
                                Minecraft.getMinecraft().thePlayer.addChatMessage(event.message);
                                return;
                            }

                            JsonObject shareItem = shareJson.get("share").getAsJsonObject().get("item").getAsJsonObject();
                            String itemName = shareItem.get("name").getAsString();
                            JsonArray itemLore = shareItem.get("lore").getAsJsonArray();
                            boolean isItemVerified = shareJson.get("share").getAsJsonObject().get("verified").getAsBoolean();

                            IChatComponent verifiedComponent = new ChatComponentText((isItemVerified ? EnumChatFormatting.GREEN + "✔ " : EnumChatFormatting.RED + "✖ "));
                            verifiedComponent.getChatStyle().setChatHoverEvent(new HoverEvent(
                                    HoverEvent.Action.SHOW_TEXT,
                                    new ChatComponentText((isItemVerified ? EnumChatFormatting.GREEN + "This item is verified!\nIt exists in the API." : EnumChatFormatting.RED + "This item is not verified!\nAPI is off or the item may not exist."))
                            ));

                            AtomicReference<String> s = new AtomicReference<>("");
                            if (shareItem.has("extra")) {
                                if (shareItem.get("extra").getAsJsonObject().has("color")) {
                                    s.set(EnumChatFormatting.GRAY + "Color: #" + Integer.toHexString(shareItem.get("extra").getAsJsonObject().get("color").getAsInt()).toUpperCase() + "\n");
                                }
                            }
                            itemLore.iterator().forEachRemaining(jsonElement -> s.set(s.get() + jsonElement.getAsString() + "\n"));
                            String shareLore = itemName + "\n" + s.get();

                            IChatComponent shareComponent = new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE
                                    + "[Synthesis " + itemName + EnumChatFormatting.LIGHT_PURPLE + "]");
                            shareComponent.getChatStyle().setChatHoverEvent(new HoverEvent(
                                    HoverEvent.Action.SHOW_TEXT,
                                    new ChatComponentText(shareLore.substring(0, shareLore.length() - 1))
                            )).setChatClickEvent(new ClickEvent(
                                    ClickEvent.Action.RUN_COMMAND,
                                    "/ctcc https://synthesis-share.antonio32a.com/share/" + shareId + "?embed"
                            ));
                            verifiedComponent.appendSibling(shareComponent);
                            shares.add(verifiedComponent);
                        }
                    } catch (IOException | JsonParseException e) {
                        Minecraft.getMinecraft().thePlayer.addChatMessage(event.message);
                        e.printStackTrace();
                    }
                }

                IChatComponent toSend = new ChatComponentText("");
                ListIterator<String> it = Arrays.asList(event.message.getFormattedText().split(shareRegexPattern.pattern())).listIterator();
                while (it.hasNext()) {
                    String s = it.next();
                    toSend.appendSibling(new ChatComponentText(s));
                    if (it.hasNext()) {
                        toSend.appendSibling(shares.get(it.nextIndex() - 1));
                    }
                }

                Minecraft.getMinecraft().thePlayer.addChatMessage(toSend);
            })).start();

        }
    }

    @SubscribeEvent
    public void onScroll(GuiScreenEvent.MouseInputEvent.Pre event) {
        if (!config.utilitiesShareScroll) return;
        if (!GuiScreen.isCtrlKeyDown()) return;
        if (!(event.gui instanceof GuiChat)) return;
        int i = Mouse.getEventDWheel();
        if (i != 0) {
            IChatComponent comp = Minecraft.getMinecraft().ingameGUI.getChatGUI().getChatComponent(Mouse.getX(), Mouse.getY());
            if (comp != null && comp.getChatStyle().getChatHoverEvent() != null && comp.getChatStyle().getChatHoverEvent().getAction() == HoverEvent.Action.SHOW_TEXT) {
                event.setCanceled(true);
            }
        }
    }

    private void doTheMagic(ItemStack itemParam, String messageParam, String whateverWasMatchedParam) {
        if (itemParam == null || messageParam == null || whateverWasMatchedParam == null) {return;}
        NBTTagCompound extraAttributes = itemParam.getSubCompound("ExtraAttributes", false);
        JsonArray loreArray = new JsonArray();
        NBTTagList lore = itemParam.getSubCompound("display", false).getTagList("Lore", 8);
        for (int i = 0; i < lore.tagCount(); i++) {
            loreArray.add(new JsonPrimitive(lore.getStringTagAt(i)));
        }

        JsonObject itemJson = new JsonObject();
        itemJson.add("name", new JsonPrimitive(itemParam.getSubCompound("display", false).getString("Name")));
        itemJson.add("lore", loreArray);
        JsonObject extraObject = new JsonObject();
        if (itemParam.hasTagCompound()) {
            if (itemParam.getTagCompound().hasKey("display")) {
                if (itemParam.getTagCompound().getCompoundTag("display").hasKey("color")) {
                    extraObject.add("color", new JsonPrimitive(itemParam.getTagCompound().getCompoundTag("display").getInteger("color")));
                }
            }
        }
        if (extraAttributes != null && extraAttributes.hasKey("uuid")) {
            itemJson.add("uuid", new JsonPrimitive(extraAttributes.getString("uuid")));
        }

        itemJson.add("extra", extraObject);

        JsonObject body = new JsonObject();
        body.add("owner", new JsonPrimitive(Minecraft.getMinecraft().getSession().getPlayerID()));
        body.add("item", itemJson);

        (new Thread(() -> {
            try {
                URL url = new URL("https://synthesis-share.antonio32a.com/share");
                HttpURLConnection http = (HttpURLConnection) url.openConnection();
                http.setDoOutput(true);
                http.setDoInput(true);
                http.setRequestProperty("Content-Type", "application/json");
                http.setRequestProperty("User-Agent", "SynthesisMod");
                http.setRequestProperty("Accept", "application/json");
                http.setRequestProperty("Method", "POST");
                http.connect();
                try (OutputStream os = http.getOutputStream()) {
                    os.write(body.toString().getBytes(StandardCharsets.UTF_8));
                    os.close();
                    if (http.getResponseCode() != 200) {
                        ChatLib.chat("Something went wrong trying to upload share. Check logs maybe?");
                        return;
                    }
                    JsonParser parser = new JsonParser();
                    JsonObject shareJson = parser.parse(IOUtils.toString(http.getInputStream())).getAsJsonObject();
                    if (!shareJson.get("success").getAsBoolean()) {
                        ChatLib.chat("Share was not successful. Reason: " + shareJson.get("error").getAsString());
                        return;
                    }

                    String shareId = shareJson.get("share").getAsJsonObject().get("id").getAsString();
                    String share = "{SynthesisShare:" + shareId + "}";
                    //Can't write event.message because this is a thread
                    Minecraft.getMinecraft().thePlayer.sendChatMessage(messageParam.replace(whateverWasMatchedParam, share));
                    ChatLib.chat(messageParam.replace(whateverWasMatchedParam, share));
                }
            } catch (IOException e) {
                ChatLib.chat("Something went wrong trying to upload share. Check logs maybe?");
                e.printStackTrace();
            }
        })).start();
    }
}
