package edu.austral.ingsis.clifford;

import edu.austral.ingsis.clifford.archives.Dir;
import edu.austral.ingsis.clifford.commandbuilder.CommandBuilder;
import edu.austral.ingsis.clifford.commands.Command;

import java.util.Arrays;
import java.util.Map;

public class MyFileSystem implements FileSystem{
    private final Map<String, CommandBuilder> commandBuilders;
    private final Dir root;
    private Dir currentDirectory;

    public MyFileSystem(Map<String, CommandBuilder> commandBuilders) {
        this.root = new Dir("/", null);
        this.currentDirectory = root;
        this.commandBuilders = commandBuilders;
    }

    @Override
    public String runCommand(String command) {
        Command executable = findExecutable(command);

        //ejecuto el comando, donde ya en command va a estar modificado con las opciones dadas un string dentro del command.
        return executable.execute();
    }

    @Override
    public Dir currentDir() {
        return currentDirectory;
    }

    public void setCurrentDir(Dir currentDirectory) {
        this.currentDirectory = currentDirectory;
    }

    @Override
    public Dir getRootDirectory() {
        return root;
    }

    private Command findExecutable(String completeCommand) {
        String[] components = completeCommand.split(" ");
        String executable = components[0];

        //copio components sin el executable.
        String[] options = Arrays.copyOfRange(components, 1, components.length);

        //agarro el builder adecuado
        CommandBuilder builder = commandBuilders.get(executable);

        //creo el comando a partir de las opciones dadas.
        return builder.buildCommand(this, options);
    }
}
