package ti_idf.mode;

public class DocumentFactory {
  public static LogDocument getLogDocument(String content,Analyzer analyzer){
	  return new LogDocument(content,analyzer);
  }
}
