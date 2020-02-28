
import java.util.List;

import java.util.Scanner;
import controller.Typehelper;
import model.PetType;

public class StartWithProgram { 

		static Scanner in = new Scanner(System.in);
		static Typehelper lih = new Typehelper();

		private static void addPet() {
			// TODO Auto-generated method stub
			System.out.print("Enter  pet type: ");
			String pettype = in.nextLine();
			System.out.print("Enter pet name: ");
			String petname = in.nextLine();
			System.out.print("Enter pet owner name: ");
			String ownername = in.nextLine();

			PetType Add = new PetType(pettype , petname, ownername);
			lih.insertItem(Add);
		}

		private static void deletepet() {
			// TODO Auto-generated method stub
			System.out.print("Enter the pet type to delete: ");
			String pettype = in.nextLine();
			System.out.print("Enter the pet name to delete: ");
			String petname = in.nextLine();
			System.out.print("Enter the pet owner name to delete: ");
			String ownername = in.nextLine();

			PetType toDelete = new PetType(pettype , petname, ownername);
			lih.deleteItem(toDelete);
		}

		private static void editpet() {
			// TODO Auto-generated method stub
			System.out.println("How would you like to search for a pet? ");
			System.out.println("1 : Search by Type");
			System.out.println("2 : Search by Pet name");
			System.out.println("3 : Search by owner name");
			int searchBy = in.nextInt();
			in.nextLine();
			List<PetType> foundPets;
			if (searchBy == 1) {
				System.out.print("Enter the type : ");
				String typeName = in.nextLine();
				foundPets = lih.searchForNmaeByType(typeName);
			} else {
				System.out.print("Enter the type: ");
				String petName = in.nextLine();
				foundPets = lih.searchForPetByPet(petName);
			}

			if (!foundPets.isEmpty()) {
				System.out.println("Found Results.");
				for (PetType l : foundPets) {
					System.out.println(l.getId() + " : " + l.returnPetDetails());
				}
				System.out.print("Which ID would like to edit: ");
				int idToEdit = in.nextInt();

				PetType Edit = lih.searchForPetId(idToEdit);
				System.out.println("Retrieved " + Edit.getPetname() + " from " + Edit.getPettype() + " from " + Edit.getOwnername() );
				System.out.println("1 : Update Pet type");
				System.out.println("2 : Update Owner name");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New Type: ");
					String newPet = in.nextLine();
					Edit.setPettype(newPet);
				} else if (update == 2) {
					System.out.print("New Pet: ");
					String newPet = in.nextLine();
					Edit.setOwnername(newPet);
				}

				lih.updatePet(Edit);

			} else {
				System.out.println("Result was not found");
			}

		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			while (goAgain) {
				System.out.println("Select from the list:");
				System.out.println(" 1......Add a pet");
				System.out.println(" 2......Edit a pet");
				System.out.println(" 3......Delete a pet");
				System.out.println(" 4......View the list of the pets");
				System.out.println(" 5......Exit the pet list program");
			
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addPet();
				} else if (selection == 2) {
					editpet();
				} else if (selection == 3) {
					deletepet();
				} else if (selection == 4) {
					viewPetList();
				} else {
					lih.cleanUp();
					System.out.println("  Thank you! see you again   ");
					goAgain = false;
				}

			}

		}

		private static void viewPetList() {
			List<PetType> allPets = lih.showAllType();
			for(PetType singlePet: allPets){
				System.out.println(singlePet.returnPetDetails());
			}

		}

	}
