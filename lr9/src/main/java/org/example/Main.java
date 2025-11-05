import org.example.SportEquipment;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;

class Football extends SportEquipment {
    public Football(String brand) {
        super(brand);
    }

    @Override
    public String toString() {
        return "Football{brand='" + getBrand() + "'}";
    }
}

class Basketball extends SportEquipment {
    public Basketball(String brand) {
        super(brand);
    }

    @Override
    public String toString() {
        return "Basketball{brand='" + getBrand() + "'}";
    }
}

public class Main {
    public static void main(String[] args) {
        // Создаём Map: ключ - название экипировки, значение - объект org.example.SportEquipment
        Map<String, SportEquipment> equipmentMap = new HashMap<>();

        // Добавляем элементы
        equipmentMap.put("football1", new Football("Nike"));
        equipmentMap.put("football2", new Football("Adidas"));
        equipmentMap.put("basketball1", new Basketball("Spalding"));

        // Получаем все ключи и выводим их
        Set<String> keys = equipmentMap.keySet();
        System.out.println("Keys in equipmentMap:");
        for (String key : keys) {
            System.out.println(key);
        }
    }
}
