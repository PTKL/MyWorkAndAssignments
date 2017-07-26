import java.awt.Choice;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class GameTree {
	TreeNode rootNode;
	private String fileName = "GameSave.txt";
	private Scanner scan;
	private String inputFileName;
	private String outputFileName;

	public GameTree(String question, String yesGuess, String noGuess) {
		rootNode = new TreeNode(question);
		rootNode.setLeftChild(new TreeNode(yesGuess));
		rootNode.setRightChild(new TreeNode(noGuess));
	}

	public void add(String newQuestion, String newAnswer) {

	}

	public boolean foundAnswer() {
		return false;

	}

	public String getCurrent() {
		return fileName;

	}

	public void playerSelected(Choice yesOrNo) {

	}

	public void reStart() {

	}

	public void saveGame() {
		outputFileName = fileName;
		try {
			PrintWriter fileWriter = new PrintWriter(outputFileName);

			fileWriter.println(rootNode.toString());

			fileWriter.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error: Unable to write to " + outputFileName);
		}
	}

	public void loadGame() {
		inputFileName = fileName;
		try {
			scan = new Scanner(new File(inputFileName));
			while (scan.hasNext()) {
				System.out.println(scan.nextLine());
			}
		} catch (FileNotFoundException e) {
			// This block would execute if currentFileNane is not found.
			// We will not have tests to construct GameTree objects with
			// non-existent files.
		}
		// root = build();
		scan.close();
	}

	public void question() {
		rootNode.question();

	}

}

// Need an inner TreeNode class here . . .
// private TreeNode root;
// private Scanner inFile;
// private String currentFileName;
//
// public GameTree(String fileName) {
// currentFileName = fileName;
// try {
// inFile = new Scanner(new File(currentFileName));
// } catch (FileNotFoundException e) {
// // This block would execute if currentFileNane is not found.
// // We will not have tests to construct GameTree objects with
// // non-existent files.
// }
// root = build();
// inFile.close();
// }