package main.data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import model.car.Car;
import model.car.PublicCar;
import model.card.Card;
import model.card.PublicCard;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class CarData {

    public static List<Car<? extends Card>> readCarData() {
        List<Car<? extends Card>> carList = new ArrayList<>();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder bulder = factory.newDocumentBuilder();
            Document doc = bulder.parse(CarData.class.getClassLoader().getResourceAsStream("main/data/CarData.xml"));
            NodeList carNodes = doc.getDocumentElement().getChildNodes();
            for (int loop = 0; loop < carNodes.getLength(); loop++) {
                Node carNode = carNodes.item(loop);
                NodeList carParam = carNode.getChildNodes();
                if (carNode.getNodeName().equals("PublicCar")) {
                    PublicCard card = new PublicCard(Integer.valueOf(getValueByName(carParam, "CardId")));
                    card.setAccount(Double.valueOf(getValueByName(carParam, "Account")));
                    PublicCar car = new PublicCar(card);
                    car.setEnterTime(parseString(getValueByName(carParam, "EnterTime")));
                    car.setLeaveTime(parseString(getValueByName(carParam, "LeaveTime")));
                    carList.add(car);
                } else if (carNode.getNodeName().equals("StaffCar")) {
                    PublicCard card = new PublicCard(Integer.valueOf(getValueByName(carParam, "CardId")));
                    PublicCar car = new PublicCar(card);
                    car.setEnterTime(parseString(getValueByName(carParam, "EnterTime")));
                    car.setLeaveTime(parseString(getValueByName(carParam, "LeaveTime")));
                    carList.add(car);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return carList;
    }

    private static Date parseString(String string) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.parse(string);
    }

    private static String getValueByName(NodeList nodeList, String nodeName) {
        String value = null;
        for (int loop = 0; loop < nodeList.getLength(); loop++) {
            Node node = nodeList.item(loop);
            if (node.getNodeName().equals(nodeName)) {
                value = node.getNodeValue();
            }
        }
        return value;
    }
}