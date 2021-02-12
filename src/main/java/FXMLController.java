import Enums.Getraenk;
import Enums.Temperatur;
import Fächer.Kaffeebohnen;
import Fächer.Kaffeesatz;
import Fächer.Tropfschale;
import Fächer.Wasserbehaelter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;

public class FXMLController {

    @FXML
    private TextArea textFeld1, textFeld2;
    @FXML
    private RadioButton crema, espresso, wasser;
    @FXML
    private RadioButton groesseDoppelt, groesseNormal, groesseKlein;
    @FXML
    private RadioButton temperatur1, temperatur2, temperatur3;
    @FXML
    private RadioButton staerkeSchwach, staerkeNormal, staerkeStark;
    @FXML
    private ProgressBar wassertank, kaffeebohnen;
    @FXML
    private Button tropfschale, kaffeesatz, buttonKA, buttonWA;

    @FXML
    protected void handleStartButtonAction(ActionEvent event) {
        setGetraenk();
        setGroesse();
        setTemperatur();
        setStaerke();
        Pruefung pruefung = new Pruefung();
        if (Tropfschale.tropfschaleIstVoll()) {
            textFeld1.setText("TROPFSCHALE LEEREN");
            textFeld2.setText("Kein Getraenk");
        } else if (!pruefung.wasserReicht) {
            textFeld1.setText("WASSER NACHFUELLEN");
            textFeld2.setText("Kein Getraenk");
        } else if (ProgrammWahl.getraenk != Getraenk.HEISSES_WASSER) {
            if (Kaffeesatz.kaffesatzIstVoll()) {
                textFeld1.setText("KAFFEESATZ LEEREN");
                textFeld2.setText("Kein Getraenk");
            } else if (!pruefung.kaffeeReicht) {
                textFeld1.setText("KAFFEEBOHNEN NACHFUELLEN");
                textFeld2.setText("Kein Getraenk");
            } else {
                Tropfschale.tropfschaleFuellen();
                Wasserbehaelter.wasserReduzieren(pruefung.wasserbedarf);
                Kaffeesatz.kaffeesatzFuellen();
                Kaffeebohnen.kaffeeReduzieren(pruefung.kaffeebedarf);
                textFeld1.setText("Optimal");
                textFeld2.setText("Getraenk wird ausgegeben");
            }
        } else {
            Tropfschale.tropfschaleFuellen();
            Wasserbehaelter.wasserReduzieren(pruefung.wasserbedarf);
            textFeld1.setText("Optimal");
            textFeld2.setText("Getraenk wird ausgegeben");
        }
        wassertank.setProgress(Wasserbehaelter.getWasserstand() / 100);
        kaffeebohnen.setProgress(Kaffeebohnen.getKaffeebohnen() / 100);

        setFarbeKaffeebohnen();
        setFarbeWassertank();
    }

    @FXML
    private void wasserAuffuellen(ActionEvent event) {
        Wasserbehaelter.wasserbehaelterFuellen();
        wassertank.setProgress(Wasserbehaelter.getWasserstand() / 100);
        textFeld1.setText("Optimal");
        setFarbeWassertank();
    }

    @FXML
    private void tropfschaleLeeren(ActionEvent event) {
        Tropfschale.tropfschaleLeeren();
        textFeld1.setText("Optimal");
    }

    @FXML
    private void kaffeebohnenAuffuellen(ActionEvent event) {
        Kaffeebohnen.kaffeebohnenAuffuellen();
        kaffeebohnen.setProgress(Kaffeebohnen.getKaffeebohnen() / 100);
        textFeld1.setText("Optimal");
        setFarbeKaffeebohnen();
    }

    @FXML
    private void kaffeesatzLeeren(ActionEvent event) {
        Kaffeesatz.kaffeesatzLeeren();
        textFeld1.setText("Optimal");
    }

    private void setGetraenk() {
        if (crema.isSelected()) ProgrammWahl.getraenk = Getraenk.CAFE_CREMA;
        else if (wasser.isSelected()) ProgrammWahl.getraenk = Getraenk.HEISSES_WASSER;
        else if (espresso.isSelected()) ProgrammWahl.getraenk = Getraenk.ESPRESSO;
    }

    private void setGroesse() {
        if (groesseDoppelt.isSelected()) ProgrammWahl.tassengroesse = 2;
        else if (groesseNormal.isSelected()) ProgrammWahl.tassengroesse = 1;
        else if (groesseKlein.isSelected()) ProgrammWahl.tassengroesse = 0;
    }

    private void setTemperatur() {
        if (temperatur1.isSelected()) ProgrammWahl.temperatur = Temperatur.STUFE_1;
        else if (temperatur2.isSelected()) ProgrammWahl.temperatur = Temperatur.STUFE_2;
        else if (temperatur3.isSelected()) ProgrammWahl.temperatur = Temperatur.STUFE_3;
    }

    private void setStaerke() {
        if (staerkeSchwach.isSelected()) ProgrammWahl.kaffestaerke = 1;
        else if (staerkeNormal.isSelected()) ProgrammWahl.kaffestaerke = 2;
        else if (staerkeStark.isSelected()) ProgrammWahl.kaffestaerke = 3;
    }

    private void setFarbeKaffeebohnen() {
        if (Kaffeebohnen.getKaffeebohnen() > 60) kaffeebohnen.setStyle("-fx-accent:#5eff5e");
        else if (Kaffeebohnen.getKaffeebohnen() < 30) kaffeebohnen.setStyle("-fx-accent:#b80000");
        else kaffeebohnen.setStyle("-fx-accent:#ffa500");
    }

    private void setFarbeWassertank() {
        if (Wasserbehaelter.getWasserstand() > 60) wassertank.setStyle("-fx-accent:#5eff5e");
        else if (Wasserbehaelter.getWasserstand() < 30) wassertank.setStyle("-fx-accent:#b80000");
        else wassertank.setStyle("-fx-accent:#ffa500");
    }
}
