package site.metacoding.bubble.ex05;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 
 * @author woals �÷��̾�� �¿��̵��� �����ϴ�. ������ �����ϴ�. ��� �߻縦 �Ѵ�.(���߿� ��������) x, y ��ǥ �ʿ�
 *         x��ǥ�� �¿� �̵� y��ǥ�� ����
 *
 */

public class Player extends JLabel {

   private int x;
   private int y;

   private ImageIcon playerR; // �������� �����ִ� pR
   private ImageIcon playerL; // ������ �����ִ� pL

   private boolean isRight; // ���� boolean ���� �̸����� is�� ����
   private boolean isLeft;
   private boolean isJump; // ���� ����(up, down)

   private static final int JUMPSPEED = 2;
   private static final int SPEED = 4;

   public boolean isJump() {
      return isJump;
   }

   public void setJump(boolean isJump) {
      this.isJump = isJump;
   }

   // �ڹ��� Ư¡ : is�� ���� boolean ������ getIsRight�� �ƴ� isRight��� �̸��� ����
   public boolean isRight() {
      return isRight;
   }

   // �ڹ��� Ư¡ : is�� ���� boolean ������ setIsRight�� �ƴ� setRight��� �̸��� ����
   public void setRight(boolean isRight) {
      this.isRight = isRight;
   }

   public boolean isLeft() {
      return isLeft;
   }

   public void setLeft(boolean isLeft) {
      this.isLeft = isLeft;
   }

   public Player() {
      initObject();
      initSetting();
   }

   private void initObject() {
      playerR = new ImageIcon("image/playerR.png");
      playerL = new ImageIcon("image/playerL.png");
   }

   // �����ڿ��� �ʱ�ȭ, �����ڿ��� ȣ��Ǿ������ϱ� �굵 ������ !
   private void initSetting() {
      x = 70;
      y = 535;
      setIcon(playerR);
      setSize(50, 50);
      setLocation(x, y); // paintComponent ȣ������, �κ� ���ΰ�ħ

      isRight = false;
      isLeft = false;
      isJump = false;
   }

   // �ϳ��� ���� å���� ���� �޼���, �޼��� ���
   public void right() {
      isRight = true;

      System.out.println("������ �̵�");

      setIcon(playerR);

      new Thread(() -> {
         while (isRight) {
            x = x + SPEED;
            setLocation(x, y);
            try {
               Thread.sleep(10);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      }).start();

   }

   // �ܺο��� ȣ�� �����ϰ�
   public void left() {
      isLeft = true;

      System.out.println("���� �̵�");

      setIcon(playerL);

      new Thread(() -> {
         while (isLeft) {
            x = x - SPEED;
            setLocation(x, y);
            try {
               Thread.sleep(10);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      }).start();

   }

   // Ű���� ������Ű
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