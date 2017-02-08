package main.java.web.services.authentification;

public enum Role {
	CLIENT("CLIENT"), ETABLISSEMENT("ETABLISSEMENT"), GESTIONNAIRE(
			"GESTIONNAIRE"), ADMINISTRATEUR("ADMINISTRATEUR");

	private String value;

	private Role(String s) {
		value = s;
	}

	public boolean equalsName(String otherName) {
		// (otherName == null) check is not needed because name.equals(null)
		// returns false
		return value.equals(otherName);
	}

	public String toString() {
		return this.value;
	}
}
