package view;

import interface_adapter.ViewModelManager;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ViewManager implements PropertyChangeListener {
    private final CardLayout cardLayout;
    private final JPanel views;
    private ViewModelManager ViewModelManager;

    public ViewManager(JPanel views, CardLayout cardLayout, ViewModelManager ViewModelManager) {
        this.views = views;
        this.cardLayout = cardLayout;
        this.ViewModelManager = ViewModelManager;
        this.ViewModelManager.addPropertyChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("view")) {
            String viewModelName = (String) evt.getNewValue();
            cardLayout.show(views, viewModelName);
        }
    }

    public void clearPropertyChange(PropertyChangeEvent e) {
        if (e.getPropertyName().equals("clear")) {
            String viewModelName = (String) e.getNewValue();
            cardLayout.show(views, viewModelName);
        }
        System.out.println("test");
    }
}
