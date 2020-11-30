/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.gsb.rv.dr;

import java.util.Optional;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author developpeur
 */
public class Appli extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        BorderPane borderPane = new BorderPane();
            MenuBar barreMenus = new MenuBar();

            Menu menuFichier = new Menu("Fichier");
 
            MenuItem itemSeConnecter = new MenuItem("Se connecter");
            MenuItem itemSeDeconnecter = new MenuItem("Se déconnecter");
            SeparatorMenuItem separateurItem = new SeparatorMenuItem();
            MenuItem itemQuitter = new MenuItem("Quitter");
            menuFichier.getItems().add(itemSeConnecter);
            menuFichier.getItems().add(itemSeDeconnecter);
            menuFichier.getItems().add(separateurItem);
            menuFichier.getItems().add(itemQuitter);
            
            Menu menuRapports = new Menu("Rapports");
        
            MenuItem itemConsulter = new MenuItem("Consulter");
            menuRapports.getItems().add(itemConsulter);
            
            itemConsulter.setOnAction( actionEvent -> {
                System.out.println("Consulter");
                }
            );
            
            
            Menu menuPraticiens = new Menu("Praticiens");
        
            MenuItem itemHesitants = new MenuItem("Hésitants");
            menuPraticiens.getItems().add(itemHesitants);

            itemHesitants.setOnAction( actionEvent -> {
                System.out.println("Hésitant");
                }
            );
            
            itemSeDeconnecter.setDisable(true);
            menuRapports.setDisable(true);
            menuPraticiens.setDisable(true);
            
            
            itemSeConnecter.setOnAction( actionEvent -> {
                System.out.println("Vous etes connecté");
                itemSeDeconnecter.setDisable(false);
                itemSeConnecter.setDisable(true);
                menuRapports.setDisable(false);
                menuPraticiens.setDisable(false);
                }
            );
            
            itemSeDeconnecter.setOnAction( actionEvent -> {
                System.out.println("Vous etes déconnecté");
                itemSeDeconnecter.setDisable(true);
                itemSeConnecter.setDisable(false);
                menuRapports.setDisable(true);
                menuPraticiens.setDisable(true);
                }
            );
            
            itemQuitter.setAccelerator(KeyCombination.keyCombination("Ctrl+X"));
            
            itemQuitter.setOnAction( actionEvent -> {
                Alert alertQuitter = new Alert(Alert.AlertType.CONFIRMATION);
                alertQuitter.setTitle("Quitter");
                alertQuitter.setHeaderText("Demande de confirmation");
                alertQuitter.setContentText("Voulez vous vraiment quittez ?");
                
                ButtonType btnOui = new ButtonType("Oui");
                ButtonType btnNon = new ButtonType("Non");
                
                alertQuitter.getButtonTypes().setAll(btnOui , btnNon);
                
                Optional<ButtonType> reponse = alertQuitter.showAndWait();
                
                if (reponse.get() == btnOui){
                    Platform.exit();
                } else {
                }
                }
            );
            
            barreMenus.getMenus().add(menuFichier);
            barreMenus.getMenus().add(menuRapports);
            barreMenus.getMenus().add(menuPraticiens);
        borderPane.setTop(barreMenus);
        
        Scene scene = new Scene(borderPane, 500, 300);
        
        primaryStage.setTitle("GSB-RV-DR");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
