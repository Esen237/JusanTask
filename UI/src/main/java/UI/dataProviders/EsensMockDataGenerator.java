package UI.dataProviders;

import com.github.javafaker.Faker;

public class EsensMockDataGenerator {
    Faker faker = new Faker();

    public String nameGenerator() {
        return faker.name().username();
    }

    public String lastNameGenerator() {
        return faker.name().lastName();
    }

    public String firstNameGenerator() {
        return faker.name().firstName();
    }

    public String emailGenerator() {
        return faker.internet().emailAddress();
    }

    public long numberGenerate() {
        return faker.number().randomNumber(10, false);
    }

    public int GenerateNumberFrom1To33() {
        return faker.number().numberBetween(1, 33);
    }

    public int GenerateNumberFrom1To12() {
        return faker.number().numberBetween(1, 12);
    }

    public String textGenerate() {
        return faker.harryPotter().character();
    }

    public int GenerateNumberFrom1To3() {
        return faker.number().numberBetween(1, 3);
    }
}
