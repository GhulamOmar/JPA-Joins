

import java.util.List;
import java.util.Scanner;

import controller.ListPetHelper;
import model.Listpet;

public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static ListPetHelper lih = new ListPetHelper();

		private static void addAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter a Type: ");
			String store = in.nextLine();
			System.out.print("Enter an pet: ");
			String item = in.nextLine();

			Listpet toAdd = new Listpet(store, item);
			lih.insertItem(toAdd);
		}

		private static void deleteAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter the type to delete: ");
			String store = in.nextLine();
			System.out.print("Enter the pet to delete: ");
			String item = in.nextLine();

			Listpet toDelete = new Listpet(store, item);
			lih.deleteItem(toDelete);
		}

		private static void editAnItem() {
			// TODO Auto-generated method stub
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by type");
			System.out.println("2 : Search by pet");
			int searchBy = in.nextInt();
			in.nextLine();
			List<Listpet> foundItems;
			if (searchBy == 1) {
				System.out.print("Enter the type name: ");
				String storeName = in.nextLine();
				foundItems = lih.searchForItemByStore(storeName);
			} else {
				System.out.print("Enter the pet: ");
				String itemName = in.nextLine();
				foundItems = lih.searchForItemByItem(itemName);
			}

			if (!foundItems.isEmpty()) {
				System.out.println("Found Results.");
				for (Listpet l : foundItems) {
					System.out.println(l.getId() + " : " + l.returnItemDetails());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				Listpet toEdit = lih.searchForItemById(idToEdit);
				System.out.println("Retrieved " + toEdit.getItem() + " from " + toEdit.getStore());
				System.out.println("1 : Update type");
				System.out.println("2 : Update pet");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New type: ");
					String newStore = in.nextLine();
					toEdit.setStore(newStore);
				} else if (update == 2) {
					System.out.print("New Pet: ");
					String newItem = in.nextLine();
					toEdit.setItem(newItem);
				}

				lih.updateItem(toEdit);

			} else {
				System.out.println("---- No results found");
			}

		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Welcome to our awesome Rrgistration list! ---");
			while (goAgain) {
				System.out.println("*  Select an pet:");
				System.out.println("*  1 -- Add an pet");
				System.out.println("*  2 -- Edit an pet");
				System.out.println("*  3 -- Delete an pet");
				System.out.println("*  4 -- View the pet");
				System.out.println("*  5 -- Exit the awesome program");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addAnItem();
				} else if (selection == 2) {
					editAnItem();
				} else if (selection == 3) {
					deleteAnItem();
				} else if (selection == 4) {
					viewTheList();
				} else {
					lih.cleanUp();
					System.out.println("  Bye!   ");
					goAgain = false;
				}

			}

		}

		private static void viewTheList() {
			List<Listpet> allItems = lih.showAllItems();
			for(Listpet singleItem : allItems){
				System.out.println(singleItem.returnItemDetails());
			}

		}

	}
