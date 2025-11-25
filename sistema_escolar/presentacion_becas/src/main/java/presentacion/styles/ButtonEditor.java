package presentacion.styles;

import presentacion.pagarAdeudo.PagarAdeudo;
import presentacion.pagarAdeudo.coordinadorAplicacionPagarAdeudo.CoordinadorAplicacionPagarAdeudo;
import presentacion.solicitarBeca.panels.enums.PanelCategory;

import javax.swing.*;
import java.awt.*;

public class ButtonEditor extends DefaultCellEditor {

    private final PagarAdeudo owner;
    private final JButton button;
    private final PanelCategory category;
    private final CoordinadorAplicacionPagarAdeudo coordinador;
    private boolean isPushed;

    public ButtonEditor(
            JCheckBox checkBox,
            PagarAdeudo owner,
            PanelCategory category,
            CoordinadorAplicacionPagarAdeudo coordinador
    ) {
        super(checkBox);

        this.owner = owner;
        this.category = category;
        this.coordinador = coordinador;

        button = new JButton("≡");
        button.setFont(new Font("SansSerif", Font.PLAIN, 24));
        button.setBackground(new Color(60, 63, 83));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder());

        button.addActionListener(e -> {
            if (isPushed) {
                switch (category) {

                    case LISTA_PRESTAMOS ->
                            owner.showPanel("listaPrestamosBiblioteca");

                    case LISTA_CLASES ->
                            owner.showPanel("listaClasesColegiatura");

                    default ->
                            System.out.println("Categoría sin implementar");
                }
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(
            JTable table, Object value, boolean isSelected, int row, int column
    ) {
        isPushed = true;
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        isPushed = false;
        return null;
    }
}
