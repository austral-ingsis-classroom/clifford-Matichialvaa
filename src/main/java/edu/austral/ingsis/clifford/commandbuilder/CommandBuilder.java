package edu.austral.ingsis.clifford.commandbuilder;

import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.commands.Command;

public interface CommandBuilder {
  Command buildCommand(FileSystem fileSystem, String[] options);
}
