package ua.fedorenko.playerstatistics;

import java.util.ArrayList;

public class Player implements Comparable<Player> {
	private String nik;
	private Integer allGamesRating = 0;
	private ArrayList<String> games= new ArrayList<String>();

	Player(String nik, ArrayList<String> games){
		this.nik=nik;
		this.games=games;
	}
	
	Player(String nik, int rating){
		this.nik=nik;
		this.allGamesRating=rating;
	}
	
	
	@Override
	public int compareTo (Player gamer) {
		
		int result = 0;
		if (this.allGamesRating == gamer.allGamesRating){
			return this.nik.compareTo(gamer.nik);
		}
		else if (this.allGamesRating < gamer.allGamesRating)
			result = -1;
		else if (this.allGamesRating > gamer.allGamesRating)
			result = 1;
		
		return result;
	}

	public Integer getAllGamesRating() {
		return allGamesRating;
	}



	public String[] getGames(){
		String[] strArr = new String[games.size()];
		strArr = games.toArray(new String[games.size()]);
		return strArr;
	}
	
	public void setRating(){
		this.allGamesRating++;
	}

@Override
public String toString() {
	return "Gamer nik= " + nik + ", Rating= " + allGamesRating ;
}

}
