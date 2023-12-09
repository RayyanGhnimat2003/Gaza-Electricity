////Name:Rayan Ghnimat.
//Student Num:1211073.
//Dr:Murad Njoum.
//My first Data Structure Project about gaza and the problem of electricity in gaza because of israel.
//#######################################################################################################################################################3
package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import application.YourApplication.StatisticsResult33;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Main extends Application {
	private RadioButton yearRadioButton;// using radio buttons for selecting year.
	private RadioButton monthRadioButton;// using radio buttons for selecting month.
	private RadioButton dayRadioButton;// using radio buttons for selecting day.
	private RadioButton allRadioButton;// using radio buttons for selecting day and month and year.
	private ComboBox<String> columnComboBox;// to have the columns and days and years.
	private TableView<Statistics> statisticsTableView;// use the table view to print the data sum,average,min,max.
	private ChoiceBox<Integer> dayChoiceBox;// to let the user to select a day to have the days.
	private ChoiceBox<String> columnChoiceBox;;// to have the columns and let user to selsect one.
	private TableView<ProjectRecord> tableView;// here we have a table view to print the data from the file
	private ObservableList<ProjectRecord> tableData;//
	private static DaySingleList daylist;// single list to store days
	private static ProjectRecord ProjectRecord;// record that contains my file contents
	private static YearCircularList years = new YearCircularList();

	private Button nextButton;// button when i click it works
	private Button previousButton;// button when i click it works
	private Scene managmentScene;// scene for managment
	private Scene saveScene;// scene for save
	private Scene statisticsScene;// scene for statictics
	private TextField CheckMethods;// to check methods
	DayNodeData head;
	private static MonthCircularList months;// circular list to store years
	private Button loadFileButton33; // Added Load File button

	private TableView<ProjectRecord> tableView33;
	private ObservableList<ProjectRecord> tableData33;
	private DatePicker statisticsDatePicker33;
	private ChoiceBox<String> statisticsColumnChoiceBox33;
	private Button showStatisticsButton33;
	private TableView<StatisticsResult33> statisticsResultTableView33; // Modified to StatisticsResult
	private ObservableList<StatisticsResult33> statisticsResultData33; // Modified to StatisticsResult

	private DatePicker datePicker1;// to pick specifif date

	// welcomeLabel.setStyle("-fx-text-fill:darkred;-fx-font-size:16px;-fx-font-weight:bold;");
	@Override
//########################################################################################################
//########################################################################################################
//###################################################################################################################################################################################################################################################################################3
	public void start(Stage primaryStage) {
		// private DaySingleList daylist;

		tableView = new TableView<>();
		tableData = FXCollections.observableArrayList();

		TableColumn<ProjectRecord, LocalDate> dateColumn = new TableColumn<>("Date");// put the first colums in it frpm
																						// the file
		dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

		TableColumn<ProjectRecord, Double> israeliLinesColumn = new TableColumn<>("Israeli Lines");// put the second
																									// colums in it frpm
																									// the file
		israeliLinesColumn.setCellValueFactory(new PropertyValueFactory<>("israeliLinesData"));

		TableColumn<ProjectRecord, Double> gazaPowerColumn = new TableColumn<>("Gaza Power");// put the third colums in
																								// it frpm the file
		gazaPowerColumn.setCellValueFactory(new PropertyValueFactory<>("gazaPowerData"));

		TableColumn<ProjectRecord, Double> egyptianLinesColumn = new TableColumn<>("Egyptian Lines");// put the fourth
																										// colums in it
																										// frpm the file
		egyptianLinesColumn.setCellValueFactory(new PropertyValueFactory<>("egyptianLinesData"));

		TableColumn<ProjectRecord, Double> totalSupplyColumn = new TableColumn<>("Total Supply");// put the fifth colums
																									// in it frpm the
																									// file
		totalSupplyColumn.setCellValueFactory(new PropertyValueFactory<>("totalSupplyData"));

		TableColumn<ProjectRecord, Double> overallDemandColumn = new TableColumn<>("Overall Demand");// put the sixth
																										// colums in it
																										// frpm the file
		overallDemandColumn.setCellValueFactory(new PropertyValueFactory<>("overallDemandData"));

		TableColumn<ProjectRecord, Double> powerCutsColumn = new TableColumn<>("Power Cuts");// put the seventh colums
																								// in it frpm the file
		powerCutsColumn.setCellValueFactory(new PropertyValueFactory<>("powerCutsData"));

		TableColumn<ProjectRecord, Double> tempColumn = new TableColumn<>("Temperature");// put the eighth colums in it
																							// frpm the file
		tempColumn.setCellValueFactory(new PropertyValueFactory<>("tempData"));
//**************************************************************
//**************************************************************
// **************************************************************
// **************************************************************
// **************************************************************
// **************************************************************

		// add all the columns to the table
		tableView.getColumns().addAll(dateColumn, israeliLinesColumn, gazaPowerColumn, egyptianLinesColumn,
				totalSupplyColumn, overallDemandColumn, powerCutsColumn, tempColumn);

		// Set the data for the table
		tableView.setItems(tableData);
//########################################################################################################################################################################################################################3
		HBox columnChoiceBoxHBox = createColumnChoiceBox(); // usinnng theHBox to put data horizental.
		System.out.println("columnChoiceBox: " + columnChoiceBox);
		HBox dayChoiceBoxHBox = createDayChoiceBox();
		Label welcomeLabel = new Label("Welcome to my first data Structure project");
		Label rayanLabel = new Label("Student Name : Rayan Ghnimat");// put my name
		Label DtMuradLabel = new Label(" Dr : Murad Njoum");// put my dr name in a label
		VBox topContentsMain = new VBox(10);// Vbox to put the data vertically
		welcomeLabel.setStyle("-fx-text-fill:black;-fx-font-size:20px;-fx-font-weight:bold;");
		rayanLabel.setStyle("-fx-text-fill:black;-fx-font-size:18px;-fx-font-weight:bold;");
		DtMuradLabel.setStyle("-fx-text-fill:black;-fx-font-size:18px;-fx-font-weight:bold;");
		topContentsMain.getChildren().addAll(welcomeLabel, rayanLabel, DtMuradLabel);
		topContentsMain.setAlignment(Pos.TOP_CENTER);
		Label welcomeLabe22 = new Label("FREE");
		Label welcomeLabe222 = new Label("PALESTINE");
		HBox hboxroro = new HBox(200);
		hboxroro.getChildren().addAll(welcomeLabe22, topContentsMain, welcomeLabe222);
		welcomeLabe22.setStyle("-fx-text-fill: red; -fx-font-size: 30; -fx-font-weight: bold;");
		welcomeLabe222.setStyle("-fx-text-fill: red; -fx-font-size: 30; -fx-font-weight: bold;");
		hboxroro.setAlignment(Pos.CENTER);
//********************************************************************************************************
		Image boyImage = new Image("gazaBoy.jpg");// use the image to store the image
		ImageView gazaboymain = new ImageView(boyImage);// use the imageview to print the image
		gazaboymain.setFitHeight(350);// put height bewtween elements
		gazaboymain.setFitWidth(550);// put width between elements.
		Label gazalabel = new Label("Gaza");
		Label projectlabel = new Label("Project");
		gazalabel.setStyle("-fx-text-fill:darkred;-fx-font-size:20px;-fx-font-weight:bold;");
		projectlabel.setStyle("-fx-text-fill:darkred;-fx-font-size:20px;-fx-font-weight:bold;");
		HBox centerContentsMain = new HBox(120);
		centerContentsMain.getChildren().addAll(gazalabel, gazaboymain, projectlabel);
		centerContentsMain.setAlignment(Pos.CENTER);
//***************************************************************************************************************		
		daylist = new DaySingleList();
		// daylist.addDay(ProjectRecord);//add the file record to my singlelist day
		// daylist.print();//use the print to prinr daylist
		Button buttonManagement = new Button("Managment Screen");// button to move to my managment screen
		Button buttonStatistics = new Button("Statistics  Screen");// button to move to my Statictics screen
		Button buttonSave = new Button("Save  Screen");// button to move to my Save screen
		nextButton = new Button("Next");// next button to move to next scene//
		previousButton = new Button("Previous");// previous button to move to previous scene
		buttonStatistics.setStyle(
				"-fx-text-fill:black;-fx-font-size:14px;-fx-font-weight:bold;-fx-background-color:#ffffff;-fx-border-color:black;-fx-border-width:2px;");

		previousButton
				.setStyle("-fx-text-fill:white;-fx-font-size:14px;-fx-font-weight:bold;-fx-background-color:#030101");
		buttonManagement.setStyle(
				"-fx-text-fill:white;-fx-font-size:14px;-fx-font-weight:bold;-fx-background-color:#B31312;-fx-border-color:black;-fx-border-width:2px;");
		buttonSave.setStyle(
				"-fx-text-fill:white;-fx-font-size:14px;-fx-font-weight:bold;-fx-background-color:#033401;-fx-border-color:black;-fx-border-width:2px;");
		nextButton.setStyle("-fx-text-fill:white;-fx-font-size:14px;-fx-font-weight:bold;-fx-background-color:#030101");
		HBox screensHbox = new HBox(10);// to put elements horizentolly
		YearCircularList years = new YearCircularList();// circular linked list to store the years
		// years.addYear(2021);
		// years.addYear(2022);
		// years.addYear(2023);

		screensHbox.getChildren().addAll(buttonManagement, buttonStatistics, buttonSave);

//**************************************************************************************************************		
		HBox bottomContentMain = new HBox(120);// to put elements horizentolly
		bottomContentMain.getChildren().addAll(previousButton, screensHbox, nextButton);
		bottomContentMain.setAlignment(Pos.BOTTOM_CENTER);
//************************************************************************************************************************
		VBox welcomeScreen = new VBox(40);// to put elements Verticaally
		welcomeScreen.getChildren().addAll(hboxroro, centerContentsMain, bottomContentMain);
		Scene scene = new Scene(welcomeScreen, 1300, 600);
		primaryStage.setScene(scene);

		primaryStage.show();
//############################# end of First Scene#####################################################################################################################3
//#############################################################################################################################################
//######################################################################################################################
		DatePicker datePicker = new DatePicker();// use the data picker to let user select specific date
		DatePicker datePicker2 = new DatePicker();// use the data picker to let user select specific date

		Image imageElectrisity = new Image("imageGaza.jpg");// use image to store image
		ImageView image = new ImageView(imageElectrisity);// use image view to print the image
		image.setFitHeight(100);// make height of image to be 100
		image.setFitWidth(200);// make width of image to be 200
		Label welcomeScreen2Label = new Label("Welcome to Mangment Scene");// label tp print the text
		VBox inagePucker = new VBox(30);// to put elements Verticaally
		inagePucker.getChildren().addAll(image, datePicker);
		HBox Scene2Hbox = new HBox(120);// to put elements horizonttaly
		Button loadButton = new Button("Load File");// load file button to load the file

		Scene2Hbox.getChildren().addAll(inagePucker, welcomeScreen2Label, loadButton);
		welcomeScreen2Label.setStyle("-fx-text-fill:black;-fx-font-size:20px;-fx-font-weight:bold;");
		// Scene2Hbox.setStyle("-fx-background-color:#E48F45");

		// (Date, Israeli_Lines_MWs, Gaza_Power_Plant_MWs,
		// Egyptian_Lines_MWs, Total_daily_Supply_available_in_MWs,
		// Overall_demand_in_MWs,
		// Power_Cuts_hours_day_400mg, and Temp) separated by comma (,).
		Button addButton = new Button("Insert");// button to click
		Button deleteButton = new Button("Delete");// button to click
		Button SearchButton = new Button("Search");// button to click
		Button updateutton = new Button("Update");// button to click
		Button next2Button = new Button("Next");// button to click and go to next scene
		Button prev2Button = new Button("Previous");// button to click and go to prev scene
		loadButton.setStyle(
				"-fx-text-fill:white;-fx-font-size:14px;-fx-font-weight:bold;-fx-background-color:#033401;-fx-border-color:black;-fx-border-width:2px;");
		next2Button
				.setStyle("-fx-text-fill:white;-fx-font-size:14px;-fx-font-weight:bold;-fx-background-color:#030101");
		prev2Button
				.setStyle("-fx-text-fill:white;-fx-font-size:14px;-fx-font-weight:bold;-fx-background-color:#030101");
		addButton.setStyle(
				"-fx-text-fill:white;-fx-font-size:14px;-fx-font-weight:bold;-fx-background-color:#B31312;-fx-border-color:black;-fx-border-width:2px;");
		deleteButton.setStyle(
				"-fx-text-fill:white;-fx-font-size:14px;-fx-font-weight:bold;-fx-background-color:#B31312;-fx-border-color:black;-fx-border-width:2px;");
		SearchButton.setStyle(
				"-fx-text-fill:white;-fx-font-size:14px;-fx-font-weight:bold;-fx-background-color:#B31312;-fx-border-color:black;-fx-border-width:2px;");
		updateutton.setStyle(
				"-fx-text-fill:white;-fx-font-size:14px;-fx-font-weight:bold;-fx-background-color:#B31312;-fx-border-color:black;-fx-border-width:2px;");
		HBox Screen2Buttons = new HBox(10);// to put the data horizontallay
		Screen2Buttons.getChildren().addAll(addButton, deleteButton, SearchButton, updateutton);
		Screen2Buttons.setAlignment(Pos.BOTTOM_CENTER);
		HBox Screen2Buttones = new HBox(150);// to put the data horizontallay
		Screen2Buttones.getChildren().addAll(prev2Button, Screen2Buttons, next2Button);
		Screen2Buttones.setAlignment(Pos.BOTTOM_CENTER);
		Label isrealLabel = new Label("Enter Israeli_Lines");// label to store text
		isrealLabel.setStyle("-fx-font-weight:bold;");// change the lines

		TextField isrealTextField = new TextField();
		Label gazaPowerLabel = new Label("Enter Gaza_Power");// label to print text
		gazaPowerLabel.setStyle("-fx-font-weight:bold;");

		TextField gazaPowerTextField = new TextField();
		Label egiptionLabel = new Label("Enter Egyptian_Lines");// label to print text
		egiptionLabel.setStyle("-fx-font-weight:bold;");// change the lines

		TextField egiptionTextField = new TextField();// change the lines
		Label supplyLabel = new Label("Enter Supplay");
		supplyLabel.setStyle("-fx-font-weight:bold;");
		// change the lines
		TextField supplyTextField = new TextField();
		// label to print text
		Label demandLabel = new Label("Enter Demand");
		demandLabel.setStyle("-fx-font-weight:bold;");// change the lines

		TextField demandTextField = new TextField();
		// label to print text
		Label PowerLabel = new Label("Enter Power");
		PowerLabel.setStyle("-fx-font-weight:bold;");// change the lines

		TextField PowerTextField = new TextField();
		// label to print text
		Label tempLabel = new Label("Enter Temp");
		tempLabel.setStyle("-fx-font-weight:bold;");// change the lines

		TextField tempTextField = new TextField();
		TextField CheckMethods = new TextField();

		VBox labelsVbox = new VBox(17);//// to put the data verticcaly
		labelsVbox.getChildren().addAll(isrealLabel, gazaPowerLabel, egiptionLabel, supplyLabel, demandLabel,
				PowerLabel, tempLabel);

		VBox TextFieldVbox = new VBox(8);// to put the data verticcaly
		TextFieldVbox.getChildren().addAll(isrealTextField, gazaPowerTextField, egiptionTextField, supplyTextField,
				demandTextField, PowerTextField, tempTextField);

		HBox labelsFieldshbox = new HBox(10);// to put the data Horizonally
		labelsFieldshbox.getChildren().addAll(datePicker, labelsVbox, TextFieldVbox, tableView);
		Image ImageAdd = new Image("add.jpg");/// to store image
		Image ImageDelete = new Image("delete.jpg");/// to store image
		Image ImageSearch = new Image("serach.jpg");/// to store image
		Image ImageUpdate = new Image("update.jpg");/// to store image
		HBox iconsHBox = new HBox(5);// to put the data Horizonally

		ImageView ImageviewAdd = new ImageView(ImageAdd);// to print the images
		ImageviewAdd.setFitHeight(40);// put the height
		ImageviewAdd.setFitWidth(40);// put the width
		// if (daylist == null) {
		// daylist = new DaySingleList(); // Initialize daylist if it's null
		// }
		ImageView Imageviewdelete = new ImageView(ImageDelete);// to print the images
		Imageviewdelete.setFitHeight(40);// put the heught 40
		Imageviewdelete.setFitWidth(40);// put the width 40
		ImageView ImageviewSearch = new ImageView(ImageSearch);// to print the images
		ImageviewSearch.setFitHeight(40);// put the heught 40
		ImageviewSearch.setFitWidth(40);// put the heught 40
		ImageView ImageviewUpdate = new ImageView(ImageUpdate);// to print the images
		ImageviewUpdate.setFitHeight(40);// put the heught 40
		ImageviewUpdate.setFitWidth(40);// put the width 40
		HBox imagesicons = new HBox(33);//// to put the data Horizonally
		imagesicons.setAlignment(Pos.BOTTOM_CENTER);// to put hbox in center
		imagesicons.getChildren().addAll(ImageviewAdd, Imageviewdelete, ImageviewSearch, ImageviewUpdate);
		VBox mainSecondScene = new VBox(30);//// to put the data vertically
		mainSecondScene.getChildren().addAll(Scene2Hbox, labelsFieldshbox, CheckMethods, Screen2Buttones, imagesicons);
		managmentScene = new Scene(mainSecondScene, 1300, 600);
//******************************************************************************************************************************************************************
//############################End of the Managment Scene##########################################################################################################################################
//######################################################################################################################################################################
//######################################################################################################################################################################
		Label welcomeScreen3Label = new Label("Welcome to Statistics Scene");// to put the text in it

		Image StatisticsFirst = new Image("Statictcs.jpg");// put the image in it
		Image StatisticsSecond = new Image("statictics.jpg");// put the image in it

		ImageView ImageviewStatisticsFirst = new ImageView(StatisticsFirst);// to print image
		ImageviewStatisticsFirst.setFitHeight(100);// to put height for image
		ImageviewStatisticsFirst.setFitWidth(200);// to put width for image

		ImageView ImageviewStatisticsSecond = new ImageView(StatisticsSecond);// to print image
		ImageviewStatisticsSecond.setFitHeight(100);/// to put height for image
		ImageviewStatisticsSecond.setFitWidth(200);// to put width for image
		loadFileButton33 = new Button("Load File");
		initTable33();
		initStatisticsComponents33();
		initLoadFileButton33();
		Button showYearButton33 = new Button("Show Year");
		showYearButton33.setOnAction(e -> handleShowYearStatistics());
		loadFileButton33.setOnAction(e -> handleLoadFile33());
		Button showMonthButton33 = new Button("Show Month");
		showMonthButton33.setOnAction(e -> handleShowMonthStatistics());
		Button button3Next = new Button("Next");// to move to next scene
		Button button3prev = new Button("Previous");// to move to prev scene
		HBox thirdScreenHbox = new HBox(150);// to add elements horizontaaly
		thirdScreenHbox.setAlignment(Pos.TOP_CENTER);
		thirdScreenHbox.getChildren().addAll(ImageviewStatisticsFirst, welcomeScreen3Label, ImageviewStatisticsSecond);
		HBox thirdScreenHbox32 = new HBox(150);// to add elements horizontaaly
		thirdScreenHbox32.setAlignment(Pos.TOP_CENTER);
		thirdScreenHbox32.getChildren().addAll(loadFileButton33, statisticsDatePicker33, statisticsColumnChoiceBox33);
		Button showDayButton = new Button("Show Day");
		showDayButton.setOnAction(e -> handleShowDayStatistics());

		// Initialize the Load File button

		HBox thirdScreenHbox323 = new HBox(150);// to add elements horizontaaly
		thirdScreenHbox323.setAlignment(Pos.TOP_CENTER);
		thirdScreenHbox323.getChildren().addAll(button3prev, showStatisticsButton33, showDayButton,showMonthButton33,
				showYearButton33, button3Next);

		VBox statisticsLayout33 = new VBox(thirdScreenHbox, tableView33, thirdScreenHbox32, statisticsResultTableView33,
				thirdScreenHbox323);

		// Create the Scene
		showYearButton33.setOnAction(e -> handleShowYearStatistics());

		// Set the scene and show the stage

		loadFileButton33.setOnAction(e -> handleLoadFile33());

		welcomeScreen3Label.setStyle("-fx-text-fill:black;-fx-font-size:20px;-fx-font-weight:bold;");
		button3prev
				.setStyle("-fx-text-fill:white;-fx-font-size:14px;-fx-font-weight:bold;-fx-background-color:#007fff;");
		button3Next
				.setStyle("-fx-text-fill:white;-fx-font-size:14px;-fx-font-weight:bold;-fx-background-color:#e30022;");
		showStatisticsButton33
				.setStyle("-fx-text-fill:black;-fx-font-size:14px;-fx-font-weight:bold;-fx-background-color:#fdee00;");
		showMonthButton33
				.setStyle("-fx-text-fill:black;-fx-font-size:14px;-fx-font-weight:bold;-fx-background-color:#fdee00;");
		showYearButton33
				.setStyle("-fx-text-fill:black;-fx-font-size:14px;-fx-font-weight:bold;-fx-background-color:#fdee00;");
		showDayButton
				.setStyle("-fx-text-fill:black;-fx-font-size:14px;-fx-font-weight:bold;-fx-background-color:#fdee00;");

		loadFileButton33
				.setStyle("-fx-text-fill:white;-fx-font-size:14px;-fx-font-weight:bold;-fx-background-color:#007fff;");
		statisticsColumnChoiceBox33
				.setStyle("-fx-text-fill:white;-fx-font-size:14px;-fx-font-weight:bold;-fx-background-color:#EF4040;");

		statisticsDatePicker33.getEditor()
				.setStyle("-fx-text-fill:black;-fx-font-size:14px;-fx-font-weight:bold;-fx-background-color:#fdee00;");
		statisticsScene = new Scene(statisticsLayout33, 1300, 600);
//**************************************************************************************************************************************************************************************************************************
//#######################End of statictics Scene################$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$		
//#####################################################################$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
		Label welcomeScreen4Label = new Label("Welcome to Save Scene");// to put text i it

		welcomeScreen4Label.setStyle("-fx-text-fill:black;-fx-font-size:20px;-fx-font-weight:bold;");
		TextField SaveTextField = new TextField();
		Button saveButton = new Button("Save");// save button to save file
		HBox hboxSave = new HBox(10);// put the data horizontally
		hboxSave.getChildren().addAll(SaveTextField, saveButton);
		hboxSave.setAlignment(Pos.CENTER);
		Image saveImage = new Image("saverayano.png");// to store the image

		ImageView ImageviewSave = new ImageView(saveImage);// to print the image
		ImageviewSave.setFitHeight(100);// put height 100
		ImageviewSave.setFitWidth(200);// put width 200
		HBox hboxSave2 = new HBox(90);// put the data horizontally
		hboxSave2.getChildren().addAll(ImageviewSave, welcomeScreen4Label);
		Button nexttButton = new Button("Next");// to move to next scene
		Button prevvButton = new Button("Previous");// to move to prev scene
		HBox hboxSave3 = new HBox(700);// put the data horizontally
		hboxSave3.getChildren().addAll(prevvButton, nexttButton);
		hboxSave3.setAlignment(Pos.BOTTOM_CENTER);
		VBox VboxSave2 = new VBox(150);// to put the data verticcaly
		// Button saveButton = new Button("Save");
		saveButton.setStyle("-fx-text-fill:white;-fx-font-size:14px;-fx-font-weight:bold;-fx-background-color:#a52a2a");

		// Add an ActionEvent handler to the saveButton
		saveButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// Use a file chooser to select the folder to save the new file
				FileChooser fileChooser = new FileChooser();
				fileChooser.setTitle("Save Linked Lists");

				// Set the file extension filter if needed (e.g., *.csv)
				FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
				fileChooser.getExtensionFilters().add(extFilter);

				// Show the file chooser dialog
				File file = fileChooser.showSaveDialog(primaryStage);

				if (file != null) {
					// Get the selected file path
					String filePath = file.getAbsolutePath();

					// Append a file name if needed
					// ...

					// Save linked lists to the file
					saveToFile(filePath);
				}
			}
		});
//########################################################################################################################################3
		// Existing code

		// Save linked lists to a file method
//********************************************************************************************************************************************
		VboxSave2.getChildren().addAll(hboxSave2, hboxSave, hboxSave3);
		// #a52a2a
		saveButton.setStyle("-fx-text-fill:white;-fx-font-size:14px;-fx-font-weight:bold;-fx-background-color:#a52a2a");
		nexttButton
				.setStyle("-fx-text-fill:white;-fx-font-size:14px;-fx-font-weight:bold;-fx-background-color:#030101");
		prevvButton
				.setStyle("-fx-text-fill:white;-fx-font-size:14px;-fx-font-weight:bold;-fx-background-color:#030101");
		saveScene = new Scene(VboxSave2, 1300, 600);

//###############################################################################################################################################################################################################################################################################
//###############################################################################################################################################################################################################################################################################
//****************************Event Handler************************************************************************************************************************************************************************************************************************************************************
		buttonManagement.setOnAction(e -> {// to move to managmentScene
			primaryStage.setScene(managmentScene);
			primaryStage.setTitle("Managment Scene");
			primaryStage.show();
		});

		buttonStatistics.setOnAction(e -> {// to move to statisticsScene
			primaryStage.setScene(statisticsScene);
			primaryStage.setTitle("Statistics Scene");
			primaryStage.show();
		});

		buttonSave.setOnAction(e -> {// to move saveScene
			primaryStage.setScene(saveScene);
			primaryStage.setTitle("Save Scene");
			primaryStage.show();
		});
		nextButton.setOnAction(e -> {// to move to next scene
			if (managmentScene != null) {
				primaryStage.setScene(managmentScene);
			} else {
				System.out.println("ohhh noo the mangementScreen not exixt!!!try again");
			}
		});

		previousButton.setOnAction(e -> {// to move to prev scene{
			if (saveScene != null) {
				primaryStage.setScene(saveScene);
			} else {
				System.out.println("ohhh noo the saveScene not exixt!!!try again");
			}
		});

		next2Button.setOnAction(e -> {// to move to next scene
			if (statisticsScene != null) {
				primaryStage.setScene(statisticsScene);
			} else {
				System.out.println("ohhh noo the mangementScreen not exixt!!!try again");
			}
		});

		button3Next.setOnAction(e -> {// to move to next scene
			if (saveScene != null) {
				primaryStage.setScene(saveScene);
			} else {
				System.out.println("ohhh noo the saveScene not exixt!!!try again");
			}
		});

		nexttButton.setOnAction(e -> {// to move to next scene
			if (scene != null) {
				primaryStage.setScene(scene);
			} else {
				System.out.println("ohhh noo the scene not exixt!!!try again");
			}
		});
		prevvButton.setOnAction(e -> {// to move to prev scene
			if (statisticsScene != null) {
				primaryStage.setScene(statisticsScene);
			} else {
				System.out.println("ohhh noo the statisticsScene not exixt!!!try again");
			}
		});
		prev2Button.setOnAction(e -> {// to move to prev scene
			if (scene != null) {
				primaryStage.setScene(scene);
			} else {
				System.out.println("ohhh noo the scene not exixt!!!try again");
			}
		});

		button3prev.setOnAction(e -> {// to move to prev scene
			if (scene != null) {
				primaryStage.setScene(managmentScene);
			} else {
				System.out.println("ohhh noo the managmentScene not exixt!!!try again");
			}
		});
//&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
		loadButton.setOnAction(e -> {// to load file to read and put it in a table view
			FileChooser fileChooser = new FileChooser();
			fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "mjj.txt"));
			File selectedFile = fileChooser.showOpenDialog(primaryStage);

			try {
				// Read data from the selected file and add to DaySingleList
				readDataAndAddToDayList(selectedFile);

				// Update the TableView
				updateTable(daylist);

				// Switch to the Management Scene
				primaryStage.setScene(managmentScene);
				primaryStage.setTitle("Management Scene");
			} catch (IOException ex) {
				ex.printStackTrace();
				// Handle the exception (e.g., show an alert)
			}
		});
//##############################################################################################################################################

		addButton.setOnAction(e -> {
			LocalDate localDate = datePicker.getValue();

			if (localDate != null) {
				if (isTextFieldEmpty(isrealTextField) || isTextFieldEmpty(gazaPowerTextField)
						|| isTextFieldEmpty(egiptionTextField) || isTextFieldEmpty(supplyTextField)
						|| isTextFieldEmpty(demandTextField) || isTextFieldEmpty(PowerTextField)
						|| isTextFieldEmpty(tempTextField)) {
					CheckMethods.setText("Ohhh no, please enter values for all fields.");
				} else {
					try {
						// Check if a record already exists for the selected date
						ProjectRecord existingRecord = daylist.searchByDate(localDate.getDayOfMonth());

						if (existingRecord != null) {
							// Update existing record with values from text fields
							existingRecord.setIsraeliLinesData(Double.parseDouble(isrealTextField.getText()));
							existingRecord.setGazaPowerData(Double.parseDouble(gazaPowerTextField.getText()));
							existingRecord.setEgyptianLinesData(Double.parseDouble(egiptionTextField.getText()));
							existingRecord.setTotalSupplyData(Double.parseDouble(supplyTextField.getText()));
							existingRecord.setOverallDemandData(Double.parseDouble(demandTextField.getText()));
							existingRecord.setPowerCutsData(Double.parseDouble(PowerTextField.getText()));
							existingRecord.setTempData(Double.parseDouble(tempTextField.getText()));
						} else {
							// Create a new record with values from text fields
							ProjectRecord newRecord = new ProjectRecord(localDate,
									Double.parseDouble(isrealTextField.getText()),
									Double.parseDouble(gazaPowerTextField.getText()),
									Double.parseDouble(egiptionTextField.getText()),
									Double.parseDouble(supplyTextField.getText()),
									Double.parseDouble(demandTextField.getText()),
									Double.parseDouble(PowerTextField.getText()),
									Double.parseDouble(tempTextField.getText()));
							daylist.addDay(newRecord, CheckMethods);// add the record to the daylist
						}

						// Update the table view
						tableData.setAll(daylist.getAllRecords());
					} catch (NumberFormatException ex) {
						// Handle the case where the input is not a valid double
						CheckMethods.setText("Error: Please enter valid numeric values.");
					}
				}
			} else {
				CheckMethods.setText("Ohhh no, please enter a date to insert.");
			}
		});

		deleteButton.setOnAction(e -> {
			LocalDate localdate = datePicker.getValue();
			if (localdate != null) {
				boolean delete = daylist.deleteByDate(localdate);
				if (delete) {
					tableData.setAll(daylist.getAllRecords());
					CheckMethods.clear();
				} else {
					CheckMethods.setText("Ohhhhhh No record try again!!!!!!!!!!!!!11 ");
				}
			} else {
				CheckMethods.setText("Please choose a date to delete.");
			}
		});

		SearchButton.setOnAction(e -> {
			LocalDate localdate = datePicker.getValue();

			if (localdate != null) {
				ProjectRecord Founded = daylist.searchByDate(localdate);

				if (Founded != null) {
					String recordString = Founded.toString();
					CheckMethods.setText("Yahooooooooo Record found for date " + localdate + ":\n" + recordString);
				} else {
					// Record not found
					CheckMethods.setText("OHHH noo sorry record not found for date: " + localdate);
				}
			} else {
				// No date selected
				CheckMethods.setText("Please choose a date");
			}
		});

		updateutton.setOnAction(event -> {
			LocalDate localdate = datePicker.getValue();

			if (localdate != null) {
				if (isTextFieldEmpty(isrealTextField) || isTextFieldEmpty(gazaPowerTextField)
						|| isTextFieldEmpty(egiptionTextField) || isTextFieldEmpty(supplyTextField)
						|| isTextFieldEmpty(demandTextField) || isTextFieldEmpty(PowerTextField)
						|| isTextFieldEmpty(tempTextField)) {
					CheckMethods.setText("Ohhh no, please enter values for all fields.");
				} else {
					try {
						// Check if the entered values are valid doubles
						Double israeliLinesData = Double.parseDouble(isrealTextField.getText());
						Double gazaPowerData = Double.parseDouble(gazaPowerTextField.getText());
						Double egyptianLinesData = Double.parseDouble(egiptionTextField.getText());
						Double totalSupplyData = Double.parseDouble(supplyTextField.getText());
						Double overallDemandData = Double.parseDouble(demandTextField.getText());
						Double powerCutsData = Double.parseDouble(PowerTextField.getText());
						Double tempData = Double.parseDouble(tempTextField.getText());

						// Get the existing record for the selected date
						ProjectRecord existingRecord = daylist.searchByDate(localdate);

						if (existingRecord != null) {
							// Update the existing record with new values
							existingRecord.setIsraeliLinesData(israeliLinesData);
							existingRecord.setGazaPowerData(gazaPowerData);
							existingRecord.setEgyptianLinesData(egyptianLinesData);
							existingRecord.setTotalSupplyData(totalSupplyData);
							existingRecord.setOverallDemandData(overallDemandData);
							existingRecord.setPowerCutsData(powerCutsData);
							existingRecord.setTempData(tempData);

							// Optionally, update other fields as needed

							// Print the updated record
							// System.out.println("Record updated: " + existingRecord);

							// Optionally, update the table view
							tableData.setAll(daylist.getAllRecords());
						} else {
							CheckMethods.setText("Please enter the all fields!!");
							// No record found for the selected date
							// System.out.println("No record found for the selected date. Cannot update.");
						}
					} catch (NumberFormatException ex) {
						// Handle the case where the input is not a valid double
						CheckMethods.setText("Invalid input! Please enter valid numeric values.");
					}
				}
			} else {
				CheckMethods.setText("Please select a date for updating.");
			}
		});

		saveButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// Use a directory chooser to select the desktop as the save location
				DirectoryChooser Savechooser = new DirectoryChooser();
				Savechooser.setTitle("Please Choose a location to save  file");

				// Show the directory chooser dialog
				File files = Savechooser.showDialog(primaryStage);

				if (files != null) {
					// Get the entered file name from the text field
					String fileName = SaveTextField.getText();

					// Construct the full file path on the desktop
					String filePath = files.getAbsolutePath() + File.separator + fileName + ".txt";

					// Save linked lists to the file
					saveToFile(filePath);
				}
			}
		});

//#################################################################################################################################

	}

	/*
	 * public Main() { daylist = new DaySingleList(); }
	 */
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	private void readDataAndAddToDayList(File file) throws IOException {
		daylist = new DaySingleList();
		months = new MonthCircularList();
		years = new YearCircularList();
		try (Scanner reades = new Scanner(file)) {
			while (reades.hasNextLine()) {
				String readLine = reades.nextLine();
				System.out.println(readLine);

				String[] splits = readLine.split(",");
				LocalDate localDate = LocalDate.parse(splits[0], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
				Double israeliLinesData = Double.parseDouble(splits[1]);
				Double gazaPowerData = Double.parseDouble(splits[2]);
				Double egyptianLinesData = Double.parseDouble(splits[3]);
				Double totalSupplyData = Double.parseDouble(splits[4]);
				Double overallDemandData = Double.parseDouble(splits[5]);
				Double powerCutsData = Double.parseDouble(splits[6]);
				Double tempData = Double.parseDouble(splits[splits.length - 1].trim());

				ProjectRecord project = new ProjectRecord(localDate, israeliLinesData, gazaPowerData, egyptianLinesData,
						totalSupplyData, overallDemandData, powerCutsData, tempData);

				daylist.addDay(project);

				// months.
				// years.addYear(0)

			}
		}
	}

//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%5
	private void updateTable(DaySingleList days) {
		// Clear the existing table data
		tableView.getItems().clear();

		// Iterate through the dayList and add records to the table
		DayNodeData nodes = days.getHead();
		while (nodes != null) {
			tableData.add(nodes.getRecords());
			nodes = nodes.getNext();
		}

		// Refresh the TableView to reflect the changes
		tableView.refresh();
	}

//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	private HBox createYearChoiceBox() {
		HBox YearsSelect = new HBox(10);

		// Add years from 2017 to 2023 to the ChoiceBox
		ChoiceBox<String> years = new ChoiceBox<>(
				FXCollections.observableArrayList("2017", "2018", "2019", "2020", "2021", "2022", "2023"));

		YearsSelect.getChildren().addAll(years);

		return YearsSelect;
	}

	/*
	 * private HBox createColumnChoiceBox() { HBox columnChoiceBoxHBox = new
	 * HBox(10);
	 * 
	 * // Add column names to the ChoiceBox ChoiceBox<String> columnChoiceBox = new
	 * ChoiceBox<>(FXCollections.observableArrayList("Israeli_Lines_MWs",
	 * "Gaza_Power_Plant_MWs", "Egyptian_Lines_MWs",
	 * "Total_daily_Supply_available_in_MWs", "Overall_demand_in_MWs",
	 * "Power_Cuts_hours_day_400mg", "Temp"));
	 * 
	 * columnChoiceBoxHBox.getChildren().addAll(columnChoiceBox);
	 * 
	 * return columnChoiceBoxHBox; }
	 */
//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$44
	private HBox createMonthChoiceBox() {
		HBox months = new HBox(10);

		// Add months as numbers to the ChoiceBox
		ChoiceBox<Integer> monthes = new ChoiceBox<>(
				FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12));

		months.getChildren().addAll(monthes);

		return months;
	}

//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	public void addProjectRecord(ProjectRecord recordes) {
		if (daylist == null) {
			daylist = new DaySingleList(); // Initialize daylist if it's null
		}
		daylist.addDay(recordes);
	}

	// ... (existing code)
//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	private HBox createDayChoiceBox() {
		HBox days = new HBox(10);

		// Add days from 1 to 31 to the ChoiceBox
		dayChoiceBox = new ChoiceBox<>(FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,
				15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31));

		days.getChildren().addAll(dayChoiceBox);

		return days;
	}
//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

	private HBox createStatisticsTableView() {
		HBox statistics = new HBox(10);

		statisticsTableView = new TableView<>();

		TableColumn<Statistics, Double> sumColumn = new TableColumn<>("Sum");
		sumColumn.setCellValueFactory(new PropertyValueFactory<>("sum"));

		TableColumn<Statistics, Double> averageColumn = new TableColumn<>("Average");
		averageColumn.setCellValueFactory(new PropertyValueFactory<>("average"));

		TableColumn<Statistics, Double> minColumn = new TableColumn<>("Min");
		minColumn.setCellValueFactory(new PropertyValueFactory<>("minimum"));

		TableColumn<Statistics, Double> maxColumn = new TableColumn<>("Max");
		maxColumn.setCellValueFactory(new PropertyValueFactory<>("maximum"));
		statistics.setAlignment(Pos.CENTER); // Center the HBox content

		statisticsTableView.getColumns().addAll(sumColumn, averageColumn, minColumn, maxColumn);

		statistics.getChildren().addAll(statisticsTableView);

		return statistics;
	}
//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

	private HBox createColumnChoiceBox() {
		HBox Columns = new HBox(10);

		// Use the class-level variable instead of declaring a local one
		columnChoiceBox = new ChoiceBox<>(FXCollections.observableArrayList("Israeli_Lines_MWs", "Gaza_Power_Plant_MWs",
				"Egyptian_Lines_MWs", "Total_daily_Supply_available_in_MWs", "Overall_demand_in_MWs",
				"Power_Cuts_hours_day_400mg", "Temp"));

		Columns.getChildren().addAll(columnChoiceBox);

		return Columns;
	}
//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

	/*
	 * public Statistics findStat() { double findSum=0; double findMax=0; for(int
	 * i=0;i<years.getCount();i++) {
	 * 
	 * }
	 * 
	 * 
	 * }
	 */
//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
//######################################################################################################################################
//######################################################################################################################################

	private void saveToFile(String files) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(files))) {
			// Write the formatted data to the file
			String formattedData = getFormattedDataFromLinkedLists();
			writer.write(formattedData);

			System.out.println("Data saved to: " + files);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
//######################################################################################################################################
	private void updateTableView(Statistics stats) {
		// Assuming you have a TableView with columns named statisticTypeColumn and
		// valueColumn
		ObservableList<Statistics> statList = FXCollections.observableArrayList(stats);
		statisticsTableView.setItems(statList);
	}
//######################################################################################################################################
//######################################################################################################################################

//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
//*******************************************************************************************************************************
	/*
	 * public Statistics calculateStatistics(LocalDate locals, String columnName) {
	 * DayNodeData nodes = head; int counts = 0; double sums = 0; double maxs =
	 * Double.MIN_VALUE; double mins = Double.MAX_VALUE;
	 * 
	 * while (nodes != null) { if (nodes.getRecords().getDate().equals(locals)) {
	 * ProjectRecord record = nodes.getRecords(); double value = 0;
	 * 
	 * switch (columnName) { case "Israeli_Lines_MWs": value =
	 * record.getIsraeliLinesData(); break; case "Gaza_Power_Plant_MWs": value =
	 * record.getGazaPowerData(); break; case "Egyptian_Lines_MWs": value =
	 * record.getEgyptianLinesData(); break; case
	 * "Total_daily_Supply_available_in_MWs": value = record.getTotalSupplyData();
	 * break; case "Overall_demand_in_MWs": value = record.getOverallDemandData();
	 * break; case "Power_Cuts_hours_day_400mg": value = record.getPowerCutsData();
	 * break; case "Temp": value = record.getTempData(); break; default:
	 * System.out.println(" Sorry Invalid column name"); return null; }
	 * 
	 * processValue(value, counts, sums, mins, maxs); } nodes = nodes.getNext(); }
	 * 
	 * double average = (counts > 0) ? (sums / counts) : 0;
	 * 
	 * return new Statistics(sums, average, mins, maxs); }
	 */
	public static String day_statistics(int day, String fieldName) {
		double min = Double.MAX_VALUE;
		double max = Double.MIN_VALUE;
		double total = 0;
		int count = 0;

		for (int i = 0; i < years.getCount(); i++) {
			MonthCircularList months = (MonthCircularList) years.getNodeAt(i).monthList;

			for (int j = 0; j < months.count; j++) {
				DaySingleList days = (DaySingleList) months.getNodeAt(j).days;

				for (int k = 0; k < days.getCount(); k++) {
					ProjectRecord record = (ProjectRecord) days.getNodeAt(k).records;
					int day_of_record = ProjectRecord.getDate().getDayOfMonth();

					if (day_of_record == day) {
						double current_value = record.getField(fieldName);

						// Update min and max
						min = Math.min(min, current_value);
						max = Math.max(max, current_value);

						total += current_value;
						count++;
					}
				}
			}
		}

		if (count != 0) {
			double average = total / count;
			return total + " " + average + " " + min + " " + max;
		}

		return null;
	}

//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	private void processValue(double var, int counts, double sums, double mins, double maxs) {
		counts++;
		sums += var;
		mins = Math.min(mins, var);
		maxs = Math.max(maxs, var);
	}
	// $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	// $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	// $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

	private String getFormattedDataFromLinkedLists() {
		return "";
	}

//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	private void initTable33() {
		// Set up the TableView and columns
		tableView33 = new TableView<>();
		tableData33 = FXCollections.observableArrayList();

		// Define TableColumn instances based on your ProjectRecord class
		TableColumn<ProjectRecord, LocalDate> dateColumn33 = new TableColumn<>("Date");
		dateColumn33.setCellValueFactory(new PropertyValueFactory<>("date"));

		TableColumn<ProjectRecord, Double> israeliLinesColumn33 = new TableColumn<>("israeliLinesData");
		israeliLinesColumn33.setCellValueFactory(new PropertyValueFactory<>("israeliLinesData"));

		TableColumn<ProjectRecord, Double> gazaPowerColumn33 = new TableColumn<>("gazaPowerData");
		gazaPowerColumn33.setCellValueFactory(new PropertyValueFactory<>("gazaPowerData"));

		TableColumn<ProjectRecord, Double> egyptianLinesColumn33 = new TableColumn<>("egyptianLinesData");
		egyptianLinesColumn33.setCellValueFactory(new PropertyValueFactory<>("egyptianLinesData"));

		TableColumn<ProjectRecord, Double> totalSupplyColumn33 = new TableColumn<>("totalSupplyData");
		totalSupplyColumn33.setCellValueFactory(new PropertyValueFactory<>("totalSupplyData"));

		TableColumn<ProjectRecord, Double> overallDemandColumn33 = new TableColumn<>("overallDemandData");
		overallDemandColumn33.setCellValueFactory(new PropertyValueFactory<>("overallDemandData"));

		TableColumn<ProjectRecord, Double> powerCutsColumn33 = new TableColumn<>("powerCutsData");
		powerCutsColumn33.setCellValueFactory(new PropertyValueFactory<>("powerCutsData"));

		TableColumn<ProjectRecord, Double> tempColumn33 = new TableColumn<>("tempData");
		tempColumn33.setCellValueFactory(new PropertyValueFactory<>("tempData"));

		// Add TableColumn instances to the TableView
		tableView33.getColumns().addAll(dateColumn33, israeliLinesColumn33, gazaPowerColumn33, egyptianLinesColumn33,
				totalSupplyColumn33, overallDemandColumn33, powerCutsColumn33, tempColumn33);

		// Set the data for the table
		tableView33.setItems(tableData33);
	}

	private void initLoadFileButton33() {
		loadFileButton33 = new Button("Load File");
	}

	public static class StatisticsResult33 {
		public final Double sum33;
		public final Double min33;
		public final Double max33;
		private int count33;

		public StatisticsResult33(Double sum33, Double min33, Double max33) {
			this.sum33 = sum33;
			this.min33 = min33;
			this.max33 = max33;
		}

		public Double getSum() {
			return sum33;
		}

		public Double getMin() {
			return min33;
		}

		public Double getMax() {
			return max33;
		}

		public double getAverage() {
			if (count33 != 0) {
				return sum33 / count33;
			} else {
				return 0.0; // Or handle this case as needed
			}
		}

		public void incrementCount() {
			count33++;
		}

		public void incrementCount(int value) {
			count33 += value;
		}
	}

	private void initStatisticsComponents33() {
		// Set up components for statistics
		statisticsDatePicker33 = new DatePicker();
		statisticsColumnChoiceBox33 = new ChoiceBox<>();
		showStatisticsButton33 = new Button("Show Statistics");
		statisticsResultTableView33 = new TableView<>();
		statisticsResultData33 = FXCollections.observableArrayList();

		// Populate statisticsColumnChoiceBox with available columns
		statisticsColumnChoiceBox33.getItems().addAll("israeliLinesData", "gazaPowerData", "egyptianLinesData",
				"totalSupplyData", "overallDemandData", "powerCutsData", "tempData");

		// Set up the button event handler
		showStatisticsButton33.setOnAction(e -> handleShowStatistics());

		// Add columns to the statisticsResultTableView
		TableColumn<StatisticsResult33, Double> sumColumn = new TableColumn<>("Sum");
		sumColumn.setCellValueFactory(new PropertyValueFactory<>("sum"));

		TableColumn<StatisticsResult33, Double> minColumn = new TableColumn<>("Min");
		minColumn.setCellValueFactory(new PropertyValueFactory<>("min"));

		TableColumn<StatisticsResult33, Double> maxColumn = new TableColumn<>("Max");
		maxColumn.setCellValueFactory(new PropertyValueFactory<>("max"));
		TableColumn<StatisticsResult33, Double> avgolumn = new TableColumn<>("Average");
		avgolumn.setCellValueFactory(new PropertyValueFactory<>("Average"));

		statisticsResultTableView33.getColumns().addAll(avgolumn, sumColumn, minColumn, maxColumn);
		statisticsResultTableView33.setItems(statisticsResultData33);
	}

	private StatisticsResult33 calculateStatistics(LocalDate selectedDate, String selectedColumn) {
		double sum = 0;
		double min = Double.MAX_VALUE;
		double max = Double.MIN_VALUE;
		int count = 0;

		int columnIndex = getColumnIndex(selectedColumn);

		if (columnIndex == -1) {
			System.out.println("Invalid column selected: " + selectedColumn);
			return null;
		}

		for (ProjectRecord record : tableData33) {
			if (record.getDate().equals(selectedDate)) {
				double currentValue = record.getField(columnIndex);

				min = Math.min(min, currentValue);
				max = Math.max(max, currentValue);

				sum += currentValue;
				count++;
			}
		}

		if (count != 0) {
			double average = sum / count;
			StatisticsResult33 result = new StatisticsResult33(sum, min, max);
			result.incrementCount(); // Update the count
			return result;
		} else {
			System.out.println("No data for the selected date and column.");
			return null;
		}
	}

	private void handleShowStatistics() {
		LocalDate selectedDate = statisticsDatePicker33.getValue();
		String selectedColumn = statisticsColumnChoiceBox33.getValue();

		if (selectedDate != null && selectedColumn != null) {
			StatisticsResult33 result = calculateStatistics(selectedDate, selectedColumn);
			if (result != null) {
				statisticsResultData33.clear();
				statisticsResultData33.add(result);
			} else {
				System.out.println("No data for the selected date and column.");
			}
		} else {
			System.out.println("Date or column is not selected.");
		}
	}

	private int getColumnIndex(String selectedColumn) {
		for (int i = 0; i < tableView33.getColumns().size(); i++) {
			if (tableView33.getColumns().get(i).getText().equalsIgnoreCase(selectedColumn)) {
				return i;
			}
		}
		return -1; // Column not found
	}

	private void handleShowMonthStatistics() {
		LocalDate selectedDate = statisticsDatePicker33.getValue();
		String selectedColumn = statisticsColumnChoiceBox33.getValue();

		if (selectedDate != null && selectedColumn != null) {
			StatisticsResult33 result = calculateMonthStatistics(selectedDate, selectedColumn);
			if (result != null) {
				statisticsResultData33.clear();
				statisticsResultData33.add(result);
			} else {
				System.out.println("No data for the selected month and column.");
			}
		} else {
			System.out.println("Date or column is not selected.");
		}
	}

	private StatisticsResult33 calculateYearStatistics(LocalDate selectedDate, String selectedColumn) {
		double sum = 0;
		double min = Double.MAX_VALUE;
		double max = Double.MIN_VALUE;
		int count = 0;

		int columnIndex = getColumnIndex(selectedColumn);

		if (columnIndex == -1) {
			System.out.println("Invalid column selected: " + selectedColumn);
			return null;
		}

		// Get the first day of the selected year
		LocalDate firstDayOfYear = selectedDate.withDayOfYear(1);

		// Get the last day of the selected year
		LocalDate lastDayOfYear = selectedDate.withDayOfYear(selectedDate.lengthOfYear());

		for (ProjectRecord record : tableData33) {
			LocalDate recordDate = record.getDate();

			// Check if the record date is within the selected year
			if (!recordDate.isBefore(firstDayOfYear) && !recordDate.isAfter(lastDayOfYear)) {
				double currentValue = record.getField(columnIndex);

				min = Math.min(min, currentValue);
				max = Math.max(max, currentValue);

				sum += currentValue;
				count++;
			}
		}

		if (count != 0) {
			double average = sum / count;
			StatisticsResult33 result = new StatisticsResult33(sum, min, max);
			result.incrementCount(count); // Update the count
			return result;
		} else {
			System.out.println("No data for the selected year and column.");
			return null;
		}
	}

	private void handleShowYearStatistics() {
		LocalDate selectedDate = statisticsDatePicker33.getValue();
		String selectedColumn = statisticsColumnChoiceBox33.getValue();

		if (selectedDate != null && selectedColumn != null) {
			StatisticsResult33 result = calculateYearStatistics(selectedDate, selectedColumn);
			if (result != null) {
				statisticsResultData33.clear();
				statisticsResultData33.add(result);
			} else {
				System.out.println("No data for the selected year and column.");
			}
		} else {
			System.out.println("Date or column is not selected.");
		}
	}

	private boolean isTextFieldEmpty(TextField textField) {
		return textField.getText().trim().isEmpty();
	}

	private StatisticsResult33 calculateMonthStatistics(LocalDate selectedDate, String selectedColumn) {
		double sum = 0;
		double min = Double.MAX_VALUE;
		double max = Double.MIN_VALUE;
		int count = 0;

		int columnIndex = getColumnIndex(selectedColumn);

		if (columnIndex == -1) {
			System.out.println("Invalid column selected: " + selectedColumn);
			return null;
		}

		// Get the first day of the selected month
		LocalDate firstDayOfMonth = selectedDate.withDayOfMonth(1);

		// Get the last day of the selected month
		LocalDate lastDayOfMonth = selectedDate.withDayOfMonth(selectedDate.lengthOfMonth());

		for (ProjectRecord record : tableData33) {
			LocalDate recordDate = record.getDate();

			// Check if the record date is within the selected month
			if (!recordDate.isBefore(firstDayOfMonth) && !recordDate.isAfter(lastDayOfMonth)) {
				double currentValue = record.getField(columnIndex);

				min = Math.min(min, currentValue);
				max = Math.max(max, currentValue);

				sum += currentValue;
				count++;
			}
		}

		if (count != 0) {
			double average = sum / count;
			StatisticsResult33 result = new StatisticsResult33(sum, min, max);
			result.incrementCount(count); // Update the count with the correct value
			return result;
		} else {
			System.out.println("No data for the selected month and column.");
			return null;
		}
	}

	private StatisticsResult33 calculateDayStatistics(LocalDate selectedDate) {
	    double sum = 0;
	    double min = Double.MAX_VALUE;
	    double max = Double.MIN_VALUE;
	    int count = 0;

	    System.out.println("Selected Date: " + selectedDate);

	    for (ProjectRecord record : tableData33) {
	        LocalDate recordDate = record.getDate();

	        // Check if the day of the record is the same as the selected day
	        if (recordDate.getDayOfMonth() == selectedDate.getDayOfMonth()) {
	            System.out.println("Record Date: " + recordDate);
	            
	            for (int columnIndex = 1; columnIndex < tableView.getColumns().size(); columnIndex++) {
	                double currentValue = record.getField(columnIndex);
	                sum += currentValue;
	                min = Math.min(min, currentValue);
	                max = Math.max(max, currentValue);
	            }
	            count++;
	        }
	    }

	    if (count != 0) {
	        StatisticsResult33 result = new StatisticsResult33(sum, min, max);
	        result.incrementCount(count);
	        System.out.println("Result: " + result.getSum() + " " + result.getMin() + " " + result.getMax());
	        return result;
	    } else {
	        System.out.println("No data for the selected day.");
	        return null;
	    }
	}


	private void handleShowDayStatistics() {
	    LocalDate selectedDate = statisticsDatePicker33.getValue();

	    if (selectedDate != null) {
	        StatisticsResult33 result = calculateDayStatistics(selectedDate);
	        if (result != null) {
	            statisticsResultData33.clear();
	            statisticsResultData33.add(result);
	        } else {
	            System.out.println("No data for the selected day.");
	        }
	    } else {
	        System.out.println("Date is not selected.");
	    }
	}

	private void handleLoadFile33() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Data File");
		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("CSV Files", "*.txt"),
				new FileChooser.ExtensionFilter("All Files", "*.*"));

		File selectedFile = fileChooser.showOpenDialog(null);

		if (selectedFile != null) {
			try {
				loadDataFromFile33(selectedFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void loadDataFromFile33(File file) throws IOException {
		List<String> lines = Files.readAllLines(file.toPath());

		for (String line : lines) {
			String[] parts = line.split(",");
			LocalDate date = LocalDate.parse(parts[0]);
			Double israeliLinesData = Double.parseDouble(parts[1]);
			Double gazaPowerData = Double.parseDouble(parts[2]);
			Double egyptianLinesData = Double.parseDouble(parts[3]);
			Double totalSupplyData = Double.parseDouble(parts[4]);
			Double overallDemandData = Double.parseDouble(parts[5]);
			Double powerCutsData = Double.parseDouble(parts[6]);
			Double tempData = Double.parseDouble(parts[7]);

			ProjectRecord record = new ProjectRecord(date, israeliLinesData, gazaPowerData, egyptianLinesData,
					totalSupplyData, overallDemandData, powerCutsData, tempData);
			tableData33.add(record);
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	private List<ProjectRecord> getTableData() {
		return new ArrayList<>(tableData);
	}
}
