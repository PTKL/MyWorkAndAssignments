
public class SentenceOvPubl extends SentencePriv{
	private static int search(String sent){ //I can override a private method and make it protected
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
