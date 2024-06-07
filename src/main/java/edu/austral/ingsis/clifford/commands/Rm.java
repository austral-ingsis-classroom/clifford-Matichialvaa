package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.archives.Archive;
import edu.austral.ingsis.clifford.archives.Dir;

public class Rm implements Command{
    final String name;
    final boolean recursive;
    FileSystem fileSystem;

    public Rm(FileSystem fileSystem, String name, boolean recursive) {
        this.name = name;
        this.recursive = recursive;
        this.fileSystem = fileSystem;
    }
    @Override
    public String execute() {
        Dir currentDir = fileSystem.currentDir();
        Archive archive = currentDir.getSubArchive(name);

        if (archive == null) {
            return "No existe";
        } else if (archive instanceof Dir) {
            if (recursive) {
                currentDir.removeSubArchive(name);
                return "'" + name + "' removed";
            } else {
                return "No se puede eliminar un directorio sin la opcion --recursive";
            }
        } else {
            currentDir.removeSubArchive(name);
            return "'" + name + "' removed";
        }
    }
}
