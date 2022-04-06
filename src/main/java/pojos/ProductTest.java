package pojos;

import org.apache.juneau.html.HtmlParser;
import org.apache.juneau.html.HtmlSerializer;
import org.apache.juneau.json.JsonParser;
import org.apache.juneau.json.JsonSerializer;
import org.apache.juneau.parser.ParseException;
import org.apache.juneau.serializer.SerializeException;
import org.apache.juneau.xml.XmlParser;
import org.apache.juneau.xml.XmlSerializer;

public class ProductTest {

	public static void main(String[] args) throws SerializeException, ParseException {
		
		//Serialization
		// pojo to json:
		JsonSerializer jsonSerializer = JsonSerializer.DEFAULT_READABLE;
		String sellerName[] = {"Neon Enterprise", "ABC Software", "XYZ IT Solution"};
		Products product = new Products("Macbook Pro", 1000, "Black", sellerName);
		String json = jsonSerializer.serialize(product);
		System.out.println(json);
		
		
		//pojo to xml
		
		XmlSerializer xmlSerializer = XmlSerializer.DEFAULT_NS_SQ_READABLE;
		String xml = xmlSerializer.serialize(product);
        System.out.println(xml);
		
        // pojo to html
        HtmlSerializer htmlSerializer = HtmlSerializer.DEFAULT_SQ_READABLE;
        String html = htmlSerializer.serialize(product);
        System.out.println(html);
	
	
	   // Deserialization
        // Json to POJO
        JsonParser jsonParser = JsonParser.DEFAULT;
        String jsonValue = "{\r\n" + 
        		"	\"color\": \"Black\",\r\n" + 
        		"	\"name\": \"Macbook Pro\",\r\n" + 
        		"	\"price\": 1000,\r\n" + 
        		"	\"sellerNames\": [\r\n" + 
        		"		\"Neon Enterprise\",\r\n" + 
        		"		\"ABC Software\",\r\n" + 
        		"		\"XYZ IT Solution\"\r\n" + 
        		"	]\r\n" + 
        		"}";
        Products p1 = jsonParser.parse(jsonValue, Products.class);
        System.out.println(p1);
        
        // xml to POJO
        XmlParser xmlParser = XmlParser.DEFAULT;
        String xmlValue = "<object>\r\n" + 
        		"	<color>Black</color>\r\n" + 
        		"	<name>Macbook Pro</name>\r\n" + 
        		"	<price>1000</price>\r\n" + 
        		"	<sellerNames>\r\n" + 
        		"		<string>Neon Enterprise</string>\r\n" + 
        		"		<string>ABC Software</string>\r\n" + 
        		"		<string>XYZ IT Solution</string>\r\n" + 
        		"	</sellerNames>\r\n" + 
        		"</object>";
        
       Products p2 =  xmlParser.parse(xmlValue, Products.class);
       System.out.println("P2 is " + p2);
       
       // html to POJO
       HtmlParser htmlParser = HtmlParser.DEFAULT;
       String htmlValue = "<table>\r\n" + 
       		"	<tr>\r\n" + 
       		"		<td>color</td>\r\n" + 
       		"		<td>Black</td>\r\n" + 
       		"	</tr>\r\n" + 
       		"	<tr>\r\n" + 
       		"		<td>name</td>\r\n" + 
       		"		<td>Macbook Pro</td>\r\n" + 
       		"	</tr>\r\n" + 
       		"	<tr>\r\n" + 
       		"		<td>price</td>\r\n" + 
       		"		<td>1000</td>\r\n" + 
       		"	</tr>\r\n" + 
       		"	<tr>\r\n" + 
       		"		<td>sellerNames</td>\r\n" + 
       		"		<td>\r\n" + 
       		"			<ul>\r\n" + 
       		"				<li>Neon Enterprise</li>\r\n" + 
       		"				<li>ABC Software</li>\r\n" + 
       		"				<li>XYZ IT Solution</li>\r\n" + 
       		"			</ul>\r\n" + 
       		"		</td>\r\n" + 
       		"	</tr>\r\n" + 
       		"</table>";
       
       Products p3 = htmlParser.parse(htmlValue, Products.class);
       System.out.println("P3 is " + p3);
       System.out.println("P3 color " + p3.getColor());
       
	
	}

}
