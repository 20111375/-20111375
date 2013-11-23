package gui;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: andrew
 * Date: 23/11/2013
 * Time: 08:39
 * To change this template use File | Settings | File Templates.
 */
public class DocListener implements DocumentListener {
    public List<JFormattedTextField> getObjectList() {
        return objectList;
    }

    public void setObjectList(List<JFormattedTextField> objectList) {
        this.objectList = objectList;
    }

    public JButton getBtn() {
        return btn;
    }

    public void setBtn(JButton btn) {
        this.btn = btn;
    }

    private List<JFormattedTextField> objectList = new ArrayList<JFormattedTextField>();
    private JButton btn;

    public void changedUpdate(DocumentEvent e) {
        checkContent(this.btn, this.objectList);
    }

    public void insertUpdate(DocumentEvent e) {
        checkContent(this.btn, this.objectList);
    }

    public void removeUpdate(DocumentEvent e) {
        checkContent(this.btn, this.objectList);
    }

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