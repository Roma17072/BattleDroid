package ua.external.lab.mvc;

import ua.external.lab.registrarion.MenuController;
import ua.external.lab.weaponAndAmmunition.WeaponAndAmmunition;

import java.io.IOException;

public class BattleDroid {
    public static void main(String[] args) throws IOException {
        ViewBattleDroid viewGameProcess = new ViewBattleDroid();
        BattleDroidModel modelImplementation = new BattleDroidModel();
        WeaponAndAmmunition weaponAndAmmunition = new WeaponAndAmmunition();
        UserController userController = new UserController(viewGameProcess, modelImplementation);
        AdminController adminController = new AdminController(viewGameProcess, modelImplementation, weaponAndAmmunition);
        MenuController menuController = new MenuController(viewGameProcess, adminController, userController);
        menuController.registrationOrAuthentication();
    }
}




