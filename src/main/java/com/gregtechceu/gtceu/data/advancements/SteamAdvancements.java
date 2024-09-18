package com.gregtechceu.gtceu.data.advancements;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.tterrag.registrate.providers.RegistrateAdvancementProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class SteamAdvancements {
    public static Advancement STEAM_VENT_DEATH;

    public static void init(RegistrateAdvancementProvider provider) {
        provider.accept(STEAM_VENT_DEATH = Advancement.Builder.advancement()
                .display(
                        GTItems.COVER_ITEM_DETECTOR.asItem(),
                        Component.translatable("gtceu.advancement.steam.85_steam_vent_death.title"),
                        Component.translatable("gtceu.advancement.steam.85_steam_vent_death.desc"),
                        GTCEu.id("textures/gui/advancements/background.png"),
                        FrameType.TASK,
                        true,
                        true,
                        false)
                .build(GTCEu.id("steam/steam_vent_death"))
        );
    }
}
