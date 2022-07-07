# Synthesis-NONCANON
Hypixel SkyBlock QoL Mod. A collection of random mod features that SirDesco couldn't find anywhere else.

> TLDR: Desco decided to rewrite the mod in Kotlin and Ery that wanted to add features decided to add new ones that he's sad he couldn't get in the base mod

***NOTE: These are noncanon builds of SirDesco's Synthesis mod. As in, because SirDesco wants to port v0.3.1 of Synthesis to Kotlin for v0.4.0 and I (Erymanthus | RayDeeUx) suck at Kotlin, this is an alternative take on Synthesis which includes some of the suggestions I liked that never made it into Synthesis. Use of any releases of these noncanon Synthesis builds—regardless of where, how, and when you obtained it—implies your understanding that some of the features in these non-canon builds of Synthesis will not make it into the Kotlin rewrite.***

To prevent mayhem and in accordance with [GitHub's licensing guidelines](https://docs.github.com/en/repositories/managing-your-repositorys-settings-and-features/customizing-your-repository/licensing-a-repository), this fork inherits the license as its parent previously assumed, which is ARR (all rights reserved):

> You're under no obligation to choose a license. However, without a license, the default copyright laws apply, meaning that you retain all rights to your source code and no one may reproduce, distribute, or create derivative works from your work.

However, as part of ARR, this fork does not violate any copyright laws as I have recieved explicit permission from SirDesco & friends (see below):

![image](https://media.discordapp.net/attachments/728977460737081454/989883710381895700/FOR_GITHUB.png)

# SirDesco is currently on sabbatical in preparation for the Kotlin rewrite of Synthesis. All the information below this heading is solely for reference purposes only, and may not reflect all of the contents of this specific repository.

Releases and announcements at the official [discord](https://discord.gg/vAUuKSwbp6).
Feedback such as suggestions, new features, bugs, etc. will also be collected there.

***

## Features
<details>
    <summary>Cleanup</summary>

### Cleanup
Features that help the game feel more clean.
- Coop cleanup, fully customizable
  - Auction creation messages
  - Auction cancellation messages
  - Auction collection messages
  - Collection tooltips
  - Beacon stat change messages
  - Co-op member traveled to island messages
- Dungeon cleanup, fully customizable
  - Potion effects message
  - Solo dungeon class message
  - Ultimate ability message
  - Blessing stats messages
  - Silverfish messages
  - Wither/Blood key usage messages
  - Watcher messages
    - Doesn't remove the final message
- Lore cleanup, still customizable (0.2.0+)
  - Gear score line
  - HPB stat bonuses
  - Reforge stat bonuses
  - Gemstone stat bonuses
  - Gemstone icons
  - Enchantment descriptions
    - And an option to remove enchantment names
  - Item abilities
  - Full armor set bonuses
  - Soulbound text
  - Obfuscated text from recombobulator
  - Option to not cleanup lore when in the auction house
- Tablist cleanup (0.2.0+)
  - Option to remove tablist header
  - Option to remove the last 2 lines from the tablist footer
- Chat cleanup (0.3.0+)
  - Option to remove old reforge messages when a new one is received
  - 
    
</details>

<details>
    <summary>Future features</summary>

### Future features
Features from future versions of the game. Yes, I don't know to name this one.
- Chunk borders (F3 + G)
- Chat clear (F3 + D) not clearing sent messages, so up and down arrows still work.
</details>

<details>
  <summary>Utilities</summary>

### Utilities
The actual collection of QoL features that doesn't fit any other category.
- Container Chat
  - Allows you to type and chat while inside gui inventories
- Search Mode
  - Allows you to toggle search mode by pressing Ctrl + F with chat open,
    which will only display chat messages that contain what you type.
  - Mode to scroll back to a message when you right click on it while on search mode.
- Backpack Retexturing
- HOTM Perk Level Display
  - Displays perk level as stack size in the HOTM menu.
- Drop chance to drop rate
  - Converts item drop chance to drop rate in the bestiary menu.
- Bestiary glance
  - Displays bestiary level and progress in the bestiary menu.
- Armadillo fix
  - Prevents your screen being blocked when you are inside a block while riding an armadillo pet.
- Wishing compass triangulation
  - Locates where a wishing compass points to. Use one, wait for the particle trail to disappear, move away and use it again.
  - Option to add a waypoint at the location while using [Skytils](https://github.com/Skytils/SkytilsMod/).
- Ancestral Spade triangulation
  - Quite literally the same thing as wishing compass, but with a few changes.
- Wishing compass uses left display
  - Displays a wishing compass' left uses as stack size.
- Visible links
  - Makes clickable links in chat blue and underlined.
- Colorless panes
  - Turns glass panes gray so glass blocks are more visible. Just used for some gemstone mining, really.
- Chat in portal
  - Allows you to type and use chat while inside a nether portal, like the one in dungeon blood room.
  - **Note**: It's possible to make portals not close containers such as player inventory, ender chest and others,
    but won't for now since I don't know if Hypixel would like that.
- Better wither impact perspective (im good with names, 0.2.0+)
  - Toggling perspective while holding a wither impact weapon will skip the front camera.
  - Option to make it global instead of wither impact only (0.3.0+)
- Superpairs IDs (0.2.0+)
  - Gives skyblock item IDs to items inside superpairs, so NEU and SBE can read them for price displays.
  - Additionally, resource packs can also modify those items.
  - This was made 1 minute before realizing [Skytils](https://github.com/Skytils/SkytilsMod/) has a working price display inside superpairs, so no need to use this if you use Skytils.
- Shares
  - Shares are a way to showcase your items to other users using the mod.
  - To show an item, hold it and type "[item]" (configurable) in chat.
  - Option to be able to scroll through the share tooltip while using [ScrollableTooltips](https://github.com/Sk1erLLC/ScrollableTooltips)
  - Option to click a share to copy an embed for discord. Simply copy it and paste it in a channel on discord.
- Bridge messages
  - Formats guild messages sent by a bridge bot.
  - Detects username and message based on message format.
    - Currently, only works with the formats "ign > msg" and "ign: msg".
    - If your bridge bot has another format, let me know.
    - If you don't have a bridge bot, [get one](https://neppy.antonio32a.com/).
  - Customizable bot name.
  - Customizable message format.
  - Working links sent from discord while using the format.
  - Compatible with [Skytils](https://github.com/Skytils/SkytilsMod/)' guild chat tab regardless of format.
- Optifine
  - Allows you to have any optifine user's cape. Only you see this cape!
  - Options to bring back from early SkyBlock:
    - Yeti with trans cape.
    - Terracotta with trans cape.
    - Bonzo with non binary cape.
    - Grinch with candy cane cape.
    - Option to disable all of them, but come on, why would you.
  - Option to disable optifine's santa/witch hat.
- [Patcher](https://github.com/Sk1erLLC/Patcher)
  - Option to fix an issue that would make compact chat not work under very specific circumstance.
    Also when using search mode/container chat in some instances.
  - Option to add custom trusted domains to Patcher's Image Preview.
    - Some image hosts, like [boob.li](https://boob.li/), won't work with [Patcher](https://github.com/Sk1erLLC/Patcher) 's Image Preview, but will when trusted with this feature.
</details>
<details>
  <summary>Commands</summary>

### Commands

The mod only really has one command, /synth, which hosts all other subcommands.
- /synth
  - Aliases: /synthesis, /syn
  - When used without an argument, it opens the config menu.
  - Subcommands:
    - bp
      - Arguments: backpack number, texture name, texture meta.
      - Re textures the backpack in the *backpack number* slot, with the texture *texture name* and *texture meta*
      - For example, if you wanted the first backpack to be a fish, you would just use /synth bp fish. If you wanted a pufferfish instead, you would do /synth bp fish 3.
      - To remove a backpack's texture, don't add any texture name or meta to the command.
    - domains
      - Arguments: "add/remove/list", domain
      - Adds or removes a domain to or from the trusted domain list for [Patcher](https://github.com/Sk1erLLC/Patcher)'s Image Preview.
      - Can also list all the current trusted domains.
</details>
