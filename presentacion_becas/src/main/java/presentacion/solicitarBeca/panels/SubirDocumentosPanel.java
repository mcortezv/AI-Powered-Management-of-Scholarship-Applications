package presentacion.solicitarBeca.panels;
import controlNavegacion.ControlNavegacion;
import dto.BecaDTO;
import dto.HistAcademicoDTO;
import dto.InformacionSocioeconomicaDTO;
import dto.SolicitudDTO;
import dto.TutorDTO;
import enums.Parentesco;
import presentacion.solicitarBeca.SolicitarBeca;
import presentacion.styles.Button;
import presentacion.styles.Label;
import presentacion.styles.Style;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SubirDocumentosPanel extends PanelSolicitarBeca {
    private Label titulo;
    private Button btnSiguiente;
    private Map<String, File> documentosCargados = new HashMap<>();
    private Button btnContinuar;
    private ControlNavegacion controlNavegacion;
    
    public SubirDocumentosPanel(SolicitarBeca frame, ControlNavegacion controlNavegacion) {
        super(frame, controlNavegacion);
        this.controlNavegacion= controlNavegacion;
        
    }

    @Override
    public void startComponents() {
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


        panelBotones.add(createUploadButton("CURP"));
        panelBotones.add(Box.createVerticalStrut(15));
        panelBotones.add(createUploadButton("IDENTIFICACIÓN OFICIAL"));
        panelBotones.add(Box.createVerticalStrut(15));
        panelBotones.add(createUploadButton("COMPROBANTE DE INSCRIPCIÓN"));
        panelBotones.add(Box.createVerticalStrut(15));
        panelBotones.add(createUploadButton("KÁRDEX"));
        panelBotones.add(Box.createVerticalStrut(15));
        panelBotones.add(createUploadButton("COMPROBANTE INGRESOS PADRE"));

        centralPanel.add(panelBotones);
        centralPanel.add(Box.createVerticalGlue());
        btnContinuar = new Button("Continuar");
        btnContinuar.setAlignmentX(Component.CENTER_ALIGNMENT);
        centralPanel.add(btnContinuar, BorderLayout.CENTER);

        btnBack.addActionListener(e -> {
            mainFrame.showPanel("informacionSocioeconomicaPanel");
        });

        btnContinuar.addActionListener(e -> {
            BecaDTO becaDTO= controlNavegacion.obtenerBecaSeleccionadaDTO();
            InformacionSocioeconomicaDTO infoSocioeconomicaDTO= controlNavegacion.obtenerInfoSocioeconomicaDTO();
            HistAcademicoDTO historialAcademicoDTO = controlNavegacion.obtenerHistAcademico();
            
            
            
           SolicitudDTO solicitudDTO= new SolicitudDTO(becaDTO, infoSocioeconomicaDTO, historialAcademicoDTO);

           controlNavegacion.setSolicitud(solicitudDTO);
            controlNavegacion.mostrarResumen();
        });
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

        button.setFont(new Font("Segoe UI", Font.BOLD, 20));
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setIconTextGap(20);

        button.addActionListener(e -> {
            abrirFileChooser(button, docName);
        });

        return button;
    }

    private void abrirFileChooser(Button button, String docName) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Selecciona tu " + docName);

        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "PDF", "pdf");
        fileChooser.setFileFilter(filter);

        int seleccion = fileChooser.showOpenDialog(this);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();

            documentosCargados.put(docName, archivoSeleccionado);

            button.setText(docName + " - " + archivoSeleccionado.getName() + " ✓");
            button.setBackground(new Color(220, 255, 220));
            button.setEnabled(false);

            if (documentosCargados.size() == 5) {
                btnSiguiente.setEnabled(true);
            }
        }
    }
}