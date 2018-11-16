package readlines;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ReadLineManager {

	private List<ReadLineObserver> observers = new ArrayList();
	private BufferedReader br;

	public void registerObserver(ReadLineObserver o) {
		observers.add(o);
	}

	public void removeObserver(ReadLineObserver o) {
		if (observers.contains(o)) {
			observers.remove(o);
		}
	}
	
	public void removeAllObservers() {
		observers.clear();
	}

	private void notifyObservers(String line) {
		for (ReadLineObserver o : observers) {
			o.notify(line);
		}
	}
	
	public void startReading() {
		br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				String line = br.readLine();
				notifyObservers(line);
			} catch (IOException e) {
				break;
			}
		}
	}
	
	public void stopReading() throws IOException {
		br.close();
	}
}
