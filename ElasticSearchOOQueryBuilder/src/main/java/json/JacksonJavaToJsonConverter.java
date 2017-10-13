package json;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

public class JacksonJavaToJsonConverter implements JavaToJsonConverter {

	ObjectMapper mapper;

	public JacksonJavaToJsonConverter() {
		initMapper();
		configMapper();
	}

	public String toJson(Object javaObject) throws JsonGenerationException, JsonMappingException, IOException {
		return mapper.writeValueAsString(javaObject);
	}

	private void initMapper() {
		mapper = new ObjectMapper();
	}

	private void configMapper() {
		// used not to print objects,maps,arrays,etc.. when null
		// (i.e:should,must)
		mapper.setSerializationInclusion(Inclusion.NON_NULL);
		mapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);
		mapper.configure(SerializationConfig.Feature.WRITE_EMPTY_JSON_ARRAYS, false);
		mapper.configure(SerializationConfig.Feature.WRITE_NULL_MAP_VALUES, false);

		// Used to show all fields, even private, and avoid information hiding
		// violation with getters
		mapper.setVisibility(JsonMethod.FIELD, Visibility.ANY);

		// Decided to indent output, this method could be proxied and put as
		// optional
		mapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, true);
	}

}
