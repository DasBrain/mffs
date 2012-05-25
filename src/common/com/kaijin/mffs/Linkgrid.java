package com.kaijin.mffs;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.src.World;

public final class Linkgrid {

	private static Map WorldpowernetMap = new HashMap();

	public static Worldlinknet getWorldMap(World world) {
		if (world != null) {

			if (!WorldpowernetMap.containsKey(world)) {
				WorldpowernetMap.put(world, new Worldlinknet());
			}
			return (Worldlinknet) WorldpowernetMap.get(world);
		}

		return null;
	}

}