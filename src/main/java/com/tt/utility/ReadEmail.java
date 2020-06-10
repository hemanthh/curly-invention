package com.tt.utility;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.URLName;

import org.testng.annotations.Test;

public class ReadEmail  extends BaseTest
{

	String hostName = "smtp.gmail.com";
	String username = "subhash.kancharla@pegs.com";
	String password = "Travel123";
	int messageCount;
	int unreadMsgCount;
	String emailSubject;
	Message emailMessage;

	@Test
	public void MailReader() {
		Properties sysProps = System.getProperties();
		//sysProps.setProperty("mail.store.protocol", "imaps");
		sysProps.setProperty("mail.imap.host", "imap.gmail.com");
		
		
		try {
			Session session = Session.getInstance(sysProps, null);
			
			/*
			Store store = session.getStore();
			store.connect(hostName, username, password);
			Session session = Session.getDefaultInstance(props, new MyAuthenticator());
			*/
			
		    URLName urlName = new URLName("imap://subhash481@gmail.com:guess037@imap.gmail.com");
		    Store store = session.getStore(urlName);
		    if (!store.isConnected()) {
		        store.connect();
		    }
			
			Folder emailInbox = store.getFolder("INBOX");
			emailInbox.open(Folder.READ_WRITE);
			messageCount = emailInbox.getMessageCount();
			System.out.println("Total Message Count: " + messageCount);
			unreadMsgCount = emailInbox.getNewMessageCount();
			System.out.println("Unread Emails count:" + unreadMsgCount);
			emailMessage = emailInbox.getMessage(messageCount);
			emailSubject = emailMessage.getSubject();

			Pattern linkPattern = Pattern.compile("href=\"(.*)\" target");
			// here you need to define regex as per you need
			Matcher pageMatcher = linkPattern.matcher(emailMessage.getContent().toString());

			while (pageMatcher.find()) {
				System.out.println("Found OTP " + pageMatcher.group(1));
			}
			emailMessage.setFlag(Flags.Flag.SEEN, true);
			emailInbox.close(true);
			store.close();

		} catch (Exception mex) {
			mex.printStackTrace();
		}
	}

}
