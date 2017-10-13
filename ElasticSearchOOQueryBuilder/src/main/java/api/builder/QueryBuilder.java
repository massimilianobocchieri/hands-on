package api.builder;

import api.domain.Bool;
import api.domain.Query;
import json.JavaToJsonConverter;

public class QueryBuilder {
	private Query query;

	public QueryBuilder() {
		this.query = new Query();
	}

	public Bool bool() {
		return query.getBool();
	}

	// Used to clean The QueryBuilder content
	public void clean() {
		this.query = new Query();
	}

	public String toJSON(JavaToJsonConverter converter) {
		try {
			return converter.toJson(this);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
