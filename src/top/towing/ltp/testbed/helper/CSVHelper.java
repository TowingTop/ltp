package top.towing.ltp.testbed.helper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import top.towing.ltp.testbed.entity.Session;
import top.towing.ltp.testbed.entity.Message;

public class CSVHelper {
    private final String CVS_SPLIT_BY = ",";
	
	public List<Session> parseSampleCSV(String csvFile) throws IOException {
		List<Session> sessions = new ArrayList<Session>();
		BufferedReader br = new BufferedReader(new FileReader(csvFile));
		try {		
			String line = br.readLine();
			String lastSessionId = "";
			
			while((line = br.readLine()) != null) {
				String[] tokens = line.split(CVS_SPLIT_BY);
				Session currentSession = null;
				if (lastSessionId != tokens[1]) {
					lastSessionId = tokens[1];					
					// create new session
					currentSession = new Session(lastSessionId);	
					List<Message> messages = new ArrayList<Message>();
					currentSession.setMessages(messages);
					sessions.add(currentSession);
				}
				
				// create new message
				Message message = createMessage(tokens);
				List<Message> messages = currentSession.getMessages();
				messages.add(message);					
			} 
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			br.close();
		}
		return sessions;
	}
	
	private Message createMessage(String[] tokens) {
		// create new message
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/mm/dd HH:mm");
		Date timeStamp = null;
		try {
			timeStamp = formatter.parse(tokens[2]);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String senderName = tokens[3];
		String senderRole = tokens[4];
		String content = tokens[5];
		
		return new Message(timeStamp, senderName, senderRole, content);
	}
}
