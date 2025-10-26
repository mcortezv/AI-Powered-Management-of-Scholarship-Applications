/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.styles;
import java.awt.*;

/**
 *
 * @author Cortez, Manuel;
 */
public class Style {
    public static boolean DARK_MODE = false;
    public static final Color PANEL_COLOR = DARK_MODE ? new Color( 23, 23, 23) : Color.WHITE;
    public static final Color BACKGROUND_COLOR = DARK_MODE ? new Color(60, 60, 60) : Color.WHITE;
    public static final Color BUTTON_COLOR = DARK_MODE ? new Color(19, 21, 26) : new Color(33, 33, 33);
    public static final Color BUTTON_COLOR_HOVER = DARK_MODE ? new Color(23, 23, 23) : Color.DARK_GRAY;
    public static final Color TEXT_COLOR = DARK_MODE ? new Color(235, 235, 235) : new Color(33, 33, 33);
    public static final Color INPUT_COLOR = DARK_MODE ? new Color(55, 55, 58) : new Color(255, 255, 255);

    public static final Font TITLE_FONT = new Font("Segoe UI", Font.BOLD, 70);
    public static final Font LABEL_FONT = new Font("Segoe UI", Font.PLAIN, 25);
    public static final Font INPUT_FONT = new Font("Segoe UI", Font.PLAIN, 18);
    public static final Font BUTTON_FONT = new Font("Segoe UI", Font.BOLD, 18);

    public static final int TOP_ESPACIO = 30;
    public static final int TITULO_ESPACIO = 50;
    public static final int LBL_ESPACIO = 30;
    public static final int BLOQUE_ESPACIO = 40;
}