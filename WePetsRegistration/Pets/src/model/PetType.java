package model;

		import javax.persistence.Column;


		import javax.persistence.Entity;
		import javax.persistence.GeneratedValue;
		import javax.persistence.GenerationType;
		import javax.persistence.Id;
		import javax.persistence.Table;

		@Entity
		@Table(name="pets")
		public class PetType {
			@Id
			@GeneratedValue(strategy=GenerationType.IDENTITY)
			@Column(name="ID")
			private int id;
			@Column(name="PetType")
			private String pettype;
			@Column(name="Petname")
			private String petname;
			@Column(name="Ownername")
			private String ownername;
			
			public PetType() {
				super();
				// TODO Auto-generated constructor stub
			}
			
			public PetType(String pettype, String petname, String ownername ) {
				super();
				this.pettype = pettype;
				this.petname = petname;
				this.ownername = ownername;
			}

			public int getId() {
				return id;
			}

			public void setId(int id) {
				this.id = id;
			}

			public String getPettype() {
				return pettype;
			}

			public void setPettype(String pettype) {
				this.pettype = pettype;
			}

			public String getPetname() {
				return petname;
			}

			public void setPetname(String petname) {
				this.petname = petname;
			}
			public String getOwnername() {
				return ownername;
			}

			public void setOwnername(String ownername) {
				this.ownername = ownername;
			}
			public String returnPetDetails( ) {
				return pettype + ": " + petname + ": " + ownername;
			}

		}
