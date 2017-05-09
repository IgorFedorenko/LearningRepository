package ua.fedorenko.playerstatistics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class GameDirector {

	private HashSet<String> games = new HashSet<String>();
	private HashMap<String, HashMap<String, Integer>> gamesPlayerRating = new HashMap<String, HashMap<String, Integer>>();
	private HashMap<String, Player> allPlayers = new HashMap<String, Player>();

	GameDirector() {
		games.add("Call of duty");
		games.add("Stronghold");
		games.add("Prince of Persya");
		games.add("Counter Strike");
		games.add("Bubbles");
		games.add("Assasin Creed");

	}

	public String[] getAllGames() {
		String[] strArr = new String[games.size()];
		strArr = games.toArray(new String[games.size()]);
		return strArr;
	}

	public void setGamesGamersRating(String game, String nik, int rating) {
		if (gamesPlayerRating.containsKey(game)) {
			HashMap<String, Integer> gamers = gamesPlayerRating.get(game);
			if (gamers.containsKey(nik)) {
				Integer rate = gamers.get(nik);
				rate++;
				gamers.put(nik, rate);
				allPlayers.get(nik).setRating();
			} else {
				gamers.put(nik, rating);
			}

		} else {
			HashMap<String, Integer> gamers = new HashMap<String, Integer>();
			gamers.put(nik, 0);
			gamesPlayerRating.put(game, gamers);
		}

	}

	public String addNewGamer(String nik, ArrayList<String> games) throws NullPointerException {
		if (nik.equals(""))
			throw new NullPointerException();
		if (!games.isEmpty()) {
			if (!allPlayers.containsKey(nik)) {
				Player gamer = new Player(nik, games);
				allPlayers.put(nik, gamer);
				for (String game : games) {
					setGamesGamersRating(game, nik, 0);
				}
				
				return "ok";
			} else
				return "Ник уже занят!";
		} else
			return "Не выбрано ни одной игры!";
	}

	public String[] getAllGamers() {
		Set<String> keySet = allPlayers.keySet();
		String[] strArr = new String[keySet.size()];
		strArr = keySet.toArray(new String[keySet.size()]);

		return strArr;
	}

	public String[] getGamerGames(String nik) {
		try {
			String[] strArr = allPlayers.get(nik).getGames();
			return strArr;
		} catch (NullPointerException e) {
			String[] strArr = new String[0];
			return strArr;
		}
	}

	public String[] getGamesAllGamersPlayed() {
		try {
			ArrayList<String> strArrList = new ArrayList<String>();

			Iterator iterat = gamesPlayerRating.entrySet().iterator();

			while (iterat.hasNext()) {
				Entry thisEntry = (Entry) iterat.next();

				if (((HashMap<String, Integer>) thisEntry.getValue()).size() == allPlayers.size()) {
					strArrList.add((String) thisEntry.getKey());
				}
			}
			String[] strArr = strArrList.toArray(new String[strArrList.size()]);

			if (strArr.length == 0)
				throw new NullPointerException();
			return strArr;
		} catch (NullPointerException e) {
			String[] strArr = new String[1];
			strArr[0] = "Нет ни одной игры в которую играют все игроки";

			return strArr;
		}
	}

	public int getGamerInOneGameRating(String game, String nik) {
		int rating = gamesPlayerRating.get(game).get(nik).intValue();

		return rating;
	}
	
	public String[] getAllGamesRating(){
		TreeMap<Player, String> gamers=new TreeMap<Player, String>();
		Iterator iterat = allPlayers.entrySet().iterator();
		while (iterat.hasNext()) {
			Entry thisEntry = (Entry) iterat.next();
			gamers.put((Player) thisEntry.getValue(),((String)thisEntry.getKey()));
			}
		
		Iterator iterat2 = gamers.entrySet().iterator();
		String[] srtArr= new String[gamers.size()];
		int i=0;
		while (iterat2.hasNext()) {
			Entry thisEntry = (Entry) iterat2.next();
			srtArr[i]=(String) thisEntry.getValue()+" - "+ allPlayers.get((String) thisEntry.getValue()).getAllGamesRating();
			i++;
			}
		return srtArr;
		}

	public String[] getTop10InOneGame(String gameForTop10) throws NullPointerException {
		TreeSet<Player> sortGamers= new TreeSet<Player>();
		HashMap<String,Integer> gamers=gamesPlayerRating.get(gameForTop10);
		Iterator iterat = gamers.entrySet().iterator();
		while (iterat.hasNext()) {
			Entry thisEntry = (Entry) iterat.next();
			Player oneGameGamer = new Player ((String)thisEntry.getKey(),(Integer) thisEntry.getValue());
			sortGamers.add(oneGameGamer);
			}
		Iterator<Player> iterat2 = sortGamers.iterator();
		String[] srtArr= new String[gamers.size()];
		int i=0;
		while (iterat2.hasNext()) {
			Player gamer=iterat2.next();
			srtArr[i]=gamer.toString();
			i++;
			}
		return srtArr;
		}

	public void addNewGame(String newGameName) {
		games.add(newGameName);
		System.out.println(games.toString());
		
	}
		
		
		
	
}
