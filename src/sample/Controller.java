package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class Controller implements Initializable{



    public String jeu = "Num_Jeu";
    public String system  = "Sistema";

    public String SaveJeu;
    public String SaveSys;

    public ComboBox jeuComboBox;
    public ComboBox SystemComboBox;
    public ComboBox addressComboBox;
    public DatePicker kipDatePicker;


    @Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {

        DbConnect dbc = new DbConnect();
        dbc.GetJeuList(jeu);
        ObservableList<String> jopt  = FXCollections.observableArrayList(dbc.JeuList);
        dbc.GetSysList(system);
        ObservableList<String> sysopt  = FXCollections.observableArrayList(dbc.SysList);

        kipDatePicker.setValue(LocalDate.now());
        jeuComboBox.getItems().setAll(jopt);
        SystemComboBox.getItems().setAll(sysopt);
    }
    public void saveJeuStatement(){
        SaveJeu = jeuComboBox.getValue().toString();
    }
    public void saveSysStatement() { SaveSys = SystemComboBox.getValue().toString(); }
    public void saveAddrStatement(){
        try {
            DbConnect dbc = new DbConnect();
            dbc.GetAddrList(jeuComboBox.getValue().toString(), SystemComboBox.getValue().toString());


            System.out.println(dbc.AddrList);
            ObservableList<String> hnopt = FXCollections.observableArrayList(dbc.AddrList);
            addressComboBox.getItems().setAll(hnopt);
        } catch (NullPointerException e) {};
    }
    public void getFullAddrStatement(){

    }


}
