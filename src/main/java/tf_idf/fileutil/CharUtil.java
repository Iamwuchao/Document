package tf_idf.fileutil;

public class CharUtil {

	//中文字符
    public static boolean isChineseByScript(char c) {
        Character.UnicodeScript sc = Character.UnicodeScript.of(c);
        if (sc == Character.UnicodeScript.HAN) {
            return true;
        }
        return false;
    }
	
	// 根据UnicodeBlock方法判断中文标点符号
    public static boolean isChinesePunctuation(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_FORMS
                || ub == Character.UnicodeBlock.VERTICAL_FORMS) {
            return true;
        } else {
            return false;
        }
    }
    
    //判断英文标点
    public static boolean isENPunctuation(char ch){
    	if(!isChineseByScript(ch)){
    		if((ch >='a' && ch<='z')||(ch>='A'&&ch<='Z')||(ch>='0'&& ch<='9')){
    			return false;
    		}
    		return true;
    	}
    	return false;
    }
    
    //判断英文字母
    public static boolean isENcharacter(char ch){
    	if((ch >='a' && ch<='z')||(ch>='A'&&ch<='Z')||(ch>='0'&& ch<='9')){
			return true;
		}
    	else
    		return false;
    }
    
	
}
