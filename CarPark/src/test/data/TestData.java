package test.data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import model.state.PayCashType;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import test.model.TestModel;

public class TestData {

    public static List<TestModel> readCarData() {
        List<TestModel> modelList = new ArrayList<>();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder bulder = factory.newDocumentBuilder();
            Document doc = bulder.parse(TestData.class.getClassLoader().getResourceAsStream("main/data/TestData.xml"));
            NodeList carNodes = doc.getDocumentElement().getChildNodes();
            for (int loop = 0; loop < carNodes.getLength(); loop++) {
                Node carNode = carNodes.item(loop);
                NodeList carParam = carNode.getChildNodes();
                TestModel carModel = new TestModel();
                carModel.setType(getValueByName(carParam, "type"));
                carModel.setAccount(Double.valueOf(getValueByName(carParam, "account")));
                carModel.setEnterTime(parseString(getValueByName(carParam, "enterTime")));
                carModel.setLeaveTime(parseString(getValueByName(carParam, "leaveTime")));
                carModel.setPays(parseCash(getValueByName(carParam, "pay")));
                modelList.add(carModel);
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

    private static List<PayCashType> parseCash(String string) {
        List<PayCashType> payCashs = new ArrayList<>();
        String[] cashs = string.split(",");
        for (String cash : cashs) {
            switch (cash) {
                case "0.5":
                    payCashs.add(PayCashType.FIFTY);
                    break;
                case "1":
                    payCashs.add(PayCashType.ONE);
                    break;
                case "2":
                    payCashs.add(PayCashType.TWO);
                    break;
                default:
                    break;
            }
        }
        return payCashs;
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