package swing;

/*
 * 
 * FlowLayoutDemo.java
 */

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class FlowLayoutDemo extends JFrame {
    JRadioButton RtoLbutton;
    JRadioButton LtoRbutton;
    FlowLayout experimentLayout = new FlowLayout();
    final String RtoL = "Right to left";
    final String LtoR = "Left to right";
    JButton applyButton = new JButton("Apply component orientation");

    public FlowLayoutDemo(String name) {
        super(name);
    }

    public void addComponentsToPane(final Container pane) {
        final JPanel compsToExperiment = new JPanel();
        compsToExperiment.setLayout(experimentLayout);
        experimentLayout.setAlignment(FlowLayout.TRAILING);
        JPanel controls = new JPanel();
        controls.setLayout(new FlowLayout());

        LtoRbutton = new JRadioButton(LtoR);
        LtoRbutton.setActionCommand(LtoR);
        LtoRbutton.setSelected(true);
        RtoLbutton = new JRadioButton(RtoL);
        RtoLbutton.setActionCommand(RtoL);

        // Add buttons to the experiment layout
        compsToExperiment.add(new JButton("Iniciar"));
        compsToExperiment.add(new JButton("Pasar Turno"));
        compsToExperiment.add(new JButton("Guardar"));
        compsToExperiment.add(new JButton("Salir"));
        compsToExperiment.add(new JButton("Disparar"));
        // Left to right component orientation is selected by default
        compsToExperiment.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        // Add controls to set up the component orientation in the experiment layout
        final ButtonGroup group = new ButtonGroup();
        group.add(LtoRbutton);
        group.add(RtoLbutton);
        controls.add(LtoRbutton);
        controls.add(RtoLbutton);
        controls.add(applyButton);

        // Process the Apply component orientation button press
        applyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = group.getSelection().getActionCommand();
                // Check the selection
                if (command.equals("Left to right")) {
                    compsToExperiment.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
                } else {
                    compsToExperiment.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
                }
                // update the experiment layout
                compsToExperiment.validate();
                compsToExperiment.repaint();
            }
        });
        pane.add(compsToExperiment, BorderLayout.CENTER);
        pane.add(controls, BorderLayout.SOUTH);;
    }

    /**
     * Create the GUI and show it. For thread safety, this method should be invoked from the event
     * dispatch thread.
     */
    private static void createAndShowGUI() {
        // Create and set up the window.
        FlowLayoutDemo frame = new FlowLayoutDemo("FlowLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set up the content pane.
        frame.addComponentsToPane(frame.getContentPane());
        // Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        /* Use an appropriate Look and Feel */
        try {
            // UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        // Schedule a job for the event dispatchi thread:
        // creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
}