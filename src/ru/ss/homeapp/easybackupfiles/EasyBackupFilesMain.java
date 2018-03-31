package ru.ss.homeapp.easybackupfiles;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javafx.application.Application;
import javafx.stage.Stage;

public class EasyBackupFilesMain extends Application {

	@Override
	public void start(Stage primaryStage) {

		// D:\eclipseProjects\from
		String from = "D:/eclipseProjects/from";
		String to = "D:/eclipseProjects/to";

		getFileTree(from);
		// copyFiles(from, to);
	}

	public static void main(String[] args) {
		launch(args);
	}

	private void getFileTree(String from) {

		System.out.println("start directory: " + from);
		
		File file = new File(from);
		
		if(file.isDirectory()) {
			getFileTree(file.getPath());
		}
		
	}

	private void copyFiles(String from, String to) {
		File fileSource = new File(from);
		File fileTarget = new File(to);

		if (fileTarget.exists()) {
			fileTarget.delete();
		}

		try {
			Files.copy(fileSource.toPath(), fileTarget.toPath());
		} catch (IOException ex) {
			System.out.println("copy file failed: name=" + from);
			ex.printStackTrace();
		}
	}
}
