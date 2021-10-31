package Lab7;

public class User {
	
	private String userName;
	private String level;
	private AccessControl accessControl;
	
//	public int t;
//	public String userList [][]= new String[6][3]; // create array
		
	public User(String userName,String level, AccessControl accessControl){
		this.userName = userName;
		this.level = level;
		this.accessControl = accessControl;

//		// Other non-working attempt
//		while(true) {
//			if(userList[t][0] ==null) { // If empty add info
//				System.out.println("user is  " + userList[t][0]);
//		    	userList[t][0] =userName;
//		    	userList[t][1] = level;  	
//		    	userList[t][2] = accessControl.getControlLevel();
//				t++;
//				System.out.println("t is  " + t);
//				break;
//			}else {
//				if(t<5) {
//					t++; // Increase column to check
//					System.out.println("t from else is  " + t);
//				}else {
//					break;
//				}
//			}
//		}
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public AccessControl getAccessControl() {
		return accessControl;
	}
	public void setAccessControl(AccessControl accessControl) {
		this.accessControl = accessControl;
	}
	
	@Override
	public String toString(){
//		if (this.getLevel().equals("SUPERUSER Level")) { // Is a superuser
//			for(int x = 0;x<6;x++) { // users
//				for(int y = 0;y<3;y++) { // info
//					if(userList[x][0] != null) { // If space not empty
//						System.out.print(userList[x][y] + "    "); // print info
//					}else {
//						break;
//					}
//				}
//				System.out.println();
//			}
//            return "Name: "+userName+", Level: "+level+", Access Control Level:"+accessControl.getControlLevel()+", Access: "+accessControl.getAccess();
//        } else {	
//            return "Name: "+userName+", Level: "+level+", Access Control Level:"+accessControl.getControlLevel()+", Access: "+accessControl.getAccess();
//        }
		return "Name: "+userName+", Level: "+level+", Access Control Level:"+accessControl.getControlLevel()+", Access: "+accessControl.getAccess();
	}
	
}
