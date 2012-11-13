package no.difi.vefa.ws;

import static org.junit.Assert.*;

import no.difi.vefa.properties.PropertiesFile;
import org.junit.Before;
import org.junit.Test;

public class ListSchemasTest {

	private ListSchemas listSchemas;
	
	@Before
	public void setUp() throws Exception {
		String path = new java.io.File("src/test/java/no/difi/vefa/ws/validator.properties").getCanonicalPath();
		PropertiesFile propFile = new PropertiesFile();
		propFile.main(path);
		propFile.dataDir = new java.io.File("src/test/java/no/difi/vefa/ws/").getCanonicalPath();
		
		listSchemas = new ListSchemas();
		listSchemas.version = "1.4";
		listSchemas.baseUri = "http://www.test.com/validate-ws/";
		listSchemas.propertiesFile = propFile;		
	}

	@Test
	public void testGetSchemas() throws Exception {
		String result = "<schemas version=\"1.4\" xmlns:xlink=\"http://www.w3.org/1999/xlink\">" +
				"<schema id=\"urn:www.cenbii.eu:profile:bii04:ver1.0#urn:www.cenbii.eu:transaction:biicoretrdm010:ver1.0#urn:www.peppol.eu:bis:peppol4a:ver1.0#urn:www.difi.no:ehf:faktura:ver1\" xlink:href=\"http://www.test.com/validate-ws/urn:www.cenbii.eu:profile:bii04:ver1.0#urn:www.cenbii.eu:transaction:biicoretrdm010:ver1.0#urn:www.peppol.eu:bis:peppol4a:ver1.0#urn:www.difi.no:ehf:faktura:ver1\">" +
				"<name xmlns:xi=\"http://www.w3.org/2001/XInclude\">\n" +
				"\t\t\t<en>EHF invoice in Norway, profile invoice only</en>\n" +
				"\t\t\t<no>EHF faktura i Norge, profil kun faktura</no>\n" +
				"\t\t</name>" +
				"</schema>" +
				"</schemas>";
		
		assertEquals(result, listSchemas.getSchemas());
	}

}