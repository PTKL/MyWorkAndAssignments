//import java.awt.Choice;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.PrintWriter;
//import java.util.Scanner;
//
//public class GameTree {
//	TreeNode rootNode;
//	private String fileName = "GameSave.txt";
//	private Scanner scan;
//	private String inputFileName;
//	private String outputFileName;
//
//	public GameTree(String question, String yesGuess, String noGuess) {
//		rootNode = new TreeNode(question, rootNode, rootNode);
//		rootNode.setLeftChild(new TreeNode(yesGuess, rootNode, rootNode));
//		rootNode.setRightChild(new TreeNode(noGuess, rootNode, rootNode));
//	}
//	
//	public void question() {
//		rootNode.question();
//
//	}
//
//	// does not work
//
////	public String getSaveName() {
////		return fileName;
////
////	}
//
//	
//	
//	// does not work
//
////	public void saveGame() {
////		outputFileName = fileName;
////		try {
////			PrintWriter fileWriter = new PrintWriter(outputFileName);
////
////			fileWriter.println(rootNode.toString());
////
////			fileWriter.close();
////		} catch (FileNotFoundException e) {
////			System.out.println("Error: Unable to write to " + outputFileName);
////		}
////	}
//
//	// does not work
//	
////	public void loadGame() {
////		inputFileName = fileName;
////		try {
////			scan = new Scanner(new File(inputFileName));
////			while (scan.hasNext()) {
////				System.out.println(scan.nextLine());
////			}
////		} catch (FileNotFoundException e) {
////			// This block would execute if currentFileNane is not found.
////			// We will not have tests to construct GameTree objects with
////			// non-existent files.
////		}
////		// root = build();
////		scan.close();
////	}
//
//	
//
//}
//
