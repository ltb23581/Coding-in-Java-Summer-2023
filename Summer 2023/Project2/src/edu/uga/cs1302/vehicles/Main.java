import java.util.*;

public class Main {
	public static void main(String[] args) {
		Vehicle[] store = new Vehicle[15];
		// creating 3 instances of Automobiles
		Automobile car1 = new Automobile();
		car1.setHorsepower(100);
		car1.setMaxPassengers(5);
		car1.setTopSpeed(50);
		car1.setName("Fun Car");
		car1.setManufacture("Fun");
		car1.setYearOfManufacture(2000);
		store[0] = car1;

		Automobile car2 = new Automobile();
		car2.setHorsepower(200);
		car2.setMaxPassengers(2);
		car2.setTopSpeed(100);
		car2.setName("Fun Car Fast");
		car2.setManufacture("Fun");
		car2.setYearOfManufacture(2010);
		store[1] = car2;

		Automobile car3 = new Automobile();
		car3.setHorsepower(270);
		car3.setMaxPassengers(5);
		car3.setTopSpeed(120);
		car3.setName("Toyota Corolla");
		car3.setManufacture("Toyota");
		car3.setYearOfManufacture(2020);
		store[2] = car3;

		// creating 3 instances of Airplane
		Airplane plane1 = new Airplane();
		plane1.setMaxAltitude(1000);
		plane1.setMaxRange(1000);
		plane1.setNumberOfEngines(4);
		plane1.setMaxPassengers(50);
		plane1.setTopSpeed(400);
		plane1.setName("Fun Plane");
		plane1.setManufacture("Fun");
		plane1.setYearOfManufacture(2000);
		store[3] = plane1;

		Airplane plane2 = new Airplane();
		plane2.setMaxAltitude(2000);
		plane2.setMaxRange(2000);
		plane2.setNumberOfEngines(8);
		plane2.setMaxPassengers(100);
		plane2.setTopSpeed(450);
		plane2.setName("Fun Plane Fast");
		plane2.setManufacture("Fun");
		plane2.setYearOfManufacture(2000);
		store[4] = plane2;

		Airplane plane3 = new Airplane();
		plane3.setMaxAltitude(3000);
		plane3.setMaxRange(3000);
		plane3.setNumberOfEngines(8);
		plane3.setMaxPassengers(100);
		plane3.setTopSpeed(500);
		plane3.setName("Boeing Type-1");
		plane3.setManufacture("Boeing");
		plane3.setYearOfManufacture(2010);
		store[5] = plane3;

		// creating 3 instances of Ship
		Ship ship1 = new Ship();
		ship1.setTonnage(100);
		ship1.setShippingLineOwner("Bob");
		ship1.setMaxPassengers(5);
		ship1.setTopSpeed(50);
		ship1.setName("Fun Ship");
		ship1.setManufacture("Fun");
		ship1.setYearOfManufacture(1980);
		store[6] = ship1;

		Ship ship2 = new Ship();
		ship2.setTonnage(200);
		ship2.setShippingLineOwner("Phill");
		ship2.setMaxPassengers(10);
		ship2.setTopSpeed(60);
		ship2.setName("Fun Ship Fast");
		ship2.setManufacture("Fun");
		ship2.setYearOfManufacture(2000);
		store[7] = ship2;

		Ship ship3 = new Ship();
		ship3.setTonnage(300);
		ship3.setShippingLineOwner("Shane");
		ship3.setMaxPassengers(100);
		ship3.setTopSpeed(30);
		ship3.setName("Toyota Ship");
		ship3.setManufacture("Toyota");
		ship3.setYearOfManufacture(2005);
		store[8] = ship3;

		// creating 3 instances of Motorcycle
		Motorcycle motorcycle1 = new Motorcycle();
		motorcycle1.setHorsepower(100);
		motorcycle1.setMaxPassengers(2);
		motorcycle1.setTopSpeed(120);
		motorcycle1.setName("Fun Motorcycle");
		motorcycle1.setManufacture("Fun");
		motorcycle1.setYearOfManufacture(2001);
		store[9] = motorcycle1;

		Motorcycle motorcycle2 = new Motorcycle();
		motorcycle2.setHorsepower(200);
		motorcycle2.setMaxPassengers(1);
		motorcycle2.setTopSpeed(200);
		motorcycle2.setName("Fun Motorcycle Fast");
		motorcycle2.setManufacture("Fun");
		motorcycle2.setYearOfManufacture(2004);
		store[10] = motorcycle2;

		Motorcycle motorcycle3 = new Motorcycle();
		motorcycle3.setHorsepower(270);
		motorcycle3.setMaxPassengers(2);
		motorcycle3.setTopSpeed(200);
		motorcycle3.setName("Toyota Motorcycle1");
		motorcycle3.setManufacture("Toyota");
		motorcycle3.setYearOfManufacture(2012);
		store[11] = motorcycle3;

		// creating 3 instances of Flyingboat
		Flyingboat flyingboat1 = new Flyingboat();
		flyingboat1.setMaxAltitude(100000);
		flyingboat1.setMaxRange(100000);
		flyingboat1.setNumberOfEngines(20);
		flyingboat1.setTonnage(10000);
		flyingboat1.setShippingLineOwner("Bob");
		flyingboat1.setMaxPassengers(5);
		flyingboat1.setTopSpeed(50);
		flyingboat1.setName("Fun Flyingboat");
		flyingboat1.setManufacture("Fun");
		flyingboat1.setYearOfManufacture(2999);
		store[12] = flyingboat1;

		Flyingboat flyingboat2 = new Flyingboat();
		flyingboat2.setMaxAltitude(1000000);
		flyingboat2.setMaxRange(1000000);
		flyingboat2.setNumberOfEngines(200);
		flyingboat2.setTonnage(10000);
		flyingboat2.setShippingLineOwner("Phill");
		flyingboat2.setMaxPassengers(500);
		flyingboat2.setTopSpeed(100000);
		flyingboat2.setName("Fun Flyingboat Fast");
		flyingboat2.setManufacture("Fun");
		flyingboat2.setYearOfManufacture(3007);
		store[13] = flyingboat2;

		Flyingboat flyingboat3 = new Flyingboat();
		flyingboat3.setMaxAltitude(100000000);
		flyingboat3.setMaxRange(100000000);
		flyingboat3.setNumberOfEngines(2000);
		flyingboat3.setTonnage(100000);
		flyingboat3.setShippingLineOwner("Karen");
		flyingboat3.setMaxPassengers(1000);
		flyingboat3.setTopSpeed(10000000);
		flyingboat3.setName("Toyota Flyingboat");
		flyingboat3.setManufacture("Toyota");
		flyingboat3.setYearOfManufacture(3045);
		store[14] = flyingboat3;

		// menu
		Scanner scan = new Scanner(System.in);
		char choice = ' ';
		// The system will ask the use to enter the options and out put what the user wants.
		do {
			System.out.println("Enter a number between 1-6 or the letters 'h'(for help) or 'q'(to quit).");
			System.out.println("========================================================================");
			choice = scan.next().charAt(0);
			System.out.println("========================================================================");
			if (choice == '1') {
				// gets the count of all vehicles
				System.out.println("There are " + store[0].getCount() + " vehicles in the system.");
				System.out.println("========================================================================");
			} else if (choice == '2') {
				// prints the name and type of all vehicles
				for (int i = 0; i < 15; i++) {
					System.out.printf("Name:%-20sType:%-20s%n", store[i].getName(), store[i].getClass());
				}
				System.out.println("========================================================================");
			} else if (choice == '3') {
				// prints the name and type of flyable vehicles
				for (int i = 0; i < 15; i++) {
					if (store[i] instanceof Flyable) {
						System.out.printf("Name:%-20sType:%-20s%n", store[i].getName(), store[i].getClass());
					}
				}
				System.out.println("========================================================================");
			} else if (choice == '4') {
				// prints the name and type of floatable vehicles
				for (int i = 0; i < 15; i++) {
					if (store[i] instanceof Floatable) {
						System.out.printf("Name:%-20sType:%-20s%n", store[i].getName(), store[i].getClass());
					}
				}
				System.out.println("========================================================================");
			} else if (choice == '5') {
				// prints the name and type of vehicles that can fly and float
				for (int i = 0; i < 15; i++) {
					if (store[i] instanceof Floatable && store[i] instanceof Flyable) {
						System.out.printf("Name:%-20sType:%-20s%n", store[i].getName(), store[i].getClass());
					}
				}
				System.out.println("========================================================================");
			} else if (choice == '6') {
				// prints all the information of all vehicles
				for (int i = 0; i < 15; i++) {
					System.out.println(store[i].toString());
					System.out.println("========================================================================");
				}
			} else if (choice == 'h') {
				// prints what each choice does
				System.out.println("Press 1 to see how many vehicles are in the system.");
				System.out.println("Press 2 to see the name and the class of each vehicle.");
				System.out.println("Press 3 to see which vehicles can fly.");
				System.out.println("Press 4 to see which vehicles can float.");
				System.out.println("Press 5 to see which vehicles can float AND fly.");
				System.out.println("Press 6 to see a description of each vehicle.");
				System.out.println("Press h to see brief help information for your system.");
				System.out.println("Press q to terminate the program.");
				System.out.println("========================================================================");
			} else if (choice == 'q') {
				// if the choice is 'q' do nothing. Need this here to prevent q as being a Error choice
			} else {
				System.out.println("Error: " + choice + " is not a valid choice");
				System.out.println("========================================================================");
				System.out.print("Re-");
			}
		// ends program if q is choosen
		} while (choice != 'q');
		System.out.println("Bye!");
	}
}
