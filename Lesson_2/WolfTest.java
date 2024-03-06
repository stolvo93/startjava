public class WolfTest {
    
    public static void main(String[] args) {
        Wolf steppeWolf = new Wolf();
        steppeWolf.setSex("Male");
        steppeWolf.setName("Harry");
        steppeWolf.setWeight(38.5f);
        steppeWolf.setAge(10);
        steppeWolf.setColor("Pale Grey");

        System.out.println("Имя волка: " + steppeWolf.getName());
        System.out.println("Пол: " + steppeWolf.getSex());
        System.out.println("Вес: " + steppeWolf.getWeight() + " кг");
        System.out.println("Возраст: " + steppeWolf.getAge());
        System.out.println("Окрас: " + steppeWolf.getColor() + "\n");

        System.out.println("Поведение волка:");
        steppeWolf.sit();
        steppeWolf.walk();
        steppeWolf.run();
        steppeWolf.hunt();
        steppeWolf.howl();
    }
}