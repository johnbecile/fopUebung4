package h04.selection;

import fopbot.Field;
import fopbot.FieldClickEvent;
import fopbot.FieldClickListener;
import fopbot.World;

/**
 * Mouse field selector, a field selector that selects a field of the mouse when clicked on.
 */
public class MouseFieldSelector implements FieldSelector, FieldClickListener {

    private FieldSelectionListener listener;
    private Field field = null;

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
     * Notifies this field click listener about the given field click event.
     *
     * @param event the field click event
     */
    @Override
    public void onFieldClick(FieldClickEvent event) {
        if (field == null) {
            field = event.getField();
        } else if (event.getField() == field) {
            listener.onFieldSelection(event.getField());
            field = null;
        }
    }

    /**
     * Instantiates a new mouse field selector, registers the central input handler.
     */
    public MouseFieldSelector() {
        World.addFieldClickListener(this);
    }
}
