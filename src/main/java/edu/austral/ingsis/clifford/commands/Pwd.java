package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.archives.Dir;

public class Pwd implements Command{
    FileSystem fileSystem;
    public Pwd(FileSystem fileSystem) {
        this.fileSystem = fileSystem;
    }

    @Override
    public String execute() {
        Dir currentDir = fileSystem.currentDir();
        return currentDir.getPath();
    }
}
