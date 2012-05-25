package net.minecraft.src;

import java.io.File;
import java.util.Hashtable;
import java.util.Map;

import net.minecraft.src.forge.*;
import net.minecraft.src.ic2.api.*;
import com.kaijin.mffs.*;

public class mod_ModularForceFieldSystem extends NetworkMod {

    public static mod_ModularForceFieldSystem instance;
	public static Configuration config = CommonProxy.getConfiguration();
	
	public static Block MFFSMaschines;
	public static Block MFFSUpgrades;
	public static Block MFFSFieldblock;
	
	public static Item MFFSitemMFDReaktorlink;
	public static Item MFFSitemMFDwrench;
	public static Item MFFSitemMFDidtool;
	public static Item MFFSitemMFDdebugger;
	public static Item MFFSitemcardempty;
	public static Item MFFSitemfc;
	public static Item MFFSitemidc;
	public static Item MFFSitemsclc;
	
	public static int guiIDGenerator;
	public static int guiareaproje;
	public static int guidirectprojektor;
	public static int guideflectorprojektor;
	public static int guidirectupgrade;
	public static int guitubeprojektor;
	public static int guicamouflageupgrade;
	public static int guireaktorfield;
	public static int guireaktorcooler;
	public static int guireaktormonitor;
	public static int guireaktormonitorclient;
	public static int guireaktormonitorremote;
	
	public static int forcefieldblockcost;
	public static int forcefieldblockcreatemodifier;
	public static int forcefieldblockzappermodifier;
	
	public static int reaktorheatcontrolice;
	public static int reaktorheatcontrolwater;
	public static int reaktorheatcontrollava;
	

	public static StringBuffer hasher = new StringBuffer();
	public static Map<Integer, Integer[]> idtotextur = new Hashtable<Integer, Integer[]>();

    @Override
    public void load()
    {
        MinecraftForge.setGuiHandler(this.instance, new GuiHandlerMFFS());
        MinecraftForge.registerConnectionHandler(new ConnectionHandler());

        ModLoader.registerBlock(MFFSMaschines, ItemMachines.class);
        ModLoader.registerBlock(MFFSUpgrades, ItemUpgrades.class);

        ModLoader.registerTileEntity(TileEntityMaschines.class, "Maschines_Multi");
        ModLoader.registerTileEntity(TileEntityGeneratorCore.class, "Generator_Core");
        ModLoader.registerTileEntity(TileEntityAreaProjektor.class, "Area_Projektor");
        ModLoader.registerTileEntity(TileEntityPassivUpgrade.class, "Generator_Upgrade");
        ModLoader.registerTileEntity(TileEntityGeneratorEUInjector.class, "Generator_EU_Injektor");
        ModLoader.registerTileEntity(TileEntityDirectionalProjektor.class, "Directional_Projektor");
        ModLoader.registerTileEntity(TileEntityDeflectorProjektor.class, "Deflector_Projektor");
        ModLoader.registerTileEntity(TileEntityDirectionalExtender.class, "Directional_Extender");
        ModLoader.registerTileEntity(TileEntityTubeProjektor.class, "Tube_Projektor");
        ModLoader.registerTileEntity(TileEntityCamoflageUpgrade.class, "Projektor_camouflage");
        ModLoader.registerTileEntity(TileEntityReaktorField.class, "Reaktor_Field");
        ModLoader.registerTileEntity(TileEntityReaktorConnector.class, "Reactor_Connector");
        ModLoader.registerTileEntity(TileEntityReaktorCooler.class, "Reaktor_Cooler");
        ModLoader.registerTileEntity(TileEntityReaktorMonitor.class, "Reaktor_Monitor");
        ModLoader.registerTileEntity(TileEntityReaktorMonitorClient.class, "Reaktor_Monitor_Client");       
        
        idtotextur.put(new Integer(1), new Integer[] { 17, 17, 17, 17, 17, 17 }); //
        idtotextur.put(new Integer(3), new Integer[] { 18, 18, 18, 18, 18, 18 }); //
        idtotextur.put(new Integer(5), new Integer[] { 20, 20, 20, 20, 20, 20 }); //
        idtotextur.put(new Integer(45), new Integer[] { 23, 23, 23, 23, 23, 23 }); //
        idtotextur.put(new Integer(4), new Integer[] { 32, 32, 32, 32, 32, 32 }); //
        idtotextur.put(new Integer(7), new Integer[] { 33, 33, 33, 33, 33, 33 }); //
        idtotextur.put(new Integer(12), new Integer[] { 34, 34, 34, 34, 34, 34 }); //
        idtotextur.put(new Integer(13), new Integer[] { 35, 35, 35, 35, 35, 35 }); //
        idtotextur.put(new Integer(42), new Integer[] { 38, 38, 38, 38, 38, 38 }); //
        idtotextur.put(new Integer(41), new Integer[] { 39, 39, 39, 39, 39, 39 }); //
        idtotextur.put(new Integer(57), new Integer[] { 40, 40, 40, 40, 40, 40 }); //
        idtotextur.put(new Integer(14), new Integer[] { 48, 48, 48, 48, 48, 48 }); //
        idtotextur.put(new Integer(15), new Integer[] { 49, 49, 49, 49, 49, 49 }); //
        idtotextur.put(new Integer(16), new Integer[] { 50, 50, 50, 50, 50, 50 }); //
        idtotextur.put(new Integer(48), new Integer[] { 52, 52, 52, 52, 52, 52 }); //
        idtotextur.put(new Integer(49), new Integer[] { 53, 53, 53, 53, 53, 53 }); //
        idtotextur.put(new Integer(19), new Integer[] { 64, 64, 64, 64, 64, 64 }); //
        idtotextur.put(new Integer(56), new Integer[] { 66, 66, 66, 66, 66, 66 }); //
        idtotextur.put(new Integer(73), new Integer[] { 67, 67, 67, 67, 67, 67 }); //
        idtotextur.put(new Integer(79), new Integer[] { 83, 83, 83, 83, 83, 83 }); //
        idtotextur.put(new Integer(82), new Integer[] { 88, 88, 88, 88, 88, 88 }); //
        idtotextur.put(new Integer(87), new Integer[] { 30, 30, 30, 30, 30, 30 }); //
        idtotextur.put(new Integer(88), new Integer[] { 31, 31, 31, 31, 31, 31 }); //
        idtotextur.put(new Integer(89), new Integer[] { 44, 44, 44, 44, 44, 44 }); //
        idtotextur.put(new Integer(22), new Integer[] { 85, 85, 85, 85, 85, 85 }); //
        idtotextur.put(new Integer(21), new Integer[] { 71, 71, 71, 71, 71, 71 }); //
        idtotextur.put(new Integer(17), new Integer[] { 37, 37, 36, 36, 36, 36 }); //
        idtotextur.put(new Integer(1017), new Integer[] { 37, 37, 92, 92, 92, 92 }); //
        idtotextur.put(new Integer(2017), new Integer[] { 37, 37, 93, 93, 93, 93 }); //
        idtotextur.put(new Integer(35), new Integer[] { 80, 80, 80, 80, 80, 80 }); //
        idtotextur.put(new Integer(8035), new Integer[] { 81, 81, 81, 81, 81, 81 }); //
        idtotextur.put(new Integer(7035), new Integer[] { 46, 46, 46, 46, 46, 46 }); //
        idtotextur.put(new Integer(15035), new Integer[] { 45, 45, 45, 45, 45, 45 }); //
        idtotextur.put(new Integer(12035), new Integer[] { 72, 72, 72, 72, 72, 72 }); //
        idtotextur.put(new Integer(14035), new Integer[] { 73, 73, 73, 73, 73, 73 }); //
        idtotextur.put(new Integer(2035), new Integer[] { 74, 74, 74, 74, 74, 74 }); //
        idtotextur.put(new Integer(11035), new Integer[] { 69, 69, 69, 69, 69, 69 }); //
        idtotextur.put(new Integer(3035), new Integer[] { 79, 79, 79, 79, 79, 79 }); //
        idtotextur.put(new Integer(13035), new Integer[] { 86, 86, 86, 86, 86, 86 }); //
        idtotextur.put(new Integer(5035), new Integer[] { 87, 87, 87, 87, 87, 87 }); //
        idtotextur.put(new Integer(4035), new Integer[] { 89, 89, 89, 89, 89, 89 }); //
        idtotextur.put(new Integer(10035), new Integer[] { 97, 97, 97, 97, 97, 97 }); //
        idtotextur.put(new Integer(2035), new Integer[] { 98, 98, 98, 98, 98, 98 }); //
        idtotextur.put(new Integer(9035), new Integer[] { 100, 10, 100, 100, 100, 100 }); //
        idtotextur.put(new Integer(1035), new Integer[] { 101, 101, 101, 101, 101, 101 }); //
        idtotextur.put(new Integer(98), new Integer[] { 70, 70, 70, 70, 70, 70 }); //
        idtotextur.put(new Integer(2098), new Integer[] { 28, 28, 28, 28, 28, 28 }); //
        idtotextur.put(new Integer(1098), new Integer[] { 27, 27, 27, 27, 27, 27 }); //
        idtotextur.put(new Integer(20), new Integer[] { 15, 15, 15, 15, 15, 15 }); //
        CommonProxy.load();
    }

    static {

        try {
            config.load();
        } catch (Exception exception) {
            config = null;
            System.err.print(exception.toString());
        }

        reaktorheatcontrolice = Functions.getBlockIdFor("reaktorheatcontrolice", 100);
        reaktorheatcontrolwater = Functions.getBlockIdFor("reaktorheatcontrolwater", 50);
        reaktorheatcontrollava = Functions.getBlockIdFor("reaktorheatcontrollava", 100);
        
        forcefieldblockcost = Functions.getBlockIdFor("forcefieldblockcost", 1);
        forcefieldblockcreatemodifier = Functions.getBlockIdFor("forcefieldblockcreatemodifier", 10);
        forcefieldblockzappermodifier = Functions.getBlockIdFor("forcefieldblockzappermodifier", 2);

        guiIDGenerator = Functions.getGuiIdFor("guiIDGenerator", 60);
        guiareaproje = Functions.getGuiIdFor("guicubeprojektor", 61);
        guidirectprojektor = Functions.getGuiIdFor("guidirectprojektor", 62);
        guideflectorprojektor = Functions.getGuiIdFor("guideflectorprojektor", 63);
        guidirectupgrade = Functions.getGuiIdFor("guidirectupgrade", 64);
        guitubeprojektor = Functions.getGuiIdFor("guitubeprojektor", 65);
        guicamouflageupgrade = Functions.getGuiIdFor("guicamouflageupgrade", 66);
        guireaktorfield = Functions.getGuiIdFor("guireaktorfield", 67);
        guireaktorcooler = Functions.getGuiIdFor("guireaktorcooler", 68);
        guireaktormonitor = Functions.getGuiIdFor("guireaktormonitor", 69);
        guireaktormonitorclient = Functions.getGuiIdFor("guireaktormonitorclient", 70);
        
        MFFSFieldblock = new BlockForceField(Functions.getBlockIdFor("HFFPFieldblock", 255));
        MFFSMaschines = new BlockMachine(Functions.getBlockIdFor("HFFPMaschines", 253));
        MFFSUpgrades = new BlockUpgrades(Functions.getBlockIdFor("HFFSUpgrades", 254));

        MFFSitemMFDReaktorlink = new ItemMFD_Reaktorlink(Functions.getItemIdFor("itemMFDReaktorlink", 11110)).setItemName("itemMFDReaktorlink");
        MFFSitemMFDdebugger = new ItemMFD_debuger(Functions.getItemIdFor("itemMFDdebugger", 11111)).setItemName("itemMFDdebugger");
        MFFSitemMFDidtool = new ItemMFD_IDwriter(Functions.getItemIdFor("itemMFDidtool", 11112)).setItemName("itemMFDidtool");
        MFFSitemMFDwrench = new ItemMFD_wrench(Functions.getItemIdFor("itemMFDwrench", 11114)).setItemName("itemMFDwrench");
        MFFSitemcardempty = new ItemCardempty(Functions.getItemIdFor("itemcardempty", 11115)).setItemName("itemcardempty");
        MFFSitemfc = new ItemFrequenzCard(Functions.getItemIdFor("itemfc", 11116)).setItemName("itemfc");
        MFFSitemidc = new ItemIDCard(Functions.getItemIdFor("itemidc", 11117)).setItemName("itemidc");
        MFFSitemsclc = new ItemSecLinkCard(Functions.getItemIdFor("itemsclc", 11118)).setItemName("itemsclc");
        
        if (config != null) {
            config.save();
        }
    }
	
	public mod_ModularForceFieldSystem()
	{
	    instance = this;
	}
	
    public void modsLoaded()
    {
        super.modsLoaded();
    	ExplosionWhitelist.addWhitelistedBlock(MFFSFieldblock);
    	ExplosionWhitelist.addWhitelistedBlock(MFFSUpgrades);
    	ExplosionWhitelist.addWhitelistedBlock(MFFSMaschines);
    	
		ModLoader.addRecipe(new ItemStack(MFFSMaschines, 1, 5), new Object[] { " B ", "ACA", " A ", Character.valueOf('A'), Items.getItem("advancedAlloy"), Character.valueOf('B'), Item.diamond, Character.valueOf('D'), Items.getItem("frequencyTransmitter") });
		ModLoader.addRecipe(new ItemStack(MFFSMaschines, 1, 4), new Object[] { "ABA", "BCB", "DED", Character.valueOf('A'), Items.getItem("advancedAlloy"), Character.valueOf('B'), Item.diamond, Character.valueOf('D'), Items.getItem("electronicCircuit"), Character.valueOf('C'), Items.getItem("frequencyTransmitter"), Character.valueOf('E'), Items.getItem("electrolyzedWaterCell") });
		ModLoader.addRecipe(new ItemStack(MFFSMaschines, 1, 1), new Object[] { "BBB", "BCB", "DED", Character.valueOf('A'), Items.getItem("advancedAlloy"), Character.valueOf('B'), Item.diamond, Character.valueOf('D'), Items.getItem("electronicCircuit"), Character.valueOf('C'), Items.getItem("frequencyTransmitter"), Character.valueOf('E'), Items.getItem("electrolyzedWaterCell") });
		ModLoader.addRecipe(new ItemStack(MFFSMaschines, 1, 3), new Object[] { "BAB", "ACA", "DED", Character.valueOf('A'), Items.getItem("advancedAlloy"), Character.valueOf('B'), Item.diamond, Character.valueOf('D'), Items.getItem("electronicCircuit"), Character.valueOf('C'), Items.getItem("frequencyTransmitter"), Character.valueOf('E'), Items.getItem("electrolyzedWaterCell") });
		ModLoader.addRecipe(new ItemStack(MFFSMaschines, 1, 2), new Object[] { "ABA", "ACA", "DED", Character.valueOf('A'), Items.getItem("advancedAlloy"), Character.valueOf('B'), Item.diamond, Character.valueOf('D'), Items.getItem("electronicCircuit"), Character.valueOf('C'), Items.getItem("frequencyTransmitter"), Character.valueOf('E'), Items.getItem("electrolyzedWaterCell") });
		ModLoader.addRecipe(new ItemStack(MFFSMaschines, 1, 6), new Object[] { "ABA", "CDC", "ABA", Character.valueOf('A'), Items.getItem("refinedIronIngot"), Character.valueOf('B'), Items.getItem("copperCableItem"), Character.valueOf('C'), Items.getItem("electrolyzedWaterCell"), Character.valueOf('D'), Items.getItem("batBox") });
		ModLoader.addRecipe(new ItemStack(MFFSMaschines, 1, 0), new Object[] { "ABA", "CDC", "AEA", Character.valueOf('A'), Items.getItem("electrolyzedWaterCell"), Character.valueOf('B'), Items.getItem("advancedAlloy"), Character.valueOf('C'), Items.getItem("electronicCircuit"), Character.valueOf('D'), Items.getItem("frequencyTransmitter"), Character.valueOf('E'), Items.getItem("electrolyzer") });
		ModLoader.addRecipe(new ItemStack(MFFSUpgrades, 1, 4), new Object[] { " A ", "ABA", " A ", Character.valueOf('A'), Items.getItem("advancedAlloy"), Character.valueOf('B'), Items.getItem("electrolyzedWaterCell") });
		ModLoader.addRecipe(new ItemStack(MFFSUpgrades, 1, 2), new Object[] { " A ", "ABA", " A ", Character.valueOf('A'), Items.getItem("advancedAlloy"), Character.valueOf('B'), Items.getItem("electronicCircuit") });
		ModLoader.addRecipe(new ItemStack(MFFSUpgrades, 1, 3), new Object[] { " A ", "ABA", " A ", Character.valueOf('A'), Items.getItem("advancedAlloy"), Character.valueOf('B'), Items.getItem("carbonPlate") });
		ModLoader.addRecipe(new ItemStack(MFFSUpgrades, 1, 5), new Object[] { " A ", "ABA", " A ", Character.valueOf('A'), Items.getItem("advancedAlloy"), Character.valueOf('B'), Items.getItem("frequencyTransmitter") });
		ModLoader.addRecipe(new ItemStack(MFFSUpgrades, 1, 1), new Object[] { " A ", "ABA", " A ", Character.valueOf('A'), Items.getItem("advancedAlloy"), Character.valueOf('B'), Item.bucketEmpty });
		ModLoader.addRecipe(new ItemStack(MFFSitemMFDwrench), new Object[] { "BCB", "DAD", "DDD", Character.valueOf('A'), Item.diamond, Character.valueOf('B') ,Items.getItem("copperCableItem")  , Character.valueOf('C') ,Item.redstone , Character.valueOf('D') ,Items.getItem("refinedIronIngot")  });
		ModLoader.addRecipe(new ItemStack(MFFSitemcardempty), new Object[] { "AAA", "ABA", "AAA", Character.valueOf('A'), Item.paper, Character.valueOf('B'), Items.getItem("electronicCircuit") });
		ModLoader.addRecipe(new ItemStack(MFFSUpgrades, 1, 6), new Object[] { " A ", "ABA", " A ", Character.valueOf('A'), Items.getItem("advancedAlloy"), Character.valueOf('B'), Items.getItem("teslaCoil") });
        ModLoader.addRecipe(new ItemStack(MFFSUpgrades, 1, 7), new Object[] { "BAB", "ACA", "BAB", Character.valueOf('A'), Items.getItem("advancedAlloy"), Character.valueOf('B'), Item.diamond, Character.valueOf('C'), Items.getItem("frequencyTransmitter") });
		ModLoader.addRecipe(new ItemStack(MFFSUpgrades, 1, 8), new Object[] { "ACA", "BDB", "ACA", Character.valueOf('A'), Items.getItem("advancedAlloy"), Character.valueOf('B'), Item.redstone, Character.valueOf('C'), Items.getItem("trippleInsulatedIronCableItem"), Character.valueOf('D'), Items.getItem("frequencyTransmitter") });
        ModLoader.addRecipe(new ItemStack(MFFSMaschines, 1, 7), new Object[] { "ADA", "BCB", "ABA", Character.valueOf('A'), Items.getItem("carbonPlate"), Character.valueOf('B'), Items.getItem("advancedAlloy"), Character.valueOf('C'), new ItemStack(MFFSMaschines, 1, 1), Character.valueOf('D'), Items.getItem("advancedCircuit") });    	
        ModLoader.addRecipe(new ItemStack(MFFSMaschines, 1, 8), new Object[] { "DCD", "CAC", "DBD", Character.valueOf('A'), Items.getItem("advancedMachine"),Character.valueOf('B'), Block.chest,Character.valueOf('C'), Items.getItem("integratedHeatDisperser") , Character.valueOf('D'), Items.getItem("advancedAlloy")});    
        ModLoader.addRecipe(new ItemStack(MFFSMaschines, 1, 9), new Object[] { "ECE", "DBD", "EAE", Character.valueOf('A'), Items.getItem("advancedMachine"),Character.valueOf('B'), Items.getItem("frequencyTransmitter") , Character.valueOf('C'), Items.getItem("detectorCableItem"), Character.valueOf('D'), Items.getItem("electronicCircuit"), Character.valueOf('E'), Items.getItem("refinedIronIngot")});
        ModLoader.addRecipe(new ItemStack(MFFSUpgrades, 1, 0), new Object[] { "ECE", "DBD", "EAE", Character.valueOf('A'), Items.getItem("machine"),Character.valueOf('B'), Items.getItem("frequencyTransmitter") , Character.valueOf('C'), Item.redstone, Character.valueOf('D'), Items.getItem("electronicCircuit"), Character.valueOf('E'), Items.getItem("refinedIronIngot")});
    	
        ModLoader.addRecipe(new ItemStack(MFFSitemMFDReaktorlink), new Object[] { "DCD", "BAB", "CBC", Character.valueOf('A'), Items.getItem("frequencyTransmitter"), Character.valueOf('B'), Items.getItem("electronicCircuit") , Character.valueOf('C'), Items.getItem("carbonPlate"), Character.valueOf('D'), Item.redstone});
 
        ModLoader.addShapelessRecipe(new ItemStack(MFFSitemMFDwrench), new Object[]{new ItemStack(MFFSitemMFDidtool)});
        ModLoader.addShapelessRecipe(new ItemStack(MFFSitemMFDidtool), new Object[]{new ItemStack(MFFSitemMFDwrench)});
         
    }

	public String getVersion() {

		return "1.2 Beta 6pre3_2";
	}

	@Override
    public boolean clientSideRequired()
    {
        return true;
    }

    @Override
    public boolean serverSideRequired()
    {
        return false;
    }
}