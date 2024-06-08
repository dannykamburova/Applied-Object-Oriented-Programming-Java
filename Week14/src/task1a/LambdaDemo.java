package task1a;


import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LambdaDemo
{
    public static void main(String[] args)
    {
        Predicate<Salesperson> predicate1 = salesperson -> salesperson.getNumSales() > 1200;
// да се инициализира
        Predicate<Salesperson> predicate2 = salesperson -> salesperson.getSalary() > 900;
// да се инициализира
        Predicate<Salesperson> predicate = salesperson -> predicate1.test(salesperson) || predicate2.test(salesperson);
       //Predicate<Salesperson> predicate = salesperson -> predicate1.or(predicate2).test(salesperson);
// да се инициализира
        Consumer<Salesperson> consumer1 = salesperson -> {
            salesperson.addBonus(salesperson.getSalary() * 0.05);
            System.out.println(salesperson);
        };
// да се инициализира
        Consumer<Salesperson> consumer2 = salesperson -> {
            if(predicate1.test(salesperson)) {
                salesperson.addBonus(salesperson.getSalary() * 0.02);
            }else {
                salesperson.addBonus(salesperson.getSalary() * -0.02);
            }
            System.out.println(salesperson);
        };
// да се инициализира
        Comparator<Salesperson> comparator1 = (salesperson1, salesperson2) ->
                Double.compare(salesperson2.getSalary(), salesperson1.getSalary());
// да се инициализира
       // Comparator<Salesperson> comparator2 = (salesperson1, salesperson2) -> {
            //int resultFromSalary = comparator1.compare(salesperson1, salesperson2);
            //if(resultFromSalary == 0) {
            //    return salesperson1.getNumSales() - salesperson2.getNumSales();
            //}
            //return resultFromSalary;
       // };

        Comparator<Salesperson> comparator2 = Comparator.comparing((Salesperson salesperson) -> salesperson.getSalary())
                .reversed().thenComparing(salesperson -> salesperson.getNumSales());

// да се инициализира

        Salesperson[] salespersons =
                {
                        new Salesperson("John Doe", 2000, 949),
                        new Salesperson("Jane Doe", 5900, 2500),
                        new Salesperson("Bob Doe 1", 1000, 1949),
                        new Salesperson("Jane Doe 1", 2900, 1500),
                        new Salesperson("John Doe 2", 4000, 1949),
                        new Salesperson("Jane Doe 2", 3900, 1500),
                        new Salesperson("John Doe 3", 6000, 4949),
                        new Salesperson("Jane Doe 3", 1900, 3500),
                        new Salesperson("John Doe 4", 3000, 2949),
                        new Salesperson("Jane Doe 4", 1900, 4500),
                        // да се добавят  още 10 обекти от тип Salesperson
                        // или да се инициализират с Random стойности

                };
        List<Salesperson> listOfSalespersons = new
                ArrayList<>();
        // обектите на salespersons да се запишат в listOfSalespersons
        for (Salesperson salesperson: salespersons)
        {
            applyBonus(salesperson, predicate1, consumer1);
            System.out.println(salesperson);
            salesperson.printNumSales(salesperson);
            listOfSalespersons.add(salesperson);
        }
        for (Salesperson salesperson: salespersons)
        {
            applyBonus(salesperson, predicate2,  consumer2);
            System.out.println(salesperson);
        }
        sort(listOfSalespersons, comparator1);
        System.out.println(listOfSalespersons);
        sort(listOfSalespersons, comparator2);
        System.out.println(listOfSalespersons);

        System.out.println("Groups: ");
        group(listOfSalespersons);
    }
    public static void applyBonus(Salesperson salesperson, Predicate<Salesperson> predicate, Consumer<Salesperson> consumer) {
            if (salesperson == null || predicate == null || consumer == null) {
                return;
            }
// Напишете if  команда, където използвайте predicate
// за да определите дали да изпълните consumer
// Изпълнете consumer, когато условието на if  командата е изпълнено
    }
    public static void applyBonus(List<Salesperson> salespersons, Predicate<Salesperson> predicate,Consumer<Salesperson> consumer) {
    for (Salesperson salesperson : salespersons) {
        if(predicate.test(salesperson)) {
            consumer.accept(salesperson);
        }
    }
// Напишете if  команда, където използвайте predicate
// за да определите дали да изпълните consumer
// Изпълнете consumer, когато условието на if  командата е изпълнено
    }
    public static void sort(List<Salesperson> salespersons, Comparator<Salesperson> comparator)
    {
        if(salespersons == null || comparator == null) {
            return;
        }
// Сортирайте  salespersons като използвате  comparator
        //Collections.sort(salespersons, comparator);
        salespersons.sort(comparator);
    }
    public static void group(List<Salesperson> salespersons)
    {
        if(salespersons == null) {
            return;
        }
// Групирайте имената на salespersons по първата буква в
//  името изведете отделните групи на стандартен изход
        Map<Character, List<String>> groups = new HashMap<>();

        for(Salesperson salesperson : salespersons) {
            Character firstLetter = salesperson.getName().charAt(0);

//            if(!groups.containsKey(firstLetter)) {
//                List<String> list = new ArrayList<>();
//                groups.put(firstLetter, list);
//            }
            groups.putIfAbsent(firstLetter, new ArrayList<>());

            groups.get(firstLetter).add(salesperson.getName());
        }

        for(Character group : groups.keySet()) {
            System.out.printf("%c => %s%n", group, groups.get(group));
        }
    }
}
