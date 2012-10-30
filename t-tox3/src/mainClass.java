import java.util.ArrayList;
import java.util.Iterator;

import org.openscience.cdk.DefaultChemObjectBuilder;
import org.openscience.cdk.exception.InvalidSmilesException;
import org.openscience.cdk.interfaces.IAtom;
import org.openscience.cdk.interfaces.IBond;
import org.openscience.cdk.interfaces.IMolecule;
import org.openscience.cdk.smiles.SmilesParser;

import descriptorClasses.oqsarDescriptor;

public class mainClass {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// getting all atoms
		try {
			SmilesParser sp = new SmilesParser(
					DefaultChemObjectBuilder.getInstance());
			IMolecule m = sp.parseSmiles("c1ccccc1[Cu]");
			ArrayList<IAtom> atomList = new ArrayList<>();
			ArrayList<oqsarDescriptor> descList = new ArrayList<oqsarDescriptor>();
			ArrayList<IBond> bondList = new ArrayList<IBond>();

			for (int i = 0; i < m.getAtomCount(); i++) {
				boolean contains = false;
				for (IAtom iAtom : atomList) {
					if (iAtom.getSymbol() == m.getAtom(i).getSymbol()) {

						contains = true;
						break;
					}
				}
				if (!contains) {
					atomList.add(m.getAtom(i));
				}

				// System.out.println(m.getAtom(i).toString());
			}

			System.out.println(atomList.size());

			// get all descriptors
			ArrayList<String> bondList2 = new ArrayList<String>();
			bondList2.add("-");
			bondList2.add("=");
			bondList2.add("#");

			for (int i = 0; i < m.getBondCount(); i++) {
				bondList.add(m.getBond(i));
			}

			for (IBond bond : bondList) {
				boolean contains = false;
				for (oqsarDescriptor de : descList) {
					if (((de.getAtom1().getSymbol() == bond.getAtom(0)
							.getSymbol() & de.getAtom2().getSymbol() == bond
							.getAtom(1).getSymbol()) | (de.getAtom2()
							.getSymbol() == bond.getAtom(0).getSymbol() & de
							.getAtom1().getSymbol() == bond.getAtom(1)
							.getSymbol()))
							& bond.getOrder().name()==de.getBond()) {
						contains = true;
						de.setQuantity(de.getQuantity()+1);
					}
				}
				if (!contains) {
					oqsarDescriptor deNew = new oqsarDescriptor();
					deNew.setAtom1(bond.getAtom(0));
					deNew.setAtom2(bond.getAtom(1));
					deNew.setBond(bond.getOrder().name());
					descList.add(deNew);
				}
								// descList.add(e)
				// bond.getAtom(0).getSymbol()
				// bond.getOrder().name()
			}
			int y = 0;
			// for (int i = 0; i < atomList.size(); i++) {
			// for (int j = i; j < atomList.size(); j++) {
			// for (int j2 = 0; j2 < 3; j2++) {
			// String descr = atomList.get(i).getSymbol()
			// + bondList2.get(j2)
			// + atomList.get(j).getSymbol();
			// descList.add(descr);
			// System.out.println(descr);
			//
			// }
			//
			// }
			// }
		} catch (InvalidSmilesException ise) {
		}

	}
}
