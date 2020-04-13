package com.mycompany.we3;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * The MenuListener class monitors menus of background and foreground color
 * options and change the color of the background/foreground when a user selects
 * an option
 * @author Ziyu Guo
 * @version 12 April 2020
 */

public class MenuListener implements ActionListener {

    public static final int BG_MODE = 0;
    public static final int FG_MODE = 1;

    private final int mode;
    private final String prefix;
    private final List<Color> palette;
    private final SwingPanel panel;

    /**
     * input mode,prefix,palette,panel
     * @param mode
     * @param prefix
     * @param palette
     * @param panel
     */
    public MenuListener(int mode, String prefix, List<Color> palette,
            SwingPanel panel) {
        this.mode = mode;
        this.prefix = prefix;
        this.palette = palette;
        this.panel = panel;
    } // MenuListener()

    /**
     * Change the color of the background or foreground in the panel
     *  depending on the user's selection.
     * @param event
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        String actionCommand = event.getActionCommand();

        if (actionCommand.contains(this.prefix)) {
            int i = this.prefix.length();
            String suffix = actionCommand.substring(i).trim();
            int index = Integer.parseInt(suffix);

            if (this.mode == MenuListener.BG_MODE) {
                this.panel.setBackground(this.palette.get(index));
            } // if
            else if (this.mode == MenuListener.FG_MODE) {
                this.panel.setColor(this.palette.get(index));
            } // else if
        } // if
    } // actionPerformed( ActionEvent )
} // MenuListener
