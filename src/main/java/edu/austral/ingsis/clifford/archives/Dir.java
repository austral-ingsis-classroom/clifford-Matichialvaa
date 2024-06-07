package edu.austral.ingsis.clifford.archives;

import java.util.Map;

public class Dir implements Archive{
    String name;
    Dir parent;
    Map<String, Archive> subArchives;

    public Dir(String dirName, Dir currentDir) {
        this.name = dirName;
        this.parent = currentDir;
        this.subArchives = new java.util.LinkedHashMap<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Dir getParent() {
        return parent;
    }

    @Override
    public String getPath() {
        //recorro el arbol agarrando los nombres de los padres.
        if (parent == null || parent.getName().equals("/")) {
            return "/" + name;
        }
        return parent.getPath() + "/" + name;
    }

   public Map<String, Archive> getSubArchives() {
        return subArchives;
   }

   public void addSubArchive(Archive archive){
        subArchives.put(archive.getName(), archive);
   }

    public void removeSubArchive(String name) {
        subArchives.remove(name);
    }

    public Archive getSubArchive(String name) {
        return subArchives.get(name);
    }



}
