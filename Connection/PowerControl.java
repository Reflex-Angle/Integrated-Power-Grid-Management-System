package application;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.collections.ObservableList;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.ImageView;
import javafx.collections.FXCollections;
import java.util.Arrays;
import java.util.Optional;
import javafx.scene.control.TextField;

import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import java.time.LocalDate;
import java.util.*;
public class PowerControl {
	int dailyPercen = 80;
	int[] outarr = {20,30,40};
	int outarrlen = 3;
	boolean mode = false;
	boolean login = false;
	boolean paymentportal=false;
	
	@FXML
    private ComboBox<String> box;
	@FXML
	private Label subtitle,basiclab1,basiclab2,basiclab3,basiclab4,basiclab5,
	        basicval1,basicval2,basicval3,basicval4,basicval5,dailyp,outgoingp,
	        outval1,outval2,outval3,outlab1,outlab2,outlab3,
	        ubasiclab1,ubasiclab2,ubasiclab3,
	        ubasiclab4,ubasiclab5,ubasicval1,ubasicval2,ubasicval3,ubasicval4,ubasicval5,
	        umcmonth1,umcmonth2,umcmonth3,umcmonth4,umcval1,umcval2,umcval3,umcval4,upblab1,
	        umeterlab,ubilllab,upbval,umeterval,ubillval;
	@FXML
	private Button incbutton,decbutton,stop,start,upbut1,
			upbut2,upbut3,downbut1,downbut2,downbut3,
			switchbut,exitlogin,enterlogin,ticketsubmit,paybill;
	@FXML
	private TextArea grievancebox;
	@FXML
	private Label[] outvalarr;
	@FXML
	private Button[] upbutarr;
	@FXML
	private Button[] downbutarr;
	@FXML
	private ProgressIndicator progc;
	@FXML
	private StackPane userpanel, main;
	@FXML
	private Pane loginback;
	@FXML
	private ImageView loginicon;
	@FXML
	private TextField username,userid;
	
	Map<String, List<String>> map = new HashMap<String, List<String>>() {{
		put("PPName1", Arrays.asList("33", "PPName1", "9876543210", "Erode", "44", "87", "20", "20", "20"));
		put("PPName2", Arrays.asList("34", "PPName2", "9898989898", "Alwarpet", "44", "80", "30", "10", "10"));
		put("ABCPPName3", Arrays.asList("45", "ABCPPName3", "9988776655", "Mylapore", "44", "75", "15", "5", "10"));
		put("PPName4", Arrays.asList("46", "PPName4", "9123456789", "Chennai", "50", "90", "20", "5", "10"));
		put("PPName5", Arrays.asList("47", "PPName5", "9234567890", "Coimbatore", "30", "60", "10", "20", "10"));
		put("PPName6", Arrays.asList("48", "PPName6", "9345678901", "Madurai", "60", "85", "15", "10", "10"));
		put("PPName7", Arrays.asList("49", "PPName7", "9456789012", "Salem", "70", "95", "25", "5", "5"));
		put("PPName8", Arrays.asList("50", "PPName8", "9567890123", "Tiruppur", "40", "55", "10", "25", "20"));
		put("PPName9", Arrays.asList("51", "PPName9", "9678901234", "Trichy", "55", "80", "15", "5", "10"));
		put("PPName10", Arrays.asList("52", "PPName10", "9789012345", "Kanchipuram", "80", "90", "30", "10", "10"));
    }};
    Map<String, List<String>> user = new HashMap<String, List<String>>() {{
    	put("Alice Green", Arrays.asList("U601", "Alice Green", "9876543210", "Chennai", "150", "200", "100", "90", "70", "1000", "M701", "U101"));
    	put("Bob Miller", Arrays.asList("U602", "Bob Miller", "8765432109", "Chennai", "250", "400", "300", "550", "620", "3500", "M702", "B502"));
    	put("Charlie Davis", Arrays.asList("U603", "Charlie Davis", "7654321098", "Chennai", "450", "330", "600", "490", "540", "2000", "M703", "B503"));
    	put("Diana Clark", Arrays.asList("U604", "Diana Clark", "6543210987", "Chennai", "300", "150", "480", "700", "180", "4200", "M704", "B504"));
    	put("Ethan Lewis", Arrays.asList("U605", "Ethan Lewis", "5432109876", "Chennai", "370", "550", "610", "200", "430", "1800", "M705", "B505"));
    	put("Fiona Adams", Arrays.asList("U606", "Fiona Adams", "4321098765", "Chennai", "520", "310", "450", "630", "290", "1600", "M706", "B506"));
    	put("George King", Arrays.asList("U607", "George King", "3210987654", "Chennai", "180", "600", "330", "420", "640", "2200", "M707", "B507"));
    	put("Hannah Young", Arrays.asList("U608", "Hannah Young", "2109876543", "Chennai", "600", "410", "290", "500", "310", "2500", "M708", "B508"));
    	put("Ivy Scott", Arrays.asList("U609", "Ivy Scott", "1098765432", "Chennai", "230", "280", "540", "460", "710", "4500", "M709", "B509"));
    	put("Jack Taylor", Arrays.asList("U610", "Jack Taylor", "0987654321", "Chennai", "670", "480", "200", "330", "390", "3600", "M710", "B510"));
    }};
	@FXML
	void setBasicLabel(String[] arr) {
		basiclab1.setText(arr[0]);
		basiclab2.setText(arr[1]);
		basiclab3.setText(arr[2]);
		basiclab4.setText(arr[3]);
		basiclab5.setText(arr[4]);
	}
	
	@FXML
	void setBasicValue(String[] arr) {
		basicval1.setText(arr[0]);
		basicval2.setText(arr[1]);
		basicval3.setText(arr[2]);
		basicval4.setText(arr[3]);
		basicval5.setText(arr[4]);
	}
	@FXML
	void setUserLabel(String[] arr) {
		ubasiclab1.setText(arr[0]);
		ubasiclab2.setText(arr[1]);
		ubasiclab3.setText(arr[2]);
		ubasiclab4.setText(arr[3]);
		ubasiclab5.setText(arr[4]);
	}
	
	@FXML
	void setUserValue(String[] arr) {
		ubasicval1.setText(arr[0]);
		ubasicval2.setText(arr[1]);
		ubasicval3.setText(arr[2]);
		ubasicval4.setText(arr[3]);
		ubasicval5.setText(arr[4]);
	}
	@FXML
	void displaymeterlabels(String[] arr) {
		LocalDate currentDate = LocalDate.now();
        int monthValue = currentDate.getMonthValue();
        int currentYear = currentDate.getYear();
        umcmonth1.setText(arr[monthValue]+","+currentYear);
        umcmonth2.setText(arr[monthValue-1]+","+currentYear);
        umcmonth3.setText(arr[monthValue-2]+","+currentYear);
        umcmonth4.setText(arr[monthValue-3]+","+currentYear);
        
	}
	@FXML
	void displaymetervalues(String[] arr) {
		umcval1.setText(arr[0]+" Units");
		umcval2.setText(arr[1]+" Units");
		umcval3.setText(arr[2]+" Units");
		umcval4.setText(arr[3]+" Units");
        
	}
	void billlabels() {
		upblab1.setText("Amount:");
		umeterlab.setText("Meter ID:");
		ubilllab.setText("Bill ID:");
        
	}
	void displaybillvalues(String[] arr) {
		upbval.setText(arr[0]);
		umeterval.setText(arr[1]);
		ubillval.setText(arr[2]);
        
	}
	@FXML 
	void setSubTitle(String name) {
		subtitle.setText(name);
	}
	
	@FXML
	void setDailyP(){
		String tmp = String.valueOf(dailyPercen) + "%";
		if(tmp.length() == 2) {
			tmp = "0" + tmp;
		}
		dailyp.setText(tmp);
		progc.setProgress((double)dailyPercen/100);
	}
	
	void setOutgoingP(boolean jk){
		int sum = Arrays.stream(outarr).sum();
		String tmp;
		if(jk) {
			tmp = String.valueOf(sum) + "%";
			if(tmp.length() == 2) {
				tmp = "0" + tmp;
			}
		}
		else {
			tmp = "00%";
		}
		outgoingp.setText(tmp);
	}
	
	void updateOutValArr(int a,boolean jk) {
		for(int i = 0; i < a; i++) {
			String str;
			if(jk) {
				str = String.valueOf(outarr[i]) + "%";
				if(str.length() == 2) {
					str = "0" + str;
				}
			}
			else {
				str = "00%";
			}
			
			outvalarr[i].setText(str);
		}
	}
	
	void changePlant(String name) {
		System.out.println(name);
		System.out.println(map.get(name));
		String[] inp = new String[5];
		
		for(int i = 0; i < 5; i++){
			inp[i] = ": " + map.get(name).get(i);
		}
		setBasicValue(inp); 
		dailyPercen =Integer.valueOf(map.get(name).get(5));
		setDailyP();
		for(int i = 0; i < outarrlen; i++) {
			outarr[i] = Integer.valueOf(map.get(name).get(6+i));
		}
		updateOutValArr(outarrlen,true);
		setOutgoingP(true);
	}
	
	@FXML
    public void initialize() {
		outvalarr = new Label[]{outval1,outval2,outval3};
		downbutarr = new Button[]{upbut1,upbut2,upbut3};
		upbutarr = new Button[]{downbut1,downbut2,downbut3};
		String months[]= {"","January","February","March","April","May","June","July","August",
				"September","October","November","December"};
		displaymeterlabels(months);
		String[] array = {"PPName1", "PPName2", "ABCPPName3", "PPName4", "PPName5", "PPName6", "PPName7", "PPName8", "PPName9", "PPName10"};
        ObservableList<String> PowerOption = FXCollections.observableArrayList(array);
        box.setItems(PowerOption);
        
         
        setSubTitle("Manage Powerplant");
        String inp0[] = {"Plant Id","Plant Name","Contact Info","Plant Location","Max Capacity (MW)"};
        setBasicLabel(inp0);
        String inp1[] = {": 33", ": PPName1", ": 9876543210", ": Erode", ": 44"};
        setBasicValue(inp1); 
        setDailyP();
        setOutgoingP(true);
        updateOutValArr(outarrlen,true); // add the arr.length;
        
        
        String inp2[] = {"UserId","Name","Contact Info","Permanent Location","Average Usage"};
        setUserLabel(inp2);
        String inp3[] = {": U601",": Alice Green",": 9876543210",": Chennai",": 150 Units"};
        setUserValue(inp3);
        String inp4[] = {"200","100","90","70"};
        displaymetervalues(inp4);
        billlabels();
        String inp5[] = {"1000","M701","B501"};
        displaybillvalues(inp5);
        // user panel
        userpanel.setVisible(mode);
        //login panel
        loginback.setVisible(login);
        
        // event handler
        incbutton.setOnAction(event -> {
        	if(dailyPercen < 99){
        		dailyPercen++;
        	}
            setDailyP();
            progc.setProgress((double)dailyPercen/100);
        });
        decbutton.setOnAction(event -> {
        	if(dailyPercen > 0){
        		dailyPercen--;
        	}
            setDailyP();
            progc.setProgress((double)dailyPercen/100);
        });
        ticketsubmit.setOnAction(event->{
        	String s=grievancebox.getText();
        	System.out.println(s);
        	//grievancebox.clear();
        	Alert alert = new Alert(AlertType.CONFIRMATION); // You can change AlertType
            alert.setTitle("Grievance Query");
            alert.setHeaderText(null);
            alert.setContentText("Grievance Submitted \n Ticket raised (ID: 801)");
            alert.getDialogPane().getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            alert.getDialogPane().lookup(".content").setStyle("-fx-font-size: 14px; -fx-text-fill: #555555;");

            alert.showAndWait(); // Display the alert and wait until it's closed
        });
        
        box.setOnAction(event -> {
            String selectedItem = box.getSelectionModel().getSelectedItem();
            changePlant(selectedItem);
        });
        start.setOnAction(event -> {
        	setOutgoingP(true);
        	updateOutValArr(outarrlen,true);
        	for(int i = 0; i < outarrlen; i++){
        		upbutarr[i].setDisable(false);
        		downbutarr[i].setDisable(false);
        	}
        });
        stop.setOnAction(event -> {
        	setOutgoingP(false);
        	updateOutValArr(outarrlen,false);
        	for(int i = 0; i < outarrlen; i++){
        		upbutarr[i].setDisable(true);
        		downbutarr[i].setDisable(true);
        	}
        });
        
        switchbut.setOnAction(event -> {
        	userpanel.setVisible(!mode);
        	mode = !mode;
        });
        
        exitlogin.setOnAction(event -> {
        	loginback.setVisible(!login);
        	login = !login;
        });
        enterlogin.setOnAction(event -> {
        	loginback.setVisible(!login);
        	login = !login;
        	System.out.println(username.getText());
        	System.out.println(userid.getText());
        	String jk = username.getText();
        	String[] in = new String[5];
    		
    		for(int i = 0; i < 5; i++){
    			in[i] = ": " + user.get(jk).get(i);
    		}
    		setUserValue(in);
    		
    		String[] in1 = new String[4];
    		for(int i = 0; i < 4; i++){
    			in1[i] = ": " + user.get(jk).get(5+i);
    		}
            displaymetervalues(in1);
            
            String[] in2 = new String[3];
    		for(int i = 0; i < 3; i++){
    			in2[i] = ": " + user.get(jk).get(9+i);
    		}
    		displaybillvalues(in2);
        	
        });
        loginicon.setOnMousePressed(event ->{
        	loginback.setVisible(!login);
        	login = !login;
        });
        for(int i = 0; i < outarrlen; i++) {
        	final int butt = i;
        	upbutarr[i].setOnAction(event -> {
        		if(outarr[butt] < 99 && Arrays.stream(outarr).sum() < 99){
            		outarr[butt]++;
            	}
        		updateOutValArr(outarrlen,true);
        		setOutgoingP(true);
            });
        	
        	downbutarr[i].setOnAction(event -> {
        		if(outarr[butt] > 0 && Arrays.stream(outarr).sum() > 0){
            		outarr[butt]--;
            	}
        		updateOutValArr(outarrlen,true);
        		setOutgoingP(true);
            });
        	
        }
    }
}
