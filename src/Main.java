import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.Timer;

public class Main {
    public static void main(String[] args) {
        // Initialize Api Context
        ApiContextInitializer.init();

        // Instantiate Telegram Bots API
        TelegramBotsApi botsApi = new TelegramBotsApi();
        Timer time = new Timer();
        Scheduler sch = new Scheduler();
        time.schedule(sch, 0 , 200);
        // Register our bot
        try {
            botsApi.registerBot(new MyBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
