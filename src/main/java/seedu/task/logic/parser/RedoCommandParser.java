package seedu.task.logic.parser;

import static seedu.task.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.NoSuchElementException;

import seedu.task.logic.commands.AddCommand;
import seedu.task.logic.commands.Command;
import seedu.task.logic.commands.IncorrectCommand;
import seedu.task.logic.commands.RedoCommand;

//@@author A0163848R
/**
 * Parses input arguments and creates a new DeleteCommand object
 */
public class RedoCommandParser {

    /**
     * Parses the given {@code String} of arguments in the context of the RedoCommand
     * and returns an RedoCommand object for execution.
     */
    public Command parse(String args) {
        try {
            return new RedoCommand();
        } catch (NoSuchElementException nsee) {
            return new IncorrectCommand(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.MESSAGE_USAGE));
        }
    }

}
