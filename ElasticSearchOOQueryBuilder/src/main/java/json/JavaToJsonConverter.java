package json;

public interface JavaToJsonConverter {

	// Strategy Pattern
	String toJson(Object javaObject) throws Exception;

}