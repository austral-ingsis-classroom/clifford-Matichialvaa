package edu.austral.ingsis;

import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.MyFileSystem;
import edu.austral.ingsis.clifford.commands.CommandFactory;
import java.util.ArrayList;
import java.util.List;

public class MyFileSystemRunner implements FileSystemRunner {
  @Override
  public List<String> executeCommands(List<String> commands) {
    // abstraer a un factory -> getNormalCommandsMap.
    FileSystem fileSystem = new MyFileSystem(CommandFactory.getBasicCommandsMap());

    List<String> messages = new ArrayList<>();
    for (String command : commands) {
      String message = fileSystem.runCommand(command);
      messages.add(message);
    }

    return messages;
  }
}
