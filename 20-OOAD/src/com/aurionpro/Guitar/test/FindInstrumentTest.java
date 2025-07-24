package com.aurionpro.Guitar.test;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.aurionpro.Guitar.model.Builder;
import com.aurionpro.Guitar.model.Guitar;
import com.aurionpro.Guitar.model.GuitarSpec;
import com.aurionpro.Guitar.model.Instrument;
import com.aurionpro.Guitar.model.Inventory;
import com.aurionpro.Guitar.model.Mandolin;
import com.aurionpro.Guitar.model.MandolinSpec;
import com.aurionpro.Guitar.model.Style;
import com.aurionpro.Guitar.model.Type;
import com.aurionpro.Guitar.model.Wood;

public class FindInstrumentTest {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        initializeInventory(inventory);
        Scanner sc = new Scanner(System.in);

        System.out.println("🎸 Welcome to RICK'S Instrument Shop!");

        while (true) {
            System.out.println("\n1. Show All Guitars");
            System.out.println("2. Filter Guitars");
            System.out.println("3. Show All Mandolins");
            System.out.println("4. Filter Mandolins");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> showAllGuitars(inventory);
                case 2 -> {
                    GuitarSpec searchSpec = new GuitarSpec(
                            selectBuilder(sc),
                            inputModel(sc),
                            selectType(sc),
                            selectWood(sc, "Back"),
                            selectWood(sc, "Top"),
                            inputNumStrings(sc)
                    );
                    List<Instrument> results = filterGuitars(inventory, searchSpec);
                    printGuitars(results);
                }
                case 3 -> showAllMandolins(inventory);
                case 4 -> {
                    MandolinSpec searchSpec = new MandolinSpec(
                            selectBuilder(sc),
                            inputModel(sc),
                            selectType(sc),
                            selectWood(sc, "Back"),
                            selectWood(sc, "Top"),
                            selectStyle(sc)
                    );
                    List<Instrument> results = filterMandolins(inventory, searchSpec);
                    printMandolins(results);
                }
                case 5 -> {
                    System.out.println("Exiting. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void showAllGuitars(Inventory inventory) {
        System.out.println("\n🎸 Guitars Available:");
        inventory.getInstruments().stream()
            .filter(i -> i instanceof Guitar)
            .map(i -> (Guitar) i)
            .forEach(g -> {
                GuitarSpec spec = (GuitarSpec) g.getSpec();
                System.out.println(spec.getBuilder() + " " + spec.getModel() + " | " +
                        spec.getType() + " | " + spec.getNumStrings() + " strings | $" + g.getPrice());
            });
    }

    private static void showAllMandolins(Inventory inventory) {
        System.out.println("\n🎻 Mandolins Available:");
        inventory.getInstruments().stream()
            .filter(i -> i instanceof Mandolin)
            .map(i -> (Mandolin) i)
            .forEach(m -> {
                MandolinSpec spec = (MandolinSpec) m.getSpec();
                System.out.println(spec.getBuilder() + " " + spec.getModel() + " | " +
                        spec.getType() + " | Style: " + spec.getStyle() + " | $" + m.getPrice());
            });
    }

    private static List<Instrument> filterGuitars(Inventory inventory, GuitarSpec searchSpec) {
        return inventory.getInstruments().stream()
            .filter(i -> i instanceof Guitar)
            .filter(i -> {
                GuitarSpec spec = (GuitarSpec) i.getSpec();
                return (searchSpec.getBuilder() == null || spec.getBuilder() == searchSpec.getBuilder()) &&
                       (searchSpec.getModel() == null || spec.getModel().equalsIgnoreCase(searchSpec.getModel())) &&
                       (searchSpec.getType() == null || spec.getType() == searchSpec.getType()) &&
                       (searchSpec.getBackWood() == null || spec.getBackWood() == searchSpec.getBackWood()) &&
                       (searchSpec.getTopWood() == null || spec.getTopWood() == searchSpec.getTopWood()) &&
                       (searchSpec.getNumStrings() == 0 || spec.getNumStrings() == searchSpec.getNumStrings());
            })
            .collect(Collectors.toList());
    }

    private static List<Instrument> filterMandolins(Inventory inventory, MandolinSpec searchSpec) {
        return inventory.getInstruments().stream()
            .filter(i -> i instanceof Mandolin)
            .filter(i -> {
                MandolinSpec spec = (MandolinSpec) i.getSpec();
                return (searchSpec.getBuilder() == null || spec.getBuilder() == searchSpec.getBuilder()) &&
                       (searchSpec.getModel() == null || spec.getModel().equalsIgnoreCase(searchSpec.getModel())) &&
                       (searchSpec.getType() == null || spec.getType() == searchSpec.getType()) &&
                       (searchSpec.getBackWood() == null || spec.getBackWood() == searchSpec.getBackWood()) &&
                       (searchSpec.getTopWood() == null || spec.getTopWood() == searchSpec.getTopWood()) &&
                       (searchSpec.getStyle() == null || spec.getStyle() == searchSpec.getStyle());
            })
            .collect(Collectors.toList());
    }

    private static void printGuitars(List<Instrument> guitars) {
        if (guitars.isEmpty()) {
            System.out.println("No matching guitars found.");
            return;
        }
        guitars.forEach(i -> {
            Guitar g = (Guitar) i;
            GuitarSpec spec = (GuitarSpec) g.getSpec();
            System.out.println(spec.getBuilder() + " " + spec.getModel() + " | " +
                    spec.getType() + " | " + spec.getNumStrings() + " strings | $" + g.getPrice());
        });
    }

    private static void printMandolins(List<Instrument> mandolins) {
        if (mandolins.isEmpty()) {
            System.out.println("No matching mandolins found.");
            return;
        }
        mandolins.forEach(i -> {
            Mandolin m = (Mandolin) i;
            MandolinSpec spec = (MandolinSpec) m.getSpec();
            System.out.println(spec.getBuilder() + " " + spec.getModel() + " | " +
                    spec.getType() + " | Style: " + spec.getStyle() + " | $" + m.getPrice());
        });
    }

    private static Builder selectBuilder(Scanner sc) {
        Builder[] options = Builder.values();
        System.out.println("\nSelect Builder (0 to skip):");
        for (int i = 0; i < options.length; i++)
            System.out.println((i + 1) + ". " + options[i]);
        int ch = sc.nextInt(); sc.nextLine();
        return (ch >= 1 && ch <= options.length) ? options[ch - 1] : null;
    }

    private static Type selectType(Scanner sc) {
        Type[] options = Type.values();
        System.out.println("Select Type (0 to skip):");
        for (int i = 0; i < options.length; i++)
            System.out.println((i + 1) + ". " + options[i]);
        int ch = sc.nextInt(); sc.nextLine();
        return (ch >= 1 && ch <= options.length) ? options[ch - 1] : null;
    }

    private static Wood selectWood(Scanner sc, String label) {
        Wood[] options = Wood.values();
        System.out.println("Select " + label + " Wood (0 to skip):");
        for (int i = 0; i < options.length; i++)
            System.out.println((i + 1) + ". " + options[i]);
        int ch = sc.nextInt(); sc.nextLine();
        return (ch >= 1 && ch <= options.length) ? options[ch - 1] : null;
    }

    private static Style selectStyle(Scanner sc) {
        Style[] options = Style.values();
        System.out.println("Select Style (0 to skip):");
        for (int i = 0; i < options.length; i++)
            System.out.println((i + 1) + ". " + options[i]);
        int ch = sc.nextInt(); sc.nextLine();
        return (ch >= 1 && ch <= options.length) ? options[ch - 1] : null;
    }

    private static String inputModel(Scanner sc) {
        System.out.print("Enter Model name (or press Enter to skip): ");
        String model = sc.nextLine().trim();
        return model.isEmpty() ? null : model;
    }

    private static int inputNumStrings(Scanner sc) {
        System.out.print("Enter number of strings (0 to skip): ");
        int num = sc.nextInt();
        sc.nextLine();
        return num;
    }

	private static void initializeInventory(Inventory inventory) {
		inventory.addInstrument("G123", 1499.99,
				new GuitarSpec(Builder.FENDER, "Stratocaster", Type.ELECTRIC, Wood.MAPLE, Wood.MAPLE, 6));
		inventory.addInstrument("G124", 1299.99,
				new GuitarSpec(Builder.MARTIN, "D-28", Type.ACOUSTIC, Wood.MAHOGANY, Wood.SITKA, 6));
		inventory.addInstrument("G125", 1799.99,
				new GuitarSpec(Builder.GIBSON, "Les Paul", Type.ELECTRIC, Wood.COCOBOLO, Wood.CEDAR, 6));
		inventory.addInstrument("G126", 799.99,
				new GuitarSpec(Builder.FENDER, "Telecaster", Type.ELECTRIC, Wood.ALDER, Wood.ALDER, 6));
		inventory.addInstrument("G127", 999.99,
		        new GuitarSpec(Builder.MARTIN, "OM-28", Type.ACOUSTIC, Wood.BRAZILIAN_ROSEWOOD, Wood.SITKA, 6));

		inventory.addInstrument("G128", 1899.99,
		        new GuitarSpec(Builder.GIBSON, "SG Standard", Type.ELECTRIC, Wood.MAHOGANY, Wood.MAPLE, 6));

		inventory.addInstrument("G129", 1199.99,
		        new GuitarSpec(Builder.FENDER, "Mustang", Type.ELECTRIC, Wood.ALDER, Wood.MAPLE, 6));

		inventory.addInstrument("G130", 1399.99,
		        new GuitarSpec(Builder.MARTIN, "D-35", Type.ACOUSTIC, Wood.INDIAN_ROSEWOOD, Wood.CEDAR, 12));

		inventory.addInstrument("G131", 1599.99,
		        new GuitarSpec(Builder.GIBSON, "Explorer", Type.ELECTRIC, Wood.MAPLE, Wood.MAPLE, 6));

		inventory.addInstrument("G132", 1099.99,
		        new GuitarSpec(Builder.FENDER, "Jazzmaster", Type.ELECTRIC, Wood.ALDER, Wood.SITKA, 6));
		//mandolin
		inventory.addInstrument("M104", 799.99,
		        new MandolinSpec(Builder.COLLINGS, "MT2", Type.ACOUSTIC, Wood.MAPLE, Wood.ADIRONDACK, Style.A));

		inventory.addInstrument("M105", 1099.99,
		        new MandolinSpec(Builder.OLSON, "F5", Type.ACOUSTIC, Wood.COCOBOLO, Wood.CEDAR, Style.F));

		inventory.addInstrument("M106", 849.99,
		        new MandolinSpec(Builder.RYAN, "Artist-A", Type.ACOUSTIC, Wood.MAHOGANY, Wood.MAPLE, Style.A));

		inventory.addInstrument("M107", 1199.99,
		        new MandolinSpec(Builder.GIBSON, "F9", Type.ACOUSTIC, Wood.BRAZILIAN_ROSEWOOD, Wood.SITKA, Style.F));

		inventory.addInstrument("M108", 950.00,
		        new MandolinSpec(Builder.MARTIN, "Flatback-A", Type.ACOUSTIC, Wood.INDIAN_ROSEWOOD, Wood.MAPLE, Style.A));

		inventory.addInstrument("M109", 1050.00,
		        new MandolinSpec(Builder.PRS, "Custom-F", Type.ACOUSTIC, Wood.MAPLE, Wood.MAPLE, Style.F));
	}
}
