/* @@author A0164889E */
package seedu.task.model.task;

import seedu.task.commons.exceptions.IllegalValueException;

/**
 * Represents a Task's group in the Task Manager.
 * Guarantees: immutable; is valid as declared in {@link #isValidGroup(String)}
 */
public class Group {

    public static final String GROUP_ID_HIDDEN = "__NO_GROUP__";
    public static final String MESSAGE_GROUP_CONSTRAINTS =
            "Task group can take any values, and it should not be blank";

    /*
     * The first character of the group must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String GROUP_VALIDATION_REGEX = "[^\\s].*";

    public final String value;

    /**
     * Validates given group.
     *
     * @throws IllegalValueException if given group string is invalid.
     */
    public Group(String group) throws IllegalValueException {
        assert group != null;
        if (!isValidGroup(group)) {
            throw new IllegalValueException(MESSAGE_GROUP_CONSTRAINTS);
        }
        this.value = group;
    }

    /**
     * Returns true if a given string is a valid group.
     */
    public static boolean isValidGroup(String test) {
        return test.matches(GROUP_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Group // instanceof handles nulls
                && this.value.equals(((Group) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
