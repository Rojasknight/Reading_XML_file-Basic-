package lecturaXML;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Lectura {
	
	public static void main(String args[]) {
		
		try {
			
			File archivo = new File("C:\\Users\\danny.rojas\\Capacitacion\\lecturaXML\\example.xml");
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
			Document document = documentBuilder.parse(archivo);
			document.getDocumentElement().normalize();
			System.out.println("Etiqueta principal:" + document.getDocumentElement().getNodeName());
			NodeList listaEmpleados = document.getElementsByTagName("empleado");
			
			for (int temp = 0; temp < listaEmpleados.getLength(); temp++) {
				
				Node nodo = listaEmpleados.item(temp);
				System.out.println("Elemento:" + nodo.getNodeName());
				
				if (nodo.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) nodo;
					System.out.println("id: " + element.getAttribute("id"));
					System.out.println("Nombre: " + element.getElementsByTagName("nombre").item(0).getTextContent());
					System.out.println("username: " + element.getElementsByTagName("username").item(0).getTextContent());
					System.out.println("password: " + element.getElementsByTagName("password").item(0).getTextContent());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
