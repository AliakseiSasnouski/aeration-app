import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.send.SendPhoto;
import org.telegram.telegrambots.api.objects.PhotoSize;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardRemove;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;

public class MyBot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        long chat_id = update.getMessage().getChatId();

        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            // Set variables
            String message_text = update.getMessage().getText();

            if (message_text.equals("/start")) {
                SendMessage message = new SendMessage() // Create a message object object
                        .setChatId(chat_id)
                        .setText("Проветривали ли вы помещение?");
                // Create ReplyKeyboardMarkup object
                ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
                // Create the keyboard (list of keyboard rows)
                List<KeyboardRow> keyboard = new ArrayList<>();
                // Create a keyboard row
                KeyboardRow row = new KeyboardRow();
                // Set each button, you can also use KeyboardButton objects if you need something else than text
                row.add("Да.");
                row.add("Нет.");

                // Add the first row to the keyboard
                keyboard.add(row);
                // Create another keyboard row
                row = new KeyboardRow();
                // Set each button for the second line
                row.add("Отложить на 15 мин.");
                // Add the second row to the keyboard
                keyboard.add(row);
                // Set the keyboard to the markup
                keyboardMarkup.setKeyboard(keyboard);
                // Add it to the message
                message.setReplyMarkup(keyboardMarkup);
                try {
                    sendMessage(message); // Sending our message object to user
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (message_text.equals("Нет.")) {
               SendMessage msg = new SendMessage()
                        .setChatId(chat_id)
                        .setText("Проветри блять!");
                ReplyKeyboardRemove keyboardMarkup1 = new ReplyKeyboardRemove();
                msg.setReplyMarkup(keyboardMarkup1);
                try {
                    sendMessage(msg); // Call method to send the photo
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (message_text.equals("Да.")) {
                SendMessage msg = new SendMessage()
                        .setChatId(chat_id)
                        .setText("Продуктивной работы!");
                ReplyKeyboardRemove keyboardMarkup1 = new ReplyKeyboardRemove();
                msg.setReplyMarkup(keyboardMarkup1);
                try {
                    sendMessage(msg); // Call method to send the photo
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (message_text.equals("/hide")) {
                SendMessage msg = new SendMessage()
                        .setChatId(chat_id)
                        .setText("Keyboard hidden");
                ReplyKeyboardRemove keyboardMarkup1 = new ReplyKeyboardRemove();
                msg.setReplyMarkup(keyboardMarkup1);
                try {
                    sendMessage(msg); // Call method to send the photo
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else {
                SendMessage msg  = new SendMessage() // Create a message object object
                        .setChatId(chat_id)
                        .setText("Unknown command");
                try {
                    sendMessage(msg); // Sending our message object to user
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public String getBotUsername() {
        // Return bot username
        // If bot username is @MyAmazingBot, it must return 'MyAmazingBot'
        return "aeration_bot";
    }

    @Override
    public String getBotToken() {
        // Return bot token from BotFather
        return "519139287:AAGqtGyPEWRlh92RknKecX7VfUbYnwvssVI";
    }
}
