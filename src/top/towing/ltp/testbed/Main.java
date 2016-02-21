package top.towing.ltp.testbed;

import java.io.IOException;
import java.util.List;

import top.towing.ltp.testbed.entity.Session;
import top.towing.ltp.testbed.helper.CSVHelper;
import top.towing.ltp.testbed.helper.ParserHelper;

public class Main {
	private final static String sampleFilePath = System.getProperty("user.dir") + "/resource/sample.csv"; 

	public static void main(String[] args) {
		CSVHelper csvHelper = new CSVHelper();
		ParserHelper parserHelper = new ParserHelper();
		try {
			List<Session> sessions = csvHelper.parseSampleCSV(sampleFilePath);
			for (Session session : sessions) {
				parserHelper.parseSession(session);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
