package com.kaijin.mffs;

import java.util.HashMap;
import java.util.Map;

public final class TexturworldMap {

	private static Map Textur_Map = new HashMap();
	static StringBuffer hasher = new StringBuffer();

	public static TexturMap getTexturMap(Integer typ) {

		if (!Textur_Map.containsKey(typ)) {
			Textur_Map.put(typ, new TexturMap());
		}
		return (TexturMap) Textur_Map.get(typ);

	}

}
