package edu.austral.ingsis.clifford;

import edu.austral.ingsis.clifford.archives.Dir;

public interface FileSystem {

  String runCommand(String command);

  Dir currentDir();

  void setCurrentDir(Dir dir);

  Dir getRootDirectory();
}
