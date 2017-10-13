package api.domain;

public class Query {

	private Bool bool;

	public Query() {
		this.bool = new Bool();
	}

	public Bool getBool() {
		return bool;
	}

}