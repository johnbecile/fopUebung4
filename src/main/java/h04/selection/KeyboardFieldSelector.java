package h04.selection;

import fopbot.*;

import java.awt.*;

/**
 * Keyboard field selector, a field selector that selects a field of the keyboard when pressed on.
 */
public class KeyboardFieldSelector implements FieldSelector, KeyPressListener {

    private FieldSelectionListener listener;
    private int counter = 0;
    private Field markedField = null;

    /**
     * Sets field selection listener.
     *
     * @param listener the listener
     */
    @Override
    public void setFieldSelectionListener(FieldSelectionListener listener) {
        this.listener = listener;
    }


    /**
     * Notifies this key press listener about the given key press event.
     *
     * @param event the key press event
     */
    @Override
    public void onKeyPress(KeyPressEvent event) {
        if (counter == 0) {
            event.getWorld().getField(0, 0).setFieldColor(Color.RED);
            markedField = event.getWorld().getField(0, 0);
            counter++;
        }
        if ((markedField != null) && (
            (event.getKey() == Key.UP) || (event.getKey() == Key.DOWN) || (event.getKey() == Key.LEFT) || (event.getKey() == Key.RIGHT)
        )) {
            myRoll(event.getKey());
        }
        if (markedField != null && event.getKey() == Key.SPACE) {
            listener.onFieldSelection(markedField);
        }
    }

    private void myRoll(Key key) {
        markedField.setFieldColor(null);
        if (key == Key.UP) {
            if (markedField.getY() != markedField.getWorld().getHeight()) {
                markedField = markedField.getWorld().getField(markedField.getX(), markedField.getY() + 1);
            } else {
                markedField = markedField.getWorld().getField(markedField.getX(), 0);
            }
        }
        if (key == Key.DOWN) {
            if (markedField.getY() != 0) {
                markedField = markedField.getWorld().getField(markedField.getX(), markedField.getY() - 1);
            } else {
                markedField = markedField.getWorld().getField(markedField.getX(), markedField.getWorld().getHeight());
            }
        }
        if (key == Key.LEFT) {
            if (markedField.getX() != 0) {
                markedField = markedField.getWorld().getField(markedField.getX() - 1, markedField.getY());
            } else {
                markedField = markedField.getWorld().getField(markedField.getWorld().getWidth(), markedField.getY());
            }
        }
        if (key == Key.RIGHT) {
            if (markedField.getX() != markedField.getWorld().getWidth()) {
                markedField = markedField.getWorld().getField(markedField.getX() + 1, markedField.getY());
            } else {
                markedField = markedField.getWorld().getField(0, markedField.getY());
            }
        }
        markedField.setFieldColor(Color.RED);
    }

    /**
     * Instantiates a new keyboard field selector, registers the central input handler.
     */
    public KeyboardFieldSelector() {
        World.addKeyPressListener(this);
    }
}
