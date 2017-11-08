package me.zp4rker.discord.core.command;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author ZP4RKER
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Command {

    String[] aliases();

    String description() default "";

    String usage() default "";

    boolean directMessages() default false;

    boolean channelMessages() default true;

    boolean allowSelf() default false;

    boolean allowOthers() default true;

    boolean showInHelp() default true;

}
