package com.kaijin.mffs;

import java.util.Hashtable;
import java.util.Map;

class WorldForceField {
	private static Map<String, ForceFieldWorldMap> FFWorldMap = new Hashtable<String, ForceFieldWorldMap>();

	public ForceFieldWorldMap addandgetffmp(int x, int y, int z) {
		WorldMap.hasher.setLength(0);
		WorldMap.hasher.append(x).append("/").append(y).append("/").append(z);
		if (FFWorldMap.get(WorldMap.hasher.toString()) == null) {
			FFWorldMap.put(WorldMap.hasher.toString(), new ForceFieldWorldMap(x, y, z));
		}
		return FFWorldMap.get(WorldMap.hasher.toString());
	}

	public ForceFieldWorldMap getFFWM(String hash) {
		return FFWorldMap.get(hash);
	}

}