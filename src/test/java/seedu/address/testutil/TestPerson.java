package seedu.address.testutil;

import seedu.task.model.tag.UniqueTagList;
import seedu.task.model.task.EndDate;
import seedu.task.model.task.Group;
import seedu.task.model.task.Name;
import seedu.task.model.task.ReadOnlyTask;
import seedu.task.model.task.StartDate;

/**
 * A mutable person object. For testing only.
 */
//@@author A0164032U
public class TestPerson implements ReadOnlyTask {

    private Name name;
    private Group group;
    private StartDate start;
    private EndDate end;
    private UniqueTagList tags;

    public TestPerson() {
        start = null;
        end = null;
        tags = new UniqueTagList();
    }

    /**
     * Creates a copy of {@code personToCopy}.
     */
    public TestPerson(TestPerson personToCopy) {
        this.name = personToCopy.getName();
        this.start = personToCopy.getStartDate();
        this.end = personToCopy.getEndDate();
        this.group = personToCopy.getGroup();
        this.tags = personToCopy.getTags();
    }

    public void setName(Name name) {
        this.name = name;
    }

    public void setGroup(Group group) {
        assert group != null;
        this.group = group;
    }

    //@@author A0164032U
    public void setStartDate(StartDate start) {
        this.start = start;
    }

    public void setEndDate(EndDate end) {
        this.end = end;
    }

    public void setTags(UniqueTagList tags) {
        this.tags = tags;
    }

    @Override
    public Name getName() {
        return name;
    }

    //author A0164032U
    @Override
    public StartDate getStartDate() {
        return start;
    }

    @Override
    public EndDate getEndDate() {
        return end;
    }

    @Override
    public Group getGroup() {
        return group;
    }

    @Override
    public UniqueTagList getTags() {
        return new UniqueTagList(tags);
    }

    @Override
    public String toString() {
        return getAsText();
    }

    public String getAddCommand() {
        StringBuilder sb = new StringBuilder();
        sb.append("add " + this.getName().fullName + " ");
        sb.append("from " + this.getStartDate().getInputValue() + " ");
        sb.append("to " + this.getEndDate().getInputValue() + " ");
        sb.append("in " + this.getGroup().value + " ");
        return sb.toString();
    }

    @Override
    public boolean hasPassed() {
        return false;
    }

    @Override
    public java.util.Date getEndTime() {
        if (end != null) {
            return end.getTime();
        }
        return new java.util.Date(Long.MAX_VALUE);
    }

    @Override
    public java.util.Date getStartTime() {
        return null;
    }
}
