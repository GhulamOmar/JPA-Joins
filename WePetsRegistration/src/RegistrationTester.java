
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

import controller.ListDetailsHelper;
import model.ListDetails;
import model.Registration;
import model.Listpet;

public class RegistrationTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Registration susan = new Registration("Susan");
		
		ListDetailsHelper ldh = new ListDetailsHelper();
		
		Listpet shampoo = new Listpet("Cat", "Max");
		Listpet brush = new Listpet("Dog", "POPPY");
		
		List<Listpet> susansItems = new ArrayList<Listpet>();
		susansItems.add(shampoo);
		susansItems.add(brush);
		
		ListDetails susansList = new ListDetails(" Mike OwneerList", LocalDate.now(), susan);
		susansList.setListOfItems(susansItems);
		
		ldh.insertNewListDetails(susansList);
		
		
		List<ListDetails> allLists = ldh.getLists();
		for(ListDetails a: allLists) {
			System.out.println(a.toString());
		}
		

	}

}
