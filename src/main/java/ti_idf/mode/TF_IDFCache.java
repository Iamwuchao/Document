package ti_idf.mode;

import java.util.Map;

import com.google.common.collect.Maps;

public class TF_IDFCache {
   private Map<String,Integer> tfCache = Maps.newHashMap();
   private Map<String,Integer> idfCache = Maps.newHashMap();
	public Map<String, Integer> getTfCache() {
		return tfCache;
	}
	public void setTfCache(Map<String, Integer> tfCache) {
		this.tfCache = tfCache;
	}
	public Map<String, Integer> getIdfCache() {
		return idfCache;
	}
	public void setIdfCache(Map<String, Integer> idfCache) {
		this.idfCache = idfCache;
	}
   
   
}
