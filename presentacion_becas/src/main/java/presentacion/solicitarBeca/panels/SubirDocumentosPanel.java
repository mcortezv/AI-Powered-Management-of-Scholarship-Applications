package presentacion.solicitarBeca.panels;

import presentacion.coordinadorAplicacion.CoordinadorAplicacion;
import presentacion.solicitarBeca.SolicitarBeca;
import presentacion.styles.Button;
import presentacion.styles.Label;
import presentacion.styles.Style;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SubirDocumentosPanel extends PanelSolicitarBeca {
    private Label titulo;
    private Button btnContinuar;
    private final Map<String, File> documentosCargados = new HashMap<>();
    private final CoordinadorAplicacion coordinadorAplicacion;
    private final String[] DOCUMENTOS_REQUERIDOS = {"CURP", "IDENTIFICACIÓN OFICIAL", "COMPROBANTE DE INSCRIPCIÓN", "KÁRDEX", "COMPROBANTE INGRESOS PADRE"};
    public SubirDocumentosPanel(SolicitarBeca frame, CoordinadorAplicacion coordinadorAplicacion) {
        super(frame, coordinadorAplicacion);
        this.coordinadorAplicacion = coordinadorAplicacion;
    }

    @Override
    public void startComponents() {
        centralPanel.setBackground(Style.PANEL_COLOR);
        centralPanel.setLayout(new BoxLayout(centralPanel, BoxLayout.Y_AXIS));

        titulo = new Label("Subir Documentos");
        titulo.setFont(Style.TITLE_FONT);
        titulo.setAlignmentX(CENTER_ALIGNMENT);
        centralPanel.add(titulo);
        centralPanel.add(Box.createVerticalStrut(Style.TITULO_ESPACIO));

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
        panelBotones.setBackground(Style.PANEL_COLOR);
        panelBotones.setMaximumSize(new Dimension(600, 600));
        panelBotones.setAlignmentX(CENTER_ALIGNMENT);

        for (String docName : DOCUMENTOS_REQUERIDOS) {
            panelBotones.add(createUploadSection(docName));
            panelBotones.add(Box.createVerticalStrut(15));
        }

        centralPanel.add(panelBotones);
        centralPanel.add(Box.createVerticalGlue());

        btnContinuar = new Button("Continuar");
        btnContinuar.setAlignmentX(Component.CENTER_ALIGNMENT);
        centralPanel.add(Box.createVerticalStrut(30));
        centralPanel.add(btnContinuar);

        btnBack.addActionListener(e -> mainFrame.showPanel("informacionSocioeconomicaPanel"));

        btnContinuar.addActionListener(e -> {
            if (documentosCargados.size() != DOCUMENTOS_REQUERIDOS.length) {
                JOptionPane.showMessageDialog(mainFrame, "Debe subir los " + DOCUMENTOS_REQUERIDOS.length + " documentos requeridos para continuar.", "Documentos faltantes", JOptionPane.WARNING_MESSAGE);
                return;
            }

            try {
                coordinadorAplicacion.procesarDocumentosYSolicitud(documentosCargados);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(mainFrame, "Error al procesar la solicitud: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    private JPanel createUploadSection(String docName) {
        JPanel sectionPanel = new JPanel();
        sectionPanel.setLayout(new BoxLayout(sectionPanel, BoxLayout.X_AXIS));
        sectionPanel.setBackground(Style.PANEL_COLOR);
        sectionPanel.setMaximumSize(new Dimension(600, 50));

        Button uploadButton = createUploadButton(docName);

        Button deleteButton = new Button("X");
        deleteButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setBackground(new Color(200, 50, 50));
        deleteButton.setVisible(false);
        deleteButton.setPreferredSize(new Dimension(50, 40));
        deleteButton.setMaximumSize(new Dimension(50, 40));

        deleteButton.addActionListener(e -> {
            documentosCargados.remove(docName);
            uploadButton.setText(docName);
            uploadButton.setBackground(Style.BUTTON_COLOR);
            uploadButton.setEnabled(true);
            deleteButton.setVisible(false);
        });

        sectionPanel.add(uploadButton);
        sectionPanel.add(Box.createHorizontalStrut(10));
        sectionPanel.add(deleteButton);

        uploadButton.addActionListener(e -> abrirFileChooser(uploadButton, deleteButton, docName));

        return sectionPanel;
    }

    private Button createUploadButton(String docName) {
        ImageIcon uploadIcon = null;
        try {
            uploadIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/assets/upload.png")));
            Image img = uploadIcon.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
            uploadIcon = new ImageIcon(img);
        } catch (Exception e) {
            System.err.println("No se pudo cargar el ícono: /assets/upload.png");
        }

        Button button = new Button(docName);
        if (uploadIcon != null) {
            button.setIcon(uploadIcon);
        }

        button.setFont(new Font("Segoe UI", Font.BOLD, 18));
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setIconTextGap(15);

        return button;
    }

    private void abrirFileChooser(Button uploadButton, Button deleteButton, String docName) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Selecciona tu " + docName);
        fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos PDF", "pdf"));

        int seleccion = fileChooser.showOpenDialog(this);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();
            documentosCargados.put(docName, archivoSeleccionado);

            uploadButton.setText(docName + " - " + archivoSeleccionado.getName() + " ✓");
            uploadButton.setBackground(new Color(220, 255, 220));
            uploadButton.setEnabled(false);
            deleteButton.setVisible(true);
        }
    }
}