import java.io.File;
import java.net.URL;
import java.nio.file.Paths;

import edu.jhu.nlp.wikipedia.WikiPage;
import edu.jhu.nlp.wikipedia.WikiPageIterator;
import edu.jhu.nlp.wikipedia.WikiXMLParser;
import edu.jhu.nlp.wikipedia.WikiXMLParserFactory;

public class WikiExtract {

	public static void parseXmlDump(String fileName) {
		WikiXMLParser wxp = WikiXMLParserFactory.getDOMParser(fileName);
		try {
			wxp.parse();
			WikiPageIterator it = wxp.getIterator();
			while(it.hasMorePages()) {
				WikiPage page = it.nextPage();
				System.out.println(page.getTitle());
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		File file = null;
		try {
			file = new File(args[0]);
			parseXmlDump(file.getAbsolutePath());
		} catch (Exception e) {
			System.err.println("Fichier introuvable !");
		}
	}

}
