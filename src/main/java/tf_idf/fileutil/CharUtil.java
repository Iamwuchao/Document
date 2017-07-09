package tf_idf.fileutil;

public class CharUtil {

	public boolean isHanZi(char ch){
		int v = (int)ch;
		if(v >=19968 && v <= 171941)
			return true;
		else
			return false;
	}
	
	public boolean isChineseChar(char ch){
		return false;
	}
}
