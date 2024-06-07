package edu.austral.ingsis.clifford.commandbuilder;

import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.commands.Cd;
import edu.austral.ingsis.clifford.commands.Command;

public class CdCommandBuilder implements CommandBuilder {
  @Override
  public Command buildCommand(FileSystem fileSystem, String[] options) {
    return new Cd(fileSystem, options[0]);
  }
}
