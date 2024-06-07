package edu.austral.ingsis.clifford.archives;

import java.util.Map;

public class File implements Archive{
    String name;
    Dir parent;

    public File(String name, Dir parent) {
        this.name = name;
        this.parent = parent;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPath() {
        if (parent == null) {
            return "/" + name;
        }
        return parent.getPath() + "/" + name;
    }

    @Override
    public Dir getParent() {
        return parent;
    }
}
