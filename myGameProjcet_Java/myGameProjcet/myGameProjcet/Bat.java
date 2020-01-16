package myGameProjcet;

public class Bat extends Monster {

	private String name = "박쥐";
	private int dropMoney =5;
	private int HP=150;
	private String Attackname = "날개치기";
	private int Attacknum = 10;
	
	public String getAttackname() {
		return Attackname;
	}
	public void setAttackname(String attackname) {
		Attackname = attackname;
	}
	public int getAttacknum() {
		return Attacknum;
	}
	public void setAttacknum(int attacknum) {
		Attacknum = attacknum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDropMoney() {
		return dropMoney;
	}
	public void setDropMoney(int dropMoney) {
		this.dropMoney = dropMoney;
	}
	public int getHP() {
		return HP;
	}
	public void setHP(int hP) {
		HP = hP;
	}
	
	
	
	
}
