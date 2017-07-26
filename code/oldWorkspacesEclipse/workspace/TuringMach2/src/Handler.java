import java.awt.*;


public class Handler extends Console {
	public boolean handleEvent(Event event) {
		switch (event.id) {
		//Most components generate ACTION_EVENT
		case Event.ACTION_EVENT:
			if (event.target == okay) {
				textarea.append("OKAY button pressed\n");
				}
			else if (event.target == step) {
				textarea.append("STEP button pressed\n");
				}
			else if (event.target == exit) {
				textarea.append("EXIT button pressed\n");
				}
			else {
				textarea.append("Unknown action event\n");
				}
		break;
		
		case Event.WINDOW_DESTROY:
			textarea.append("Window Destroy\n");
		break;
			
		case Event.WINDOW_ICONIFY:
			textarea.append("Window Iconify\n");
		break;
			
		case Event.WINDOW_DEICONIFY:
			textarea.append("Window DeIconfiy\n");
		break;
		
		case Event.MOUSE_DOWN:
			textarea.append("Mouse down: (" + event.x + "," + event.y + ")\n");
			return false;
			
		case Event.MOUSE_UP:
			textarea.append("Mouse up: (" + event.x + "," + event.y + ")\n");
			return false;
			
		case Event.MOUSE_DRAG:
			textarea.append("Mouse drag: (" + event.x + "," + event.y + ")\n");
			return false;
			
		default:
			return false;
		}
		return true;
	}
		
}	
		
