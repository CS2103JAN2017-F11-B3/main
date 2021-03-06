package guitests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import seedu.address.testutil.TestPerson;
import seedu.task.commons.core.Messages;

public class FindCommandTest extends AddressBookGuiTest {

    @Test
    public void findNonEmptyList() {
        assertFindResult("find Mark"); // no results
        assertFindResult("find Meier", td.benson, td.daniel); // multiple results

        //find after deleting one result
        commandBox.runCommand("delete 1");
        assertFindResult("find Meier", td.daniel);
    }

    @Test
    public void findEmptyList() {
        commandBox.runCommand("clear all");
        assertFindResult("find Jean"); // no results
    }

    @Test
    public void findInvalidCommandFail() {
        commandBox.runCommand("findgeorge");
        assertResultMessage(Messages.MESSAGE_UNKNOWN_COMMAND);
    }

    private void assertFindResult(String command, TestPerson... expectedHits) {
        commandBox.runCommand(command);
        assertListSize(expectedHits.length);
        assertResultMessage(expectedHits.length + " tasks listed!");
        assertTrue(personListPanel.isListMatching(expectedHits));
    }
}
