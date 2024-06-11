package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.archives.Dir;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ls implements Command {
  FileSystem fileSystem;
  String option;

  public Ls(FileSystem fileSystem, String option) {
    this.fileSystem = fileSystem;
    this.option = option;
  }

  @Override
  public String execute() {
    Dir dir = fileSystem.currentDir();

    List<String> elements = new ArrayList<>(dir.getSubArchives().keySet());

    if ("asc".equals(option)) {
      Collections.sort(elements);
    } else if ("desc".equals(option)) {
      elements.sort(Collections.reverseOrder());
    }

    String result = "";
    for (String element : elements) {
      result += element + " ";
    }

    if (!result.isEmpty()) {
      result = result.substring(0, result.length() - 1);
    }

    return result;
  }
}
