package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
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

    MediatorInterface btnEditMediator;
    MediatorInterface btnRemoveMediator;
    MediatorInterface btnFeatureMediator;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        btnEditMediator = new DisableOnMultiselectionMediator(btn_edit, item_list);
        btnRemoveMediator = new DisableOnNoSelectionMediator(btn_remove, item_list);
        btnFeatureMediator = new DisableOnAnySelectionMediator(btn_feature, item_list);

        obsList = FXCollections.observableArrayList (
                "Test1", "Test2", "Test3");
        obsList.add("Test4");
        item_list.setItems(obsList);
        obsList.add("Test5");

        item_list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

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

}






