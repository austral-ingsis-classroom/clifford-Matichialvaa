package edu.austral.ingsis.clifford.commandbuilder;

import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.commands.Command;
import edu.austral.ingsis.clifford.commands.MkDir;

public class MkdirCommandBuilder implements CommandBuilder {
  @Override
  public Command buildCommand(FileSystem fileSystem, String[] options) {
    return new MkDir(fileSystem, options[0]);
  }
}
