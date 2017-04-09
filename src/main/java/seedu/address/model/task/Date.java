package seedu.address.model.task;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.commons.util.DateUtil;

/**
 * Represents a Date in the YTomorrow.
 */
public abstract class Date {

    public static final String MESSAGE_DATE_CONSTRAINTS = "Task date's format should resemble a date";

    public final String inputValue;
    public final java.util.Date value;

    /**
     * Validates given date.
     *
     * @throws IllegalValueException if given date string is invalid.
     */
    public Date(String date) throws IllegalValueException {
        //assert date != null;

        inputValue = date;

        if (date != null) {
            value = DateUtil.parse(date);
        } else {
            value = new java.util.Date();
        }
    }

    public java.util.Date getTime() {
        return value;
    }

    @Override
    public String toString() {
        if (inputValue != null) {
            return inputValue;
        } else {
            return value.toString();
        }
    }

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof Date
                        && this.value.equals(((Date) other).value));
    }
    //@@author A0164032U
    public static boolean isValidDate(String date) {
        return DateUtil.isValidDate(date);
    }

    @Override
    public int hashCode() {
        return inputValue.hashCode() * value.hashCode();
    }

}
