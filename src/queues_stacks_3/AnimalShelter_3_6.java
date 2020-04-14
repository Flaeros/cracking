package queues_stacks_3;

import java.util.LinkedList;
import java.util.Objects;

public class AnimalShelter_3_6 {

    public static void main(String[] args) {
        AnimalShelter_3_6 q = new AnimalShelter_3_6();
        q.enqueue(new Dog("a"));
        q.enqueue(new Cat("b"));
        q.enqueue(new Dog("c"));
        q.enqueue(new Cat("d"));
        q.enqueue(new Dog("e"));
        q.enqueue(new Dog("f"));
        q.enqueue(new Cat("g"));

        System.out.println("q.dequeueDog() = " + q.dequeueDog().id);
        System.out.println("q.dequeueDog() = " + q.dequeueDog().id);
        System.out.println("q.dequeueAny() = " + q.dequeueAny().id);
        System.out.println("q.dequeueDog() = " + q.dequeueDog().id);
        System.out.println("q.dequeueCat() = " + q.dequeueCat().id);
    }

    LinkedList<Cat> cats = new LinkedList<>();
    LinkedList<Dog> dogs = new LinkedList<>();
    LinkedList<Animal> animals = new LinkedList<>();

    public void enqueue(Animal a) {
        animals.addLast(a);

        if (a instanceof Dog)
            dogs.addLast((Dog) a);
        if (a instanceof Cat)
            cats.addLast((Cat) a);
    }

    public Animal dequeueAny() {
        Animal first = animals.getFirst();
        if (first instanceof Cat)
            cats.removeFirst();
        if (first instanceof Dog)
            dogs.removeFirst();
        return first;
    }

    public Dog dequeueDog() {
        Dog dog = dogs.removeFirst();
        animals.remove(dog);
        return dog;
    }

    public Cat dequeueCat() {
        Cat cat = cats.removeFirst();
        animals.remove(cat);
        return cat;
    }

    static class Animal {
        public String id;

        public Animal(String id) {
            this.id = id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Animal animal = (Animal) o;
            return Objects.equals(id, animal.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }

    static class Cat extends Animal {
        public Cat(String id) {
            super(id);
        }
    }

    static class Dog extends Animal {
        public Dog(String id) {
            super(id);
        }
    }
}
