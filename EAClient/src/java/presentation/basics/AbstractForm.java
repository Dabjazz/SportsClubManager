/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.basics;

import java.beans.EventHandler;
import javax.swing.JFrame;

/**
 *
 * @author Lucia
 */
public class AbstractForm extends JFrame{
    
    public AbstractForm parent;
    EventHandler eventHandler;
    
    public AbstractForm() {
        this(null);
    }

    public AbstractForm(AbstractForm parent) {
        this.parent = parent;
        initControls();
    }
    
    private void initControls() {
        //TODO: basic windoweventhandler+ windowlistener
        
    }
    
    public void showForm() {
        this.setVisible(true);
        this.setTitle("SportsClubManager");
    }

    public void refresh() {
        if (parent != null) {
            parent.refresh();
        }
    }
}