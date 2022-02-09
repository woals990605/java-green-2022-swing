package site.metacoding.bubble.test;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel {

	private ImageIcon playerR;
	private ImageIcon playerL;
	private int x;
	private int y;
	private boolean isRight;
	private boolean isLeft;
	private boolean isJump;
	 private static final int JUMPSPEED = 2;
	 
	 public void setRight(boolean isRight) {
			this.isRight = isRight;

		}

		public void setLeft(boolean isLeft) {
			this.isLeft = isLeft;
		}
		
		public void setJump(boolean isJump) {
			this.isJump = isJump;
		}

		public boolean isRight() {
			return isRight;
		}

		public boolean isLeft() {
			// TODO Auto-generated method stub
			return isLeft;
		}

		public boolean isJump() {
			// TODO Auto-generated method stub
			return isJump;
		}

	public Player() {
		initObject();
		initSetting();
	}

	private void initObject() {
		playerR = new ImageIcon("image/playerR.png");
		playerL = new ImageIcon("image/playerL.png");
	}

	private void initSetting() {
		x = 70;
		y = 535;
		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y);

		isRight = false;
		isLeft = false;
		isJump= false;
	}

	public void right() {
		isRight = true;
		
		System.out.println("������ �̵�");
		setIcon(playerR);

		new Thread(() -> {
			while (isRight) {
				x = x + 10;
				setLocation(x, y);

				try {
					Thread.sleep(10);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();

	}

	public void left() {
		isLeft=true;
		
		System.out.println("���� �̵�");
		setIcon(playerL);

		new Thread(() -> {
			while (isLeft) {
				x = x - 10;
				setLocation(x, y);

				try {
					Thread.sleep(10);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	public void jump() {
		isJump = true;

		System.out.println("���� ����");
		// ������ for���� ��������
		// up �̶��� sleep(5), down �̶��� sleep(3)
		new Thread(() -> {
			// up
			for (int i = 0; i < 130 / JUMPSPEED; i++) { // JUMPSPEED�� ���� ���̰� �޶����� �ȵ�!
				y = y - JUMPSPEED;
				setLocation(x, y);
				isJump = true; // �������� �ȵ� ! Ű���� �Է��� �ѹ��� �޾ƾ���

				try {
					Thread.sleep(5);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			// down
			for (int i = 0; i < 130 / JUMPSPEED; i++) {
				y = y + JUMPSPEED;
				setLocation(x, y);

				try {
					Thread.sleep(3);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			isJump = false;
		}).start();
	}

	

}
