import com.cegedim.puissance4.entity.CouleurCase;
import com.cegedim.puissance4.service.PlateauDeJeuService;

import junit.framework.*;

public class testU extends TestCase {

  public void testVictoire() throws Exception {

	  /*
	   * Cas de test de détection de la victoire du joueur rouge
	   */
	  PlateauDeJeuService.getInstance()
		.initialiserJeu(new CouleurCase[][] {
				{ CouleurCase.VIDE, CouleurCase.VIDE, CouleurCase.VIDE, CouleurCase.VIDE, CouleurCase.VIDE,
						CouleurCase.VIDE, CouleurCase.VIDE },
				{ CouleurCase.VIDE, CouleurCase.VIDE, CouleurCase.VIDE, CouleurCase.VIDE, CouleurCase.VIDE,
						CouleurCase.VIDE, CouleurCase.VIDE },
				{ CouleurCase.VIDE, CouleurCase.VIDE, CouleurCase.ROUGE, CouleurCase.ROUGE, CouleurCase.VIDE,
						CouleurCase.VIDE, CouleurCase.VIDE },
				{ CouleurCase.VIDE, CouleurCase.VIDE, CouleurCase.JAUNE, CouleurCase.ROUGE, CouleurCase.VIDE,
						CouleurCase.VIDE, CouleurCase.VIDE },
				{ CouleurCase.JAUNE, CouleurCase.ROUGE, CouleurCase.ROUGE, CouleurCase.JAUNE, CouleurCase.ROUGE,
						CouleurCase.VIDE, CouleurCase.JAUNE },
				{ CouleurCase.ROUGE, CouleurCase.JAUNE, CouleurCase.JAUNE, CouleurCase.JAUNE, CouleurCase.ROUGE,
						CouleurCase.ROUGE, CouleurCase.JAUNE } });
	  
	  assertTrue(CouleurCase.ROUGE.equals(PlateauDeJeuService.getInstance().determineVainqueur().get()));
  }
}