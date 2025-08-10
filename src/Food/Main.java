public class Main{
    public static void main(String[] args) {
        // Declare variables
        Meat meat = new Meat(
                "Picanha", 60., LocalDate.parse("2025-10-10"), 12., 8
        );

        Vegetable vegetable = new Vegetable(
                "Potato", 5., LocalDate.parse("2025-8-24"), "Starchy", false
        );

        // Print variables
        System.out.println("-----------Print variables-----------");
        System.out.println(meat);
        System.out.println(vegetable);

        // Check Methods
        System.out.println("-----------Check Methods-----------");
        System.out.println(meat.calcPrice());
        System.out.println(vegetable.calcPrice());

        meat.cutMeat(10);
        vegetable.peel();

        System.out.println(meat.calcPrice());
        System.out.println(vegetable.calcPrice());

        System.out.println("-----------Print variables-----------");
        System.out.println(meat);
        System.out.println(vegetable);
    }
}