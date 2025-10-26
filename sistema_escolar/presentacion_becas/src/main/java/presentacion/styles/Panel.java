/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.styles;
import presentacion.MainFrame;
import presentacion.panels.uitls.NorthPanel;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Cortez, Manuel;
 */
public abstract class Panel extends JPanel {
    protected MainFrame mainFrame;
    protected JPanel centralPanel;
    protected JPanel southPanel;
    protected Button btnBack;
    protected NorthPanel northPanel;

    public Panel(MainFrame frame, NorthPanel northPanel) {
        mainFrame = frame;
        this.northPanel = northPanel;
        btnBack = new Button("Volver");
        setLayout(new BorderLayout());
        centralPanel = new JPanel();
        southPanel = new JPanel();
        centralPanel.setPreferredSize(new Dimension(1500, 750));
        centralPanel.setLayout(new BoxLayout(centralPanel, BoxLayout.Y_AXIS));
        southPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        southPanel.setPreferredSize(new Dimension(1500, 100));
        southPanel.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 0));
        centralPanel.setBackground(Style.PANEL_COLOR);
        southPanel.setBackground(Style.PANEL_COLOR);

        startComponents();
        add(centralPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
        southPanel.add(btnBack);

        btnBack.addActionListener(e -> frame.showMainPanel());
        btnBack.addActionListener(e -> {
           this.northPanel.erraseRectangle();
        });

    }


    public abstract void startComponents();
}