package seedu.address.ui;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import seedu.address.commons.events.ui.PersonPanelSelectionChangedEvent;
import seedu.address.commons.util.FxViewUtil;
import seedu.address.model.task.ReadOnlyPerson;

//@@author A0164889E
/**
 * Panel containing the list of persons.
 */
public class PersonListPanelComplete extends UiPart<Region> {
    private static final String FXML = "PersonListPanelComplete.fxml";

    @FXML
    private ListView<ReadOnlyPerson> personListViewComplete;

    public PersonListPanelComplete(AnchorPane personListCompletePlaceholder, ObservableList<ReadOnlyPerson> personList) {
        super(FXML);
        setConnections(personList);
        addToPlaceholder(personListCompletePlaceholder);
    }

    private void setConnections(ObservableList<ReadOnlyPerson> personList) {
        personListViewComplete.setItems(personList);
        personListViewComplete.setCellFactory(listView -> new PersonListViewCellComplete());
        setEventHandlerForSelectionChangeEvent();
    }

    private void addToPlaceholder(AnchorPane placeHolderPane) {
        SplitPane.setResizableWithParent(placeHolderPane, false);
        FxViewUtil.applyAnchorBoundaryParameters(getRoot(), 0.0, 0.0, 0.0, 0.0);
        placeHolderPane.getChildren().add(getRoot());
    }

    private void setEventHandlerForSelectionChangeEvent() {
        personListViewComplete.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        LOGGER.fine("Selection in person list panel changed to : '" + newValue + "'");
                        raise(new PersonPanelSelectionChangedEvent(newValue));
                    }
                });
    }

    public void scrollTo(int index) {
        Platform.runLater(() -> {
            personListViewComplete.scrollTo(index);
            personListViewComplete.getSelectionModel().clearAndSelect(index);
        });
    }

    class PersonListViewCellComplete extends ListCell<ReadOnlyPerson> {

        @Override
        protected void updateItem(ReadOnlyPerson person, boolean empty) {
            super.updateItem(person, empty);

            if (empty || person == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new PersonCardComplete(person, getIndex() + 1).getRoot());
            }
        }
    }

}