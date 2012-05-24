package com.kaijin.mffs;

import net.minecraft.src.*;
import net.minecraft.src.forge.*;
import com.kaijin.mffs.*;

public class GuiHandlerMFFS implements IGuiHandler
{
    @Override
    public Object getGuiElement(int ID, EntityPlayer player, World world,
            int x, int y, int z)
    {
        if (!world.blockExists(x, y, z))
        {
            return null;
        }
        
        TileEntity tile = world.getBlockTileEntity(x, y, z);
        
        if ((tile.getBlockMetadata() == 4 || tile.getBlockMetadata() == 5) && tile.getBlockType() == mod_ModularForceFieldSystem.MFFSUpgrades) {
            ID = mod_ModularForceFieldSystem.guiIDGenerator;
        }

        if (ID == mod_ModularForceFieldSystem.guiIDGenerator) {

            return new GuiGenerator(player.inventory, tile == null ? new TileEntityGeneratorCore() : ((TileEntityGeneratorCore) tile));
        }
        if (ID == mod_ModularForceFieldSystem.guiareaproje) {

            return new GuiProjektorArea(player.inventory, tile == null ? new TileEntityAreaProjektor() : ((TileEntityAreaProjektor) tile));
        }
        if (ID == mod_ModularForceFieldSystem.guidirectprojektor) {

            return new GuiProjektorDirectional(player.inventory, tile == null ? new TileEntityDirectionalProjektor() : ((TileEntityDirectionalProjektor) tile));
        }
        if (ID == mod_ModularForceFieldSystem.guideflectorprojektor) {

            return new GuiDeflectorDirectional(player.inventory, tile == null ? new TileEntityDeflectorProjektor() : ((TileEntityDeflectorProjektor) tile));
        }
        if (ID == mod_ModularForceFieldSystem.guidirectupgrade) {

            return new GuiDirectionalUpgrade(player.inventory, tile == null ? new TileEntityDirectionalExtender() : ((TileEntityDirectionalExtender) tile));
        }
        if (ID == mod_ModularForceFieldSystem.guitubeprojektor) {

            return new GuiProjTube(player.inventory, tile == null ? new TileEntityTubeProjektor() : ((TileEntityTubeProjektor) tile));
        }
        if (ID == mod_ModularForceFieldSystem.guicamouflageupgrade) {

            return new GuiCamouflageUpgrade(player.inventory, tile == null ? new TileEntityCamoflageUpgrade() : ((TileEntityCamoflageUpgrade) tile));
        }
        if (ID == mod_ModularForceFieldSystem.guireaktorfield) {

            return new GuiReaktorField(player.inventory, tile == null ? new TileEntityReaktorField() : ((TileEntityReaktorField) tile));
        }
        if (ID == mod_ModularForceFieldSystem.guireaktorcooler) {

            return new GuiReaktorCooler(player.inventory, tile == null ? new TileEntityReaktorCooler() : ((TileEntityReaktorCooler) tile));
        }
        if (ID == mod_ModularForceFieldSystem.guireaktormonitor) {

            return new GuiReaktorMonitor(player.inventory, tile == null ? new TileEntityReaktorMonitor() : ((TileEntityReaktorMonitor) tile));
        }
        if (ID == mod_ModularForceFieldSystem.guireaktormonitorclient) {

            return new GuiReaktorMonitorClient(player.inventory, tile == null ? new TileEntityReaktorMonitorClient() : ((TileEntityReaktorMonitorClient) tile));
        }
        return null;
    }
}
