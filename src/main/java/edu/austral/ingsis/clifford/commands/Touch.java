package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.archives.Archive;
import edu.austral.ingsis.clifford.archives.Dir;
import edu.austral.ingsis.clifford.archives.File;

public class Touch implements Command {
  FileSystem fileSystem;
  String fileName;

  public Touch(FileSystem fileSystem, String fileName) {
    this.fileSystem = fileSystem;
    this.fileName = fileName;
  }

  @Override
  public String execute() {
    Dir currentDir = fileSystem.currentDir();
    if (fileName.contains("/") || fileName.contains(" ")) {
      return "error nombre invalido";
    }

    // Eliminar el archivo existente si ya existe
    Archive existingFile = currentDir.getSubArchive(fileName);
    if (existingFile instanceof File) {
      currentDir.removeSubArchive(fileName);
    }

    File file = new File(fileName, fileSystem.currentDir());
    currentDir.addSubArchive(file);
    return "'" + fileName + "' file created";
  }
}
