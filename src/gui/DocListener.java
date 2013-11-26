package gui;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 20111375
 * Date: 23/11/2013
 * Time: 08:39
 */
public class DocListener implements DocumentListener {
    private List<JFormattedTextField> objectList = new ArrayList<JFormattedTextField>();
    private JButton btn;

    /**
     * @return gets a collection of formatted text field objects
     */
    public List<JFormattedTextField> getObjectList() {
        return objectList;
    }

    /**
     * @param objectList defines a list of formatted text field objects
     */
    public void setObjectList(List<JFormattedTextField> objectList) {
        this.objectList = objectList;
    }

    /**
     * @return gets a button of type jbutton
     */
    public JButton getBtn() {
        return btn;
    }

    /**
     * @param btn sets a button of type jbutton
     */
    public void setBtn(JButton btn) {
        this.btn = btn;
    }

    /**
     * @param e accepts document events after checked updates
     */
    public void changedUpdate(DocumentEvent e) {
        checkContent(this.btn, this.objectList);
    }

    /**
     * @param e accepts document events after insert updates
     */
    public void insertUpdate(DocumentEvent e) {
        checkContent(this.btn, this.objectList);
    }

    /**
     * @param e accepts document events after remove updates
     */
    public void removeUpdate(DocumentEvent e) {
        checkContent(this.btn, this.objectList);
    }

    /**
     * @param btn       accepts a jbutton as input and registers formatted text fields to it
     * @param fieldList accepts a collection of formatted text fields
     *                  set a button to listen to a list of text fields (default set to disabled)
     */
    private void checkContent(JButton btn, List<JFormattedTextField> fieldList) {
        for (JFormattedTextField field : fieldList) {
            if (field.getText().trim().isEmpty()) {
                btn.setEnabled(false);
                return;
            }
        }
        btn.setEnabled(true);
    }
}