package it.paleocapa.mastroiannim;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class JavaBossBot extends TelegramLongPollingBot {

	@Autowired
    private Environment env;

	private static final Logger LOG = LoggerFactory.getLogger(JavaBossBot.class);
	 
	@Value("${telegram.username}") 
	private String botUsername;
    
	@Value("${telegram.token}") 
	private String botToken;

	public String getBotUsername() {
		LOG.info(env.getProperty("botUsername"));
		LOG.info(botUsername);
		return botUsername;
	}

	@Override
	@Deprecated
	public String getBotToken() {
		LOG.info(env.getProperty("botToken"));
		LOG.info(botToken);
		return botToken;
	}

	public void onUpdateReceived(Update update) {
		if (update.hasMessage() && update.getMessage().hasText()) {
			
			long chatId = update.getMessage().getChatId();
			
			SendMessage message = new SendMessage();
			message.setChatId(chatId);
			message.setText("Benvenuto! Come posso aiutarti?");
			
			try {
				execute(message);
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
		}
	}
}
