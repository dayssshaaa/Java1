package org.example;

public class LabEnterprise {
    public static Sotrudnik createSotrudnikSafely(String type, String fio, String dol, double oklad, double extra1, int extra2) throws OkladException {
        try {
            if ("shtat".equals(type)) {
                return new ShtatnySotrudnik(fio, dol, oklad, extra1);
            } else if ("kontr".equals(type)) {
                return new SotrudnikPoKontraktu(fio, dol, oklad, extra2, extra1);
            } else {
                throw new IllegalArgumentException("Unknown type: " + type);
            }
        } catch (IllegalArgumentException iae) {
            // Выводим только сообщение, стек-трейс не печатаем
            System.out.println(iae.getMessage());
            return null;
        } catch (OkladException oe) {
            System.out.println("Невозможно создать сотрудника – указан отрицательный оклад: " + oklad);
            throw oe;
        }
    }

    public static void main(String[] args) {
        Firma f = new Firma("");
        Otdel o1 = new Otdel("Отдел продаж", 5);
        f.addOtdel(o1);

        try {
            Sotrudnik s1 = createSotrudnikSafely("shtat", "Иванов Иван", "Менеджер", -3000, 500, 0);
            if (s1 != null) {
                o1.addStaff(s1);
                s1.rasschitatZarplatu();
            }
        } catch (OkladException e) {
            System.out.println("Главный обработчик: не создан сотрудник: " + e.getMessage());
        }

        try {
            Sotrudnik s2 = createSotrudnikSafely("shtat", "Петров Петр", "Бухгалтер", 3500, -200, 0);
            if (s2 != null) {
                o1.addStaff(s2);
                s2.rasschitatZarplatu();
            }
        } catch (OkladException e) {
            System.out.println("Главный обработчик: не создан сотрудник: " + e.getMessage());
        }

        try {
            Sotrudnik s3 = createSotrudnikSafely("kontr", "Сидоров Сидр", "Разработчик", 0, 1000, 10);
            if (s3 != null) {
                o1.addStaff(s3);
                s3.rasschitatZarplatu();
            }
        } catch (OkladException e) {
            System.out.println("Главный обработчик: не создан сотрудник: " + e.getMessage());
        }

        try {
            Sotrudnik bad = createSotrudnikSafely("shtat", "Негатив Н.Н.", "Тест", -1000, 100, 0);
            if (bad != null) {
                o1.addStaff(bad);
            }
        } catch (OkladException e) {
            System.err.println("MAIN: обработано OkladException: " + e.getMessage());
        }

        Sotrudnik wrong = null;
        try {
            wrong = createSotrudnikSafely("unknownType", "Кто То", "Тест", 1000, 0, 0);
        } catch (OkladException e) {
            System.err.println("Главный обработчик: не создан сотрудник: " + e.getMessage());
        }
        if (wrong != null) {
            o1.addStaff(wrong);
        }

        System.out.println("\nСотрудники отдела \"" + o1.getName() + "\":");
        for (Sotrudnik s : o1.getStaff()) {
            System.out.println("- " + s.getFio() + ", должность: " + s.getDolzhnost() + ", оклад: " + s.getOklad());
        }
    }
}
