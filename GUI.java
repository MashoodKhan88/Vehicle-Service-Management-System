import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

public class GUI {

    static ArrayList<Vehicle> vehicles = new ArrayList<>();
    static ArrayList<ServiceRecord> serviceRecords = new ArrayList<>();

    public static void main(String[] args) {

        
        // MAIN WINDOW
       
        JFrame frame = new JFrame("Vehicle Service Management System");

        frame.setSize(850, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);




        JPanel background = new JPanel();

        background.setBounds(0, 0, 850, 550);
        background.setBackground(new Color(245, 247, 250));
        background.setLayout(null);

        frame.add(background);


        JPanel header = new JPanel();

        header.setBounds(0, 0, 850, 100);
        header.setBackground(new Color(35, 45, 60));
        header.setLayout(null);

        background.add(header);


        JLabel title = new JLabel(
            "VEHICLE SERVICE MANAGEMENT SYSTEM"
        );

        title.setBounds(100, 20, 650, 40);
        title.setHorizontalAlignment(SwingConstants.CENTER);

        title.setFont(
            new Font("Arial", Font.BOLD, 24)
        );

        title.setForeground(Color.WHITE);

        header.add(title);

        JButton addVehicleButton = new JButton("Add Vehicle");

        addVehicleButton.setBounds(100, 140, 280, 65);

        styleButton(addVehicleButton);

        background.add(addVehicleButton);


        addVehicleButton.addActionListener(e -> {

            JPanel panel = new JPanel();

            panel.setLayout(
                new GridLayout(3, 2, 10, 15)
            );

            panel.setBorder(
                BorderFactory.createEmptyBorder(
                    10, 10, 10, 10
                )
            );


            JLabel numberLabel =
                new JLabel("Vehicle Number:");

            JTextField numberField =
                new JTextField();


            JLabel ownerLabel =
                new JLabel("Owner Name:");

            JTextField ownerField =
                new JTextField();


            JLabel modelLabel =
                new JLabel("Vehicle Model:");

            JTextField modelField =
                new JTextField();


            panel.add(numberLabel);
            panel.add(numberField);

            panel.add(ownerLabel);
            panel.add(ownerField);

            panel.add(modelLabel);
            panel.add(modelField);


            int result = JOptionPane.showConfirmDialog(
                frame,
                panel,
                "Add Vehicle",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
            );


            if (result == JOptionPane.OK_OPTION) {

                String vehicleNumber =
                    numberField.getText().trim();

                String ownerName =
                    ownerField.getText().trim();

                String vehicleModel =
                    modelField.getText().trim();


                if (vehicleNumber.isEmpty()) {

                    JOptionPane.showMessageDialog(
                        frame,
                        "Vehicle number cannot be empty!",
                        "Invalid Input",
                        JOptionPane.WARNING_MESSAGE
                    );

                    return;
                }


                boolean vehicleExists = false;


                for (Vehicle v : vehicles) {

                    if (v.vehicleNumber
                        .equalsIgnoreCase(vehicleNumber)) {

                        vehicleExists = true;
                        break;
                    }
                }


                if (vehicleExists) {

                    JOptionPane.showMessageDialog(
                        frame,
                        "Vehicle number already exists!",
                        "Duplicate Vehicle",
                        JOptionPane.WARNING_MESSAGE
                    );

                    return;
                }


                Vehicle vehicle = new Vehicle(
                    vehicleNumber,
                    ownerName,
                    vehicleModel
                );


                vehicles.add(vehicle);


                JOptionPane.showMessageDialog(
                    frame,
                    "Vehicle added successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE
                );
            }
        });


        
        // VIEW VEHICLES BUTTON
        

        JButton viewVehicleButton =
            new JButton("View Vehicles");

        viewVehicleButton.setBounds(
            470, 140, 280, 65
        );

        styleButton(viewVehicleButton);

        background.add(viewVehicleButton);


        viewVehicleButton.addActionListener(e -> {

            if (vehicles.isEmpty()) {

                JOptionPane.showMessageDialog(
                    frame,
                    "No vehicles found!",
                    "Vehicle List",
                    JOptionPane.INFORMATION_MESSAGE
                );

                return;
            }


            String[] columns = {
                "Vehicle Number",
                "Owner Name",
                "Vehicle Model"
            };


            Object[][] data =
                new Object[vehicles.size()][3];


            for (int i = 0;
                 i < vehicles.size();
                 i++) {

                Vehicle v = vehicles.get(i);

                data[i][0] = v.vehicleNumber;
                data[i][1] = v.ownerName;
                data[i][2] = v.vehicleModel;
            }


            JTable table =
                new JTable(data, columns);


            styleTable(table);


            JScrollPane scrollPane =
                new JScrollPane(table);

            scrollPane.setPreferredSize(
                new Dimension(650, 280)
            );


            JOptionPane.showMessageDialog(
                frame,
                scrollPane,
                "All Vehicles",
                JOptionPane.INFORMATION_MESSAGE
            );
        });


        
        // ADD SERVICE BUTTON
        

        JButton addServiceButton =
            new JButton("Add Service Record");

        addServiceButton.setBounds(
            100, 240, 280, 65
        );

        styleButton(addServiceButton);

        background.add(addServiceButton);


        addServiceButton.addActionListener(e -> {

            JPanel panel = new JPanel();

            panel.setLayout(
                new GridLayout(4, 2, 10, 15)
            );

            panel.setBorder(
                BorderFactory.createEmptyBorder(
                    10, 10, 10, 10
                )
            );


            JLabel numberLabel =
                new JLabel("Vehicle Number:");

            JTextField numberField =
                new JTextField();


            JLabel typeLabel =
                new JLabel("Service Type:");

            JTextField typeField =
                new JTextField();


            JLabel dateLabel =
                new JLabel("Service Date:");

            JTextField dateField =
                new JTextField();


            JLabel costLabel =
                new JLabel("Service Cost:");

            JTextField costField =
                new JTextField();


            panel.add(numberLabel);
            panel.add(numberField);

            panel.add(typeLabel);
            panel.add(typeField);

            panel.add(dateLabel);
            panel.add(dateField);

            panel.add(costLabel);
            panel.add(costField);


            int result = JOptionPane.showConfirmDialog(
                frame,
                panel,
                "Add Service Record",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
            );


            if (result == JOptionPane.OK_OPTION) {

                String vehicleNumber =
                    numberField.getText().trim();

                String serviceType =
                    typeField.getText().trim();

                String serviceDate =
                    dateField.getText().trim();


                if (vehicleNumber.isEmpty()) {

                    JOptionPane.showMessageDialog(
                        frame,
                        "Vehicle number cannot be empty!",
                        "Invalid Input",
                        JOptionPane.WARNING_MESSAGE
                    );

                    return;
                }


                double serviceCost;


                try {

                    serviceCost =
                        Double.parseDouble(
                            costField.getText().trim()
                        );

                } catch (NumberFormatException ex) {

                    JOptionPane.showMessageDialog(
                        frame,
                        "Please enter a valid service cost!",
                        "Invalid Cost",
                        JOptionPane.WARNING_MESSAGE
                    );

                    return;
                }


                if (serviceCost < 0) {

                    JOptionPane.showMessageDialog(
                        frame,
                        "Service cost cannot be negative!",
                        "Invalid Cost",
                        JOptionPane.WARNING_MESSAGE
                    );

                    return;
                }


                ServiceRecord record =
                    new ServiceRecord(
                        vehicleNumber,
                        serviceType,
                        serviceDate,
                        serviceCost
                    );


                serviceRecords.add(record);


                JOptionPane.showMessageDialog(
                    frame,
                    "Service record added successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE
                );
            }
        });


        
        // SERVICE HISTORY BUTTON
        

        JButton serviceHistoryButton =
            new JButton("Service History");

        serviceHistoryButton.setBounds(
            470, 240, 280, 65
        );

        styleButton(serviceHistoryButton);

        background.add(serviceHistoryButton);


        serviceHistoryButton.addActionListener(e -> {

            String vehicleNumber =
                JOptionPane.showInputDialog(
                    frame,
                    "Enter Vehicle Number:"
                );


            if (vehicleNumber == null ||
                vehicleNumber.trim().isEmpty()) {

                return;
            }


            vehicleNumber =
                vehicleNumber.trim();


            ArrayList<ServiceRecord> matchingRecords =
                new ArrayList<>();


            for (ServiceRecord record :
                 serviceRecords) {

                if (record.vehicleNumber
                    .equalsIgnoreCase(vehicleNumber)) {

                    matchingRecords.add(record);
                }
            }


            if (matchingRecords.isEmpty()) {

                JOptionPane.showMessageDialog(
                    frame,
                    "No service records found for this vehicle!",
                    "Service History",
                    JOptionPane.INFORMATION_MESSAGE
                );

                return;
            }


            String[] columns = {
                "Service Type",
                "Service Date",
                "Service Cost"
            };


            Object[][] data =
                new Object[matchingRecords.size()][3];


            for (int i = 0;
                 i < matchingRecords.size();
                 i++) {

                ServiceRecord record =
                    matchingRecords.get(i);


                data[i][0] =
                    record.serviceType;

                data[i][1] =
                    record.serviceDate;

                data[i][2] =
                    "₹" + record.serviceCost;
            }


            JTable table =
                new JTable(data, columns);


            styleTable(table);


            JScrollPane scrollPane =
                new JScrollPane(table);

            scrollPane.setPreferredSize(
                new Dimension(650, 280)
            );


            JOptionPane.showMessageDialog(
                frame,
                scrollPane,
                "Service History - " + vehicleNumber,
                JOptionPane.INFORMATION_MESSAGE
            );
        });


        
        // DELETE VEHICLE BUTTON
        

        JButton deleteVehicleButton =
            new JButton("Delete Vehicle");

        deleteVehicleButton.setBounds(
            285, 340, 280, 65
        );

        styleDeleteButton(deleteVehicleButton);

        background.add(deleteVehicleButton);


        deleteVehicleButton.addActionListener(e -> {

            String vehicleNumber =
                JOptionPane.showInputDialog(
                    frame,
                    "Enter Vehicle Number to Delete:"
                );


            if (vehicleNumber == null ||
                vehicleNumber.trim().isEmpty()) {

                return;
            }


            vehicleNumber =
                vehicleNumber.trim();


            boolean vehicleFound = false;


            for (int i = 0;
                 i < vehicles.size();
                 i++) {

                if (vehicles.get(i)
                    .vehicleNumber
                    .equalsIgnoreCase(vehicleNumber)) {

                    vehicles.remove(i);

                    vehicleFound = true;

                    break;
                }
            }


            if (vehicleFound) {

                JOptionPane.showMessageDialog(
                    frame,
                    "Vehicle deleted successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE
                );

            } else {

                JOptionPane.showMessageDialog(
                    frame,
                    "Vehicle not found!",
                    "Not Found",
                    JOptionPane.WARNING_MESSAGE
                );
            }
        });




    
        // SHOW WINDOW
        

        frame.setVisible(true);
    }


    
    // BUTTON STYLE
    

    public static void styleButton(JButton button) {

        button.setFont(
            new Font("Arial", Font.BOLD, 16)
        );

        button.setForeground(Color.WHITE);

        button.setBackground(
            new Color(52, 73, 94)
        );

        button.setFocusPainted(false);

        button.setBorder(
            BorderFactory.createEmptyBorder()
        );

        button.setCursor(
            new Cursor(Cursor.HAND_CURSOR)
        );
    }



    public static void styleDeleteButton(JButton button) {

        button.setFont(
            new Font("Arial", Font.BOLD, 16)
        );

        button.setForeground(Color.WHITE);

        button.setBackground(
            new Color(192, 57, 43)
        );

        button.setFocusPainted(false);

        button.setBorder(
            BorderFactory.createEmptyBorder()
        );

        button.setCursor(
            new Cursor(Cursor.HAND_CURSOR)
        );
    }



    public static void styleTable(JTable table) {

        table.setFont(
            new Font("Arial", Font.PLAIN, 14)
        );

        table.setRowHeight(30);

        table.setSelectionMode(
            ListSelectionModel.SINGLE_SELECTION
        );


        JTableHeader header =
            table.getTableHeader();

        header.setFont(
            new Font("Arial", Font.BOLD, 14)
        );

        header.setBackground(
            new Color(35, 45, 60)
        );

        header.setForeground(Color.WHITE);


        DefaultTableCellRenderer renderer =
            new DefaultTableCellRenderer();

        renderer.setHorizontalAlignment(
            SwingConstants.CENTER
        );


        for (int i = 0;
             i < table.getColumnCount();
             i++) {

            table.getColumnModel()
                 .getColumn(i)
                 .setCellRenderer(renderer);
        }
    }
}