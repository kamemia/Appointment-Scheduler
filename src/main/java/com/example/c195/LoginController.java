package com.example.c195;

import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.time.ZoneId;
import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    private String lang;

    @FXML
    private AnchorPane bg;

    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    private Label label;

    @FXML
    private ChoiceBox<String> langBox;

    @FXML
    private Button login;

    @FXML
    private Label zone;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        Platform.runLater(()-> bg.requestFocus());

        zone.setText(ZoneId.systemDefault().toString());

        setLang(Locale.getDefault().getLanguage());
        langBox.setOnAction(this::setLangBox);

        if (Objects.equals(getLang(), "en")){
            langBox.setValue("English");
        } else if (Objects.equals(getLang(), "fr")) {
            langBox.setValue("Francais");
        }
    }
    private String getLang() {return lang;}

    private void setLang(String lang) {
        this.lang = lang;
    }

    private void setLangBox(ActionEvent event) {
        if (Objects.equals(langBox.getValue(), "Français")) {
            setFrench();
            setLang("fr");
        }
        if (Objects.equals(langBox.getValue(), "English")) {
            setEnglish();
            setLang("en");
        }
    }

    private void setFrench() {
        label.setText("Système de gestion\ndes rendez-vous");
        username.setPromptText("Nom d'utilisateur");
        password.setPromptText("Mot de passe");
        login.setText("Connexion");
    }
    private void setEnglish() {
        label.setText("Appointment Management System");
        username.setPromptText("Username");
        password.setPromptText("Password");
        login.setText("Login");
    }

//    @FXML
//    private void loginClick(ActionEvent actionEvent) throws IOException {
//        ObservableList<User> users = Database.getUsers();
//
//        int match = 0;
//
//        for (User user: users){
//            if(Objects.equals(username.getText(), user.getUserName()) &&
//                    Objects.equals(password.getText(), user.getPassword())){
//                match = 1;
//            }
//        }
//    }
}
