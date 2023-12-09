package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.List;

public class YourApplication extends Application {
	private Button loadFileButton33; // Added Load File button

	private TableView<ProjectRecord> tableView33;
	private ObservableList<ProjectRecord> tableData33;
	private DatePicker statisticsDatePicker33;
	private ChoiceBox<String> statisticsColumnChoiceBox33;
	private Button showStatisticsButton33;
	private TableView<StatisticsResult33> statisticsResultTableView33; // Modified to StatisticsResult
	private ObservableList<StatisticsResult33> statisticsResultData33; // Modified to StatisticsResult

	@Override
	public void start(Stage primaryStage) {
		initTable33();
		initStatisticsComponents33();
		initLoadFileButton33(); // Initialize the Load File button
		loadFileButton33 = new Button("Load File");
		Button showYearButton33 = new Button("Show Year");
		showYearButton33.setOnAction(e -> handleShowYearStatistics());
		loadFileButton33.setOnAction(e -> handleLoadFile33());
		Button showMonthButton33 = new Button("Show Month");
		showMonthButton33.setOnAction(e -> handleShowMonthStatistics());
		VBox statisticsLayout33 = new VBox(loadFileButton33, tableView33, statisticsDatePicker33, statisticsColumnChoiceBox33,
				showStatisticsButton33, showMonthButton33,showYearButton33, statisticsResultTableView33);

		// Create the Scene
		Scene statisticsScene33 = new Scene(statisticsLayout33, 800, 600);
		showYearButton33.setOnAction(e -> handleShowYearStatistics());

		// Set the scene and show the stage
		primaryStage.setScene(statisticsScene33);
		primaryStage.setTitle("Statistics Screen");
		primaryStage.show();
		loadFileButton33.setOnAction(e -> handleLoadFile33());

	}

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

	// ...

	// Modify StatisticsResult class to hold sum, min, and max values
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

}
