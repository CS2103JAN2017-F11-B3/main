package seedu.task.logic.parser;

import static seedu.task.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.NoSuchElementException;

import seedu.task.logic.commands.Command;
import seedu.task.logic.commands.DeleteCommand;
import seedu.task.logic.commands.IncorrectCommand;

/**
 * Parses input arguments and creates a new DeleteCommand object
 */
public class DeleteCommandParser {

    /**
     * Parses the given {@code String} of arguments in the context of the DeleteCommand
     * and returns an DeleteCommand object for execution.
     */
    public Command parse(String args) {

        //@@author A0163848R
        ArgumentTokenizer argsTokenizer =
                new ArgumentTokenizer();
        argsTokenizer.tokenize(args);
        //@@author

        try {
            return new DeleteCommand(argsTokenizer.getPreamble().get());
        } catch (NoSuchElementException nsee) {
            return new IncorrectCommand(String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteCommand.MESSAGE_USAGE));
        }
    }

}