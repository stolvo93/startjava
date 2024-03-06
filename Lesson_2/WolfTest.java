public class WolfTest {
    
    public static void main(String[] args) {
        Wolf steppeWolf = new Wolf();
        steppeWolf.sex = "Male";
        steppeWolf.name = "Harry";
        steppeWolf.weight = 38.5f;
        steppeWolf.age = 4;
        steppeWolf.coatColor = "Pale Grey";

        System.out.println("Имя волка: " + steppeWolf.name);
        System.out.println("Пол: " + steppeWolf.sex);
        System.out.println("Вес: " + steppeWolf.weight + " кг");
        System.out.println("Возраст: " + steppeWolf.age);
        System.out.println("Окрас: " + steppeWolf.coatColor + "\n");

        System.out.println("Поведение волка:");
        steppeWolf.sit();
        steppeWolf.walk();
        steppeWolf.run();
        steppeWolf.hunt();
        steppeWolf.howl();
    }
}