package com.labollo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Gianl
 */
public class SpinningWheel extends JFrame implements ActionListener {
    private GamePanel gp;

    private int angle = 0;  // L'angolo corrente della ruota
    private Timer timer;
    private Random random;
    private WheelPanel wheelPanel; // Pannello personalizzato per la ruota

    public SpinningWheel () {
        random = new Random();
        timer = new Timer(50, this);  // Il timer per controllare la velocità della rotazione (ogni 50ms)

        // Inizializza i componenti della finestra
        initComponents();
    }

    private void initComponents() {
        // Impostazione della dimensione e del layout della finestra
        setPreferredSize(new Dimension(500, 500));
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        // Creiamo un pannello personalizzato per la ruota
        wheelPanel = new WheelPanel();
        wheelPanel.setBackground(Color.BLACK);
        wheelPanel.setPreferredSize(new Dimension(400, 400));

        // Creiamo un bottone per avviare la rotazione della ruota
        JButton spinButton = new JButton("Spin");
        spinButton.addActionListener(e -> {
            // Avviamo il timer e la ruota inizia a girare
            timer.start();
        });

        // Creiamo un bottone per fermare la rotazione della ruota

        JButton stopButton = new JButton("Stop");
        stopButton.addActionListener(e -> {
            // Ferma il timer e la ruota si ferma
            timer.stop();
        });

        // Aggiungiamo il pannello della ruota e i pulsanti al frame
        this.setLayout(new BorderLayout());
        this.add(wheelPanel, BorderLayout.CENTER);

        // Pannello per i pulsanti
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(spinButton);
        buttonPanel.add(stopButton);
        this.add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);  // Posiziona la finestra al centro dello schermo
    }

    // Classe interna per la ruota personalizzata
    private class WheelPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            // Disegna la ruota con diversi colori per le sezioni
            int centerX = getWidth() / 2;
            int centerY = getHeight() / 2;
            int radius = 150;

            // Imposta la quantità di sezioni
            int numSections = 8;
            int sectionAngle = 360 / numSections;

            for (int i = 0; i < numSections; i++) {
                g2d.setColor(getRandomColor());
                g2d.fillArc(centerX - radius, centerY - radius, radius * 2, radius * 2, angle + i * sectionAngle, sectionAngle);
            }

            // Disegna un cerchio al centro per simulare il perno della ruota
            g2d.setColor(Color.BLACK);
            g2d.fillOval(centerX - 10, centerY - 10, 20, 20);
        }

        // Metodo per ottenere un colore casuale per ogni sezione della ruota
        private Color getRandomColor() {
            return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        angle += 10;  // Cambia l'angolo per simulare la rotazione
        if (angle >= 360) {
            angle = 0;
        }
        wheelPanel.repaint();  // Richiede di ridisegnare il pannello della ruota
    }

    public static void main(String[] args) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new SpinningWheel().setVisible(true);
        });
    }
}
