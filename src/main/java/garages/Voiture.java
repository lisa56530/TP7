package garages;

import java.io.PrintStream;
import java.util.*;

public class Voiture {

	private final String immatriculation;
	private final List<Stationnement> myStationnement = new LinkedList<>();

	public Voiture(String i) {
		if (null == i) {
			throw new IllegalArgumentException("Une voiture doit avoir une immatriculation");
		}

		immatriculation = i;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	/**
	 * Fait rentrer la voiture au garage
	 * Précondition : la voiture ne doit pas être déjà dans un garage
	 *
	 * @param g le garage où la voiture va stationner
	 * @throws java.lang.Exception Si déjà dans un garage
	 */
	public void entreAuGarage(Garage g) throws Exception {
		// Et si la voiture est déjà dans un garage ?

		Stationnement s = new Stationnement(this, g);
		
		if(s.getFin() != null) {
		 myStationnement.add(s);
		}
	}

	/**
	 * Fait sortir la voiture du garage
	 * Précondition : la voiture doit être dans un garage
	 *
	 * @throws java.lang.Exception si la voiture n'est pas dans un garage
	 */
	public void sortDuGarage() throws Exception {
		throw new UnsupportedOperationException("Pas encore implémenté");
		// TODO: Implémenter cette méthode
		// Trouver le dernier stationnement de la voiture
		// Terminer ce stationnement
		int indiceDernierStationnement = myStationnement.size()-1;
		Stationnement dernierStationnement = myStationnement.get(indiceDernierStationnement); 
		if (dernierStationnement.estEnCours()) {
			dernierStationnement.terminer(); 
		} else {
			throw new Exception ("la voiture est deja sortie ou la voiture n'a pas de stationnement");
		
		}
	}

	/**
	 * @return l'ensemble des garages visités par cette voiture
	 */
	public Set<Garage> garagesVisites() {
		// TODO: Implémenter cette méthode
		//throw new UnsupportedOperationException("Pas encore implémenté");
		HashSet<Garage> jarages = new HashSet <Garage>() ; 
		for (Stationnement s : myStationnement) {
				jarages.add(s.getGarage()) ;
		}
		return jarages ; 
		


	}

	/**
	 * @return vrai si la voiture est dans un garage, faux sinon
	 */
	public boolean estDansUnGarage() {
		// TODO: Implémenter cette méthode
		throw new UnsupportedOperationException("Pas encore implémenté");
		// Vrai si le dernier stationnement est en cours
		Stationnement sta = myStationnement.get(myStationnement.size()-1);

		if (sta.estEnCours()) { 
			return true ;
		} 
		else return false ; 
	}

	

	/**
	 * Pour chaque garage visité, imprime le nom de ce garage suivi de la liste des
	 * dates d'entrée / sortie dans ce garage
	 * <br>
	 * Exemple :
	 * 
	 * <pre>
	 * Garage Castres:
	 *		Stationnement{ entree=28/01/2019, sortie=28/01/2019 }
	 *		Stationnement{ entree=28/01/2019, en cours }
	 *  Garage Albi:
	 *		Stationnement{ entree=28/01/2019, sortie=28/01/2019 }
	 * </pre>
	 *
	 * @param out l'endroit où imprimer (ex: System.out)
	 */
		public void imprimeStationnements(PrintStream out) {
		Set<Garage> liststa = garagesVisites();
		for(Garage ga : liststa) {
			System.out.println(ga.toString());
			for (Stationnement st : myStationnement) {
				if(st.getGarage().equals(ga)) {
					System.out.println(st.toString());
				}	
			}
		}
	}

}
