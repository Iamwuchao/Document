package tf_idf.fileutil;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import ti_idf.mode.LogDocument;

public interface FileProcess {
  List<LogDocument> getAllDocuments(String path,Charset charset) throws IOException;
}
