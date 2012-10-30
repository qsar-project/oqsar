package descriptorClasses;

import org.openscience.cdk.interfaces.IAtom;

public class oqsarDescriptor {
	private IAtom atom1;
	private IAtom atom2;
	private String bond;
	private int quantity = 0;
	public IAtom getAtom1() {
		return atom1;
	}
	public void setAtom1(IAtom atom1) {
		this.atom1 = atom1;
	}
	public IAtom getAtom2() {
		return atom2;
	}
	public void setAtom2(IAtom atom2) {
		this.atom2 = atom2;
	}
	public String getBond() {
		return bond;
	}
	public void setBond(String bond) {
		this.bond = bond;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
