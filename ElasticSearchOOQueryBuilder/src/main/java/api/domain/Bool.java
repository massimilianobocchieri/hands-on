package api.domain;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;

public class Bool {

	private List<Object> must = new ArrayList<Object>();
	private List<Object> should = new ArrayList<Object>();

	@JsonIgnore
	private List<Object> origin;

	public Bool() {
	}

	public Bool mustMatch(Object name, Object value) {
		Object newMatch = new Match(name, value);
		must.add(newMatch);
		this.origin = must;
		return this;
	}

	public Bool shouldMatch(Object name, Object value) {
		Object newMatch = new Match(name, value);
		should.add(newMatch);
		this.origin = should;
		return this;
	}

	public Bool bool() {
		if (this.origin == null)
			throw new RuntimeException("Consequent bool method call not allowed: inconsistent state call");
		
		Query nestedQuery = new Query();
		this.origin.add(nestedQuery);

		return nestedQuery.getBool();
	}

}
