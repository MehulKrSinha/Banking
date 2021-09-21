import com.lti.Address;
import com.lti.PanCard;
import com.lti.SavingsAccount;
import com.lti.designpattern.basedao.BaseDAOImpl;
import org.junit.jupiter.api.Test;

public class SavingsAccountsPanCardTest {

	BaseDAOImpl baseDAO = new BaseDAOImpl();

	@Test
	void addSavingsAccountWithPanCard() {
		SavingsAccount savObj = new SavingsAccount();
		savObj.setAccountNumber(444);
		savObj.setAccountHolderName("JOBY");
		savObj.setAccountBalance(4444);
		
		PanCard panCardObj = new PanCard();
		panCardObj.setPanNumber("APIRE3456P");
		panCardObj.setIssuedBy("Govt. Of. India");
		
		savObj.setPanCard(panCardObj);
		
		baseDAO.persist(savObj);
		
	}
	
	@Test
	void addSavingsAccountWithAddressAndPanCard() {
		
		SavingsAccount savObj = new SavingsAccount();
		savObj.setAccountNumber(333);
		savObj.setAccountHolderName("JIMMY");
		savObj.setAccountBalance(3333);
		
		PanCard panCardObj = new PanCard();
		panCardObj.setPanNumber("JUYTR55");
		panCardObj.setIssuedBy("Govt. Of. India");
		
		Address addrObj = new Address();
		addrObj.setArea("Sweet Home");
		addrObj.setStreet("West");
		addrObj.setCity("Pune");
		addrObj.setState("Mahatra");
		addrObj.setCountry("India");
		addrObj.setZip("123123");
		
		savObj.setHomeAddress(addrObj); //hasA
		savObj.setPanCard(panCardObj); //hasA
		
		baseDAO.persist(savObj);
		
	}
	
}
