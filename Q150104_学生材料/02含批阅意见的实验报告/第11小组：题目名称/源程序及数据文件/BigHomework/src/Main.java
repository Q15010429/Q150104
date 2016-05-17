import java.awt.*;
import java.io.*;
import java.util.Vector;
import javax.swing.*;

public class Main{
	public static void main(String[] args) {
		MainFrame f = new MainFrame();
	}
}

class MainFrame extends JFrame {
	Vector buyList=new Vector();
	
	MainFrame(){
		super("���Ϲ������ϵͳ");
		
		this.setTitle("���Ϲ������ϵͳ");
		this.setSize(700,320);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		this.readStuFile();
		this.showBuyPanel();
		this.setVisible(true);

		this.setResizable(false);
		this.setSize(700,320);
		this.setLocationRelativeTo(this.getOwner());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	void readStuFile(){
		try {
			FileInputStream fis;
			fis = new FileInputStream("Buyer.txt");
			InputStreamReader dis=new InputStreamReader(fis);
			BufferedReader reader=new BufferedReader(dis);
			String s;
			while((s=reader.readLine())!=null)
			{
				Buyer buy=new Buyer();
				String[] temp=s.split(" ");
				buy.setBuyerNum(temp[0]);
				buy.setBuyerSex(temp[1]);
				buy.setBuyerAdd(temp[2]);
				buyList.add(buy);
			}
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
	}
	
	void showBuyPanel(){
		BuyPanel buyPanel=new BuyPanel();
		buyPanel.buyList=this.buyList;
		this.add(buyPanel,BorderLayout.CENTER);
		buyPanel.showbuyer(0);
		this.setVisible(true);
	}
}

class BuyPanel extends JPanel {
	private JTextField buyerNum=new JTextField();											//��Ա��
	private JTextField buyerSex=new JTextField();											//�Ա�
	private JTextField buyerAdd=new JTextField();											//��ַ
	Vector buyList=new Vector();
	private String[] btnStr={"��һ��","��һ��","��һ��","���һ��","���","�޸�","ɾ��"};
	private JButton[] btn= new JButton[btnStr.length];
	
	BuyPanel(){
		this.setLayout(null);
		//��ʾ��Ա��
		JLabel lb1=new JLabel("��Ա�ţ�");
		lb1.setBounds(30, 10, 100, 20);
		this.add(lb1);
		buyerNum.setBounds(100,10, 100, 20);
		this.add(buyerNum);
		//��ʾ�Ա�
		JLabel lb2=new JLabel("�Ա�");
		lb2.setBounds(30, 60, 100, 20);
		this.add(lb2);
		buyerSex.setBounds(100,60, 100, 20);
		this.add(buyerSex);
		//��ʾ��ַ
		JLabel lb3=new JLabel("��ַ��");
		lb3.setBounds(30, 110, 100, 20);
		this.add(lb3);
		buyerAdd.setBounds(100,110, 100, 20);
		this.add(buyerAdd);
	
		//��ʾ���ư�ť
		for(int i=0;i<btn.length;i++){
			btn[i]=new JButton(btnStr[i]);
			btn[i].setBounds(30+i*90, 210, 90, 30);
			this.add(btn[i]);
		}
	}
	
	void showbuyer(int offset){
		Buyer buy=(Buyer) buyList.get(offset);
		this.buyerNum.setText(buy.getBuyerNum());
		this.buyerSex.setText(buy.getBuyerSex());
		this.buyerAdd.setText(buy.getBuyerAdd());
	}
}

class Buyer {
	private String buyerNum;											//��Ա��
	private String buyerSex;											//�Ա�
	private String buyerAdd;											//��ַ
	public String getBuyerNum() {
		return buyerNum;
	}
	public void setBuyerNum(String buyerNum) {
		this.buyerNum = buyerNum;
	}
	public String getBuyerSex() {
		return buyerSex;
	}
	public void setBuyerSex(String buyerSex) {
		this.buyerSex = buyerSex;
	}
	public String getBuyerAdd() {
		return buyerAdd;
	}
	public void setBuyerAdd(String buyerAdd) {
		this.buyerAdd = buyerAdd;
	}
}

	
