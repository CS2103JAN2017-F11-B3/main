package seedu.address.model.task;

import java.util.Objects;

import seedu.address.commons.util.CollectionUtil;
import seedu.address.model.tag.UniqueTagList;

/**
 * Represents a Person in the address book.
 * Guarantees: details are present and not null, field values are validated.
 */
public class Task implements ReadOnlyPerson {

    private Name name;
    private Date date;
    private Email email;
    private Group group;

    private UniqueTagList tags;

    /**
     * Every field must be present and not null.
     */
    public Task(Name name, Date date, Email email, Group group, UniqueTagList tags) {
        assert !CollectionUtil.isAnyNull(name, date, email, group, tags);
        this.name = name;
        this.date = date;
        this.email = email;
        this.group = group;
        this.tags = new UniqueTagList(tags); // protect internal tags from changes in the arg list
    }

    /**
     * Creates a copy of the given ReadOnlyPerson.
     */
    public Task(ReadOnlyPerson source) {
        this(source.getName(), source.getDate(), source.getEmail(), source.getGroup(), source.getTags());
    }

    public void setName(Name name) {
        assert name != null;
        this.name = name;
    }

    @Override
    public Name getName() {
        return name;
    }

    public void setDate(Date date) {
        assert date != null;
        this.date = date;
    }

    @Override
    public Date getDate() {
        return date;
    }

    public void setEmail(Email email) {
        assert email != null;
        this.email = email;
    }

    @Override
    public Email getEmail() {
        return email;
    }

    public void setGroup(Group group) {
        assert group != null;
        this.group = group;
    }

    @Override
    public Group getGroup() {
        return group;
    }

    @Override
    public UniqueTagList getTags() {
        return new UniqueTagList(tags);
    }

    /**
     * Replaces this person's tags with the tags in the argument tag list.
     */
    public void setTags(UniqueTagList replacement) {
        tags.setTags(replacement);
    }

    /**
     * Updates this person with the details of {@code replacement}.
     */
    public void resetData(ReadOnlyPerson replacement) {
        assert replacement != null;

        this.setName(replacement.getName());
        this.setDate(replacement.getDate());
        this.setEmail(replacement.getEmail());
        this.setGroup(replacement.getGroup());
        this.setTags(replacement.getTags());
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ReadOnlyPerson // instanceof handles nulls
                && this.isSameStateAs((ReadOnlyPerson) other));
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, date, email, group, tags);
    }

    @Override
    public String toString() {
        return getAsText();
    }

}