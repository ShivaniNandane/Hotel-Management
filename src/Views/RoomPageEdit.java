package Views;

import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class RoomPageEdit extends DefaultCellEditor {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JButton button;
    private String label;
    private boolean clicked;

    public RoomPageEdit (JTextField textField) {
        super(textField);
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(e -> fireEditingStopped());
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        label = (value == null) ? "Edits" : value.toString();
        button.setText(label);
        clicked = true;
        return button;
    }

  
    @Override
    public Object getCellEditorValue() {
        if (clicked) {
           
            int userChoice = JOptionPane.showOptionDialog(
                button,
                "Please click on the button for the details you want:",
                "Customer Action",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[]{"Details", "History", "Current Status"},
                "Details"
            );

           
            if (userChoice == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(
                    button,
                    "Room No: 101, Room Type: Deluxe, Price: $200, Status: Available\n"
                    + "Room No: 102, Room Type: Suite, Price: $350, Status: Booked"
                );
            }

           
            int userchoice1 = JOptionPane.showConfirmDialog(
                button,
                "Do you want to view customer details?",
                "Customer Details",
                JOptionPane.OK_CANCEL_OPTION
            );

            if (userchoice1 == JOptionPane.OK_OPTION) {
                JOptionPane.showMessageDialog(
                    button,
                    "John Doe\njohn@example.com\n1234567890\n123 Main St\n"
                    + "111122223333\nABCDE1234F\n01/10/2024 - 05/10/2024\nRoom No: 101"
                );
            }

            
            int CustomerDetals = JOptionPane.showConfirmDialog(
                button,
                "Room No: 101, Additional Features: Private Pool, WiFi, TV\n"
                + "Room Type: Suite",
                "Customer Details",
                JOptionPane.YES_NO_OPTION
            );

            if (CustomerDetals == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(button,"Room No:101 /paid item"
                		+ " order: cold drink"  +" Quantity: 1"+"  price: 100");
               
            }
        }

        clicked = false; 
        return label;
    }


    @Override
    public boolean stopCellEditing() {
        clicked = false;
        return super.stopCellEditing();
    }
}