package com.luna.synthesis.core;

import com.luna.synthesis.Synthesis;
import gg.essential.vigilance.Vigilant;
import gg.essential.vigilance.data.JVMAnnotationPropertyCollector;
import gg.essential.vigilance.data.Property;
import gg.essential.vigilance.data.PropertyType;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.fml.common.Loader;

import java.awt.*;
import java.io.File;

public class Config extends Vigilant {

    // Me englando is no bueno.
    // If you find something that could be rewritten to be more concise and clear, let me know

    @Property(
            type = PropertyType.SELECTOR,
            name = "Collection tooltips",
            description = "Cleans some lines on the co-op collection display.",
            category = "Cleanup",
            subcategory = "Co-op",
            options = {
                    "Unchanged",
                    "Empty contributions",
                    "Other people's contributions",
                    "All contributions"
            }
    )
    public int cleanupCoopCollections = 0;

    @Property(
            type = PropertyType.SELECTOR,
            name = "Auction creation",
            description = "Removes co-op auction creation messages.",
            category = "Cleanup",
            subcategory = "Co-op",
            options = {
                    "None",
                    "Own auctions",
                    "Own auctions and show price",
                    "Other people's auctions",
                    "All auctions",
                    "All auctions and show price for own"
            }
    )
    public int cleanupCoopAuctionCreation = 0;

    @Property(
            type = PropertyType.SELECTOR,
            name = "Auction cancellations",
            description = "Removes co-op auction cancellation messages.",
            category = "Cleanup",
            subcategory = "Co-op",
            options = {
                    "None",
                    "Own auctions",
                    "Other people's auctions",
                    "All auctions"
            }
    )
    public int cleanupCoopAuctionCancellation = 0;

    @Property(
            type = PropertyType.SELECTOR,
            name = "Auction collections",
            description = "Removes co-op auction collection messages.",
            category = "Cleanup",
            subcategory = "Co-op",
            options = {
                    "None",
                    "Own auctions",
                    "Other people's auctions",
                    "All auctions"
            }
    )
    public int cleanupCoopAuctionCollection = 0;

    @Property(
            type = PropertyType.SELECTOR,
            name = "Beacon stat changes",
            description = "Removes co-op beacon stat changes messages.",
            category = "Cleanup",
            subcategory = "Co-op",
            options = {
                    "None",
                    "Own changes",
                    "Other people's changes",
                    "All changes"
            }
    )
    public int cleanupCoopBeaconStatChanges = 0;

    @Property(
            type = PropertyType.SWITCH,
            name = "Co-op travel messages",
            description = "Removes the chat message when your coop members travel to another island.",
            category = "Cleanup",
            subcategory = "Co-op"
    )
    public boolean cleanupCoopTravel = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Remove dungeon potion effects message",
            description = "Removes the chat message when you join a dungeon with active potion effects outside.",
            category = "Cleanup",
            subcategory = "Dungeon"
    )
    public boolean cleanupDungeonPotionEffects = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Remove dungeon class message",
            description = "Removes the chat message when you're the only player using a class.",
            category = "Cleanup",
            subcategory = "Dungeon"
    )
    public boolean cleanupDungeonSoloClassMessage = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Remove dungeon ultimate message",
            description = "Removes the dungeon reminder that your ultimate is ready to use.",
            category = "Cleanup",
            subcategory = "Dungeon"
    )
    public boolean cleanupDungeonUltimateMessage = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Remove dungeon blessing stats messages",
            description = "Removes the chat message that shows the stats of the collected blessing.",
            category = "Cleanup",
            subcategory = "Dungeon"
    )
    public boolean cleanupDungeonBlessingStatMessages = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Remove dungeon blessing messages",
            description = "Also removes the message that a blessing has been obtained, not only stats.",
            category = "Cleanup",
            subcategory = "Dungeon"
    )
    public boolean cleanupDungeonBlessingMessages = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Remove dungeon silverfish messages",
            description = "Removes the chat message when you hit the silverfish while it's moving.",
            category = "Cleanup",
            subcategory = "Dungeon"
    )
    public boolean cleanupDungeonSilverfishMessages = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Remove dungeon key usage messages",
            description = "Removes the chat message that explains how to use blood and wither keys.",
            category = "Cleanup",
            subcategory = "Dungeon"
    )
    public boolean cleanupDungeonKeyUsageMessages = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Remove dungeon watcher messages",
            description = "Removes all watcher messages except for the last one.",
            category = "Cleanup",
            subcategory = "Dungeon"
    )
    public boolean cleanupDungeonWatcherMessages = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Remove gear score",
            description = "Removes the gear score line.",
            category = "Cleanup",
            subcategory = "Lore"
    )
    public boolean cleanupLoreGearScore = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Remove HPB stat bonuses",
            description = "Removes the text of bonus stats from hot/fuming potato books.",
            category = "Cleanup",
            subcategory = "Lore"
    )
    public boolean cleanupLoreHPB = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Remove reforge stat bonuses",
            description = "Removes the text of bonus stats from reforge.",
            category = "Cleanup",
            subcategory = "Lore"
    )
    public boolean cleanupLoreReforge = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Remove gemstone stat bonuses",
            description = "Removes the text of bonus stats from gemstones.",
            category = "Cleanup",
            subcategory = "Lore"
    )
    public boolean cleanupLoreGemstones = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Remove dungeon stat bonuses",
            description = "Removes the text of the weapon's dungeon stats.",
            category = "Cleanup",
            subcategory = "Lore"
    )
    public boolean cleanupLoreDungeon = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Remove gemstone icons",
            description = "Removes the line that indicates applied gemstones.",
            category = "Cleanup",
            subcategory = "Lore"
    )
    public boolean cleanupLoreGemstoneSlots = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Remove enchantment descriptions",
            description = "Removes the explanation of what each enchantment does when the item has a low amount of enchantments.",
            category = "Cleanup",
            subcategory = "Lore"
    )
    public boolean cleanupLoreEnchantmentDescriptions = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Remove enchantments and reforge abilities",
            description = "Removes both the paragraph of enchantments and any mention of reforge abilities.",
            category = "Cleanup",
            subcategory = "Lore"
    )
    public boolean cleanupLoreEnchantments = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Remove reforge abilities",
            description = "Removes only the reforge ability text and leaves the paragraph of enchantments alone.",
            category = "Cleanup",
            subcategory = "Lore"
    )
    public boolean cleanupLoreReforgeAbility = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Remove item abilities",
            description = "Removes the item ability text.",
            category = "Cleanup",
            subcategory = "Lore"
    )
    public boolean cleanupLoreAbilities = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Remove armor piece bonuses",
            description = "Removes the armor piece bonus text.",
            category = "Cleanup",
            subcategory = "Lore"
    )
    public boolean cleanupLorePieceBonus = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Remove armor full set bonuses",
            description = "Removes the armor full set bonus text.",
            category = "Cleanup",
            subcategory = "Lore"
    )
    public boolean cleanupLoreFullSetBonus = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Remove co-op soulbound text",
            description = "Removes the \"§8* Co-op Soulbound *§r\" text.",
            category = "Cleanup",
            subcategory = "Lore"
    )
    public boolean cleanupLoreCoopSoulbound = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Remove solo soulbound text",
            description = "Removes the \"§8* Soulbound *§r\" text.",
            category = "Cleanup",
            subcategory = "Lore"
    )
    public boolean cleanupLoreSoloSoulbound = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Remove recombobulated obfuscated text",
            description = "Removes the obfuscated text (§ka§r) on the rarity of a recombobulated item.",
            category = "Cleanup",
            subcategory = "Lore"
    )
    public boolean cleanupLoreRecombobulatedObfuscated = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Remove \"§7Lvl§r\" from pet names in the pet menu",
            description = "Shows only the pet's level number in the pet menu.\n\n" +
                          "§c§lWARNING§r§c: This WILL conflict with Skytils' item rarity feature at this time\n§cdue to their pet name regex detection, and consequently almost any other mod features that depends on the pet's display name.\n" +
                          "§e§lCAUTION§r§e: This will also affect the output of the pet's display name\n§eif you use Developer Mode to copy item NBT data using the §7/sba nbt§e command from SkyblockAddons.",
            category = "Cleanup",
            subcategory = "Lore"
    )
    public boolean cleanupPetDisplayName = false;

    @Property(
            type = PropertyType.SELECTOR,
            name = "Remove pet type text in the pet menu",
            description = "Removes the pet's type (type and/or skill, your choice) from its lore in the pet menu.\n" +
                          "Example (show skill only): §8Mining Pet§r -> §8Mining\n" +
                          "Example (show type only): §8Combat Morph§r -> §8Morph\n",
            category = "Cleanup",
            subcategory = "Lore",
            options = {
                "Off",
                "Show skill only and remove pet type",
                "Show type only and remove pet's skill",
                "Remove both skill and type"
            }
    )
    public int cleanupLorePetType = 0;

    @Property(
            type = PropertyType.SWITCH,
            name = "Remove pet perk names in the pet menu",
            description = "Examples: §6Hive§r, §6Ridable§r, §6Run§r, §6Odyssey§r, §6Mining Exp Boost§r.",
            category = "Cleanup",
            subcategory = "Lore"
    )
    public boolean cleanupLorePetPerkName = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Remove pet \"§6Held Item: §r\" prefix in the pet menu",
            description = "Example: §6Held Item: §aGold Claws\nThis will §lNOT§r remove the ability text\n§rof the held pet item in question.",
            category = "Cleanup",
            subcategory = "Lore"
    )
    public boolean cleanupLorePetHeldItemPrefix = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Remove pet lore's empty lines in the pet menu",
            description = "This line intentionally left uninformative.",
            category = "Cleanup",
            subcategory = "Lore"
    )
    public boolean cleanupLorePetEmptyLines = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Remove pet lore's \"§b§lMAX LEVEL§r\" line in the pet menu",
            description = "This line intentionally left uninformative.",
            category = "Cleanup",
            subcategory = "Lore"
    )
    public boolean cleanupLorePetMaxLevel = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Remove pet lore's \"§eClick to summon!§r\" line in the pet menu",
            description = "This line intentionally left uninformative.",
            category = "Cleanup",
            subcategory = "Lore"
    )
    public boolean cleanupLorePetClickToSummon = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Remove pet lore's \"§cClick to despawn!§r\" line in the pet menu",
            description = "This line intentionally left uninformative.",
            category = "Cleanup",
            subcategory = "Lore"
    )
    public boolean cleanupLorePetClickToDespawn = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Compact pet lore's \"§a(X/10) Pet Candy Used§r\" line in the pet menu",
            description = "Example: §a(X/10) Pet Candy Used§r -> §aX Cand[y/ies]",
            category = "Cleanup",
            subcategory = "Lore"
    )
    public boolean cleanupLorePetCandiesUsed = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Auction house exception",
            description = "Stops the lore being cleaned up when the auction house menu is opened.",
            category = "Cleanup",
            subcategory = "Lore"
    )
    public boolean cleanupLoreAuctionException = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Remove old reforge messages",
            description = "Removes past reforge messages from chat when a new one is received.",
            category = "Cleanup",
            subcategory = "Chat"
    )
    public boolean cleanupChatOldReforgeMessages = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Remove tablist header",
            description = "Removes the message at the top of the tablist.",
            category = "Cleanup",
            subcategory = "Tablist"
    )
    public boolean cleanupTablistHeader = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Remove tablist footer",
            description = "Removes the last 2 lines at the bottom of the tablist.",
            category = "Cleanup",
            subcategory = "Tablist"
    )
    public boolean cleanupTablistFooter = false;

    //FUTURE

    @Property(
            type = PropertyType.SWITCH,
            name = "Keep sent messages",
            description = "Clearing the chat with F3 + D won't clear sent messages from the up and down arrows.",
            category = "Future features"
    )
    public boolean futureKeepSentMessages = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Chunk borders",
            description = "Pressing F3 + G toggles chunk borders.",
            category = "Future features"
    )
    public boolean futureChunkBorders = false;

    //UTILITIES

    @Property(
            type = PropertyType.SWITCH,
            name = "Container chat",
            description = "Opens the chat when having a container open.",
            category = "Utilities"
    )
    public boolean utilitiesContainerChat = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Container control",
            description = "Requires to have the control key held down to be able to open chat inside a container.\nIf not toggled, holding control key down will not open container chat.",
            category = "Utilities"
    )
    public boolean utilitiesContainerControl = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Resize chat",
            description = "Resizes chat when inside a container for it to fit on the screen.",
            category = "Utilities"
    )
    public boolean utilitiesResizeContainerChat = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Reopen chat",
            description = "When a container is closed while typing, reopen chat with what you were typing.",
            category = "Utilities"
    )
    public boolean utilitiesReopenContainerChat = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Transfer chat",
            description = "When a container is opened while typing from chat or another container, carry over what you were typing.",
            category = "Utilities"
    )
    public boolean utilitiesTransferContainerChat = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Chat search mode",
            description = "Pressing Ctrl + F when chat is open will toggle search mode.",
            category = "Utilities"
    )
    public boolean utilitiesChatSearchMode = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Chat search instant refresh",
            description = "Chat will look for chat messages every key typed instead of only after pressing enter.",
            category = "Utilities"
    )
    public boolean utilitiesChatSearchKeyRefresh = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Search scroll",
            description = "Scrolls to a message when right clicked on while on search mode.",
            category = "Utilities"
    )
    public boolean utilitiesChatScrollClick = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Backpack retexturing",
            description = "Allows you to retexture storage backpacks.",
            category = "Utilities"
    )
    public boolean utilitiesBackpackRetexturing = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "HOTM Perk Level Display",
            description = "Shows perk level as stack size.",
            category = "Utilities"
    )
    public boolean utilitiesPerkLevelDisplay = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "HOTM Max Perk Display",
            description = "Shows perk level as stack size also on maxed perks.",
            category = "Utilities"
    )
    public boolean utilitiesMaxPerkLevelDisplay = false;

    @Property(
            type = PropertyType.SELECTOR,
            name = "Drop chance to drop rate",
            description = "Displays drop chances as drop rates in bestiary.",
            category = "Utilities",
            options = {
                    "None",
                    "Hold shift",
                    "Permanent"
            }
    )
    public int utilitiesDropChanceToDropRate = 0;

    @Property(
            type = PropertyType.SWITCH,
            name = "Bestiary glance",
            description = "Displays bestiary level and progress in the bestiary menu.",
            category = "Utilities"
    )
    public boolean utilitiesBestiaryGlance = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Server occupancy glance",
            description = "Draws a background around any item representing the occupancy of a lobby or player island.\nDepending on the occupancy level of a server or island, the highlight's color can range from something near §athis highight§r (empty lobby/island) to something near §cthis highight§r (full lobby/island), with the occasional highlight of somewhere near §ethis color in particular§r (half-empty/half-full lobby/island).",
            category = "Utilities",
            subcategory = "Server occupancy overlay"
    )
    public boolean utilitiesOccupancyOverlay = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "§9Friend§r highlight",
            description = "Uses §9this unique color§r for lobbies with at least one Hypixel friend.\n§e§lNOTE: §r§eThis highlight does not apply when a lobby\n§eis at or over its maximum capacity.",
            category = "Utilities",
            subcategory = "Server occupancy overlay"
    )
    public boolean utilitiesOccupancyOverlayFriendHighlght = false;
    
    @Property(
            type = PropertyType.SWITCH,
            name = "§2Guildmate§r highlight",
            description = "Uses §2this unique color§r for lobbies with at least one Hypixel guildmate.\n§e§lNOTE: §r§eThis highlight does not apply when a lobby\n§eis at or over its maximum capacity.",
            category = "Utilities",
            subcategory = "Server occupancy overlay"
    )
    public boolean utilitiesOccupancyOverlayGuildHighlght = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "§dFriend(s) §land§r§d guildmate(s)§r highlight",
            description = "Uses §dthis unique color§r for lobbies with both at least one Hypixel friend and one Hypixel guildmate.\nIf this is disabled, then either §9the friend highlight§r or §2the guildmate highlight§r takes priority, depending on your settings.\n§e§lNOTE: §r§eThis highlight does not apply when a lobby\n§eis at or over its maximum capacity.",
            category = "Utilities",
            subcategory = "Server occupancy overlay"
    )
    public boolean utilitiesOccupancyOverlayFriendAndGuildHighlght = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "§bCurrently connected§r highlight",
            description = "Uses §bthis unique color§r for lobbies you're already connected to.\nIf this is disabled, then at least one of the above settings (§9friend§r, §2guildmate§r, or §dboth§r) takes priority.\n§e§lNOTE: §r§eBecause of how Hypixel's hub selector tooltips work,\n§ethis highlight still applies even if a lobby is at or over its maximum capacity.",
            category = "Utilities",
            subcategory = "Server occupancy overlay"
    )
    public boolean utilitiesOccupancyOverlayAlreadyConnectedHighlght = true;

    @Property(
            type = PropertyType.SWITCH,
            name = "Armadillo fix",
            description = "Stops armadillo blocking the screen when trying to mine blocks.",
            category = "Utilities"
    )
    public boolean utilitiesArmadilloFix = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "WishingCompass helper",
            description = "Triangulates the location wishing compass points to. Use the item once, wait until the particle trail has disappeared, move away a bit and use it again. Make sure /pq is NOT \"off\".",
            category = "Utilities"
    )
    public boolean utilitiesWishingCompass = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Block triangulation item",
            description = "Blocks using wishing compass if the last trail hasn't disappeared.",
            category = "Utilities"
    )
    public boolean utilitiesBlockWishingCompass = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Wishing Compass waypoints",
            description = "Sets a waypoint at the location calculated by triangulation. Uses Skytils' waypoints.",
            category = "Utilities"
    )
    public boolean utilitiesWishingCompassWaypoint = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "AncestralSpade helper",
            description = "Triangulates the location ancestral spade points to. §cLook straight up or down§r, use the item once, wait until the particle trail has disappeared, move away a bit and use it again. Make sure /pq is NOT \"off\".",
            category = "Utilities"
    )
    public boolean utilitiesAncestralSpade = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Burrow waypoints",
            description = "Sets a waypoint at the location calculated by ancestral spade triangulation.",
            category = "Utilities"
    )
    public boolean utilitiesAncestralSpadeWaypoint = false;

    @Property(
            type = PropertyType.COLOR,
            name = "Burrow waypoint color",
            description = "The color of the waypoint beacon.",
            category = "Utilities",
            allowAlpha = false
    )
    public Color utilitiesAncestralSpadeWaypointColor = Color.RED;

    @Property(
            type = PropertyType.SWITCH,
            name = "Parse burrow arrow",
            description = "Saves the direction arrow from a burrow, making it only require an extra use of Ancestral Spade.",
            category = "Utilities"
    )
    public boolean utilitiesAncestralSpadeArrow = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Display wishing compass uses left",
            description = "Displays the uses left on wishing compasses.",
            category = "Utilities"
    )
    public boolean utilitiesWishingCompassUsesLeft = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Always display wishing compass uses left",
            description = "Also displays uses left on wishing compasses when they have 3 uses left.",
            category = "Utilities"
    )
    public boolean utilitiesWishingCompassAlwaysUsesLeft = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Visible links",
            description = "Makes clickable links blue and underlined.",
            category = "Utilities"
    )
    public boolean utilitiesVisibleLinks = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Colorless panes",
            description = "Removes the color from glass panes so glass blocks are more visible.",
            category = "Utilities"
    )
    public boolean utilitiesColorlessPanes = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Chat in portal",
            description = "Lets you open and use chat inside a nether portal.",
            category = "Utilities"
    )
    public boolean utilitiesPortalChat = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Better wither impact perspective",
            description = "Toggling third person view will skip the front camera if holding a wither impact weapon.",
            category = "Utilities"
    )
    public boolean utilitiesWitherImpactPerspective = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Better perspective",
            description = "Makes Better wither impact perspective skip the wither impact test and will always skip the front camera.",
            category = "Utilities"
    )
    public boolean utilitiesWitherImpactPerspectiveGlobal = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Superpairs IDs",
            description = "Gives superpairs item rewards Skyblock IDs so mods like NEU and SBE can display price and resource packs can display custom textures.",
            category = "Utilities"
    )
    public boolean utilitiesSuperpairsIDs = false;

    @Property(
        type = PropertyType.SWITCH,
        name = "Trophy Fishing Overlay",
        description = "Colors a trophy fish in Odger's menu with the highest tier of it that you've caught.",
        category = "Utilities"
)
    public boolean utilitiesTrophyFishingOverlay = false;

    @Property(
        type = PropertyType.SWITCH,
        name = "Hexatorum Overlay",
        description = "Displays the progress of your item's individual traits in color form according to the Hex.",
        category = "Utilities"
)
    public boolean utilitiesHexatorumOverlay = false;

    @Property(
        type = PropertyType.SWITCH,
        name = "Hexatorum Debug",
        description = "Displays debug information in case the Hexatorum overlay decides to break.\nCan and WILL flood your chat-enable with great caution!",
        category = "Utilities"
)
    public boolean utilitiesHexatorumDebug = false;

    @Property(
            type = PropertyType.TEXT,
            name = "Share held item text",
            description = "Hold an item and type the text to show the item to other Synthesis users.",
            category = "Utilities",
            subcategory = "Share"
    )
    public String utilitiesShareText = "[item]";

    @Property(
            type = PropertyType.TEXT,
            name = "Share helmet text",
            description = "Type the text to show your helmet slot to other Synthesis users.",
            category = "Utilities",
            subcategory = "Share"
    )
    public String utilitiesShareHelmetText = "[helmet]";

    @Property(
            type = PropertyType.TEXT,
            name = "Share chestplate text",
            description = "Type the text to show your chestplate slot to other Synthesis users.",
            category = "Utilities",
            subcategory = "Share"
    )
    public String utilitiesShareChestplateText = "[chestplate]";

    @Property(
            type = PropertyType.TEXT,
            name = "Share leggings text",
            description = "Type the text to show your leggings slot to other Synthesis users.",
            category = "Utilities",
            subcategory = "Share"
    )
    public String utilitiesShareLeggingsText = "[leggings]";

    @Property(
            type = PropertyType.TEXT,
            name = "Share boots text",
            description = "Type the text to show your boots slot to other Synthesis users.",
            category = "Utilities",
            subcategory = "Share"
    )
    public String utilitiesShareBootsText = "[boots]";

    @Property(
            type = PropertyType.SWITCH,
            name = "Share scroll",
            description = "Scrolling while hovering a share and holding control will not scroll the chat.",
            category = "Utilities",
            subcategory = "Share"
    )
    public boolean utilitiesShareScroll = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Share copy embed",
            description = "Clicking on shares copies a link to clipboard, that embeds an item preview on discord.",
            category = "Utilities",
            subcategory = "Share"
    )
    public boolean utilitiesShareCopyEmbed = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Better bridge message",
            description = "Reformats guild bridge messages.",
            category = "Utilities",
            subcategory = "Bridge"
    )
    public boolean utilitiesBridge = false;

    @Property(
            type = PropertyType.TEXT,
            name = "Bridge bot name",
            description = "The IGN of the minecraft account acting as a bridge. Case sensitive.",
            category = "Utilities",
            subcategory = "Bridge",
            min = 1,
            max = 16
    )
    public String utilitiesBridgeBotName = "mmmmBeepBeepBeep";

    @Property(
            type = PropertyType.TEXT,
            name = "Bridge message format",
            description = "The message that will be sent when a message is sent from discord. Use <ign> and <msg> for message sender and message. Use & for color codes.",
            category = "Utilities",
            subcategory = "Bridge"
    )
    public String utilitiesBridgeMessageFormat = "&9[Discord] &6<ign>&r: <msg>";

    @Property(
            type = PropertyType.BUTTON,
            name = "Test bridge message",
            description = "Send in chat a message formatted like the above format. Useful for testing that format.",
            category = "Utilities",
            subcategory = "Bridge",
            placeholder = "Test"
    )
    public void utilitiesBridgeTestFormat() {
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(utilitiesBridgeMessageFormat.replaceAll("&", "§").replace("<ign>", "Luna").replace("<msg>", "This is an example message. Thank you for using Synthesis!")));
    }

    @Property(
            type = PropertyType.BUTTON,
            name = "Color code guide",
            description = "Sends a chat message with all formatting codes.",
            category = "Utilities",
            subcategory = "Bridge",
            placeholder = "Show"
    )
    public void utilitiesBridgeColorCodeGuide() {
        for (EnumChatFormatting value : EnumChatFormatting.values()) {
            if (value.getFriendlyName().equals("obfuscated")) {
                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText( "&" + value.toString().replace("§", "") + " - " + value + value.getFriendlyName()));
            } else {
                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(value + "&" + value.toString().replace("§", "") + " - " + value.getFriendlyName()));
            }
        }
    }

    @Property(
            type = PropertyType.SWITCH,
            name = "Bridge guild chat tab",
            description = "If using skytils' chattabs, moves formatted bridge messages to the guild tab.",
            category = "Utilities",
            subcategory = "Bridge"
    )
    public boolean utilitiesBridgeGuildChatTab = true;

    @Property(
            type = PropertyType.TEXT,
            name = "Custom cape",
            description = "Use someone else's optifine cape. Only you will see this! Leave empty to not use someone else's cape.",
            category = "Utilities",
            subcategory = "Optifine",
            min = 1,
            max = 16
    )
    public String utilitiesOptifineCustomCape = "";

    @Property(
            type = PropertyType.SWITCH,
            name = "Trans yeti",
            description = "Gives the yeti a trans cape.",
            category = "Utilities",
            subcategory = "Optifine"
    )
    public boolean utilitiesOptifineTransYeti = true;

    @Property(
            type = PropertyType.SWITCH,
            name = "Trans terracotta",
            description = "Gives the terracotta a trans cape.",
            category = "Utilities",
            subcategory = "Optifine"
    )
    public boolean utilitiesOptifineTransTerracotta = true;

    @Property(
            type = PropertyType.SWITCH,
            name = "Non binary bonzo",
            description = "Gives bonzo a non binary cape.",
            category = "Utilities",
            subcategory = "Optifine"
    )
    public boolean utilitiesOptifineNonBinaryBonzo = true;

    @Property(
            type = PropertyType.SWITCH,
            name = "Candy cane grinch",
            description = "Gives the grinch a candy cane cape.",
            category = "Utilities",
            subcategory = "Optifine"
    )
    public boolean utilitiesOptifineCandyCaneGrinch = true;

    @Property(
            type = PropertyType.SWITCH,
            name = "Hide santa/witch hat",
            description = "Hides the witch/santa hat given to players with capes on halloween/christmas.",
            category = "Utilities",
            subcategory = "Optifine"
    )
    public boolean utilitiesOptifineHideHats = false;

    @Property(
            type = PropertyType.NUMBER,
            name = "Bestiary Level",
            description = "If you're somehow reading this in-game, something isn't right.",
            category = "Advanced",
            max = 10000,
            hidden = true
    )
    public int personalBestiaryLevel = 0;

    @Property(
            type = PropertyType.SELECTOR,
            name = "Bestiary Milestone Warning",
            description = "Specify how (if at all) you want your Bestiary Milestone warning to be delivered.\n§cIn order for this to work, you need to view the \"Bestiary Milestone\" item tooltip via §r/be §cfirst.",
            category = "Utilities",
            subcategory = "Bestiary",
            options = {"Off", "Chat", "Notification"}
    )
    public int utilitiesBestiaryMilestoneWarningDeliveryMethod = 0;

    @Property(
            type = PropertyType.NUMBER,
            name = "Bestiary Milestone Frequency (in seconds)",
            description = "Specify how frequently (in units of \"every X seconds\") Synthesis will (notify you via chat/send notifications) if you're close to reaching a Bestiary Milestone that rewards combat experience.",
            category = "Utilities",
            subcategory = "Bestiary",
            min = 5, max = 60
    )
    public int utilitiesBestiaryMilestoneWarningSeconds = 5;

    @Property(
            type = PropertyType.NUMBER,
            name = "Bestiary Milestone Notification Duration (in seconds)",
            description = "Specify how long (in units of \"X seconds\") Synthesis' Bestiary Milestone notification will last.\n§cFor an optimal experience, it is recommended to keep this value lower than what you have for \"Bestiary Milestone Frequency (in seconds)\".",
            category = "Utilities",
            subcategory = "Bestiary",
            min = 5, max = 120
    )
    public int utilitiesBestiaryMilestoneWarningDuration = 5;

    @Property(
            type = PropertyType.SELECTOR,
            name = "Show Item UUID at Item Lore",
            description = "Displays the item's UUID (if there is one) at the end of an item's tooltip.\n§cFor compatibility reasons, UUIDs for all pets will not be displayed while viewing the pet menu.",
            category = "Utilities",
            subcategory = "Item Lore",
            options = {"Off", "With \"-\"s", "Without \"-\"s"}
    )
    public int utilitiesLoreItemUUID = 0;

    @Property(
            type = PropertyType.SWITCH,
            name = "Show Item Origin at Item Lore",
            description = "Displays the item's origin (if there is one) at the end of an item's tooltip.\n§cFor compatibility reasons, item origins for all pets will not be displayed while viewing the pet menu.",
            category = "Utilities",
            subcategory = "Item Lore"
    )
    public boolean utilitiesLoreOriginTag = false;

    @Property(
            type = PropertyType.SELECTOR,
            name = "Master Star Display Options",
            description = "Choose how you want master stars in item names to be displayed.\n§eWill affect output provided by SkyblockAddons' §r/sba dev §ecommand.\n§cMay not apply to items renamed via NEU.",
            category = "Utilities",
            options = {"Whatever Hypixel has right now (§6✪§6✪§6✪§6✪§6✪§c➍§r)", "Go old school (§c✪§c✪§c✪§c✪§6✪§r)", "Append to previous stars (§6✪§6✪§6✪§6✪§6✪§c✪§c✪§c✪§c✪§r)"}
    )
    public int utilitiesMasterStarDisplay = 0;

    @Property(
        type = PropertyType.SWITCH,
        name = "Master Mode Soul Detection per Item",
        description = "Check if an item is filled §aexclusively§r or §epartially§r of Master Mode souls.\nAdditionally indicates which souls are from Master Mode on item tooltips.",
        category = "Utilities"
)
    public boolean utilitiesMasterModeSoulDetection = true;

    @Property(
            type = PropertyType.SWITCH,
            name = "Enable Senither and Lily weight search",
            description = "The toggle to enable/disable checking exclusively for someone's weights in both the Senither calculation system and the Lily calculation system. §e(Type \"[weight <username>]\" in chat to check someone's weight calculations, or \"[weight]\" to check your own.)\n§c§lEnable with caution!",
            category = "Utilities"
    )
    public boolean utilitiesCheckWeight = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Enable checking for Player's SkyCrypt Stats",
            description = "The toggle to enable/disable checking for someone's stats in the SkyCrypt API. §e(Type \"[stats <username>]\" in chat to check someone's SkyCrypt stats, or \"[stats]\" to check your own. Additionally, this also activates when sending trade requests to someone.)\n§c§lEnable with caution!",
            category = "Utilities"
    )
    public boolean utilitiesCheckStats = false;

    @Property(
            type = PropertyType.SELECTOR,
            name = "SkyCrypt Stats Level of Detail (§dLOD§r)",
            description = "Choose how much detail you should see when checking someone's SkyCrypt info.\n§eApplies to all players without exception regardless of your choice; choose wisely!\n§cDoes not influence load time of SkyCrypt player data.\nGo experiment!",
            category = "Utilities",
            options = {"\"give me the bare minimum\"", "\"Maybe a bit of extra info would be nice.\"", "\"I DEMAND TO KNOW EVERY SINGLE DETAIL!\""}
    )
    public int utilitiesCheckStatsLvlOfDetail = 0;

    @Property(
        type = PropertyType.SWITCH,
        name = "Prevent HOTM Reset",
        description = "Prevent clicking on that one button which resets your HOTM tree.",
        category = "Utilities"
    )
    public boolean utilitiesPreventHOTMReset = false;

    @Property(
        type = PropertyType.SWITCH,
        name = "Prevent Profile Deletion",
        description = "Prevent clicking on that one button which deletes your profiles.",
        category = "Utilities"
    )
    public boolean utilitiesPreventProfileDeletion = false;

    @Property(
        type = PropertyType.SWITCH,
        name = "Prevent Portal Destruction",
        description = "Prevent destroying portals on your private island.",
        category = "Utilities"
)
    public boolean utilitiesPreventPortalDestruction = false;

    @Property(
        type = PropertyType.SWITCH,
        name = "Prevent Voting for Barry",
        description = "Prevent voting for Barry in Skyblock mayor elections. (Sorry not sorry, arithemonkey.)",
        category = "Utilities"
    )
    public boolean utilitiesPreventVotingBarry = false;

    @Property(
        type = PropertyType.SWITCH,
        name = "Prevent Voting for Diaz",
        description = "Prevent voting for Diaz in Skyblock mayor elections.",
        category = "Utilities"
    )
    public boolean utilitiesPreventVotingDiaz = false;

    @Property(
        type = PropertyType.SWITCH,
        name = "Prevent Voting for Dante",
        description = "Prevent voting for Dante in Skyblock mayor elections.",
        category = "Utilities"
    )
    public boolean utilitiesPreventVotingDante = false;

    @Property(
        type = PropertyType.SWITCH,
        name = "Prevent Voting for Unknown Special Mayors",
        description = "Prevent voting for new special mayors besides Derpy, Jerry, or Scorpius in Skyblock mayor elections. Enabling this will prevent voting for Dante as well.",
        category = "Utilities"
    )
    public boolean utilitiesPreventVotingSusSpecialMayors = false;

    @Property(
        type = PropertyType.NUMBER,
        name = "Prevent Voting for Mayors with Less Than [number] Perks",
        description = "If left at the default value of \"1\", Synthesis will not prevent you from voting for any mayors.\nHowever, if you chose \"2\", Synthesis would prevent you from voting for mayors with only one perk (as one is less than two).", //\"
        category = "Utilities",
        min = 1, max = 3
    )
    public int utilitiesPreventVotingXPerkMayors = 1;

    @Property(
        type = PropertyType.SWITCH,
        name = "Show Collections as Stack Size",
        description = "Applies to the collection menus of most Skyblock skills.",
        category = "Utilities"
    )
    public boolean utilitiesShowCollectionStackSize = false;

    @Property(
        type = PropertyType.SWITCH,
        name = "Show Highest Crafted Minions as Stack Size",
        description = "Applies to the Crafted Minions menu.",
        category = "Utilities"
    )
    public boolean utilitiesShowCraftedMinionsStackSize = false;

    @Property(
        type = PropertyType.SWITCH,
        name = "Show Skills as Stack Size",
        description = "Applies to both the \"Dungeoneering\" and \"Your Skills\" menus\n§e§lCAUTION§r§e: If you enabled Skytils' \"Show Potion Tier\" option, there will be a \"1\" as the stack size for the Healer icon in the \"Dungeoneering\" menu. There is no known solution to this besides building your own copies of Skytils.",
        category = "Utilities"
    )
    public boolean utilitiesShowSkillStackSize = false;

    @Property(
        type = PropertyType.SWITCH,
        name = "Show Dojo Progress as Stack Size",
        description = "Shows your Rank on all attempted §9Tests§r at the Dojo as well as your overall §6Rank§r.",
        category = "Utilities"
    )
    public boolean utilitiesShowDojoProgressStackSize = false;

    @Property(
        type = PropertyType.SWITCH,
        name = "Show §aCompleted Quest§r count as Stack Size",
        description = "This line intentionally left uninformative.",
        category = "Utilities"
    )
    public boolean utilitiesShowCompletedQuestCountStackSize = false;

    @Property(
        type = PropertyType.SWITCH,
        name = "Show Wardrobe Slot # as Stack Size",
        description = "This line intentionally left uninformative.",
        category = "Utilities"
    )
    public boolean utilitiesShowWardrobeSlotStackSize = false;

    @Property(
        type = PropertyType.SWITCH,
        name = "Show Bank Tier as Stack Size",
        description = "This line intentionally left uninformative.",
        category = "Utilities"
    )
    public boolean utilitiesShowBankTierStackSize = false;

    @Property(
        type = PropertyType.SELECTOR,
        name = "Show Skill Average as Stack Size",
        description = "Rounded: Rounds this value to the nearest integer.\nExact: Embraces the decimal point of this value.",
        category = "Utilities",
        options = {"Off", "Rounded", "Exact"}
    )
    public int utilitiesShowSkillAverageStackSize = 0;

    @Property(
        type = PropertyType.SELECTOR,
        name = "Show Overall Unlocked Recipes Percent as Stack Size",
        description = "Rounded: Rounds this value to the nearest integer.\nExact: Embraces the decimal point of this value.\nFor compatibility reasons, this is limited to the \"SkyBlock Menu\".",
        category = "Utilities",
        options = {"Off", "Rounded", "Exact"}
    )
    public int utilitiesShowUnlockedRecipePercentStackSize = 0;
    
    @Property(
        type = PropertyType.SELECTOR,
        name = "Show Categorized Unlocked Recipes Percent as Stack Size",
        description = "Rounded: Rounds this value to the nearest integer.\nExact: Embraces the decimal point of this value.",
        category = "Utilities",
        options = {"Off", "Rounded", "Exact"}
    )
    public int utilitiesShowUnlockedSpecificRecipePercentStackSize = 0;

    @Property(
        type = PropertyType.SELECTOR,
        name = "Show Overall Unlocked Collections Percent as Stack Size",
        description = "Rounded: Rounds this value to the nearest integer.\nExact: Embraces the decimal point of this value.",
        category = "Utilities",
        options = {"Off", "Rounded", "Exact"}
    )
    public int utilitiesShowUnlockedCollectionStackSize = 0;

    @Property(
        type = PropertyType.SELECTOR,
        name = "Show Museum Donated Percent as Stack Size",
        description = "Rounded: Rounds this value to the nearest integer.\nExact: Embraces the decimal point of this value.",
        category = "Utilities",
        options = {"Off", "Rounded", "Exact"}
    )
    public int utilitiesShowMuseumPercentagesStackSize = 0;

    @Property(
        type = PropertyType.SWITCH,
        name = "Show New Year's Cake Year as Stack Size",
        description = "This line intentionally left uninformative.",
        category = "Utilities"
    )
    public boolean utilitiesShowNYCakeStackSize = false;

    @Property(
        type = PropertyType.SWITCH,
        name = "Show Active Effects count as Stack Size",
        description = "This line intentionally left uninformative.",
        category = "Utilities"
    )
    public boolean utilitiesShowActiveEffectsStackSize = false;

    @Property(
        type = PropertyType.SELECTOR,
        name = "Show Spooky Pie Stack Size",
        description = "SB Year: Shows the SB year the Pie was obtained.\nnth Festival: Shows the nth Spooky Festival the Pie was obtained.\n(For compatibility reasons, this will only apply to the general SkyBlock Menu.)",
        category = "Utilities",
        options = {"Off", "SB Year", "nth Festival"}
    )
    public int utilitiesShowSpookyPieStackSize = 0;

    //MISC

    @Property(
            type = PropertyType.SWITCH,
            name = "Ignore Hypixel's Books GUIs",
            description = "Automatically close any book GUI in all Hypixel lobbies. Originally designed to automate ignoring all those books about Hypixel's seasonal sales on their online store, but §efalse positives CAN and WILL happen.\n§c§lEnable with caution, and disable when in doubt!",
            category = "Miscellaneous"
    )
    public boolean miscIgnoreHypixelBooks = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Send Notifications When Book GUIs are ignored",
            description = "Sends a notification if Synthesis ignores a book GUI. Only turn this off if you know what you're doing.",
            category = "Miscellaneous"
    )
    public boolean miscIgnoreHypixelBooksWarning = true;

    @Property(
            type = PropertyType.SWITCH,
            name = "More burger",
            description = "WHY WOULD YOU ENABLE THIS WHY.",
            category = "Miscellaneous"
    )
    public boolean miscMoreBurgers = false;

    //PATCHER

    @Property(
            type = PropertyType.SWITCH,
            name = "Compact chat fix",
            description = "Fixes chat messages not being removed with compact chat when the chat is refreshed.",
            category = "Patcher"
    )
    public boolean patcherCompactChatFix = true;

    @Property(
            type = PropertyType.SWITCH,
            name = "Custom image preview domains",
            description = "Lets you set and use custom domains for Patcher's ImagePreview. Do not add sites you do not trust. Use at own risk.",
            category = "Patcher"
    )
    public boolean patcherCustomImagePreviewer = false;

    @Property(
            type = PropertyType.TEXT,
            name = "Custom domains",
            description = "Look, I'm way too lazy to store this in a json as an array or whatever. It's literally just text why would I care.",
            category = "Patcher",
            hidden = true
    )
    public String patcherCustomDomains = "";

    public Config() {
        super(new File(Synthesis.configLocation), "§dSynthesis§r - §bNON-CANON EDITION BY ERYMANTHUS", new JVMAnnotationPropertyCollector(), new CustomSortingBehavior());
        initialize();
        setSubcategoryDescription("Utilities", "Server occupancy overlay", "Ever wondered how full a lobby is?\nEver wanted a visual indicator of that metric?\nHere you go!");
        setSubcategoryDescription("Utilities", "Share", "A simple way to show your items to other people using the mod. Hold the item, type whatever \"Share text\" is and a preview for your item will be sent.");
        hidePropertyIf("patcherCompactChatFix", () -> !Loader.isModLoaded("patcher"));
        hidePropertyIf("patcherCustomImagePreviewer", () -> !Loader.isModLoaded("patcher"));
        hidePropertyIf("utilitiesShareScroll", () -> !Loader.isModLoaded("text_overflow_scroll"));
        hidePropertyIf("utilitiesWishingCompassWaypoint", () -> !Loader.isModLoaded("skytils"));
        hidePropertyIf("miscMoreBurgers", () -> (!(Minecraft.getMinecraft().getSession().getPlayerID().equalsIgnoreCase("1f20d60f1bc242dd82669a173a7af77c")) && !(Minecraft.getMinecraft().getSession().getPlayerID().equalsIgnoreCase("b43d74579da4408ba9fb51239022cec9"))));
        addDependency("utilitiesWishingCompassWaypoint", "utilitiesWishingCompass");
        addDependency("utilitiesBlockWishingCompass", "utilitiesWishingCompass");
        addDependency("utilitiesContainerControl", "utilitiesContainerChat");
        addDependency("cleanupDungeonBlessingMessages", "cleanupDungeonBlessingStatMessages");
        addDependency("utilitiesWitherImpactPerspectiveGlobal", "utilitiesWitherImpactPerspective");
        addDependency("utilitiesOccupancyOverlayFriendHighlght", "utilitiesOccupancyOverlay");
        addDependency("utilitiesOccupancyOverlayGuildHighlght", "utilitiesOccupancyOverlay");
        addDependency("utilitiesOccupancyOverlayFriendAndGuildHighlght", "utilitiesOccupancyOverlay");
        addDependency("utilitiesOccupancyOverlayAlreadyConnectedHighlght", "utilitiesOccupancyOverlay");
        addDependency("miscIgnoreHypixelBooksWarning", "miscIgnoreHypixelBooks");
        addDependency("utilitiesHexatorumDebug", "utilitiesHexatorumOverlay");
        registerListener("utilitiesColorlessPanes", (z) -> Minecraft.getMinecraft().renderGlobal.loadRenderers());
    }
}
