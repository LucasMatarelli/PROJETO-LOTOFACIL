import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LotofacilGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("LotofácilGUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JButton btnAposta1 = new JButton("Apostar de 0 a 100");
        JButton btnAposta2 = new JButton("Apostar de A à Z");
        JButton btnAposta3 = new JButton("Apostar em par ou ímpar");
        JButton btnSair = new JButton("Sair");

        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(btnAposta1);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(btnAposta2);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(btnAposta3);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(btnSair);

        frame.add(mainPanel);
        
        btnAposta1.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnAposta2.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnAposta3.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnSair.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnAposta1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog(null, "Digite um número de 0 a 100:");
                try {
                    int numeroApostado = Integer.parseInt(input);
                    realizarAposta1(numeroApostado);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Aposta inválida.");
                }
            }
        });
        btnAposta2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog(null, "Digite uma letra de A à Z:");
                if (input != null && input.length() == 1) {
                    char letraApostada = Character.toUpperCase(input.charAt(0));
                    realizarAposta2(letraApostada);
                } else {
                    JOptionPane.showMessageDialog(null, "Aposta inválida.");
                }
            }
        });
        btnAposta3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog(null, "Digite um número inteiro:");
                try {
                    int numeroParImpar = Integer.parseInt(input);
                    realizarAposta3(numeroParImpar);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Aposta inválida.");
                }
            }
        });
        btnSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        frame.setVisible(true);
    }
    public static void realizarAposta1(int numeroApostado) {
        Random random = new Random();
        int numeroSorteado = random.nextInt(101);

        if (numeroApostado < 0 || numeroApostado > 100) {
            JOptionPane.showMessageDialog(null, "Aposta inválida.");
        } else if (numeroApostado == numeroSorteado) {
            JOptionPane.showMessageDialog(null, "Você ganhou R$ 1.000,00 reais.");
        } else {
            JOptionPane.showMessageDialog(null, "Que triste! O número sorteado foi: " + numeroSorteado + ".");
        }
    }
    public static void realizarAposta2(char letraApostada) {
        char letraPremiada = 'L';

        if (letraApostada == letraPremiada) {
            JOptionPane.showMessageDialog(null, "Você ganhou R$ 500,00 reais.");
        } else {
            JOptionPane.showMessageDialog(null, "Que triste! A letra sorteada foi: " + letraPremiada + ".");
        }
    }
    public static void realizarAposta3(int numeroParImpar) {
        if (numeroParImpar % 2 == 0) {
            JOptionPane.showMessageDialog(null, "Você ganhou R$ 100,00 reais.");
        } else {
            JOptionPane.showMessageDialog(null, "Que triste! O número digitado é ímpar e a premiação foi para números pares.");
        }
    }
}
