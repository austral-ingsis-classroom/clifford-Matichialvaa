package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.archives.Dir;

public class MkDir implements Command{
    FileSystem fileSystem;
    String dirName;

    public MkDir(FileSystem fileSystem, String dirName){
        this.fileSystem = fileSystem;
        this.dirName = dirName;
    }
    @Override
    public String execute() {
        if (dirName.contains("/") || dirName.contains(" ") || dirName.isEmpty()){
            return "error nombre invalido";
        }

        Dir currentDir = fileSystem.currentDir();
        Dir newDir = new Dir(dirName, currentDir);
        currentDir.addSubArchive(newDir);
        return "'" + dirName + "' file created";
    }
}
