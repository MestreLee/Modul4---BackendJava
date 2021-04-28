import java.util.*;

public class Nivell1 {

	public static void main(String[] args) {
		/*FASE 1: L’exercici consisteix a mostrar per consola una carta d’un restaurant 
		 on afegirem diferents plats i després escollirem que volem per menjar. 
		 Un cop fet això s’haurà de calcular el preu del menjar el programa ens dirà amb quins bitllets hem de pagar.*/
		
		//Creeu una variable int per cada un dels bitllets que existeixen des de 5€ a 500€
		
		int bitllet5Euros = 5;
		int bitllet10Euros = 10;
		int bitllet20Euros = 20;
		int bitllet50Euros = 50;
		int bitllet100Euros = 100;
		int bitllet200Euros = 200;
		int bitllet500Euros = 500;
		
		//haureu de crear un altre variable per guardar el preu total del menjar.  
		
		int preuTotal = 0;
		
		//Creeu dos arrays, un on guardarem el menú i un altre on guardarem el preu de cada plat.
		
		String plats[] = new String[10];
		int preus[] = new int[10];
		
		/*FASE 2: Amb un bucle for haurem d’omplir els dos arrays anteriorment creats. 
		 Afegirem el nom del plat i després el preu. 
		 Pots fer us de diccionaris de dades(Java HasMap).*/
		 HashMap<String, Integer> preuPlat = new HashMap<String, Integer>();
		 
		 preuPlat.put("Macarrons a la bolonyesa", 10);
		 preuPlat.put("Amanida catalana", 8);
		 preuPlat.put("Canelons", 9);
		 preuPlat.put("Paella", 11);
		 preuPlat.put("Ous estrellats", 12);
		 preuPlat.put("Carn a la brasa", 9);
		 preuPlat.put("Confit d'ànec", 13);
		 preuPlat.put("Secret ibèric", 17);
		 preuPlat.put("Daurada al forn", 14);
		 preuPlat.put("Entrecot al roquefort", 11);
		 
		 int numPlats = 0;
		 
		 for (Map.Entry<String, Integer> entry : preuPlat.entrySet()) {
			 plats[numPlats] = entry.getKey();
			 preus[numPlats] = entry.getValue(); 
			 numPlats ++;
		 }
		 
		 
		 /*Un cop plens els dos arrays haurem de mostrar-los i preguntar que es vol per menjar, 
		  guardarem la informació en una List fent servir un bucle while. */
		 /*Haurem de preguntar si es vol seguir demanant menjar. 
		  Podeu fer servir el sistema (1:Si / 0:No), per tant haureu de crear un altre variable int per guardar la informació. */
		 
		 ArrayList<String> menu = new ArrayList<String>();
		 		 
		 Scanner myObj = new Scanner(System.in);
		 System.out.println("Aquest és el menú del dia: ");
		 
		 for (int i = 0; i < plats.length; i++) {
			 System.out.println(plats[i] + " " + preus[i] + "€");
		 }
		 
		 int seguirDemanant = 1;
		 String plat;
		 boolean test = true;
		 
		
		 while (seguirDemanant == 1) {
			 System.out.println("Quin plat voleu demanar? ");
			 plat = myObj.nextLine(); 
			 test = Arrays.asList(plats).contains(plat);
		     
			 if (!test){
		      	while(!test){	
		      		System.out.println ("Introdueix un plat que estigui al menú!");
		      		plat = myObj.nextLine();
		      		test = Arrays.asList(plats).contains(plat);
		      	}
		     }
			 
			 menu.add(plat);		      	
			 System.out.println("Voleu demanar alguna cosa més? 1 - Si | 0 - No");
			 try {
				 seguirDemanant = myObj.nextInt();
				 
			 }catch (Exception e){
				 System.out.println("Error! No has introduit un element vàlid!");
				//Li donem un valor int a seguirDemanant diferent de 0 o 1 per
				//Disparar la condició de l'if + while
				 seguirDemanant = 3;  
			 }finally {
				// Llegim la new-line que causa problemes amb l'scanner si no es fa:
				 myObj.nextLine();
			 }

			 if (seguirDemanant != 0 && seguirDemanant != 1) {
				 while(seguirDemanant != 0 && seguirDemanant != 1) {
					 System.out.println("Escriu només 1 si vols seguir demanant o 0 si no vols seguir demanant:");
					 try {
						 seguirDemanant = myObj.nextInt();
					 }catch(Exception e) {
						 System.out.println("Error! No has introduit un element vàlid!");
					 }finally {
						// Llegim la new-line que causa problemes amb l'scanner si no es fa:
						 myObj.nextLine();
					 }	 
					 
				 }
			 }
		 }
		 System.out.println(menu);
		 
		 /*FASE 3: Un cop hem acabat de demanar el menjar, haurem de comparar la llista amb l’array que hem fet al principi. 
		 En el cas que la informació que hem introduït a la List coincideixi amb la del array, 
		 haurem de sumar el preu del producte demanat; 
		 en el cas contrari haurem de mostrar un missatge que digui que el producte que hem demanat no existeix. */
		 
		 int index;
		 System.out.println("Heu demanat: ");
		 for (String i : menu) {
			 System.out.println(i);
			 index = Arrays.asList(plats).indexOf(i);
			 preuTotal = preuTotal + preus[index];
		 }
		 
		 System.out.println("El preu total és de: " + preuTotal + " €");

	}

}
