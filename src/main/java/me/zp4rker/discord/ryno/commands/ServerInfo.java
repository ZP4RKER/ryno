package me.zp4rker.discord.ryno.commands;

import me.zp4rker.discord.core.command.Command;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.entities.User;

import java.util.stream.Collectors;

public class ServerInfo {

    @Command(aliases = {"serverinfo", "server", "sinfo"})
    public void onCommand(Message message) {
        Guild guild = message.getGuild();
        User user = guild.getOwner().getUser();

        String name = guild.getName();
        String owner = user.getName() + "#" + user.getDiscriminator();
        String region = guild.getRegionRaw();
        String id = guild.getId();

        int totalMembers = guild.getMembers().size();
        int bots = guild.getMembers().stream().filter(member -> member.getUser().isBot()).collect(Collectors.toList()).size();
        int users = totalMembers - bots;

        int categories = guild.getCategories().size();
        int textChannels = guild.getTextChannels().size();
        int voiceChannels = guild.getVoiceChannels().size();

        int roles = guild.getRoles().size();
        int emotes = guild.getEmotes().size();

        MessageEmbed embed = new EmbedBuilder()
                .setAuthor(name, null, guild.getIconUrl())
                .addField("Owner", owner, true).addField("Region", region, true).addBlankField(false)
                .addField("Members", "**Users:** " + users + "\n**Bots:** " + bots, true)
                .addField("Channels", "**Categories:** " + categories + "\n**Text:** " + textChannels + "\n**Voice:** " + voiceChannels, true)
                .addField("Roles", roles + "", true).addField("Emotes", emotes + "", true)
                .setFooter("ID: " + id, null).build();

        message.getChannel().sendMessage(embed).queue();

    }

}
