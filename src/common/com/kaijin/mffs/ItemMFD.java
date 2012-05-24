package com.kaijin.mffs;

import net.minecraft.src.Item;
import net.minecraft.src.forge.ITextureProvider;
import net.minecraft.src.ic2.api.IElectricItem;

public abstract class ItemMFD extends Item implements ITextureProvider {

	protected int tickcounter = 0;
	protected StringBuffer info = new StringBuffer();
	protected StringBuffer hasher = new StringBuffer();

	public ItemMFD(int i, int mode) {
		super(i);
		setMaxStackSize(1);

	}

	public String getTextureFile() {
		return "/mffs_grafik/items.png";
	}

	public boolean isRepairable() {
		return false;
	}

}
