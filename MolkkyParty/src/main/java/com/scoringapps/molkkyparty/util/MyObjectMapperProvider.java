package com.scoringapps.molkkyparty.util;

import java.util.List;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.AnnotationIntrospector.Pair;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig.Feature;
import org.codehaus.jackson.map.introspect.JacksonAnnotationIntrospector;
import org.codehaus.jackson.xc.JaxbAnnotationIntrospector;

/**
 * 
 * @author japod
 */
@Provider
public class MyObjectMapperProvider implements ContextResolver<ObjectMapper> {

	final ObjectMapper defaultObjectMapper;
	final ObjectMapper combinedObjectMapper;

	public MyObjectMapperProvider() {
		defaultObjectMapper = createDefaultMapper();
		combinedObjectMapper = createCombinedObjectMapper();
	}

	@Override
	public ObjectMapper getContext(Class<?> type) {

		if (type == ListItemsWrapper.class || type == List.class) {
			return combinedObjectMapper;
		} else {
			return defaultObjectMapper;
		}
	}

	private static ObjectMapper createCombinedObjectMapper() {

		Pair combinedIntrospector = createJaxbJacksonAnnotationIntrospector();
		ObjectMapper result = new ObjectMapper();
		result.configure(Feature.WRAP_ROOT_VALUE, false);
		result.configure(Feature.INDENT_OUTPUT, true);
		result.setDeserializationConfig(result.getDeserializationConfig().withAnnotationIntrospector(combinedIntrospector));
		result.setSerializationConfig(result.getSerializationConfig().withAnnotationIntrospector(combinedIntrospector));

		return result;
	}

	private static ObjectMapper createDefaultMapper() {

		ObjectMapper result = new ObjectMapper();
		result.configure(Feature.INDENT_OUTPUT, true);

		return result;
	}

	private static Pair createJaxbJacksonAnnotationIntrospector() {

		AnnotationIntrospector jaxbIntrospector = new JaxbAnnotationIntrospector();
		AnnotationIntrospector jacksonIntrospector = new JacksonAnnotationIntrospector();

		return new AnnotationIntrospector.Pair(jaxbIntrospector, jacksonIntrospector);
	}
}
