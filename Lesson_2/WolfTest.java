public class WolfTest {
    public static void main(String[] args) {
        Wolf myPetWolf = new Wolf();
        myPetWolf.sex = "самец";
        myPetWolf.nickname = "Локи";
        myPetWolf.weight = 10.1f;
        myPetWolf.color = "равномерно серый";

        System.out.println("Пол: " + myPetWolf.sex);
        System.out.println("Кличка: " + myPetWolf.nickname);
        System.out.println("Вес: " + myPetWolf.weight + " кг");
        System.out.println("Окрас: " + myPetWolf.color);

        myPetWolf.walk();
        myPetWolf.sit();
        myPetWolf.run();
        myPetWolf.howl();
        myPetWolf.hunt();
    }
}