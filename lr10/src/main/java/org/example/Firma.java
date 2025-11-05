package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Firma {
    private String name;
    private List<Otdel> otdely = new ArrayList<>();

    public Firma(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addOtdel(Otdel o) {
        otdely.add(o);
    }

    public List<Otdel> getOtdely() {
        return Collections.unmodifiableList(otdely);
    }
}
