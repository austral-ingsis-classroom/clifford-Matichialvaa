package edu.austral.ingsis.clifford.commandbuilder;

import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.archives.Dir;
import edu.austral.ingsis.clifford.commands.Command;
import edu.austral.ingsis.clifford.commands.Rm;
import java.util.ArrayList;
import java.util.List;

public class RmCommandBuilder implements CommandBuilder {
  @Override
  public Command buildCommand(FileSystem fileSystem, String[] options) {
    boolean recursive = false;
    String name = null;

    // si no pasa parametro, agarro el primero del ls. (si hay)
    Dir currentDir = fileSystem.currentDir();
    List<String> keys = new ArrayList<>(currentDir.getSubArchives().keySet());
    if (!keys.isEmpty()) {
      name = keys.get(0);
    }

    for (String option : options) {
      if ("--recursive".equals(option)) {
        recursive = true;
      } else {
        name = option;
        break;
      }
    }
    return new Rm(fileSystem, name, recursive);
  }
}
