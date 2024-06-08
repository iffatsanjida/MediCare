import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class pendingDocList extends JFrame {
    private JTable table;
    private DefaultTableModel model;
    private List<Doctor> pendingDoctors;
    private List<Doctor> approvedDoctors;

    public pendingDocList() {
        setTitle("Pending Doctor List");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 400);
        getContentPane().setLayout(new BorderLayout());

        // Load doctors from file
        loadPendingDoctors();
        loadApprovedDoctors();

        // Create table model
        model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"First Name", "Last Name", "Email", "Approve", "Delete"});

        // Create table
        table = new JTable(model) {
            public boolean isCellEditable(int row, int column) {
                return column == 3 || column == 4; // Only approve and delete columns are editable
            }
        };

        // Add buttons to table
        table.getColumnModel().getColumn(3).setCellRenderer(new ButtonRenderer());
        table.getColumnModel().getColumn(3).setCellEditor(new ButtonEditor(new JCheckBox(), this, true));
        table.getColumnModel().getColumn(4).setCellRenderer(new ButtonRenderer());
        table.getColumnModel().getColumn(4).setCellEditor(new ButtonEditor(new JCheckBox(), this, false));

        // Add data to table
        for (Doctor doctor : pendingDoctors) {
            model.addRow(new Object[]{doctor.getFirstName(), doctor.getLastName(), doctor.getEmail(), "Approve", "Delete"});
        }

        // Add table to scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        JButton backButton = new JButton("Back to Dashboard");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Redirect to admin home page
                new AdminDashboard();
                dispose(); // Close the pending doctor list window
            }
        });

        // Add the back button to the content pane
        getContentPane().add(backButton, BorderLayout.NORTH);

        setVisible(true);
    }

    private void loadPendingDoctors() {
        pendingDoctors = new ArrayList<>();
        try (FileInputStream fileIn = new FileInputStream("pending_doctor_list.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            pendingDoctors = (List<Doctor>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "No records");
        }
    }

    private void loadApprovedDoctors() {
        approvedDoctors = new ArrayList<>();
        try (FileInputStream fileIn = new FileInputStream("doctor_list.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            approvedDoctors = (List<Doctor>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void savePendingDoctors() {
        try (FileOutputStream fileOut = new FileOutputStream("pending_doctor_list.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(pendingDoctors);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveApprovedDoctors() {
        try (FileOutputStream fileOut = new FileOutputStream("doctor_list.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(approvedDoctors);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void approveDoctor(int index) {
        Doctor doctor = pendingDoctors.remove(index);
        approvedDoctors.add(doctor);
        savePendingDoctors();
        saveApprovedDoctors();
        model.removeRow(index);
    }

    public void deleteDoctor(int index) {
        pendingDoctors.remove(index);
        savePendingDoctors();
        model.removeRow(index);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new pendingDocList());
    }
}

class ButtonRenderer extends JButton implements TableCellRenderer {
    public ButtonRenderer() {
        setOpaque(true);
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setText((value == null) ? "" : value.toString());
        return this;
    }
}

class ButtonEditor extends DefaultCellEditor {
    protected JButton button;
    private String label;
    private boolean isApprove;
    private int row;
    private pendingDocList frame;

    public ButtonEditor(JCheckBox checkBox, pendingDocList frame, boolean isApprove) {
        super(checkBox);
        this.frame = frame;
        this.isApprove = isApprove;
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
                if (isApprove) {
                    frame.approveDoctor(row);
                } else {
                    frame.deleteDoctor(row);
                }
            }
        });
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.row = row;
        label = (value == null) ? "" : value.toString();
        button.setText(label);
        return button;
    }

    public Object getCellEditorValue() {
        return label;
    }
}
