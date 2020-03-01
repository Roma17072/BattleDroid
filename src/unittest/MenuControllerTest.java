package unittest;

import org.junit.Assert;
import org.junit.Test;
import ua.external.lab.mvc.AdminController;
import ua.external.lab.mvc.UserController;
import ua.external.lab.mvc.ViewBattleDroid;
import ua.external.lab.registrarion.Helper;
import ua.external.lab.registrarion.MenuController;

public class MenuControllerTest {
    ViewBattleDroid viewGameProcess;
    Helper modelMenu;
    AdminController adminController;
    UserController userController;
    MenuController menuController = new MenuController(viewGameProcess, modelMenu, adminController, userController);

    @Test
    public void registrationOrAuthorization() {

    }

    @Test
    public void chooseProfile() {
        String expected ="User";
        menuController.chooseProfile(1);
        String actual = menuController.getProfile();
        Assert.assertEquals(expected,actual);
    }
}