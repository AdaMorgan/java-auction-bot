package core;

import core.command.GuildManager;
import core.config.Config;
import core.message.MessageEditor;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.MemberCachePolicy;

import java.sql.SQLException;
import java.util.Arrays;

public final class Application {
    public static void main(String[] args) {
        JDABuilder.create(Config.getToken(), Arrays.asList(INTENTS))
                .setActivity(Activity.playing("server"))
                .setStatus(OnlineStatus.ONLINE)
                .setMemberCachePolicy(MemberCachePolicy.NONE)

                .addEventListeners(new GuildManager())
                .addEventListeners(new MessageEditor())
                .build();
    }

    private static final GatewayIntent[] INTENTS = {
            GatewayIntent.MESSAGE_CONTENT,
            GatewayIntent.DIRECT_MESSAGES,
            GatewayIntent.GUILD_MESSAGES,
            GatewayIntent.GUILD_MEMBERS,
            GatewayIntent.GUILD_MESSAGE_REACTIONS,
            GatewayIntent.GUILD_PRESENCES
    };
}