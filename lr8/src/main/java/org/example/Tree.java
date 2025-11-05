package org.example;

class Tree implements Plant, Int {
    private final String name;

    public Tree(String name) {
        this.name = name;
    }

    @Override
    public  void grow() {
        System.out.println(name + " растёт медленно, но уверенно — становится деревом.");
    }
}
