package ti_idf.mode;

public class AnalyzerFactory {
     public static LogAnalyzer getLogFileAnalyzer(){
    	 return new LogAnalyzer();
     }
}
