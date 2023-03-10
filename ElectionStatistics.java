package Election_Statistics;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class ElectionStatistics {
	Scanner sc= new Scanner(System.in);
	TreeMap<String, Integer> Candidates = new TreeMap();
	public void entercandidate( ) {
		System.out.println("Enter candidate name");
		String candidateName=sc.next();
		candidateName.toUpperCase();
			if(Candidates.containsKey(candidateName)) {
				System.out.println("Candidate name is already present");
			} else {
				Candidates.put(candidateName, 0);
			}
	}
	public void castvote() {
		System.out.println("Enter candidate name");
		String candidateName= sc.next();
		if(Candidates.containsKey(candidateName)) {
			int vote = (int) Candidates.get(candidateName);
			Candidates.replace(candidateName, vote+1);
			System.out.println("Vote is casted");
		}
	}
	public void countVote() {
		System.out.println("Enter candidate name");
		String candidateName= sc.next();
		if(Candidates.containsKey(candidateName)) {
			int vote = (int) Candidates.get(candidateName);
			System.out.println(candidateName + " has " + vote + " votes");
		} else {
			System.out.println("Enter correct candidate name");
		}
		
	}
	
	public void listVote() {
		Set<Map.Entry<String, Integer>> entryset = Candidates.entrySet();
		for(Entry<String, Integer> candidate : entryset) {
			System.out.println(candidate.getKey()+ " : " + candidate.getValue());
		}
	}
	
	public void getWinner() {	
		Set<Map.Entry<String, Integer>> entryset = Candidates.entrySet();
		Map.Entry<String, Integer> [] candidatesArray = entryset.toArray(new Map.Entry[entryset.size()]);
		boolean temp=true;
		int highestvote= candidatesArray[0].getValue();
		String winner= candidatesArray[0].getKey();
		for(int  i=1; i<candidatesArray.length; i++) {
			if(highestvote < candidatesArray[i].getValue()) {
				highestvote= candidatesArray[i].getValue();
				winner = candidatesArray[i].getKey();
			} else if(highestvote == candidatesArray[i].getValue()) {
				temp= false;
			}
		}
		if(temp) {
			System.out.println("The Winner is "+ winner);
		} else {
			System.out.println("All candidates have same votes, so there is no winner");	
		}
		
	}
	public static void main(String[] args) {
		ElectionStatistics electionStatistics= new ElectionStatistics();
		boolean flag= true;
		while (flag) {
			System.out.println("Enter Command ");
			String choice=electionStatistics.sc.next();
			choice.toLowerCase();
			switch (choice) {
				case "entercandidate": {
						electionStatistics.entercandidate();
					} break;
				case "castvote": {
						electionStatistics.castvote();
					} break;
					
				case "countvote": {
						electionStatistics.countVote();
					} break;
				case "listvote" : {
						electionStatistics.listVote();
					} break;
				case "getwinner" : {
						electionStatistics.getWinner();
					} break;
				case "exit" : {
						flag= false;
					} break;
				default : {
					System.out.println("Enter valid command");
				}
			}
		}

	}

}
