package edu.austral.ingsis.clifford.commandbuilder;

import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.commands.Command;
import edu.austral.ingsis.clifford.commands.Rm;

public class RmCommandBuilder implements CommandBuilder{
    @Override
    public Command buildCommand(FileSystem fileSystem, String[] options) {
        boolean recursive = false;
        String name = null;

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
