package com.kaijin.mffs;

import java.io.File;
import net.minecraft.src.*;
import net.minecraft.src.forge.*;
import net.minecraft.client.Minecraft;
import com.kaijin.mffs.*;

public class CommonProxy
{
    public static void load()
    {
        MinecraftForgeClient.preloadTexture("/com/kaijin/mffs/textures/upgrades.png");
        MinecraftForgeClient.preloadTexture("/com/kaijin/mffs/textures/machines.png");
        MinecraftForgeClient.preloadTexture("/com/kaijin/mffs/textures/blocks.png");
        MinecraftForgeClient.preloadTexture("/com/kaijin/mffs/textures/items.png");
        ModLoader.addName(mod_ModularForceFieldSystem.MFFSitemMFDidtool, "MFDevice <ID-Tool>");
        ModLoader.addName(mod_ModularForceFieldSystem.MFFSitemMFDwrench, "MFDevice <Wrench>");
        ModLoader.addName(mod_ModularForceFieldSystem.MFFSitemcardempty, "MFFS Card blank ");
        ModLoader.addName(mod_ModularForceFieldSystem.MFFSitemfc, "MFFS Frequency Card");
        ModLoader.addName(mod_ModularForceFieldSystem.MFFSitemidc, "MFFS ID Card");
        ModLoader.addName(mod_ModularForceFieldSystem.MFFSitemMFDdebugger, "MFDevice <Debugger>");
        ModLoader.addName(mod_ModularForceFieldSystem.MFFSitemsclc, "MFFS  Link Card");
        ModLoader.addName(mod_ModularForceFieldSystem.MFFSitemMFDReaktorlink, "MFFS Remote Reaktor Link");
        
        ModLoader.addLocalization("Tube_Projektor.name", "MFFS Tube Projector");
        ModLoader.addLocalization("Directional_Extender.name", "MFFS directional extender");
        ModLoader.addLocalization("Deflector_Projektor.name", "MFFS deflector");
        ModLoader.addLocalization("Generator_Core.name", "MFFS generator core");
        ModLoader.addLocalization("Area_Projektor.name", "MFFS Area Projector");
        ModLoader.addLocalization("Generator_Storage.name", "MFFS generator storage upgrade");
        ModLoader.addLocalization("Generator_Linkex.name", "MFFS generator range upgrade");
        ModLoader.addLocalization("Generator_EU_Injektor.name", "MFFS generator EU-injector");
        ModLoader.addLocalization("Directional_Projektor.name", "MFFS directional projektor");
        ModLoader.addLocalization("Projektor_Subwater.name", " MFFS Projector underwater upgrade");
        ModLoader.addLocalization("Projektor_Dome.name", "MFFS Projector dome upgrade");
        ModLoader.addLocalization("Projektor_Hardner.name", "MFFS Projector block cutter upgrade");
        ModLoader.addLocalization("Projektor_Zapper.name", "MFFS Projector ZAPPER upgrade");
        ModLoader.addLocalization("Projektor_camouflage.name", "MFFS Projector camouflage upgrade");
        ModLoader.addLocalization("Reaktor_Field.name", "MFFS nuclear reactor containment ");
        ModLoader.addLocalization("Reactor_Connector.name", "MFFS reactor connector ");
        ModLoader.addLocalization("Reaktor_Cooler.name", "MFFS reactor heat control");
        ModLoader.addLocalization("Reaktor_Monitor.name", "MFFS reactor heat monitor server");
        ModLoader.addLocalization("Reaktor_Monitor_Client.name", "MFFS reactor heat monitor client");

    }

    public static Configuration getConfiguration()
    {
        return new Configuration(new File(Minecraft.getMinecraftDir(), "config/ModularForceFieldSystem.cfg"));
    }

    public static World PacketHandlerGetWorld(NetworkManager network)
    {
        //server side needs to grab the world entity
        return ModLoader.getMinecraftInstance().theWorld;
    }

    public static boolean isClient(World world)
    {
        return world instanceof WorldClient;
    }

    public static boolean isServer()
    {
        return false;
    }

    public static void sendPacketToPlayer(String playerName, Packet250CustomPayload packet)
    {
        // ModLoader.getMinecraftServerInstance().configManager.sendPacketToPlayer(playerName, packet);
    }

    public static void sendPacketToServer(Packet250CustomPayload packet)
    {
        ModLoader.sendPacket(packet);
    }
}
