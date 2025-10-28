/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.solicitarBeca.panels;
import controlNavegacion.ControlNavegacion;
import dto.BecaDTO;
import dto.RequisitosDTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import presentacion.solicitarBeca.SolicitarBeca;
import presentacion.styles.Button;
import presentacion.styles.ComboBox;
import presentacion.styles.Label;
import presentacion.styles.Style;

/**
 *
 * @author katia
 */
public class ListadoBecasDisponiblesPanel extends PanelSolicitarBeca{
    private Label titulo;
    private JScrollPane scroll;
    private JPanel lista;
    private ComboBox<BecaDTO> ddlBecas;
    private Button btnSeleccionar;
    
    public ListadoBecasDisponiblesPanel(SolicitarBeca frame, ControlNavegacion controlNavegacion) {
        super(frame, controlNavegacion);
    }

    public void startComponents() {
        centralPanel.add(Box.createVerticalStrut(Style.TOP_ESPACIO));
        
        titulo = new Label("Becas Disponibles");
        titulo.setFont(Style.TITLE_FONT);
        titulo.setAlignmentX(CENTER_ALIGNMENT);
        centralPanel.add(titulo);
        centralPanel.add(Box.createVerticalStrut(Style.TITULO_ESPACIO));
        
        lista = new JPanel();
        lista.setOpaque(false);
        lista.setLayout(new BoxLayout(lista, BoxLayout.Y_AXIS));

        scroll = new JScrollPane(lista);
        scroll.setBorder(BorderFactory.createEmptyBorder());
        scroll.getViewport().setOpaque(false);
        scroll.setOpaque(false);
        scroll.setPreferredSize(new Dimension(980, 420));
        centralPanel.add(scroll);
        centralPanel.add(Box.createVerticalStrut(Style.BLOQUE_ESPACIO));

        ddlBecas = new ComboBox<>(new BecaDTO[]{}); // se va  a llenar con setBecas
        ddlBecas.setAlignmentX(CENTER_ALIGNMENT);
        ddlBecas.setMaximumSize(new Dimension(600, 60));
        centralPanel.add(ddlBecas);
        centralPanel.add(Box.createVerticalStrut(Style.LBL_ESPACIO));

        btnSeleccionar = new Button("Seleccionar");
        btnSeleccionar.setAlignmentX(CENTER_ALIGNMENT);
        centralPanel.add(btnSeleccionar);

        btnBack.addActionListener(e -> {
            mainFrame.showPanel("informacionGeneralPanel");
        });

        btnSeleccionar.addActionListener(e -> {
            //BecaDTO seleccionada = (BecaDTO) ddlBecas.getSelectedItem();
            //if (seleccionada == null) {
                //JOptionPane.showMessageDialog(this, "Selecciona una beca.", "Aviso", JOptionPane.WARNING_MESSAGE);
                //return;
           // }
            mainFrame.showPanel("detalleBecaPanel");
        });

    }
    
    public void setBecas(List<BecaDTO> becas) {
        lista.removeAll();
        if (becas != null && !becas.isEmpty()) {
            for (BecaDTO b : becas) {
                lista.add(crearItem(b));
                lista.add(Box.createVerticalStrut(16));
            }
        } else {
            lista.add(new Label("Lo siento. No hay becas disponibles para ti."));
        }
        lista.revalidate();
        lista.repaint();

        ddlBecas.setModel(new DefaultComboBoxModel<>(
                becas == null ? new BecaDTO[]{} : becas.toArray(new BecaDTO[0])
        ));
    }
    
    private JComponent crearItem(BecaDTO b) {
        JPanel card = new JPanel();
        card.setOpaque(false);
        card.setLayout(new BorderLayout());
        card.setMaximumSize(new Dimension(980, 100));
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(1,1,1,1,new Color(220,220,220)),
                BorderFactory.createEmptyBorder(12, 12, 12, 12)
        ));
        
        JLabel titul = new JLabel("<html><b>" + safe(b.getNombre()) + "</b>:</html>");
        titul.setFont(Style.LABEL_FONT);
        
        JLabel desc = new JLabel("<html>" + descripcionBeca(b) + "</html>");
        desc.setFont(Style.LABEL_FONT.deriveFont(Font.PLAIN, 20f));

        JPanel text = new JPanel();
        text.setOpaque(false);
        text.setLayout(new BoxLayout(text, BoxLayout.Y_AXIS));
        text.add(titul);
        text.add(Box.createVerticalStrut(6));
        text.add(desc);

        card.add(Box.createRigidArea(new Dimension(56, 56)), BorderLayout.WEST); // placeholder de icono
        card.add(text, BorderLayout.CENTER);
        return card;
    }
        
        private String safe(String s) { return s == null ? "" : s; }

    private String descripcionBeca(BecaDTO b) {
        RequisitosDTO r = b.getRequisitos();
        if (r == null) return "Está dirigida a estudiantes con buen desempeño académico.";
        StringBuilder sb = new StringBuilder("Está dirigida a estudiantes ");
        boolean pusoAlgo = false;

        if (r.getPromedioMinimo() > 0) {
            sb.append("con promedio ≥ ").append(r.getPromedioMinimo());
            pusoAlgo = true;
        }
        if (r.getIngresoFamiliarMaximo() > 0) {
            if (pusoAlgo) sb.append(", ");
            sb.append("ingreso familiar ≤ ").append((int) r.getIngresoFamiliarMaximo());
            pusoAlgo = true;
        }
        if (!pusoAlgo) sb.append("cuyo perfil cumple la convocatoria");

        sb.append(".");
        return sb.toString();
    }
}
