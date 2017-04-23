package by.epamlab;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public final class RunnerClientREST {
	private static final String APPLICATION_JSON = "application/json";
	private static final String METHOD_DELETE = "DELETE";
	private static final String METHOD_PUT = "PUT";
	private static final String METHOD_POST = "POST";
	private static final String METHOD_GET = "GET";
	private static final Logger LOG = Logger.getLogger(RunnerClientREST.class);
	private static final String SERVICE_URL = "http://localhost:8080/service-implementation-module/ServiceREST";

	private RunnerClientREST() {
		super();
	}

	public static void main(final String[] args) {
		String data = null;

		printResult(SERVICE_URL + "/documents", null, METHOD_GET);

		printResult(SERVICE_URL + "/documents/5", null, METHOD_GET);

		printResult(SERVICE_URL + "/documents/111111111", null, METHOD_GET);

		printResult(SERVICE_URL + "/documents/chapters/shortest", "application/xml", METHOD_GET);

		data = "{\"id\":1000,\"name\":\"XXX\",\"chapters\":{\"chapters\":["
				+ "{\"id\":1,\"chapterNumber\":111,\"numberOfPage\":21},"
				+ "{\"id\":2,\"chapterNumber\":12,\"numberOfPage\":12},"
				+ "{\"id\":3,\"chapterNumber\":1,\"numberOfPage\":12},"
				+ "{\"id\":4,\"chapterNumber\":34,\"numberOfPage\":12},"
				+ "{\"id\":5,\"chapterNumber\":54,\"numberOfPage\":322},"
				+ "{\"id\":6,\"chapterNumber\":45,\"numberOfPage\":122}]}}";
		printResultQQQ(SERVICE_URL + "/documents", APPLICATION_JSON, METHOD_POST, data);

		data = "incorrect data";
		printResultQQQ(SERVICE_URL + "/documents", APPLICATION_JSON, METHOD_POST, data);

		data = "{\"id\":1000,\"name\":\"XXX\",\"chapters\":"
				+ "{\"chapters\":[{\"id\":1,\"chapterNumber\":111,\"numberOfPage\":21},"
				+ "{\"id\":2,\"chapterNumber\":12,\"numberOfPage\":12},"
				+ "{\"id\":3,\"chapterNumber\":1,\"numberOfPage\":12},"
				+ "{\"id\":4,\"chapterNumber\":34,\"numberOfPage\":12},"
				+ "{\"id\":5,\"chapterNumber\":54,\"numberOfPage\":322},"
				+ "{\"id\":6,\"chapterNumber\":45,\"numberOfPage\":122}]}}";
		printResultQQQ(SERVICE_URL + "/documents", APPLICATION_JSON, METHOD_PUT, data);

		data = "{\"id\":5555,\"name\":\"XXX\",\"chapters\":{\"chapters\":["
				+ "{\"id\":1,\"chapterNumber\":111,\"numberOfPage\":21},"
				+ "{\"id\":2,\"chapterNumber\":12,\"numberOfPage\":12},"
				+ "{\"id\":3,\"chapterNumber\":1,\"numberOfPage\":12},"
				+ "{\"id\":4,\"chapterNumber\":34,\"numberOfPage\":12},"
				+ "{\"id\":5,\"chapterNumber\":54,\"numberOfPage\":322},"
				+ "{\"id\":6,\"chapterNumber\":45,\"numberOfPage\":122}]}}";
		printResultQQQ(SERVICE_URL + "/documents", APPLICATION_JSON, METHOD_PUT, data);

		printResult(SERVICE_URL + "/documents/1000", APPLICATION_JSON, METHOD_DELETE);

	}

	static String readFile(final String path, final Charset encoding) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, encoding);
	}

	private static void printResult(final String resourceAddress, final String acceptDataType, final String method) {
		try {
			Client client = Client.create();
			WebResource webResource = client.resource(resourceAddress);
			ClientResponse response = webResource.accept(acceptDataType).method(method, ClientResponse.class);
			String output = response.getEntity(String.class);
			LOG.info("REQUEST : " + method);
			LOG.info("REQUEST: " + resourceAddress);
			LOG.info("RESPONSE STATUS: " + response.getStatus());
			LOG.info("RESPONSE DATA: " + output + "\n");
		} catch (Exception e) {
			LOG.error("---" + e);
		}
	}

	private static void printResultQQQ(final String resourceAddress, final String acceptDataType, final String method,
			final String data) {
		try {
			Client client = Client.create();
			WebResource webResource = client.resource(resourceAddress);
			ClientResponse response = webResource.accept(acceptDataType).entity(data, MediaType.APPLICATION_JSON)
					.method(method, ClientResponse.class);
			String output = response.getEntity(String.class);
			LOG.info("REQUEST : " + method);
			LOG.info("REQUEST: " + resourceAddress);
			LOG.info("REQUEST: " + data);
			LOG.info("RESPONSE STATUS: " + response.getStatus());
			LOG.info("RESPONSE DATA: " + output + "\n");
		} catch (Exception e) {
			LOG.error(e);
		}
	}
}
