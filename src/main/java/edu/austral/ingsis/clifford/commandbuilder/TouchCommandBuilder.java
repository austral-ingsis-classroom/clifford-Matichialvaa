package edu.austral.ingsis.clifford.commandbuilder;

import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.commands.Command;
import edu.austral.ingsis.clifford.commands.Touch;

public class TouchCommandBuilder implements CommandBuilder {
  @Override
  public Command buildCommand(FileSystem fileSystem, String[] options) {
    return new Touch(fileSystem, options[0]);
  }
}
