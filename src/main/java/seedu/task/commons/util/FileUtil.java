package seedu.task.commons.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

/**
 * Writes and reads files
 */
public class FileUtil {

    private static final String CHARSET = "UTF-8";

    public static boolean isFileExists(File file) {
        return file.exists() && file.isFile();
    }

    public static void createIfMissing(File file) throws IOException {
        if (!isFileExists(file)) {
            createFile(file);
        }
    }

    /**
     * Creates a file if it does not exist along with its missing parent directories
     *
     * @return true if file is created, false if file already exists
     */
    public static boolean createFile(File file) throws IOException {
        if (file.exists()) {
            return false;
        }

        createParentDirsOfFile(file);

        return file.createNewFile();
    }

    /**
     * Creates the given directory along with its parent directories
     *
     * @param dir the directory to be created; assumed not null
     * @throws IOException if the directory or a parent directory cannot be created
     */
    public static void createDirs(File dir) throws IOException {
        if (!dir.exists() && !dir.mkdirs()) {
            throw new IOException("Failed to make directories of " + dir.getName());
        }
    }

    /**
     * Creates parent directories of file if it has a parent directory
     */
    public static void createParentDirsOfFile(File file) throws IOException {
        File parentDir = file.getParentFile();

        if (parentDir != null) {
            createDirs(parentDir);
        }
    }

    /**
     * Assumes file exists
     */
    public static String readFromFile(File file) throws IOException {
        return new String(Files.readAllBytes(file.toPath()), CHARSET);
    }

    /**
     * Writes given string to a file.
     * Will create the file if it does not exist yet.
     */
    public static void writeToFile(File file, String content) throws IOException {
        Files.write(file.toPath(), content.getBytes(CHARSET));
    }

    /**
     * Converts a string to a platform-specific file path
     * @param pathWithForwardSlash A String representing a file path but using '/' as the separator
     * @return {@code pathWithForwardSlash} but '/' replaced with {@code File.separator}
     */
    public static String getPath(String pathWithForwardSlash) {
        assert pathWithForwardSlash != null;
        assert pathWithForwardSlash.contains("/");
        return pathWithForwardSlash.replace("/", File.separator);
    }

    //@@author A0163848R
    /**
     * Creates a localized window to create a file for saving.
     * @param Window title
     * @param File extension filters
     * @return Chosen file
     */
    public static File promptSaveFileDialog(String title, Stage stage, ExtensionFilter ...extensionFilters) {
        FileChooser prompt =  getFileChooser(title, extensionFilters);
        File saved = prompt.showSaveDialog(stage);
        if (!saved.getName().contains(".")) {
            saved = new File(saved.getAbsolutePath()
                  + prompt.getSelectedExtensionFilter().getExtensions().get(0).substring(1));
        }
        return saved;
    }

    /**
     * Creates a localized window to select a file for loading.
     * @param Window title
     * @param File extension filters
     * @return Chosen file
     */
    public static File promptOpenFileDialog(String title, Stage stage, ExtensionFilter ...extensionFilters) {
        return getFileChooser(title, extensionFilters).showOpenDialog(stage);
    }

    /**
     * Returns a new file chooser prompt
     * @param Title of prompt
     * @param Extension filters to allow for writing/reading
     * @return New file chooser prompt
     */
    private static FileChooser getFileChooser(String title, ExtensionFilter ...extensionFilters) {
        FileChooser fileChooser = new FileChooser();

        fileChooser.setTitle(title);
        fileChooser.getExtensionFilters().addAll(extensionFilters);

        return fileChooser;
    }
}
