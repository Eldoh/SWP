package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class BtnFeatureMediator implements MediatorInterface{

    private Button btn;

    public BtnFeatureMediator(Button btn){
        this.btn = btn;
    }

    @Override
    public void onSelect(int selectedItems) {
        if(selectedItems == 0){
            btn.setDisable(false);
        }else{
            btn.setDisable(true);
        }
    }
}
