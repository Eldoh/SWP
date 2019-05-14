package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class DisableOnAnySelectionMediator implements MediatorInterface, ChangeListener {

    private Button btn;
    private ListView listView;

    public DisableOnAnySelectionMediator(Button btn, ListView listView){
        this.btn = btn;
        this.listView = listView;
        listView.getSelectionModel().selectedItemProperty().addListener(this);
    }

    @Override
    public void onSelect() {
        int selectedItems = listView.getSelectionModel().getSelectedItems().size();
        if(selectedItems == 0){
            btn.setDisable(false);
        }else{
            btn.setDisable(true);
        }
    }

    @Override
    public void changed(ObservableValue observable, Object oldValue, Object newValue) {
        onSelect();
    }
}
