package run;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
    public static String[] brandList;
    public static String[] planList;
    public static String[] tierList;
    public static  String chosenBrand;
    public static  String chosenPlan;
    public static  String chosenTier;

    @Override
    public void start(Stage primaryStage) throws Exception{
        brandList = new String[]{"UK","US","Canada","ATT","BT"};
        planList = new String[]{"Office", "Prof", "Fax"};
        tierList = new String[]{"Entry", "Standard", "Premium"};
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        GridPane root = new GridPane();
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setVgap(5);
        root.setHgap(5);
        primaryStage.setTitle("SignUp");

        Label labelEmail = new Label("Set email:");

        TextField email = new TextField();
        email.setMaxSize(200,20);
        email.setPromptText("sergei.demyanenko");

        Label labelBrand = new Label("Brand");
        ChoiceBox brand = addChoiveBox(brandList);
        brand.getSelectionModel().selectFirst();
        brand.getSelectionModel().selectedIndexProperty()
                .addListener(new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observableValue, Number value1, Number value2) {
                        chosenBrand = brandList[value2.intValue()];
                    }
                });

        Label labelPlan = new Label("Plan");
        ChoiceBox plan = addChoiveBox(planList);
        plan.getSelectionModel().selectFirst();
        plan.getSelectionModel()
                .selectedIndexProperty()
                .addListener(new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observableValue, Number value1, Number value2) {
                        chosenPlan = planList[value2.intValue()];
                    }
                });

        Label labelTier = new Label("Tier");
        ChoiceBox tier = addChoiveBox(tierList);
        tier.getSelectionModel().selectFirst();
        tier.getSelectionModel().selectedIndexProperty()
                .addListener(new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observableValue, Number value1, Number value2) {
                        chosenTier = tierList[value2.intValue()];
                    }
                });

        Label labelName = new Label("Set name:");
        TextField name = new TextField("NameTest");

        Label labelSurname = new Label("Set surname:");
        TextField surname = new TextField("SurnameTest");

        Label labelUsers = new Label("Set number of users:");
        TextField users = new TextField("2");

        Button signButton = addButton("SignUp");
        signButton.setOnAction(actionEvent ->{
            System.out.println("signUp");
            System.out.println(email.getText());
            System.out.println(brand.getSelectionModel().getSelectedIndex());
            WriteToFile.writeToXLSX(email.getText(),
                    brandList[brand.getSelectionModel().getSelectedIndex()],
                    planList[plan.getSelectionModel().getSelectedIndex()],tierList[tier.getSelectionModel().getSelectedIndex()],
                    name.getText(),surname.getText(),users.getText());

        });


        Button closeButton = addButton("Close");
        closeButton.setOnAction(actionEvent -> {
            primaryStage.close();
        });


        GridPane.setConstraints(labelEmail, 0, 0);
        GridPane.setConstraints(email, 1, 0);

        GridPane.setConstraints(labelBrand, 0,1);
        GridPane.setConstraints(brand,0, 2);

        GridPane.setConstraints(labelPlan, 1,1);
        GridPane.setConstraints(plan,1, 2);

        GridPane.setConstraints(labelTier, 2,1);
        GridPane.setConstraints(tier,2, 2);

        GridPane.setConstraints(labelName, 3,1);
        GridPane.setConstraints(name, 3,2);
        GridPane.setConstraints(labelSurname,4, 1);
        GridPane.setConstraints(surname, 4,2);
        GridPane.setConstraints(labelUsers,5, 1);
        GridPane.setConstraints(users, 5,2);

        GridPane.setConstraints(signButton, 7,6);
        GridPane.setConstraints(closeButton,0,6);

        root.getChildren().addAll(labelEmail,email,labelBrand,brand,labelPlan,plan,labelTier,tier,
                labelName,name,labelSurname,labelUsers,users,surname, signButton,closeButton);


        Scene scene = new Scene(root, 700,150);
        primaryStage.setScene(scene);
        primaryStage.show();
    }







    private ChoiceBox addChoiveBox(String...titles) {
        ChoiceBox cb = new ChoiceBox();
        cb.setItems(FXCollections.observableArrayList(titles));
        cb.setPrefSize(70,20);
        //cb.setPadding(new Insets(10,10,10,10));
        return cb;
    }
    private Button addButton(String title){
        Button btn = new Button(title);
        btn.setPrefSize(70,20);
        // btn.setPadding(new Insets(10,10,10,10));
        return btn;
    }
    public static void main(String[] args) {
        launch(args);
    }

}

