package ie.atu.sw;

public record Author(String firstName, String middleInitial, String surname) {

	public String getFullName() {
		if (middleInitial != null && !middleInitial.isEmpty()) {
			return surname + ", " + firstName + " " + middleInitial + ".";
		}

		return surname + ", " + firstName;
	}

	public String getHarvardName() {
		return surname + ", " + firstName.charAt(0) + ".";
	}
}
