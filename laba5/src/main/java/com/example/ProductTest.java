package com.example;

import com.example.domain.*;
import com.example.domain.BookProduct;
import com.example.domain.ClothingProduct;
import com.example.domain.ElectronicsProduct;
import com.example.domain.FoodProduct;

public class ProductTest {
    public static void main(String[] args) {
        FoodProduct apple = new FoodProduct("Яблоко", 50.0, "2025-12-31");
        ElectronicsProduct phone = new ElectronicsProduct("Смартфон", 25000.0, 24);
        ClothingProduct shirt = new ClothingProduct("Рубашка", 1200.0, "L");
        BookProduct book = new BookProduct("Java для начинающих", 899.0, "Герберт Шилдт");

        apple.printInfo();
        phone.printInfo();
        shirt.printInfo();
        book.printInfo();
    }
}
