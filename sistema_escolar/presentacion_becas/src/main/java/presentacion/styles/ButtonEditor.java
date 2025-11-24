package presentacion.styles;

import presentacion.pagarAdeudo.*;
import presentacion.pagarAdeudo.panels.ListaClasesColegiatura;
import presentacion.pagarAdeudo.panels.ListaPrestamosBiblioteca;
import presentacion.solicitarBeca.panels.enums.PanelCategory;

import javax.swing.*;
import java.awt.*;

public class ButtonEditor extends DefaultCellEditor{
    private PagarAdeudo owner;
    private JButton button;
    private PanelCategory category;
    private boolean isPushed;
    private int currentRow;
    private int id;

    public ButtonEditor(JCheckBox checkBox, PagarAdeudo owner, PanelCategory category, JPanel previous) {
        super(checkBox);
        this.owner = owner;
        this.category = category;
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
//                    case LISTA_PRESTAMOS -> owner.showPanel(new ListaPrestamosBiblioteca(owner));
//                    case LISTA_CLASES   -> owner.showPanel(new ListaClasesColegiatura(owner));
                }

            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.currentRow = row;
        this.isPushed = true;
        int id = (int) table.getValueAt(row, table.getColumnModel().getColumnIndex("Id"));
        this.id = id;
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        isPushed = false;
        return null;
    }
}