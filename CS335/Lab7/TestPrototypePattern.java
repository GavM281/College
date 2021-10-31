package Lab7;

public class TestPrototypePattern {

	public static void main(String[] args) {
		User arr[] = new User[10];
		int i = 0;
		
		AccessControl userAccessControl = AccessControlProvider.getAccessControlObject("USER");
		User user = new User("User A", "USER Level", userAccessControl);
		
		System.out.println("************************************");
		System.out.println(user);
		arr[i]=user;
		i++;
		
		userAccessControl = AccessControlProvider.getAccessControlObject("USER");
		user = new User("User B", "USER Level", userAccessControl);
		System.out.println("Changing access control of: "+user.getUserName());
		user.getAccessControl().setAccess("READ REPORTS");
		System.out.println(user);
		arr[i] = user;
		i++;
		
		System.out.println("************************************");
		
		AccessControl managerAccessControl = AccessControlProvider.getAccessControlObject("MANAGER");
		user = new User("User C", "MANAGER Level", managerAccessControl);
		System.out.println(user);
		arr[i] = user;
		i++;
		
		System.out.println("************************************");
		
		userAccessControl = AccessControlProvider.getAccessControlObject("SUPERUSER");
		user = new User("User D", "SUPERUSER Level", userAccessControl);
		System.out.println("Changing access control of: "+user.getUserName());
		user.getAccessControl().setAccess("ADD/REMOVE USERS, INSTALL/UNINSTALL APPLICATIONS");
//		System.out.println(user);
		arr[i] = user;
		for(int x = 0; x<=i;x++) {
			System.out.println(arr[x]);
		}
		i++;
	}
}
