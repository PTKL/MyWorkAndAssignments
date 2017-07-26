import java.util.ArrayList;

public class Hotel {
	public Hotel(int numberOfRooms, int personsPerRoom) {
		this.numberOfRooms = numberOfRooms;
		this.personsPerRoom = personsPerRoom;
		rooms = new ArrayList<FastRoom>();
		for (int i = 0; i < numberOfRooms; ++i) {
			rooms.add(new FastRoom(personsPerRoom));
		}
		/* Update this to take */
		for (FastRoom room : rooms)
			if (room.sameBirthday())
				++sameBirthdayRooms;
	}

	public int getSameBirthdayRooms() {
		return sameBirthdayRooms;
	}

	@Override
	public String toString() {
		return "Person per room "
				+ personsPerRoom
				+ " and the fraction of room that have two or more with the same birday is "
				+ ((double) sameBirthdayRooms / numberOfRooms);
	}

	int numberOfRooms;
	int personsPerRoom;
	ArrayList<FastRoom> rooms;
	int sameBirthdayRooms = 0;
}
