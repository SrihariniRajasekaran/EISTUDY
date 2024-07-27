package cdp1;

public class login {
        private static login instance;
        private login(){}
        public static synchronized login getInstance() {
           if (instance == null) {
                instance = new login();
            }
            return instance;
    
        }
        public void logs(String message) {
            System.out.println("Login Status: " + message);
        }
    
    }


