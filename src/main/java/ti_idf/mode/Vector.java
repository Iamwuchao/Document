package ti_idf.mode;

import java.util.List;

public class Vector {
  private  String docId;
   private List<Double> vector;
   
	public String getDocId() {
		return docId;
	}
	public void setDocId(String docId) {
		this.docId = docId;
	}
	public List<Double> getVector() {
		return vector;
	}
	public void setVector(List<Double> vector) {
		this.vector = vector;
	} 
   
   
}
