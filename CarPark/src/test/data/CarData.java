package test.data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import test.model.TestModel;

public class CarData {

    public static List<TestModel> readCarData() {
        List<TestModel> modelList = new ArrayList<>();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder bulder = factory.newDocumentBuilder();
            Document doc = bulder.parse(CarData.class.getClassLoader().getResourceAsStream("main/data/CarData.xml"));
            NodeList carNodes = doc.getDocumentElement().getChildNodes();
            for (int loop = 0; loop < carNodes.getLength(); loop++) {
                Node carNode = carNodes.item(loop);
                NodeList carParam = carNode.getChildNodes();
                TestModel carModel = new TestModel();
                if (carNode.getNodeName().equals("PublicCar")) {
                    carModel.setType("PublicCar");
                    carModel.setAccount(Double.valueOf(getValueByName(carParam, "Account")));
                    carModel.setEnterTime(parseString(getValueByName(carParam, "EnterTime")));
                    carModel.setLeaveTime(parseString(getValueByName(carParam, "LeaveTime")));
                    modelList.add(carModel);
                } else if (carNode.getNodeName().equals("StaffCar")) {
                    carModel.setType("StaffCar");
                    carModel.setEnterTime(parseString(getValueByName(carParam, "EnterTime")));
                    carModel.setLeaveTime(parseString(getValueByName(carParam, "LeaveTime")));
                    modelList.add(carModel);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return modelList;
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