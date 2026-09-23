import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        ArrayList<ServiceRecord> serviceRecords = new ArrayList<>();
        int choice;

        do {

            System.out.println("\n===== VEHICLE SERVICE MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Vehicle");
            System.out.println("2. View Vehicles");
            System.out.println("3. Service Record");
            System.out.println("4. view service record");
            System.out.println("5. Delete a vehicle");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {

                case 1:

                    System.out.print("Enter Vehicle Number: ");
                    String vehicleNumber = sc.nextLine();
                    if(vehicleNumber.isEmpty()){
                        System.out.println("vehicle number cannot be empty");
                        break;
                    }

                    boolean vehicleExists = false;

                    for (Vehicle v : vehicles) {

                        if (v.vehicleNumber.equalsIgnoreCase(vehicleNumber)) {
                            vehicleExists = true;
                            break;
                        }
                    }
                    if (vehicleExists) {
                        System.out.println("Vehicle number already exists!");
                        break;
                    }
                   

                    System.out.print("Enter Owner Name: ");
                    String ownerName = sc.nextLine();

                    System.out.print("Enter Vehicle Model: ");
                    String vehicleModel = sc.nextLine();

                    Vehicle vehicle = new Vehicle(vehicleNumber,ownerName,vehicleModel);
                    vehicles.add(vehicle);

                    System.out.println("Vehicle added successfully!");
                    break;


                case 2:

                    if (vehicles.isEmpty()) {

                        System.out.println("No vehicles found!");

                    } else {

                        System.out.println("\n===== ALL VEHICLES =====");

                        for (Vehicle v : vehicles) {

                            System.out.println("Vehicle Number: " + v.vehicleNumber);

                            System.out.println("Owner Name: " + v.ownerName);

                            System.out.println("Vehicle Model: " + v.vehicleModel);

                            System.out.println("-------------------------");
                        }
                    }

                    break;



                case 3:
                    System.out.println("enter vehicle Number");
                    String vehichleNumber = sc.nextLine();

                    System.out.println("Enter service type");
                    String serviceType = sc.nextLine();

                    System.out.println("Enter Service date");
                    String serviceDate = sc.nextLine();

                    System.out.println("enter service cost");
                    double serviceCost = sc.nextDouble();
                    sc.nextLine();
                    if(serviceCost<0){
                        System.out.println("serivce cost cannot be negative");
                        break;
                    }


                    ServiceRecord record = new ServiceRecord(vehichleNumber, serviceType, serviceDate, serviceCost);

                    serviceRecords.add(record);
                    System.out.println("record added successfully");
                    break; 
                    
                case 4:
                    System.out.println("Enter vehicle number: ");
                    String searchVehicleNumber = sc.nextLine();
                    
                    boolean foundService = false;

                    System.out.println("====service history====");

                    for(ServiceRecord records : serviceRecords){
                        if(records.vehicleNumber.equalsIgnoreCase(searchVehicleNumber)){
                            System.out.println("service type: "+ records.serviceType);
                            System.out.println("service date: "+ records.serviceType);
                            System.out.println("service cost: "+ records.serviceCost);

                            foundService = true;

                        }
                    }
                    if(!foundService){
                        System.out.println("no service records found");
                    }
                    break;

                case 5:
                    System.out.println("Enter vehicle number to delete");
                    String deleteVehicle = sc.nextLine();

                    boolean vehicleFound = false;

                    for(int i=0;i<vehicles.size();i++){
                        if(vehicles.get(i).vehicleNumber.equalsIgnoreCase(deleteVehicle)){
                            vehicles.remove(i);
                            System.out.println("vehicle deleted!");
                            vehicleFound = true;
                            break;
                        }
                    }
                    if(!vehicleFound){
                        System.out.println("vehicle not found");
                    }
                    break;
                case 6: 
                System.out.println("Thank you for using the system!");
                    break;

                default:
                    System.out.println("Invalid choice!");

            }

        } while (choice != 6);

        sc.close();
    }
}