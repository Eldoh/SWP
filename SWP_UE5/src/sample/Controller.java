package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    ObservableList<String> obsList;
    int newNumber = 6;

    @FXML
    private ListView<String> item_list;

    @FXML
    private Button btn_edit;

    @FXML
    private Button btn_remove;

    @FXML
    private Button btn_add;

    @FXML
    private Button btn_feature;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        obsList = FXCollections.observableArrayList (
                "Test1", "Test2", "Test3");
        obsList.add("Test4");
        item_list.setItems(obsList);
        obsList.add("Test5");

        item_list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        item_list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                selectionChanged();
            }
        });
        item_list.getSelectionModel().select(0);
    }

    public void add(){
        obsList.add("Test"+newNumber);
        newNumber++;

        item_list.getSelectionModel().clearSelection();
        item_list.getSelectionModel().selectLast();
    }

    public void remove(){
        ObservableList<String> toDel = item_list.getSelectionModel().getSelectedItems();
            obsList.removeAll(toDel);
            item_list.getSelectionModel().clearSelection();
            item_list.getSelectionModel().selectFirst();
    }

    public void featureAction(){
        for(int i=0; i<5; i++){
            add();
        }
    }

    public void selectionChanged(){
        int selectedItemNumber = item_list.getSelectionModel().getSelectedItems().size();
        switch(selectedItemNumber){
            case 0:
                btn_edit.setDisable(true);
                btn_remove.setDisable(true);
                btn_feature.setDisable(false);
                break;

            case 1:
                btn_edit.setDisable(false);
                btn_remove.setDisable(false);
                btn_feature.setDisable(true);
                break;

            default:
                btn_edit.setDisable(true);
                btn_remove.setDisable(false);
                btn_feature.setDisable(true);
                break;
        }

    }





}
