package com.kaijin.mffs;

import java.util.Hashtable;
import java.util.Map;

class TexturMap {

	public static Map<String, Integer> TTextur = new Hashtable<String, Integer>();

	public void add(int x, int y, int z, int textur) {
		TexturworldMap.hasher.setLength(0);
		TexturworldMap.hasher.append(x).append("/").append(y).append("/").append(z);
		TTextur.put(TexturworldMap.hasher.toString(), textur);
	}

	public void addfromUpate(String hasher, int textur) {

		TTextur.put(hasher.toString(), textur);
	}

	public int getTextur(int x, int y, int z) {
		TexturworldMap.hasher.setLength(0);
		TexturworldMap.hasher.append(x).append("/").append(y).append("/").append(z);

		if (TTextur.get(TexturworldMap.hasher.toString()) != null) {
			return TTextur.get(TexturworldMap.hasher.toString());
		}

		return -1;

	}

	public int getSize() {

		return TTextur.size();
	}

}