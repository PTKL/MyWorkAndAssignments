
public class SentenceOvPriv extends SentencePubl{
	private static int search(String sent){ //I cannot override a public method and make it private
		if (sent.equals("")){
			return 0;
		}
		else if (sent.charAt(0)=='e'){
			return 1 + search(sent.substring(1));
		}
		else {
			return search(sent.substring(1));
		}
	}
}

//I cannot reduce the visibility of the inherited method
//I can expand the visibility of the inherited method