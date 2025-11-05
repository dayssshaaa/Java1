package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Otdel {
    private String name;
    private int kolVoSotrudnikov;
    private List<Sotrudnik> staff = new ArrayList<>();

    public Otdel(String name, int kolVoSotrudnikov) {
        this.name = name;
        this.kolVoSotrudnikov = kolVoSotrudnikov;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKolVoSotrudnikov() {
        return kolVoSotrudnikov;
    }

    public void setKolVoSotrudnikov(int k) {
        kolVoSotrudnikov = k;
    }

    public void addStaff(Sotrudnik s) {
        staff.add(s);
    }

    public List<Sotrudnik> getStaff() {
        return Collections.unmodifiableList(staff);
    }
}
