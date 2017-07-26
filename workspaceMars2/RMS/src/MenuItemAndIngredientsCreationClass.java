import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * Used to create the MenuItem and Ingredient objects that will be
 * present in our restraunt. We then use the toString() method
 * and write them to a file so they can be inserted into
 * the database. AddMenuItemsAndIngredientsToDatabase.java
 * is the class that inserts the produced toString()'s into
 * the correct databases.
 * 
 * @author callum
 */
public class MenuItemAndIngredientsCreationClass {
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException{
		//for us to cycle through when write them to files
		ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();
		ArrayList<MenuItem> menuItemList = new ArrayList<MenuItem>();		
		
		//ingredient list
		Allergry[] nullArray = {};
		
		Ingredient steakMince = new Ingredient("500g Mince Steak", 2, 100, nullArray);
		ingredientList.add(steakMince);
		
		Ingredient onion = new Ingredient("Red Onion", 1, 20, nullArray);
		ingredientList.add(onion);
		
		Ingredient tomatoe = new Ingredient("Tomatoe", 1, 20, nullArray);
		ingredientList.add(tomatoe);
		
		Allergry[] cheeseAlg = {Allergry.Milk};
		Ingredient cheese = new Ingredient("100g Mild Cheddar Cheese", 1, 150, cheeseAlg);
		ingredientList.add(cheese);
		
		Allergry[] nanchoAlg = {Allergry.Wheat, Allergry.Egg};
		Ingredient nancho = new Ingredient("150g Nancho Chips", 2, 100, nanchoAlg);
		ingredientList.add(nancho);
		
		Ingredient mango = new Ingredient("Mango", 1, 60, nullArray);
		ingredientList.add(mango);
		
		Ingredient chilli = new Ingredient("Green Chilli", 1, 40, nullArray);
		ingredientList.add(chilli);
		
		Ingredient cumcumber = new Ingredient("Cucumber", 1, 50, nullArray);
		ingredientList.add(cumcumber);
		
		Ingredient springOnion = new Ingredient("Spring Onion", 1, 50, nullArray);
		ingredientList.add(springOnion);
		
		Allergry[] prawnsAlg = {Allergry.Shellfish};
		Ingredient prawns = new Ingredient("500g King Prawns",2,200,prawnsAlg);
		ingredientList.add(prawns);
		
		Ingredient coke = new Ingredient("500ml Coke", 1, 90, nullArray);
		ingredientList.add(coke);
		
		Ingredient ice = new Ingredient("Ice", 0, 5, nullArray);
		ingredientList.add(ice);
		
		Ingredient sprite = new Ingredient("500ml Sprite", 1, 90, nullArray);
		ingredientList.add(sprite);
		
		Ingredient tequila = new Ingredient("Tequila", 2, 25, nullArray);
		ingredientList.add(tequila);
		
		Ingredient orangeJuice = new Ingredient("Orange Juice", 1, 20, nullArray);
		ingredientList.add(orangeJuice);
		
		Ingredient malibu = new Ingredient("Malibu", 2, 40, nullArray);
		ingredientList.add(malibu);
		
		Ingredient cranberryJuice = new Ingredient("Cranberry Juice", 1, 20, nullArray);
		ingredientList.add(cranberryJuice);
		
		Ingredient pulledPork = new Ingredient(" 500g Pulled Shreaded Pork", 3, 200, nullArray);
		ingredientList.add(pulledPork);
		
		Ingredient burritoWrap = new Ingredient("Burrito Wrap", 1, 40, nullArray);
		ingredientList.add(burritoWrap);
		
		Ingredient chicken = new Ingredient("500g Chicken", 2, 200, nullArray);
		ingredientList.add(chicken);
		
		Ingredient sweetcorn = new Ingredient("Sweetcorn", 1, 10, nullArray);
		ingredientList.add(sweetcorn);
		
		Ingredient blackBeans = new Ingredient("Black Beans", 1, 10, nullArray);
		ingredientList.add(blackBeans);
		
		Ingredient chickpeas = new Ingredient("Chickpeas", 1, 10, nullArray);
		ingredientList.add(chickpeas);
		
		Ingredient rice = new Ingredient("Rice", 1, 200, nullArray);
		ingredientList.add(rice);
		
		Ingredient flour = new Ingredient("Flour", 1, 100, nullArray);
		ingredientList.add(flour);
		
		Ingredient sugar = new Ingredient("Sugar", 1, 150, nullArray);
		ingredientList.add(sugar);
		
		Ingredient cinnamon = new Ingredient("Cinnamon", 1, 10, nullArray);
		ingredientList.add(cinnamon);
		
		//STARTERS
		Catergory[] beefNachosCat = {Catergory.Starter};
		Ingredient[] beefNachosIng = {steakMince,onion,onion,tomatoe,tomatoe,tomatoe,tomatoe,cheese,nancho};
		MenuItem beefNachos = new MenuItem("Beef Nachos - To Share", "http://media-cache-ak0.pinimg.com/736x/b4/b3/11/b4b31105c032efb330af25d5d1ed9d99.jpg",8, beefNachosIng,beefNachosCat);
		menuItemList.add(beefNachos);
		
		Catergory[] mangoSalsaCat = {Catergory.Starter, Catergory.Vegetarian};
		Ingredient[] mangoSalsaIng = {nancho,tomatoe,tomatoe,onion,mango,mango,chilli,cumcumber,cumcumber};
		MenuItem mangoSalsa = new MenuItem("Mango Salsa with chips", "http://fitnesscheerleader.com/wp-content/uploads/2011/07/MangoSalsa.jpg", 8, mangoSalsaIng, mangoSalsaCat);
		menuItemList.add(mangoSalsa);
		
		Catergory[] tomatoeSalsaCat = {Catergory.Starter, Catergory.Vegetarian};
		Ingredient[] tomatoeSalsaIng = {nancho,tomatoe,tomatoe,tomatoe,tomatoe,onion,onion,chilli,cumcumber};
		MenuItem tomatoeSalsa = new MenuItem("Tomatoe Salsa with chips", "http://2.bp.blogspot.com/--WNE3PY7sp4/TmbIVxnfwUI/AAAAAAAAF5k/2xSQ-6wSav8/s1600/016.JPG", 8, tomatoeSalsaIng, tomatoeSalsaCat);
		menuItemList.add(tomatoeSalsa);
		
		Catergory[] spicyPrawnCocktailCat = {Catergory.Starter};
		Ingredient[] spicyPrawnCocktailIng = {cumcumber,tomatoe,chilli,springOnion,springOnion,prawns};
		MenuItem spicyPrawnCocktail = new MenuItem("Spicy Prawn Cocktail", "http://thumbs.ifood.tv/files/image/31/48/40863-spicy-mexican-shrimp-amp-avocado-cocktail.jpg", 9, spicyPrawnCocktailIng, spicyPrawnCocktailCat);
		menuItemList.add(spicyPrawnCocktail);
		
		//MAINS
		Catergory[] pulledPortBurritoCat = {Catergory.Main};
		Ingredient[] pulledPortBurritoIng = {onion,tomatoe,pulledPork,burritoWrap,burritoWrap};
		MenuItem pulledPortBurrito = new MenuItem("Pulled Pork Burrito", "http://images.edge-generalmills.com/8e600bb1-e35f-46c9-ae13-98677cf42711.jpg", 11, pulledPortBurritoIng, pulledPortBurritoCat);
		menuItemList.add(pulledPortBurrito);
		
		Catergory[] chickenEnchiladasCat = {Catergory.Main};
		Ingredient[] chickenEnchiladasIng = {onion,tomatoe,burritoWrap,burritoWrap,cheese,chicken};
		MenuItem chickenEnchiladas = new MenuItem("Chicken Enchiladas", "http://farm4.static.flickr.com/3563/3796088529_2b71f9138b.jpg", 11, chickenEnchiladasIng, chickenEnchiladasCat);
		menuItemList.add(chickenEnchiladas);
		
		Catergory[] beanSaladCat = {Catergory.Main , Catergory.Vegetarian};
		Ingredient[] beanSaladIng = {onion, chilli, chilli, blackBeans, chickpeas, sweetcorn };
		MenuItem beanSalad = new MenuItem("Bean Salad", "http://www.foodfood.com/wp-content/uploads/2012/07/mexican-bean-salad.jpg", 11, beanSaladIng, beanSaladCat);
		menuItemList.add(beanSalad);
		
		Catergory[] beefBeanChilliCat = {Catergory.Main};
		Ingredient[] beefBeanChilliIng = {onion, chilli, blackBeans, chickpeas, steakMince, rice };
		MenuItem beefBeanChilli = new MenuItem("Beef Bean Chilli", "http://www.foodsnaps.co.uk/wp-content/uploads/2010/06/DSC0008-Edit.jpg", 11, beefBeanChilliIng, beefBeanChilliCat);
		menuItemList.add(beefBeanChilli);
		
		//DESSERTS
		Catergory[] churrosCat = {Catergory.Dessert, Catergory.Vegetarian};
		Ingredient[] churrosIng = {flour, sugar, sugar, cinnamon};
		MenuItem churros = new MenuItem("Churros", "http://churrostix.com/wp-content/uploads/IMG_RR.jpg", 11, churrosIng, churrosCat);
		menuItemList.add(churros);
		
		//DRINKS	
		Catergory[] cokeCat = {Catergory.Drink};
		Ingredient[] cokeIng = {ice,coke};
		MenuItem glassOfCoke = new MenuItem("Coke", "https://images.duckduckgo.com/iu/?u=http%3A%2F%2Fconnectivity.cqrollcall.com%2Fwp-content%2Fuploads%2F2014%2F11%2Fsoda-glass.jpg&f=1", 2, cokeIng, cokeCat);
		menuItemList.add(glassOfCoke);
		
		Catergory[] spriteCat = {Catergory.Drink};
		Ingredient[] spriteIng = {ice,sprite};
		MenuItem glassOfSprite = new MenuItem("Sprite", "https://images.duckduckgo.com/iu/?u=http%3A%2F%2Fpacificonlinespirits.com%2Fimages%2Fproducts%2Fdetail%2Fabsolutlemonade.jpg&f=1", 2, spriteIng, spriteCat);
		menuItemList.add(glassOfSprite);
		
		Catergory[] tequilaSunriseCat = {Catergory.Drink, Catergory.Alcohol};
		Ingredient[] tequilaSunriseIng = {malibu,tequila,orangeJuice,orangeJuice};
		MenuItem tequilaSunrise = new MenuItem("Tequilla Sunrise","http://www.shavans.com.au/uploads/images/sunrise-tequila.jpg",6,tequilaSunriseIng,tequilaSunriseCat);
		menuItemList.add(tequilaSunrise);		
		
		Catergory[] mexicanMadrasCat = {Catergory.Drink, Catergory.Alcohol};
		Ingredient[] mexicanMadrasIng = {ice,tequila,orangeJuice,cranberryJuice,cranberryJuice,cranberryJuice};
		MenuItem mexicanMadras = new MenuItem("mexicanMadras","https://41.media.tumblr.com/4c2dbbc764dd700c214fa9e657c5fe02/tumblr_mw54g0advt1smv39ro1_500.jpg",8,mexicanMadrasIng,mexicanMadrasCat);
		menuItemList.add(mexicanMadras);
		
		//write ingredients to their file
		//need to include stock level, could make dif per ingredient but 
		PrintWriter writer = new PrintWriter("ingredientsToAddToDatabase.txt", "UTF-8");
		writer.flush();
		for(Ingredient i : ingredientList){
			writer.println(50+"	"+i.toString());
		}
		writer.flush();
		writer.close();
		
		//write menuItems to their file
		PrintWriter writer2 = new PrintWriter("menuItemsToAddToDatabase.txt", "UTF-8");
		writer2.flush();
		for(MenuItem m : menuItemList){
			writer2.println(m.toString());
		}
		writer2.flush();
		writer2.close();
	}
}
