package ua.external.lab.registrarion;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.external.lab.mvc.AdminController;
import ua.external.lab.mvc.CheckInput;
import ua.external.lab.mvc.UserController;
import ua.external.lab.mvc.ViewBattleDroid;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static ua.external.lab.mvc.ViewBattleDroid.print;

public class MenuController implements CheckInput {
    ViewBattleDroid viewGameProcess;
    AdminController adminController;
    UserController userController;
    Profile profile ;
    String registrationLogin;
    String registrationPassword;

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Logger logger1 = LogManager.getLogger(MenuController.class);

    public MenuController(ViewBattleDroid viewGameProcess, AdminController adminController, UserController userController) {
        this.viewGameProcess = viewGameProcess;
        this.userController = userController;
        this.adminController = adminController;
    }

    public void registrationOrAuthentication() throws IOException {
        print(ViewBattleDroid.CHOSE_LANGUAGE);
        viewGameProcess.viewLanguage(CheckInput.checkInput(br));
        viewGameProcess.printMessageBundle(ViewBattleDroid.SIGN_IN_OR_REGISTRATION);
        if((CheckInput.checkInput(br))==1) {
            do{
                profile = authentication();
            }
            while(profile==null);
            if (profile.getRole().equals("Admin")) {
                if (adminController.processAdmin()) {
                    registrationOrAuthentication();
                }
            }else {
                if (userController.processUser()) ;
                registrationOrAuthentication();
            }
        }else {
            viewGameProcess.printMessageBundle(ViewBattleDroid.PROFILE);
            String registrationRole = chooseProfile(CheckInput.checkInput(br));
            while(!registrationLogin(br));
            while(!registrationPassword(br));
            Helper.writeToFile(registrationRole,registrationLogin,registrationPassword);
            viewGameProcess.printMessageBundle(ViewBattleDroid.SUCCESSFUL);
            registrationOrAuthentication();
        }
    }

    private boolean registrationLogin (BufferedReader br) throws IOException {
        String text;
            viewGameProcess.printMessageBundle(ViewBattleDroid.CREATE_LOGIN);
            text = inputString(br);
            if (text.matches("^[A-Za-z0-9]{6,8}$")) {
                if (Helper.checkLogin(text)) {
                    registrationLogin = text;
                    return true;
                }else {
                    viewGameProcess.printMessageBundle(ViewBattleDroid.LOGIN_EXIST);
                    logger1.info("login already exist");
                }
            } else {
                viewGameProcess.printMessageBundle(ViewBattleDroid.WRONG_INPUT);
                logger1.info("login does not match regex");
            }
        return false;
    }

    private boolean registrationPassword (BufferedReader br) throws IOException {
        String text;
            viewGameProcess.printMessageBundle(ViewBattleDroid.CREATE_PASSWORD);
            text = inputString(br);
            if (text.matches("^[\\w]{6,}[\\d]{2,}$")) {
                registrationPassword = text;
                return true;
            } else {
                logger1.info("password does not match regex");
                viewGameProcess.printMessageBundle(ViewBattleDroid.WRONG_INPUT);
            }
        return false;
    }
    public Profile authentication (){
        String role;
        String login;
        String password;
        viewGameProcess.printMessageBundle(ViewBattleDroid.PROFILE);
        role = chooseProfile(CheckInput.checkInput(br));
        viewGameProcess.printMessageBundle(ViewBattleDroid.LOGIN);
        login = inputString(br);
        viewGameProcess.printMessageBundle(ViewBattleDroid.PASSWORD);
        password = inputString(br);
        if(Helper.checkUser(new String[]{role, login, password})){
            return new Profile(role, login, password);
        }else{
            viewGameProcess.printMessageBundle(ViewBattleDroid.WRONG_AUTHENTICATION);
            logger1.info("Wrong login or password");
        }
        return null;
    }

    public String chooseProfile(int i){
        if(i==1){
            return "User";
        }else{
            return "Admin";
        }
    }

    private String inputString (BufferedReader br){
        try {
            return (br.readLine());
        } catch (IOException e) {
            viewGameProcess.printMessageBundle(viewGameProcess.WRONG_INPUT);
            logger1.info("wrong input authorization", e);
        }
     return null;
    }
}
