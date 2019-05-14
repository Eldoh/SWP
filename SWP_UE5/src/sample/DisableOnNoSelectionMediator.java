package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import javax.swing.event.ChangeEvent;

public class DisableOnNoSelectionMediator implements MediatorInterface, ChangeListener {

    private Button btn;
    private ListView listView;

    public DisableOnNoSelectionMediator(Button btn, ListView listView){
        this.btn = btn;
        this.listView = listView;
        listView.getSelectionModel().selectedItemProperty().addListener(this);
    }

    @Override
    public void onSelect() {
        int selectedItems = listView.getSelectionModel().getSelectedItems().size();
        if(selectedItems == 0){
            btn.setDisable(true);
        }else{
            btn.setDisable(false);
        }
    }

    @Override
    public void changed(ObservableValue observable, Object oldValue, Object newValue) {
      onSelect();
    }
}
