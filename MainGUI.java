import java.awt.Color;
import java.awt.Font;
import java.util.Arrays;

import javax.swing.*;
@SuppressWarnings("unchecked")
public class MainGUI {
 
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
    System.out.println("Welcome to Friendship_MCL");
    System.out.println("System is now loading, please wait");
    //item define
    Font normalbig = new Font("΢���ź�",Font.BOLD,18);
    Font normaloutput = new Font("����",Font.PLAIN,10);
    Color success = new Color(30,30,30);
    Color error = new Color(255,0,0);
    //define over
    //versions find
    VersionFinder vfind = new VersionFinder();
    //vfind.find();
    int lines = vfind.br();
    String[] versions = vfind.list(lines,1);
    String[] vertype = vfind.list(lines,2);
    String[] verurl = vfind.list(lines,3);
    String[] vertime = vfind.list(lines,4);
    JFrame f = new JFrame("FMCL pre-release 0.1");//��������
    f.setSize(100, 100);//Ĭ�ϵĴ��ڴ�С
    f.setLocation(0, 0);//�߿�
    f.setLayout(null);//��ͻ����ʾ
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���ùر��¼�
	f.setResizable(false);//��С���ɱ�
    f.setVisible(true);//���ô��ڿɼ�
    System.out.println("Version list:"+Arrays.toString(versions));
    JComboBox vlist = new JComboBox(versions);
    vlist.setBounds(300, 50, 500, 50);
    f.add(vlist);
    JLabel vtip = new JLabel("ѡ����Ϸ�汾");//��ʾ
    vtip.setBounds(300, 0, 200, 50);
	f.add(vtip);
	vtip.setFont(normalbig);
	JLabel vinfo = new JLabel("wait a moment");
    vinfo.setBounds(300, 120, 500, 50);
	f.add(vinfo);
    //versions over
    f.setSize(1440, 960);
    //always load
    String[] selected = new String[3];
    while(true) {
    	try {
    	selected = vfind.getinfo(vlist.getSelectedItem().toString(),versions,vertype,verurl,vertime);
    	vinfo.setText("ѡ�а汾��"+vlist.getSelectedItem().toString()+"���汾���ͣ�"+selected[0]);
		vinfo.setForeground(success);
    	}catch(NullPointerException npe) {
    		vinfo.setText("ѡ�е�����Ϊ��");
    		vinfo.setForeground(error);
    	}
    }
    //always over
	}

}
