package tf_idf.fileutil;

public class FileProcessFactory {
     public static LogFileProcess getLogFileProcess(){
    	 return new LogFileProcess();
     }
}
