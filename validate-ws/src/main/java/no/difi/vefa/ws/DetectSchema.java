package no.difi.vefa.ws;

import java.util.ArrayList;
import java.util.List;
import no.difi.vefa.message.Message;
import no.difi.vefa.message.MessageType;
import no.difi.vefa.message.ValidationType;
import no.difi.vefa.validation.WellFormed;
import no.difi.vefa.xml.Utils;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

/**
 * This class is used to auto detect schema identifier.
 */
public class DetectSchema {
	/**
	 * Schema to validate XML against.
	 */	
	public String schema;

	/**
	 * Collection of messages generated by the validation.
	 */
	public List<Message> messages = new ArrayList<Message>();
	
	/**
	 * Tries to detect schema identifier from XML. This consists of ProfileID and CustomizationID.
	 * 
	 * @param xml XML as String
	 * @param version Version as String
	 * @return Schema identifier as String
	 * @throws Exception
	 */		
	public void setSchemaIdentifier(String xml, String version) throws Exception {
		// Setup
		Utils utils = new Utils();
		String profileId = "";
		String customizationId = "";
				
		// Check if XML string is well formed
		WellFormed wellFormed = new WellFormed();
		if (wellFormed.main(xml, this.messages) == false) {
			return;
		}		
		
		// Load xml to DOM
		Document document = utils.stringToXMLDOM(xml);

		// Get ProfileID and CustomizationID from xml
		Node pId = utils.xmlDOMXPathQuery(document, "*/ProfileID").item(0);
		Node cId = utils.xmlDOMXPathQuery(document, "*/CustomizationID").item(0);
				
		if (pId == null) {
			Message message = new Message();
			message.validationType = ValidationType.XMLWellFormed;
			message.messageType = MessageType.Fatal;
			message.title = "ProfileID is missing from XML document. Unable to choose validation profile.";
			message.description = "";			
			this.messages.add(message);			
		} else {
			profileId = pId.getTextContent();
		}
		
		if (cId == null) {
			Message message = new Message();
			message.validationType = ValidationType.XMLWellFormed;
			message.messageType = MessageType.Fatal;
			message.title = "CustomizationID is missing from XML document. Unable to choose validation profile.";
			message.description = "";			
			this.messages.add(message);						
		} else {
			customizationId = cId.getTextContent();
		}
		
		// Build schema id				
		this.schema = profileId + "#" + customizationId;
	}
}