package edu.austral.ingsis.clifford.commandbuilder;

import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.commands.Command;
import edu.austral.ingsis.clifford.commands.Ls;

public class LsCommandBuilder implements CommandBuilder{
    @Override
    public Command buildCommand(FileSystem fileSystem, String[] options) {

        for (String option : options) {
            if (option.startsWith("--ord=")) {
                String orden = option.substring(6);
                return new Ls(fileSystem, orden);
            }
        }
        return new Ls(fileSystem, null);
    }
}
