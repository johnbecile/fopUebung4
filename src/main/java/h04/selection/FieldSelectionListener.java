package h04.selection;

import fopbot.Field;

/**
 * Interface Field selection listener.
 */
public interface FieldSelectionListener {
    /**
     * Called by a field selector when a field has been selected using this field
     * selector, with this same field being used as the current parameter.
     *
     * @param field the field
     */
    public void onFieldSelection(Field field);
}
