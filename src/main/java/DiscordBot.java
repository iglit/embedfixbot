import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class DiscordBot {
    public static void main(String[] args) {
        Config config = new Config();
        JDA bot = JDABuilder.createDefault(config.token)
                .enableIntents(GatewayIntent.GUILD_MESSAGES,GatewayIntent.MESSAGE_CONTENT,GatewayIntent.GUILD_MEMBERS,GatewayIntent.DIRECT_MESSAGES)
                .setActivity(Activity.watching("Twitter"))
                .addEventListeners(new EventListeners())
                .build();
    }

}
