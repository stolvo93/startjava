public class WolfTest {
    public static void main(String[] args) {
        Wolf myPetWolf = new Wolf();
        myPetWolf.setSex("самец");
        myPetWolf.setNickname("Локи");
        myPetWolf.setWeight(10.1f);
        myPetWolf.setAge(5);
        myPetWolf.setColor("равномерно серый");

        System.out.println("Пол: " + myPetWolf.getSex());
        System.out.println("Кличка: " + myPetWolf.getNickname());
        System.out.println("Вес: " + myPetWolf.getWeight() + " кг");
        System.out.println("Возраст: " + myPetWolf.getAge());
        System.out.println("Окрас: " + myPetWolf.getColor());
    }
}