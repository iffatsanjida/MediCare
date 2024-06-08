import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorList extends JFrame {
    private List<Doctor> doctors;
    private boolean isAdmin;

    public DoctorList(String email, Patient patient) {
        getContentPane().setBackground(new Color(125, 173, 196));
        setTitle("Doctor List");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        getContentPane().setLayout(null);

        JButton btnNewButton = new JButton("Back");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isAdmin) {
                    new AdminDashboard();
                } else {
                    new patientHomePage(patient);
                }
                dispose();
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnNewButton.setBounds(595, 527, 179, 23);
        getContentPane().add(btnNewButton);

        // Check if the user is admin
        isAdmin = email.equals("admin@admin.com");

        // Load doctors from file
        loadDoctors();

        // Create a panel to hold all doctor panels
        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(new Color(125, 173, 196));
        contentPanel.setLayout(null);

        // Add each doctor panel to the content panel
        int y = 10; // Initial y position for the first panel
        for (Doctor doctor : doctors) {
            JPanel panel = createDoctorPanel(doctor);
            panel.setBounds(10, y, 764, 114);
            contentPanel.add(panel);
            y += 120; // Increase y position for the next panel
        }

        // Add the content panel to a scroll pane
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setBounds(10, 10, 764, 500); // Adjust the bounds as needed
        getContentPane().add(scrollPane);

        setVisible(true);
    }

    private void loadDoctors() {
    	doctors = new ArrayList<>();
        try (FileInputStream fileIn = new FileInputStream("doctor_list.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            doctors = (List<Doctor>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private JPanel createDoctorPanel(Doctor doctor) {
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);

        JLabel lblName = new JLabel(doctor.getFirstName());
        lblName.setFont(new Font("Tahoma", Font.BOLD, 25));
        lblName.setBounds(10, 11, 315, 44);
        panel.add(lblName);

        JLabel lblMail = new JLabel(doctor.getEmail());
        lblMail.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblMail.setBounds(10, 55, 279, 24);
        panel.add(lblMail);

        JButton btnContact = new JButton("Contact");
        btnContact.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnContact.setBounds(563, 67, 168, 36);
        btnContact.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Action to perform when the contact button is clicked
                JOptionPane.showMessageDialog(DoctorList.this, "Contact: " + doctor.getEmail(), "Contact Doctor", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        panel.add(btnContact);

        if (isAdmin) {
            JButton btnDelete = new JButton("Delete");
            btnDelete.setFont(new Font("Tahoma", Font.BOLD, 16));
            btnDelete.setBounds(390, 67, 163, 36);
            // Add action listener for delete button if user is admin
            btnDelete.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Action to perform when the delete button is clicked
                    // You can implement delete functionality here
                    int confirm = JOptionPane.showConfirmDialog(DoctorList.this, "Are you sure you want to delete " + doctor.getFirstName() + "?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        doctors.remove(doctor);
                        saveDoctors();
                        panel.setVisible(false); 
                        panel.getParent().revalidate(); 
                        panel.getParent().repaint();
                    }
                }
            });
            panel.add(btnDelete);
        }

        return panel;
    }
    
    private void saveDoctors() {
        try (FileOutputStream fileOut = new FileOutputStream("doctor_list.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(doctors);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DoctorList("admin@admin.com", null));
    }
}
