package presentacion.pagarAdeudo.panels;

import pagarAdeudo.PrestamoDTO;
import presentacion.pagarAdeudo.PagarAdeudo;
import presentacion.pagarAdeudo.PanelPagarAdeudo;
import presentacion.pagarAdeudo.coordinadorAplicacionPagarAdeudo.CoordinadorAplicacionPagarAdeudo;
import presentacion.styles.Button;
import presentacion.styles.CustomTable;
import presentacion.styles.Style;
import presentacion.styles.enums.PanelCategory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ListaPrestamosBiblioteca extends PanelPagarAdeudo {

    private JLabel lblMontoTotal;
    private DefaultTableModel tableModel;
    private CustomTable table;

    public ListaPrestamosBiblioteca(PagarAdeudo frame, CoordinadorAplicacionPagarAdeudo coordinadorAplicacion) {
        super(frame, coordinadorAplicacion);
    }

    @Override
    public void startComponents() {
        centralPanel.removeAll();
        centralPanel.setLayout(new GridBagLayout());
        centralPanel.setBackground(new Color(30, 30, 30));

        GridBagConstraints gbc = new GridBagConstraints();

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setOpaque(false);

        JPanel headerBiblioteca = new RoundedPanel(20, new Color(235, 235, 235));
        headerBiblioteca.setPreferredSize(new Dimension(250, 50));
        headerBiblioteca.setMaximumSize(new Dimension(250, 50));
        headerBiblioteca.setLayout(new GridBagLayout()); // Para centrar el texto
        JLabel lblTituloIzq = new JLabel("Biblioteca");
        lblTituloIzq.setFont(new Font("SansSerif", Font.PLAIN, 20));
        headerBiblioteca.add(lblTituloIzq);

        JPanel cardPago = new RoundedPanel(20, new Color(235, 235, 235));
        cardPago.setPreferredSize(new Dimension(250, 200));
        cardPago.setMaximumSize(new Dimension(250, 200));
        cardPago.setLayout(new BoxLayout(cardPago, BoxLayout.Y_AXIS));
        cardPago.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel lblMontoTitulo = new JLabel("Monto total:");
        lblMontoTitulo.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblMontoTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        lblMontoTotal = new JLabel("$ 0.00 MXN");
        lblMontoTotal.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblMontoTotal.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel precioBox = new RoundedPanel(10, Color.WHITE);
        precioBox.setMaximumSize(new Dimension(200, 40));
        precioBox.add(lblMontoTotal);

        Button btnRealizarPago = new Button("Realizar Pago");
        btnRealizarPago.setBackground(Color.BLACK);
        btnRealizarPago.setForeground(Color.BLACK);
        btnRealizarPago.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnRealizarPago.setMaximumSize(new Dimension(200, 40));

        leftPanel.add(headerBiblioteca);
        leftPanel.add(Box.createVerticalStrut(30));

        cardPago.add(Box.createVerticalStrut(10));
        cardPago.add(lblMontoTitulo);
        cardPago.add(Box.createVerticalStrut(10));
        cardPago.add(precioBox);
        cardPago.add(Box.createVerticalStrut(20));
        cardPago.add(btnRealizarPago);

        leftPanel.add(cardPago);

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setOpaque(false);

        JPanel headerPrestamos = new RoundedPanel(20, new Color(235, 235, 235));
        headerPrestamos.setPreferredSize(new Dimension(250, 50));
        headerPrestamos.setMaximumSize(new Dimension(250, 50));
        headerPrestamos.setLayout(new GridBagLayout());
        JLabel lblTituloDer = new JLabel("Prestamos");
        lblTituloDer.setFont(new Font("SansSerif", Font.PLAIN, 20));
        headerPrestamos.add(lblTituloDer);

        JPanel tableContainer = new RoundedPanel(20, Color.WHITE);
        tableContainer.setLayout(new BorderLayout());
        tableContainer.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        tableContainer.setPreferredSize(new Dimension(700, 400));

        String[] columnNames = {"ISBN", "Título", "Fecha préstamo", "Fecha Devolución", "Ver"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 4;
            }
        };


        table = new CustomTable(tableModel, mainFrame, PanelCategory.LISTA_PRESTAMOS, this, coordinadorAplicacion);
        table.addColumnButton();

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getViewport().setBackground(Color.WHITE);

        tableContainer.add(scrollPane, BorderLayout.CENTER);

        rightPanel.add(headerPrestamos);
        rightPanel.add(Box.createVerticalStrut(20));
        rightPanel.add(tableContainer);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(20, 20, 20, 20);
        centralPanel.add(leftPanel, gbc);

        gbc.gridx = 1;
        JLabel arrow = new JLabel("←");
        arrow.setFont(new Font("SansSerif", Font.BOLD, 24));
        arrow.setForeground(Color.WHITE);

        gbc.gridx = 2;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        centralPanel.add(rightPanel, gbc);
        btnBack.addActionListener(e-> mainFrame.showPanel("consultaAdeudoMenu"));
        btnRealizarPago.addActionListener(e -> {
            coordinadorAplicacion.seleccionarRealizarPago();
        });

        centralPanel.revalidate();
        centralPanel.repaint();
    }

    public void setPrestamos(List<PrestamoDTO> prestamos) {
        if (tableModel == null) return;

        tableModel.setRowCount(0);

        for (PrestamoDTO p : prestamos) {
            Object[] row = {
                    p.getIsbn(),
                    p.getTitulo(),
                    p.getFechaPrestamo(),
                    p.getFechaDevolucion()
            };
            tableModel.addRow(row);
        }
    }

    public void setAdeudo(double adeudo) {
        if (lblMontoTotal != null) {
            lblMontoTotal.setText(String.format("$ %.2f MXN", adeudo));
        }
    }

    static class RoundedPanel extends JPanel {
        private int cornerRadius = 15;
        private Color backgroundColor;

        public RoundedPanel(int radius, Color bgColor) {
            super();
            this.cornerRadius = radius;
            this.backgroundColor = bgColor;
            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Dimension arcs = new Dimension(cornerRadius, cornerRadius);
            int width = getWidth();
            int height = getHeight();
            Graphics2D graphics = (Graphics2D) g;
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            graphics.setColor(new Color(0,0,0,30));
            graphics.fillRoundRect(3, 3, width-3, height-3, arcs.width, arcs.height);
            graphics.setColor(backgroundColor);
            graphics.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);
        }
    }
}