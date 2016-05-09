import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Component;
import javax.swing.Box;

public class Tester extends JFrame {
	public String Name="";
	public String ID="";
	public double negNumber;
	public double posNumber;
	
	
	private JPanel mainContentPanel;
	private JTextField txtTitle;
	private JTextField txtPleaseMakeAn;
	private JTextField textFieldEnterName;
	private JTextField txtName;
	private JButton btnSetName;
	private JTextField txtDisplayName;
	private JTextField txtDisplayID;
	CheckingAccount account1 = new CheckingAccount("","");
	private JTextField txtWithdraw;
	private JTextField txtDeposit;
	private JTextField txtUsersWithdrawBox;
	private JTextField txtUserDepositBox;
	private JButton btnEnterWithdraw;
	private JButton btnEnterDeposit;
	private JTextField txtDisplayTotal;
	private JTextField txtCantWithdraw;
	private JTextField txtCEO;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tester frame = new Tester();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tester() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1028, 650);
/***********************top menu bar***********************/
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmQuit = new JMenuItem("Quit");
		mntmQuit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				System.exit(0);
			}
		});
		
/***********************top menu bar End***********************/
		mainContentPanel = new JPanel();
		mainContentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainContentPanel);
		mainContentPanel.setLayout(null);
		
		txtTitle = new JTextField();
		txtTitle.setBorder(null);
		txtTitle.setEditable(false);
		txtTitle.setBackground(SystemColor.menu);
		txtTitle.setFont(new Font("Times New Roman", Font.BOLD, 41));
		txtTitle.setHorizontalAlignment(SwingConstants.CENTER);
		txtTitle.setText("Python Bank");
		txtTitle.setBounds(10, 11, 992, 69);
		mainContentPanel.add(txtTitle);
		txtTitle.setColumns(10);
		JButton btnCreateAccount = new JButton("Make a Bank Account");
		btnCreateAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				makeAccount();
				btnCreateAccount.setVisible(false);
				btnCreateAccount.setEnabled(false);
			}
		});
		btnCreateAccount.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnCreateAccount.setBounds(227, 279, 558, 88);
		
		JMenuItem mntmNew = new JMenuItem("New");
		mntmNew.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				ResetGame();
				btnCreateAccount.setVisible(true);
				btnCreateAccount.setEnabled(true);
			}
		});
		mnFile.add(mntmNew);
		mnFile.add(mntmQuit);
		
		
		mainContentPanel.add(btnCreateAccount);
		
		txtPleaseMakeAn = new JTextField();
		txtPleaseMakeAn.setEditable(false);
		txtPleaseMakeAn.setBorder(null);
		txtPleaseMakeAn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtPleaseMakeAn.setBackground(SystemColor.menu);
		txtPleaseMakeAn.setHorizontalAlignment(SwingConstants.CENTER);
		txtPleaseMakeAn.setText("Please make an account");
		txtPleaseMakeAn.setBounds(360, 196, 291, 31);
		mainContentPanel.add(txtPleaseMakeAn);
		txtPleaseMakeAn.setColumns(10);
		
		textFieldEnterName = new JTextField();
		textFieldEnterName.setFont(new Font("Times New Roman", Font.BOLD, 18));
		textFieldEnterName.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldEnterName.setBounds(360, 212, 291, 56);
		textFieldEnterName.setVisible(false);
		mainContentPanel.add(textFieldEnterName);
		textFieldEnterName.setColumns(10);
		
		txtName = new JTextField();
		txtName.setBorder(null);
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtName.setEditable(false);
		txtName.setVisible(false);
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		txtName.setText("Please Enter your name");
		txtName.setBounds(141, 212, 209, 56);
		mainContentPanel.add(txtName);
		txtName.setColumns(10);
		
		btnSetName = new JButton("Set Name");
		btnSetName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				setName();
			}
		});
		btnSetName.setVisible(false);
		btnSetName.setBounds(678, 231, 89, 23);
		mainContentPanel.add(btnSetName);
		
		txtDisplayName = new JTextField();
		txtDisplayName.setEditable(false);
		txtDisplayName.setHorizontalAlignment(SwingConstants.CENTER);
		txtDisplayName.setBorder(null);
		txtDisplayName.setBackground(SystemColor.menu);
		txtDisplayName.setFont(new Font("Times New Roman", Font.BOLD, 32));
		txtDisplayName.setBounds(20, 91, 355, 88);
		mainContentPanel.add(txtDisplayName);
		txtDisplayName.setColumns(10);
		
		txtDisplayID = new JTextField();
		txtDisplayID.setEditable(false);
		txtDisplayID.setHorizontalAlignment(SwingConstants.CENTER);
		txtDisplayID.setBackground(SystemColor.menu);
		txtDisplayID.setBorder(null);
		txtDisplayID.setFont(new Font("Times New Roman", Font.BOLD, 32));
		txtDisplayID.setColumns(10);
		txtDisplayID.setBounds(634, 91, 355, 88);
		mainContentPanel.add(txtDisplayID);
		
		txtWithdraw = new JTextField();
		txtWithdraw.setBackground(SystemColor.menu);
		txtWithdraw.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtWithdraw.setEditable(false);
		txtWithdraw.setText("Withdraw: Enter amount below");
		txtWithdraw.setHorizontalAlignment(SwingConstants.CENTER);
		txtWithdraw.setBounds(65, 205, 285, 49);
		mainContentPanel.add(txtWithdraw);
		txtWithdraw.setColumns(10);
		txtWithdraw.setVisible(false);
		
		txtDeposit = new JTextField();
		txtDeposit.setBackground(SystemColor.menu);
		txtDeposit.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtDeposit.setText("Deposit: Enter amount below");
		txtDeposit.setHorizontalAlignment(SwingConstants.CENTER);
		txtDeposit.setEditable(false);
		txtDeposit.setColumns(10);
		txtDeposit.setBounds(661, 205, 274, 49);
		mainContentPanel.add(txtDeposit);
		
		txtUsersWithdrawBox = new JTextField();
		txtUsersWithdrawBox.setForeground(Color.RED);
		txtUsersWithdrawBox.setFont(new Font("Times New Roman", Font.BOLD, 24));
		txtUsersWithdrawBox.setBackground(Color.GRAY);
		txtUsersWithdrawBox.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsersWithdrawBox.setBounds(65, 263, 285, 99);
		txtUsersWithdrawBox.setVisible(false);
		mainContentPanel.add(txtUsersWithdrawBox);
		txtUsersWithdrawBox.setColumns(10);
		
		txtUserDepositBox = new JTextField();
		txtUserDepositBox.setForeground(new Color(0, 128, 0));
		txtUserDepositBox.setFont(new Font("Times New Roman", Font.BOLD, 24));
		txtUserDepositBox.setBackground(Color.GRAY);
		txtUserDepositBox.setHorizontalAlignment(SwingConstants.CENTER);
		txtUserDepositBox.setColumns(10);
		txtUserDepositBox.setBounds(650, 268, 285, 99);
		txtUserDepositBox.setVisible(false);
		mainContentPanel.add(txtUserDepositBox);
		
		btnEnterWithdraw = new JButton("Enter");
		btnEnterWithdraw.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				Withdraw();
			}
		});
		btnEnterWithdraw.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnEnterWithdraw.setBounds(65, 422, 285, 23);
		btnEnterWithdraw.setVisible(false);
		mainContentPanel.add(btnEnterWithdraw);
		
		btnEnterDeposit = new JButton("Enter");
		btnEnterDeposit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				Deposit();
			}
		});
		btnEnterDeposit.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnEnterDeposit.setBounds(650, 425, 285, 23);
		btnEnterDeposit.setVisible(false);
		mainContentPanel.add(btnEnterDeposit);
		
		txtDisplayTotal = new JTextField();
		txtDisplayTotal.setFont(new Font("Lucida Bright", Font.BOLD, 32));
		txtDisplayTotal.setBorder(null);
		txtDisplayTotal.setEditable(false);
		txtDisplayTotal.setForeground(new Color(0, 128, 0));
		txtDisplayTotal.setBackground(SystemColor.menu);
		txtDisplayTotal.setHorizontalAlignment(SwingConstants.CENTER);
		txtDisplayTotal.setColumns(10);
		txtDisplayTotal.setBounds(360, 279, 285, 99);
		mainContentPanel.add(txtDisplayTotal);
		
		txtCantWithdraw = new JTextField();
		txtCantWithdraw.setBorder(null);
		txtCantWithdraw.setEditable(false);
		txtCantWithdraw.setBackground(SystemColor.menu);
		txtCantWithdraw.setHorizontalAlignment(SwingConstants.CENTER);
		txtCantWithdraw.setFont(new Font("Times New Roman", Font.BOLD, 18));
		txtCantWithdraw.setBounds(373, 426, 267, 20);
		mainContentPanel.add(txtCantWithdraw);
		txtCantWithdraw.setColumns(10);
		
		txtCEO = new JTextField();
		txtCEO.setHorizontalAlignment(SwingConstants.CENTER);
		txtCEO.setText("CEO:Amalan Pulendran");
		txtCEO.setFont(new Font("Traditional Arabic", Font.ITALIC, 22));
		txtCEO.setBackground(SystemColor.menu);
		txtCEO.setBorder(null);
		txtCEO.setBounds(196, 75, 619, 56);
		mainContentPanel.add(txtCEO);
		txtCEO.setColumns(10);
		txtDeposit.setVisible(false);
		txtDisplayTotal.setVisible(false);
		
		
	}
	
	public void makeAccount()
	{
		txtPleaseMakeAn.setVisible(false);
		txtName.setVisible(true);
		btnSetName.setVisible(true);
		textFieldEnterName.setVisible(true);
		
	}
	public void setName()
	{
		Name = textFieldEnterName.getText();
		ID = getNumber();
		makeTheAccount();
		txtName.setVisible(false);
		btnSetName.setVisible(false);
		textFieldEnterName.setVisible(false);
		
	}
	public String getNumber()
	{
	String ID="";
	Random gen = new Random();	
	for(int i = 0; i < 4;i++)
	{
		int part = gen.nextInt(10);
		ID += part;
	}
	return ID;
	}
	public void makeTheAccount()
	{
		account1.setAccountHolderName(Name);
		account1.setAccountID(ID);
		loadContent();
	}
	public void loadContent()
	{
		txtDisplayName.setText("Your Name "+account1.getAccountHolderName());
		txtDisplayID.setText("Your ID #"+account1.getAccountID());
		btnEnterWithdraw.setVisible(true);
		btnEnterDeposit.setVisible(true);
		txtUsersWithdrawBox.setVisible(true);
		txtUserDepositBox.setVisible(true);
		txtDisplayTotal.setVisible(true);
		txtWithdraw.setVisible(true);
		txtDeposit.setVisible(true);
		
	}
	public void  Withdraw()
	{	
		txtCantWithdraw.setText("");
		double testForNeg = account1.getAccountTotalt();
		negNumber = 0;
		String withdrawString = txtUsersWithdrawBox.getText();
		negNumber = Double.parseDouble(withdrawString);
		negNumber*=-1;
		if(testForNeg + negNumber >0)
		{
			account1.setAccountTotal(negNumber);
			txtUsersWithdrawBox.setText("");
			setTotal();
		}
		else
		{
			txtCantWithdraw.setText("Sorry can't withdraw $"+ negNumber*-1 +".");
			txtUsersWithdrawBox.setText("");
		}
	}
	public void Deposit()
	{
		txtCantWithdraw.setText("");
		posNumber = 0;
		String depositString = txtUserDepositBox.getText();
		posNumber = Double.parseDouble(depositString);
		posNumber*=1;
		account1.setAccountTotal(posNumber);
		txtUserDepositBox.setText("");
		setTotal();
	}
	public void setTotal()
	{
		double number = account1.getAccountTotalt();
		String total = String.valueOf(number);
		txtDisplayTotal.setForeground(new Color(0, 128, 0));
		txtDisplayTotal.setText("$"+total);
		
		
	}
	public void ResetGame()
	{
		//Resetting
		txtPleaseMakeAn.setVisible(true);
		btnEnterWithdraw.setVisible(false);
		textFieldEnterName.setText("");
		txtDisplayTotal.setText("");
		txtDisplayName.setText("");
		txtDisplayID.setText("");
		btnEnterDeposit.setVisible(false);
		txtUsersWithdrawBox.setVisible(false);
		txtUserDepositBox.setVisible(false);
		txtDisplayTotal.setVisible(false);
		txtWithdraw.setVisible(false);
		txtDeposit.setVisible(false);
		

		
	}
}
