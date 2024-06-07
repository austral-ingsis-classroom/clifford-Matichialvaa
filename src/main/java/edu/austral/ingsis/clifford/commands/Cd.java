package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.archives.Archive;
import edu.austral.ingsis.clifford.archives.Dir;

public class Cd implements Command {
  FileSystem fileSystem;
  String path;

  public Cd(FileSystem fileSystem, String path) {
    this.fileSystem = fileSystem;
    this.path = path;
  }

  @Override
  public String execute() {
    Dir currentDir = fileSystem.currentDir();
    String[] pathComponents = path.split("/");

    if (path.equals("/") || (path.equals("..") && currentDir.getParent() == null)) {
      fileSystem.setCurrentDir(fileSystem.getRootDirectory());
      return "moved to directory '/'";
    }

    for (String component : pathComponents) {
      if (path.equals("..")) {
        currentDir = currentDir.getParent();
      } else if (!component.isEmpty() && !component.equals(".")) {
        Archive archive = currentDir.getSubArchive(component);
        if (archive instanceof Dir) {
          currentDir = (Dir) archive;
        } else {
          return "'" + path + "' directory does not exist";
        }
      }
    }

    fileSystem.setCurrentDir(currentDir);
    return "moved to directory '" + currentDir.getName() + "'";
  }
}
