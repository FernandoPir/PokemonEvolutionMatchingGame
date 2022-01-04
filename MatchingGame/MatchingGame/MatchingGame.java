 
/**
 * Programmer: Fernando Pires Rui
 * Date: 26/05/2021
 * Name: Matching Game
 * This program will create a pokemon theme matching game using arrays. 16 cards will be displayed
 * being 8 cards the pokemon in first evolution form and 8 cards of their respective evolution. The 
 * user will need to match all the pokemons with their respective evolutions.
 */

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

public class MatchingGame extends JFrame {

	ArrayList<String> cards = new ArrayList();
	ArrayList<String> set = new ArrayList();
	ArrayList<Integer> change = new ArrayList();
	int[] confirm = new int[20];

	// Creating the pokemons ImageIcon

	// https://icons.iconarchive.com/icons/hektakun/pokemon/72/190-Aipom-icon.png
	ImageIcon aipom = new ImageIcon(getClass().getResource("/images/aipom.png"));

	// https://icons.iconarchive.com/icons/hektakun/pokemon/72/424-Ambipom-icon.png
	ImageIcon ambipom = new ImageIcon(getClass().getResource("/images/ambipom.png"));

	// https://icons.iconarchive.com/icons/hektakun/pokemon/72/447-Riolu-icon.png
	ImageIcon riolu = new ImageIcon(getClass().getResource("/images/Riolu.png"));

	// https://icons.iconarchive.com/icons/hektakun/pokemon/72/448-Lucario-icon.png
	ImageIcon lucario = new ImageIcon(getClass().getResource("/images/Lucario.png"));

	// https://icons.iconarchive.com/icons/hektakun/pokemon/72/025-Pikachu-icon.png
	ImageIcon pikachu = new ImageIcon(getClass().getResource("/images/Pikachu.png"));

	// https://icons.iconarchive.com/icons/hektakun/pokemon/72/026-Raichu-icon.png
	ImageIcon raichu = new ImageIcon(getClass().getResource("/images/Raichu.png"));

	// https://icons.iconarchive.com/icons/hektakun/pokemon/72/113-Chansey-icon.png
	ImageIcon chansey = new ImageIcon(getClass().getResource("/images/Chansey.png"));

	// https://icons.iconarchive.com/icons/hektakun/pokemon/72/242-Blissey-icon.png
	ImageIcon blissey = new ImageIcon(getClass().getResource("/images/Blissey.png"));

	// https://icons.iconarchive.com/icons/hektakun/pokemon/72/129-Magikarp-icon.png
	ImageIcon magikarp = new ImageIcon(getClass().getResource("/images/Magikarp.png"));

	// https://icons.iconarchive.com/icons/hektakun/pokemon/72/130-Gyarados-icon.png
	ImageIcon gyarados = new ImageIcon(getClass().getResource("/images/Gyarados.png"));

	// https://icons.iconarchive.com/icons/hektakun/pokemon/72/058-Growlithe-icon.png
	ImageIcon growlithe = new ImageIcon(getClass().getResource("/images/Growlithe.png"));

	// https://icons.iconarchive.com/icons/hektakun/pokemon/72/059-Arcanine-icon.png
	ImageIcon arcanine = new ImageIcon(getClass().getResource("/images/Arcanine.png"));

	// https://icons.iconarchive.com/icons/hektakun/pokemon/72/436-Bronzor-icon.png
	ImageIcon bronzor = new ImageIcon(getClass().getResource("/images/bronzor.png"));

	// https://icons.iconarchive.com/icons/hektakun/pokemon/72/436-Bronzor-icon.png
	ImageIcon bronzong = new ImageIcon(getClass().getResource("/images/Bronzong.png"));

	// https://icons.iconarchive.com/icons/hektakun/pokemon/72/200-Misdreavus-icon.png
	ImageIcon misdreavus = new ImageIcon(getClass().getResource("/images/Misdreavus.png"));

	// https://icons.iconarchive.com/icons/hektakun/pokemon/72/429-Mismagius-icon.png
	ImageIcon mismagius = new ImageIcon(getClass().getResource("/images/Mismagius.png"));
	
	//https://icons.iconarchive.com/icons/hektakun/pokemon/72/418-Buizel-icon.png
	ImageIcon buizel = new ImageIcon(getClass().getResource("/images/Buizel.png"));
	
	//https://icons.iconarchive.com/icons/hektakun/pokemon/72/418-Buizel-icon.png
	ImageIcon floatzel = new ImageIcon(getClass().getResource("/images/Floatzel.png"));
	
	//https://icons.iconarchive.com/icons/hektakun/pokemon/72/019-Rattata-icon.png
	ImageIcon rattata = new ImageIcon(getClass().getResource("/images/Rattata.png"));
	
	//https://icons.iconarchive.com/icons/hektakun/pokemon/72/020-Raticate-icon.png
	ImageIcon raticate = new ImageIcon(getClass().getResource("/images/Raticate.png"));
	
	ImageIcon back = new ImageIcon(getClass().getResource("/images/Pokeball-icon.png"));
	ImageIcon done = new ImageIcon(getClass().getResource("/images/done.jpg"));

	int Count, count, c1, c2, card1, card2;
	int cardsLeft = 20;

	private JPanel contentPane;
	private JTextField Instructions;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					MatchingGame frame = new MatchingGame();
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
	public MatchingGame() {
		setTitle("Pokemon Evolution Matching Game");
		setForeground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//	Creating The Title
		JLabel Title = new JLabel("Pokemon Evolutions Matching Game");
		Title.setFont(new Font("Segoe UI Black", Font.BOLD, 28));
		Title.setForeground(new Color(255, 153, 0));
		Title.setBounds(153, 25, 695, 38);
		contentPane.add(Title);
		
		//	Creating the card 1
		JButton Card1 = new JButton("");
		
		/**
		 * Creating an mouseClicked event to display the picture
		 * when the user click on the button.
		 */
		Card1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// Checking if "Play" was pressed before clicking on the card
				if (Count < 1) {
					JOptionPane.showMessageDialog(null, "You must click in the \"Play\" button first");
					return;
				}
				
				//	Checking if card is already guessed right
				if (confirm[0] == 1) {
					JOptionPane.showMessageDialog(null, "Card already guessed right");
					return;
				}
				
				
				//	Checking if two cards were already pressed
				count++;
				if (count > 2) {
					JOptionPane.showMessageDialog(null,	"You already selected 2 buttons, please click on the \"Guess Again\" button");
					count = 2;
					return;
				}
				
				//	Displaying the card that the user button is holding
				int num = Integer.parseInt(cards.get(0));
				String temp = Integer.toString(num);
				if (temp.equals("1")) {
					Card1.setIcon(aipom);
				} else if (temp.equals("2")) {
					Card1.setIcon(ambipom);
				} else if (temp.equals("3")) {
					Card1.setIcon(riolu);
				} else if (temp.equals("4")) {
					Card1.setIcon(lucario);
				} else if (temp.equals("5")) {
					Card1.setIcon(pikachu);
				} else if (temp.equals("6")) {
					Card1.setIcon(raichu);
				} else if (temp.equals("7")) {
					Card1.setIcon(chansey);
				} else if (temp.equals("8")) {
					Card1.setIcon(blissey);
				} else if (temp.equals("9")) {
					Card1.setIcon(magikarp);
				} else if (temp.equals("10")) {
					Card1.setIcon(gyarados);
				} else if (temp.equals("11")) {
					Card1.setIcon(growlithe);
				} else if (temp.equals("12")) {
					Card1.setIcon(arcanine);
				} else if (temp.equals("13")) {
					Card1.setIcon(bronzor);
				} else if (temp.equals("14")) {
					Card1.setIcon(bronzong);
				} else if (temp.equals("15")) {
					Card1.setIcon(misdreavus);
				} else if (temp.equals("16")) {
					Card1.setIcon(mismagius);
				} else if (temp.equals("17")){ 
					Card1.setIcon(buizel); 
				} else if (temp.equals("18")){ 
					Card1.setIcon(floatzel); 
				} else if (temp.equals("19")){ 
					Card1.setIcon(rattata);
				} else if (temp.equals("20")){ 
					Card1.setIcon(raticate); 
				}
				// Holding the number on the change array to see if there is a match
				change.set(0, Integer.parseInt(temp));
			}
		});
		Card1.setIcon(new ImageIcon(MatchingGame.class.getResource("/images/PokeBall-icon.png")));
		// Availability:
		// https://icons.iconarchive.com/icons/draseart/dumper/128/PokeBall-icon.png
		
		Card1.setBounds(10, 100, 144, 105);
		
		contentPane.add(Card1);
		
		// Creating the card 2
		JButton Card2 = new JButton("");
		
		/**
		 * Creating an mouseClicked event to display the picture
		 * when the user click on the button.
		 */
		Card2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// Checking if "Play" was pressed before clicking on the card
				if (Count < 1) {
					JOptionPane.showMessageDialog(null, "You must click in the \"Play\" button first");
					return;
				}
				
				//	Checking if card is already guessed right
				if (confirm[1] == 1) {
					JOptionPane.showMessageDialog(null, "Card already guessed right");
					return;
				}
				// Checking if two cards were already pressed
				count++;
				if (count > 2) {
					JOptionPane.showMessageDialog(null,	"You already selected 2 buttons, please click on the \"Guess Again\" button");
					count = 2;
					return;
				}
				
				//	Displaying the card that the user button is holding
				int num = Integer.parseInt(cards.get(1));
				String temp = Integer.toString(num);
				if (temp.equals("1")) {
					Card2.setIcon(aipom);
				} else if (temp.equals("2")) {
					Card2.setIcon(ambipom);
				} else if (temp.equals("3")) {
					Card2.setIcon(riolu);
				} else if (temp.equals("4")) {
					Card2.setIcon(lucario);
				} else if (temp.equals("5")) {
					Card2.setIcon(pikachu);
				} else if (temp.equals("6")) {
					Card2.setIcon(raichu);
				} else if (temp.equals("7")) {
					Card2.setIcon(chansey);
				} else if (temp.equals("8")) {
					Card2.setIcon(blissey);
				} else if (temp.equals("9")) {
					Card2.setIcon(magikarp);
				} else if (temp.equals("10")) {
					Card2.setIcon(gyarados);
				} else if (temp.equals("11")) {
					Card2.setIcon(growlithe);
				} else if (temp.equals("12")) {
					Card2.setIcon(arcanine);
				} else if (temp.equals("13")) {
					Card2.setIcon(bronzor);
				} else if (temp.equals("14")) {
					Card2.setIcon(bronzong);
				} else if (temp.equals("15")) {
					Card2.setIcon(misdreavus);
				} else if (temp.equals("16")) {
					Card2.setIcon(mismagius);
				} else if (temp.equals("17")){ 
					Card1.setIcon(buizel); 
				} else if (temp.equals("18")){ 
					Card2.setIcon(floatzel); 
				} else if (temp.equals("19")){ 
					Card2.setIcon(rattata);
				} else if (temp.equals("20")){ 
					Card2.setIcon(raticate); 
				}
				
				// Holding the number on the change array to see if there is a match
				change.set(1, Integer.parseInt(temp));

			}
		});
		Card2.setIcon(new ImageIcon(MatchingGame.class.getResource("/images/PokeBall-icon.png")));
		// Availability:
		// https://icons.iconarchive.com/icons/draseart/dumper/128/PokeBall-icon.png
		
		Card2.setBounds(10, 216, 144, 112);
		contentPane.add(Card2);
		
		// Creating the card 3
		JButton Card3 = new JButton("");
		
		/**
		 * Creating an mouseClicked event to display the picture
		 * when the user click on the button.
		 */
		Card3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Checking if "Play" was pressed before clicking on the card
				if (Count < 1) {
					JOptionPane.showMessageDialog(null, "You must click in the \"Play\" button first");
					return;
				}
				// Checking if card is already guessed right
				if (confirm[2] == 1) {
					JOptionPane.showMessageDialog(null, "Card already guessed right");
					return;
				}
				
				// Checking if two cards were already pressed
				count++;
				if (count > 2) {
					JOptionPane.showMessageDialog(null,	"You already selected 2 buttons, please click on the \"Guess Again\" button");
					count = 2;
					return;
				}
				
				// Displaying the card that this button is holding
				int num = Integer.parseInt(cards.get(2));
				String temp = Integer.toString(num);
				if (temp.equals("1")) {
					Card3.setIcon(aipom);
				} else if (temp.equals("2")) {
					Card3.setIcon(ambipom);
				} else if (temp.equals("3")) {
					Card3.setIcon(riolu);
				} else if (temp.equals("4")) {
					Card3.setIcon(lucario);
				} else if (temp.equals("5")) {
					Card3.setIcon(pikachu);
				} else if (temp.equals("6")) {
					Card3.setIcon(raichu);
				} else if (temp.equals("7")) {
					Card3.setIcon(chansey);
				} else if (temp.equals("8")) {
					Card3.setIcon(blissey);
				} else if (temp.equals("9")) {
					Card3.setIcon(magikarp);
				} else if (temp.equals("10")) {
					Card3.setIcon(gyarados);
				} else if (temp.equals("11")) {
					Card3.setIcon(growlithe);
				} else if (temp.equals("12")) {
					Card3.setIcon(arcanine);
				} else if (temp.equals("13")) {
					Card3.setIcon(bronzor);
				} else if (temp.equals("14")) {
					Card3.setIcon(bronzong);
				} else if (temp.equals("15")) {
					Card3.setIcon(misdreavus);
				} else if (temp.equals("16")) {
					Card3.setIcon(mismagius);
				} else if (temp.equals("17")){ 
					Card3.setIcon(buizel); 
				} else if (temp.equals("18")){ 
					Card3.setIcon(floatzel); 
				} else if (temp.equals("19")){ 
					Card3.setIcon(rattata);
				} else if (temp.equals("20")){ 
					Card3.setIcon(raticate); 
				}
				
				// Holding the number on the change array to see if there is a match
				change.set(2, Integer.parseInt(temp));

			}
		});
		Card3.setIcon(new ImageIcon(MatchingGame.class.getResource("/images/PokeBall-icon.png")));
		// Availability:
		// https://icons.iconarchive.com/icons/draseart/dumper/128/PokeBall-icon.png
		
		Card3.setBounds(10, 339, 144, 105);
		contentPane.add(Card3);
		
		//	Creating the card 4
		JButton Card4 = new JButton("");
		
		/**
		 * Creating an mouseClicked event to display the picture
		 * when the user click on the button.
		 */
		Card4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// Checking if "Play" was pressed before clicking on the card
				if (Count < 1) {
					JOptionPane.showMessageDialog(null, "You must click in the \"Play\" button first");
					return;
				}
				
				// Checking if card is already guessed right
				if (confirm[3] == 1) {
					JOptionPane.showMessageDialog(null, "Card already guessed right");
					return;
				}
				
				// Checking if two cards were already pressed
				count++;
				if (count > 2) {
					JOptionPane.showMessageDialog(null,
							"You already selected 2 buttons, please click on the \"Guess Again\" button");
					count = 2;
					return;
				}
				
				// Displaying the card that the user button is holding
				int num = Integer.parseInt(cards.get(3));
				String temp = Integer.toString(num);
				if (temp.equals("1")) {
					Card4.setIcon(aipom);
				} else if (temp.equals("2")) {
					Card4.setIcon(ambipom);
				} else if (temp.equals("3")) {
					Card4.setIcon(riolu);
				} else if (temp.equals("4")) {
					Card4.setIcon(lucario);
				} else if (temp.equals("5")) {
					Card4.setIcon(pikachu);
				} else if (temp.equals("6")) {
					Card4.setIcon(raichu);
				} else if (temp.equals("7")) {
					Card4.setIcon(chansey);
				} else if (temp.equals("8")) {
					Card4.setIcon(blissey);
				} else if (temp.equals("9")) {
					Card4.setIcon(magikarp);
				} else if (temp.equals("10")) {
					Card4.setIcon(gyarados);
				} else if (temp.equals("11")) {
					Card4.setIcon(growlithe);
				} else if (temp.equals("12")) {
					Card4.setIcon(arcanine);
				} else if (temp.equals("13")) {
					Card4.setIcon(bronzor);
				} else if (temp.equals("14")) {
					Card4.setIcon(bronzong);
				} else if (temp.equals("15")) {
					Card4.setIcon(misdreavus);
				} else if (temp.equals("16")) {
					Card4.setIcon(mismagius);
				} else if (temp.equals("17")){ 
					Card4.setIcon(buizel); 
				} else if (temp.equals("18")){ 
					Card4.setIcon(floatzel); 
				} else if (temp.equals("19")){ 
					Card4.setIcon(rattata);
				} else if (temp.equals("20")){ 
					Card4.setIcon(raticate); 
				}
				
				// Holding the number on the change array to see if there is a match
				change.set(3, Integer.parseInt(temp));
			}
		});
		Card4.setIcon(new ImageIcon(MatchingGame.class.getResource("/images/PokeBall-icon.png")));
		// Availability:
		// https://icons.iconarchive.com/icons/draseart/dumper/128/PokeBall-icon.png
		
		Card4.setBounds(10, 455, 144, 105);
		contentPane.add(Card4);
		
		// Creating the card 5
		JButton Card5 = new JButton("");
		
		/**
		 * Creating an mouseClicked event to display the picture
		 * when the user click on the button.
		 */
		Card5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// Checking if "Play" was pressed before clicking on the card
				if (Count < 1) {
					JOptionPane.showMessageDialog(null, "You must click in the \"Play\" button first");
					return;
				}

				// Checking if card is already guessed right
				if (confirm[4] == 1) {
					JOptionPane.showMessageDialog(null, "Card already guessed right");
					return;
				}
				
				// Checking if two cards were already pressed
				count++;
				if (count > 2) {
					JOptionPane.showMessageDialog(null,
							"You already selected 2 buttons, please click on the \"Guess Again\" button");
					count = 2;
					return;
				}
				
				// Displaying the card that the user button is holding
				int num = Integer.parseInt(cards.get(4));
				String temp = Integer.toString(num);
				if (temp.equals("1")) {
					Card5.setIcon(aipom);
				} else if (temp.equals("2")) {
					Card5.setIcon(ambipom);
				} else if (temp.equals("3")) {
					Card5.setIcon(riolu);
				} else if (temp.equals("4")) {
					Card5.setIcon(lucario);
				} else if (temp.equals("5")) {
					Card5.setIcon(pikachu);
				} else if (temp.equals("6")) {
					Card5.setIcon(raichu);
				} else if (temp.equals("7")) {
					Card5.setIcon(chansey);
				} else if (temp.equals("8")) {
					Card5.setIcon(blissey);
				} else if (temp.equals("9")) {
					Card5.setIcon(magikarp);
				} else if (temp.equals("10")) {
					Card5.setIcon(gyarados);
				} else if (temp.equals("11")) {
					Card5.setIcon(growlithe);
				} else if (temp.equals("12")) {
					Card5.setIcon(arcanine);
				} else if (temp.equals("13")) {
					Card5.setIcon(bronzor);
				} else if (temp.equals("14")) {
					Card5.setIcon(bronzong);
				} else if (temp.equals("15")) {
					Card5.setIcon(misdreavus);
				} else if (temp.equals("16")) {
					Card5.setIcon(mismagius);
				} else if (temp.equals("17")){ 
					Card5.setIcon(buizel); 
				} else if (temp.equals("18")){ 
					Card5.setIcon(floatzel); 
				} else if (temp.equals("19")){ 
					Card5.setIcon(rattata);
				} else if (temp.equals("20")){ 
					Card5.setIcon(raticate); 
				}
				
				// Holding the number on the change array to see if there is a match
				change.set(4, Integer.parseInt(temp));
			}
		});
		
		
		Card5.setIcon(new ImageIcon(MatchingGame.class.getResource("/images/PokeBall-icon.png")));
		// Availability:
		// https://icons.iconarchive.com/icons/draseart/dumper/128/PokeBall-icon.png
		
		Card5.setBounds(181, 100, 144, 105);
		contentPane.add(Card5);
		
		//	Creating the card 6
		JButton Card6 = new JButton("");
		
		/**
		 * Creating an mouseClicked event to display the picture
		 * when the user click on the button.
		 */
		Card6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// Checking if "Play" was pressed before clicking on the card
				if (Count < 1) {
					JOptionPane.showMessageDialog(null, "You must click in the \"Play\" button first");
					return;
				}
				
				// Checking if card is already guessed right
				if (confirm[5] == 1) {
					JOptionPane.showMessageDialog(null, "Card already guessed right");
					return;
				}
				
				// Checking if two cards were already pressed
				count++;
				if (count > 2) {
					JOptionPane.showMessageDialog(null,
							"You already selected 2 buttons, please click on the \"Guess Again\" button");
					count = 2;
					return;
				}
				
				// Displaying the card that the user button is holding
				int num = Integer.parseInt(cards.get(5));
				String temp = Integer.toString(num);
				if (temp.equals("1")) {
					Card6.setIcon(aipom);
				} else if (temp.equals("2")) {
					Card6.setIcon(ambipom);
				} else if (temp.equals("3")) {
					Card6.setIcon(riolu);
				} else if (temp.equals("4")) {
					Card6.setIcon(lucario);
				} else if (temp.equals("5")) {
					Card6.setIcon(pikachu);
				} else if (temp.equals("6")) {
					Card6.setIcon(raichu);
				} else if (temp.equals("7")) {
					Card6.setIcon(chansey);
				} else if (temp.equals("8")) {
					Card6.setIcon(blissey);
				} else if (temp.equals("9")) {
					Card6.setIcon(magikarp);
				} else if (temp.equals("10")) {
					Card6.setIcon(gyarados);
				} else if (temp.equals("11")) {
					Card6.setIcon(growlithe);
				} else if (temp.equals("12")) {
					Card6.setIcon(arcanine);
				} else if (temp.equals("13")) {
					Card6.setIcon(bronzor);
				} else if (temp.equals("14")) {
					Card6.setIcon(bronzong);
				} else if (temp.equals("15")) {
					Card6.setIcon(misdreavus);
				} else if (temp.equals("16")) {
					Card6.setIcon(mismagius);
				} else if (temp.equals("17")){ 
					Card6.setIcon(buizel); 
				} else if (temp.equals("18")){ 
					Card6.setIcon(floatzel); 
				} else if (temp.equals("19")){ 
					Card6.setIcon(rattata);
				} else if (temp.equals("20")){ 
					Card6.setIcon(raticate); 
				}
				
				// Holding the number on the change array to see if there is a match
				change.set(5, Integer.parseInt(temp));
			}
		});
		
		Card6.setIcon(new ImageIcon(MatchingGame.class.getResource("/images/PokeBall-icon.png")));
		// Availability:
		// https://icons.iconarchive.com/icons/draseart/dumper/128/PokeBall-icon.png
		
		Card6.setBounds(181, 216, 144, 112);
		contentPane.add(Card6);
		
		// Creating the card 7
		JButton Card7 = new JButton("");
		
		/**
		 * Creating an mouseClicked event to display the picture
		 * when the user click on the button.
		 */
		Card7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// Checking if "Play" was pressed before clicking on the card
				if (Count < 1) {
					JOptionPane.showMessageDialog(null, "You must click in the \"Play\" button first");
					return;
				}
				
				// Checking if card is already guessed right
				if (confirm[6] == 1) {
					JOptionPane.showMessageDialog(null, "Card already guessed right");
					return;
				}
				
				// Checking if two cards were already pressed
				count++;
				if (count > 2) {
					JOptionPane.showMessageDialog(null,
							"You already selected 2 buttons, please click on the \"Guess Again\" button");
					count = 2;
					return;
				}
				
				// Displaying the card that the user button is holding
				int num = Integer.parseInt(cards.get(6));
				String temp = Integer.toString(num);
				if (temp.equals("1")) {
					Card7.setIcon(aipom);
				} else if (temp.equals("2")) {
					Card7.setIcon(ambipom);
				} else if (temp.equals("3")) {
					Card7.setIcon(riolu);
				} else if (temp.equals("4")) {
					Card7.setIcon(lucario);
				} else if (temp.equals("5")) {
					Card7.setIcon(pikachu);
				} else if (temp.equals("6")) {
					Card7.setIcon(raichu);
				} else if (temp.equals("7")) {
					Card7.setIcon(chansey);
				} else if (temp.equals("8")) {
					Card7.setIcon(blissey);
				} else if (temp.equals("9")) {
					Card7.setIcon(magikarp);
				} else if (temp.equals("10")) {
					Card7.setIcon(gyarados);
				} else if (temp.equals("11")) {
					Card7.setIcon(growlithe);
				} else if (temp.equals("12")) {
					Card7.setIcon(arcanine);
				} else if (temp.equals("13")) {
					Card7.setIcon(bronzor);
				} else if (temp.equals("14")) {
					Card7.setIcon(bronzong);
				} else if (temp.equals("15")) {
					Card7.setIcon(misdreavus);
				} else if (temp.equals("16")) {
					Card7.setIcon(mismagius);
				} else if (temp.equals("17")){ 
					Card7.setIcon(buizel); 
				} else if (temp.equals("18")){ 
					Card7.setIcon(floatzel); 
				} else if (temp.equals("19")){ 
					Card7.setIcon(rattata);
				} else if (temp.equals("20")){ 
					Card7.setIcon(raticate); 
				}

				// Holding the number on the change array to see if there is a match
				change.set(6, Integer.parseInt(temp));
			}
		});
		Card7.setIcon(new ImageIcon(MatchingGame.class.getResource("/images/PokeBall-icon.png")));
		
		// Availability:
		// https://icons.iconarchive.com/icons/draseart/dumper/128/PokeBall-icon.png
		Card7.setBounds(181, 339, 144, 105);
		contentPane.add(Card7);
		
		// Creating the card 8
		JButton Card8 = new JButton("");
		
		/**
		 * Creating an mouseClicked event to display the picture
		 * when the user click on the button.
		 */
		Card8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// Checking if "Play" was pressed before clicking on the card
				if (Count < 1) {
					JOptionPane.showMessageDialog(null, "You must click in the \"Play\" button first");
					return;
				}
				
				// Checking if card is already guessed right
				if (confirm[7] == 1) {
					JOptionPane.showMessageDialog(null, "Card already guessed right");
					return;
				}
				
				// Checking if two cards were already pressed
				count++;
				if (count > 2) {
					JOptionPane.showMessageDialog(null,
							"You already selected 2 buttons, please click on the \"Guess Again\" button");
					count = 2;
					return;
				}
				
				// Displaying the card that the user button is holding
				int num = Integer.parseInt(cards.get(7));
				String temp = Integer.toString(num);
				if (temp.equals("1")) {
					Card8.setIcon(aipom);
				} else if (temp.equals("2")) {
					Card8.setIcon(ambipom);
				} else if (temp.equals("3")) {
					Card8.setIcon(riolu);
				} else if (temp.equals("4")) {
					Card8.setIcon(lucario);
				} else if (temp.equals("5")) {
					Card8.setIcon(pikachu);
				} else if (temp.equals("6")) {
					Card8.setIcon(raichu);
				} else if (temp.equals("7")) {
					Card8.setIcon(chansey);
				} else if (temp.equals("8")) {
					Card8.setIcon(blissey);
				} else if (temp.equals("9")) {
					Card8.setIcon(magikarp);
				} else if (temp.equals("10")) {
					Card8.setIcon(gyarados);
				} else if (temp.equals("11")) {
					Card8.setIcon(growlithe);
				} else if (temp.equals("12")) {
					Card8.setIcon(arcanine);
				} else if (temp.equals("13")) {
					Card8.setIcon(bronzor);
				} else if (temp.equals("14")) {
					Card8.setIcon(bronzong);
				} else if (temp.equals("15")) {
					Card8.setIcon(misdreavus);
				} else if (temp.equals("16")) {
					Card8.setIcon(mismagius);
				} else if (temp.equals("17")){ 
					Card8.setIcon(buizel); 
				} else if (temp.equals("18")){ 
					Card8.setIcon(floatzel); 
				} else if (temp.equals("19")){ 
					Card8.setIcon(rattata);
				} else if (temp.equals("20")){ 
					Card8.setIcon(raticate); 
				}

				// Holding the number on the change array to see if there is a match
				change.set(7, Integer.parseInt(temp));
			}
		});
		
		Card8.setIcon(new ImageIcon(MatchingGame.class.getResource("/images/PokeBall-icon.png")));
		// Availability:
		// https://icons.iconarchive.com/icons/draseart/dumper/128/PokeBall-icon.png
		
		Card8.setBounds(181, 455, 144, 105);
		contentPane.add(Card8);
		
		// Creating the card 9
		JButton Card9 = new JButton("");
		
		/**
		 * Creating an mouseClicked event to display the picture
		 * when the user click on the button.
		 */
		Card9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// Checking if "Play" was pressed before clicking on the card
				if (Count < 1) {
					JOptionPane.showMessageDialog(null, "You must click in the \"Play\" button first");
					return;
				}
				
				// Checking if card is already guessed right
				if (confirm[8] == 1) {
					JOptionPane.showMessageDialog(null, "Card already guessed right");
					return;
				}
				
				// Checking if two cards were already pressed
				count++;
				if (count > 2) {
					JOptionPane.showMessageDialog(null,
							"You already selected 2 buttons, please click on the \"Guess Again\" button");
					count = 2;
					return;
				}
				
				// Displaying the card that the user button is holding
				int num = Integer.parseInt(cards.get(8));
				String temp = Integer.toString(num);
				if (temp.equals("1")) {
					Card9.setIcon(aipom);
				} else if (temp.equals("2")) {
					Card9.setIcon(ambipom);
				} else if (temp.equals("3")) {
					Card9.setIcon(riolu);
				} else if (temp.equals("4")) {
					Card9.setIcon(lucario);
				} else if (temp.equals("5")) {
					Card9.setIcon(pikachu);
				} else if (temp.equals("6")) {
					Card9.setIcon(raichu);
				} else if (temp.equals("7")) {
					Card9.setIcon(chansey);
				} else if (temp.equals("8")) {
					Card9.setIcon(blissey);
				} else if (temp.equals("9")) {
					Card9.setIcon(magikarp);
				} else if (temp.equals("10")) {
					Card9.setIcon(gyarados);
				} else if (temp.equals("11")) {
					Card9.setIcon(growlithe);
				} else if (temp.equals("12")) {
					Card9.setIcon(arcanine);
				} else if (temp.equals("13")) {
					Card9.setIcon(bronzor);
				} else if (temp.equals("14")) {
					Card9.setIcon(bronzong);
				} else if (temp.equals("15")) {
					Card9.setIcon(misdreavus);
				} else if (temp.equals("16")) {
					Card9.setIcon(mismagius);
				}  else if (temp.equals("17")){ 
					Card9.setIcon(buizel); 
				} else if (temp.equals("18")){ 
					Card9.setIcon(floatzel); 
				} else if (temp.equals("19")){ 
					Card9.setIcon(rattata);
				} else if (temp.equals("20")){ 
					Card9.setIcon(raticate); 
				}

				// Holding the number on the change array to see if there is a match
				change.set(8, Integer.parseInt(temp));
			}
		});
		
		Card9.setIcon(new ImageIcon(MatchingGame.class.getResource("/images/PokeBall-icon.png")));
		// Availability:
		// https://icons.iconarchive.com/icons/draseart/dumper/128/PokeBall-icon.png
		
		Card9.setBounds(350, 100, 144, 105);
		contentPane.add(Card9);
		
		//	Creating the card 10
		JButton Card10 = new JButton("");
		
		/**
		 * Creating an mouseClicked event to display the picture
		 * when the user click on the button.
		 */
		Card10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// Checking if "Play" was pressed before clicking on the card
				if (Count < 1) {
					JOptionPane.showMessageDialog(null, "You must click in the \"Play\" button first");
					return;
				}
				
				// Checking if card is already guessed right
				if (confirm[9] == 1) {
					JOptionPane.showMessageDialog(null, "Card already guessed right");
					return;
				}
				
				// Checking if two cards were already pressed
				count++;
				if (count > 2) {
					JOptionPane.showMessageDialog(null,
							"You already selected 2 buttons, please click on the \"Guess Again\" button");
					count = 2;
					return;
				}
				
				// Displaying the card that the user button is holding
				int num = Integer.parseInt(cards.get(9));
				String temp = Integer.toString(num);
				if (temp.equals("1")) {
					Card10.setIcon(aipom);
				} else if (temp.equals("2")) {
					Card10.setIcon(ambipom);
				} else if (temp.equals("3")) {
					Card10.setIcon(riolu);
				} else if (temp.equals("4")) {
					Card10.setIcon(lucario);
				} else if (temp.equals("5")) {
					Card10.setIcon(pikachu);
				} else if (temp.equals("6")) {
					Card10.setIcon(raichu);
				} else if (temp.equals("7")) {
					Card10.setIcon(chansey);
				} else if (temp.equals("8")) {
					Card10.setIcon(blissey);
				} else if (temp.equals("9")) {
					Card10.setIcon(magikarp);
				} else if (temp.equals("10")) {
					Card10.setIcon(gyarados);
				} else if (temp.equals("11")) {
					Card10.setIcon(growlithe);
				} else if (temp.equals("12")) {
					Card10.setIcon(arcanine);
				} else if (temp.equals("13")) {
					Card10.setIcon(bronzor);
				} else if (temp.equals("14")) {
					Card10.setIcon(bronzong);
				} else if (temp.equals("15")) {
					Card10.setIcon(misdreavus);
				} else if (temp.equals("16")) {
					Card10.setIcon(mismagius);
				} else if (temp.equals("17")){ 
					Card10.setIcon(buizel); 
				} else if (temp.equals("18")){ 
					Card10.setIcon(floatzel); 
				} else if (temp.equals("19")){ 
					Card10.setIcon(rattata);
				} else if (temp.equals("20")){ 
					Card10.setIcon(raticate); 
				}

				// Holding the number on the change array to see if there is a match
				change.set(9, Integer.parseInt(temp));
			}
		});
		
		Card10.setIcon(new ImageIcon(MatchingGame.class.getResource("/images/PokeBall-icon.png")));
		// Availability:
		// https://icons.iconarchive.com/icons/draseart/dumper/128/PokeBall-icon.png
		
		Card10.setBounds(350, 216, 144, 112);
		contentPane.add(Card10);
		
		// Creating the card 11
		JButton Card11 = new JButton("");
		
		/**
		 * Creating an mouseClicked event to display the picture
		 * when the user click on the button.
		 */
		Card11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// Checking if "Play" was pressed before clicking on the card
				if (Count < 1) {
					JOptionPane.showMessageDialog(null, "You must click in the \"Play\" button first");
					return;
				}
				
				// Checking if card is already guessed right
				if (confirm[10] == 1) {
					JOptionPane.showMessageDialog(null, "Card already guessed right");
					return;
				}
				
				// Checking if two cards were already pressed
				count++;
				if (count > 2) {
					JOptionPane.showMessageDialog(null,
							"You already selected 2 buttons, please click on the \"Guess Again\" button");
					count = 2;
					return;
				}
				
				// Displaying the card that the user button is holding
				int num = Integer.parseInt(cards.get(10));
				String temp = Integer.toString(num);
				if (temp.equals("1")) {
					Card11.setIcon(aipom);
				} else if (temp.equals("2")) {
					Card11.setIcon(ambipom);
				} else if (temp.equals("3")) {
					Card11.setIcon(riolu);
				} else if (temp.equals("4")) {
					Card11.setIcon(lucario);
				} else if (temp.equals("5")) {
					Card11.setIcon(pikachu);
				} else if (temp.equals("6")) {
					Card11.setIcon(raichu);
				} else if (temp.equals("7")) {
					Card11.setIcon(chansey);
				} else if (temp.equals("8")) {
					Card11.setIcon(blissey);
				} else if (temp.equals("9")) {
					Card11.setIcon(magikarp);
				} else if (temp.equals("10")) {
					Card11.setIcon(gyarados);
				} else if (temp.equals("11")) {
					Card11.setIcon(growlithe);
				} else if (temp.equals("12")) {
					Card11.setIcon(arcanine);
				} else if (temp.equals("13")) {
					Card11.setIcon(bronzor);
				} else if (temp.equals("14")) {
					Card11.setIcon(bronzong);
				} else if (temp.equals("15")) {
					Card11.setIcon(misdreavus);
				} else if (temp.equals("16")) {
					Card11.setIcon(mismagius);
				} else if (temp.equals("17")){ 
					Card11.setIcon(buizel); 
				} else if (temp.equals("18")){ 
					Card11.setIcon(floatzel); 
				} else if (temp.equals("19")){ 
					Card11.setIcon(rattata);
				} else if (temp.equals("20")){ 
					Card11.setIcon(raticate); 
				}
				
				// Holding the number on the change array to see if there is a match
				change.set(10, Integer.parseInt(temp));
			}

		});
		
		Card11.setIcon(new ImageIcon(MatchingGame.class.getResource("/images/PokeBall-icon.png")));
		// Availability:
		// https://icons.iconarchive.com/icons/draseart/dumper/128/PokeBall-icon.png
		
		Card11.setBounds(350, 339, 144, 105);
		contentPane.add(Card11);
		
		// Creating the card 12
		JButton Card12 = new JButton("");
		

		/**
		 * Creating an mouseClicked event to display the picture
		 * when the user click on the button.
		 */
		Card12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// Checking if "Play" was pressed before clicking on the card
				if (Count < 1) {
					JOptionPane.showMessageDialog(null, "You must click in the \"Play\" button first");
					return;
				}
				
				// Checking if card is already guessed right
				if (confirm[11] == 1) {
					JOptionPane.showMessageDialog(null, "Card already guessed right");
					return;
				}
				
				// Checking if two cards were already pressed
				count++;
				if (count > 2) {
					JOptionPane.showMessageDialog(null,
							"You already selected 2 buttons, please click on the \"Guess Again\" button");
					count = 2;
					return;
				}
				
				// Displaying the card that the user button is holding
				int num = Integer.parseInt(cards.get(11));
				String temp = Integer.toString(num);
				if (temp.equals("1")) {
					Card12.setIcon(aipom);
				} else if (temp.equals("2")) {
					Card12.setIcon(ambipom);
				} else if (temp.equals("3")) {
					Card12.setIcon(riolu);
				} else if (temp.equals("4")) {
					Card12.setIcon(lucario);
				} else if (temp.equals("5")) {
					Card12.setIcon(pikachu);
				} else if (temp.equals("6")) {
					Card12.setIcon(raichu);
				} else if (temp.equals("7")) {
					Card12.setIcon(chansey);
				} else if (temp.equals("8")) {
					Card12.setIcon(blissey);
				} else if (temp.equals("9")) {
					Card12.setIcon(magikarp);
				} else if (temp.equals("10")) {
					Card12.setIcon(gyarados);
				} else if (temp.equals("11")) {
					Card12.setIcon(growlithe);
				} else if (temp.equals("12")) {
					Card12.setIcon(arcanine);
				} else if (temp.equals("13")) {
					Card12.setIcon(bronzor);
				} else if (temp.equals("14")) {
					Card12.setIcon(bronzong);
				} else if (temp.equals("15")) {
					Card12.setIcon(misdreavus);
				} else if (temp.equals("16")) {
					Card12.setIcon(mismagius);
				} else if (temp.equals("17")){ 
					Card12.setIcon(buizel); 
				} else if (temp.equals("18")){ 
					Card12.setIcon(floatzel); 
				} else if (temp.equals("19")){ 
					Card12.setIcon(rattata);
				} else if (temp.equals("20")){ 
					Card12.setIcon(raticate); 
				}

				// Holding the number on the change array to see if there is a match
				change.set(11, Integer.parseInt(temp));
			}
		});
		
		Card12.setIcon(new ImageIcon(MatchingGame.class.getResource("/images/PokeBall-icon.png")));
		// Availability:
		// https://icons.iconarchive.com/icons/draseart/dumper/128/PokeBall-icon.png
		
		Card12.setBounds(350, 455, 144, 105);
		contentPane.add(Card12);
		
		// Creating the card 13
		JButton Card13 = new JButton("");
		
		/**
		 * Creating an mouseClicked event to display the picture
		 * when the user click on the button.
		 */
		Card13.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// Checking if "Play" was pressed before clicking on the card
				if (Count < 1) {
					JOptionPane.showMessageDialog(null, "You must click in the \"Play\" button first");
					return;
				}
				
				// Checking if card is already guessed right
				if (confirm[12] == 1) {
					JOptionPane.showMessageDialog(null, "Card already guessed right");
					return;
				}
				
				// Checking if two cards were already pressed
				count++;
				if (count > 2) {
					JOptionPane.showMessageDialog(null,
							"You already selected 2 buttons, please click on the \"Guess Again\" button");
					count = 2;
					return;
				}
				
				// Displaying the card that the user button is holding
				int num = Integer.parseInt(cards.get(12));
				String temp = Integer.toString(num);
				if (temp.equals("1")) {
					Card13.setIcon(aipom);
				} else if (temp.equals("2")) {
					Card13.setIcon(ambipom);
				} else if (temp.equals("3")) {
					Card13.setIcon(riolu);
				} else if (temp.equals("4")) {
					Card13.setIcon(lucario);
				} else if (temp.equals("5")) {
					Card13.setIcon(pikachu);
				} else if (temp.equals("6")) {
					Card13.setIcon(raichu);
				} else if (temp.equals("7")) {
					Card13.setIcon(chansey);
				} else if (temp.equals("8")) {
					Card13.setIcon(blissey);
				} else if (temp.equals("9")) {
					Card13.setIcon(magikarp);
				} else if (temp.equals("10")) {
					Card13.setIcon(gyarados);
				} else if (temp.equals("11")) {
					Card13.setIcon(growlithe);
				} else if (temp.equals("12")) {
					Card13.setIcon(arcanine);
				} else if (temp.equals("13")) {
					Card13.setIcon(bronzor);
				} else if (temp.equals("14")) {
					Card13.setIcon(bronzong);
				} else if (temp.equals("15")) {
					Card13.setIcon(misdreavus);
				} else if (temp.equals("16")) {
					Card13.setIcon(mismagius);
				} else if (temp.equals("17")){ 
					Card13.setIcon(buizel); 
				} else if (temp.equals("18")){ 
					Card13.setIcon(floatzel); 
				} else if (temp.equals("19")){ 
					Card13.setIcon(rattata);
				} else if (temp.equals("20")){ 
					Card13.setIcon(raticate); 
				}

				// Holding the number on the change array to see if there is a match
				change.set(12, Integer.parseInt(temp));
			}
		});
		
		Card13.setIcon(new ImageIcon(MatchingGame.class.getResource("/images/PokeBall-icon.png")));
		// Availability:
		// https://icons.iconarchive.com/icons/draseart/dumper/128/PokeBall-icon.png
		
		Card13.setBounds(515, 99, 144, 106);
		contentPane.add(Card13);
		
		// Creating the card 14
		JButton Card14 = new JButton("");
		
		/**
		 * Creating an mouseClicked event to display the picture
		 * when the user click on the button.
		 */
		Card14.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// Checking if "Play" was pressed before clicking on the card
				if (Count < 1) {
					JOptionPane.showMessageDialog(null, "You must click in the \"Play\" button first");
					return;
				}
				
				// Checking if card is already guessed right
				if (confirm[13] == 1) {
					JOptionPane.showMessageDialog(null, "Card already guessed right");
					return;
				}
				
				// Checking if two cards were already pressed
				count++;
				if (count > 2) {
					JOptionPane.showMessageDialog(null,
							"You already selected 2 buttons, please click on the \"Guess Again\" button");
					count = 2;
					return;
				}
				
				// Displaying the card that the user button is holding
				int num = Integer.parseInt(cards.get(13));
				String temp = Integer.toString(num);
				if (temp.equals("1")) {
					Card14.setIcon(aipom);
				} else if (temp.equals("2")) {
					Card14.setIcon(ambipom);
				} else if (temp.equals("3")) {
					Card14.setIcon(riolu);
				} else if (temp.equals("4")) {
					Card14.setIcon(lucario);
				} else if (temp.equals("5")) {
					Card14.setIcon(pikachu);
				} else if (temp.equals("6")) {
					Card14.setIcon(raichu);
				} else if (temp.equals("7")) {
					Card14.setIcon(chansey);
				} else if (temp.equals("8")) {
					Card14.setIcon(blissey);
				} else if (temp.equals("9")) {
					Card14.setIcon(magikarp);
				} else if (temp.equals("10")) {
					Card14.setIcon(gyarados);
				} else if (temp.equals("11")) {
					Card14.setIcon(growlithe);
				} else if (temp.equals("12")) {
					Card14.setIcon(arcanine);
				} else if (temp.equals("13")) {
					Card14.setIcon(bronzor);
				} else if (temp.equals("14")) {
					Card14.setIcon(bronzong);
				} else if (temp.equals("15")) {
					Card14.setIcon(misdreavus);
				} else if (temp.equals("16")) {
					Card14.setIcon(mismagius);
				} else if (temp.equals("17")){ 
					Card14.setIcon(buizel); 
				} else if (temp.equals("18")){ 
					Card14.setIcon(floatzel); 
				} else if (temp.equals("19")){ 
					Card14.setIcon(rattata);
				} else if (temp.equals("20")){ 
					Card14.setIcon(raticate); 
				}
				
				// Holding the number on the change array to see if there is a match
				change.set(13, Integer.parseInt(temp));
			}
		});
		
		Card14.setIcon(new ImageIcon(MatchingGame.class.getResource("/images/PokeBall-icon.png")));
		// Availability:
		// https://icons.iconarchive.com/icons/draseart/dumper/128/PokeBall-icon.png
		
		Card14.setBounds(515, 216, 144, 112);
		contentPane.add(Card14);
		
		// Creating the card 15
		JButton Card15 = new JButton("");
		
		/**
		 * Creating an mouseClicked event to display the picture
		 * when the user click on the button.
		 */
		Card15.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// Checking if "Play" was pressed before clicking on the card
				if (Count < 1) {
					JOptionPane.showMessageDialog(null, "You must click in the \"Play\" button first");
					return;
				}
				
				// Checking if card is already guessed right
				if (confirm[14] == 1) {
					JOptionPane.showMessageDialog(null, "Card already guessed right");
					return;
				}
				
				// Checking if two cards were already pressed
				count++;
				if (count > 2) {
					JOptionPane.showMessageDialog(null,
							"You already selected 2 buttons, please click on the \"Guess Again\" button");
					count = 2;
					return;
				}
				
				// Displaying the card that the user button is holding
				int num = Integer.parseInt(cards.get(14));
				String temp = Integer.toString(num);
				if (temp.equals("1")) {
					Card15.setIcon(aipom);
				} else if (temp.equals("2")) {
					Card15.setIcon(ambipom);
				} else if (temp.equals("3")) {
					Card15.setIcon(riolu);
				} else if (temp.equals("4")) {
					Card15.setIcon(lucario);
				} else if (temp.equals("5")) {
					Card15.setIcon(pikachu);
				} else if (temp.equals("6")) {
					Card15.setIcon(raichu);
				} else if (temp.equals("7")) {
					Card15.setIcon(chansey);
				} else if (temp.equals("8")) {
					Card15.setIcon(blissey);
				} else if (temp.equals("9")) {
					Card15.setIcon(magikarp);
				} else if (temp.equals("10")) {
					Card15.setIcon(gyarados);
				} else if (temp.equals("11")) {
					Card15.setIcon(growlithe);
				} else if (temp.equals("12")) {
					Card15.setIcon(arcanine);
				} else if (temp.equals("13")) {
					Card15.setIcon(bronzor);
				} else if (temp.equals("14")) {
					Card15.setIcon(bronzong);
				} else if (temp.equals("15")) {
					Card15.setIcon(misdreavus);
				} else if (temp.equals("16")) {
					Card15.setIcon(mismagius);
				} else if (temp.equals("17")){ 
					Card15.setIcon(buizel); 
				} else if (temp.equals("18")){ 
					Card15.setIcon(floatzel); 
				} else if (temp.equals("19")){ 
					Card15.setIcon(rattata);
				} else if (temp.equals("20")){ 
					Card15.setIcon(raticate); 
				}

				// Holding the number on the change array to see if there is a match
				change.set(14, Integer.parseInt(temp));
			}
		});
		
		Card15.setIcon(new ImageIcon(MatchingGame.class.getResource("/images/PokeBall-icon.png")));
		// Availability:
		// https://icons.iconarchive.com/icons/draseart/dumper/128/PokeBall-icon.png
		
		Card15.setBounds(515, 339, 144, 105);
		contentPane.add(Card15);
		
		// Creating the card 16
		JButton Card16 = new JButton("");
		
		/**
		 * Creating an mouseClicked event to display the picture
		 * when the user click on the button.
		 */
		Card16.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// Checking if "Play" was pressed before clicking on the card
				if (Count < 1) {
					JOptionPane.showMessageDialog(null, "You must click in the \"Play\" button first");
					return;
				}
				
				// Checking if card is already guessed right
				if (confirm[15] == 1) {
					JOptionPane.showMessageDialog(null, "Card already guessed right");
					return;
				}
				
				// Checking if two cards were already pressed
				count++;
				if (count > 2) {
					JOptionPane.showMessageDialog(null,
							"You already selected 2 buttons, please click on the \"Guess Again\" button");
					count = 2;
					return;
				}
				
				// Displaying the card that the user button is holding
				int num = Integer.parseInt(cards.get(15));
				String temp = Integer.toString(num);
				if (temp.equals("1")) {
					Card16.setIcon(aipom);
				} else if (temp.equals("2")) {
					Card16.setIcon(ambipom);
				} else if (temp.equals("3")) {
					Card16.setIcon(riolu);
				} else if (temp.equals("4")) {
					Card16.setIcon(lucario);
				} else if (temp.equals("5")) {
					Card16.setIcon(pikachu);
				} else if (temp.equals("6")) {
					Card16.setIcon(raichu);
				} else if (temp.equals("7")) {
					Card16.setIcon(chansey);
				} else if (temp.equals("8")) {
					Card16.setIcon(blissey);
				} else if (temp.equals("9")) {
					Card16.setIcon(magikarp);
				} else if (temp.equals("10")) {
					Card16.setIcon(gyarados);
				} else if (temp.equals("11")) {
					Card16.setIcon(growlithe);
				} else if (temp.equals("12")) {
					Card16.setIcon(arcanine);
				} else if (temp.equals("13")) {
					Card16.setIcon(bronzor);
				} else if (temp.equals("14")) {
					Card16.setIcon(bronzong);
				} else if (temp.equals("15")) {
					Card16.setIcon(misdreavus);
				} else if (temp.equals("16")) {
					Card16.setIcon(mismagius);
				} else if (temp.equals("17")){ 
					Card16.setIcon(buizel); 
				} else if (temp.equals("18")){ 
					Card16.setIcon(floatzel); 
				} else if (temp.equals("19")){ 
					Card16.setIcon(rattata);
				} else if (temp.equals("20")){ 
					Card16.setIcon(raticate); 
				}
				
				// Holding the number on the change array to see if there is a match
				change.set(15, Integer.parseInt(temp));

			}
		});
		
		Card16.setIcon(new ImageIcon(MatchingGame.class.getResource("/images/PokeBall-icon.png")));
		// Availability:
		// https://icons.iconarchive.com/icons/draseart/dumper/128/PokeBall-icon.png
		
		Card16.setBounds(515, 455, 144, 105);
		contentPane.add(Card16);
		
		// Creating the card 17
		JButton Card17 = new JButton("");
		
		/**
		 * Creating an mouseClicked event to display the picture
		 * when the user click on the button.
		 */
		Card17.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// Checking if "Play" was pressed before clicking on the card
				if (Count < 1) {
					JOptionPane.showMessageDialog(null, "You must click in the \"Play\" button first");
					return;
				}
				
				// Checking if card is already guessed right
				if (confirm[16] == 1) {
					JOptionPane.showMessageDialog(null, "Card already guessed right");
					return;
				}
				
				// Checking if two cards were already pressed
				count++;
				if (count > 2) {
					JOptionPane.showMessageDialog(null,
							"You already selected 2 buttons, please click on the \"Guess Again\" button");
					count = 2;
					return;
				}
				
				// Displaying the card that the user button is holding
				int num = Integer.parseInt(cards.get(16));
				String temp = Integer.toString(num);
				if (temp.equals("1")) {
					Card17.setIcon(aipom);
				} else if (temp.equals("2")) {
					Card17.setIcon(ambipom);
				} else if (temp.equals("3")) {
					Card17.setIcon(riolu);
				} else if (temp.equals("4")) {
					Card17.setIcon(lucario);
				} else if (temp.equals("5")) {
					Card17.setIcon(pikachu);
				} else if (temp.equals("6")) {
					Card17.setIcon(raichu);
				} else if (temp.equals("7")) {
					Card17.setIcon(chansey);
				} else if (temp.equals("8")) {
					Card17.setIcon(blissey);
				} else if (temp.equals("9")) {
					Card17.setIcon(magikarp);
				} else if (temp.equals("10")) {
					Card17.setIcon(gyarados);
				} else if (temp.equals("11")) {
					Card17.setIcon(growlithe);
				} else if (temp.equals("12")) {
					Card17.setIcon(arcanine);
				} else if (temp.equals("13")) {
					Card17.setIcon(bronzor);
				} else if (temp.equals("14")) {
					Card17.setIcon(bronzong);
				} else if (temp.equals("15")) {
					Card17.setIcon(misdreavus);
				} else if (temp.equals("16")) {
					Card17.setIcon(mismagius);
				} else if (temp.equals("17")){ 
					Card17.setIcon(buizel); 
				} else if (temp.equals("18")){ 
					Card17.setIcon(floatzel); 
				} else if (temp.equals("19")){ 
					Card17.setIcon(rattata);
				} else if (temp.equals("20")){ 
					Card17.setIcon(raticate); 
				}
				
				// Holding the number on the change array to see if there is a match
				change.set(16, Integer.parseInt(temp));

			}
		});
		
		Card17.setIcon(new ImageIcon(MatchingGame.class.getResource("/images/PokeBall-icon.png")));
		// Availability:		
		// https://icons.iconarchive.com/icons/draseart/dumper/128/PokeBall-icon.png
				
		Card17.setBounds(677, 100, 143, 105);
		contentPane.add(Card17);
				
		// Creating the card 18
		JButton Card18 = new JButton("");
		/**
		 * Creating an mouseClicked event to display the picture
		 * when the user click on the button.
		 */
		Card18.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// Checking if "Play" was pressed before clicking on the card
				if (Count < 1) {
					JOptionPane.showMessageDialog(null, "You must click in the \"Play\" button first");
					return;
				}
				
				// Checking if card is already guessed right
				if (confirm[17] == 1) {
					JOptionPane.showMessageDialog(null, "Card already guessed right");
					return;
				}
				
				// Checking if two cards were already pressed
				count++;
				if (count > 2) {
					JOptionPane.showMessageDialog(null,
							"You already selected 2 buttons, please click on the \"Guess Again\" button");
					count = 2;
					return;
				}
				
				// Displaying the card that the user button is holding
				int num = Integer.parseInt(cards.get(17));
				String temp = Integer.toString(num);
				if (temp.equals("1")) {
					Card18.setIcon(aipom);
				} else if (temp.equals("2")) {
					Card18.setIcon(ambipom);
				} else if (temp.equals("3")) {
					Card18.setIcon(riolu);
				} else if (temp.equals("4")) {
					Card18.setIcon(lucario);
				} else if (temp.equals("5")) {
					Card18.setIcon(pikachu);
				} else if (temp.equals("6")) {
					Card18.setIcon(raichu);
				} else if (temp.equals("7")) {
					Card18.setIcon(chansey);
				} else if (temp.equals("8")) {
					Card18.setIcon(blissey);
				} else if (temp.equals("9")) {
					Card18.setIcon(magikarp);
				} else if (temp.equals("10")) {
					Card18.setIcon(gyarados);
				} else if (temp.equals("11")) {
					Card18.setIcon(growlithe);
				} else if (temp.equals("12")) {
					Card18.setIcon(arcanine);
				} else if (temp.equals("13")) {
					Card18.setIcon(bronzor);
				} else if (temp.equals("14")) {
					Card18.setIcon(bronzong);
				} else if (temp.equals("15")) {
					Card18.setIcon(misdreavus);
				} else if (temp.equals("16")) {
					Card18.setIcon(mismagius);
				} else if (temp.equals("17")){ 
					Card18.setIcon(buizel); 
				} else if (temp.equals("18")){ 
					Card18.setIcon(floatzel); 
				} else if (temp.equals("19")){ 
					Card18.setIcon(rattata);
				} else if (temp.equals("20")){ 
					Card18.setIcon(raticate); 
				}
				
				// Holding the number on the change array to see if there is a match
				change.set(17, Integer.parseInt(temp));

			}
		});
				
		Card18.setIcon(new ImageIcon(MatchingGame.class.getResource("/images/PokeBall-icon.png")));
		// Availability:
		// https://icons.iconarchive.com/icons/draseart/dumper/128/PokeBall-icon.png
				
		Card18.setBounds(677, 216, 143, 112);
		contentPane.add(Card18);
				
		// Creating the card 19
		JButton Card19 = new JButton("");
		/**
		 * Creating an mouseClicked event to display the picture
		 * when the user click on the button.
		 */
		Card19.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// Checking if "Play" was pressed before clicking on the card
				if (Count < 1) {
					JOptionPane.showMessageDialog(null, "You must click in the \"Play\" button first");
					return;
				}
				
				// Checking if card is already guessed right
				if (confirm[18] == 1) {
					JOptionPane.showMessageDialog(null, "Card already guessed right");
					return;
				}
				
				// Checking if two cards were already pressed
				count++;
				if (count > 2) {
					JOptionPane.showMessageDialog(null,
							"You already selected 2 buttons, please click on the \"Guess Again\" button");
					count = 2;
					return;
				}
				
				// Displaying the card that the user button is holding
				int num = Integer.parseInt(cards.get(18));
				String temp = Integer.toString(num);
				if (temp.equals("1")) {
					Card19.setIcon(aipom);
				} else if (temp.equals("2")) {
					Card19.setIcon(ambipom);
				} else if (temp.equals("3")) {
					Card19.setIcon(riolu);
				} else if (temp.equals("4")) {
					Card19.setIcon(lucario);
				} else if (temp.equals("5")) {
					Card19.setIcon(pikachu);
				} else if (temp.equals("6")) {
					Card19.setIcon(raichu);
				} else if (temp.equals("7")) {
					Card19.setIcon(chansey);
				} else if (temp.equals("8")) {
					Card19.setIcon(blissey);
				} else if (temp.equals("9")) {
					Card19.setIcon(magikarp);
				} else if (temp.equals("10")) {
					Card19.setIcon(gyarados);
				} else if (temp.equals("11")) {
					Card19.setIcon(growlithe);
				} else if (temp.equals("12")) {
					Card19.setIcon(arcanine);
				} else if (temp.equals("13")) {
					Card19.setIcon(bronzor);
				} else if (temp.equals("14")) {
					Card19.setIcon(bronzong);
				} else if (temp.equals("15")) {
					Card19.setIcon(misdreavus);
				} else if (temp.equals("16")) {
					Card19.setIcon(mismagius);
				} else if (temp.equals("17")){ 
					Card19.setIcon(buizel); 
				} else if (temp.equals("18")){ 
					Card19.setIcon(floatzel); 
				} else if (temp.equals("19")){ 
					Card19.setIcon(rattata);
				} else if (temp.equals("20")){ 
					Card19.setIcon(raticate); 
				}
				
				// Holding the number on the change array to see if there is a match
				change.set(18, Integer.parseInt(temp));

			}
		});
				
		Card19.setIcon(new ImageIcon(MatchingGame.class.getResource("/images/PokeBall-icon.png")));
	    // Availability:
		// https://icons.iconarchive.com/icons/draseart/dumper/128/PokeBall-icon.png
			
		Card19.setBounds(677, 339, 143, 105);
		contentPane.add(Card19);
				
		// Creating the card 20
		JButton Card20 = new JButton("");
		/**
		 * Creating an mouseClicked event to display the picture
		 * when the user click on the button.
		 */
		Card20.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// Checking if "Play" was pressed before clicking on the card
				if (Count < 1) {
					JOptionPane.showMessageDialog(null, "You must click in the \"Play\" button first");
					return;
				}
				
				// Checking if card is already guessed right
				if (confirm[19] == 1) {
					JOptionPane.showMessageDialog(null, "Card already guessed right");
					return;
				}
				
				// Checking if two cards were already pressed
				count++;
				if (count > 2) {
					JOptionPane.showMessageDialog(null,
							"You already selected 2 buttons, please click on the \"Guess Again\" button");
					count = 2;
					return;
				}
				
				// Displaying the card that the user button is holding
				int num = Integer.parseInt(cards.get(19));
				String temp = Integer.toString(num);
				if (temp.equals("1")) {
					Card20.setIcon(aipom);
				} else if (temp.equals("2")) {
					Card20.setIcon(ambipom);
				} else if (temp.equals("3")) {
					Card20.setIcon(riolu);
				} else if (temp.equals("4")) {
					Card20.setIcon(lucario);
				} else if (temp.equals("5")) {
					Card20.setIcon(pikachu);
				} else if (temp.equals("6")) {
					Card20.setIcon(raichu);
				} else if (temp.equals("7")) {
					Card20.setIcon(chansey);
				} else if (temp.equals("8")) {
					Card20.setIcon(blissey);
				} else if (temp.equals("9")) {
					Card20.setIcon(magikarp);
				} else if (temp.equals("10")) {
					Card20.setIcon(gyarados);
				} else if (temp.equals("11")) {
					Card20.setIcon(growlithe);
				} else if (temp.equals("12")) {
					Card20.setIcon(arcanine);
				} else if (temp.equals("13")) {
					Card20.setIcon(bronzor);
				} else if (temp.equals("14")) {
					Card20.setIcon(bronzong);
				} else if (temp.equals("15")) {
					Card20.setIcon(misdreavus);
				} else if (temp.equals("16")) {
					Card20.setIcon(mismagius);
				} else if (temp.equals("17")){ 
					Card20.setIcon(buizel); 
				} else if (temp.equals("18")){ 
					Card20.setIcon(floatzel); 
				} else if (temp.equals("19")){ 
					Card20.setIcon(rattata);
				} else if (temp.equals("20")){ 
					Card20.setIcon(raticate); 
				}
				
				// Holding the number on the change array to see if there is a match
				change.set(19, Integer.parseInt(temp));

			}
		});
				
		Card20.setIcon(new ImageIcon(MatchingGame.class.getResource("/images/PokeBall-icon.png")));
		// Availability:
		// https://icons.iconarchive.com/icons/draseart/dumper/128/PokeBall-icon.png
				
		Card20.setBounds(677, 455, 143, 105);
		contentPane.add(Card20);
				
		// Creating the button play
		JButton Play = new JButton("Play");
		
		/** 
		 * This action listener will set up the randomized numbers and the array to hold the number selected by the user
		 */
		Play.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// Checking if the user pressed the Play button only one time
				if (Count >= 1) {
					JOptionPane.showMessageDialog(null, "You are already playing the game");
					return;
				}
				
				String temp;
				
				// Setting up the array to store the randomized number that the user will choose
				for (int c = 0; c <= 21; c++) {
					change.add(0);
				}
		
				// Adding the number 1 to 16 to array set
				for (int c = 1; c <= 20; c++) {
					temp = Integer.toString(c);
					set.add(temp);

				}
				
				// Randomizing the order of the set array and storing the randomized numbers in the card array  
				for (int x = 1 ; x <= 20; x++) {
					double index = Math.floor(Math.random() * (21- x));
					int index1 = (int) index;
					cards.add(set.get(index1));
					set.remove(set.get(index1));

				}
				Count++;
			}
		});
		Play.setBounds(52, 582, 68, 23);
		contentPane.add(Play);
		
		//Creating the guess button
		JButton GuessAgain = new JButton("Guess Again");
		
		/**
		 * Checking if the there is a evolution pair with the cards and if have, the
		 * cards will show "done", else the card will turn to back
		 */
		GuessAgain.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (count == 2) {					
					if (change.get(0) != 0) {
						int index = change.get(0);
						int index1 = index + 1;
						int index2 = index - 1;
						int indexRest = index % 2;
						for (int c = 0; c <= 21; c++) {

							if (indexRest == 0 && change.get(c) == index2 || indexRest == 1 && change.get(c) == index1) {
								Card1.setIcon(done);
								confirm[0] = 1;
								cardsLeft--;
								break;
								
							} else {
								Card1.setIcon(back);

							}
						}
					}					
					if (change.get(1) != 0) {
						int index = change.get(1);
						int indexRest = index % 2;
						int index1 = index + 1;
						int index2 = index - 1;
						for (int c = 0; c <= 21; c++) {
							if (indexRest == 0 && change.get(c) == index2 || indexRest == 1 && change.get(c) == index1) {
								Card2.setIcon(done);
								confirm[1] = 1;
								cardsLeft--;
								break;
							} else {
								Card2.setIcon(back);
							}
						}

					}
					if (change.get(2) != 0) {
						int index = change.get(2);
						int indexRest = index % 2;
						int index2 = index - 1;
						int index1 = index + 1;
						for (int c = 0; c <= 21; c++) {
							if (indexRest == 0 && change.get(c) == index2 || indexRest == 1 && change.get(c) == index1) {
								Card3.setIcon(done);
								confirm[2] = 1;
								cardsLeft--;
								break;
							} else {
								Card3.setIcon(back);
							}
						}
					}					
					if (change.get(3) != 0) {
						int index = change.get(3);
						int index1 = index + 1;
						int index2 = index - 1;
						int indexRest = index % 2;
						for (int c = 1; c <= 20; c++) {
							if (indexRest == 0 && change.get(c) == index2 || indexRest == 1 && change.get(c) == index1) {
								Card4.setIcon(done);
								confirm[3] = 1;
								cardsLeft--;
								break;
							} else {
								Card4.setIcon(back);
							}
						}
					}					
					if (change.get(4) != 0) {
						int index = change.get(4);
						int index1 = index + 1;
						int index2 = index - 1;
						int indexRest = index % 2;
						for (int c = 0; c <= 21; c++) {
							if (indexRest == 0 && change.get(c) == index2 || indexRest == 1 && change.get(c) == index1) {
								Card5.setIcon(done);
								confirm[4] = 1;
								cardsLeft--;
								break;
							} else {
								Card5.setIcon(back);
							}
						}
					}					
					if (change.get(5) != 0) {
						int index = change.get(5);
						int index1 = index + 1;
						int index2 = index - 1;
						int indexRest = index % 2;
						for (int c = 0; c <= 21; c++) {
							if (indexRest == 0 && change.get(c) == index2 || indexRest == 1 && change.get(c) == index1) {
								Card6.setIcon(done);
								confirm[5] = 1;
								cardsLeft--;
								break;
							} else {
								Card6.setIcon(back);
							}
						}
					}					
					if (change.get(6) != 0) {
						int index = change.get(6);
						int index1 = index + 1;
						int index2 = index - 1;
						int indexRest = index % 2;
						for (int c = 0; c <= 21; c++) {
							if (indexRest == 0 && change.get(c) == index2 || indexRest == 1 && change.get(c) == index1) {
								Card7.setIcon(done);
								confirm[6] = 1;
								cardsLeft--;
								break;
							} else {
								Card7.setIcon(back);
							}
						}
					}					
					if (change.get(7) != 0) {
						int index = change.get(7);
						int index1 = index + 1;
						int index2 = index - 1;
						int indexRest = index % 2;
						for (int c = 0; c <= 21; c++) {
							if (indexRest == 0 && change.get(c) == index2
									|| indexRest == 1 && change.get(c) == index1) {
								Card8.setIcon(done);
								confirm[7] = 1;
								cardsLeft--;
								break;
							} else {
								Card8.setIcon(back);
							}
						}
					}					
					if (change.get(8) != 0) {
						int index = change.get(8);
						int index1 = index + 1;
						int index2 = index - 1;
						int indexRest = index % 2;
						for (int c = 0; c <= 21; c++) {
							if (indexRest == 0 && change.get(c) == index2 || indexRest == 1 && change.get(c) == index1) {
								Card9.setIcon(done);
								confirm[8] = 1;
								cardsLeft--;
								break;
							} else {
								Card9.setIcon(back);
							}
						}
					}					
					if (change.get(9) != 0) {
						int index = change.get(9);
						int index1 = index + 1;
						int index2 = index - 1;
						int indexRest = index % 2;
						for (int c = 0; c <= 21; c++) {
							if (indexRest == 0 && change.get(c) == index2 || indexRest == 1 && change.get(c) == index1) {
								Card10.setIcon(done);
								confirm[9] = 1;
								cardsLeft--;
								break;
							} else {
								Card10.setIcon(back);
							}
						}
					}					
					if (change.get(10) != 0) {
						int index = change.get(10);
						int index1 = index + 1;
						int index2 = index - 1;
						int indexRest = index % 2;
						for (int c = 0; c <= 21; c++) {
							if (indexRest == 0 && change.get(c) == index2 || indexRest == 1 && change.get(c) == index1) {
								Card11.setIcon(done);
								cardsLeft--;
								confirm[10] = 1;
								break;
							} else {
								Card11.setIcon(back);
							}
						}
					}					
					if (change.get(11) != 0) {
						int index = change.get(11);
						int index1 = index + 1;
						int index2 = index - 1;
						int indexRest = index % 2;
						for (int c = 0; c <= 21; c++) {
							if (indexRest == 0 && change.get(c) == index2 || indexRest == 1 && change.get(c) == index1) {
								Card12.setIcon(done);
								confirm[11] = 1;
								cardsLeft--;
								break;
							} else {
								Card12.setIcon(back);
							}
						}
					}				
					if (change.get(12) != 0) {
						int index = change.get(12);
						int index1 = index + 1;
						int index2 = index - 1;
						int indexRest = index % 2;
						for (int c = 0; c <= 21; c++) {
							if (indexRest == 0 && change.get(c) == index2 || indexRest == 1 && change.get(c) == index1) {
								Card13.setIcon(done);
								confirm[12] = 1;
								cardsLeft--;
								break;
							} else {
								Card13.setIcon(back);
							}
						}
					}		
					if (change.get(13) != 0) {
						int index = change.get(13);
						int index1 = index + 1;
						int index2 = index - 1;
						int indexRest = index % 2;
						for (int c = 0; c <= 21; c++) {
							if (indexRest == 0 && change.get(c) == index2 || indexRest == 1 && change.get(c) == index1) {
								Card14.setIcon(done);
								cardsLeft--;
								confirm[13] = 1;
								break;
							} else {
								Card14.setIcon(back);
							}
						}
					}
					if (change.get(14) != 0) {
						int index = change.get(14);
						int index1 = index + 1;
						int index2 = index - 1;
						int indexRest = index % 2;
						for (int c = 0; c <= 21; c++) {
							if (indexRest == 0 && change.get(c) == index2 || indexRest == 1 && change.get(c) == index1) {
								Card15.setIcon(done);
								confirm[14] = 1;
								cardsLeft--;
								break;
							} else {
								Card15.setIcon(back);
							}
						}
					}
					if (change.get(15) != 0) {
						int index = change.get(15);
						int index1 = index + 1;
						int index2 = index - 1;
						int indexRest = index % 2;
						for (int c = 0; c <= 21; c++) {
							if (indexRest == 0 && change.get(c) == index2	|| indexRest == 1 && change.get(c) == index1) {
								Card16.setIcon(done);
								confirm[15] = 1;
								cardsLeft--;
								break;
							} else {
								Card16.setIcon(back);
							}
						}
					}
					if (change.get(16) != 0) {
						int index = change.get(16);
						int index1 = index + 1;
						int index2 = index - 1;
						int indexRest = index % 2;
						for (int c = 0; c <= 21; c++) {
							if (indexRest == 0 && change.get(c) == index2 || indexRest == 1 && change.get(c) == index1) {
								Card17.setIcon(done);
								confirm[16] = 1;
								cardsLeft--;
								break;
							} else {
								Card17.setIcon(back);

							}
						}
					}
					if (change.get(17) != 0) {
						int index = change.get(17);
						int index1 = index + 1;
						int index2 = index - 1;
						int indexRest = index % 2;
						for (int c = 0; c <= 21; c++) {

							if (indexRest == 0 && change.get(c) == index2 || indexRest == 1 && change.get(c) == index1) {
								Card18.setIcon(done);
								confirm[17] = 1;
								cardsLeft--;
								break;
							} else {
								Card18.setIcon(back);

							}
						}
					}
					if (change.get(18) != 0) {
						int index = change.get(18);
						int index1 = index + 1;
						int index2 = index - 1;
						int indexRest = index % 2;
						for (int c = 0; c <= 21; c++) {

							if (indexRest == 0 && change.get(c) == index2 || indexRest == 1 && change.get(c) == index1) {
								Card19.setIcon(done);
								confirm[18] = 1;
								cardsLeft--;
								break;
							} else {
								Card19.setIcon(back);

							}
						}
					}
					if (change.get(19) != 0) {
						int index = change.get(19);
						int index1 = index + 1;
						int index2 = index - 1;
						int indexRest = index % 2;
						for (int c = 0; c <= 21; c++) {

							if (indexRest == 0 && change.get(c) == index2 || indexRest == 1 && change.get(c) == index1) {
								Card20.setIcon(done);
								cardsLeft--;
								confirm[19] = 1;
								break;
							} else {
								Card20.setIcon(back);
							}
						}
	
					}							
					// Checking if more than one button was checked 
					} else if (count < 2) {
						JOptionPane.showMessageDialog(null, "Please, select one more card");
						count = 1;
						return;
					}
					change.clear();
					for (int c = 0; c <= 21; c++) {
						change.add(c, 0);
					}
					count = 0;
					if (cardsLeft == 0) {
						Instructions.setText("Congratulations");
					}
				}
		});
	
		//Creating the exit button
		GuessAgain.setBounds(181, 582, 111, 23);
		contentPane.add(GuessAgain);
		JButton Exit = new JButton("Exit");
		Exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		Exit.setBounds(539, 582, 61, 23);
		contentPane.add(Exit);
		
		// Creating the text field to hold the instructions
		Instructions = new JTextField();
		Instructions.setBackground(Color.WHITE);
		Instructions.setText("    Click the Play button to start. Make sure to click Guess Again after each guess.");
		Instructions.setEditable(false);
		Instructions.setBounds(411, 630, 451, 20);
		contentPane.add(Instructions);
		Instructions.setColumns(10);
	}
}
