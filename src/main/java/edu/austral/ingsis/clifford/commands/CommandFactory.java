package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.commandbuilder.*;
import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
  public static Map<String, CommandBuilder> getBasicCommandsMap() {
    Map<String, CommandBuilder> commandBuilders = new HashMap<>();
    commandBuilders.put("ls", new LsCommandBuilder());
    commandBuilders.put("cd", new CdCommandBuilder());
    commandBuilders.put("touch", new TouchCommandBuilder());
    commandBuilders.put("mkdir", new MkdirCommandBuilder());
    commandBuilders.put("rm", new RmCommandBuilder());
    commandBuilders.put("pwd", new PwdCommandBuilder());

    return commandBuilders;
  }
}
