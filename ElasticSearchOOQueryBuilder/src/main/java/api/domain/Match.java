package api.domain;

import java.util.Map;
import java.util.TreeMap;

//Immutable Object, defined @ construction time
public class Match {
	// implemented this way to get the right syntax with Jackson Json generation
	// { "match": { "key": "value" }},
	private Map<Object, Object> match;

	public Match(Object name, Object value) {
		match = new TreeMap<Object, Object>();
		match.put(name, value);
	}

}
