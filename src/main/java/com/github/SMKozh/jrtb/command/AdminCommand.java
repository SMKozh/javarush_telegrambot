package com.github.SMKozh.jrtb.command;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/*
* Mark if {@link Command} can be viewed only by admins.
* */
@Retention(RetentionPolicy.RUNTIME)
public @interface AdminCommand {
}
