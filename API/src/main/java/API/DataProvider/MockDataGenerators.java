package API.DataProvider;
import com.github.javafaker.Faker;

public class MockDataGenerators {
    Faker faker = new Faker();

    public String nameGenerator() {
        return faker.name().username();
    }

    public String jobGenerator(){
        return faker.job().field();
    }

    public String mailGenerator(){
        return faker.internet().emailAddress();
    }


    public String passwordGenerator(){
        return faker.gameOfThrones().character();
    }
}
