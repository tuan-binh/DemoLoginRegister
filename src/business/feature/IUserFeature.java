package business.feature;

import business.entity.Users;

public interface IUserFeature {
	
	void register(String fullName, String email, String password);
	
	Users login(String email, String password);
	
}
