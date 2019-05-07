package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class BtnRemoveMediator implements MediatorInterface{

    private Button btn;

    public BtnRemoveMediator(Button btn){
        this.btn = btn;
    }

    @Override
    public void onSelect(int selectedItems) {
        if(selectedItems == 0){
            btn.setDisable(true);
        }else{
            btn.setDisable(false);
        }
    }
}
