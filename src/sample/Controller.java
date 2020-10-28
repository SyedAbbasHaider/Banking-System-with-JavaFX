package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.nio.file.Files;

public class Controller {

    @FXML
    private TextField first_name, last_name;

    @FXML
    private TextField date;

    @FXML
    private TextField amount;

    @FXML
    private RadioButton checking, savings, moneyMarket;

    @FXML
    private ToggleGroup radiob;

    @FXML
    private Button openAccount;

    @FXML
    private Button closeAccount;

    @FXML
    private Button clear;

    @FXML
    private CheckBox ddCheckBox, lcCheckBox;

    @FXML
    private TextArea textArea_OC;

    @FXML
    private TextArea textArea_DW;

    @FXML
    private TextArea textArea_AD;

    @FXML
    private Button import_file;

    @FXML
    private Button export_file;


    AccountDatabase ad = new AccountDatabase();

    @FXML
    void addAccount(ActionEvent event) {
        String fName = first_name.getText();
        String lName = last_name.getText();
        double balance = Double.parseDouble(amount.getText());
        String d_date = date.getText();
        Date d = new Date(d_date);
        //boolean val = CheckBox.isSelected();
        Profile profile = new Profile(fName, lName);
        Toggle selectedToggle = radiob.getSelectedToggle();
        if (selectedToggle == checking) {
            lcCheckBox.setDisable(true);
            boolean val = ddCheckBox.isSelected();
            Account acc = new Checking(profile, balance, d, val);
            ad.add(acc);
        }
        if (selectedToggle == savings) {
            ddCheckBox.setDisable(true);
            boolean val = lcCheckBox.isSelected();
            Account acc = new Savings(profile, balance, d, val);
            ad.add(acc);
        }
        if (selectedToggle == moneyMarket) {
            lcCheckBox.setDisable(true);
            //boolean val = ddCheckBox.isSelected();
            Account acc = new MoneyMarket(profile, balance, d);
            ad.add(acc);
        }

        //textArea_OC.setText(ad.printAccounts());
        textArea_OC.appendText(ad.printAccounts() + "\n");


    }

    @FXML
    void importTextFile(ActionEvent event) throws IOException {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open Source File for the Import");
        chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                new FileChooser.ExtensionFilter("All Files", "*.*"));
        Stage stage = new Stage();
        File sourceFile = chooser.showOpenDialog(stage); //get the reference of the source file
        //write code to read from the file.
        //run a loop through the readable file, and then send a row to the addAccount method.
        BufferedReader br = new BufferedReader(new FileReader(sourceFile));
        String line;
        try {
            if (br.readLine() == null) {
                textArea_AD.appendText("File is Empty \n");
            }
            while ((line = br.readLine()) != null) {
                String[] token = line.split(",");
                switch (token[0]) {
                    case "C":
                        try {
                            Profile person = new Profile(token[1], token[2]);
                            double balance = Double.parseDouble(token[3]);
                            String date = token[4];
                            Date d = new Date(date);
                            boolean val = Boolean.parseBoolean(token[5]);
                            Account acc = new Checking(person, balance, d, val);
                            ad.add(acc);
                            break;
                        } catch (Exception e) {
                            System.out.println("Invalid Command entered !");
                            break;
                        }
                    case "S":
                        try {
                            Profile person = new Profile(token[1], token[2]);
                            double balance = Double.parseDouble(token[3]);
                            String date = token[4];
                            Date d = new Date(date);
                            boolean val = Boolean.parseBoolean(token[5]);
                            Account acc = new Savings(person, balance, d, val);
                            ad.add(acc);
                            break;
                        } catch (Exception e) {
                            System.out.println("Invalid Command entered !");
                            break;
                        }
                    case "M":
                        try {
                            Profile person = new Profile(token[1], token[2]);
                            double balance = Double.parseDouble(token[3]);
                            String date = token[4];
                            Date d = new Date(date);
                            Account acc = new MoneyMarket(person, balance, d);
                            ad.add(acc);
                            break;
                        } catch (Exception e) {
                            System.out.println("Invalid Command entered !");
                            break;
                        }
                }
                textArea_AD.appendText(ad.printAccounts() + "\n");
            }

        } catch (IOException e) {
            textArea_AD.appendText("Invalid, Error occurs \n");
        }
    }


    @FXML
    void exportTextFile(ActionEvent event) throws IOException {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open Target File for the Export");
        chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                new FileChooser.ExtensionFilter("All Files", "*.*"));
        Stage stage = new Stage();
        File targetFile = chooser.showSaveDialog(stage); //get the reference of the target file
        //write code to write to the file.
        BufferedWriter bw = new BufferedWriter(new FileWriter(targetFile));
        try{
            String[] result = ad.tester();
            for (int i = 0; i < result.length; i++) {
                bw.write(result[i] + "\n");
            }
            bw.close();

        }catch (Exception e){
            textArea_AD.appendText("Invalid, Error occurs \n");
        }

    }



}
