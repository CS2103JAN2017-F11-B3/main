package seedu.task.commons.events.ui;

import java.io.File;

import seedu.task.commons.events.BaseEvent;
import seedu.task.model.ReadOnlyTaskManager;

//@@author A0164466X
/**
 * Represents a request to export the stored YTomorrow task file.
 */
//@@author A0163848R
public class ExportRequestEvent extends BaseEvent {

    private ReadOnlyTaskManager toExport;
    private File target;

    public ExportRequestEvent(ReadOnlyTaskManager toExport, File target) {
        this.toExport = toExport;
        this.target = target;
    }

    public ReadOnlyTaskManager getYTomorrowToExport() {
        return toExport;
    }

    public File getTargetFile() {
        return target;
    }

    @Override
    public String toString() {
        return "Exported YTomorrow: " + target.toString();
    }

}