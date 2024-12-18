package day11_29;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "day11_29.Person{" +
                "name: " + name.toUpperCase() + '\'' +
                ", age: " + age +
                '}';
    }
    public String isAdult() {
        if(getAge() < 18) {
            return (getName() + " is not an adult!");
        }
        else {
          return (getName() + " is an adult! ");
        }
    }

    public static void main(String[] args) {
        Person[] people = {
                new Person("John", 25),
                new Person("Alice", 15),
                new Person("Bob", 30)
        };
        for (Person person : people) {
            System.out.println(person);
            System.out.println(person.isAdult());
        }
    }
}
