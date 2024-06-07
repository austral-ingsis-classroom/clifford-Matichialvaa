package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.archives.Archive;
import edu.austral.ingsis.clifford.archives.Dir;

public class Cd implements Command{
    FileSystem fileSystem;
    String option;
    public Cd(FileSystem fileSystem, String option) {
        this.fileSystem = fileSystem;
        this.option = option;
    }

    @Override
    public String execute() {
        Dir currentDir = fileSystem.currentDir();
        if (option.equals("..")) {
            fileSystem.setCurrentDir(currentDir.getParent());
        } else {
            Archive archive = currentDir.getSubArchive(option);
            if (archive instanceof Dir) {
                fileSystem.setCurrentDir((Dir) archive);
            } else {
                return "error, no hay archivo con ese nombre en el directorio actual";
            }
        }
        return "Moved to directory: '" + fileSystem.currentDir().getName() + "'";
    }
}
