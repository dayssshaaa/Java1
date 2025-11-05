package org.example;

public class Main {

    static class Fotografiya {
        private String name;

        public Fotografiya(String name) {
            this.name = name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    static class Stranitsa {
        private java.util.List<Fotografiya> photos = new java.util.ArrayList<>();

        public void addPhoto(Fotografiya photo) {
            photos.add(photo);
        }

        public int getPhotoCount() {
            return photos.size();
        }
    }

    static class Fotoalbom {
        private java.util.List<Stranitsa> pages = new java.util.ArrayList<>();
        private final int maxPerPage;

        public Fotoalbom() {
            this(10);
        }

        public Fotoalbom(int maxPerPage) {
            this.maxPerPage = Math.max(1, maxPerPage);
        }

        public void addPhoto(Fotografiya photo) {
            if (pages.isEmpty() || pages.get(pages.size() - 1).getPhotoCount() >= maxPerPage) {
                pages.add(new Stranitsa());
            }
            pages.get(pages.size() - 1).addPhoto(photo);
        }

        public int getTotalPhotos() {
            int total = 0;
            for (Stranitsa p : pages) total += p.getPhotoCount();
            return total;
        }

        public void printPhotoCount() {
            System.out.println("Количество фотографий в альбоме: " + getTotalPhotos());
        }
    }

    public static void main(String[] args) {
        Fotoalbom albom = new Fotoalbom(5);

        Fotografiya f1 = new Fotografiya("Отпуск 2024");
        Fotografiya f2 = new Fotografiya("День рождения");
        Fotografiya f3 = new Fotografiya("Закат");

        albom.addPhoto(f1);
        albom.addPhoto(f2);
        albom.addPhoto(f3);

        albom.printPhotoCount();
    }
}
