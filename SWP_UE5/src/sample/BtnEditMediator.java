package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class BtnEditMediator implements MediatorInterface{

    private Button btn;

    public BtnEditMediator(Button btn){
        this.btn = btn;
    }

    @Override
    public void onSelect(int selectedItems){
        if(selectedItems == 1){
            btn.setDisable(false);
        }else{
            btn.setDisable(true);
        }
    }

}
