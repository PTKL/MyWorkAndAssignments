import java.io.*;

public class CardInputStream extends InputStream {
	@Override
	public int read() throws IOException {
		return 0;
	}

	BufferedReader bufRead;

	public CardInputStream(InputStream input) {
		bufRead = new BufferedReader(new InputStreamReader(input));
	}

	public String readResponse() {
		try {
			return bufRead.readLine();
		} catch (IOException e) {
			System.out.println("UNABLE TO READ");
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void close() {
		try {
			bufRead.close();
		} catch (IOException e) {
			System.out.println("CAN'T CLOSE");
			e.printStackTrace();
		}
	}

	public Card readCard() {
		try {
			long id = Long.parseLong(bufRead.readLine());
			String name = bufRead.readLine();
			CardRank rank = CardRank.parseEnumRank(bufRead.readLine());
			long price = Long.parseLong(bufRead.readLine());

			return new Card(id, name, rank, price);
		} catch (NumberFormatException e) {
			System.out.println("INVALID FORMAT");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("UNABLE TO READ");
			e.printStackTrace();
		}

		return null;
	}
}
