package com.gregtechceu.gtceu.integration.jade.provider;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.common.blockentity.FluidPipeBlockEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import snownee.jade.api.Accessor;
import snownee.jade.api.fluid.JadeFluidObject;
import snownee.jade.api.view.*;

import java.util.ArrayList;
import java.util.List;

public enum FluidPipeStorageProvider implements IServerExtensionProvider<FluidPipeBlockEntity,CompoundTag>, IClientExtensionProvider<CompoundTag, FluidView> {
    INSTANCE;

    @Override
    public List<ClientViewGroup<FluidView>> getClientGroups(Accessor<?> accessor, List<ViewGroup<CompoundTag>> groups) {
        return ClientViewGroup.map(groups, FluidView::readDefault, (group, clientGroup) -> {
            if(group.id != null) {
                clientGroup.title = Component.literal(group.id);
            }
            //clientGroup.bgColor = 0x55666666;
        });
    }

    @Override
    public @Nullable List<ViewGroup<CompoundTag>> getGroups(Accessor<?> accessor,
                                                            FluidPipeBlockEntity pipe) {
        List<ViewGroup<CompoundTag>> tanks = new ArrayList<>();
        for(var tank : pipe.getFluidTanks()) {
            tanks.add(new ViewGroup<>(List.of(FluidView.writeDefault(JadeFluidObject.of(tank.getFluid().getFluid(),
                tank.getFluidAmount()), tank.getCapacity()))));
        }
        return tanks;
    }

    @Override
    public ResourceLocation getUid() {
        return GTCEu.id("fluid_storage");
    }
}
