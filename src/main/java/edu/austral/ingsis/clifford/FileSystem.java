package edu.austral.ingsis.clifford;

import edu.austral.ingsis.clifford.archives.Dir;
import edu.austral.ingsis.clifford.commands.Command;

public interface FileSystem {

    String runCommand(String command);
    Dir currentDir();
    void setCurrentDir(Dir dir);
    Dir getRootDirectory();
}
