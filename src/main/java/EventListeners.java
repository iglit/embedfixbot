import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;


public class EventListeners extends ListenerAdapter {


    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        String messageSent = event.getMessage().getContentRaw();

        if (messageSent.toLowerCase().contains("https://twitter.com") && !event.getAuthor().isBot()) {
            int linkStart = messageSent.indexOf("https://twitter.com");
            event.getMessage().suppressEmbeds(true).queue();
            if(messageSent.substring(linkStart).contains(" ")) {
                event.getChannel().sendMessage(messageSent.substring(linkStart, linkStart + 8) + "fx" + messageSent.substring(linkStart + 8, messageSent.indexOf(" ", linkStart + 8))).queue();
            }
            else{
                event.getChannel().sendMessage(messageSent.substring(linkStart, linkStart + 8) + "fx" + messageSent.substring(linkStart + 8)).queue();
            }
        }else if(messageSent.contains("https://fxtwitter.com") && !event.getAuthor().isBot()){
            event.getMessage().suppressEmbeds(false).queue();
        }


    }
}

