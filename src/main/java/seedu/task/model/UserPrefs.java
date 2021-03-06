package seedu.task.model;

import java.util.Objects;

import seedu.task.commons.core.GuiSettings;
import seedu.task.ui.Theme;

/**
 * Represents User's preferences.
 */
public class UserPrefs {

    public GuiSettings guiSettings;

    public GuiSettings getGuiSettings() {
        return guiSettings == null ? new GuiSettings() : guiSettings;
    }

    public void updateLastUsedGuiSetting(GuiSettings guiSettings) {
        this.guiSettings = guiSettings;
    }

    public UserPrefs() {
        this.setGuiSettings(500, 500, 0, 0, Theme.DEFAULT_STYLESHEET, null);
    }

    public void setGuiSettings(
            double width,
            double height,
            int x,
            int y,
            String styleSheet,
            String lastLoadedYTomorrow) {
        guiSettings = new GuiSettings(width, height, x, y, styleSheet, lastLoadedYTomorrow);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof UserPrefs)) { //this handles null as well.
            return false;
        }

        UserPrefs o = (UserPrefs) other;

        return Objects.equals(guiSettings, o.guiSettings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guiSettings);
    }

    @Override
    public String toString() {
        return guiSettings.toString();
    }

}
