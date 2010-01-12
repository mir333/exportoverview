/*
 * GuiMain.java
 */

package cz.ligas.exportoverview.gui;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;

/**
 * The main class of the application.
 */
public class GuiMain extends SingleFrameApplication {

    /**
     * At startup create and show the main frame of the application.
     */
    @Override protected void startup() {
        show(MainView.getInstance(this));
    }

    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override protected void configureWindow(java.awt.Window root) {
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of GuiMain
     */
    public static GuiMain getApplication() {
        return Application.getInstance(GuiMain.class);
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args) {
        Handler fh;
        try {
            fh = new FileHandler("log/app.log");
             Logger.getLogger("").addHandler(fh);
        } catch (Exception ex) {
            Logger.getLogger(GuiMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        launch(GuiMain.class, args);
    }
}
