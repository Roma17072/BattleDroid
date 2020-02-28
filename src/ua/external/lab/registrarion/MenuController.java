package ua.external.lab.registrarion;

import ua.external.lab.droids.AdminController;
import ua.external.lab.droids.CheckInput;
import ua.external.lab.droids.UserController;
import ua.external.lab.droids.ViewBattleDroid;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static ua.external.lab.droids.ViewBattleDroid.print;
import static ua.external.lab.droids.ViewConstant.WRONG_LOGIN;
import static ua.external.lab.droids.ViewConstant.WRONG_PASSWORD;

public class MenuController implements CheckInput {
    ViewBattleDroid viewGameProcess;
    Helper helper;
    AdminController adminController;
    UserController userController;
    private String profile;
    private String login;
    private String password;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public MenuController(ViewBattleDroid viewGameProcess, Helper modelMenu, AdminController adminController, UserController userController) {
        this.viewGameProcess = viewGameProcess;
        this.helper = modelMenu;
        this.userController = userController;
        this.adminController = adminController;
    }

    public String getProfile() {
        return profile;
    }

    public void registrationOrAuthorization() throws IOException {
        print(ViewBattleDroid.CHOSE_LANGUAGE);
        viewGameProcess.viewLanguage(CheckInput.checkInput(br));
        viewGameProcess.printMessage(ViewBattleDroid.PROFILE);
        chooseProfile(CheckInput.checkInput(br));
        viewGameProcess.printMessage(ViewBattleDroid.SIGN_IN_OR_REGISTRATION);
        if(signInOrRegistration(CheckInput.checkInput(br))=="Admin"){
            if(adminController.processAdmin()){
                registrationOrAuthorization();
            }
        }else{
            if(userController.processUser());
            registrationOrAuthorization();
        }
    }

    private String signInOrRegistration(int i) throws IOException {
        if(i==1){
            String [] user;
            do {
                viewGameProcess.printMessage(ViewBattleDroid.LOGIN);
                login = inputString(br);
                viewGameProcess.printMessage(ViewBattleDroid.PASSWORD);
                password = inputString(br);
            }while(!helper.checkUser(user= new String[]{profile, login, password}));
        }else {
            while(!registrationLogin(br)){
                viewGameProcess.printMessage(WRONG_LOGIN);
            }
            while(!registrationPassword(br)){
                viewGameProcess.printMessage(WRONG_PASSWORD);
            }
            helper.writeToFile(profile,login,password);
            viewGameProcess.printMessage(ViewBattleDroid.SUCCESSFUL);
            signInOrRegistration(1);
        }
        return profile;
    }

    private boolean registrationLogin (BufferedReader br) throws IOException {
        String text;
            viewGameProcess.printMessage(ViewBattleDroid.CREATE_LOGIN);
            text = inputString(br);
            if (text.matches("^[A-Za-z0-9]{6,8}$")) {
                if (helper.checkLogin(text,1)) {
                    login = text;
                    return true;
                }else {
                    viewGameProcess.printMessage(ViewBattleDroid.LOGIN_EXIST);
                }
            } else {
                viewGameProcess.printMessage(ViewBattleDroid.WRONG_INPUT);
            }
        return false;
    }

    private boolean registrationPassword (BufferedReader br) throws IOException {
        String text;
            viewGameProcess.printMessage(ViewBattleDroid.CREATE_PASSWORD);
            text = inputString(br);
            if (text.matches("^[\\w]{6,}[\\d]{2,}$")) {
                password = text;
                return true;
            } else {
                viewGameProcess.printMessage(ViewBattleDroid.WRONG_INPUT);
                viewGameProcess.printMessage(ViewBattleDroid.CREATE_PASSWORD);
            }
        return false;
    }

    public void chooseProfile(int i){
        if(i==1){
            profile = "User";
        }else{
            profile = "Admin";
        }
    }

    private String inputString (BufferedReader br){
        try {
            return (br.readLine());
        } catch (IOException e) {
            viewGameProcess.printMessage(viewGameProcess.WRONG_INPUT);
        }
     return null;
    }
}
