package com.kaijin.mffs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.NoSuchElementException;


import net.minecraft.src.World;
import net.minecraft.src.mod_ModularForceFieldSystem;

public final class WorldMap {

	private static Map ForceFieldWorld = new HashMap();
	static StringBuffer hasher = new StringBuffer();

	public static WorldForceField getForceFieldforWorld(World world) {

		if (world != null) {

			if (!ForceFieldWorld.containsKey(world)) {
				ForceFieldWorld.put(world, new WorldForceField());
			}
			return (WorldForceField) ForceFieldWorld.get(world);
		}

		return null;

	}

}
