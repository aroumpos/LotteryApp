
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.util.HashSet;
import java.util.NoSuchElementException;
public class JokerMain {
	
	public static void main(String[] args){
		JokerAi AI = new JokerAi();
		Player me = new Player();
		SystemData opap = new SystemData();
                
		opap.Check(me.play(),AI.play()); // με την επιλογή "opap.Check(AI.play(),me.play())" δίνει πρώτα τα νούμερα του τζοκερ.
                
                opap.counting(opap.twentyplays());
	}

}
