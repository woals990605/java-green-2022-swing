package site.metacoding.bubble.test;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BubbleFrame extends JFrame{
	
	private JLabel backgroundMap;
	private Player player;
	
	public BubbleFrame() {
		initObject();
		initSetting();
		initListener();
		
		setVisible(true);
	}
	
	private void initObject() {
		backgroundMap = new JLabel(new ImageIcon("image/backgroundMap.png"));
		setContentPane(backgroundMap);// 백그라운드 사진 추가
	
		player = new Player();
		add(player);
	}
	
	private void initSetting() {
		setSize(1000,640);
		getContentPane().setLayout(null);//도화지
		setLocationRelativeTo(null);//가운데 배치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
	
	private void initListener() {
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				System.out.println("키보드 릴리즈");
				
				if(e.getKeyCode()== KeyEvent.VK_RIGHT) {
					player.setRight(false);
				}else if (e.getKeyCode()== KeyEvent.VK_LEFT) {
					player.setLeft(false);
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()== KeyEvent.VK_RIGHT) {
					if(player.isRight()==false) {
						player.right();
					}
				}else if(e.getKeyCode()== KeyEvent.VK_LEFT){
					if (player.isLeft()==false) {
						player.left();
					}
				}else if (e.getKeyCode()== KeyEvent.VK_UP) {
					if (player.isJump()==false) {
						player.jump();
					}
				}
				
			}
		});
	}
	public static void main(String[] args) {
		new BubbleFrame();

	}
}
